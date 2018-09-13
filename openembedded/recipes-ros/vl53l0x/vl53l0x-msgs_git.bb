require vl53l0x.inc

S = "${WORKDIR}/git/vl53l0x_msgs"

inherit catkin

# This is a Catkin (ROS) based recipe
# ROS package.xml format version 2

SUMMARY = "ROS package vl53l0x_msgs"
DESCRIPTION = "The vl53l0x_msgs package"
# ROS_MAINTAINER = "seb <seb@todo.todo>"
SECTION = "devel"
DEPENDS += "sensor-msgs"
RDEPENDS_${PN} += "sensor-msgs"

ROS_SPN = "vl53l0x_msgs"
