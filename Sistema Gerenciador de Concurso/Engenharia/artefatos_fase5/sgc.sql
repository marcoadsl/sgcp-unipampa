# Host: 127.0.0.1  (Version: 5.5.32)
# Date: 2015-01-29 20:01:41
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

#
# Data for table "examinador"
#

INSERT INTO `examinador` VALUES (4,'José Carlos Bins','M','Doutor'),(5,'JP','M','Mestre'),(6,'Andreia Bordin','F','Mestre'),(8,'Andrea Bordin','F','Mestre'),(9,'Joao Pablo','M','Mestre'),(10,'Aline Mello','F','Doutor'),(11,'Duda','M','Graduado'),(12,'Gabriel','M','Graduado'),(13,'Roberto Carlo','M','Mestre'),(14,'Eduardo Bruning','M','Doutor'),(15,'Jean Rangel','M','Mestre'),(16,'Anderson Raugust','M','Mestre'),(17,'Alice Finger','F','Mestre'),(18,' Alice Finger','F','Mestre'),(19,'Marcia Cristina Cera','F','Doutor'),(20,'Sérgio Mergen','M','Doutor');

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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

#
# Data for table "banca"
#

INSERT INTO `banca` VALUES (12,4,5,6),(13,4,5,6),(14,4,6,5),(15,4,6,5),(16,4,8,9),(17,4,10,6),(18,8,11,12),(19,4,8,13),(20,4,8,13),(21,14,15,16),(22,4,17,8),(23,4,8,17),(24,4,8,17),(25,8,17,4),(26,8,18,4),(27,8,4,17),(28,4,8,17),(29,19,4,17),(30,4,19,20),(31,4,15,8),(32,4,15,8);

#
# Structure for table "prova_didatica"
#

CREATE TABLE `prova_didatica` (
  `idProva_Didatica` int(11) NOT NULL AUTO_INCREMENT,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` varchar(45) DEFAULT NULL,
  `artigo_prazo_recurso` varchar(45) DEFAULT NULL,
  `pode_desistir_recurso` tinyint(1) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Didatica`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "prova_didatica"
#

INSERT INTO `prova_didatica` VALUES (1,NULL,NULL,NULL,NULL,4);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "prova_entrevista"
#

INSERT INTO `prova_entrevista` VALUES (1,NULL,NULL,NULL,7);

#
# Structure for table "prova_escrita"
#

CREATE TABLE `prova_escrita` (
  `idProva_Escrita` int(11) NOT NULL AUTO_INCREMENT,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` varchar(45) DEFAULT NULL,
  `artigo_prazo_recurso` varchar(45) DEFAULT NULL,
  `pode_desistir_recurso` tinyint(1) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Escrita`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "prova_escrita"
#

INSERT INTO `prova_escrita` VALUES (6,NULL,NULL,NULL,NULL,4),(7,NULL,NULL,NULL,NULL,2),(8,NULL,NULL,NULL,NULL,8);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "prova_memorial"
#

INSERT INTO `prova_memorial` VALUES (1,NULL,NULL,3);

#
# Structure for table "prova_titulo"
#

CREATE TABLE `prova_titulo` (
  `idProva_Titulo` int(11) NOT NULL AUTO_INCREMENT,
  `eliminatoria` varchar(45) DEFAULT NULL,
  `nota_minima` int(11) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProva_Titulo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "prova_titulo"
#

INSERT INTO `prova_titulo` VALUES (1,NULL,NULL,8);

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

#
# Structure for table "sessao_abertura"
#

CREATE TABLE `sessao_abertura` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `horaInicio` varchar(255) DEFAULT NULL,
  `local` varchar(255) DEFAULT NULL,
  `portariaDeNomeacao` varchar(255) DEFAULT NULL,
  `emissorDePortaria` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

#
# Data for table "sessao_abertura"
#

INSERT INTO `sessao_abertura` VALUES (1,'teste','teste','teste','teste'),(2,'Campus Alegrete','laboratório 2','23','Gabriel B Moro'),(3,'Hotel Dallas','laboratório 2','teste','teste'),(4,'test','teste','teste2','teste3'),(5,'sala 202','sala 203','sala 204','sala 205'),(6,'Uruguaiana','lab2','20/12202','Consuni');

#
# Structure for table "cronograma"
#

CREATE TABLE `cronograma` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `atividade` varchar(400) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `horario` varchar(255) DEFAULT NULL,
  `local` varchar(255) DEFAULT NULL,
  `sessaoRespectivai` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `sessaoRespectivai` (`sessaoRespectivai`),
  CONSTRAINT `cronograma_ibfk_1` FOREIGN KEY (`sessaoRespectivai`) REFERENCES `sessao_abertura` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

#
# Data for table "cronograma"
#

INSERT INTO `cronograma` VALUES (1,'Registrar Candidatos','12/12/12','12:00hrs','lab',5),(2,'Registrar Candidatos','12/12/12','12:00','lab2',6),(3,'Almoçar','12/12/12/','12:30','lab3',6);

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
  `sessaoInicialAbertura` int(11) DEFAULT NULL,
  PRIMARY KEY (`idConcurso`),
  KEY `fk_Concurso_Banca1_idx` (`Banca_idBanca`),
  KEY `sessaoInicialAbertura` (`sessaoInicialAbertura`),
  CONSTRAINT `concurso_ibfk_1` FOREIGN KEY (`sessaoInicialAbertura`) REFERENCES `sessao_abertura` (`Id`),
  CONSTRAINT `fk_Concurso_Banca1` FOREIGN KEY (`Banca_idBanca`) REFERENCES `banca` (`idBanca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Data for table "concurso"
#

INSERT INTO `concurso` VALUES (5,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Engenharia de Software - Evolução de Software','19/01/2015','CONSUNI','Assistente',NULL,16,NULL),(6,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','teste','19/12/2015','teste','Assistente',NULL,17,NULL),(7,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','','','','-----------------------------',NULL,21,NULL),(8,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Engenharia de Software - Web Semântica','12/03/2020','Ecoas','Assistente',NULL,22,NULL),(9,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Engenharia de Software','30/01/2015','Consuni - 2014','do Magistério Superior',NULL,23,2),(10,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Enfermagem - Saúde do Idoso','12/12/2015','Consuni','do Magistério Superior',NULL,24,3),(11,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Campus Alegrete','12/12/2013','Consuni','Assistente',NULL,25,4),(12,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Campus Alegrete','12/12/2014','Consuni','Adjunto',NULL,26,5),(13,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Computação','12/12/2015','consuni','Adjunto',NULL,27,NULL),(14,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','Computação','12/12/0012','Consuni','Assistente',NULL,28,NULL),(15,'Ministério da Educação','Universidade Federal do Pampa','Alegrete','CC - Arquitetura','12/12/0012','asd','Adjunto',NULL,30,6);

#
# Structure for table "candidato"
#

CREATE TABLE `candidato` (
  `idCandidato` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `Concurso_ministerio` int(11) NOT NULL,
  `presenca` int(1) DEFAULT NULL,
  PRIMARY KEY (`idCandidato`),
  KEY `fk_Candidato_Concurso1_idx` (`Concurso_ministerio`),
  CONSTRAINT `fk_Candidato_Concurso1` FOREIGN KEY (`Concurso_ministerio`) REFERENCES `concurso` (`idConcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

#
# Data for table "candidato"
#

INSERT INTO `candidato` VALUES (2,'Gabriel B Moro','15/03/1994','Masculino',5,NULL),(3,'Eduardo Bruning','28/03/1994','Masculino',5,NULL),(4,'Anderson Raugust','01/03/1994','Masculino',5,NULL),(5,'Anderson Raugust','12/10/2015','Feminino',6,NULL),(6,'César do Planeta dos Macacos','12/12/2015','Masculino',7,NULL),(7,'César do Planeta dos Macacos','12/12/2015','Masculino',7,NULL),(8,'Jean Rangel','12/12/2010','Masculino',8,NULL),(9,'Gabriel Bronzatti Moro','15/03/1994','Masculino',9,NULL),(10,'Eduardo Bruning','15/03/1994','Masculino',9,NULL),(11,'Thaíse Soares Deponti','27/04/1990','Feminino',10,NULL),(12,'Jucéli Bronzatti Moro','01/09/1987','Feminino',10,NULL),(13,'Pedro Osório Scolari Moro','16/10/1977','Masculino',10,NULL),(14,'Kaio Resendi','12/12/2014','Masculino',11,NULL),(15,'Kaio Resendi','12/12/2014','Masculino',12,NULL),(16,'Tiago Cássio Krug','01/08/2015','Masculino',12,NULL),(17,'Kaio Resendi','12/12/0012','Masculino',13,NULL),(18,'Eduardo Amaral','12/12/0012','Masculino',13,NULL),(19,'Anderson Raugust','12/12/0012','Masculino',13,NULL),(20,'Eduardo Bruning','12/12/0012','Masculino',13,NULL),(21,'Kaio Resendi','12/12/1222','Masculino',14,NULL),(22,'Eduardo Amaral','12/12/1222','Masculino',14,NULL),(23,'Anderson Raugust','12/12/1222','Masculino',14,NULL),(24,'Augusto Görgen','12/12/1222','Masculino',14,NULL),(25,'Murilo','12/12/0012','Masculino',15,NULL),(26,'Anderson','12/12/0012','Masculino',15,NULL),(27,'Eduardo','12/12/0012','Masculino',15,NULL),(28,'Kaio','12/12/0012','Masculino',15,NULL),(29,'Gabriel','12/12/0012','Masculino',15,NULL);
