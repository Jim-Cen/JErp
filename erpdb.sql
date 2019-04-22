/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.24 : Database - erpdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`erpdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `erpdb`;

/*Table structure for table `tbl_dep` */

DROP TABLE IF EXISTS `tbl_dep`;

CREATE TABLE `tbl_dep` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `tele` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_dep` */

insert  into `tbl_dep`(`uuid`,`name`,`tele`) values (1,'�ܲð�','8888'),(2,'�ɹ���','6668'),(3,'���۲�','6888'),(4,'��������','3434'),(5,'�������','5666'),(6,'������Դ','1234'),(7,'����','9999');

/*Table structure for table `tbl_emp` */

DROP TABLE IF EXISTS `tbl_emp`;

CREATE TABLE `tbl_emp` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(15) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  `name` varchar(28) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tele` varchar(30) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` int(1) NOT NULL COMMENT '1-�� 0-Ů',
  `birthday` date DEFAULT '0000-00-00',
  `depUuid` bigint(20) NOT NULL,
  `lastLoginTime` datetime DEFAULT '0000-00-00 00:00:00',
  `lastLoginIp` varchar(255) NOT NULL,
  `loginTimes` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_emp` */

insert  into `tbl_emp`(`uuid`,`userName`,`pwd`,`name`,`email`,`tele`,`address`,`gender`,`birthday`,`depUuid`,`lastLoginTime`,`lastLoginIp`,`loginTimes`) values (6,'admin','21232f297a57a5a743894a0e4a801fc3','����','admin@itcast.cn','112233','������1¥����',1,1263830400000,1,1497015543177,'127.0.0.1',293),(7,'chengzheng','202cb962ac59075b964b07152d234b70','�ܲ�','Qeeqe','q11213','q213',0,1420473600000,1,1422263312319,'-',0),(8,'hr','202cb962ac59075b964b07152d234b70','hr����','hr@itcast.cn','3232323','������1¥����',0,1421164800000,6,1422516196593,'0:0:0:0:0:0:0:1',4),(9,'hr2','202cb962ac59075b964b07152d234b70','hrרԱ','hr2@itcast.cn','3232323','���ڽ���3¥',0,1421683200000,6,1422516211656,'0:0:0:0:0:0:0:1',3),(11,'test','098f6bcd4621d373cade4e832627b4f6','test','test','test','test',1,1421164800000,1,1422848026718,'0:0:0:0:0:0:0:1',3),(12,'jock','202cb962ac59075b964b07152d234b70','����ʦ','jock@itcast.cn','15611386665','����',1,1422547200000,6,1422589659332,'192.168.40.184',1),(13,'liulei','202cb962ac59075b964b07152d234b70','����','liulei@qq.com','010-110','Сݷׯ',0,1421856000000,1,1422592663169,'-',0);

/*Table structure for table `tbl_emp_role` */

DROP TABLE IF EXISTS `tbl_emp_role`;

CREATE TABLE `tbl_emp_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `empUuid` bigint(20) NOT NULL,
  `roleUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_emp_role` */

insert  into `tbl_emp_role`(`uuid`,`empUuid`,`roleUuid`) values (12,8,8),(13,9,9),(18,11,7),(19,12,8),(20,12,3),(21,12,2),(22,12,9),(23,12,5),(24,12,4),(25,12,6),(26,12,1),(27,12,7),(37,13,8),(38,13,6),(39,13,4),(40,13,7),(41,13,5),(42,13,3),(43,13,9),(44,13,2),(45,13,1),(46,6,1),(47,6,8);

/*Table structure for table `tbl_goods` */

DROP TABLE IF EXISTS `tbl_goods`;

CREATE TABLE `tbl_goods` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `origin` varchar(30) NOT NULL,
  `producer` varchar(30) NOT NULL,
  `unit` varchar(30) NOT NULL,
  `inPrice` double(10,2) NOT NULL,
  `outPrice` double(10,2) NOT NULL,
  `goodsTypeUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_goods` */

insert  into `tbl_goods`(`uuid`,`name`,`origin`,`producer`,`unit`,`inPrice`,`outPrice`,`goodsTypeUuid`) values (1,'����(10g)','�Ĵ�','�ɶ�������','��',1.00,11.00,1),(2,'����(100g)','�Ĵ�','�Ĵ�������','��',2.00,22.00,1),(3,'�ϸ��賬��','�Ĵ�','�ϸ����','��',3.00,33.00,2),(4,'�ϸ�������','�Ĵ�','�ϸ����','��',4.00,44.00,2),(5,'�ϸ���BT��','�Ĵ�','�ϸ����','��',5.00,55.00,2),(6,'���ºͳ�����','�Ĵ�','���ºͼ�','��',6.00,66.00,3),(7,'�޼����','�㶫','�㶫����Ԫ����','��',7.00,77.00,5),(8,'ɢ������','�㶫','�㶫����Ԫ����','��',8.00,88.00,6),(9,'ɢ������','�㶫','�㶫����Ԫ����','��',9.00,99.00,6);

/*Table structure for table `tbl_goodstype` */

DROP TABLE IF EXISTS `tbl_goodstype`;

CREATE TABLE `tbl_goodstype` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `supplierUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_goodstype` */

insert  into `tbl_goodstype`(`uuid`,`name`,`supplierUuid`) values (1,'����',1),(2,'�ϸ�������',1),(3,'������',1),(4,'��Ƭ',1),(5,'���',2),(6,'ɢ����',2),(7,'����',2),(8,'��Ѽ',3);

/*Table structure for table `tbl_menu` */

DROP TABLE IF EXISTS `tbl_menu`;

CREATE TABLE `tbl_menu` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `url` varchar(255) NOT NULL,
  `puuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=707 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_menu` */

insert  into `tbl_menu`(`uuid`,`name`,`url`,`puuid`) values (1,'ϵͳ�˵�','-',0),(100,'��Ʒ����','-',1),(101,'��Ӧ��','supplier_list.action',100),(102,'��Ʒ���','goodsType_list.action',100),(103,'��Ʒ','goods_list.action',100),(200,'�ɹ�����','-',1),(201,'�ɹ�����','order_buyList.action',200),(202,'�ɹ����','order_buyCheckList.action',200),(300,'���۹���','-',1),(400,'��Ʒ����','-',1),(401,'����ָ��','transport_taskList.action',400),(402,'�����ѯ','transport_tasks.action',400),(500,'�ֿ����','-',1),(501,'����ѯ','storeDetail_list.action',500),(502,'���','order_inStoreList.action',500),(504,'�ֿ������ϸ','operDetail_list.action',500),(600,'��������','-',1),(601,'�ɹ�����','bill_buyBillList.action',600),(700,'����ά��','-',1),(701,'����ά��','dep_list.action',700),(702,'Ա��ά��','emp_list.action',700),(703,'��ɫά��','role_list.action',700),(704,'��Դά��','res_list.action',700),(705,'�˵�ά��','menu_list.action',700),(706,'�ֿ�ά��','store_list.action',700);

/*Table structure for table `tbl_operdetail` */

DROP TABLE IF EXISTS `tbl_operdetail`;

CREATE TABLE `tbl_operdetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `empUuid` bigint(20) NOT NULL,
  `operTime` bigint(20) NOT NULL,
  `type` int(1) NOT NULL,
  `goodsUuid` bigint(20) NOT NULL,
  `storeUuid` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_operdetail` */

insert  into `tbl_operdetail`(`uuid`,`empUuid`,`operTime`,`type`,`goodsUuid`,`storeUuid`,`num`) values (3,6,1422866275700,1,6,1,10),(4,6,1422866286419,1,6,1,5),(5,6,1422866312331,1,6,3,15),(6,6,1422866557169,1,6,3,1),(7,6,1422866562699,1,6,2,20),(8,6,1422866565578,1,6,2,9),(9,6,1422866659498,1,4,1,11),(10,6,1422866662443,1,4,2,22),(11,6,1422866665416,1,4,1,7),(12,6,1422866717019,1,1,1,9),(13,6,1422866729350,1,2,1,20),(14,6,1422866730517,1,3,1,30),(15,6,1422866731719,1,5,1,50),(16,6,1422866733506,1,1,1,1),(17,6,1422866984562,1,8,1,10),(18,6,1422866986220,1,9,1,10),(19,6,1422866987843,1,7,1,10),(20,6,1422867363860,1,8,1,10),(21,6,1422867365146,1,9,1,10),(22,6,1422867366359,1,7,1,10),(23,6,1422867375121,1,6,1,60),(24,6,1422867376618,1,4,1,40),(25,6,1422867377750,1,1,1,10),(26,6,1422867378917,1,5,1,50);

/*Table structure for table `tbl_order` */

DROP TABLE IF EXISTS `tbl_order`;

CREATE TABLE `tbl_order` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(30) NOT NULL,
  `creater` bigint(20) NOT NULL,
  `createTime` bigint(20) NOT NULL,
  `checker` bigint(20) DEFAULT NULL,
  `checkTime` bigint(20) DEFAULT NULL,
  `completer` bigint(20) DEFAULT NULL,
  `endTime` bigint(20) DEFAULT NULL,
  `orderType` int(1) NOT NULL,
  `type` int(3) NOT NULL,
  `totalNum` int(11) NOT NULL,
  `totalPrice` double(10,2) NOT NULL,
  `supplierUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_order` */

insert  into `tbl_order`(`uuid`,`orderNum`,`creater`,`createTime`,`checker`,`checkTime`,`completer`,`endTime`,`orderType`,`type`,`totalNum`,`totalPrice`,`supplierUuid`) values (1,'37F4489A1',6,1422782442006,6,1422843573782,NULL,NULL,1,121,4,10.00,1),(2,'37F4489A2',6,1422782485205,6,1422842391025,6,1422867366361,1,199,30,240.00,2),(3,'37F4489A3',6,1422782578170,6,1422843576079,11,NULL,1,131,4,10.00,1),(4,'37F4489A4',6,1422782748231,NULL,NULL,NULL,NULL,1,111,3,6.00,1),(5,'37F4489A5',6,1422783740701,6,1422842081560,NULL,NULL,1,120,3,6.00,1),(6,'37F4489A6',6,1422784607857,6,1422841477118,6,NULL,1,141,210,910.00,1),(7,'37F461041',6,1422848864081,6,1422848869769,6,NULL,1,131,1,1.00,1),(8,'3BE821CE1',6,1470879623028,6,1470879633283,6,NULL,1,141,80,80.00,1);

/*Table structure for table `tbl_orderdetail` */

DROP TABLE IF EXISTS `tbl_orderdetail`;

CREATE TABLE `tbl_orderdetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsUuid` bigint(20) NOT NULL,
  `price` double(10,2) NOT NULL,
  `orderUuid` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  `surplus` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_orderdetail` */

insert  into `tbl_orderdetail`(`uuid`,`goodsUuid`,`price`,`orderUuid`,`num`,`surplus`) values (1,4,4.00,1,1,1),(2,2,2.00,1,1,1),(3,1,1.00,1,1,1),(4,3,3.00,1,1,1),(5,8,8.00,2,10,0),(6,9,9.00,2,10,0),(7,7,7.00,2,10,0),(8,2,2.00,3,1,1),(9,3,3.00,3,1,1),(10,1,1.00,3,1,1),(11,4,4.00,3,1,1),(12,2,2.00,4,1,1),(13,3,3.00,4,1,1),(14,1,1.00,4,1,1),(15,1,1.00,5,1,1),(16,3,3.00,5,1,1),(17,2,2.00,5,1,1),(18,6,6.00,6,60,0),(19,4,4.00,6,40,0),(20,1,1.00,6,10,0),(21,5,5.00,6,50,0),(22,3,3.00,6,30,30),(23,2,2.00,6,20,20),(24,1,1.00,7,1,1),(25,1,1.00,8,80,80);

/*Table structure for table `tbl_res` */

DROP TABLE IF EXISTS `tbl_res`;

CREATE TABLE `tbl_res` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_res` */

insert  into `tbl_res`(`uuid`,`name`,`url`) values (1,'Ա���б�','cn.itcast.erp.auth.emp.web.EmpAction.list'),(2,'�������/�޸�Ա��','cn.itcast.erp.auth.emp.web.EmpAction.input'),(3,'���/�޸�Ա��','cn.itcast.erp.auth.emp.web.EmpAction.save'),(4,'ɾ��Ա��','cn.itcast.erp.auth.emp.web.EmpAction.delete');

/*Table structure for table `tbl_role` */

DROP TABLE IF EXISTS `tbl_role`;

CREATE TABLE `tbl_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `code` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_role` */

insert  into `tbl_role`(`uuid`,`name`,`code`) values (1,'ϵͳ����Ա','admin'),(2,'�ɹ�����','buymgr'),(3,'�ɹ�רԱ','buyer'),(4,'��������','salemgr'),(5,'����רԱ','saler'),(6,'����Ա','follower'),(7,'�ֿ����Ա','storemgr'),(8,'������Դ�ܼ�','hrmgr'),(9,'������ԴרԱ','hr');

/*Table structure for table `tbl_role_menu` */

DROP TABLE IF EXISTS `tbl_role_menu`;

CREATE TABLE `tbl_role_menu` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` bigint(20) NOT NULL,
  `menuUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_role_menu` */

insert  into `tbl_role_menu`(`uuid`,`roleUuid`,`menuUuid`) values (31,8,703),(32,8,704),(33,8,1),(34,8,702),(35,8,701),(36,8,700),(37,9,1),(38,9,702),(39,9,700),(52,7,101),(53,7,102),(54,7,1),(55,7,100),(62,1,600),(63,1,500),(64,1,700),(65,1,100),(66,1,706),(67,1,701),(68,1,400),(69,1,502),(70,1,703),(71,1,401),(72,1,501),(73,1,103),(74,1,101),(75,1,702),(76,1,300),(77,1,1),(78,1,201),(79,1,202),(80,1,200),(81,1,704),(82,1,705),(83,1,504),(84,1,601),(85,1,102),(86,1,402);

/*Table structure for table `tbl_role_res` */

DROP TABLE IF EXISTS `tbl_role_res`;

CREATE TABLE `tbl_role_res` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` bigint(20) NOT NULL,
  `resUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_role_res` */

insert  into `tbl_role_res`(`uuid`,`roleUuid`,`resUuid`) values (17,8,1),(18,8,2),(19,8,3),(20,9,1),(21,1,2),(22,1,1),(23,1,4),(24,1,3);

/*Table structure for table `tbl_store` */

DROP TABLE IF EXISTS `tbl_store`;

CREATE TABLE `tbl_store` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `empUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_store` */

insert  into `tbl_store`(`uuid`,`name`,`address`,`empUuid`) values (1,'��װ�ֿ�','�����к�����1��',6),(2,'ʳƷ�ֿ�','������',6),(3,'3#���','���ڽ���1¥',6),(4,'4#���','�йش��ֶ��ô���3¥',6);

/*Table structure for table `tbl_storedetail` */

DROP TABLE IF EXISTS `tbl_storedetail`;

CREATE TABLE `tbl_storedetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `storeUuid` bigint(20) NOT NULL,
  `goodsUuid` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_storedetail` */

insert  into `tbl_storedetail`(`uuid`,`storeUuid`,`goodsUuid`,`num`) values (1,1,6,75),(2,3,6,16),(3,2,6,29),(4,1,4,58),(5,2,4,22),(6,1,1,20),(7,1,2,20),(8,1,3,30),(9,1,5,100),(10,1,8,20),(11,1,9,20),(12,1,7,20);

/*Table structure for table `tbl_supplier` */

DROP TABLE IF EXISTS `tbl_supplier`;

CREATE TABLE `tbl_supplier` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `contact` varchar(30) NOT NULL,
  `tele` varchar(30) NOT NULL,
  `needs` int(1) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_supplier` */

insert  into `tbl_supplier`(`uuid`,`name`,`address`,`contact`,`tele`,`needs`) values (1,'�ɶ�СʳƷ�����ܹ�˾','�ɶ�������1��','������','11111111',1),(2,'�йش嶦��302��̯','�йش��ֶ��ô���3¥','������','88888888',0),(3,'�����ز������ܹ�˾','�������������4��','���ز�','89898989',1),(4,'���ڽ���¥��С����','���ڽ���1¥','����ͷ','12345678',1);


CREATE TABLE `tbl_login` (
  `uuid` bigint(20) NOT NULL DEFAULT '0',
  `timestamp` bigint(20) NOT NULL DEFAULT '0',
  `token` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;