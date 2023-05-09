-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 08, 2023 at 05:53 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `devapps`
--

-- --------------------------------------------------------

--
-- Table structure for table `finance`
--

CREATE TABLE `finance` (
  `id` int(11) NOT NULL,
  `taxe` float NOT NULL,
  `tva` int(11) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `prix` float NOT NULL,
  `etat` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `id_facture` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `finance`
--

INSERT INTO `finance` (`id`, `taxe`, `tva`, `photo`, `prix`, `etat`, `date`, `id_facture`) VALUES
(2, 0, 44, '20', 0, 'paid', '2018-01-01', 21),
(3, 120, 20, 'adda', 203, 'payee', '2025-01-01', 21),
(14, 22, 10, 'hhh', 20, 'fgjh', '2023-03-07', 21),
(16, 2, 20, 'aa', 20, 'aa', '2023-03-07', 21),
(18, 5, 55, 'fdq', 0, 'qdfsk', '2023-03-08', 35),
(19, 20, 20, 'dd', 20, 'dd', '2023-03-08', 32),
(20, 12, 12, 'ddd', 20, 'dd', '2023-03-08', 21);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `finance`
--
ALTER TABLE `finance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk3` (`id_facture`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `finance`
--
ALTER TABLE `finance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `finance`
--
ALTER TABLE `finance`
  ADD CONSTRAINT `fk3` FOREIGN KEY (`id_facture`) REFERENCES `facture` (`id_facture`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
