-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 08 mars 2023 à 17:50
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `devapps`
--

-- --------------------------------------------------------

--
-- Structure de la table `reponse_reclamation`
--

CREATE TABLE `reponse_reclamation` (
  `id_reponse` int(11) NOT NULL,
  `sujet` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `id_reclamation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reponse_reclamation`
--

INSERT INTO `reponse_reclamation` (`id_reponse`, `sujet`, `etat`, `date`, `id_reclamation`) VALUES
(14, 'eeoffreeeee', 'traitée', '2023-03-04', 52),
(17, 'dd', 'dd', '2023-03-07', 52),
(18, 'aaa', 'traitée', '2023-03-07', 49),
(19, 'AAA', 'traiter', '2023-03-07', 64),
(20, 'dd', 'traiter', '2023-03-07', 65),
(21, 'AAA', 'traiter', '2023-03-07', 65),
(22, 'aaa', 'bbbb', '2023-03-07', 65),
(23, 'SSSSS', 'traiter', '2023-03-07', 66),
(24, 'ddd', 'dd', '2023-03-07', 52),
(25, 'ddd', 'fff', '2023-03-07', 52),
(26, 'ddd', 'ddd', '2023-03-08', 52),
(27, 'ddd', 'ddd', '2023-03-08', 52),
(28, 'ss', 'ss', '2023-03-08', 52);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `reponse_reclamation`
--
ALTER TABLE `reponse_reclamation`
  ADD PRIMARY KEY (`id_reponse`),
  ADD KEY `fk9` (`id_reclamation`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `reponse_reclamation`
--
ALTER TABLE `reponse_reclamation`
  MODIFY `id_reponse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reponse_reclamation`
--
ALTER TABLE `reponse_reclamation`
  ADD CONSTRAINT `fk9` FOREIGN KEY (`id_reclamation`) REFERENCES `reclamation` (`id_rec`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
