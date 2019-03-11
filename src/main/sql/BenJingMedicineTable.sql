/*==============================================================*/
/* Table: Ben_Jing_Medicine                                          */
/*==============================================================*/
CREATE TABLE Ben_Jing_Medicine
(
  id          int          not null,
  name        varchar(100) not null comment '药名',
  alias       text,
  xing_wei    text comment '性味',
  origin      text comment '产地',
  effect      text comment '功效',
  ben_jing    text comment '本经原文',
  taboo       text comment '禁忌',
  pao_zhi     text comment '炮制',
  dose        text comment '用量',
  create_time datetime     NOT NULL comment '创建时间',
  update_time datetime     NOT NULL comment '修改时间',
  primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
alter table Ben_Jing_Medicine
  comment '本经-药表';