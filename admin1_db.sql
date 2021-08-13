/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.27-community-nt : Database - admin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`admin` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `admin`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(255) default NULL,
  `firstname` varchar(255) default NULL,
  `lastname` varchar(255) default NULL,
  `phone` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

LOCK TABLES `admin` WRITE;

insert  into `admin`(`id`,`email`,`firstname`,`lastname`,`phone`) values (2,'chetankagda180@gmail.com','chaitanya','kansara',8320401936),(3,'neel@123.com','Neel ','Khanapara',9106656562),(4,'heet@123.com','Heet','Bavariya',999897234),(5,'abhi@123.com','Abhishek','Bhut',9823435510),(6,'prince@123.com','Prince ','Alondra',8320401936),(7,'poojashah@123.com','Pooja ','Shah',9723844406),(8,'jhnavideshani789@gmail.com','Jhanvi','Deshani',9106257273),(9,'chetankagda180@gmail.com','Tanvi','Jagani',9106656562),(10,'chetankagda180@gmail.com','chetan','kansaraaaa',9106257273),(11,'abhi@123.com','abhishek','abishek@gmail.com',0);

UNLOCK TABLES;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

LOCK TABLES `hibernate_sequence` WRITE;

insert  into `hibernate_sequence`(`next_val`) values (12);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
