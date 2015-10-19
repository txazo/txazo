create table ModelBranch (
    id int(11) unsigned not null auto_increment comment 'id',
    userName varchar(32) not null default '' comment 'userName',
    branchName varchar(32) not null default '' comment 'branchName',
    status tinyint(4) unsigned not null default 0 comment 'status',
    startVersion varchar(16) not null default '' comment 'startVersion',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    key (userName),
    unique (branchName),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ModelBranch';

create table ModelFieldModify (
    id int(11) unsigned not null auto_increment comment 'id',
    branchId int(11) unsigned not null default 0 comment 'branchId',
    modelId int(11) unsigned not null default 0 comment 'modelId',
    fieldId int(11) unsigned not null default 0 comment 'fieldId',
    modifyType tinyint(4) unsigned not null default 0 comment 'modifyType',
    oldContent varchar(1024) not null default '' comment 'oldContent',
    newContent varchar(1024) not null default '' comment 'newContent',
    status tinyint(4) unsigned not null default 0 comment 'status',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    key (branchId),
    key (modelId),
    key (fieldId),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ModelFieldModify';