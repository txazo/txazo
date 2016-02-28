create table SourceTemplate (
    id int(11) unsigned not null auto_increment comment 'id',
    title varchar(32) not null default '' comment 'title',
    content text comment 'content',
    creator varchar(32) not null default '' comment 'creator',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    key (creator)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SourceTemplate';