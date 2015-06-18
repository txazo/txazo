drop table EmailContent;

create table EmailContent (
    id int(11) unsigned not null auto_increment comment 'id',
    content text comment 'content',
    createTime datetime default null comment 'createTime',
    primary key (id),
    key (createTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='EmailContent';