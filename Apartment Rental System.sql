-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- โฮสต์: 127.0.0.1
-- เวลาในการสร้าง: 
-- รุ่นของเซิร์ฟเวอร์: 6.0.4
-- รุ่นของ PHP: 6.0.0-dev

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- ฐานข้อมูล: `kong`
-- 

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `addressrender`
-- 

CREATE TABLE `addressrender` (
  `personal_id` varchar(13) CHARACTER SET utf8 NOT NULL,
  `address` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`personal_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- dump ตาราง `addressrender`
-- 

INSERT INTO `addressrender` VALUES ('1461300144470', 'ระยอง');
INSERT INTO `addressrender` VALUES ('1451301234567', 'พะเยา');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `categoryroom`
-- 

CREATE TABLE `categoryroom` (
  `category_id` varchar(20) NOT NULL,
  `categoryName` varchar(20) NOT NULL,
  `categoryPrice` varchar(20) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- dump ตาราง `categoryroom`
-- 

INSERT INTO `categoryroom` VALUES ('1029', 'พัดลม', '700000');
INSERT INTO `categoryroom` VALUES ('1150', 'ธรรมดา', '200');
INSERT INTO `categoryroom` VALUES ('1160', 'VIP', '1500');
INSERT INTO `categoryroom` VALUES ('1170', 'แอร์', '1600');
INSERT INTO `categoryroom` VALUES ('1180', 'อ่างอาบน้ำ', '20000');
INSERT INTO `categoryroom` VALUES ('1190', 'AAA', '50000');
INSERT INTO `categoryroom` VALUES ('1120', 'BBB', '2000');
INSERT INTO `categoryroom` VALUES ('1121', 'CCCCD', '50000');
INSERT INTO `categoryroom` VALUES ('1123', 'แฟนรัก', '5000');
INSERT INTO `categoryroom` VALUES ('1027', 'ห้องน้ำ', '2500');
INSERT INTO `categoryroom` VALUES ('1031', 'Wingo', '2000');
INSERT INTO `categoryroom` VALUES ('1033', 'WingWing', '20000');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `charges`
-- 

CREATE TABLE `charges` (
  `charges_id` varchar(20) NOT NULL,
  `chargesName` varchar(20) NOT NULL,
  `chargesPer` varchar(20) NOT NULL,
  PRIMARY KEY (`charges_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- dump ตาราง `charges`
-- 

INSERT INTO `charges` VALUES ('102', 'ค่าน้ำ', '8');
INSERT INTO `charges` VALUES ('101', 'ค่าไฟ', '7');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `receipt`
-- 

CREATE TABLE `receipt` (
  `receiptid` varchar(10) CHARACTER SET utf8 NOT NULL,
  `amount` varchar(10) CHARACTER SET ucs2 NOT NULL,
  `dateOfReceipt` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`receiptid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- dump ตาราง `receipt`
-- 

INSERT INTO `receipt` VALUES ('1150', '26000.0', '20/12/2557');
INSERT INTO `receipt` VALUES ('1160', '10000.0', '17/12/2557');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `rent`
-- 

CREATE TABLE `rent` (
  `idlicense` varchar(20) CHARACTER SET utf8 NOT NULL,
  `money` varchar(20) CHARACTER SET utf8 NOT NULL,
  `datein` varchar(20) CHARACTER SET utf8 NOT NULL,
  `dateout` varchar(20) CHARACTER SET utf8 NOT NULL,
  `datelicense` varchar(20) CHARACTER SET utf8 NOT NULL,
  `idcard` varchar(13) CHARACTER SET utf8 NOT NULL,
  `idroom` varchar(20) CHARACTER SET utf8 NOT NULL,
  `idreceipt` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`idlicense`,`idcard`,`idroom`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- dump ตาราง `rent`
-- 

INSERT INTO `rent` VALUES ('11009', '50', '30/12/2557', '1/12/2558', '31/12/2558', '1461300144470', '101', '1150');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `renter`
-- 

CREATE TABLE `renter` (
  `idcard` varchar(13) CHARACTER SET utf8 NOT NULL,
  `fName` varchar(10) CHARACTER SET utf8 NOT NULL,
  `lName` varchar(10) CHARACTER SET utf8 NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`idcard`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- dump ตาราง `renter`
-- 

INSERT INTO `renter` VALUES ('1461300144470', 'kong    ', 'ruksiamza', 'ชาย');
INSERT INTO `renter` VALUES ('1451301234567', 'ก้อง', 'รักสยาม', 'ชาย');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `room`
-- 

CREATE TABLE `room` (
  `room_id` varchar(20) CHARACTER SET utf8 NOT NULL,
  `layer` varchar(20) CHARACTER SET utf8 NOT NULL,
  `idcatagory` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- dump ตาราง `room`
-- 

INSERT INTO `room` VALUES ('113', '2', '1029');
INSERT INTO `room` VALUES ('102', '1', '1150');
INSERT INTO `room` VALUES ('120', '1170', '2');
INSERT INTO `room` VALUES ('118', '1', '1029');
INSERT INTO `room` VALUES ('106', '3', '1027');
INSERT INTO `room` VALUES ('105', '3', '1170');
INSERT INTO `room` VALUES ('104', '2', '1160');
INSERT INTO `room` VALUES ('107', '2', '1029');
INSERT INTO `room` VALUES ('103', '3', '1160');
INSERT INTO `room` VALUES ('101', '3', '1029');
INSERT INTO `room` VALUES ('115', '1', '1160');
INSERT INTO `room` VALUES ('116', '3', '1029');
INSERT INTO `room` VALUES ('119', '2', '1029');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `spending`
-- 

CREATE TABLE `spending` (
  `months` varchar(20) NOT NULL,
  `years` varchar(20) NOT NULL,
  `per` varchar(20) NOT NULL,
  `unit` varchar(20) NOT NULL,
  `datereal` varchar(20) NOT NULL,
  `charges_id` varchar(20) NOT NULL,
  `idlicense` varchar(20) NOT NULL,
  `roomid` varchar(20) NOT NULL,
  `idrender` varchar(20) NOT NULL,
  `idreceipt` varchar(20) NOT NULL,
  PRIMARY KEY (`months`,`years`,`charges_id`,`idlicense`,`roomid`,`idrender`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- dump ตาราง `spending`
-- 

INSERT INTO `spending` VALUES ('มีนาคม', '2558', '8', '5', '13/20/2557', '102', '11009', '101', '1461300144470', '1150');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `telrenter`
-- 

CREATE TABLE `telrenter` (
  `idRenter` varchar(13) CHARACTER SET utf8 NOT NULL,
  `telNumber` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`idRenter`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- dump ตาราง `telrenter`
-- 

INSERT INTO `telrenter` VALUES ('1461300144470', '0828510940');
INSERT INTO `telrenter` VALUES ('1451301234567', '0920975132');
