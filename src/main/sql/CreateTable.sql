use grape;
/*==============================================================*/
/* Table: Patient                                               */
/*==============================================================*/
create table Patient
(
   id                   int not null,
   name                 varchar(20) comment '姓名',
   sex                  varchar(5) comment '性别',
   age                  int comment '年龄',
   birthday             date comment '生日',
   zodiac               varchar(5) comment '属相',
   introducer           varchar(20) comment '介绍人',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table Patient comment '病人信息表';
