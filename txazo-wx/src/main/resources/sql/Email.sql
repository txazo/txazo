drop table Email;

create table Email (
    id int(11) unsigned not null auto_increment comment 'id',
    `from` varchar(100) not null default '' comment 'from',
    `to` varchar(100) not null default '' comment 'to',
    subject varchar(100) not null default '' comment 'subject',
    sendTime datetime default null comment 'sendTime',
    contentId int(11) unsigned not null default 0 comment 'contentId',
    attachment varchar(200) not null default '' comment 'attachment',
    messageId varchar(100) default null comment 'messageId',
    createTime datetime default null comment 'createTime',
    primary key (id),
    key (`from`),
    key (`to`),
    key (subject),
    key (createTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Email';