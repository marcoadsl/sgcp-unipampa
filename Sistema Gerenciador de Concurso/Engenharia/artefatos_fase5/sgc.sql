# Host: 127.0.0.1  (Version: 5.5.32)
# Date: 2015-01-23 02:55:04
# Generator: MySQL-Front 5.3  (Build 4.191)

/*!40101 SET NAMES latin1 */;

#
# Structure for table "classedoconcurso"
#

CREATE TABLE `classedoconcurso` (
  `idClasseDoConcurso` int(11) NOT NULL,
  `nomeClasse` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClasseDoConcurso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "classedoconcurso"
#


#
# Structure for table "examinador"
#

CREATE TABLE `examinador` (
  `idExaminador` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idExaminador`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "examinador"
#

INSERT INTO `examinador` VALUES (4,'José Carlos Bins','M','Doutor'),(5,'JP','M','Mestre'),(6,'Andreia Bordin','F','Mestre'),(8,'Andrea Bordin','F','Mestre'),(9,'Joao Pablo','M','Mestre'),(10,'Aline Mello','F','Doutor');

#
# Structure for table "banca"
#

CREATE TABLE `banca` (
  `idBanca` int(11) NOT NULL AUTO_INCREMENT,
  `Examinador_idExaminador` int(11) NOT NULL,
  `Examinador_idExaminador1` int(11) NOT NULL,
  `Examinador_idExaminador2` int(11) NOT NULL,
  PRIMARY KEY (`idBanca`),
  KEY `fk_Banca_Examinador1_idx` (`Examinador_idExaminador`),
  KEY `fk_Banca_Examinador2_idx` (`Examinador_idExaminador1`),
  KEY `fk_Banca_Examinador3_idx` (`Examinador_idExaminador2`),
  CONSTRAINT `fk_Banca_Examinador1` FOREIGN KEY (`Examinador_idExaminador`) REFERENCES `examinador` (`idExaminador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Banca_Examinador2` FOREIGN KEY (`Examinador_idExaminador1`) REFERENCES `examinador` (`idExaminador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Banca_Examinador3` FOREIGN KEY (`Examinador_idExaminador2`) REFERENCES `examinador` (`idExaminador`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

#
# Data for table "banca"
#

INSERT INTO `banca` VALUES (12,4,5,6),(13,4,5,6),(14,4,6,5),(15,4,6,5),(16,4,8,9),(17,4,10,6);

#
# Structure for table "concurso"
#

CREATE TABLE `concurso` (
  `idConcurso` int(11) NOT NULL AUTO_INCREMENT,
  `ministerio` varchar(45) DEFAULT NULL,
  `universidade` varchar(45) DEFAULT NULL,
  `campus` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `data` varchar(45) DEFAULT NULL,
  `edital` varchar(45) DEFAULT NULL,
  `classe` varchar(45) DEFAULT NULL,
  `cabecalho` varchar(100) DEFAULT NULL,
  `Banca_idBanca` int(11) NOT NULL,
  PRIMARY KEY (`idConcurso`),
  KEY `fk_Concurso_Banca1_idx` (`Banca_idBanca`),
  CONSTRAINT `fk_Concurso_Banca1` FOREIGN KEY (`Banca_idBanca`) REFERENCES `banca` (`idBanca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "concurso"
#

INSERT INTO `concurso` VALUES (3,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Ciencia da COmputacao - S','19/01/2015','asdkj','do Magistério Superior',NULL,14),(4,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Ciencia da COmputaçã','19/01/2015','asd','Assistente',NULL,15),(5,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Engenharia de Software - Evolução de Software','19/01/2015','CONSUNI','Assistente',NULL,16),(6,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','teste','19/12/2015','teste','Assistente',NULL,17);

#
# Structure for table "candidato"
#

CREATE TABLE `candidato` (
  `idCandidato` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `Concurso_ministerio` int(11) NOT NULL,
  PRIMARY KEY (`idCandidato`),
  KEY `fk_Candidato_Concurso1_idx` (`Concurso_ministerio`),
  CONSTRAINT `fk_Candidato_Concurso1` FOREIGN KEY (`Concurso_ministerio`) REFERENCES `concurso` (`idConcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "candidato"
#

INSERT INTO `candidato` VALUES (2,'Gabriel B Moro','15/03/1994','Masculino',5),(3,'Eduardo Bruning','28/03/1994','Masculino',5),(4,'Anderson Raugust','01/03/1994','Masculino',5),(5,'Anderson Raugust','12/10/2015','Feminino',6);

#
# Structure for table "prova_didatica"
#

CREATE TABLE `prova_didatica` (
  `idProva_Didatica` int(11) NOT NULL,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` varchar(45) DEFAULT NULL,
  `artigo_prazo_recurso` varchar(45) DEFAULT NULL,
  `pode_desistir_recurso` tinyint(1) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Didatica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "prova_didatica"
#


#
# Structure for table "prova_entrevista"
#

CREATE TABLE `prova_entrevista` (
  `idEntrevista` int(11) NOT NULL AUTO_INCREMENT,
  `nota1` int(11) DEFAULT NULL,
  `nota2` int(11) DEFAULT NULL,
  `nota3` int(11) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEntrevista`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "prova_entrevista"
#


#
# Structure for table "prova_escrita"
#

CREATE TABLE `prova_escrita` (
  `idProva_Escrita` int(11) NOT NULL,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` varchar(45) DEFAULT NULL,
  `artigo_prazo_recurso` varchar(45) DEFAULT NULL,
  `pode_desistir_recurso` tinyint(1) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Escrita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "prova_escrita"
#

INSERT INTO `prova_escrita` VALUES (6,NULL,NULL,NULL,NULL,4),(7,NULL,NULL,NULL,NULL,2);

#
# Structure for table "criterio"
#

CREATE TABLE `criterio` (
  `idCriterio` int(11) NOT NULL,
  `nomeCriterio` varchar(45) DEFAULT NULL,
  `notaCriterio` int(11) DEFAULT NULL,
  `Prova_Didatica_idProva_Didatica` int(11) DEFAULT NULL,
  `Prova_Escrita_idProva_Escrita` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCriterio`),
  KEY `fk_Criterio_Prova_Didatica1_idx` (`Prova_Didatica_idProva_Didatica`),
  KEY `fk_Criterio_Prova_Escrita1_idx` (`Prova_Escrita_idProva_Escrita`),
  CONSTRAINT `fk_Criterio_Prova_Didatica1` FOREIGN KEY (`Prova_Didatica_idProva_Didatica`) REFERENCES `prova_didatica` (`idProva_Didatica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Criterio_Prova_Escrita1` FOREIGN KEY (`Prova_Escrita_idProva_Escrita`) REFERENCES `prova_escrita` (`idProva_Escrita`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "criterio"
#


#
# Structure for table "prova_memorial"
#

CREATE TABLE `prova_memorial` (
  `idProva_Memorial` int(11) NOT NULL AUTO_INCREMENT,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` int(11) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Memorial`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "prova_memorial"
#


#
# Structure for table "prova_titulo"
#

CREATE TABLE `prova_titulo` (
  `idProva_Titulo` int(11) NOT NULL AUTO_INCREMENT,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` int(11) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Titulo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "prova_titulo"
#


#
# Structure for table "classe"
#

CREATE TABLE `classe` (
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
  KEY `fk_Classe_Prova_Titulo1_idx` (`Prova_Titulo_idProva_Titulo`),
  CONSTRAINT `fk_Classe_Prova_Titulo1` FOREIGN KEY (`Prova_Titulo_idProva_Titulo`) REFERENCES `prova_titulo` (`idProva_Titulo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "classe"
#


#
# Structure for table "item"
#

CREATE TABLE `item` (
  `idItem` int(11) NOT NULL,
  `discItem` varchar(45) DEFAULT NULL,
  `pontItem` int(11) DEFAULT NULL,
  `Classe_idClasse` int(11) NOT NULL,
  PRIMARY KEY (`idItem`),
  KEY `fk_Item_Classe1_idx` (`Classe_idClasse`),
  CONSTRAINT `fk_Item_Classe1` FOREIGN KEY (`Classe_idClasse`) REFERENCES `classe` (`idClasse`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "item"
#


#
# Structure for table "regra"
#

CREATE TABLE `regra` (
  `idRegra` int(11) NOT NULL,
  `Prova_Titulo_idProva_Titulo` int(11) NOT NULL,
  `item` varchar(45) DEFAULT NULL,
  `discriminacao` varchar(45) DEFAULT NULL,
  `pontuacao` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRegra`),
  KEY `fk_Regra_Prova_Titulo1_idx` (`Prova_Titulo_idProva_Titulo`),
  CONSTRAINT `fk_Regra_Prova_Titulo1` FOREIGN KEY (`Prova_Titulo_idProva_Titulo`) REFERENCES `prova_titulo` (`idProva_Titulo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "regra"
#


#
# Structure for table "resolucao"
#

CREATE TABLE `resolucao` (
  `idResolucao` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `versao_minima` double DEFAULT NULL,
  `normativa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idResolucao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "resolucao"
#

INSERT INTO `resolucao` VALUES (1,'Resolução 64/2013',NULL,'CONSUNI'),(2,'Resolução 82/2014',NULL,'CONSUNI');
