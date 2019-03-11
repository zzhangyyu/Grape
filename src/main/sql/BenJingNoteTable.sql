CREATE TABLE Ben_Jing_Note
(
  id          int          not null,
  note_key    varchar(100) not null,
  content     text         NOT NULL,
  kind        int          NOT NULL,
  create_time datetime     NOT NULL,
  update_time datetime     NOT NULL,
  medicine_id int,
  primary key (id),
  CONSTRAINT `FK_Medicine_Id` FOREIGN KEY (`medicine_id`) REFERENCES `Ben_Jing_Medicine` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
alter table Ben_Jing_Note
  comment '本经-注解表';