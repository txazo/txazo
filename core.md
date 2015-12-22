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
* 类加载机制
* 内存模型
* 垃圾回收
* 性能优化

## Java
#### IO

	基本流

| 流类型 | 流说明 |
| :----------: | :-------------: |
| 文件流 | 磁盘 |
| Socket流 | 网络 |
| 字节/字符数组流 | 内存 |

	过滤流

| 流类型 | 流说明 |
| :----------: | :-------------: |
| 对象流 | 对象 |
| 缓冲流 | 缓冲区 |
| 基本数据类型流 | 基本数据类型 |

	装饰器模式：基本数据类型流、对象流、缓冲流
	
	序列化/反序列化：Serializable、Externalizable，深度克隆

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

## 设计模式

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