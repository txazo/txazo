drop table BlogContent;

create table BlogContent (
    id int(11) unsigned not null auto_increment comment 'id',
    blogId int(11) unsigned not null default 0 comment 'blogId',
    content text comment 'content',
    type tinyint(6) unsigned not null default 0 comment 'type',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    key (blogId),
    key (createTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BlogContent';