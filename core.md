### IO

### CPU
* 控制单元
* 运算单元
* 存储单元

### Memory

### 网络协议
* TCP/IP
* HTTP

### Tomcat
* tomcat配置

### Linux
* linux
* shell

### JVM
* 内存模型
* 垃圾回收
* 类加载机制
* JVM参数和调优
* Java工具

		jps、jstack、jmap、jconsole、javap

* 内存溢出
	* HeapOutOfMemory
	* StackOutOfMemory
	* StackOverFlow
	* YoungOutOfMemory
	* MethodAreaOutOfMemory
	* ConstantPoolOutOfMemory
	* DirectMemoryOutOfMemory
* 常见问题
	* Java程序响应很慢
	* Java程序频繁Full GC
	* Java程序发生OutOfMemory

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

***

## 设计模式
#### 创建型模式

	单例模式

#### 结构型模式

	适配器模式: 转换接口, 复用功能
	桥接模式: 分离抽象与实现, 各自独立变化
	组合模式: 整体 - 部分的层次结构
	装饰器模式: 动态为对象添加功能
	门面模式: 封装交互, 简化调用
	享元模式: 分离变与不变, 运用共享技术有效地支持大量细粒度的对象
	代理模式: 为其它对象提供一种代理以控制对这个对象的访问

#### 行为型模式

	迭代器模式

***

## 开源框架(原理和机制)
* Struts2
* Spring
* MyBatis

## MySQL
* sql优化

### 分布式
* RPC
* Dubbo

### 缓存

### 消息
* JMS
* ActiveMQ

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

### 模型
1. reactor模式