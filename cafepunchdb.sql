-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 14, 2023 at 05:47 AM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cafepunchdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `staffbids`
--

CREATE TABLE `staffbids` (
  `bID` int(11) NOT NULL,
  `empID` varchar(20) NOT NULL,
  `wsID` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `staffs`
--

CREATE TABLE `staffs` (
  `empID` varchar(11) NOT NULL,
  `role` varchar(11) NOT NULL,
  `maxWorkSlot` int(11) NOT NULL,
  `availableWorkSlot` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staffs`
--

INSERT INTO `staffs` (`empID`, `role`, `maxWorkSlot`, `availableWorkSlot`) VALUES
('test-01', 'Waiter', 4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `useraccounts`
--

CREATE TABLE `useraccounts` (
  `empID` varchar(11) NOT NULL,
  `firstName` varchar(11) NOT NULL,
  `lastName` varchar(11) NOT NULL,
  `email` text NOT NULL,
  `gender` varchar(1) NOT NULL,
  `password` varchar(20) NOT NULL,
  `profileID` int(11) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `useraccounts`
--

INSERT INTO `useraccounts` (`empID`, `firstName`, `lastName`, `email`, `gender`, `password`, `profileID`, `status`) VALUES
('A-001', 'Jun', 'Choi', 'junnie@gmail.com', 'M', '123456', 1, 'Active'),
('M-001', 'Noah', 'Han', 'hannoah@gmail.com', 'M', '123456', 2, 'Active'),
('test-01', 'TestFirst', 'TestLast1', 'test@test.com', 'F', '123456', 3, 'Active'),
('test-02', 'Test2', 'Test2-1', 'test@test2.com', 'M', '12345', 2, 'Suspend'),
('Test3', 'Ronald', 'Mac', 'ronmac@google.com', 'M', '12345', 1, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `userprofiles`
--

CREATE TABLE `userprofiles` (
  `profileID` int(11) NOT NULL,
  `profileName` varchar(20) NOT NULL,
  `permissionType` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userprofiles`
--

INSERT INTO `userprofiles` (`profileID`, `profileName`, `permissionType`) VALUES
(1, 'Cafe Owner', 'Owner'),
(2, 'Cafe Manager', 'Manager'),
(3, 'Full Timer Staff', 'Staff'),
(5, 'TestStaff1', 'Staff');

-- --------------------------------------------------------

--
-- Table structure for table `workslots`
--

CREATE TABLE `workslots` (
  `wsID` int(11) NOT NULL,
  `date` varchar(20) NOT NULL,
  `startTime` varchar(11) NOT NULL,
  `endTime` varchar(11) NOT NULL,
  `noOfCashier` int(11) NOT NULL,
  `noOfChef` int(11) NOT NULL,
  `noOfWaiter` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `workslots`
--

INSERT INTO `workslots` (`wsID`, `date`, `startTime`, `endTime`, `noOfCashier`, `noOfChef`, `noOfWaiter`) VALUES
(1, '2023-10-23', '08:00', '21:00', 1, 2, 4),
(2, '2023-11-01', '09:00', '21:00', 1, 1, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `staffs`
--
ALTER TABLE `staffs`
  ADD PRIMARY KEY (`empID`);

--
-- Indexes for table `useraccounts`
--
ALTER TABLE `useraccounts`
  ADD PRIMARY KEY (`empID`);

--
-- Indexes for table `userprofiles`
--
ALTER TABLE `userprofiles`
  ADD PRIMARY KEY (`profileID`);

--
-- Indexes for table `workslots`
--
ALTER TABLE `workslots`
  ADD PRIMARY KEY (`wsID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `userprofiles`
--
ALTER TABLE `userprofiles`
  MODIFY `profileID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `workslots`
--
ALTER TABLE `workslots`
  MODIFY `wsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
