create table ChannelActive (
    id int(11) unsigned not null auto_increment comment 'id',
    activeId int(11) unsigned not null default 0 comment 'activeId',
    sourceName varchar(32) not null default '' comment 'sourceName',
    os varchar(8) not null default '' comment 'os',
    ip varchar(64) not null default '' comment 'ip',
    dpid varchar(32) not null default '' comment 'dpid',
    clickId varchar(128) not null default '' comment 'clickId',
    activeDate date not null default '1970-01-01' comment 'activeDate',
    callbackTime datetime default null comment 'callbackTime',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    key (activeId),
    key (dpid),
    key (activeDate),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ChannelActive';