create table SourcePkg (
    id int(11) unsigned not null auto_increment comment 'id',
    source varchar(32) not null default '' comment 'source',
    version varchar(16) not null default '' comment 'version',
    pkgUrl varchar(128) not null default '' comment 'pkgUrl',
    creator varchar(32) not null default '' comment 'creator',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    unique (version, source),
    key (creator)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SourcePkg';