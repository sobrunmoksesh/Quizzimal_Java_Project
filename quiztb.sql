-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 20, 2019 at 06:37 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quizzimaldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `quiztb`
--

CREATE TABLE `quiztb` (
  `id` int(10) UNSIGNED NOT NULL,
  `challenge` varchar(50) NOT NULL,
  `question` varchar(500) NOT NULL,
  `answer` varchar(50) NOT NULL,
  `image` varchar(10) NOT NULL,
  `descript` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiztb`
--

INSERT INTO `quiztb` (`id`, `challenge`, `question`, `answer`, `image`, `descript`) VALUES
(1, 'Challenge 1', '<html>I am black and white.<br><br> I love bamboo.<br><br> What animal am I?<html>', 'panda', 'p.jpg', 'Pandas are a symbol of peace in China.'),
(2, 'Challenge 2', '<html>I am a bird.<br><br> I have the name of a fruit.<br><br> What is my name?<html>', 'kiwi', 'k.png', 'Kiwis are flightless birds.'),
(3, 'Challenge 3', '<html>My laugh resembles that of a hysterical human laughter.<br><br> What animal am I?<html>', 'hyena', 'h.png', 'Hyena: Africa’s most common large carnivore.'),
(4, 'Challenge 4', '<html>I am the largest hopping animal on Earth.<br><br> What animal am I?<html>', 'kangaroo', 'ka.png', 'In one leap they can jump 3m high & 7.6m long.'),
(5, 'Challenge 5', '<html>I eat eucalyptus leaves.<br><br>I live in Australia.<br><br> What animal am I?<html>', 'koala', 'koala.png', 'The koala will eat 2.5 pounds of food a day.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `quiztb`
--
ALTER TABLE `quiztb`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
