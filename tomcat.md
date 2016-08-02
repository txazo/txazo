构建Tomcat源码过程
1. 下载二进制包

wget http://mirrors.hust.edu.cn/apache/tomcat/tomcat-7/v7.0.65/bin/apache-tomcat-7.0.65.tar.gz
tar -zxvf apache-tomcat-7.0.65.tar.gz
rm -f apache-tomcat-7.0.65.tar.gz
mv apache-tomcat-7.0.65 tomcat-7.0.65-catalina

2. 下载源代码

svn co http://svn.apache.org/repos/asf/tomcat/tc7.0.x/tags/TOMCAT_7_0_65 tomcat-7.0.65-sourcecode

3. 添加pom.xml

touch pom.xml
touch tomcat-7.0.65-sourcecode/pom.xml

4. 配置Run Configurations

Main class:

org.apache.catalina.startup.Bootstrap

VM options:

-Dcatalina.home=tomcat-7.0.65-catalina
-Dcatalina.base=tomcat-7.0.65-catalina
-Djava.endorsed.dirs=tomcat-7.0.65-catalina/endorsed
-Djava.io.tmpdir=tomcat-7.0.65-catalina/temp
-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager
-Djava.util.logging.config.file=tomcat-7.0.65-catalina/conf/logging.properties

Working directory:

${tomcat-sourcecode-home}

Use classpath of module:

tomcat7-sourcecode
