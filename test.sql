-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2020 at 08:35 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `name` varchar(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  `author` varchar(20) NOT NULL,
  `price` varchar(10) NOT NULL,
  `rack_no` varchar(10) NOT NULL,
  `no_of_book` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`name`, `code`, `author`, `price`, `rack_no`, `no_of_book`) VALUES
('ANSIc', '1', 'E Balagurusamy', '100', '1', '5'),
('C++', '2', 'E Balagurusamy', '200', '1', '4'),
('DataBase Syatem Conc', '3', 'Avi Silberschatz', '500', '1', '2'),
('Introduction To Algo', '4', 'Thomas H Cormen', '600', '1', '2');

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

CREATE TABLE `issue` (
  `id` varchar(10) NOT NULL,
  `code` varchar(20) NOT NULL,
  `doi` varchar(10) NOT NULL,
  `doe` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue`
--

INSERT INTO `issue` (`id`, `code`, `doi`, `doe`) VALUES
('18CEUOG104', '1', '2020-03-22', '2020-04-22'),
('18CEUOS67', '1', '2020-05-22', '2020-06-22');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` varchar(10) NOT NULL,
  `pass` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `mobile` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `pass`, `name`, `address`, `mobile`) VALUES
('18CEUOG!04', '123456', 'Dip Dhameliya', 'Nadiad', '6353889322'),
('18CEUOS067', '123456', 'Deep Donda', 'Nadiad', '6353594040'),
('18CEUOS57', '123456', 'Meet Vaghasiya', 'Nadiad', '6353694040');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `issue`
--
ALTER TABLE `issue`
  ADD PRIMARY KEY (`id`,`code`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
