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
   left_pulse_cun                 varchar(30) comment '左寸脉象',
   left_pulse_guan                varchar(30) comment '左关脉象',
   left_pulse_chi                 varchar(30) comment '左尺脉象',
   right_pulse_cun                varchar(30) comment '右寸脉象',
   right_pulse_guan               varchar(30) comment '右关脉象',
   right_pulse_chi                varchar(30) comment '右尺脉象',
   tongue                         varchar(30) comment '舌象',
   add_condition                  varchar(50) comment '其它病情描述',
   analysis                       varchar(50) comment '病情分析',
   prescription_name              varchar(20) comment '药方名称',
   prescription_detail            varchar(500) comment '药方内容',
   prescription_method            varchar(20) comment '药方煎服方法',
   prescription_count             int comment '几副药',
   prescription_duration          varchar(10) comment '吃多久',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table Patient_Condition comment '病历表';
