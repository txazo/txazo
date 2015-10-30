# tomcat-sourcecode
## 构建Tomcat源码过程
### 1. 下载二进制包
<pre><code>wget http://mirrors.hust.edu.cn/apache/tomcat/tomcat-7/v7.0.65/bin/apache-tomcat-7.0.65.tar.gz
tar -zxvf apache-tomcat-7.0.65.tar.gz
rm -f apache-tomcat-7.0.65.tar.gz
mv apache-tomcat-7.0.65 tomcat-7.0.65-catalina
</code></pre>
### 2. 下载源代码
<pre><code>svn co http://svn.apache.org/repos/asf/tomcat/tc7.0.x/tags/TOMCAT_7_0_65 tomcat-7.0.65-sourcecode
</code></pre>
### 3. 添加pom.xml
<pre><code>touch pom.xml
touch tomcat-7.0.65-sourcecode/pom.xml
</code></pre>
### 4. 配置Run Configurations
Main class:
<pre><code>org.apache.catalina.startup.Bootstrap
</code></pre>
VM options:
<pre><code>-Dcatalina.home=tomcat-7.0.65-catalina
-Dcatalina.base=tomcat-7.0.65-catalina
-Djava.endorsed.dirs=tomcat-7.0.65-catalina/endorsed
-Djava.io.tmpdir=tomcat-7.0.65-catalina/temp
-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager
-Djava.util.logging.config.file=tomcat-7.0.65-catalina/conf/logging.properties
</code></pre>
Working directory:
<pre><code>${tomcat-sourcecode-home}
</code></pre>
Use classpath of module:
<pre><code>tomcat7-sourcecode
</code></pre>