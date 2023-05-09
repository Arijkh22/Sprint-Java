-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 08 mars 2023 à 18:17
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
-- Structure de la table `reponse_offre`
--

CREATE TABLE `reponse_offre` (
  `id` int(11) NOT NULL,
  `nom_produit` varchar(255) NOT NULL,
  `budget` float NOT NULL,
  `Etat` varchar(255) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `id_offre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reponse_offre`
--

INSERT INTO `reponse_offre` (`id`, `nom_produit`, `budget`, `Etat`, `date`, `id_offre`) VALUES
(16, 'hhhhh', 0, '222', '2023-03-07', 8),
(26, 'dd', 22, 'dd', '2023-03-07', 8),
(27, 'ddd', 20, 'ddd', '2023-03-07', 8),
(28, 'ddd', 20, 'dd', '2023-03-07', 8),
(29, 'd', 20, 'dd', '2023-03-07', 28),
(31, 'ddd', 2, 'dd', '2023-03-08', 29);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `reponse_offre`
--
ALTER TABLE `reponse_offre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk8` (`id_offre`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `reponse_offre`
--
ALTER TABLE `reponse_offre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reponse_offre`
--
ALTER TABLE `reponse_offre`
  ADD CONSTRAINT `fk8` FOREIGN KEY (`id_offre`) REFERENCES `appel_offre` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
