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

#### NIO

	IO: 单向、同步阻塞、字节流、字节流
	NIO: 双向、异步非阻塞、通道、缓冲区

	Channel: 通道
	Buffer: 缓冲区
	Selector: 选择器
	
	reactor模式

	同步: 并行执行
    异步: 并发执行
    阻塞: 一直等待直到条件满足
    非阻塞: 不会等待, 直接返回标志信息

    IO请求: 检查数据是否就绪、数据拷贝(内核拷贝到用户线程)

    阻塞IO: 用户线程一直等待直到数据就绪
    非阻塞IO: 数据未就绪, 直接返回标志信息给用户线程
    同步IO: 用户线程将数据从内核拷贝到用户线程
    异步IO: 内核将数据从内核拷贝到用户线程, 发送消息给用户线程

	阻塞IO模型: 用户线程等待数据就绪和将数据从内核拷贝到用户线程
	非阻塞IO模型: 用户线程不断轮询数据是否就绪, 数据就绪后, 用户线程将数据从内核拷贝到用户线程
	多路复用IO模型(NIO): 一个线程管理多个socket, 不断轮询socket状态, socket就绪后, 用户线程将数据从内核拷贝到用户线程
	信号驱动IO模型: 内核等待数据就绪, 数据就绪后发送信号给用户线程
	异步IO模型: 内核等待数据就绪, 数据就绪后, 内核拷贝数据到用户线程, 发送信号给用户线程
	
	多线程IO模式:
	线程池IO模式:
	Reactor模式(多路复用IO模型): 注册事件、轮询事件、分发事件
	Proactor模式(异步IO模型): 注册事件、轮询事件、异步IO、分发事件

#### 反射

	asm: 字节码操控工具

	javassist: 运行时操作字节码

#### 动态代理

	asm: 字节码
	javassist:
	InvocationHandler: 接口
	CGlib: 接口或类
	<http://blog.csdn.net/luanlouis/article/details/24589193>

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
* 适配器模式
* 桥接模式
* 组合模式
* 装饰器模式
* 门面模式
* 享元模式
* 代理模式
#### 结果型模式
#### 行为型模式

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