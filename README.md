VL53L0X ROS Driver
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

It will then start producing standard `sensor_msgs/Range` messages on a topic called `/vl53l0x/range`. 

To stop ranging:

    rosservice call /vl53l0x/stop_ranging

There is also the possibilty to automatically start the ROS driver (still TBD):

    rosrun vl53l0x vl53l0x_node _autostart:=true _mode=1

would automatically start the node in *Better Accuracy Mode*.

The frame id is also customizable by specifying a `frame_id` parameter.

## Prerequisites
The only prerequisite is the [VL53L0X Python API on Raspberry Pi](https://github.com/johnbryanmoore/VL53L0X_rasp_python) from Mr. Bryan Moore.

## TODO
Features that will be supported in the future.

* Add support for configurable address, this will enable having multiple TOF sensors on the same i2c bus.
* Implement an automatic start feature so it can start producing range readings at startup.
* Add configurable frame id.
