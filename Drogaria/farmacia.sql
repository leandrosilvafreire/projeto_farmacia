-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: drogaria
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_fabricante`
--

DROP TABLE IF EXISTS `tbl_fabricante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_fabricante` (
  `fab_codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `fab_descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`fab_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fabricante`
--

LOCK TABLES `tbl_fabricante` WRITE;
/*!40000 ALTER TABLE `tbl_fabricante` DISABLE KEYS */;
INSERT INTO `tbl_fabricante` VALUES (1,'DESeeeee'),(6,'DESCRICAOB'),(7,'DESCRICAOC'),(8,'DESCRICAOP'),(9,'DESCRICAOB'),(10,'DESCRICAOC'),(11,'Bebidas Ipiranga Ltda'),(12,'Rizzati Bebidas Ltda'),(13,'Pepsico Ltda'),(14,'Teste'),(15,'Teste_I'),(16,'Teste_II'),(17,'Unilever Ltda'),(18,'Marangoni Ltda'),(20,'Cervejaria Colônia Ltda'),(21,'Mirim Atacado Ltda'),(22,''),(23,'Doces'),(24,'dfdeee'),(25,'Oragom S/A'),(26,'Descrição Livro');
/*!40000 ALTER TABLE `tbl_fabricante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_funcionarios`
--

DROP TABLE IF EXISTS `tbl_funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_funcionarios` (
  `fun_codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `fun_cpf` varchar(14) NOT NULL,
  `fun_funcao` varchar(50) NOT NULL,
  `fun_nome` varchar(50) NOT NULL,
  `fun_senha` varchar(32) NOT NULL,
  PRIMARY KEY (`fun_codigo`),
  UNIQUE KEY `UK_mxb3f7990g171hgnyqobicje7` (`fun_cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_funcionarios`
--

LOCK TABLES `tbl_funcionarios` WRITE;
/*!40000 ALTER TABLE `tbl_funcionarios` DISABLE KEYS */;
INSERT INTO `tbl_funcionarios` VALUES (2,'335.345.583-32','Administrador','Leandro Silva Freire','123456'),(3,'944.747.258-32','Gerente','João','123456'),(8,'464.160.230-16','Administrador','jjjjjhjhjh','789456'),(9,'344.545.246-61','Balconista','Maria Aparecida José','mariaj'),(11,'661.861.793-62','Balconista','Ana Carolina Mercedes','anamerce'),(12,'471.273.864-20','Balconista','Pedro Malazrte','kikoki'),(13,'044.659.507-13','Gerente','Pereira Madureira','librasa'),(14,'304.705.774-52','Administrador','Pereira','123456');
/*!40000 ALTER TABLE `tbl_funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_itens`
--

DROP TABLE IF EXISTS `tbl_itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_itens` (
  `ite_codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `ite_quantidade` int(11) NOT NULL,
  `ite_valor_parcial` decimal(7,2) NOT NULL,
  `tbl_produtos_pro_codigo` bigint(20) NOT NULL,
  `tbl_vendas_ven_codigo` bigint(20) NOT NULL,
  PRIMARY KEY (`ite_codigo`),
  KEY `FK_dmbwny5rjkvpgphdk82o4vaba` (`tbl_produtos_pro_codigo`),
  KEY `FK_nk6bdj58rd66e7518sxt4vbcu` (`tbl_vendas_ven_codigo`),
  CONSTRAINT `FK_dmbwny5rjkvpgphdk82o4vaba` FOREIGN KEY (`tbl_produtos_pro_codigo`) REFERENCES `tbl_produtos` (`pro_codigo`),
  CONSTRAINT `FK_nk6bdj58rd66e7518sxt4vbcu` FOREIGN KEY (`tbl_vendas_ven_codigo`) REFERENCES `tbl_vendas` (`ven_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_itens`
--

LOCK TABLES `tbl_itens` WRITE;
/*!40000 ALTER TABLE `tbl_itens` DISABLE KEYS */;
INSERT INTO `tbl_itens` VALUES (2,5,20.00,1,3),(3,8,425.65,3,4),(4,1,8.99,1,7),(5,3,6.27,3,7),(6,6,11.94,6,7),(7,1,8.99,1,9),(8,2,4.18,3,9),(9,3,5.97,6,9),(10,1,8.99,1,11),(11,1,2.09,3,11),(12,2,17.98,1,12),(13,6,12.54,3,12),(14,8,15.92,6,12),(15,2,3.98,6,13),(16,2,17.98,1,13),(17,1,1.99,6,14),(18,1,8.99,1,15),(19,1,2.09,3,15),(20,1,1.99,6,15),(21,1,8.99,1,16),(22,1,2.09,3,16),(23,1,1.99,6,16),(24,7,62.93,1,17),(25,3,6.27,3,17),(26,2,3.98,6,17),(27,3,6.27,3,18),(28,4,7.96,6,18),(29,2,17.98,1,19),(30,1,1.99,6,19),(31,5,9.90,13,19);
/*!40000 ALTER TABLE `tbl_itens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_produtos`
--

DROP TABLE IF EXISTS `tbl_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_produtos` (
  `pro_codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `pro_descricao` varchar(50) NOT NULL,
  `pro_preco` decimal(7,2) NOT NULL,
  `pro_quantidade` int(11) NOT NULL,
  `tbl_fabricantes_fab_codigo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pro_codigo`),
  KEY `FK_c5ow9jmmm9cdp52342dwqyaqf` (`tbl_fabricantes_fab_codigo`),
  CONSTRAINT `FK_c5ow9jmmm9cdp52342dwqyaqf` FOREIGN KEY (`tbl_fabricantes_fab_codigo`) REFERENCES `tbl_fabricante` (`fab_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_produtos`
--

LOCK TABLES `tbl_produtos` WRITE;
/*!40000 ALTER TABLE `tbl_produtos` DISABLE KEYS */;
INSERT INTO `tbl_produtos` VALUES (1,'Coca-Cola 2L',8.99,20,1),(3,'Leite Nilza Integral 1L',2.09,5,7),(6,'Oleo Liza',1.99,100,18),(7,'Dipirona comprimidos',1.57,100,25),(8,'Sertralina 50mg',8.90,52,1),(9,'Paroxetina 50mg',12.57,2,6),(10,'Calcitran B3',21.35,1,7),(11,'Benegripe',159.00,1,6),(12,'Anador',1.25,2,6),(13,'aaaaaaaaaaaa',1.98,10,7),(14,'ssdsdsdsd',125.62,25,6);
/*!40000 ALTER TABLE `tbl_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_vendas`
--

DROP TABLE IF EXISTS `tbl_vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_vendas` (
  `ven_codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `ven_horario` datetime NOT NULL,
  `ven_valor_total` decimal(7,2) NOT NULL,
  `tbl_funcionarios_fun_codigo` bigint(20) NOT NULL,
  PRIMARY KEY (`ven_codigo`),
  KEY `FK_si6jywmvpou06ekibtndyvkby` (`tbl_funcionarios_fun_codigo`),
  CONSTRAINT `FK_si6jywmvpou06ekibtndyvkby` FOREIGN KEY (`tbl_funcionarios_fun_codigo`) REFERENCES `tbl_funcionarios` (`fun_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_vendas`
--

LOCK TABLES `tbl_vendas` WRITE;
/*!40000 ALTER TABLE `tbl_vendas` DISABLE KEYS */;
INSERT INTO `tbl_vendas` VALUES (2,'2015-09-25 21:24:35',298.87,3),(3,'2015-09-25 21:58:45',875.46,3),(4,'2015-09-25 21:57:12',365.99,2),(5,'2015-10-01 15:23:46',32.21,8),(6,'2015-10-01 15:41:31',27.20,8),(7,'2015-10-01 15:41:31',27.20,8),(8,'2015-10-01 15:42:26',19.14,8),(9,'2015-10-01 15:42:26',19.14,8),(10,'2015-10-01 15:45:04',11.08,8),(11,'2015-10-01 15:45:04',11.08,8),(12,'2015-10-01 16:20:18',46.44,8),(13,'2015-10-03 00:00:20',21.96,9),(14,'2015-10-03 00:30:23',1.99,8),(15,'2015-10-22 03:09:55',13.07,2),(16,'2015-10-22 23:42:05',13.07,8),(17,'2015-10-22 23:43:32',73.18,8),(18,'2015-10-27 17:24:39',14.23,13),(19,'2015-11-12 01:55:47',29.87,2);
/*!40000 ALTER TABLE `tbl_vendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-04  1:21:30
