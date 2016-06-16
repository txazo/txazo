// 表锁

// 表级共享锁
lock tables User read;
unlock tables;

// 表级排它锁
lock tables User write;
unlock tables;

lock tables User read;
select * from User where id = 1;
update User set name = 'root' where id = 1;
ERROR 1099 (HY000): Table 'User' was locked with a READ lock and can't be updated
