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


-- 导出 test3 的数据库结构
CREATE DATABASE IF NOT EXISTS `test3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test3`;

-- 导出  表 test3.app1_epidemic 结构
CREATE TABLE IF NOT EXISTS `app1_epidemic` (
  `provinnce` varchar(50) DEFAULT NULL,
  `xcqz` int(11) DEFAULT NULL,
  `ljqz` int(11) DEFAULT NULL,
  `xz` int(11) DEFAULT NULL,
  `ljzy` int(11) DEFAULT NULL,
  `dead` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 正在导出表  test3.app1_epidemic 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `app1_epidemic` DISABLE KEYS */;
INSERT INTO `app1_epidemic` (`provinnce`, `xcqz`, `ljqz`, `xz`, `ljzy`, `dead`) VALUES
	('安徽', 1, 34, 3, 5, 10),
	('新疆', 0, 0, 0, 0, 5),
	('湖北', 100, 20, 23, 29, 50),
	('浙江', 89, 12, 34, 3, 12),
	('上海', 67, 12, 11, 9, 6),
	('山西', 20, 78, 2, 6, 20);
/*!40000 ALTER TABLE `app1_epidemic` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
