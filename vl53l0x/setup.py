from setuptools import find_packages
from setuptools import setup

setup(
    name='vl53l0x',
    packages=find_packages(),
    install_requires=['setuptools'],
    py_modules=['vl53l0x_node'],
    zip_safe=True,
    author='Sebastien Gemme',
    author_email='sgemme@protonmail.com',
    entry_points = {
        'console_scripts': [
            'vl53l0x_node = vl53l0x_node:main'
        ]
    }
)
