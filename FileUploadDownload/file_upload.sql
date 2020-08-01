-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2019 at 10:54 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `file_upload`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `designation`, `file_name`, `file_path`, `file_size`, `file_type`, `created_date`) VALUES
(1, 'Roman Reigns', 'Wrestler', 'roman-reigns.jpg', 'G:\\Java HUB\\ImageUploadDisplay\\uploads\\roman-reigns.jpg', '167696', 'image/jpeg', '2019-11-14 18:03:08'),
(2, 'Seth Rollins', 'Wrestler', 'seth-rollins.jpg', 'G:\\Java HUB\\ImageUploadDisplay\\uploads\\seth-rollins.jpg', '187889', 'image/jpeg', '2019-11-14 18:03:41'),
(3, 'Dean Ambrose', 'Wrestler', 'dean-ambrose.jpg', 'G:\\Java HUB\\ImageUploadDisplay\\uploads\\dean-ambrose.jpg', '115518', 'image/jpeg', '2019-11-14 18:05:20'),
(4, 'Dharmesh Mourya', 'Developer', 'Dharmesh Mourya.jpg', 'G:\\Java HUB\\ImageUploadDisplay\\uploads\\Dharmesh Mourya.jpg', '805652', 'image/jpeg', '2019-11-14 18:32:36');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
