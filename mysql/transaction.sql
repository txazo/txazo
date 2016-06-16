// 事务的ACID特性
   A(Atomicity): 原子性
   C(Consistency): 一致性
   I(Isolation): 隔离性
   D(Curability): 持久性

// 事务隔离级别
   READ UNCOMMITTED: 读未提交
   READ COMMITTED: 读提交
   REPEATABLE READ: 可重复读
   SERIALIZABLE: 序列化

// 显式事务: set autocommit = 0
   1) session始终保持开启一个事务, commit | rollback显式结束事务, 并开启新的事务

// 隐式事务: set autocommit = 1
   1) 每条SQL自成一个事务, 执行后事务自动提交
   2) start transaction | begin显式开启事务, commit | rollback显式结束事务

// MySQL事务
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
SET GLOBAL TRANSACTION ISOLATION LEVEL SERIALIZABLE;

SELECT @@global.tx_isolation, @@session.tx_isolation;

SET GLOBAL tx_isolation='REPEATABLE-READ';
SET SESSION tx_isolation='SERIALIZABLE';

set autocommit = 0;

start transaction | begin
commit | rollback
