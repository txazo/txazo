create table SourcePkg (
    id int(11) unsigned not null auto_increment comment 'id',
    source varchar(32) not null default '' comment 'source',
    version varchar(16) not null default '' comment 'version',
    pkgUrl varchar(256) not null default '' comment 'pkgUrl',
    creator varchar(32) not null default '' comment 'creator',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    unique (version, source),
    key (creator),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SourcePkg';

create table SourceTask (
    id int(11) unsigned not null auto_increment comment 'id',
    creator varchar(32) not null default '' comment 'creator',
    status tinyint(4) unsigned not null default 0 comment 'status',
    version varchar(16) not null default '' comment 'version',
    name varchar(32) not null default '' comment 'name',
    sources text comment 'sources',
    result text comment 'result',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    key (creator),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SourceTask';

create table SourceTemplate (
    id int(11) unsigned not null auto_increment comment 'id',
    name varchar(32) not null default '' comment 'name',
    content text comment 'content',
    creator varchar(32) not null default '' comment 'creator',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    unique (name),
    key (creator),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SourceTemplate';