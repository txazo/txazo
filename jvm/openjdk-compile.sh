#!/bin/bash
#
# GNU Make 3.81
# Xcode
# JDK 7
# XQuartz(X11)
#
# ln -s /usr/X11/include/X11 /usr/include/X11
#

export LANG=C

unset JAVA_HOME

bash ./configure

make all
