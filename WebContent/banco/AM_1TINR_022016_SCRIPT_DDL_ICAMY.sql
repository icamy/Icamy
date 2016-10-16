-- SCRIPTS DDL
-- INTEGRANTES DO GRUPO:
-- 76007 - BIANCA CESAR TURCO
-- 77329 - LUCAS TAVARES DA ROCHA
-- 74426 - MAXWELL MARTINS LIMA
-- 76190 - RENÊ FERNANDES BARBOSA
-- 77150 - THIAGO TADEU BETTIOL FRATINI

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema icamydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `icamydb` ;

-- -----------------------------------------------------
-- Schema icamydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `icamydb` DEFAULT CHARACTER SET utf8 ;
USE `icamydb` ;

-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PRESTADOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_PRESTADOR` ;

CREATE TABLE `icamydb`.`T_ICM_PRESTADOR` (
  `cd_prestador` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nm_prestador` varchar(255) NOT NULL,
  `ds_tipo_pessoa` char(1) NOT NULL,
  `nr_documento` bigint(14) unsigned NOT NULL,
  `nr_telefone` bigint(11) NOT NULL,
  `ds_email` varchar(255) NOT NULL,
  `ds_senha` varchar(255) NOT NULL,
  `tx_apresentacao` text NOT NULL,
  `dt_nascimento` date DEFAULT NULL,
  `ds_url_foto` varchar(255) NOT NULL DEFAULT 'profile/none.png',
  PRIMARY KEY (`cd_prestador`),
  UNIQUE KEY `cpf_prestador_UNIQUE` (`nr_documento`),
  UNIQUE KEY `ds_email_UNIQUE` (`ds_email`)
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_CLIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_CLIENTE` ;

CREATE TABLE `icamydb`.`T_ICM_CLIENTE` (
  `cd_cliente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nm_cliente` varchar(255) NOT NULL,
  `nr_cpf` bigint(11) unsigned NOT NULL,
  `nr_telefone` bigint(11) NOT NULL,
  `ds_email` varchar(255) NOT NULL,
  `ds_senha` varchar(255) NOT NULL,
  `dt_nascimento` date DEFAULT NULL,
  `ds_sexo` char(1) DEFAULT NULL,
  `ds_url_foto` varchar(255) NOT NULL DEFAULT 'profile/none.png',
  PRIMARY KEY (`cd_cliente`),
  UNIQUE KEY `nr_cpf_UNIQUE` (`nr_cpf`),
  UNIQUE KEY `ds_email_UNIQUE` (`ds_email`)
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PORTFOLIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_PORTFOLIO` ;

CREATE TABLE `icamydb`.`T_ICM_PORTFOLIO` (
  `cd_arquivo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cd_prestador` int(10) unsigned NOT NULL,
  `ds_url_arquivo` varchar(255) NOT NULL,
  `nm_arquivo` varchar(255) NOT NULL,
  PRIMARY KEY (`cd_arquivo`,`cd_prestador`),
  KEY `fk_T_ICM_PORTFOLIO_T_ICM_PRESTADOR_idx` (`cd_prestador`),
  CONSTRAINT `fk_T_ICM_PORTFOLIO_T_ICM_PRESTADOR` 
	FOREIGN KEY (`cd_prestador`) 
    REFERENCES `icamydb`.`T_ICM_PRESTADOR` (`cd_prestador`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_BAIRRO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_BAIRRO` ;

CREATE TABLE `icamydb`.`T_ICM_BAIRRO` (
  `cd_bairro` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nm_bairro` varchar(255) NOT NULL,
  `ds_regiao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cd_bairro`)
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_ENDERECO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_ENDERECO` ;

CREATE TABLE `icamydb`.`T_ICM_ENDERECO` (
  `cd_endereco` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cd_bairro` int(10) unsigned NOT NULL,
  `cd_cliente` int(10) unsigned NOT NULL,
  `nr_cep` int(10) unsigned zerofill NOT NULL,
  `nm_logradouro` varchar(255) NOT NULL,
  `nr_logradouro` int(11) DEFAULT NULL,
  `ds_complemento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cd_endereco`,`cd_bairro`,`cd_cliente`),
  KEY `fk_T_ICM_ENDERECO_T_ICM_BAIRRO1_idx` (`cd_bairro`),
  KEY `fk_T_ICM_ENDERECO_T_ICM_CLIENTE1_idx` (`cd_cliente`),
  CONSTRAINT `fk_T_ICM_ENDERECO_T_ICM_BAIRRO1` 
	FOREIGN KEY (`cd_bairro`) 
    REFERENCES `icamydb`.`T_ICM_BAIRRO` (`cd_bairro`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_ICM_ENDERECO_T_ICM_CLIENTE1` 
	FOREIGN KEY (`cd_cliente`) 
    REFERENCES `icamydb`.`T_ICM_CLIENTE` (`cd_cliente`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PRESTADOR_BAIRRO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_PRESTADOR_BAIRRO` ;

CREATE TABLE `icamydb`.`T_ICM_PRESTADOR_BAIRRO` (
  `cd_prestador` int(10) unsigned NOT NULL,
  `cd_bairro` int(10) unsigned NOT NULL,
  PRIMARY KEY (`cd_prestador`,`cd_bairro`),
  KEY `fk_T_ICM_PRESTADOR_BAIRRO_T_ICM_BAIRRO1_idx` (`cd_bairro`),
  CONSTRAINT `fk_T_ICM_PRESTADOR_BAIRRO_T_ICM_BAIRRO1` 
	FOREIGN KEY (`cd_bairro`) 
    REFERENCES `icamydb`.`T_ICM_BAIRRO` (`cd_bairro`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_ICM_PRESTADOR_BAIRRO_T_ICM_PRESTADOR1` 
	FOREIGN KEY (`cd_prestador`) 
    REFERENCES `icamydb`.`T_ICM_PRESTADOR` (`cd_prestador`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_CATEGORIA_SERVICO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_CATEGORIA_SERVICO` ;

CREATE TABLE `icamydb`.`T_ICM_CATEGORIA_SERVICO` (
  `cd_categoria` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nm_categoria` varchar(255) NOT NULL,
  PRIMARY KEY (`cd_categoria`)
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_SERVICO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_SERVICO` ;

CREATE TABLE `icamydb`.`T_ICM_SERVICO` (
  `cd_servico` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cd_categoria` int(10) unsigned NOT NULL,
  `nm_servico` varchar(255) NOT NULL,
  `st_servico` char(1) NOT NULL,
  PRIMARY KEY (`cd_servico`,`cd_categoria`),
  KEY `fk_T_ICM_SERVICO_T_ICM_CATEGORIA1_idx` (`cd_categoria`),
  CONSTRAINT `fk_T_ICM_SERVICO_T_ICM_CATEGORIA1` 
	FOREIGN KEY (`cd_categoria`) 
    REFERENCES `icamydb`.`T_ICM_CATEGORIA_SERVICO` (`cd_categoria`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_OFERTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_OFERTA` ;

CREATE TABLE `icamydb`.`T_ICM_OFERTA` (
  `cd_oferta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cd_servico` int(10) unsigned NOT NULL,
  `cd_prestador` int(10) unsigned NOT NULL,
  `tx_oferta` text NOT NULL,
  `vl_oferta` decimal(10,2) unsigned NOT NULL,
  `nr_minutos_execucao` int(11) NOT NULL DEFAULT '60',
  `nr_dias_validade` int(11) NOT NULL,
  PRIMARY KEY (`cd_oferta`,`cd_servico`,`cd_prestador`),
  KEY `fk_T_ICM_OFERTA_T_ICM_PRESTADOR1_idx` (`cd_prestador`),
  KEY `fk_T_ICM_OFERTA_T_ICM_SERVICO1_idx` (`cd_servico`),
  CONSTRAINT `fk_T_ICM_OFERTA_T_ICM_PRESTADOR1` 
	FOREIGN KEY (`cd_prestador`) 
    REFERENCES `icamydb`.`T_ICM_PRESTADOR` (`cd_prestador`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_ICM_OFERTA_T_ICM_SERVICO1` 
	FOREIGN KEY (`cd_servico`) 
    REFERENCES `icamydb`.`T_ICM_SERVICO` (`cd_servico`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_MODALIDADE_PGTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_MODALIDADE_PGTO` ;

CREATE TABLE `icamydb`.`T_ICM_MODALIDADE_PGTO` (
  `cd_modalidade` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nm_modalidade` varchar(255) NOT NULL,
  PRIMARY KEY (`cd_modalidade`)
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_CONTRATACAO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_CONTRATACAO` ;

CREATE TABLE `icamydb`.`T_ICM_CONTRATACAO` (
  `cd_contratacao` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cd_oferta` int(10) unsigned NOT NULL,
  `cd_cliente` int(10) unsigned NOT NULL,
  `dt_contratacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `vl_contratacao` decimal(10,2) unsigned NOT NULL,
  `st_contratacao` char(1) NOT NULL,
  `dt_execucao` date DEFAULT NULL,
  PRIMARY KEY (`cd_contratacao`,`cd_oferta`,`cd_cliente`),
  KEY `fk_T_ICM_CONTRATACAO_T_ICM_OFERTA1_idx` (`cd_oferta`),
  KEY `fk_T_ICM_CONTRATACAO_T_ICM_CLIENTE1_idx` (`cd_cliente`),
  CONSTRAINT `fk_T_ICM_CONTRATACAO_T_ICM_CLIENTE1` 
	FOREIGN KEY (`cd_cliente`) 
    REFERENCES `icamydb`.`T_ICM_CLIENTE` (`cd_cliente`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_ICM_CONTRATACAO_T_ICM_OFERTA1` 
	FOREIGN KEY (`cd_oferta`) 
    REFERENCES `icamydb`.`T_ICM_OFERTA` (`cd_oferta`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_AVALIACAO_CONTRATACAO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_AVALIACAO_CONTRATACAO`;

CREATE TABLE `icamydb`.`T_ICM_AVALIACAO_CONTRATACAO` (
  `cd_avaliacao` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cd_contratacao` int(10) unsigned NOT NULL,
  `dt_avaliacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `vl_nota` int(11) NOT NULL,
  `tx_comentario` text,
  PRIMARY KEY (`cd_avaliacao`,`cd_contratacao`),
  KEY `fk_T_ICM_AVALIACAO_T_ICM_CONTRATACAO1_idx` (`cd_contratacao`),
  CONSTRAINT `fk_T_ICM_AVALIACAO_T_ICM_CONTRATACAO1` 
	FOREIGN KEY (`cd_contratacao`) 
    REFERENCES `icamydb`.`T_ICM_CONTRATACAO` (`cd_contratacao`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PROPOSTA_AGENDAMENTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_PROPOSTA_AGENDAMENTO` ;

CREATE TABLE `icamydb`.`T_ICM_PROPOSTA_AGENDAMENTO` (
  `cd_proposta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cd_contratacao` int(10) unsigned NOT NULL,
  `ds_parte_proponente` char(1) NOT NULL,
  `dt_postagem` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dt_sugerida` datetime NOT NULL,
  `tx_mensagem` text NOT NULL,
  `st_proposta` char(1) NOT NULL,
  PRIMARY KEY (`cd_proposta`,`cd_contratacao`),
  KEY `fk_T_ICM_PROPOSTA_AGENDAMENTO_T_ICM_CONTRATACAO1_idx` (`cd_contratacao`),
  CONSTRAINT `fk_T_ICM_PROPOSTA_AGENDAMENTO_T_ICM_CONTRATACAO1` 
	FOREIGN KEY (`cd_contratacao`) 
    REFERENCES `icamydb`.`T_ICM_CONTRATACAO` (`cd_contratacao`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_PAGAMENTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_PAGAMENTO` ;

CREATE TABLE `icamydb`.`T_ICM_PAGAMENTO` (
  `cd_pagamento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cd_contratacao` int(10) unsigned NOT NULL,
  `cd_modalidade` int(10) unsigned NOT NULL,
  `dt_operacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `vl_operacao` decimal(10,2) unsigned NOT NULL,
  `st_pagamento` char(1) NOT NULL,
  `cd_identificador` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cd_pagamento`,`cd_contratacao`,`cd_modalidade`),
  KEY `fk_T_ICM_PAGAMENTO_T_ICM_MODALIDADE_PGTO1_idx` (`cd_modalidade`),
  KEY `fk_T_ICM_PAGAMENTO_T_ICM_CONTRATACAO1_idx` (`cd_contratacao`),
  CONSTRAINT `fk_T_ICM_PAGAMENTO_T_ICM_CONTRATACAO1` 
	FOREIGN KEY (`cd_contratacao`) 
    REFERENCES `icamydb`.`T_ICM_CONTRATACAO` (`cd_contratacao`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_ICM_PAGAMENTO_T_ICM_MODALIDADE_PGTO1` 
	FOREIGN KEY (`cd_modalidade`) 
    REFERENCES `icamydb`.`T_ICM_MODALIDADE_PGTO` (`cd_modalidade`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
) ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `icamydb`.`T_ICM_REPASSE_COMISSAO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icamydb`.`T_ICM_REPASSE_COMISSAO` ;

CREATE TABLE `icamydb`.`T_ICM_REPASSE_COMISSAO` (
  `cd_repasse` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cd_pagamento` int(10) unsigned NOT NULL,
  `dt_repasse` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `vl_repasse` decimal(10,2) unsigned NOT NULL,
  `st_repasse` char(1) NOT NULL,
  PRIMARY KEY (`cd_repasse`,`cd_pagamento`),
  KEY `fk_T_ICM_REPASSE_T_ICM_PAGAMENTO1_idx` (`cd_pagamento`),
  CONSTRAINT `fk_T_ICM_REPASSE_T_ICM_PAGAMENTO1` 
	FOREIGN KEY (`cd_pagamento`) 
    REFERENCES `icamydb`.`T_ICM_PAGAMENTO` (`cd_pagamento`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION
) ENGINE=InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
