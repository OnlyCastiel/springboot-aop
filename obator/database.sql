CREATE DATABASE /*!32312 IF NOT EXISTS*/`school_job` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.37-log : Database - school_job
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`school_job` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

/*Table structure for table `school_file_info` */

CREATE TABLE `school_file_info` (
  `id` varchar(64) NOT NULL COMMENT '主键id,作为@BizId',
  `school_id` varchar(64) NOT NULL COMMENT '学校id',
  `file_name` varchar(64) NOT NULL COMMENT '文件名称',
  `file_url` varchar(256) NOT NULL COMMENT '文件下载地址',
  `file_code` varchar(128) DEFAULT NULL COMMENT '文件标识（用作比对文件是否更新）',
  `created_at` timestamp NOT NULL COMMENT '创建时间',
  `updated_at` timestamp NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校文件更新记录';

/*Data for the table `school_file_info` */

insert  into `school_file_info`(`id`,`school_id`,`file_name`,`file_url`,`file_code`,`created_at`,`updated_at`) values ('626348878295470080','624253231643758592','2019_fall2_admission_foreigner_CN.pdf','https://peda.smu.ac.kr/cms/fileDownload.do?path=%2F_res%2Fgrad%2Fetc%2F2019_fall2_admission_foreigner_CN.pdf',NULL,'2019-09-25 09:26:50','2019-09-25 09:26:50'),('626348938957688832','625716191994056704','2019+招生简章.pdf','http://graduate.dankook.ac.kr/documents/2801066/0/2019+%E6%8B%9B%E7%94%9F%E7%AE%80%E7%AB%A0.pdf','db7a8692-aa7e-40ee-be60-11319c28927c','2019-09-25 09:27:04','2019-09-25 09:27:04');

/*Table structure for table `school_info` */

CREATE TABLE `school_info` (
  `id` varchar(64) NOT NULL COMMENT '主键id,作为@BizId',
  `school_name` varchar(64) NOT NULL COMMENT '学校名称原名',
  `school_namec_ch` varchar(64) NOT NULL COMMENT '学校中文名称',
  `homepage_url` varchar(64) NOT NULL COMMENT '学校首页地址',
  `recruit_students_url` varchar(64) NOT NULL COMMENT '招生信息地址（相对路径）',
  `method_name` varchar(64) DEFAULT NULL COMMENT '页面解析方法名',
  `created_at` timestamp NOT NULL COMMENT '创建时间',
  `updated_at` timestamp NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校信息';

/*Data for the table `school_info` */

insert  into `school_info`(`id`,`school_name`,`school_namec_ch`,`homepage_url`,`recruit_students_url`,`method_name`,`created_at`,`updated_at`) values ('624253231643758592','sangmyung','上明大学','https://peda.smu.ac.kr','/grad/admission/student.do','SangmyungRecruitFile','2019-09-19 14:39:28','2019-09-19 14:39:28'),('625716191994056704','dankook','檀国大学','http://graduate.dankook.ac.kr','/web/graduate/guidec','DankookRecruitFile','2019-09-23 15:32:45','2019-09-23 15:32:45');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
