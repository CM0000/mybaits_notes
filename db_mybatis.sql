/*
SQLyog Ultimate v8.32 
MySQL - 5.5.27 : Database - db_mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_mybatis`;

/*Table structure for table `tb_banji` */

DROP TABLE IF EXISTS `tb_banji`;

CREATE TABLE `tb_banji` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_banji` */

insert  into `tb_banji`(`id`,`name`) values (1,'16软件技术1班'),(2,'16软件技术2班');

/*Table structure for table `tb_course` */

DROP TABLE IF EXISTS `tb_course`;

CREATE TABLE `tb_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `code` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_course` */

insert  into `tb_course`(`id`,`name`,`code`) values (1,'Java程序设计语言','08113226'),(2,'JavaWeb程序开发入门','08113228');

/*Table structure for table `tb_electivecourse` */

DROP TABLE IF EXISTS `tb_electivecourse`;

CREATE TABLE `tb_electivecourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `tb_electivecourse_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `tb_student` (`id`),
  CONSTRAINT `tb_electivecourse_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `tb_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_electivecourse` */

insert  into `tb_electivecourse`(`id`,`student_id`,`course_id`) values (1,1,1),(2,1,2),(3,2,2);

/*Table structure for table `tb_student` */

DROP TABLE IF EXISTS `tb_student`;

CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `card_id` (`card_id`),
  CONSTRAINT `tb_student_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `tb_studentidcard` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_student` */

insert  into `tb_student`(`id`,`name`,`sex`,`card_id`) values (1,'limin','f',1),(2,'jack','m',2);

/*Table structure for table `tb_student02` */

DROP TABLE IF EXISTS `tb_student02`;

CREATE TABLE `tb_student02` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `banji_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `banji_id` (`banji_id`),
  CONSTRAINT `tb_student02_ibfk_1` FOREIGN KEY (`banji_id`) REFERENCES `tb_banji` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_student02` */

insert  into `tb_student02`(`id`,`name`,`sex`,`banji_id`) values (1,'孙淼','m',1),(2,'刘梦奕','f',1),(3,'无为','m',2);

/*Table structure for table `tb_studentidcard` */

DROP TABLE IF EXISTS `tb_studentidcard`;

CREATE TABLE `tb_studentidcard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_studentidcard` */

insert  into `tb_studentidcard`(`id`,`CODE`) values (1,'18030128'),(2,'18030135');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
