#!/bin/bash

pid='0'`ps -ef | grep tomcat | grep org.apache.catalina.startup.Bootstrap | awk '{print $2}'`
[ $pid -ne 0 ] && kill -9 $pid

sudo /usr/local/tomcat/bin/startup.sh