use grape;
/*==============================================================*/
/* Table: Patient_Info                                               */
/*==============================================================*/
create table Patient_Info
(
   id                   int not null,
   name                 varchar(10) comment '姓名',
   sex                  varchar(5) comment '性别',
   age                  int comment '年龄',
   birthday             varchar(20) comment '生日',
   zodiac               varchar(5) comment '属相',
   introducer           varchar(10) comment '介绍人',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table Patient_Info comment '病人基本信息表';
alter table Patient_Info modify id int auto_increment;

/*==============================================================*/
/* Table: Patient_Condition                                               */
/*==============================================================*/
create table Patient_Condition
(
   id                             int not null,
   patient_info_id                int not null comment '病人id',
   visiting_date                  DATE comment '就诊时间',
   pulse                          varchar(500) comment '左寸脉象',
   tongue                         varchar(500) comment '舌象',
   add_condition                  varchar(1000) comment '病情描述',
   analysis                       varchar(500) comment '病情分析',
   primary key (id),
   CONSTRAINT `FK_PATIENT_ID` FOREIGN KEY (`patient_info_id`) REFERENCES `Patient_Info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table Patient_Condition comment '病历表';
alter table Patient_Condition modify id int auto_increment;

/*==============================================================*/
/* Table: Prescription                                          */
/*==============================================================*/
  create table Prescription
(
   id                                int not null,
   patient_condition_id              int not null comment '病历ID',
   doctor_id                         int comment '医生ID',
   prescription_name                 varchar(20) comment '药方名称',
   prescription_detail               varchar(1000) comment '药方内容',
   prescription_method               varchar(100) comment '煎服方法',
   prescription_duration             varchar(100) comment '剂量',
   advice                            varchar(500) comment '医嘱',
   zhao_sir_say                      varchar(1000) comment '师曰',
   primary key (id),
   UNIQUE KEY `UK_PATIENT_CONDITION_ID` (`patient_condition_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table Prescription comment '药方表';
alter table Prescription modify id int auto_increment;

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   id                   int,
   wx_openid            varchar(100) comment '微信openid',
   user_name            varchar(20) comment '用户名',
   password             varchar(20) comment '密码',
   avatar               varchar(1000) comment '头像',
   create_time          datetime comment '创建时间',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;
alter table User comment '用户表';
alter table User modify id int auto_increment;

/*==============================================================*/
/* Table: User_Favourite                                        */
/*==============================================================*/
create table User_Favourite
(
   user_id              int comment '用户ID',
   patient_info_id      int comment '收藏的病人ID',
   patient_condition_id int comment '收藏的病历ID',
   delete_flag          int(2) comment '删除标志0:删除;1:未删除',
   create_time          datetime comment '收藏时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;
alter table User_Favourite comment '用户收藏表';

