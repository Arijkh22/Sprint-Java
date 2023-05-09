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
-- Structure de la table `appel_offre`
--

CREATE TABLE `appel_offre` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `quantite` int(11) NOT NULL,
  `budget` float NOT NULL,
  `description` varchar(255) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `id_utilisateur_id` int(11) DEFAULT NULL,
  `id_categorie_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `appel_offre`
--

INSERT INTO `appel_offre` (`id`, `nom`, `quantite`, `budget`, `description`, `date`, `id_utilisateur_id`, `id_categorie_id`) VALUES
(8, 'Pc acer', 60, 200000, '7i RAM 16 Windows 11', '2023-02-16', 1, 1),
(17, 'pc', 20, 2000, '7i RAM 16 Windows 11', '2023-02-28', 1, 1),
(18, 'pc', 23, 230000, 'ffffffffffffffffffff', '2023-02-28', 1, 1),
(27, 'projecteur', 100, 500000, 'nouuuv', '2023-03-07', 1, 1),
(28, 'jklm', 233, 13.25, 'nouv', '2023-03-07', 1, 1),
(29, 'aa', 20, 20, 'dd', '2023-03-07', 1, 1),
(30, 'dd', 1, 1, 'ff', '2023-03-07', 1, 1),
(31, 'ddd', 2, 2, 'dd', '2023-03-08', 1, 1),
(32, 'ddd', 1, 1, 'ddd', '2023-03-08', 1, 1),
(33, 'gggg', 600, 12000, 'desccc', '2023-03-08', 1, 1),
(34, 'gggg', 600, 12000, 'desccc', '2023-03-08', 1, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `appel_offre`
--
ALTER TABLE `appel_offre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1` (`id_utilisateur_id`),
  ADD KEY `fk10` (`id_categorie_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `appel_offre`
--
ALTER TABLE `appel_offre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appel_offre`
--
ALTER TABLE `appel_offre`
  ADD CONSTRAINT `FK_BC56FD4750EAE44` FOREIGN KEY (`id_utilisateur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FK_BC56FD47C9486A13` FOREIGN KEY (`id_categorie_id`) REFERENCES `categorie` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
