drop table Email;

create table Email (
    id int(11) unsigned not null auto_increment comment 'id',
    fromEmail varchar(50) not null default '' comment 'fromEmail',
    fromPerson varchar(50) default null comment 'fromPerson',
    toEmail varchar(50) not null default '' comment 'toEmail',
    toPerson varchar(50) default null comment 'toPerson',
    subject varchar(100) not null default '' comment 'subject',
    sendTime datetime default null comment 'sendTime',
    contentId int(11) unsigned not null default 0 comment 'contentId',
    attachment varchar(200) not null default '' comment 'attachment',
    messageId varchar(100) default null comment 'messageId',
    createTime datetime default null comment 'createTime',
    primary key (id),
    key (fromEmail),
    key (toEmail),
    key (subject),
    key (createTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Email';