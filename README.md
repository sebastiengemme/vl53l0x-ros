ROS Driver for the VL53L0X TOF Range Finder
===================

This ROS driver interfaces with the VL53L0X, it is meant to run on the Rasbperry Pi. The driver produces standard `sensor_msgs/Range` messages.

Launch the node (make sure you have a `roscore` running):

    rosrun vl53l0x vl53l0x_node

To start ranging:

    rosservice call /vl53l0x/start_ranging mode

Where `mode` takes one of the folling values:

    Good Accuracy Mode: 0
    Better Accuracy Mode: 1
    Best Accuracy Mode: 2
    Long Range Mode: 3
    High Speed Mode: 4

It will then start producing standard `sensor_msgs/Range` messages on a topic called `/vl53l0x/range`. The range is in meters while the field of view is expressed in radians, in line with [ROS REP 103](http://www.ros.org/reps/rep-0103.html).

To stop ranging:

    rosservice call /vl53l0x/stop_ranging

There is also the possibilty to automatically start the ROS driver:

    rosrun vl53l0x vl53l0x_node _autostart:=true _mode=1

would automatically start the node in *Better Accuracy Mode*.

The frame id is also customizable by specifying a `frame_id` parameter.

The i2c bus address of the sensor can be changed by specifying the following ROS parameters:

    address: an address (looks like we can only express it in base 10)
    xshut_gpio: the GPIO number (not the pin number) connected to the xshut pin of the vl53l0x

## Prerequisites
The only prerequisite is the [VL53L0X Python API on Raspberry Pi](https://github.com/johnbryanmoore/VL53L0X_rasp_python) from Mr. Bryan Moore.

## Catkin Build
If using catkin, create a catkin repo:
 mkdir -p ~/catkin_ws_vl530l/src
 cd ~/catkin_ws_vl530l/src
 catkin_init_workspace
 
Copy the repo info ```~/catkin_ws_vl530l/src```

Build the repo:
 cd ~/catkin_ws_vl530l
 catkin_make

## Openembedded Recipe
This pakage also comes with an Openembedded recipe located in the openembedded folter
