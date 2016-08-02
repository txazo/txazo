create table TitansApi (
    id int(11) unsigned not null auto_increment comment 'id',
    apiName varchar(32) not null default '' comment 'apiName',
    appType varchar(32) not null default '' comment 'appType',
    titansVersion varchar(16) not null default '' comment 'titansVersion',
    appVersion varchar(16) not null default '' comment 'appVersion',
    messageName varchar(32) not null default '' comment 'messageName',
    jsApiName varchar(32) not null default '' comment 'jsApiName',
    platformType varchar(8) not null default '' comment 'platformType',
    paramList text comment 'paramList',
    functionList text comment 'functionList',
    creator varchar(32) not null default '' comment 'creator',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    unique (apiName),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TitansApi';
