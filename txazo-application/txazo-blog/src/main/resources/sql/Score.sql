drop table Score;

create table Score (
    id int(11) unsigned not null auto_increment comment 'id',
    userId int(11) unsigned not null default 0 comment 'userId',
    score int(11) unsigned not null default 0 comment 'score',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    unique (userId),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Score';