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

	* 克隆：Cloneable
	* 比较：Comparable、Comparator
	* 迭代器：Iterable
	* 类加载器：ClassLoader、URLClassLoader
	* 枚举：Enum
	* 基本数据类型包装类：Integer、Double
	* 对象：Object
	* 字符串：String、StringBuffer、StringBuilder
	* 异常：Throwable、Exception、Error、RuntimeException

#### IO
* 文件流: 磁盘
* Socket流: 网络
* 字节/字符数组流: 内存
* 对象流: 对象
* 缓冲流: 缓冲区
* 基本数据类型流: 基本数据类型
* 装饰器模式：基本数据类型流、对象流、缓冲流
* 序列化/反序列化：Serializable、Externalizable，深度克隆

#### NIO

	IO和NIO对比
	
| | IO | NIO |
| :----------: | :-------------: | :-------------: |
| 是否双向 | 单向 | 双向 |
| 是否异步 | 同步阻塞 | 异步非阻塞 |
| 操作方式 | 字节流 | 通道、缓冲区 |

	Channel：
	Buffer：
	Selector：

#### 集合
* List：ArrayList、LinkedList、Vector、Stack
* Set：HashSet、TreeSet
* Map：HashMap、TreeMap
* Queue
* 迭代器：Iterator、Enumeration
* 

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