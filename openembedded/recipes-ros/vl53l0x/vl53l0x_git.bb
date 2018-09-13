require vl53l0x.inc

S = "${WORKDIR}/git/vl53l0x"

inherit catkin

SUMMARY = "ROS package vl53l0x"
DESCRIPTION = "The vl53l0x package"
SECTION = "devel"
DEPENDS = "sensor-msgs vl53l0x-msgs"
DEPENDS += "rospy"
RDEPENDS_${PN} = "sensor-msgs"
RDEPENDS_${PN} += "rospy"
RDEPENDS_${PN} += "vl53l0x-msgs"
RDEPENDS_${PN} += "vl53l0x-rasp-python"

CONFFILES_${PN} += "${ros_datadir}/${ROS_BPN}/vl53l0x.launch "
