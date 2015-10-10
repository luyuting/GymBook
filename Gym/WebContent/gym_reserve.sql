-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-10-10 08:50:51
-- 服务器版本： 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gym_reserve`
--

-- --------------------------------------------------------

--
-- 表的结构 `tbl_gym`
--

CREATE TABLE IF NOT EXISTS `tbl_gym` (
`gymId` int(11) NOT NULL,
  `gymName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `gymInfo` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `tbl_gym`
--

INSERT INTO `tbl_gym` (`gymId`, `gymName`, `gymInfo`) VALUES
(1, '春哥体育馆', '信春哥，就是屌');

-- --------------------------------------------------------

--
-- 表的结构 `tbl_record`
--

CREATE TABLE IF NOT EXISTS `tbl_record` (
`recordId` int(11) NOT NULL,
  `venuesId` int(11) NOT NULL,
  `userId` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `location` int(11) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=30 ;

--
-- 转存表中的数据 `tbl_record`
--

INSERT INTO `tbl_record` (`recordId`, `venuesId`, `userId`, `location`, `startTime`, `endTime`) VALUES
(1, 1, '1', 1, '2014-12-26 09:00:00', '2014-12-26 10:00:00'),
(2, 1, '1', 2, '2014-12-26 10:00:00', '2014-12-26 11:00:00'),
(3, 2, '1', 1, '2014-12-26 15:00:00', '2014-12-26 16:00:00'),
(4, 1, '1', 1, '2014-12-27 10:00:00', '2014-12-27 11:00:00'),
(5, 2, '1', 2, '2014-12-27 20:00:00', '2014-12-27 21:00:00'),
(7, 3, '1', 3, '2014-12-29 20:00:00', '2014-12-29 21:00:00'),
(16, 1, '1', 2, '2015-10-05 17:00:00', '2015-10-05 18:00:00'),
(17, 1, '1', 5, '2015-10-05 17:00:00', '2015-10-05 18:00:00'),
(18, 1, '1', 5, '2015-10-05 16:00:00', '2015-10-05 17:00:00'),
(19, 1, '1', 6, '2015-10-05 18:00:00', '2015-10-05 19:00:00'),
(20, 1, '1', 3, '2015-10-05 15:00:00', '2015-10-05 16:00:00'),
(21, 1, '1', 8, '2015-10-05 15:00:00', '2015-10-05 16:00:00'),
(22, 1, '1', 7, '2015-10-05 16:00:00', '2015-10-05 17:00:00'),
(23, 2, '1', 8, '2015-10-05 16:00:00', '2015-10-05 17:00:00'),
(24, 2, '1', 11, '2015-10-05 15:00:00', '2015-10-05 16:00:00'),
(25, 2, '1', 21, '2015-10-05 17:00:00', '2015-10-05 18:00:00'),
(26, 2, '1', 11, '2015-10-05 15:00:00', '2015-10-05 16:00:00'),
(27, 2, '1', 18, '2015-10-05 16:00:00', '2015-10-05 17:00:00'),
(28, 2, '1', 4, '2015-10-05 15:00:00', '2015-10-05 16:00:00'),
(29, 3, '1', 4, '2015-10-05 20:00:00', '2015-10-05 21:00:00');

-- --------------------------------------------------------

--
-- 表的结构 `tbl_sport`
--

CREATE TABLE IF NOT EXISTS `tbl_sport` (
`sportId` int(11) NOT NULL,
  `sportName` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `tbl_sport`
--

INSERT INTO `tbl_sport` (`sportId`, `sportName`) VALUES
(1, '篮球'),
(2, '羽毛球'),
(3, '乒乓球'),
(4, '游泳'),
(5, '台球');

-- --------------------------------------------------------

--
-- 表的结构 `tbl_user`
--

CREATE TABLE IF NOT EXISTS `tbl_user` (
  `userId` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `userName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `userRole` int(11) NOT NULL,
  `password` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cookie` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creditWorthiness` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `tbl_user`
--

INSERT INTO `tbl_user` (`userId`, `userName`, `userRole`, `password`, `cookie`, `creditWorthiness`) VALUES
('1', 'qwe@gmail.com', 1, '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', '81174D3DA905B6DDCF3F31E32D3EC4AB', 0),
('18840851132', '958340585@qq.com', 1, '99421f6591445486fb1f8dd4ee12658534e64f0d0a80d3d78446940b4c4e72a0', NULL, 0),
('201203126', '958340585@qq.com', 1, '8658eea639f1f477be5c35b4f94d5f88dee315b5a715c65cc816e35331eaf082', '6A301800E0A9BD3038D9B6718AB76160', 0);

-- --------------------------------------------------------

--
-- 表的结构 `tbl_venues`
--

CREATE TABLE IF NOT EXISTS `tbl_venues` (
`venuesId` int(11) NOT NULL,
  `gymId` int(11) NOT NULL,
  `sportId` int(11) NOT NULL,
  `venuesName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `venuesNum` int(11) NOT NULL,
  `venuesCharge` float NOT NULL,
  `isOpen` int(11) NOT NULL DEFAULT '1',
  `openTime` datetime NOT NULL,
  `closeTime` datetime NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `tbl_venues`
--

INSERT INTO `tbl_venues` (`venuesId`, `gymId`, `sportId`, `venuesName`, `venuesNum`, `venuesCharge`, `isOpen`, `openTime`, `closeTime`) VALUES
(1, 1, 1, '篮球馆', 10, 20, 1, '2014-12-24 09:00:00', '2015-12-27 20:00:00'),
(2, 1, 2, '羽毛球馆', 25, 500, 1, '2014-11-13 14:00:00', '2015-12-24 18:02:19'),
(3, 1, 4, '游泳馆', 30, 10, 1, '2014-12-24 10:00:00', '2015-12-24 21:00:00'),
(4, 1, 5, '台球馆', 40, 8, 1, '2014-12-24 08:00:00', '2015-12-24 21:00:00'),
(5, 1, 3, '乒乓球馆', 50, 5, 1, '2014-12-24 07:00:00', '2015-12-24 17:30:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_gym`
--
ALTER TABLE `tbl_gym`
 ADD PRIMARY KEY (`gymId`);

--
-- Indexes for table `tbl_record`
--
ALTER TABLE `tbl_record`
 ADD PRIMARY KEY (`recordId`), ADD KEY `venuesId` (`venuesId`), ADD KEY `userId` (`userId`);

--
-- Indexes for table `tbl_sport`
--
ALTER TABLE `tbl_sport`
 ADD PRIMARY KEY (`sportId`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
 ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `tbl_venues`
--
ALTER TABLE `tbl_venues`
 ADD PRIMARY KEY (`venuesId`), ADD KEY `sportId` (`sportId`), ADD KEY `tbl_venues_ibfk_2` (`gymId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_gym`
--
ALTER TABLE `tbl_gym`
MODIFY `gymId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_record`
--
ALTER TABLE `tbl_record`
MODIFY `recordId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `tbl_sport`
--
ALTER TABLE `tbl_sport`
MODIFY `sportId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_venues`
--
ALTER TABLE `tbl_venues`
MODIFY `venuesId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- 限制导出的表
--

--
-- 限制表 `tbl_record`
--
ALTER TABLE `tbl_record`
ADD CONSTRAINT `tbl_record_ibfk_1` FOREIGN KEY (`venuesId`) REFERENCES `tbl_venues` (`venuesId`),
ADD CONSTRAINT `tbl_record_idfk_2` FOREIGN KEY (`userId`) REFERENCES `tbl_user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 限制表 `tbl_venues`
--
ALTER TABLE `tbl_venues`
ADD CONSTRAINT `tbl_venues_ibfk_1` FOREIGN KEY (`sportId`) REFERENCES `tbl_sport` (`sportId`),
ADD CONSTRAINT `tbl_venues_ibfk_2` FOREIGN KEY (`gymId`) REFERENCES `tbl_gym` (`gymId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
