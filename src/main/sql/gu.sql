/*==============================================================*/
/* Table: Register_Gu_Jingbo                                    */
/*==============================================================*/
create table Register_Gu_Jingbo
(
   id                            int not null,
   intention_date                DATE comment '意向就诊时间',
   intention_week                varchar(10) comment '周几就诊',
   patient_name                  varchar(20) comment '姓名',
   patient_sex                   varchar(2) comment '1：男；2：女',
   patient_age                   varchar(5) comment '年龄',
   patient_phone                 varchar(20) comment '手机号',
   patient_intro                 varchar(20) comment '介绍人',
   first_flag                    varchar(2) comment '1：初诊；2：复诊',
   create_date                   DATE comment '创建时间',
   update_date                   DATE comment '修改时间',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table Register_Gu_Jingbo comment '谷大夫挂号表';
alter table Register_Gu_Jingbo modify id int auto_increment;