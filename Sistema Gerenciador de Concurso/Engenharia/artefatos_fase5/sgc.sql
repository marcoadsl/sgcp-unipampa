-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Máquina: 127.0.0.1
-- Data de Criação: 15-Jan-2015 às 05:45
-- Versão do servidor: 5.5.32
-- versão do PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `sgc`
--
CREATE DATABASE IF NOT EXISTS `sgc` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sgc`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `banca`
--

CREATE TABLE IF NOT EXISTS `banca` (
  `idBanca` int(11) NOT NULL,
  `Examinador_idExaminador` int(11) NOT NULL,
  `Examinador_idExaminador1` int(11) NOT NULL,
  `Examinador_idExaminador2` int(11) NOT NULL,
  PRIMARY KEY (`idBanca`),
  KEY `fk_Banca_Examinador1_idx` (`Examinador_idExaminador`),
  KEY `fk_Banca_Examinador2_idx` (`Examinador_idExaminador1`),
  KEY `fk_Banca_Examinador3_idx` (`Examinador_idExaminador2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidato`
--

CREATE TABLE IF NOT EXISTS `candidato` (
  `idCandidato` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `Concurso_ministerio` int(11) NOT NULL,
  PRIMARY KEY (`idCandidato`),
  KEY `fk_Candidato_Concurso1_idx` (`Concurso_ministerio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `classe`
--

CREATE TABLE IF NOT EXISTS `classe` (
  `idClasse` int(11) NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `rodape` varchar(45) DEFAULT NULL,
  `subtitulo` varchar(45) DEFAULT NULL,
  `peso_min` int(11) DEFAULT NULL,
  `peso_max` int(11) DEFAULT NULL,
  `pontuacao_max` int(11) DEFAULT NULL,
  `valor_pontuacao_max` int(11) DEFAULT NULL,
  `Prova_Titulo_idProva_Titulo` int(11) NOT NULL,
  PRIMARY KEY (`idClasse`),
  KEY `fk_Classe_Prova_Titulo1_idx` (`Prova_Titulo_idProva_Titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `classedoconcurso`
--

CREATE TABLE IF NOT EXISTS `classedoconcurso` (
  `idClasseDoConcurso` int(11) NOT NULL,
  `nomeClasse` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClasseDoConcurso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `concurso`
--

CREATE TABLE IF NOT EXISTS `concurso` (
  `idConcurso` int(11) NOT NULL,
  `ministerio` varchar(45) DEFAULT NULL,
  `universidade` varchar(45) DEFAULT NULL,
  `campus` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `data` varchar(45) DEFAULT NULL,
  `edital` varchar(45) DEFAULT NULL,
  `classe` varchar(45) DEFAULT NULL,
  `cabecalho` varchar(100) DEFAULT NULL,
  `Regras_idRegras` int(11) NOT NULL,
  `ClasseDoConcurso_idClasseDoConcurso` int(11) NOT NULL,
  `Banca_idBanca` int(11) NOT NULL,
  PRIMARY KEY (`idConcurso`),
  KEY `fk_Concurso_Regras_idx` (`Regras_idRegras`),
  KEY `fk_Concurso_ClasseDoConcurso1_idx` (`ClasseDoConcurso_idClasseDoConcurso`),
  KEY `fk_Concurso_Banca1_idx` (`Banca_idBanca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `criterio`
--

CREATE TABLE IF NOT EXISTS `criterio` (
  `idCriterio` int(11) NOT NULL,
  `nomeCriterio` varchar(45) DEFAULT NULL,
  `notaCriterio` int(11) DEFAULT NULL,
  `Prova_Didatica_idProva_Didatica` int(11) DEFAULT NULL,
  `Prova_Escrita_idProva_Escrita` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCriterio`),
  KEY `fk_Criterio_Prova_Didatica1_idx` (`Prova_Didatica_idProva_Didatica`),
  KEY `fk_Criterio_Prova_Escrita1_idx` (`Prova_Escrita_idProva_Escrita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `examinador`
--

CREATE TABLE IF NOT EXISTS `examinador` (
  `idExaminador` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idExaminador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `idItem` int(11) NOT NULL,
  `discItem` varchar(45) DEFAULT NULL,
  `pontItem` int(11) DEFAULT NULL,
  `Classe_idClasse` int(11) NOT NULL,
  PRIMARY KEY (`idItem`),
  KEY `fk_Item_Classe1_idx` (`Classe_idClasse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `prova_didatica`
--

CREATE TABLE IF NOT EXISTS `prova_didatica` (
  `idProva_Didatica` int(11) NOT NULL,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` varchar(45) DEFAULT NULL,
  `artigo_prazo_recurso` varchar(45) DEFAULT NULL,
  `pode_desistir_recurso` tinyint(1) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Didatica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `prova_entrevista`
--

CREATE TABLE IF NOT EXISTS `prova_entrevista` (
  `idEntrevista` int(11) NOT NULL,
  `nota1` int(11) DEFAULT NULL,
  `nota2` int(11) DEFAULT NULL,
  `nota3` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEntrevista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `prova_escrita`
--

CREATE TABLE IF NOT EXISTS `prova_escrita` (
  `idProva_Escrita` int(11) NOT NULL,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` varchar(45) DEFAULT NULL,
  `artigo_prazo_recurso` varchar(45) DEFAULT NULL,
  `pode_desistir_recurso` tinyint(1) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Escrita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `prova_memorial`
--

CREATE TABLE IF NOT EXISTS `prova_memorial` (
  `idProva_Memorial` int(11) NOT NULL,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` int(11) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Memorial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `prova_titulo`
--

CREATE TABLE IF NOT EXISTS `prova_titulo` (
  `idProva_Titulo` int(11) NOT NULL,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` int(11) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `regra`
--

CREATE TABLE IF NOT EXISTS `regra` (
  `idRegra` int(11) NOT NULL,
  `Prova_Titulo_idProva_Titulo` int(11) NOT NULL,
  `item` varchar(45) DEFAULT NULL,
  `discriminacao` varchar(45) DEFAULT NULL,
  `pontuacao` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRegra`),
  KEY `fk_Regra_Prova_Titulo1_idx` (`Prova_Titulo_idProva_Titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `resolucao`
--

CREATE TABLE IF NOT EXISTS `resolucao` (
  `idResolucao` int(11) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `versao_minima` double DEFAULT NULL,
  `normativa` varchar(45) DEFAULT NULL,
  `Prova_Memorial_idProva_Memorial` int(11) NOT NULL,
  `Prova_Titulo_idProva_Titulo` int(11) NOT NULL,
  `Prova_Didatica_idProva_Didatica` int(11) NOT NULL,
  `Prova_Escrita_idProva_Escrita` int(11) NOT NULL,
  `Prova_Entrevista_idEntrevista` int(11) NOT NULL,
  PRIMARY KEY (`idResolucao`),
  KEY `fk_Resolucao_Prova_Memorial1_idx` (`Prova_Memorial_idProva_Memorial`),
  KEY `fk_Resolucao_Prova_Titulo1_idx` (`Prova_Titulo_idProva_Titulo`),
  KEY `fk_Resolucao_Prova_Didatica1_idx` (`Prova_Didatica_idProva_Didatica`),
  KEY `fk_Resolucao_Prova_Escrita1_idx` (`Prova_Escrita_idProva_Escrita`),
  KEY `fk_Resolucao_Prova_Entrevista1_idx` (`Prova_Entrevista_idEntrevista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `banca`
--
ALTER TABLE `banca`
  ADD CONSTRAINT `fk_Banca_Examinador1` FOREIGN KEY (`Examinador_idExaminador`) REFERENCES `examinador` (`idExaminador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Banca_Examinador2` FOREIGN KEY (`Examinador_idExaminador1`) REFERENCES `examinador` (`idExaminador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Banca_Examinador3` FOREIGN KEY (`Examinador_idExaminador2`) REFERENCES `examinador` (`idExaminador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `candidato`
--
ALTER TABLE `candidato`
  ADD CONSTRAINT `fk_Candidato_Concurso1` FOREIGN KEY (`Concurso_ministerio`) REFERENCES `concurso` (`idConcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `fk_Classe_Prova_Titulo1` FOREIGN KEY (`Prova_Titulo_idProva_Titulo`) REFERENCES `prova_titulo` (`idProva_Titulo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `concurso`
--
ALTER TABLE `concurso`
  ADD CONSTRAINT `fk_Concurso_Regras` FOREIGN KEY (`Regras_idRegras`) REFERENCES `resolucao` (`idResolucao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Concurso_ClasseDoConcurso1` FOREIGN KEY (`ClasseDoConcurso_idClasseDoConcurso`) REFERENCES `classedoconcurso` (`idClasseDoConcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Concurso_Banca1` FOREIGN KEY (`Banca_idBanca`) REFERENCES `banca` (`idBanca`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `criterio`
--
ALTER TABLE `criterio`
  ADD CONSTRAINT `fk_Criterio_Prova_Didatica1` FOREIGN KEY (`Prova_Didatica_idProva_Didatica`) REFERENCES `prova_didatica` (`idProva_Didatica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Criterio_Prova_Escrita1` FOREIGN KEY (`Prova_Escrita_idProva_Escrita`) REFERENCES `prova_escrita` (`idProva_Escrita`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `fk_Item_Classe1` FOREIGN KEY (`Classe_idClasse`) REFERENCES `classe` (`idClasse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `regra`
--
ALTER TABLE `regra`
  ADD CONSTRAINT `fk_Regra_Prova_Titulo1` FOREIGN KEY (`Prova_Titulo_idProva_Titulo`) REFERENCES `prova_titulo` (`idProva_Titulo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `resolucao`
--
ALTER TABLE `resolucao`
  ADD CONSTRAINT `fk_Resolucao_Prova_Memorial1` FOREIGN KEY (`Prova_Memorial_idProva_Memorial`) REFERENCES `prova_memorial` (`idProva_Memorial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Resolucao_Prova_Titulo1` FOREIGN KEY (`Prova_Titulo_idProva_Titulo`) REFERENCES `prova_titulo` (`idProva_Titulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Resolucao_Prova_Didatica1` FOREIGN KEY (`Prova_Didatica_idProva_Didatica`) REFERENCES `prova_didatica` (`idProva_Didatica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Resolucao_Prova_Escrita1` FOREIGN KEY (`Prova_Escrita_idProva_Escrita`) REFERENCES `prova_escrita` (`idProva_Escrita`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Resolucao_Prova_Entrevista1` FOREIGN KEY (`Prova_Entrevista_idEntrevista`) REFERENCES `prova_entrevista` (`idEntrevista`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
