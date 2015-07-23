drop table Remind;

create table Remind (
    id int(11) unsigned not null auto_increment comment 'id',
    userName varchar(30) not null default '' comment 'userName',
    type tinyint(3) unsigned not null default 0 comment 'type',
    extJson text comment 'extJson',
    status tinyint(3) unsigned not null default 0 comment 'status',
    isDeleted tinyint(3) unsigned not null default 0 comment 'isDeleted',
    createTime datetime default null comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    primary key (id),
    key (userName),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Remind';