/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.1.62-community : Database - zjdatesql
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zjdatesql` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zjdatesql`;

/*Table structure for table `dayijiehuo` */

DROP TABLE IF EXISTS `dayijiehuo`;

CREATE TABLE `dayijiehuo` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dayijiehuo` */

insert  into `dayijiehuo`(`id`,`content`,`creatime`,`title`) values ('40282b81661ef49401661ef8ce0e0003','<p>答疑解惑答疑解惑答疑解惑答疑解惑</p>','2018-09-28 14:58:34','答疑解惑');

/*Table structure for table `gangtieyuanqu` */

DROP TABLE IF EXISTS `gangtieyuanqu`;

CREATE TABLE `gangtieyuanqu` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `gangtieyuanqu` */

insert  into `gangtieyuanqu`(`id`,`content`,`creatime`,`title`) values ('40282b81661a045401661a0531e80001','<p>钢铁配套园区钢铁配套园区钢铁配套园区钢铁配套园区</p>','2018-09-27 15:54:00','钢铁配套园区');

/*Table structure for table `images` */

DROP TABLE IF EXISTS `images`;

CREATE TABLE `images` (
  `id` varchar(32) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `urlpath` longtext,
  `creatime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `images` */

insert  into `images`(`id`,`type`,`urlpath`,`creatime`) values ('40282b81662301d10166230356250000','1','/uploadImg/1538187042940.png','2018-09-29 10:10:43'),('40282b81662301d101662306626e0001','2','/uploadImg/1538185911046.gif','2018-09-29 09:51:52'),('40282b81662301d101662306bc3e0002','3','/uploadImg/1538185935192.png','2018-09-29 09:52:15'),('40282b8166230f6401662310b8630000','1','/uploadImg/1538187050238.png','2018-09-29 10:10:51'),('40282b8166230f64016623112fdb0001','1','/uploadImg/1538186910011.jpg','2018-09-29 10:08:30');

/*Table structure for table `jigouzhineng` */

DROP TABLE IF EXISTS `jigouzhineng`;

CREATE TABLE `jigouzhineng` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jigouzhineng` */

insert  into `jigouzhineng`(`id`,`content`,`creatime`,`title`) values ('40282b81661a2bc101661a2c53d80001','<p>机构构成机构构成机构构成机构构成</p>','2018-09-28 17:19:04','机构构成');

/*Table structure for table `juzhangyouxiang` */

DROP TABLE IF EXISTS `juzhangyouxiang`;

CREATE TABLE `juzhangyouxiang` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `juzhangyouxiang` */

insert  into `juzhangyouxiang`(`id`,`content`,`creatime`,`title`) values ('40282b81661a32bb01661a34e3a80001','<p>局长邮箱局长邮箱局长邮箱局长邮箱</p>','2018-09-27 16:46:05','局长邮箱');

/*Table structure for table `lianxiwomen` */

DROP TABLE IF EXISTS `lianxiwomen`;

CREATE TABLE `lianxiwomen` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lianxiwomen` */

insert  into `lianxiwomen`(`id`,`content`,`creatime`,`title`) values ('40282b81661a3a7001661a3b2d0c0001','<p>联系方式联系方式联系方式联系方式</p>','2018-09-28 17:19:18','联系方式');

/*Table structure for table `liaojiewomen` */

DROP TABLE IF EXISTS `liaojiewomen`;

CREATE TABLE `liaojiewomen` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  `fmimg` varchar(32) DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `liaojiewomen` */

insert  into `liaojiewomen`(`id`,`content`,`creatime`,`title`,`fmimg`,`type`) values ('40282b8166190d380166192736df0001','<p>了解开发区规划开发区规划开发区规划开发区规划开发区规划</p>','2018-09-28 15:54:40','开发区规划',NULL,'4'),('40282b81661f1ef801661f2010400000','<p>湛江开发区情况湛江开发区情况湛江开发区情况湛江开发区情况</p>','2018-09-28 15:41:26','湛江开发区情况',NULL,'1'),('40282b81661f1ef801661f204b490001','<p>投资优势投资优势投资优势投资优势</p>','2018-09-28 15:41:42','投资优势',NULL,'2'),('40282b81661f1ef801661f20c9630002','<p>经济发展状况经济发展状况经济发展状况经济发展状况</p>','2018-09-28 15:42:14','经济发展状况',NULL,'3');

/*Table structure for table `shihuayuanqu` */

DROP TABLE IF EXISTS `shihuayuanqu`;

CREATE TABLE `shihuayuanqu` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shihuayuanqu` */

insert  into `shihuayuanqu`(`id`,`content`,`creatime`,`title`) values ('40282b816619f9a5016619fbcde80002','<p>石化园区石化园区石化园区石化园区</p>','2018-09-27 15:43:44','石化园区');

/*Table structure for table `touzichengben` */

DROP TABLE IF EXISTS `touzichengben`;

CREATE TABLE `touzichengben` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `touzichengben` */

insert  into `touzichengben`(`id`,`content`,`creatime`,`title`) values ('40282b816619bb6f016619bd355c0002','<p>投资成本投资成本投资成本投资成本投资成本</p>','2018-09-27 14:35:22','投资成本');

/*Table structure for table `touzidongtai` */

DROP TABLE IF EXISTS `touzidongtai`;

CREATE TABLE `touzidongtai` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  `fmimg` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `touzidongtai` */

insert  into `touzidongtai`(`id`,`content`,`creatime`,`title`,`fmimg`) values ('40282b816618fbf4016618fd603f0002','<p>投资动态投资动态投资动态投资动态</p>','2018-09-27 11:05:50','投资动态','/uploadImg/1538017549715.png');

/*Table structure for table `touziliucheng` */

DROP TABLE IF EXISTS `touziliucheng`;

CREATE TABLE `touziliucheng` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `touziliucheng` */

insert  into `touziliucheng`(`id`,`content`,`creatime`,`title`) values ('40282b816619e0f1016619e1db670001','<p>投资流程投资流程投资流程投资流程投资流程投资流程</p>','2018-09-27 15:15:24','投资流程');

/*Table structure for table `touzimulu` */

DROP TABLE IF EXISTS `touzimulu`;

CREATE TABLE `touzimulu` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `touzimulu` */

insert  into `touzimulu`(`id`,`content`,`creatime`,`title`) values ('40282b816619f10f016619f205e40001','<p>投资目录投资目录投资目录投资目录</p>','2018-09-27 15:33:03','投资目录');

/*Table structure for table `touzixiangmu` */

DROP TABLE IF EXISTS `touzixiangmu`;

CREATE TABLE `touzixiangmu` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `touzixiangmu` */

insert  into `touzixiangmu`(`id`,`content`,`creatime`,`title`) values ('40282b816619aa08016619ad14b40001','<p>投资项目投资项目投资项目投资项目投资项目</p>','2018-09-27 14:17:45','投资项目');

/*Table structure for table `touzizhengce` */

DROP TABLE IF EXISTS `touzizhengce`;

CREATE TABLE `touzizhengce` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `touzizhengce` */

insert  into `touzizhengce`(`id`,`content`,`creatime`,`title`) values ('40282b816619b4c6016619b64f560001','<p>投资政策投资政策投资政策投资政策投资政策</p>','2018-09-27 14:27:50','投资政策');

/*Table structure for table `xinwenmeijie` */

DROP TABLE IF EXISTS `xinwenmeijie`;

CREATE TABLE `xinwenmeijie` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  `fmimg` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `xinwenmeijie` */

insert  into `xinwenmeijie`(`id`,`content`,`creatime`,`title`,`fmimg`) values ('40282b816618fbf4016618fcef9e0001','<p>新闻媒介新闻媒介新闻媒介新闻媒介新闻媒介新闻媒介</p>','2018-09-27 11:05:21','新闻媒介','/uploadImg/1538017520774.png');

/*Table structure for table `zhinengbumen` */

DROP TABLE IF EXISTS `zhinengbumen`;

CREATE TABLE `zhinengbumen` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zhinengbumen` */

insert  into `zhinengbumen`(`id`,`content`,`creatime`,`title`) values ('40282b816619e79c016619e87fd70001','<p>职能部门职能部门职能部门职能部门</p>','2018-09-27 15:22:47','职能部门联系');

/*Table structure for table `zhongdianqiye` */

DROP TABLE IF EXISTS `zhongdianqiye`;

CREATE TABLE `zhongdianqiye` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zhongdianqiye` */

insert  into `zhongdianqiye`(`id`,`content`,`creatime`,`title`) values ('40282b816619c515016619c67aed0001','<p>重点企业重点企业重点企业重点企业重点企业</p>','2018-09-27 14:45:29','重点企业');

/*Table structure for table `zhongyangshangwu` */

DROP TABLE IF EXISTS `zhongyangshangwu`;

CREATE TABLE `zhongyangshangwu` (
  `id` varchar(32) NOT NULL,
  `content` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zhongyangshangwu` */

insert  into `zhongyangshangwu`(`id`,`content`,`creatime`,`title`) values ('40282b81661a24aa01661a256a890001','<p>中央商务区中央商务区中央商务区中央商务区中央商务区</p>','2018-09-27 16:29:11','中央商务区');

/*Table structure for table `ziliaoxiazai` */

DROP TABLE IF EXISTS `ziliaoxiazai`;

CREATE TABLE `ziliaoxiazai` (
  `id` varchar(32) NOT NULL,
  `fileUrl` longtext,
  `creatime` datetime DEFAULT NULL,
  `title` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ziliaoxiazai` */

insert  into `ziliaoxiazai`(`id`,`fileUrl`,`creatime`,`title`) values ('40282b81661f8bb601661f9617470000','/uploadFile/1538128221095.rar','2018-09-28 17:50:22','资料下载1'),('40282b816622e29d016622e30d050000','/uploadFile/1538183596275.xls','2018-09-29 09:13:17','资料下载2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
