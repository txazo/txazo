drop table Remind;

create table Remind (
    id int(11) unsigned not null auto_increment comment 'id',
    account varchar(100) not null default '' comment 'account',
    title varchar(100) not null default '' comment 'title',
    description varchar(100) not null default '' comment 'description',
    cronExpression varchar(100) not null default '' comment 'cronExpression',
    beginTime datetime default null comment 'beginTime',
    endTime datetime default null comment 'endTime',
    remindedTimes smallint(5) unsigned not null default 0 comment 'remindedTimes',
    totalTimes smallint(5) unsigned not null default 0 comment 'totalTimes',
    isDeleted tinyint(3) unsigned not null default 0 comment 'isDeleted',
    createTime datetime default null comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    primary key (id),
    key (account),
    key (title),
    key (createTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Remind';