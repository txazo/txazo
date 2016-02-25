create table AndroidChannel (
    id int(11) unsigned not null auto_increment comment 'id',
    source varchar(32) not null default '' comment 'source',
    sourceId varchar(32) not null default '' comment 'sourceId',
    downloadUrl varchar(128) not null default '' comment 'downloadUrl',
    creator varchar(32) not null default '' comment 'creator',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    unique (source),
    unique (sourceId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='AndroidChannel';