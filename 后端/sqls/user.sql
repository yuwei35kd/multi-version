-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.29 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 user 的数据库结构
CREATE DATABASE IF NOT EXISTS `user` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `user`;

-- 导出  表 user.datasource 结构
CREATE TABLE IF NOT EXISTS `datasource` (
  `tenant_code` varchar(50) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `driver_class` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 正在导出表  user.datasource 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `datasource` DISABLE KEYS */;
INSERT INTO `datasource` (`tenant_code`, `url`, `username`, `password`, `driver_class`) VALUES
	('test1', 'jdbc:mysql://localhost:3306/test1?characterEncoding=utf8&characterSetResults=utf8&autoReconnect=true&failOverReadOnly=false&serverTimezone=GMT%2B8&amp&useSSL=false', 'root', NULL, 'com.mysql.cj.jdbc.Driver'),
	('test2', 'jdbc:mysql://localhost:3306/test2?characterEncoding=utf8&characterSetResults=utf8&autoReconnect=true&failOverReadOnly=false&serverTimezone=GMT%2B8&amp&useSSL=false', 'root', NULL, 'com.mysql.cj.jdbc.Driver'),
	('test3', 'jdbc:mysql://localhost:3306/test3?characterEncoding=utf8&characterSetResults=utf8&autoReconnect=true&failOverReadOnly=false&serverTimezone=GMT%2B8&amp&useSSL=false', 'root', NULL, 'com.mysql.cj.jdbc.Driver');
/*!40000 ALTER TABLE `datasource` ENABLE KEYS */;

-- 导出  表 user.tenant_app_version 结构
CREATE TABLE IF NOT EXISTS `tenant_app_version` (
  `tenant_code` varchar(50) NOT NULL DEFAULT '',
  `app` int(11) NOT NULL DEFAULT '1',
  `version` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`tenant_code`,`app`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='租户和版本的对应关系';

-- 正在导出表  user.tenant_app_version 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `tenant_app_version` DISABLE KEYS */;
INSERT INTO `tenant_app_version` (`tenant_code`, `app`, `version`) VALUES
	('test1', 1, '1.0'),
	('test1', 2, '4.0'),
	('test2', 1, '2.0'),
	('test3', 1, '3.0');
/*!40000 ALTER TABLE `tenant_app_version` ENABLE KEYS */;

-- 导出  表 user.user_info 结构
CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `tenant_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 正在导出表  user.user_info 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`user_id`, `user_name`, `pwd`, `tenant_code`) VALUES
	(1, 'zhangsan', '1', 'test1'),
	(2, 'lisi', '1', 'test2'),
	(3, 'wangwu', '1', 'test3'),
	(4, 'zhaoliu', '1', 'test1');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

-- 导出  表 user.version 结构
CREATE TABLE IF NOT EXISTS `version` (
  `version` varchar(50) DEFAULT NULL,
  `order` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`order`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- 正在导出表  user.version 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `version` DISABLE KEYS */;
INSERT INTO `version` (`version`, `order`) VALUES
	('2.0', 1),
	('3.0', 2),
	('4.0', 3);
/*!40000 ALTER TABLE `version` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
