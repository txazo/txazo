**************************************************

## JVM

#### javac编译

	*.java -> *.class
	解语法糖

#### 语法糖

	断言: assert, AssertionError
	自动拆箱装箱: 基本数据类型、包装类型
	枚举
	增强for循环
	泛型: 类型擦除, 强制类型转换
	条件编译
	内部类
	switch字符串: 先hashcode(), 后equals()
	try-with-resources: AutoCloseable
	可变长参数: 数组

#### class文件结构

	magic
	minor_version
	major_version
	constant_pool_count
	constant_pool[constant_pool_count - 1]
	access_flags
	this_class
	super_class
	interfaces_count
	interfaces[interfaces_count]
	fields_count
	fields[fields_count]
	methods_count
	methods[methods_count]
	attributes_count
	attributes[attributes_count]

#### jvm指令集

	javap

#### jvm内存模型

	程序计数器: 线程私有
	Java虚拟机栈: 线程私有, 栈帧(局部变量表、操作数栈、动态链接、方法出口), OutOfMemoryError、StackOverflowError
	本地方法栈: Native方法, OutOfMemoryError
	Java堆: 线程共享, 分配对象, 新生代(Eden、From Survivor、To Survivor)、老年代、永久代, OutOfMemoryError
	方法区: 线程共享, 永久代, 存储虚拟机加载的类信息、常量、静态变量, OutOfMemoryError
	运行时常量池: 线程共享, OutOfMemoryError
	直接内存: OutOfMemoryError

#### 类加载机制

	1) 获取类的二进制字节码(jar包、网络、asm)
	2) 解析二进制字节码转化为方法区中类的运行时数据结构
	3) Java堆中生成一个Class对象, 作为方法区中类信息的访问入口
	4) 类静态变量分配内存, 初始化默认值
	5) 类初始化: 父类初始化, 静态变量赋值, static静态代码块执行
	6) 对象初始化: 分配内存, 初始化父对象, 类实例变量赋值, 执行构造函数

	双亲委派机制
	启动类加载器、扩展类加载器、系统类加载器
	BootstrapClassLoader(C实现) -> Launcher -> Launcher.ExtClassLoader、Launcher.AppClassLoader(系统类加载器)

#### 垃圾标记算法

	1) 引用计数算法
	2) 可达性分析算法

#### 垃圾收集算法

	1) 标记清除算法
	2) 复制算法
	3) 标记整理算法
	4) 分代收集算法

#### 垃圾收集器

	1) Serial收集器
	2) ParNew收集器
	3) Parallel Scavenge收集器
	4) Serial Old收集器
	5) Parallel Old收集器
	6) CMS收集器
	7) G1收集器

#### 堆内存分配

	1) 对象优先在Eden分配
	2) 大对象直接进入老年代
	3) 长期存活的对象进入老年代

#### GC

	新生代GC: Minor GC、Young GC
	老年代GC: Major GC、Full GC

#### 内存调优

	-Xss128k
	-Xmn1G
	-XX:NewRatio=3
	-Xms4G
	-Xmx4G
    -XX:SurvivorRatio=8
    -XX:MaxTenuringThreshold=10
    -XX:PermSize=6M
    -XX:MaxPermSize=6M

#### GC调优

	垃圾收集器搭配
	监控工具: JConsole、VisualVM
	GC日志: -verbose:gc、-XX:+PrintGC、-XX:PrintGCDetails、-XX:+PrintGCTimeStamps、-Xloggc

#### 诊断

	内存泄漏: jmap
	线程: 等待、锁竞争、死锁, jstack

**************************************************

## Java

#### Java基础

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

	单例
	枚举
	通用: 跨平台、跨语言(序列化格式)
	性能: 空间开销(序列化大小)、时间开销(序列化/反序列化时间)
	序列化协议: XML、JSON、Thrift、ProtoBuf

#### NIO

	IO: 单向、阻塞、流
	NIO: 双向、非阻塞、通道、缓冲区
	
	BIO: 同步阻塞IO
	NIO: 同步非阻塞IO
	AIO: 异步非阻塞IO
	
	Channel: 通道
	Buffer: 缓冲区
	Selector: 选择器

	Reactor模式

	同步: 串行执行
    异步: 并行执行, 通知
    阻塞: 一直等待, 直到条件满足
    非阻塞: 不会等待, 直接返回标志信息

    IO: 检查数据是否就绪、数据拷贝(内核拷贝到用户线程)

    阻塞IO: 用户线程一直等待直到数据就绪
    非阻塞IO: 数据未就绪, 直接返回标志信息给用户线程
    同步IO: 用户线程将数据从内核拷贝到用户线程
    异步IO: 内核将数据从内核拷贝到用户线程, 然后发送信号通知用户线程

	阻塞IO模型: 用户线程等待数据就绪, 然后将数据从内核拷贝到用户线程
	非阻塞IO模型: 用户线程不断轮询数据是否就绪, 数据就绪后, 用户线程将数据从内核拷贝到用户线程
	多路复用IO模型(NIO): 一个线程管理多个socket, 不断轮询socket状态, socket就绪后, 用户线程将数据从内核拷贝到用户线程
	信号驱动IO模型: 内核等待数据就绪, 数据就绪后发送信号通知用户线程
	异步IO模型: 内核等待数据就绪, 数据就绪后, 内核拷贝数据到用户线程, 然后发送信号通知用户线程

	多线程IO模式: 一个连接一个线程
	线程池IO模式: 线程池
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

#### 集合

	fail-fast机制
	比较器: Comparator、Comparable
	迭代器: Iterator、Enumeration
	List: ArrayList、Vector、Stack、LinkedList
	Set: HashSet、TreeSet
	Map: HashMap、Hashtable、TreeMap
	Queue: Deque
	Deque: ArrayDeque、LinkedList
	Arrays、Collections

#### 多线程

	Thread、Runnable
	ThreadLocal
	wait()、notify()、notifyAll()
	sleep()、join()、interrupt()
	synchronized

#### 并发包

	并发包基础: volatile、CAS(Compare And Swap)、AQS(AbstractQueuedSynchronizer)
	原子类
	锁: ReentrantLock、ReentrantReadWriteLock、Condition、LockSupport
	并发扩展: Semaphore、CyclicBarrier、CountDownLatch
	线程池: Callable、Future、Executor
	并发集合: ConcurrentHashMap、CopyOnWriteArrayList、CopyOnWriteArraySet、ArrayBlockingQueue、LinkedBlockingQueue

#### 网络编程

	网络协议: TCP/IP、HTTP、SSL
	URL、Socket、HttpURLConnection
	简单的HTTP服务器: 线程池、NIO、Reactor模式、响应状态码
	nginx、apache: 特性、搭建、配置
	FTP、SMTP: Java实现
	RPC原理
	消息机制(JMS)原理

#### 远程通讯

	请求转化: 序列化
	传输格式: stream、xml、json
	传输协议: tcp/ip、http、udp
	网络IO: bio、nio、aio

**************************************************

## 设计模式

#### 创建型模式(6)

	简单工厂模式: 一个工厂, 创建多个产品
	工厂方法模式: 多个工厂, 一个工厂创建一个产品
	抽象工厂模式: 多个工厂, 一个工厂创建一个产品簇
	单例模式: 控制一个类只有一个实例, 懒汉, 饿汉, 枚举, 静态内部类, 双重检查锁
	原型模式: 对象拷贝, 浅复制, 深复制
	建造者模式: 分离对象的构建和表示, Director(不变) -> Builder(可变) -> Product

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

#### AOP

	面向切面编程
	实现: 动态代理
	应用: 性能监控、权限控制、事务管理、日志记录

#### BIO

	同步阻塞
	accept -> New Thread(read -> decode -> process -> encode -> write)
	accept -> Queue + Thread Pool(read -> decode -> process -> encode -> write)

#### NIO和Reactor模式

	同步非阻塞
	read request -> decode request -> process service -> encode reply -> write reply
	MainReactor: acceptor
	SubReactor: read、write
	Dispatch(Thread Pool): decode、process、encode

**************************************************

## 开源框架(原理和机制)

#### Struts2

#### Spring

#### MyBatis

	半自动的ORM: sql参数映射, 结果集映射
	sql从代码中分离: xml配置、注解配置
	封装JDBC代码、参数设置、结果集检索
	动态sql
	缓存: 一级缓存、二级缓存
	事务管理
	数据库连接池

	MappedStatement
	SqlSessionFactoryBuilder - > SqlSessionFactory -> SqlSession
	SqlSession -> Mapper -> MapperProxy -> MapperMethod -> SqlSession
	SqlSession -> Executor -> StatementHandler -> ResultSetHandler

## 应用服务器

	tomcat

## 网络安全

	Base64: 双向编码解码
	MD5: 单向加密
	SHA: 单向加密
	AES: 对称加密
	DES: 对称加密
	DSA: 数字签名算法
	RSA: 非对称加密

## 分布式
	
	RPC
	Dubbo
	Hessian
	Thirft

## 缓存

	Redis
	Memcached

## 消息
	
	JMS
	ActiveMQ

## 搜索

	Lucene
	Solr

## 高并发

	Java内存模型

## 常见解决方案

	sso, 单点登录
	一致性hash, 分布式缓存
	全文检索, lucene
	负载均衡
	连接池

## 业务场景
#### 秒杀减库存

	秒杀系统独立部署
	秒杀的库存单独推送到秒杀系统
	异步队列

## 技术方案

	缓存
	异步消息: 优先级

## 数据库
#### 垂直拆分

	分库: 按功能模块分库

#### 水平拆分

	分库: 划分到不同的数据库
	分表: 单表拆分为子表
	主从: 主从同步, 读写分离

#### binlog解析

	数据变更 -> 发布订阅系统 -> push/pull

#### KV Store

## 缓存
#### 数据缓存

	本地缓存:
	集中式缓存:
	分布式缓存: 缓存服务化
	缓存命中率: 缓存划分力度, 业务相关性, 缓存有效期

## 消息

	消息类型: 点对点、发布/订阅
	消息顺序: 有序、无序
	消息模型: push、pull
	消息存储: 持久化、非持久化
	消息优先级

## 分布式

	无状态节点: 应用服务器
	有状态节点: 缓存、数据库

## 数据一致性

	最终一致性

## 前端性能优化

	1) 减少http请求
	2) 减少重定向
	3) 预加载
	4) 减少cookie大小
	5) 延迟加载
	6) Ajax异步化
	7) CDN加速
	8) 延迟渲染
	9) DNS预解析
	10) js放在尾部

## 中间件

	MVC框架
	RPC服务框架
	消息中间件
	数据库中间件
	分布式存储

**************************************************

## 操作系统

#### CPU

	CPU寄存器 > L1 > L2 > L3 > 跨槽 > 内存 > 磁盘
    L1 Cache: L1 Data Cache、L2 Instruction Cache
    L2 Cache
    L3 Cache
    Cache Line: 缓存行, 64个字节, CPU最小操作单位
    	1) Cache Miss: 缓存未命中, 按照数据的物理顺序访问数据(二维数组)
    	2) Cache冲突: 避免缓存行冲突, 补齐缓存行, 伪共享
    	3) Cache满: 减少操作的数据大小

#### 内存

#### 磁盘

#### IO

**************************************************

## MySQL
#### 索引

	B-Tree、B+Tree
	主索引、辅助索引
	MyISAM: B+Tree, 非聚集索引(数据文件和索引文件分离)
	InnoDB: B+Tree, 聚集索引(数据文件就是主索引文件, 按主键聚集, 辅助索引记录主键的值)
	聚集索引: 主索引查询高效, 辅助索引查询两次索引
	非聚集索引:

#### 优化

	分库分表
	主从同步
	binlog
	慢查询
	sql优化

**************************************************

## 源码(为什么、底层原理)

	java.lang.AutoCloseable: close(), try-with-resource语法糖
	java.lang.Comparable: Arrays.sort()、Collections.sort()、TreeSet、TreeMap
	java.lang.Byte: valueOf()、ByteCache
	java.lang.Character: valueOf()、CharacterCache
	java.lang.Class: 
		forName(): native
		newInstance(): Constructor.newInstance()
		getResource(): ClassLoader.getResource()
		getResourceAsStream(): ClassLoader.getResourceAsStream()
	
	java.lang.reflect.Constructor
		newInstance():
		
	java.lang.ClassLoader
	
	java.lang.Enum: 
		final String name、final int ordinal
		valueOf(): 反射调用values()获取枚举实例数组，封装为HashMap<String, T>
	
	java.lang.Thread
		ThreadLocal.ThreadLocalMap
		
	java.lang.ThreadLocal
		get(): Thread.currentThread().threadLocals.get(this)
		set(): Thread.currentThread().threadLocals.set(this, value)
		remove(): Thread.currentThread().threadLocals.remove(this)
	
	java.lang.Integer: valueOf()
	
	java.lang.String
	
	java.lang.Object
