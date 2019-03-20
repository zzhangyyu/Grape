CREATE TABLE Formula
(
  id            int,
  name          varchar(20) comment '方剂名',
  formula_key   varchar(20) comment '方剂key',
  alias         varchar(10),
  nameEn        varchar(100) comment '方剂英文名',
  kind          int,
  category      varchar(20) comment '解表剂',
  source        varchar(20) comment '出处',
  effect        varchar(200) comment '功用',
  components    text comment '用量',
  zhuZhi        text comment '主治',
  taboo         text,
  bingJi        text comment '病机',
  usages        text comment '运用',
  jianFa        text comment '煎法',
  fangGe        text comment '方歌',
  analysisTable text comment '组成表',
  onlineImg     varchar(200) comment '图片地址',
  link          varchar(200) comment '网站',
  create_time   datetime comment '创建时间',
  update_time   datetime comment '更新时间',
  fuFang        text comment '附方',
  faq           text comment '释疑',
  primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
alter table Formula
  comment '方剂表';