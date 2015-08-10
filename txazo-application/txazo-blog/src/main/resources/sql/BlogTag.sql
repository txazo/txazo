drop table BlogTag;

create table BlogTag (
    id int(11) unsigned not null auto_increment comment 'id',
    name varchar(30) not null default '' comment 'name',
    quantity smallint(6) unsigned not null default 0 comment 'quantity',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    unique (name),
    unique (quantity),
    key (createTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BlogTag';