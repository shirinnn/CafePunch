-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 16, 2023 at 11:00 PM
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

--
-- Dumping data for table `staffbids`
--

INSERT INTO `staffbids` (`bID`, `empID`, `wsID`, `status`) VALUES
(1, 'test-03', 1, 'Assigned'),
(3, 'test-01', 2, 'Rejected'),
(5, 'towne.fried', 33, 'Rejected'),
(6, 'test-01', 2, 'Approved'),
(7, 'test-03', 2, 'Approved'),
(8, 'ziemann.lau', 43, 'Approved'),
(9, 'gilda40', 99, 'Assigned'),
(10, 'phayes', 66, 'Approved'),
(11, 'test-01', 64, 'Assigned'),
(12, 'klein.evely', 34, 'Rejected'),
(13, 'fahey.jewel', 70, 'Rejected'),
(14, 'georgiana.g', 1, 'Pending'),
(15, 'felix17', 83, 'Approved'),
(16, 'annabel.kle', 71, 'Pending'),
(17, 'ubaldo93', 82, 'Approved'),
(18, 'wbuckridge', 36, 'Assigned'),
(19, 'mayert.dunc', 82, 'Pending'),
(20, 'runolfsson.', 48, 'Pending'),
(21, 'cameron45', 79, 'Approved'),
(22, 'orin.kunde', 92, 'Assigned'),
(23, 'frank10', 45, 'Rejected'),
(24, 'saul.nitzsc', 11, 'Assigned'),
(25, 'evert.kuhn', 77, 'Rejected'),
(26, 'moshe29', 30, 'Rejected'),
(27, 'barrett.ksh', 9, 'Approved'),
(28, 'daniel.afto', 42, 'Pending'),
(29, 'paige.zieme', 100, 'Assigned'),
(30, 'theidenreic', 69, 'Pending'),
(31, 'fjakubowski', 29, 'Approved'),
(32, 'gdubuque', 95, 'Rejected'),
(33, 'brandy.walt', 73, 'Approved'),
(34, 'megane.spin', 29, 'Pending'),
(35, 'towne.domen', 90, 'Rejected'),
(36, 'prince72prosenbaum', 101, 'Assigned'),
(37, 'wolf.osbald', 69, 'Rejected'),
(38, 'ziemann.lau', 79, 'Rejected'),
(39, 'kihn.rudolp', 82, 'Rejected'),
(40, 'yost.stacy', 85, 'Rejected'),
(41, 'test-03', 54, 'Assigned'),
(42, 'toy.grace', 1, 'Rejected'),
(43, 'theidenreic', 57, 'Approved'),
(44, 'valentin02', 65, 'Pending'),
(45, 'wuckert.lav', 49, 'Rejected'),
(46, 'nasir.hartm', 80, 'Approved'),
(47, 'barrett.ksh', 43, 'Rejected'),
(48, 'herminio.zb', 87, 'Assigned'),
(49, 'bonita.mann', 42, 'Approved'),
(50, 'gleffler', 55, 'Assigned'),
(51, 'orin.kunde', 43, 'Rejected'),
(52, 'emmalee.rut', 49, 'Pending'),
(53, 'ybednar', 44, 'Assigned'),
(54, 'ujaskolskiureichert', 58, 'Approved'),
(55, 'towne.fried', 36, 'Rejected'),
(56, 'ujaskolskiureichert', 67, 'Assigned'),
(57, 'evert.kuhn', 9, 'Pending'),
(58, 'wolf.osbald', 65, 'Pending'),
(59, 'eve.dickens', 7, 'Approved'),
(60, 'nbergstrom', 44, 'Approved'),
(61, 'chills', 31, 'Assigned'),
(62, 'florian98', 16, 'Approved'),
(63, 'orin.kunde', 62, 'Approved'),
(64, 'nbergstrom', 4, 'Pending'),
(65, 'jhagenes', 75, 'Rejected'),
(66, 'megane.spin', 74, 'Rejected'),
(67, 'rippin.lew', 75, 'Approved'),
(68, 'towne.domen', 58, 'Assigned'),
(69, 'theidenreic', 24, 'Approved'),
(70, 'jhagenes', 43, 'Assigned'),
(71, 'jeremy31', 72, 'Assigned'),
(72, 'megane.spin', 44, 'Rejected'),
(73, 'marquis.parmarvin18', 36, 'Assigned'),
(74, 'ashields', 92, 'Pending'),
(75, 'orin.kunde', 32, 'Pending'),
(76, 'wbuckridge', 61, 'Approved'),
(77, 'rosalee90', 99, 'Approved'),
(78, 'little.schu', 59, 'Pending'),
(79, 'nbergstrom', 66, 'Approved'),
(80, 'rosalee90', 75, 'Assigned'),
(81, 'rosalee90', 51, 'Pending'),
(82, 'rau.lon', 55, 'Rejected'),
(83, 'eve.dickens', 98, 'Assigned'),
(84, 'kgleason', 41, 'Pending'),
(85, 'kihn.rudolp', 43, 'Assigned'),
(86, 'little.schu', 78, 'Pending'),
(87, 'rosalee90', 53, 'Pending'),
(88, 'eve.dickens', 38, 'Assigned'),
(89, 'saul.nitzsc', 102, 'Pending'),
(90, 'blanche.zbo', 46, 'Assigned'),
(91, 'emmalee.rut', 36, 'Pending'),
(92, 'mayert.dunc', 88, 'Pending'),
(93, 'phoebe59', 94, 'Approved'),
(94, 'fahey.jewel', 95, 'Rejected'),
(95, 'daniel.afto', 32, 'Rejected'),
(96, 'gdubuque', 14, 'Assigned'),
(97, 'nathanial.g', 50, 'Rejected'),
(98, 'olson.lilia', 102, 'Rejected'),
(99, 'test-01', 102, 'Pending'),
(100, 'jeremy31', 98, 'Pending'),
(101, 'test-04', 8, 'Pending'),
(102, 'test-04', 3, 'Pending');

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
('annabel.kle', 'Cashier', 5, 1),
('armstrong.t', 'Chef', 6, 3),
('ashields', 'Chef', 5, 2),
('barrett.ksh', 'Chef', 5, 2),
('blanche.zbo', 'Chef', 6, 4),
('bonita.mann', 'Chef', 4, 3),
('brandy.walt', 'Waiter', 4, 3),
('cameron45', 'Chef', 6, 2),
('chills', 'Waiter', 4, 4),
('crooks.euni', 'Cashier', 5, 1),
('daniel.afto', 'Cashier', 6, 2),
('demarcus42', 'Chef', 4, 4),
('deven30', 'Waiter', 6, 1),
('dexter.bore', 'Cashier', 4, 3),
('elinor.beck', 'Chef', 4, 3),
('elwyn00', 'Chef', 4, 1),
('emard.adell', 'Cashier', 6, 1),
('emmalee.rut', 'Cashier', 5, 1),
('eve.dickens', 'Cashier', 4, 3),
('evert.kuhn', 'Waiter', 6, 3),
('fabiola.doo', 'Waiter', 6, 1),
('fahey.jewel', 'Cashier', 5, 2),
('fanny.durga', 'Cashier', 5, 3),
('felix17', 'Cashier', 6, 1),
('fern.padber', 'Waiter', 4, 2),
('fjakubowski', 'Chef', 6, 3),
('florence45', 'Chef', 6, 3),
('florian98', 'Waiter', 6, 3),
('frank10', 'Chef', 5, 1),
('gdubuque', 'Cashier', 4, 4),
('georgiana.g', 'Chef', 6, 2),
('gibson.lore', 'Chef', 6, 4),
('gilda40', 'Waiter', 6, 3),
('gleffler', 'Chef', 4, 4),
('herminio.zb', 'Waiter', 5, 2),
('ireilly', 'Waiter', 4, 3),
('jacquelyn49', 'Waiter', 6, 2),
('jeremy31', 'Cashier', 6, 2),
('jhagenes', 'Cashier', 5, 4),
('johns.olen', 'Chef', 4, 1),
('jzboncak', 'Chef', 5, 3),
('kgleason', 'Chef', 6, 2),
('kihn.rudolp', 'Waiter', 4, 3),
('klein.evely', 'Waiter', 5, 2),
('lawson.paco', 'Waiter', 4, 1),
('legros.leop', 'Chef', 4, 1),
('little.schu', 'Chef', 5, 3),
('marquis.par', 'Waiter', 4, 2),
('mayert.dunc', 'Chef', 4, 4),
('megane.spin', 'Waiter', 4, 3),
('moshe29', 'Cashier', 4, 2),
('nasir.hartm', 'Chef', 6, 1),
('nathanial.g', 'Waiter', 4, 3),
('nbergstrom', 'Chef', 6, 3),
('nicolas.ros', 'Chef', 4, 3),
('nora66', 'Cashier', 4, 3),
('o\'hara.dann', 'Waiter', 6, 1),
('olson.lilia', 'Chef', 5, 4),
('orin.kunde', 'Waiter', 4, 1),
('osinski.sal', 'Chef', 5, 4),
('paige.zieme', 'Chef', 6, 3),
('pat.doyle', 'Cashier', 6, 3),
('patricia40', 'Waiter', 5, 1),
('phayes', 'Waiter', 5, 2),
('phoebe59', 'Chef', 5, 2),
('prince72pro', 'Cashier', 5, 2),
('ptremblay', 'Chef', 4, 2),
('qaufderhar', 'Chef', 4, 3),
('rau.lon', 'Cashier', 5, 4),
('raynor.blan', 'Cashier', 6, 3),
('rippin.lew', 'Chef', 6, 2),
('robb.lakin', 'Waiter', 5, 1),
('rosalee90', 'Chef', 4, 2),
('runolfsson.', 'Cashier', 6, 2),
('saul.nitzsc', 'Cashier', 4, 4),
('schmitt.sav', 'Chef', 6, 4),
('schuster.da', 'Cashier', 4, 3),
('smitham.ded', 'Chef', 6, 4),
('test-01', 'Waiter', 4, 2),
('test-03', 'Waiter', 5, 3),
('test-04', 'Chef', 6, 6),
('theidenreic', 'Waiter', 5, 1),
('towne.domen', 'Cashier', 4, 2),
('towne.fried', 'Chef', 5, 1),
('toy.grace', 'Cashier', 5, 1),
('treutel.sam', 'Waiter', 5, 1),
('tyshawn01', 'Cashier', 6, 3),
('ubaldo93', 'Chef', 6, 4),
('ujaskolskiu', 'Chef', 6, 2),
('valentin02', 'Waiter', 5, 3),
('vonrueden.m', 'Waiter', 6, 2),
('wbuckridge', 'Cashier', 6, 4),
('wolf.osbald', 'Waiter', 5, 3),
('wstamm', 'Chef', 4, 2),
('wuckert.lav', 'Chef', 4, 3),
('ybednar', 'Waiter', 4, 4),
('yost.stacy', 'Waiter', 5, 2),
('yyost', 'Chef', 4, 4),
('zackary.kau', 'Waiter', 4, 4),
('ziemann.lau', 'Cashier', 4, 3);

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
('admin', 'Admin', 'Person1', 'admin@admin.com', 'M', '123456', 5, 'Active'),
('annabel.kle', 'Brianne', 'Weber', 'alberta78@example.net', 'F', '123456', 3, 'Active'),
('armstrong.t', 'Corene', 'McCullough', 'edmond.mohr@example.net', 'F', '123456', 3, 'Active'),
('ashields', 'Norene', 'Jerde', 'berniece91@example.com', 'M', '123456', 3, 'Active'),
('barrett.ksh', 'Betsy', 'Bosco', 'khansen@example.com', 'F', '123456', 3, 'Active'),
('blanche.zbo', 'Ava', 'Rice', 'danielle25@example.com', 'F', '123456', 3, 'Active'),
('bonita.mann', 'Faye', 'Funk', 'rice.geoffrey@example.com', 'F', '123456', 3, 'Active'),
('brandy.walt', 'Cameron', 'Ondricka', 'reyes.braun@example.net', 'M', '123456', 3, 'Active'),
('cameron45', 'Dominic', 'Maggio', 'feest.dorothy@example.net', 'F', '123456', 3, 'Active'),
('chills', 'Breanne', 'Schmeler', 'donna.kerluke@example.com', 'F', '123456', 3, 'Active'),
('crooks.euni', 'Dayne', 'Schaden', 'laisha.schultz@example.net', 'M', '123456', 3, 'Active'),
('daniel.afto', 'Cora', 'Turcotte', 'ankunding.una@example.com', 'M', '123456', 3, 'Active'),
('demarcus42', 'Fernando', 'Emmerich', 'ottilie91@example.net', 'F', '123456', 3, 'Active'),
('deven30', 'Beatrice', 'Hahn', 'kennedi13@example.com', 'M', '123456', 3, 'Active'),
('dexter.bore', 'Clare', 'Graham', 'heller.jovany@example.net', 'F', '123456', 3, 'Active'),
('elinor.beck', 'Ophelia', 'Boehm', 'randal.bruen@example.com', 'F', '123456', 3, 'Active'),
('elwyn00', 'Keanu', 'Wolff', 'windler.dallin@example.com', 'M', '123456', 3, 'Active'),
('emard.adell', 'Sabryna', 'Will', 'kenyatta.breitenberg@example.com', 'F', '123456', 3, 'Active'),
('emmalee.rut', 'Lonie', 'O\'Reilly', 'bosco.linda@example.org', 'F', '123456', 3, 'Active'),
('eve.dickens', 'Kattie', 'Tromp', 'marley08@example.net', 'M', '123456', 3, 'Active'),
('evert.kuhn', 'Willa', 'Rosenbaum', 'ubode@example.org', 'M', '123456', 3, 'Active'),
('fabiola.doo', 'Kendrick', 'Eichmann', 'collier.heidi@example.org', 'M', '123456', 3, 'Active'),
('fahey.jewel', 'Betty', 'Christianse', 'xbaumbach@example.com', 'M', '123456', 3, 'Active'),
('fanny.durga', 'Pat', 'Zulauf', 'toy.murray@example.com', 'F', '123456', 3, 'Active'),
('felix17', 'Joshuah', 'Sauer', 'volkman.eldred@example.net', 'M', '123456', 3, 'Active'),
('fern.padber', 'Lane', 'Lubowitz', 'marguerite.morissette@example.com', 'M', '123456', 3, 'Active'),
('fjakubowski', 'Ricky', 'Marquardt', 'martine.kshlerin@example.com', 'F', '123456', 3, 'Active'),
('florence45', 'Simeon', 'McKenzie', 'brogahn@example.com', 'M', '123456', 3, 'Active'),
('florian98', 'Bernard', 'Ullrich', 'krajcik.amber@example.net', 'F', '123456', 3, 'Active'),
('frank10', 'Devyn', 'Durgan', 'muriel.monahan@example.org', 'F', '123456', 3, 'Active'),
('gdubuque', 'Marian', 'Lubowitz', 'shanie11@example.com', 'F', '123456', 3, 'Active'),
('georgiana.g', 'Darrin', 'Douglas', 'mills.raymond@example.net', 'F', '123456', 3, 'Active'),
('gibson.lore', 'Alvah', 'Ryan', 'ilittel@example.com', 'F', '123456', 3, 'Active'),
('gilda40', 'Jarret', 'Bergnaum', 'felicia65@example.org', 'F', '123456', 3, 'Active'),
('gleffler', 'Kaylee', 'Swaniawski', 'adams.reba@example.net', 'F', '123456', 3, 'Active'),
('herminio.zb', 'Rudy', 'Hartmann', 'rdibbert@example.org', 'M', '123456', 3, 'Active'),
('ireilly', 'Tabitha', 'Mayert', 'hferry@example.org', 'M', '123456', 3, 'Active'),
('jacquelyn49', 'Carmen', 'Legros', 'anastasia.sawayn@example.org', 'M', '123456', 3, 'Active'),
('jeremy31', 'Libbie', 'Kilback', 'stracke.waldo@example.org', 'F', '123456', 3, 'Active'),
('jhagenes', 'Leora', 'Sanford', 'pink.steuber@example.net', 'F', '123456', 3, 'Active'),
('johns.olen', 'Myron', 'Bernhard', 'miller.theresia@example.com', 'M', '123456', 3, 'Active'),
('jzboncak', 'Gage', 'Wisoky', 'aida.dare@example.net', 'M', '123456', 3, 'Active'),
('kgleason', 'Cedrick', 'Beier', 'hirthe.shaun@example.net', 'F', '123456', 3, 'Active'),
('kihn.rudolp', 'Brisa', 'Jacobs', 'runolfsson.ezequiel@example.net', 'F', '123456', 3, 'Active'),
('klein.evely', 'Justine', 'Kunde', 'rcummerata@example.org', 'M', '123456', 3, 'Active'),
('lawson.paco', 'Stewart', 'Ryan', 'ukessler@example.org', 'F', '123456', 3, 'Active'),
('legros.leop', 'Maxine', 'Harber', 'mazie41@example.org', 'M', '123456', 3, 'Active'),
('little.schu', 'Mallory', 'Watsica', 'gottlieb.jordane@example.net', 'F', '123456', 3, 'Active'),
('M-001', 'Noah', 'Han', 'hannoah@gmail.com', 'M', '123456', 2, 'Active'),
('marquis.par', 'Devon', 'Sanford', 'kennith44@example.net', 'F', '123456', 3, 'Active'),
('marvin18', 'Yvette', 'Stamm', 'okuphal@example.org', 'F', '123456', 3, 'Active'),
('mayert.dunc', 'Faye', 'Stokes', 'wilfredo17@example.com', 'F', '123456', 3, 'Active'),
('megane.spin', 'Kale', 'Rowe', 'wcorwin@example.com', 'M', '123456', 3, 'Active'),
('moshe29', 'Maryjane', 'West', 'mlegros@example.org', 'F', '123456', 3, 'Active'),
('nasir.hartm', 'D\'angelo', 'Lueilwitz', 'christy21@example.com', 'M', '123456', 3, 'Active'),
('nathanial.g', 'Baylee', 'Hagenes', 'ardith06@example.net', 'F', '123456', 3, 'Active'),
('nbergstrom', 'Mohammad', 'Erdman', 'samantha.rowe@example.com', 'M', '123456', 3, 'Active'),
('nicolas.ros', 'Helga', 'Herman', 'elvie.kihn@example.net', 'M', '123456', 3, 'Active'),
('nora66', 'Katarina', 'Feest', 'leilani92@example.net', 'F', '123456', 3, 'Active'),
('o\'hara.dann', 'Edgardo', 'Harber', 'lou61@example.net', 'F', '123456', 3, 'Active'),
('olson.lilia', 'Norberto', 'Ferry', 'crooks.edna@example.net', 'F', '123456', 3, 'Active'),
('orin.kunde', 'Murl', 'Graham', 'garrett09@example.org', 'M', '123456', 3, 'Active'),
('osinski.sal', 'Judson', 'Aufderhar', 'alfredo74@example.com', 'M', '123456', 3, 'Active'),
('paige.zieme', 'Cloyd', 'Spencer', 'weimann.rhianna@example.com', 'F', '123456', 3, 'Active'),
('pat.doyle', 'Alessandro', 'Zemlak', 'emmett.mcdermott@example.org', 'M', '123456', 3, 'Active'),
('patricia40', 'Bailee', 'Conn', 'lkerluke@example.org', 'F', '123456', 3, 'Active'),
('phayes', 'Sasha', 'Mitchell', 'jameson.bogisich@example.org', 'M', '123456', 3, 'Active'),
('phoebe59', 'Cathrine', 'Schmeler', 'hauck.guido@example.org', 'F', '123456', 3, 'Active'),
('prince72', 'Bobby', 'Pollich', 'xpagac@example.com', 'M', '123456', 3, 'Active'),
('prosenbaum', 'Donavon', 'Mills', 'rene.rolfson@example.net', 'F', '123456', 3, 'Active'),
('ptremblay', 'Micheal', 'Paucek', 'ypfannerstill@example.com', 'F', '123456', 3, 'Active'),
('qaufderhar', 'Monty', 'Crooks', 'boehm.meredith@example.net', 'F', '123456', 3, 'Active'),
('rau.lon', 'Braulio', 'Ortiz', 'litzy40@example.org', 'F', '123456', 3, 'Active'),
('raynor.blan', 'Bernhard', 'Howell', 'carmela05@example.org', 'F', '123456', 3, 'Active'),
('rippin.lew', 'Wilma', 'McCullough', 'hgutkowski@example.net', 'M', '123456', 3, 'Active'),
('robb.lakin', 'Lula', 'Hodkiewicz', 'rlemke@example.com', 'M', '123456', 3, 'Active'),
('rosalee90', 'Carmela', 'Tromp', 'shad.heathcote@example.org', 'M', '123456', 3, 'Active'),
('runolfsson.', 'Norberto', 'Marks', 'bartell.destinee@example.net', 'F', '123456', 3, 'Active'),
('saul.nitzsc', 'Noemy', 'Bradtke', 'leif81@example.net', 'M', '123456', 3, 'Active'),
('schmitt.sav', 'Leonora', 'Weimann', 'davon.beatty@example.net', 'M', '123456', 3, 'Active'),
('schuster.da', 'Kaylee', 'Kulas', 'fritz67@example.org', 'F', '123456', 3, 'Active'),
('smitham.ded', 'Kailyn', 'Paucek', 'elfrieda.mertz@example.com', 'M', '123456', 3, 'Active'),
('test-01', 'TestFirst', 'TestLast1', 'test@test.com', 'F', '123456', 3, 'Active'),
('test-02', 'Test2', 'Test2-1', 'test@test2.com', 'M', '123456', 2, 'Suspend'),
('test-03', 'Sarah', 'Tan', 'sarahtan@test.com', 'F', '123456', 3, 'Active'),
('test-04', 'Kelvin', 'Han', 'kHan@gmail.com', 'M', '123456', 3, 'Active'),
('Test3', 'Ronald', 'Mac', 'ronmac@google.com', 'M', '123456', 1, 'Active'),
('theidenreic', 'Oscar', 'Jakubowski', 'christ.wolf@example.net', 'F', '123456', 3, 'Active'),
('towne.domen', 'Ervin', 'Orn', 'marjorie.wisozk@example.net', 'F', '123456', 3, 'Active'),
('towne.fried', 'Rebeca', 'Zulauf', 'marcel.keebler@example.net', 'M', '123456', 3, 'Active'),
('toy.grace', 'Rebeka', 'Wisoky', 'ahmed25@example.com', 'F', '123456', 3, 'Active'),
('treutel.sam', 'Peter', 'Prohaska', 'ceasar.o\'hara@example.org', 'F', '123456', 3, 'Active'),
('tyshawn01', 'Dahlia', 'Upton', 'bcummerata@example.com', 'M', '123456', 3, 'Active'),
('ubaldo93', 'Newell', 'Hartmann', 'gregory53@example.org', 'F', '123456', 3, 'Active'),
('ujaskolski', 'Javon', 'Kuhn', 'bins.yazmin@example.org', 'M', '123456', 3, 'Active'),
('ureichert', 'Lucienne', 'O\'Conner', 'alden61@example.net', 'M', '123456', 3, 'Active'),
('valentin02', 'Aiden', 'Erdman', 'florence53@example.com', 'F', '123456', 3, 'Active'),
('vonrueden.m', 'Geovanni', 'Veum', 'emmie48@example.org', 'M', '123456', 3, 'Active'),
('wbuckridge', 'Kaitlin', 'Konopelski', 'abraham41@example.org', 'F', '123456', 3, 'Active'),
('wolf.osbald', 'Bettie', 'Hegmann', 'rheaney@example.net', 'M', '123456', 3, 'Active'),
('wstamm', 'Josefina', 'Kunde', 'davon.kessler@example.com', 'F', '123456', 3, 'Active'),
('wuckert.lav', 'Dannie', 'Hegmann', 'xcollier@example.com', 'F', '123456', 3, 'Active'),
('ybednar', 'Toy', 'O\'Connell', 'crolfson@example.net', 'F', '123456', 3, 'Active'),
('yost.stacy', 'Alta', 'Borer', 'elwyn.rowe@example.com', 'F', '123456', 3, 'Active'),
('yyost', 'Mozell', 'Feest', 'aklein@example.com', 'F', '123456', 3, 'Active'),
('zackary.kau', 'Kianna', 'Homenick', 'kschmeler@example.org', 'M', '123456', 3, 'Active'),
('ziemann.lau', 'Gunner', 'McCullough', 'beahan.sierra@example.org', 'F', '123456', 3, 'Active');

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
(5, 'Admin', 'Admin');

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
(1, '2023-10-23', '08:00', '21:00', 1, 2, 2),
(2, '2023-11-01', '09:00', '21:00', 1, 0, 2),
(3, '2023-11-18', '09:00', '21:00', 3, 1, 1),
(4, '2023-12-03', '09:00', '23:00', 3, 1, 1),
(5, '2023-11-27', '10:00', '22:00', 2, 2, 3),
(6, '2023-11-30', '07:00', '21:00', 1, 3, 3),
(7, '2023-11-28', '09:00', '21:00', 2, 3, 3),
(8, '2023-12-07', '10:00', '23:00', 2, 2, 2),
(9, '2023-11-27', '07:00', '23:00', 1, 2, 1),
(10, '2023-12-11', '10:00', '23:00', 2, 1, 2),
(11, '2023-12-04', '09:00', '21:00', 3, 1, 1),
(12, '2023-11-22', '07:00', '21:00', 1, 3, 3),
(13, '2023-12-09', '09:00', '22:00', 1, 2, 1),
(14, '2023-11-18', '09:00', '21:00', 1, 1, 3),
(15, '2023-12-20', '09:00', '22:00', 3, 1, 2),
(16, '2023-11-19', '08:00', '22:00', 2, 3, 2),
(17, '2023-11-19', '10:00', '23:00', 1, 1, 2),
(18, '2023-12-04', '10:00', '20:00', 3, 2, 1),
(19, '2023-11-18', '11:00', '22:00', 1, 3, 3),
(20, '2023-12-06', '10:00', '23:00', 2, 1, 1),
(21, '2023-11-21', '08:00', '22:00', 1, 3, 2),
(22, '2023-12-07', '08:00', '23:00', 3, 3, 3),
(23, '2023-12-07', '09:00', '22:00', 2, 1, 2),
(24, '2023-11-26', '11:00', '21:00', 1, 2, 3),
(25, '2023-11-18', '08:00', '23:00', 2, 2, 2),
(26, '2023-12-04', '10:00', '23:00', 2, 3, 3),
(27, '2023-12-12', '07:00', '20:00', 1, 3, 1),
(28, '2023-12-17', '08:00', '22:00', 1, 2, 1),
(29, '2023-12-14', '10:00', '21:00', 3, 2, 3),
(30, '2023-12-06', '07:00', '20:00', 2, 1, 2),
(31, '2023-11-24', '10:00', '21:00', 3, 1, 3),
(32, '2023-11-19', '08:00', '22:00', 1, 1, 2),
(33, '2023-11-23', '07:00', '20:00', 3, 2, 2),
(34, '2023-11-28', '09:00', '20:00', 2, 1, 2),
(35, '2023-12-19', '08:00', '21:00', 2, 3, 3),
(36, '2023-12-13', '09:00', '20:00', 2, 3, 3),
(37, '2023-12-20', '11:00', '21:00', 2, 1, 1),
(38, '2023-11-21', '10:00', '22:00', 3, 2, 2),
(39, '2023-11-20', '08:00', '23:00', 3, 1, 2),
(40, '2023-12-01', '09:00', '23:00', 1, 2, 1),
(41, '2023-11-29', '08:00', '21:00', 2, 3, 3),
(42, '2023-11-28', '09:00', '21:00', 1, 2, 2),
(43, '2023-12-11', '09:00', '22:00', 2, 1, 2),
(44, '2023-12-14', '11:00', '22:00', 2, 3, 3),
(45, '2023-12-12', '10:00', '21:00', 2, 2, 2),
(46, '2023-11-18', '07:00', '21:00', 3, 2, 3),
(47, '2023-11-28', '08:00', '23:00', 3, 1, 2),
(48, '2023-11-20', '11:00', '23:00', 1, 3, 3),
(49, '2023-11-21', '10:00', '23:00', 2, 1, 2),
(50, '2023-12-16', '09:00', '20:00', 3, 2, 3),
(51, '2023-11-24', '08:00', '20:00', 1, 2, 3),
(52, '2023-12-03', '10:00', '21:00', 1, 1, 2),
(53, '2023-12-17', '11:00', '22:00', 2, 1, 3),
(54, '2023-11-26', '10:00', '23:00', 3, 2, 2),
(55, '2023-11-21', '10:00', '20:00', 3, 3, 2),
(56, '2023-12-07', '07:00', '21:00', 1, 2, 1),
(57, '2023-12-10', '11:00', '20:00', 2, 1, 3),
(58, '2023-11-19', '07:00', '21:00', 1, 2, 3),
(59, '2023-11-26', '08:00', '21:00', 1, 3, 3),
(60, '2023-11-26', '09:00', '22:00', 3, 2, 1),
(61, '2023-11-26', '07:00', '23:00', 2, 1, 1),
(62, '2023-11-23', '11:00', '22:00', 2, 1, 3),
(63, '2023-12-11', '11:00', '20:00', 1, 3, 1),
(64, '2023-12-11', '08:00', '20:00', 1, 2, 3),
(65, '2023-12-06', '09:00', '23:00', 3, 2, 1),
(66, '2023-12-07', '08:00', '21:00', 2, 3, 3),
(67, '2023-12-03', '07:00', '23:00', 1, 3, 3),
(68, '2023-11-21', '11:00', '21:00', 2, 1, 3),
(69, '2023-11-30', '07:00', '22:00', 3, 1, 2),
(70, '2023-11-27', '10:00', '21:00', 2, 1, 1),
(71, '2023-12-08', '07:00', '22:00', 3, 2, 2),
(72, '2023-11-23', '08:00', '21:00', 1, 2, 2),
(73, '2023-11-22', '07:00', '23:00', 2, 1, 1),
(74, '2023-11-25', '10:00', '21:00', 2, 3, 1),
(75, '2023-12-16', '07:00', '21:00', 1, 2, 2),
(76, '2023-11-20', '10:00', '22:00', 3, 1, 1),
(77, '2023-12-15', '08:00', '22:00', 3, 2, 3),
(78, '2023-12-08', '09:00', '23:00', 1, 2, 3),
(79, '2023-12-10', '07:00', '21:00', 2, 1, 2),
(80, '2023-12-12', '10:00', '20:00', 2, 3, 3),
(81, '2023-11-22', '08:00', '20:00', 2, 2, 1),
(82, '2023-12-15', '09:00', '22:00', 1, 3, 2),
(83, '2023-11-29', '07:00', '20:00', 2, 1, 3),
(84, '2023-11-26', '09:00', '22:00', 3, 3, 3),
(85, '2023-12-04', '08:00', '22:00', 2, 2, 2),
(86, '2023-11-20', '09:00', '22:00', 3, 1, 3),
(87, '2023-12-02', '11:00', '20:00', 2, 2, 3),
(88, '2023-11-25', '10:00', '21:00', 1, 1, 2),
(89, '2023-12-16', '08:00', '22:00', 1, 3, 2),
(90, '2023-12-12', '08:00', '21:00', 2, 3, 3),
(91, '2023-12-14', '07:00', '22:00', 2, 2, 3),
(92, '2023-11-27', '07:00', '23:00', 2, 3, 3),
(93, '2023-12-01', '09:00', '23:00', 3, 2, 3),
(94, '2023-12-14', '07:00', '21:00', 1, 1, 2),
(95, '2023-12-09', '07:00', '22:00', 2, 1, 3),
(96, '2023-11-23', '07:00', '21:00', 1, 2, 2),
(97, '2023-12-09', '08:00', '23:00', 3, 2, 3),
(98, '2023-12-16', '08:00', '23:00', 2, 3, 2),
(99, '2023-11-28', '11:00', '22:00', 3, 3, 3),
(100, '2023-12-05', '08:00', '21:00', 3, 1, 3),
(101, '2023-12-17', '11:00', '21:00', 1, 2, 2),
(102, '2023-12-02', '09:00', '21:00', 2, 1, 1),
(103, '2023-11-30', '09:00', '23:00', 3, 1, 3),
(104, '2023-11-20', '11:00', '22:00', 2, 3, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `staffbids`
--
ALTER TABLE `staffbids`
  ADD PRIMARY KEY (`bID`);

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
-- AUTO_INCREMENT for table `staffbids`
--
ALTER TABLE `staffbids`
  MODIFY `bID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT for table `userprofiles`
--
ALTER TABLE `userprofiles`
  MODIFY `profileID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `workslots`
--
ALTER TABLE `workslots`
  MODIFY `wsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
