-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2019 at 03:53 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bitmascot`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

CREATE TABLE IF NOT EXISTS `app_user` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(10) DEFAULT 'USER',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`id`, `address`, `dob`, `email`, `first_name`, `last_name`, `password`, `phone`, `role`) VALUES
(1, 'Savar,Dhaka-1216', '2019-12-05', 'motaleb14029@gmail.com', 'Motaleb', 'Hossain', 'mmmmmmmm', '01521447020', 'USER'),
(2, 'dhaka', '2019-12-12', 'admin@localhost.local', 'Motaleb', 'Hossain', 'admin', '01558964215', 'ADMIN'),
(3, 'Sakhipur, Tangail', '1997-08-04', 'mamun@gmail.com', 'Abdullah Al', 'Mamun', 'mamun', '01626311400', 'USER'),
(4, 'Mymansing', '1982-06-15', 'muead@gmail.com', 'Wazid Ullah', 'Murad', 'murad', '01685222158', 'USER'),
(5, 'Mymansing', '1998-07-23', 'sajib@gmail.com', 'Sajib', 'Hossain', 'sajib', '01734732985', 'USER'),
(6, 'Rangpur', '1972-07-20', 'manna@gmail.com', 'Khaled hassan', 'Manna', 'manna', '016872987322', 'USER'),
(7, 'borishal', '1998-12-31', 'motaleb14030@gmail.com', 'hello', 'ict', 'rrrr67#5', '01668967890', 'USER');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
