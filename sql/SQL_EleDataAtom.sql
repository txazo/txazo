create table EleDataAtom (
    id int(11) unsigned not null auto_increment comment 'id',
    dataKey varchar(32) not null default '' comment 'dataKey',
    pageName varchar(32) not null default '' comment 'pageName',
    dataType tinyint(4) unsigned not null default 0 comment 'dataType',
    eleType tinyint(4) unsigned not null default 0 comment 'eleType',
    displayType tinyint(4) unsigned not null default 0 comment 'displayType',
    attributes text comment 'attributes',
    isDeleted tinyint(4) unsigned not null default 0 comment 'isDeleted',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='EleDataAtom';