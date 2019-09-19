CREATE DATABASE /*!32312 IF NOT EXISTS*/`school_job` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

DROP TABLE IF EXISTS `school_info`;
CREATE TABLE `school_info` (
  `id` varchar(64) NOT NULL COMMENT '主键id,作为@BizId',
  `school_name` varchar(64) NOT NULL COMMENT '学校名称原名',
  `school_namec_ch` varchar(64) NOT NULL COMMENT '学校中文名称',
  `homepage_url` varchar(64) NOT NULL COMMENT '学校首页地址',
  `recruit_students_url` varchar(64) NOT NULL COMMENT '学校首页地址',
  `created_at` timestamp NOT NULL COMMENT '创建时间',
  `updated_at` timestamp NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校信息';

DROP TABLE IF EXISTS `school_file_info`;
CREATE TABLE `school_file_info` (
  `id` varchar(64) NOT NULL COMMENT '主键id,作为@BizId',
  `school_id` varchar(64) NOT NULL COMMENT '学校id',
  `file_name` varchar(64) NOT NULL COMMENT '文件名称',
  `created_at` timestamp NOT NULL COMMENT '创建时间',
  `updated_at` timestamp NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校文件更新记录';