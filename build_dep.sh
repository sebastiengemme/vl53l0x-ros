#!/bin/bash

echo "Building ..."
git clone https://github.com/johnbryanmoore/VL53L0X_rasp_python.git
cd VL53L0X_rasp_python
patch -p 1  < $(find ../ -name \*patch)
make

echo "Instlaling ..."
# Copy the python library to the site-packages directory
sudo install -m 0755 python/VL53L0X.py $(python -c 'import site; print(site.getsitepackages()[0])')

# Copy the so to /usr/lib
sudo install -m 0755 bin/*.so /usr/lib

cd -
