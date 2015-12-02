create table EleDataDisplay (
    id int(11) unsigned not null auto_increment comment 'id',
    scene varchar(32) not null default '' comment 'scene',
    page varchar(32) not null default '' comment 'page',
    atomItems text comment 'atomItems',
    isDeleted tinyint(4) unsigned not null default 0 comment 'isDeleted',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    key (scene, page),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='EleDataDisplay';