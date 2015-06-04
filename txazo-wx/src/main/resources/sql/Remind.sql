create table Remind (
    id int(11) unsigned not null auto_increment comment 'id',
    title varchar(100) not null default '' comment 'name',
    createTime datetime default null comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    primary key (id),
    key (createTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Remind';