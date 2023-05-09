-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 08 mars 2023 à 17:56
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

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
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT 'USER',
  `age` date NOT NULL,
  `username` varchar(255) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `bloquer` int(11) NOT NULL DEFAULT 0,
  `code` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `password`, `email`, `adresse`, `role`, `age`, `username`, `photo`, `bloquer`, `code`) VALUES
(144, 'mama', 'mama', 'xdYBVs0YI1vdyO+3T6ZfXQ==', 'mama@mama.com', 'houmt 9ouraych', 'ROLE_USER', '2018-01-01', 'mamma', 'aebccda2b4040db02a7531cd3329659c.jpg', 1, NULL),
(162, 'baha', 'baha', 'Qb5pjYEpx1ChrL5RE/+/xA==', 'gg', '789 rue palastine', 'ROLE_USER', '2018-01-01', 'baha', 'e7203d782eec040f478fbc0adbc8449d.jpg', 0, 9458),
(168, 'mohamed', 'mejdi', 'V+69VS2l9KUJUBtsNGsEFw==', 'ss', 'rue palastineee', 'ROLE_USER', '2001-05-25', '9a39a3', 'iiiilll', 1, NULL),
(173, 'esprance sportive de tunis ', 'esprance sportive de tunis ', 'GJKxP41HzXH0lVJTtxm28w==', 'esprance sportive de tunis ', 'esprance sportive de tunis ', 'ROLE_USER', '1919-01-19', 'esprance sportive de tunis ', 'esprance sportive de tunis ', 1, NULL),
(175, 'mejdi', 'mohamed', 'm5osfXWm3bf0sRntZeILPA==', 'mejdi.mohamed@esprit.tn', 'houmt 9ouraych', 'ROLE_USER', '2019-01-01', 'Hama', 'e846fabe39541b51eee54069a1589482.jpg', 1, 4552);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=176;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
