set autocommit = 0;
SET SESSION tx_isolation='READ-UNCOMMITTED';

drop table if exists User;
create table User (
    id int(11) unsigned not null auto_increment,
    name varchar(16) not null default '',
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into User(name) values ('root');
insert into User(name) values ('admin');

// READ UNCOMMITTED
   读不加锁
   写加排它锁

// 读读
begin;                                                            begin;
select * from User where id = 1;
                                                                  select * from User where id = 1;
commit;                                                           commit;

// 读写
begin;                                                            begin;
select * from User where id = 1;
                                                                  update User set name = 'manager' where id = 1;
commit;                                                           commit;

// 写读
begin;                                                            begin;
update User set name = 'manager' where id = 1;
                                                                  select * from User where id = 1;
commit;                                                           commit;

// 写写
begin;                                                            begin;
update User set name = 'manager' where id = 1;
                                                                  update User set name = 'manager' where id = 1;
                                                                  // waiting
commit;                                                           commit;
