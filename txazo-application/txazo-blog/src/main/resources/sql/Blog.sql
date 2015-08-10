drop table Blog;

create table Blog (
    id int(11) unsigned not null auto_increment comment 'id',
    userId int(11) unsigned not null default 0 comment 'userId',
    catalogId int(11) unsigned not null default 0 comment 'catalogId',
    title varchar(30) not null default '' comment 'title',
    tags varchar(30) not null default '' comment 'tags',
    viewCount smallint(6) unsigned not null default 0 comment 'viewCount',
    isPublic tinyint(4) unsigned not null default 0 comment 'isPublic',
    idDeleted tinyint(4) unsigned not null default 0 comment 'idDeleted',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    key (userId, catalogId),
    key (createTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Blog';