use grape;
/*==============================================================*/
/* Table: Patient_Info                                               */
/*==============================================================*/
create table Patient_Info
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
alter table Patient_Info comment '病人基本信息表';

/*==============================================================*/
/* Table: Patient_Condition                                               */
/*==============================================================*/
create table Patient_Condition
(
   id                             int not null,
   patient_info_id                int not null comment '病人id',
   visiting_date                  DATE comment '就诊时间',
   pulse                          varchar(150) comment '左寸脉象',
   tongue                         varchar(30) comment '舌象',
   add_condition                  varchar(150) comment '其它病情描述',
   analysis                       varchar(200) comment '病情分析',
   primary key (id),
   CONSTRAINT `FK_PATIENT_ID` FOREIGN KEY (`patient_info_id`) REFERENCES `Patient_Info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table Patient_Condition comment '病历表';

/*==============================================================*/
/* Table: Prescription                                          */
/*==============================================================*/
  create table Prescription
(
   id                                int not null,
   patient_condition_id              int not null comment '病历ID',
   doctor_id                         int comment '医生ID',
   prescription_name                 varchar(20) comment '药方名称',
   prescription_detail               varchar(500) comment '药方内容',
   prescription_method               varchar(20) comment '煎服方法',
   prescription_count                int comment '几服药',
   prescription_duration             varchar(10) comment '喝多久',
   primary key (id),
   UNIQUE KEY `UK_PATIENT_CONDITION_ID` (`patient_condition_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table Prescription comment '药方表';

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   id                   int,
   phone                varchar(20) comment '手机号',
   user_name            varchar(20) comment '用户名',
   password             varchar(20) comment '密码',
   avatar               blob comment '头像',
   create_time          datetime comment '创建时间',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;
alter table User comment '用户表';

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

