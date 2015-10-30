#!/bin/bash

function init() {
    mirror="http://www.eu.apache.org/dist";
    tomcatVersion="8";
    subVersion="28";
    version="${tomcatVersion}.0.${subVersion}";

    rm -rf tomcat-${version}-catalina
    rm -rf tomcat-${version}-sourcecode
}

function downloadBinary() {
    wget "${mirror}/tomcat/tomcat-${tomcatVersion}/v${version}/bin/apache-tomcat-${version}.tar.gz"
    tar -zxvf apache-tomcat-${version}.tar.gz
    rm -f apache-tomcat-${version}.tar.gz
    mv apache-tomcat-${version} tomcat-${version}-catalina
}

function downloadSourceCode() {
    mkdir tomcat-${version}-sourcecode
    cd tomcat-${version}-sourcecode
    svn co "http://svn.apache.org/repos/asf/tomcat/tc${tomcatVersion}.0.x/tags/TOMCAT_${tomcatVersion}_0_${subVersion}/java" java
    rm -rf tomcat-${version}-sourcecode/.svn
}

function main() {
    init
    downloadBinary
    #downloadSourceCode
}

main

