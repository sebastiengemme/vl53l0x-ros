cmake_minimum_required(VERSION 2.8.3)
project(vl53l0x)

find_package(catkin REQUIRED COMPONENTS
  rospy
  sensor_msgs
  vl53l0x_msgs
)

catkin_python_setup()

catkin_package()

install(PROGRAMS
   scripts/vl53l0x_node
   DESTINATION ${CATKIN_PACKAGE_BIN_DESTINATION}
)

## Mark other files for installation (e.g. launch and bag files, etc.)
install(FILES
   launch/vl53l0x.launchvl53l0x.launch
   DESTINATION ${CATKIN_PACKAGE_SHARE_DESTINATION}
)
