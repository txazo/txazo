create table GdtAdCallback (
    id int(11) unsigned not null auto_increment comment 'id',
    appid varchar(16) not null default '' comment '移动应用id',
    appType varchar(8) not null default '' comment 'app类型',
    advertiserId varchar(16) not null default '' comment '广告主id',
    muid varchar(32) not null default '' comment '设备id',
    clickId varchar(32) not null default '' comment '广告点击id',
    clickTime varchar(16) not null default '' comment '广告点击时间',
    ip varchar(16) not null default '' comment 'ip',
    activeTime varchar(16) not null default '' comment '激活时间',
    dpid varchar(32) not null default '' comment 'dpid',
    ret tinyint(4) not null default -1 comment '返回码',
    msg varchar(32) not null default '' comment '错误提示',
    createTime datetime not null default '1970-01-01 00:00:00' comment '创建时间',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    primary key (id),
    key (createTime),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广点通广告激活上报';