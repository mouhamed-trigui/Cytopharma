-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 08 juil. 2019 à 13:16
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `appges`
--

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

DROP TABLE IF EXISTS `achat`;
CREATE TABLE IF NOT EXISTS `achat` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nbc` varchar(255) NOT NULL,
  `fournisseur` varchar(255) NOT NULL,
  `transitaire` varchar(255) NOT NULL,
  `banque` varchar(255) NOT NULL,
  `devise` varchar(255) NOT NULL,
  `facture` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `achat`
--

INSERT INTO `achat` (`id`, `nbc`, `fournisseur`, `transitaire`, `banque`, `devise`, `facture`) VALUES
(1, '1234', 'PHARMA', 'Ali', 'Biat', 'USD', '1000'),
(3, '123', 'Bam', 'Med Trigui', 'ATB', 'EUR', '1050'),
(4, '1235', 'FARMA', 'Asma', 'ATB', 'EUR', '2000');

-- --------------------------------------------------------

--
-- Structure de la table `basetotal`
--

DROP TABLE IF EXISTS `basetotal`;
CREATE TABLE IF NOT EXISTS `basetotal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `semaine` varchar(255) DEFAULT NULL,
  `pf` varchar(255) DEFAULT NULL,
  `nlot` varchar(255) DEFAULT NULL,
  `qplanifiee` varchar(255) DEFAULT NULL,
  `qrealisee` varchar(255) DEFAULT NULL,
  `datefab` varchar(255) DEFAULT NULL,
  `dateexp` varchar(255) DEFAULT NULL,
  `ddplanifiee` varchar(255) DEFAULT NULL,
  `ddrealisee` varchar(255) DEFAULT NULL,
  `dfplanifiee` varchar(255) DEFAULT NULL,
  `dfrealisee` varchar(255) DEFAULT NULL,
  `ddplanifieefab` varchar(255) DEFAULT NULL,
  `ddrealiseefab` varchar(255) DEFAULT NULL,
  `dfplanifieefab` varchar(255) DEFAULT NULL,
  `dfrealiseefab` varchar(255) DEFAULT NULL,
  `ddplanifieem` varchar(255) DEFAULT NULL,
  `ddrealiseem` varchar(255) DEFAULT NULL,
  `dfplanifieem` varchar(255) DEFAULT NULL,
  `dfrealiseem` varchar(255) DEFAULT NULL,
  `ddplanifieec` varchar(255) DEFAULT NULL,
  `ddrealiseec` varchar(255) DEFAULT NULL,
  `dfplanifieec` varchar(255) DEFAULT NULL,
  `dfrealiseec` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `basetotal`
--

INSERT INTO `basetotal` (`id`, `semaine`, `pf`, `nlot`, `qplanifiee`, `qrealisee`, `datefab`, `dateexp`, `ddplanifiee`, `ddrealisee`, `dfplanifiee`, `dfrealisee`, `ddplanifieefab`, `ddrealiseefab`, `dfplanifieefab`, `dfrealiseefab`, `ddplanifieem`, `ddrealiseem`, `dfplanifieem`, `dfrealiseem`, `ddplanifieec`, `ddrealiseec`, `dfplanifieec`, `dfrealiseec`) VALUES
(1, 'S3', 'PF 04 : CYTOFLU 1g/20mL', '53', '560', '700', 'Fri Jun 21 19:01:04 GMT+01:00 2019', 'Fri Jun 28 19:01:04 GMT+01:00 2019', 'Fri Jun 14 19:37:45 GMT+01:00 2019', 'Sat Jun 15 20:00:07 GMT+01:00 2019', 'Fri Jun 28 19:37:45 GMT+01:00 2019', 'Fri Jun 14 20:00:07 GMT+01:00 2019', 'Fri Jun 14 19:57:03 GMT+01:00 2019', 'Sat Jun 15 20:01:45 GMT+01:00 2019', 'Fri Jun 21 19:57:03 GMT+01:00 2019', 'Fri Jun 21 20:01:44 GMT+01:00 2019', 'Wed Jun 19 20:06:38 GMT+01:00 2019', 'Fri Jun 21 20:07:25 GMT+01:00 2019', 'Sat Jun 15 20:06:38 GMT+01:00 2019', 'Fri Jun 28 20:07:25 GMT+01:00 2019', 'Fri Jun 07 20:15:03 GMT+01:00 2019', 'Fri Jun 21 20:18:12 GMT+01:00 2019', 'Fri Jun 14 20:15:03 GMT+01:00 2019', 'Fri Jun 28 20:18:12 GMT+01:00 2019'),
(3, 'S6', 'PF 06 : CYTOXALINE 100mg/20mL', '33', '560', '800', 'Thu Jun 20 20:02:17 GMT+01:00 2019', 'Fri Jun 28 20:02:17 GMT+01:00 2019', 'Fri Jun 07 19:59:20 GMT+01:00 2019', 'Fri Jun 21 20:00:07 GMT+01:00 2019', 'Fri Jun 14 19:59:20 GMT+01:00 2019', 'Wed Jun 19 20:00:07 GMT+01:00 2019', 'Wed Jun 19 19:57:03 GMT+01:00 2019', 'Fri Jun 21 20:01:45 GMT+01:00 2019', 'Fri Jun 28 19:57:03 GMT+01:00 2019', 'Fri Jun 28 20:01:44 GMT+01:00 2019', 'Fri Jun 28 20:06:38 GMT+01:00 2019', 'Tue Jun 11 20:07:25 GMT+01:00 2019', 'Sat Jun 29 20:06:38 GMT+01:00 2019', 'Tue Jun 25 20:07:25 GMT+01:00 2019', 'Sat Jun 08 20:15:03 GMT+01:00 2019', 'Tue Jun 18 20:18:12 GMT+01:00 2019', 'Sat Jun 22 20:15:03 GMT+01:00 2019', 'Thu Jun 27 20:18:12 GMT+01:00 2019'),
(4, 'S5', 'PF 03 : CYTOTERE 80mg/4mL', '55', '99', NULL, NULL, NULL, 'Thu Jun 13 16:00:51 GMT+01:00 2019', NULL, 'Fri Jun 21 16:00:51 GMT+01:00 2019', NULL, 'Wed Jun 12 17:36:06 GMT+01:00 2019', 'Thu Jun 13 16:01:32 GMT+01:00 2019', 'Mon Jun 10 17:36:06 GMT+01:00 2019', 'Fri Jun 21 16:01:32 GMT+01:00 2019', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'S2', 'PF 02 : CYTOTERE 20mg/1mL', '252', '5892', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Mon May 27 17:36:06 GMT+01:00 2019', NULL, 'Tue Jun 18 17:36:06 GMT+01:00 2019', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `gestion`
--

DROP TABLE IF EXISTS `gestion`;
CREATE TABLE IF NOT EXISTS `gestion` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `reference` varchar(255) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `quantite` varchar(255) NOT NULL,
  `besoin` varchar(255) NOT NULL,
  `couverture` varchar(255) NOT NULL,
  `mois` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `gestion`
--

INSERT INTO `gestion` (`id`, `reference`, `designation`, `quantite`, `besoin`, `couverture`, `mois`) VALUES
(8, 'PA0001', 'FLUOROURACILE', '18000', '9000', '2', 'Juin'),
(9, 'PA0001', 'FLUOROURACILE', '18000', '0', '0', 'Aout'),
(7, 'EX0009', 'MACROGOLGLYCEROL RICINOLEATE PEG35', '325666', '63280', '5', 'Juin');

-- --------------------------------------------------------

--
-- Structure de la table `kpi`
--

DROP TABLE IF EXISTS `kpi`;
CREATE TABLE IF NOT EXISTS `kpi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mois` varchar(255) DEFAULT NULL,
  `pf` varchar(255) DEFAULT NULL,
  `qteplanifiee` varchar(255) DEFAULT NULL,
  `qterealisee` varchar(255) DEFAULT NULL,
  `taux` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `kpi`
--

INSERT INTO `kpi` (`id`, `mois`, `pf`, `qteplanifiee`, `qterealisee`, `taux`) VALUES
(13, 'Avril', 'PF 02 : CYTOTERE 20mg/1mL', '1155', '877', '75.93073593073592'),
(14, 'Fevrier', 'PF 02 : CYTOTERE 20mg/1mL', '1000', '600', '60,00'),
(10, 'Avril', 'PF 02 : CYTOTERE 20mg/1mL', '1000', '950', '95.0'),
(11, 'Avril', 'PF 02 : CYTOTERE 20mg/1mL', '1000', '111', '11.1'),
(12, 'Avril', 'PF 02 : CYTOTERE 20mg/1mL', '1000', '877', '87.7'),
(15, 'Avril', 'PF 02 : CYTOTERE 20mg/1mL', '1000', '640', '64.0');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
