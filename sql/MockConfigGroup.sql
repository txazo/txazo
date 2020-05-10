/* MockConfigGroup */
create table MockConfigGroup (
    id int(11) unsigned not null auto_increment comment 'id',
    user varchar(32) not null default '' comment 'user',
    name varchar(64) not null default '' comment 'name',
    status tinyint(4) unsigned NOT NULL DEFAULT 0 COMMENT 'status',
    createTime datetime not null default '1970-01-01 00:00:00' comment 'createTime',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment 'updateTime',
    primary key (id),
    unique (user, name),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='MockConfigGroup';

/* MockConfig */
CREATE TABLE MockConfig (
   id int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
   groupId int(11) unsigned NOT NULL DEFAULT 0 COMMENT 'groupId',
   type tinyint(4) unsigned NOT NULL DEFAULT 0 COMMENT 'type',
   `desc` varchar(128) NOT NULL DEFAULT '' COMMENT 'desc',
   `rule` varchar(64) NOT NULL DEFAULT '' COMMENT 'rule',
   `schema` varchar(16) NOT NULL DEFAULT '' COMMENT 'schema',
   host varchar(32) NOT NULL DEFAULT '' COMMENT 'host',
   delay int(11) unsigned NOT NULL DEFAULT 0 COMMENT 'delay',
   statusCode smallint(8) unsigned NOT NULL DEFAULT 0 COMMENT 'statusCode',
   header text COMMENT 'header',
   response longtext COMMENT 'response',
   createTime datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT 'createTime',
   updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
   primary key (id),
   key (groupId),
   key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='MockConfig';

/* UserConfig */
CREATE TABLE UserConfig (
   id int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
   user varchar(32) NOT NULL DEFAULT '' COMMENT 'user',
   mockGroup int(11) unsigned NOT NULL DEFAULT 0 COMMENT 'mockGroup',
   createTime datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT 'createTime',
   updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
   PRIMARY KEY (id),
   unique (user),
   KEY updateTime (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='UserConfig';


create table MyisamI(
    id int(11) unsigned not null auto_increment comment 'id',
    name varchar(64) not null default '' comment 'name',
    name1 varchar(64) not null default '' comment 'name1',
    name2 varchar(64) not null default '' comment 'name2',
    primary key (id),
    key (name),
    key (name1),
    key (name2)
) ENGINE=Myisam DEFAULT CHARSET=utf8 COMMENT='MyisamI';

create table Product (
    id int(11) unsigned not null auto_increment comment 'id',
    name varchar(16) not null default '' comment 'name',
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Product';


insert into InnoDBI(name, name1, name2) values('asas1', 'adfaf1', 'asasas1');
insert into InnoDBI(name, name1, name2) values('asas2', 'adfaf2', 'asasas2');
insert into InnoDBI(name, name1, name2) values('asas3', 'adfaf3', 'asasas3');
insert into InnoDBI(name, name1, name2) values('asas4', 'adfaf4', 'asasas4');
insert into InnoDBI(name, name1, name2) values('asas5', 'adfaf5', 'asasas5');
insert into InnoDBI(name, name1, name2) values('asas6', 'adfaf6', 'asasas6');
