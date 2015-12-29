## JVM

#### class文件结构

#### 类加载机制

	启动类加载器、扩展类加载器、应用程序类加载器
	双亲委派机制

#### jvm内存模型

	程序计数器: 线程私有
	Java虚拟机栈: 线程私有, 栈帧(局部变量表、操作数栈、动态链接、方法出口), OutOfMemoryError、StackOverflowError
	本地方法栈: Native方法
	Java堆: 线程共享, 分配对象, 新生代(Eden、From Survivor、To Survivor)、老年代、永久代, OutOfMemoryError
	方法区: 线程共享, 永久代, 存储虚拟机加载的类信息、常量、静态变量, OutOfMemoryError
	运行时常量池: 线程共享, OutOfMemoryError
	直接内存: OutOfMemoryError

#### 垃圾回收

	垃圾回收算法: 标记清除算法、复制算法、标记整理算法、分代收集算法
	垃圾收集器: Serial收集器、ParNew收集器、Parallel Scavenge收集器、Serial Old收集器、Parallel Old收集器、CMS收集器、G1收集器

#### jvm参数

	-Xms、-Xmx

#### 内存溢出

	堆内存溢出
	栈内存溢出
	StackOverFlow
	方法区内存溢出
	常量池内存溢出
	直接内存溢出

#### jvm调优

	响应很慢
	频繁Full GC, 垃圾回收日志
	发生OutOfMemory


#### jdk工具

	jps
	jstack
	jmap
	jconsole
	javap

## CPU

	CPU寄存器 > L1 > L2 > L3 > 跨槽 > 内存 > 磁盘
	L1 Cache: L1 Data Cache、L2 Instruction Cache
	L2 Cache
	L3 Cache
	Cache Line: 缓存行, 64个字节, CPU最小操作单位
		1) Cache Miss: 缓存未命中, 按照数据的物理顺序访问数据(二维long数组)
		2) Cache冲突: 避免缓存行冲突, 补齐缓存行, 伪共享
		3) Cache满: 减少操作的数据大小

## Linux

	linux
	shell

## Java

#### Java基础

	克隆: Cloneable
	比较: Comparable、Comparator
	迭代器: Iterable
	类加载: ClassLoader、URLClassLoader
	枚举: Enum
	基本数据类型包装类: Integer、Double
	对象: Object
	字符串: String、StringBuffer、StringBuilder
	异常: Throwable、Exception、Error、RuntimeException

#### 位操作

	<<、>>、>>>、&、|、^、~

#### IO

	文件流: 磁盘
	Socket流: 网络
	字节/字符数组流: 内存
	缓冲流: 缓冲区, 装饰器模式
	对象流: 对象, 装饰器模式, 序列化/反序列化
	基本数据类型流: 基本数据类型, 装饰器模式

	编码: ASCII、ISO-8859-1、GB2312、GBK、UTF-8、UTF-16

#### 序列化/反序列化
	单例、枚举
	性能: 序列化时间、反系列化时间、序列化大小、序列化压缩大小、序列化格式
	fastjson、protobuf

#### NIO

	IO: 单向、阻塞、流
	NIO: 双向、非阻塞、通道、缓冲区

	Channel: 通道
	Buffer: 缓冲区
	Selector: 选择器

	Reactor模式

	同步: 串行执行
    异步: 并行执行
    阻塞: 一直等待, 直到条件满足
    非阻塞: 不会等待, 直接返回标志信息

    IO: 检查数据是否就绪、数据拷贝(内核拷贝到用户线程)

    阻塞IO: 用户线程一直等待直到数据就绪
    非阻塞IO: 数据未就绪, 直接返回标志信息给用户线程
    同步IO: 用户线程将数据从内核拷贝到用户线程
    异步IO: 内核将数据从内核拷贝到用户线程, 然后发送消息通知用户线程

	阻塞IO模型: 用户线程等待数据就绪, 然后将数据从内核拷贝到用户线程
	非阻塞IO模型: 用户线程不断轮询数据是否就绪, 数据就绪后, 用户线程将数据从内核拷贝到用户线程
	多路复用IO模型(NIO): 一个线程管理多个socket, 不断轮询socket状态, socket就绪后, 用户线程将数据从内核拷贝到用户线程
	信号驱动IO模型: 内核等待数据就绪, 数据就绪后发送信号通知用户线程
	异步IO模型: 内核等待数据就绪, 数据就绪后, 内核拷贝数据到用户线程, 然后发送信号通知用户线程

	多线程IO模式: 一个连接一个线程
	线程池IO模式: 多个连接重用线程池中的线程
	Reactor模式(多路复用IO模型): 注册事件、轮询事件、分发事件
	Proactor模式(异步IO模型): 注册事件、轮询事件、异步IO(内核拷贝数据到用户线程)、分发事件

#### 反射

	javassist: 运行时分析、编辑、创建字节码
	应用: Spring IOC、动态代理

#### 动态代理

	InvocationHandler: 代理接口
	CGlib: 代理接口或类
	asm
	javassist
	<http://blog.csdn.net/luanlouis/article/details/24589193>

#### 注解

#### 语法糖

	断言
	自动拆箱装箱
	枚举
	增强for循环
	泛型: 类型擦除(编译期), 强制类型转换
	条件编译
	内部类
	switch字符串: 先hashcode(), 后equals()
	try-with-resources
	可变长参数: 数组

#### 集合
* List：ArrayList、LinkedList、Vector、Stack
* Set：HashSet、TreeSet
* Map：HashMap、TreeMap
* Queue
* 迭代器：Iterator、Enumeration

#### 多线程

#### 网络编程

	DNS: 搭建DNS服务器
	CDN
	网络协议: TCP/IP、HTTP、SSL
	Socket
	URL
	HttpURLConnection
	简单的HTTP服务器: 线程池、NIO、Reactor模式、状态码
	nginx、apache: 特性、搭建、配置
	FTP、SMTP: Java实现

***

## 设计模式
#### 创建型模式(6)

	简单工厂模式: 一个工厂, 创建多个产品
	工厂方法模式: 多个工厂, 一个工厂创建一个产品
	抽象工厂模式: 多个工厂, 一个工厂创建一个产品簇
	单例模式: 控制一个类只有一个实例, 懒汉, 饿汉, 枚举, 静态内部类, 双重检查锁
	原型模式: 对象拷贝, 浅复制, 深复制
	建造者模式: 分离对象的构建和表示(Director -> Builder -> Product)

#### 结构型模式(7)

	适配器模式: 接口转换
	桥接模式: 多维度变化时, 分离抽象部分与实现部分
	组合模式: 创建整体部分的树形层次结构
	装饰器模式: 接口不变, 扩展对象的功能
	门面模式: 为子系统提供一个高层次的接口
	享元模式: 运用共享技术有效地支持大量细粒度的对象
	代理模式: 为对象提供一个代理对象, 控制对原对象的访问

#### 行为型模式(11)

	职责链模式: 对象组成链, 请求沿链传递, 链表实现、数组实现
	命令模式: 解耦请求方和实现方, 请求方 -> 命令 -> 实现方
	解释器模式: 定义一种文法和一个解释器用来解释该文法
	迭代器模式: 元素遍历
	中介者模式: 封装一系列的对象交互, 解耦, 对象 <> 中介对象 <> 对象
	备忘录模式: 保存和恢复对象的内部状态
	观察者模式: 多个观察者监听一个主题, 主题状态变化时, 通知所有观察者
	状态模式: 状态改变时改变行为
	策略模式: 定义一组算法, 可以相互替换
	模板方法模式: 固定算法骨架, 延迟子类实现
	访问者模式: 固定数据结构中元素, 访问者的实现可变

#### MVC

	模型
	视图
	控制器

#### AOP(面向切面编程)

	面向切面编程
	实现: 动态代理

#### NIO和Reactor模式

	NIO
	Reactor模式

***

## 开源框架(原理和机制)

	Struts2: 源码
	Spring、Spring MVC: 源码

#### MyBatis

	sql配置化
	动态sql
	事务处理
	缓存: 一级缓存、二级缓存
	连接池
	结果集包装
	源码: 

## 应用服务器

	tomcat

## MySQL

	MySQL主从、分库分表
	binlog
	sql优化

## NoSQL

	Cache
	Redis
	Memcached

## 大数据

	ZooKeeper: 部署
	Storm: 流式计算
	Hadoop: Hdfs、MapReduce、Hive

## 网络安全



### 分布式
* RPC
* Dubbo

### 缓存

### 消息
* JMS
* ActiveMQ

## 搜索

	Lucene
	Solr

### 高并发
* Java内存模型
* 多线程
* 高性能
* 高并发
* 性能调优

### 常见解决方案
* sso, 单点登录
* 一致性hash, 分布式缓存
* 全文检索, lucene
* 负载均衡
* 连接池

### 技术点
* 序列化

### 业务场景
* 秒杀库存