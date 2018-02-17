cmake_minimum_required(VERSION 2.8.3)
project(vl53l0x_msgs)

find_package(catkin REQUIRED COMPONENTS
  sensor_msgs
  message_generation
)

## Generate messages in the 'msg' folder
# add_message_files(
#   FILES
#   Message1.msg
#   Message2.msg
# )

## Generate services in the 'srv' folder
add_service_files(
   DIRECTORY srv
   FILES
   StartRanging.srv
)

## Generate actions in the 'action' folder
# add_action_files(
#   FILES
#   Action1.action
#   Action2.action
# )

## Generate added messages and services with any dependencies listed here
generate_messages(
   DEPENDENCIES
   sensor_msgs
)

catkin_package(
#  INCLUDE_DIRS include
#  LIBRARIES vl53l0x_msgs
#  CATKIN_DEPENDS sensor_msgs
#  DEPENDS system_lib
)
