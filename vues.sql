-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2017 at 07:42 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vues`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` varchar(10) DEFAULT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `password`) VALUES
('11111', 'ADMIN', '4321');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `name` varchar(30) DEFAULT NULL,
  `id` int(10) NOT NULL,
  `fee` int(10) NOT NULL DEFAULT '15000',
  `credit` int(10) NOT NULL DEFAULT '3',
  `capacity` int(10) DEFAULT '40',
  `dept` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`name`, `id`, `fee`, `credit`, `capacity`, `dept`) VALUES
('Java', 123, 15000, 3, 60, 'cse'),
('C#', 124, 15000, 3, 40, 'cse'),
('C', 125, 15000, 3, 40, 'cse'),
('Algorithms', 127, 15000, 3, 40, 'cse'),
('Operating System', 128, 15000, 3, 40, 'cse'),
('Theory Of Computation', 129, 15000, 3, 40, 'cse'),
('Computer Networks', 130, 15000, 3, 60, 'cse'),
('OOAD', 131, 15000, 3, 40, 'cse'),
('Adv. Computer Networks', 132, 15000, 3, 60, 'cse'),
('Computer Graphics', 133, 15000, 3, 40, 'cse'),
('ATP I', 134, 15000, 3, 40, 'cse'),
('ATP II', 135, 15000, 3, 40, 'cse'),
('ATP III', 136, 15000, 3, 40, 'cse'),
('Embedded Software', 137, 15000, 3, 40, 'cse'),
('Software Engineering', 138, 15000, 3, 40, 'cse'),
('Soft. Quality Testing', 139, 15000, 3, 40, 'cse'),
('Compiler Design', 140, 15000, 3, 40, 'cse'),
('VLSI Designing', 141, 15000, 3, 40, 'cse'),
('Electrical Circuits I', 142, 15000, 3, 40, 'eee'),
('Electrical Circuits II', 143, 15000, 3, 40, 'eee'),
('DLD', 144, 15000, 3, 40, 'eee'),
('Electronic Device', 145, 15000, 3, 40, 'eee'),
('DEC', 146, 15000, 3, 40, 'eee'),
('Microprocessor', 147, 15000, 3, 40, 'eee'),
('Electrical Machine I', 148, 15000, 3, 40, 'eee');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(10) NOT NULL,
  `password` varchar(30) NOT NULL,
  `answer` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `dept` varchar(10) NOT NULL,
  `course1` varchar(30) DEFAULT NULL,
  `course2` varchar(30) DEFAULT NULL,
  `course3` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `password`, `answer`, `name`, `dept`, `course1`, `course2`, `course3`) VALUES
(102, 'dada', 'RED', 'Tawhid', 'cse', 'ATP I', 'ATP II', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(10) NOT NULL,
  `password` varchar(30) NOT NULL,
  `answer` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `dept` varchar(10) NOT NULL,
  `salary` int(10) DEFAULT NULL,
  `course1` varchar(30) NOT NULL,
  `course2` varchar(30) NOT NULL,
  `course3` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `password`, `answer`, `name`, `dept`, `salary`, `course1`, `course2`, `course3`) VALUES
(231, 'tdtda', 'abc', 'das', 'cse', 50000, 'OOAD', 'Algorithms', 'Computer Graphics'),
(241, 'dsds', 'sdsd', 'sdds', 'dscs', 60000, 'ATP I', 'ATP II', 'ATP III');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=149;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=242;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
