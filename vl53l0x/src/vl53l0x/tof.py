'''
Created on Feb 17, 2018

@author: seb
'''
from __future__ import division

import rospy
from vl53l0x_msgs.srv._StartRanging import StartRanging, StartRangingResponse
from std_srvs.srv._Trigger import Trigger, TriggerResponse
import VL53L0X
from sensor_msgs.msg._Range import Range
import math


class VL53L0x(object):

    def __init__(self):
        '''
        Constructor
        '''
        rospy.init_node("vl53l0x")
        
        self.__tof = VL53L0X.VL53L0X()
        
        # Advertise services
        self.__initServices()
        
        self.__initTopics()
        
        self.__isRanging = False
        
        self.__rangingThread = None
        
    def __initServices(self):
        self.__startRangingSrv = rospy.Service("~start_ranging", StartRanging, self.__startRanging)
        self.__stopRangingSrv = rospy.Service("~stop_ranging", Trigger, self.__stopRanging)
        
    def __initTopics(self):
        self.__rangePub = rospy.Publisher("~range", Range, queue_size=10)
        
    def __startRanging(self, req):
        
        res = StartRangingResponse()
        
        if not self.__isRanging:
            self.__tof.start_ranging(req.mode)        
            self.__isRanging = True
            res.success = True
            
            # Get the timing information in order to determine how fast
            # we need to poll the tof, timing is in micro seconds
            timing = self.__tof.get_timing()
            if (timing < 20000):
                timing = 20000
            
            period = rospy.Duration(timing / 1e+6)
            rospy.loginfo("Polling at " + repr(period.nsecs/1e+9) + "s")
            
            self.__rangingThread = rospy.Timer(period, self.__readRange)
            
        else:
            res.success = False
            res.message = "Already Ranging"
        
        return res;
    
    def __readRange(self, evt):
        
        reading = Range()
        
        reading.header.frame_id = "range_finder"
        reading.header.stamp = rospy.Time.now()
        
        reading.radiation_type = Range.INFRARED
        reading.field_of_view = math.radians(25.0)
        
        reading.min_range = rospy.get_param("~min_range",0.005)
        reading.max_range = rospy.get_param("~max_range",2.0)
        
        range.range = self.__tof.get_distance() / 1000.0
        
        self.__rangePub.publish(range)
        
    def __stopRanging(self, req):
        
        res = TriggerResponse()
        
        if self.__isRanging:
            self.__tof.stop_ranging()
            res.success = True
            self.__isRanging = False
            self.__rangingThread.shutdown()
        else:
            res.success = False
            res.message = "Not Ranging"
        
        return res
