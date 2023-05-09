-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 08, 2023 at 05:52 PM
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
-- Table structure for table `facture`
--

CREATE TABLE `facture` (
  `id_facture` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prix` float NOT NULL,
  `date` date NOT NULL,
  `etat` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `facture`
--

INSERT INTO `facture` (`id_facture`, `numero`, `nom`, `prix`, `date`, `etat`, `description`, `image`, `id_utilisateur`) VALUES
(21, 21, 'GTTGS', 23, '2023-02-21', '0', 'GTFTG', 'dd', 1),
(25, 2021, 'aasasas', 20, '2018-01-01', 'good', 'dadaadad', 'd88f03d03ddaf2bba30676d45e102b62.png', 1),
(28, 20, 'sasasa', 2, '2018-01-01', 'assas', 'sasasasasas', '95bd50fc03bd906009568d7236dff67e.png', 1),
(30, 12, 'GTGTG', 20, '2023-03-07', '0', 'GTGT', 'ddd', 1),
(32, 20, 'asaa', 20, '2023-03-07', 'aa', 'zzz', 'zz', 1),
(35, 225, 'fac1', 50, '2023-03-07', 'etat2', 'desc2', 'img2', 1),
(37, 20, 'dd', 20, '2023-03-08', 'dd', 'dd', 'dd', 1),
(38, 20, 'fff', 20, '2023-03-08', 'dd', 'dd', 'dd', 1),
(39, 20, 'dd', 20, '2023-03-08', 'dd', 'dd', 'dd', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id_facture`),
  ADD KEY `fk4` (`id_utilisateur`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `facture`
--
ALTER TABLE `facture`
  MODIFY `id_facture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `fk4` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
