drop table Memory;

create table Memory (
    id int(11) unsigned not null auto_increment comment 'id',
    parentId int(11) unsigned not null default 0 comment 'parentId',
    type tinyint(3) unsigned not null default 0 comment 'type',
    name varchar(30) not null default '' comment 'name',
    content text comment 'content',
    isDeleted tinyint(3) unsigned not null default 0 comment 'isDeleted',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    key (parentId),
    key (name),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Memory';