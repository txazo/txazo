create table HasTasteCategory (
    id int(11) unsigned not null auto_increment comment 'ID',
    type tinyint(4) unsigned not null default 0 comment '类型, 1-探好店, 2-推荐菜, 3-好去处',
    tag tinyint(4) unsigned not null default 0 comment '标签, 1-分类, 2-菜品, 3-场景词',
    typeId int(11) unsigned not null default 0 comment '类别ID',
    typeName varchar(32) not null default '' comment '类别名称',
    citys text default '' comment '城市列表',
    listTitle varchar(32) not null default '' comment '列表页描述',
    listImage varchar(128) not null default '' comment '列表页图片',
    listUrl varchar(256) not null default '' comment '列表页链接',
    subTitle varchar(128) not null default '' comment '5字标题',
    topicTitle varchar(128) not null default '' comment '专题页描述',
    topicImage varchar(128) not null default '' comment '专题页图片',
    isDeleted tinyint(4) unsigned not null default 0 comment '是否删除, 0-未删除, 1-删除',
    createTime datetime not null default '1970-01-01 00:00:00' comment '创建时间',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    primary key (id),
    key (updateTime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='HasTasteCategory';

alter table HasTasteCategory modify subTitle varchar(32) not null default '' comment '5字标题';
alter table HasTasteCategory modify listImage varchar(256) not null default '' comment '列表页图片';
alter table HasTasteCategory modify topicImage varchar(1024) not null default '' comment '专题页图片';
