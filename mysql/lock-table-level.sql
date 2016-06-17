// 表锁

// 表级共享锁
lock tables User read;
unlock tables;

// 表级排它锁
lock tables User write;
unlock tables;
