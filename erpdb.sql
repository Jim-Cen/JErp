-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: erpdb
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `erpdb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `erpdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `erpdb`;

--
-- Table structure for table `tbl_dep`
--

DROP TABLE IF EXISTS `tbl_dep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_dep` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `tele` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dep`
--

LOCK TABLES `tbl_dep` WRITE;
/*!40000 ALTER TABLE `tbl_dep` DISABLE KEYS */;
INSERT INTO `tbl_dep` VALUES (1,'','8888'),(2,'','6668'),(3,'','6888'),(4,'','3434'),(5,'','5666'),(6,'','1234'),(7,'','9999');
/*!40000 ALTER TABLE `tbl_dep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_emp`
--

DROP TABLE IF EXISTS `tbl_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_emp` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(15) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` varchar(30) NOT NULL DEFAULT '',
  `address` varchar(255) NOT NULL,
  `gender` int(1) NOT NULL COMMENT '1-男0-女',
  `birthday` date DEFAULT '0000-00-00',
  `depUuid` bigint(20) NOT NULL,
  `lastLoginTime` datetime DEFAULT '0000-00-00 00:00:00',
  `lastLoginIp` varchar(255) NOT NULL,
  `loginTimes` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_emp`
--

LOCK TABLES `tbl_emp` WRITE;
/*!40000 ALTER TABLE `tbl_emp` DISABLE KEYS */;
INSERT INTO `tbl_emp` VALUES (6,'Jim','1','admin@itcast.cn','112233','',1,'1900-01-01',1,'1900-01-01 00:00:00','127.0.0.1',293),(7,'chengzheng','1','Qeeqe','q11213','q213',0,'1900-01-01',1,'1900-01-01 00:00:00','-',0),(8,'hr','1','hr@itcast.cn','3232323','',0,'1900-01-01',6,'1900-01-01 00:00:00','0:0:0:0:0:0:0:1',4),(9,'hr2','1','hr2@itcast.cn','3232323','',0,'1900-01-01',6,'1900-01-01 00:00:00','0:0:0:0:0:0:0:1',3),(11,'test','1','test','test','test',1,'1900-01-01',1,'1900-01-01 00:00:00','0:0:0:0:0:0:0:1',3),(12,'jock','1','jock@itcast.cn','15611386665','',1,'1900-01-01',6,'1900-01-01 00:00:00','192.168.40.184',1),(13,'liulei','1','liulei@qq.com','010-110','广东',0,'1900-01-01',1,'1900-01-01 00:00:00','-',0);
/*!40000 ALTER TABLE `tbl_emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_emp_role`
--

DROP TABLE IF EXISTS `tbl_emp_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_emp_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `empUuid` bigint(20) NOT NULL,
  `roleUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_emp_role`
--

LOCK TABLES `tbl_emp_role` WRITE;
/*!40000 ALTER TABLE `tbl_emp_role` DISABLE KEYS */;
INSERT INTO `tbl_emp_role` VALUES (12,8,8),(13,9,9),(18,11,7),(19,12,8),(20,12,3),(21,12,2),(22,12,9),(23,12,5),(24,12,4),(25,12,6),(26,12,1),(27,12,7),(37,13,8),(38,13,6),(39,13,4),(40,13,7),(41,13,5),(42,13,3),(43,13,9),(44,13,2),(45,13,1),(46,6,1),(47,6,8);
/*!40000 ALTER TABLE `tbl_emp_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_goods`
--

DROP TABLE IF EXISTS `tbl_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_goods` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `origin` varchar(30) NOT NULL,
  `producer` varchar(30) NOT NULL,
  `unitUuid` bigint(20) NOT NULL DEFAULT '0',
  `inPrice` double(10,2) NOT NULL,
  `outPrice` double(10,2) NOT NULL,
  `supplierUuid` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_goods`
--

LOCK TABLES `tbl_goods` WRITE;
/*!40000 ALTER TABLE `tbl_goods` DISABLE KEYS */;
INSERT INTO `tbl_goods` VALUES (1,'辣条(10g)','四川','成都辣条厂',2,1.00,11.00,1),(2,'辣条(100g)','四川','四川辣条厂',3,2.00,22.00,1),(3,'老干妈超辣','四川','老干妈家',2,3.00,33.00,3),(4,'老干妈麻辣','四川','老干妈家',2,4.00,44.00,3),(5,'老干妈BT辣','四川','老干妈家',3,5.00,55.00,3),(6,'王致和臭豆腐','四川','王致和家',2,6.00,66.00,4),(7,'罗技鼠标','广东','广东电子元件厂',1,7.00,77.00,2),(8,'散热器大','广东','广东电子元件厂',1,8.00,88.00,2),(9,'散热器中','广东','广东电子元件厂',1,9.00,99.00,2);
/*!40000 ALTER TABLE `tbl_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_login`
--

DROP TABLE IF EXISTS `tbl_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_login` (
  `uuid` int(11) NOT NULL DEFAULT '0',
  `timestamp` bigint(20) NOT NULL DEFAULT '0',
  `token` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_login`
--

LOCK TABLES `tbl_login` WRITE;
/*!40000 ALTER TABLE `tbl_login` DISABLE KEYS */;
INSERT INTO `tbl_login` VALUES (6,1559090744557,'76f56163969362a8eae7f764b81618c6');
/*!40000 ALTER TABLE `tbl_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_menu`
--

DROP TABLE IF EXISTS `tbl_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_menu` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `icon` varchar(255) DEFAULT '',
  `href` varchar(255) DEFAULT NULL,
  `parentUuid` int(11) DEFAULT NULL,
  `level` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_menu`
--

LOCK TABLES `tbl_menu` WRITE;
/*!40000 ALTER TABLE `tbl_menu` DISABLE KEYS */;
INSERT INTO `tbl_menu` VALUES (1,'商品管理','fa-sitemap',NULL,NULL,0),(2,'供应商','','supplier.html',1,1),(3,'商品','','goods.html',1,1),(4,'采购管理','fa-university',NULL,NULL,0),(5,'采购订单','','purchorder.html',4,1);
/*!40000 ALTER TABLE `tbl_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_operdetail`
--

DROP TABLE IF EXISTS `tbl_operdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_operdetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `empUuid` bigint(20) NOT NULL,
  `operTime` bigint(20) NOT NULL,
  `type` int(1) NOT NULL,
  `goodsUuid` bigint(20) NOT NULL,
  `storeUuid` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_operdetail`
--

LOCK TABLES `tbl_operdetail` WRITE;
/*!40000 ALTER TABLE `tbl_operdetail` DISABLE KEYS */;
INSERT INTO `tbl_operdetail` VALUES (3,6,1422866275700,1,6,1,10),(4,6,1422866286419,1,6,1,5),(5,6,1422866312331,1,6,3,15),(6,6,1422866557169,1,6,3,1),(7,6,1422866562699,1,6,2,20),(8,6,1422866565578,1,6,2,9),(9,6,1422866659498,1,4,1,11),(10,6,1422866662443,1,4,2,22),(11,6,1422866665416,1,4,1,7),(12,6,1422866717019,1,1,1,9),(13,6,1422866729350,1,2,1,20),(14,6,1422866730517,1,3,1,30),(15,6,1422866731719,1,5,1,50),(16,6,1422866733506,1,1,1,1),(17,6,1422866984562,1,8,1,10),(18,6,1422866986220,1,9,1,10),(19,6,1422866987843,1,7,1,10),(20,6,1422867363860,1,8,1,10),(21,6,1422867365146,1,9,1,10),(22,6,1422867366359,1,7,1,10),(23,6,1422867375121,1,6,1,60),(24,6,1422867376618,1,4,1,40),(25,6,1422867377750,1,1,1,10),(26,6,1422867378917,1,5,1,50);
/*!40000 ALTER TABLE `tbl_operdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_purch_order`
--

DROP TABLE IF EXISTS `tbl_purch_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_purch_order` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(255) NOT NULL DEFAULT '',
  `creator` bigint(20) NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `checker` bigint(20) DEFAULT NULL,
  `checkTime` datetime DEFAULT NULL,
  `completer` bigint(20) DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `u_orderNo` (`orderNo`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_purch_order`
--

LOCK TABLES `tbl_purch_order` WRITE;
/*!40000 ALTER TABLE `tbl_purch_order` DISABLE KEYS */;
INSERT INTO `tbl_purch_order` VALUES (1,'00000001',6,'1900-01-01 00:00:00',6,'1900-01-01 00:00:00',NULL,NULL),(2,'00000002',6,'1900-01-01 00:00:00',6,'1900-01-01 00:00:00',6,'1900-01-01 00:00:00'),(3,'00000003',6,'1900-01-01 00:00:00',6,'1900-01-01 00:00:00',11,NULL),(4,'00000004',6,'1900-01-01 00:00:00',NULL,NULL,NULL,NULL),(5,'00000005',6,'1900-01-01 00:00:00',6,'1900-01-01 00:00:00',NULL,NULL),(6,'00000006',6,'1900-01-01 00:00:00',6,'1900-01-01 00:00:00',6,NULL),(7,'00000007',6,'1900-01-01 00:00:00',6,'1900-01-01 00:00:00',6,NULL),(8,'00000008',6,'1900-01-01 00:00:00',6,'1900-01-01 00:00:00',6,NULL),(20,'00000020',6,'2019-05-15 21:02:00',0,NULL,0,NULL),(25,'00000025',6,'2019-05-16 10:26:48',0,NULL,0,NULL),(26,'00000026',6,'2019-05-24 03:10:55',0,NULL,0,NULL),(27,'00000027',6,'2019-05-24 03:11:13',0,NULL,0,NULL),(28,'00000028',6,'2019-05-24 03:15:44',0,NULL,0,NULL),(29,'00000029',6,'2019-05-24 03:16:41',0,NULL,0,NULL),(30,'00000030',6,'2019-05-29 01:17:51',0,NULL,0,NULL);
/*!40000 ALTER TABLE `tbl_purch_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_purch_orderdetail`
--

DROP TABLE IF EXISTS `tbl_purch_orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_purch_orderdetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderUuid` bigint(20) NOT NULL DEFAULT '0',
  `goodsUuid` bigint(20) NOT NULL,
  `inPrice` double(10,2) NOT NULL DEFAULT '0.00',
  `supplierUuid` bigint(20) NOT NULL DEFAULT '0',
  `num` bigint(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_purch_orderdetail`
--

LOCK TABLES `tbl_purch_orderdetail` WRITE;
/*!40000 ALTER TABLE `tbl_purch_orderdetail` DISABLE KEYS */;
INSERT INTO `tbl_purch_orderdetail` VALUES (1,1,4,4.00,1,1),(2,1,2,2.00,1,1),(3,1,1,1.00,1,1),(4,1,3,3.00,1,1),(5,2,8,8.00,1,10),(6,2,9,9.00,1,10),(7,2,7,7.00,1,10),(8,3,2,2.00,1,1),(9,3,3,3.00,1,1),(10,3,1,1.00,1,1),(11,3,4,4.00,1,1),(12,4,2,2.00,1,1),(13,4,3,3.00,1,1),(14,4,1,1.00,1,1),(15,5,1,1.00,1,1),(16,5,3,3.00,1,1),(17,5,2,2.00,1,1),(18,6,6,6.00,1,60),(19,6,4,4.00,1,40),(20,6,1,1.00,1,10),(21,6,5,5.00,1,50),(22,6,3,3.00,1,30),(23,6,2,2.00,1,20),(24,7,1,1.00,1,1),(25,8,1,1.00,1,80),(34,29,1,1.00,1,123),(35,29,2,2.00,1,35),(36,29,4,4.00,3,123),(37,29,4,4.00,3,45),(38,29,7,7.00,2,34),(39,29,6,6.00,4,67),(40,28,6,6.00,4,67),(41,28,3,3.00,3,12),(42,28,4,4.00,3,12),(43,28,4,4.00,3,1212),(44,30,4,4.00,3,12);
/*!40000 ALTER TABLE `tbl_purch_orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_res`
--

DROP TABLE IF EXISTS `tbl_res`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_res` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_res`
--

LOCK TABLES `tbl_res` WRITE;
/*!40000 ALTER TABLE `tbl_res` DISABLE KEYS */;
INSERT INTO `tbl_res` VALUES (1,'员工列表','cn.itcast.erp.auth.emp.web.EmpAction.list'),(2,'操作添加/修改员工','cn.itcast.erp.auth.emp.web.EmpAction.input'),(3,'添加/修改员工','cn.itcast.erp.auth.emp.web.EmpAction.save'),(4,'删除员工','cn.itcast.erp.auth.emp.web.EmpAction.delete');
/*!40000 ALTER TABLE `tbl_res` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role`
--

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `code` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role`
--

LOCK TABLES `tbl_role` WRITE;
/*!40000 ALTER TABLE `tbl_role` DISABLE KEYS */;
INSERT INTO `tbl_role` VALUES (1,'ϵͳ','admin'),(2,'','buymgr'),(3,'','buyer'),(4,'','salemgr'),(5,'','saler'),(6,'','follower'),(7,'','storemgr'),(8,'','hrmgr'),(9,'','hr');
/*!40000 ALTER TABLE `tbl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role_menu`
--

DROP TABLE IF EXISTS `tbl_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role_menu` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` bigint(20) NOT NULL,
  `menuUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role_menu`
--

LOCK TABLES `tbl_role_menu` WRITE;
/*!40000 ALTER TABLE `tbl_role_menu` DISABLE KEYS */;
INSERT INTO `tbl_role_menu` VALUES (31,8,703),(32,8,704),(33,8,1),(34,8,702),(35,8,701),(36,8,700),(37,9,1),(38,9,702),(39,9,700),(52,7,101),(53,7,102),(54,7,1),(55,7,100),(62,1,600),(63,1,500),(64,1,700),(65,1,100),(66,1,706),(67,1,701),(68,1,400),(69,1,502),(70,1,703),(71,1,401),(72,1,501),(73,1,103),(74,1,101),(75,1,702),(76,1,300),(77,1,1),(78,1,201),(79,1,202),(80,1,200),(81,1,704),(82,1,705),(83,1,504),(84,1,601),(85,1,102),(86,1,402);
/*!40000 ALTER TABLE `tbl_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role_res`
--

DROP TABLE IF EXISTS `tbl_role_res`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role_res` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` bigint(20) NOT NULL,
  `resUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role_res`
--

LOCK TABLES `tbl_role_res` WRITE;
/*!40000 ALTER TABLE `tbl_role_res` DISABLE KEYS */;
INSERT INTO `tbl_role_res` VALUES (17,8,1),(18,8,2),(19,8,3),(20,9,1),(21,1,2),(22,1,1),(23,1,4),(24,1,3);
/*!40000 ALTER TABLE `tbl_role_res` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_store`
--

DROP TABLE IF EXISTS `tbl_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_store` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `empUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_store`
--

LOCK TABLES `tbl_store` WRITE;
/*!40000 ALTER TABLE `tbl_store` DISABLE KEYS */;
INSERT INTO `tbl_store` VALUES (1,'服装仓库','北京市海淀区1号',6),(2,'食品仓库','北京市',6),(3,'3#冷库','中腾建华1楼',6),(4,'4#冷库','中关村大街鼎好大厦3楼',6);
/*!40000 ALTER TABLE `tbl_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_storedetail`
--

DROP TABLE IF EXISTS `tbl_storedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_storedetail` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `storeUuid` bigint(20) NOT NULL,
  `goodsUuid` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_storedetail`
--

LOCK TABLES `tbl_storedetail` WRITE;
/*!40000 ALTER TABLE `tbl_storedetail` DISABLE KEYS */;
INSERT INTO `tbl_storedetail` VALUES (1,1,6,75),(2,3,6,16),(3,2,6,29),(4,1,4,58),(5,2,4,22),(6,1,1,20),(7,1,2,20),(8,1,3,30),(9,1,5,100),(10,1,8,20),(11,1,9,20),(12,1,7,20);
/*!40000 ALTER TABLE `tbl_storedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_supplier`
--

DROP TABLE IF EXISTS `tbl_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_supplier` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `contact` varchar(30) NOT NULL,
  `tel` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_supplier`
--

LOCK TABLES `tbl_supplier` WRITE;
/*!40000 ALTER TABLE `tbl_supplier` DISABLE KEYS */;
INSERT INTO `tbl_supplier` VALUES (1,'成都小食品批发总公司','成都辣条街1号','王辣条','1111111'),(2,'中关村鼎好302号摊','中关村大街鼎好大厦3楼','刘电脑','88888888'),(3,'北京特产批发总公司','北京王府井大街4号','赵特产','89898989'),(4,'中腾建华楼下小卖店','中腾建华1楼','老王头','12345678');
/*!40000 ALTER TABLE `tbl_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_unit`
--

DROP TABLE IF EXISTS `tbl_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_unit` (
  `uuid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_unit`
--

LOCK TABLES `tbl_unit` WRITE;
/*!40000 ALTER TABLE `tbl_unit` DISABLE KEYS */;
INSERT INTO `tbl_unit` VALUES (1,'个'),(2,'箱'),(3,'袋');
/*!40000 ALTER TABLE `tbl_unit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-02 17:51:30
