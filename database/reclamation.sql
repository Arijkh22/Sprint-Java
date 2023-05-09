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
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id_rec` int(11) NOT NULL,
  `sujet` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `id_utilisateur_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`id_rec`, `sujet`, `email`, `description`, `etat`, `date`, `id_utilisateur_id`) VALUES
(49, 'bbbdadada', 'bbbdadada', 'je ne peux pas accéder au services pup', 'bb', '2019-07-03', 1),
(52, 'cccc', 'cccc', 'je ne peux pas accéder au services pup', 'ccc', '2022-05-04', 1),
(54, 'bbbdd', 'bbbdd', 'je ne peux pas accéder au services pup', 'bb', '2023-03-04', 1),
(55, 'bbb', 'bbb', 'je ne peux pas accéder au services pup', 'bb', '2023-03-04', 1),
(56, 'bbb', 'bbb', 'je ne peux pas accéder au services pup', 'bb', '2023-03-04', 1),
(62, '', 'null', '', '', '2023-03-07', 1),
(63, '', 'null', '', '', '2023-03-07', 1),
(64, 'DDDDDD', 'mohamedabdelkebir15@gmail.com', 'hahahhaa', 'traité', '2023-03-07', 1),
(65, 'AAAAAAAAAAAA', 'mohamedabdelkebir15@gmail.com', 'Aaaaa20Aaaaa20', 'traité', '2023-03-07', 2),
(66, 'SSSSSSS', 'iheb.zaidi@esprit.tn', 'J\'ai pas trouver le même produit', 'traité', '2023-03-07', 2),
(67, 'WWWWW', 'Jihed.gh@gmail.com', 'mon compte  n\'est pas à jour', 'en cours', '2023-03-07', 1),
(68, 'XXXXXXXX', 'XXXXXXXX', 'gghg', 'en cours', '2023-03-07', 2),
(69, 'ddd', 'null', 'ddd', 'dd', '2023-03-07', 1),
(70, 'ddd', 'null', 'dd', 'dd', '2023-03-08', 1),
(71, 'dd', 'null', 'dd', 'dd', '2023-03-08', 1),
(72, 'dfdfd', 'null', 'fdfd', 'ffffff', '2023-03-08', 1),
(73, 'dd', 'null', 'dd', 'dd', '2023-03-08', 1),
(74, 'dddd', 'null', 'dd', 'dd', '2023-03-08', 1),
(75, 'dd', 'null', 'dd', 'dd', '2023-03-08', 1),
(76, 'hhhhhh', 'null', 'sssd', 'ddddde', '2023-03-08', 1),
(77, 'hhhhhh', 'null', 'sssd', 'ddddde', '2023-03-08', 1),
(78, 'yyyyy', 'null', 'yyyyy', 'yyyyy', '2023-03-08', 1),
(79, 'kjkj,lm', 'null', 'jkklkl', 'fff', '2023-03-08', 1),
(80, 'aaaa', 'null', 'aaa', 'aaa', '2023-03-08', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id_rec`),
  ADD KEY `fk7` (`id_utilisateur_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id_rec` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `fk7` FOREIGN KEY (`id_utilisateur_id`) REFERENCES `utilisateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
