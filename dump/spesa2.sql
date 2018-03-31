-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              5.7.18 - MySQL Community Server (GPL)
-- S.O. server:                  Win64
-- HeidiSQL Versione:            9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database spesa2
CREATE DATABASE IF NOT EXISTS `spesa2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spesa2`;

-- Dump della struttura di tabella spesa2.negozio
CREATE TABLE IF NOT EXISTS `negozio` (
  `idNegozio` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idNegozio`),
  UNIQUE KEY `idNegozio_UNIQUE` (`idNegozio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella spesa2.negozio: ~0 rows (circa)
/*!40000 ALTER TABLE `negozio` DISABLE KEYS */;
INSERT INTO `negozio` (`idNegozio`, `nome`) VALUES
	(1, 'Auchan'),
	(2, 'Dok');
/*!40000 ALTER TABLE `negozio` ENABLE KEYS */;

-- Dump della struttura di tabella spesa2.prodotto
CREATE TABLE IF NOT EXISTS `prodotto` (
  `idprodotto` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `marca` varchar(45) NOT NULL,
  `contenitore` varchar(45) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  `quantità` int(11) DEFAULT NULL,
  `prezzo` float NOT NULL,
  `negozio_idNegozio` int(11) NOT NULL,
  PRIMARY KEY (`idprodotto`),
  UNIQUE KEY `idprodotto_UNIQUE` (`idprodotto`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella spesa2.prodotto: ~1 rows (circa)
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` (`idprodotto`, `nome`, `descrizione`, `marca`, `contenitore`, `peso`, `quantità`, `prezzo`, `negozio_idNegozio`) VALUES
	(1, 'LatteMio Biscotto', NULL, 'Nestlé', 'Busta', 500, 1, 1.2, 1);
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
