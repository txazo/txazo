// MySQL锁分类
   1) 表级锁: MyISAM, InnoDB
   2) 行级锁: InnoDB, 给索引上的索引项加锁实现

// 共享锁
   当前事务可以读, 写请求报ERROR
   其它事务的读请求可以获取共享锁
   其它事务的写请求等待获取排它锁
   select ... lock in share mode

// 排它锁
   当前事务可以读写
   其它事务的读请求等待获取共享锁
   其它事务的写请求等待获取排它锁
   select ... for update

// sql语句锁类型
   1) select, 快照读, 不加锁
   2) select ... lock in share mode, 当前读
   3) select ... for update, 当前读
   4) insert/delete/update, 写, 加排它锁

// 读
   1) 快照读/一致读, 不加锁
      select ...
   2) 当前读, 加共享锁
      select ... lock in share mode
   3) 当前读, 加排它锁
      select ... for update
      insert/delete/update

// binlog: 主从同步

// undo log: 撤消日志
   1) 记录原始的数据
   2) 保证事务的原子性, 用来回滚事务

// redo log: 重做日志
   1) 记录更改的数据
   2) 保证事务的持久性, 用来恢复数据
   3) 延迟数据的持久化, 提升I/O性能

// undo log + redo log
   1) 事务开始
   2) 记录undo log
   3) 修改数据
   4) 记录redo log
   5) redo log写入磁盘
   6) 事务提交

// 开启锁监控
   create table innodb_lock_monitor(a int) engine=innodb;

// 查看Innodb锁信息
   show engine innodb status;

set autocommit = 0;
SET SESSION tx_isolation='SERIALIZABLE';

// 脏读
begin;                                                            begin;
select * from User where id = 1;
                                                                  update User set name = 'manager' where id = 1;
select * from User where id = 1;
                                                                  rollback;
select * from User where id = 1;
commit;

// 不可重复读
begin;                                                            begin;
select * from User where id = 1;
                                                                  update User set name = 'manager' where id = 1;
                                                                  commit;
select * from User where id = 1;
commit;

// 幻读 - REPEATABLE READ
begin;                                                            begin;
select * from User;
// 两行记录
                                                                  insert into User(name) values ('manager');
                                                                  commit;
select * from User;
// 两行记录
update User set name = 'manager';
// 成功更新三行记录
select * from User;
// 三行记录
commit;

// 幻读解决 - SERIALIZABLE
begin;                                                            begin;
select * from User;
                                                                  insert into User(name) values ('manager');
                                                                  // waiting
commit;
                                                                  // insert ok
begin;
select * from User;
// waiting
                                                                  commit;
// query ok
commit;
