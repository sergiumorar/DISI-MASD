-- MySQL Script generated by MySQL Workbench
-- Ma 09 apr 2019 18:59:53 +0300
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pocketmanager
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pocketmanager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pocketmanager` DEFAULT CHARACTER SET latin1 ;
USE `pocketmanager` ;

-- -----------------------------------------------------
-- Table `pocketmanager`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pocketmanager`.`user` (
  `id` INT(11) NOT NULL,
  `username` VARCHAR(30) NULL DEFAULT NULL,
  `password` VARCHAR(30) NULL DEFAULT NULL,
  `firstName` VARCHAR(15) NULL DEFAULT NULL,
  `lastName` VARCHAR(15) NULL DEFAULT NULL,
  `birthDate` VARCHAR(20) NULL DEFAULT NULL,
  `email` VARCHAR(40) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pocketmanager`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pocketmanager`.`type` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pocketmanager`.`currency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pocketmanager`.`currency` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(15) NULL DEFAULT NULL,
  `value` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pocketmanager`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pocketmanager`.`account` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `spendingLimit` DOUBLE NULL DEFAULT NULL,
  `idCurrency` INT(11) NULL DEFAULT NULL,
  `idType` INT(11) NULL DEFAULT NULL,
  `idUser` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idUser` (`idUser` ASC),
  INDEX `idType` (`idType` ASC),
  INDEX `idCurrency` (`idCurrency` ASC),
  CONSTRAINT `account_ibfk_1`
    FOREIGN KEY (`idUser`)
    REFERENCES `pocketmanager`.`user` (`id`),
  CONSTRAINT `account_ibfk_2`
    FOREIGN KEY (`idType`)
    REFERENCES `pocketmanager`.`type` (`id`),
  CONSTRAINT `account_ibfk_3`
    FOREIGN KEY (`idCurrency`)
    REFERENCES `pocketmanager`.`currency` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pocketmanager`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pocketmanager`.`category` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pocketmanager`.`expenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pocketmanager`.`expenses` (
  `id` INT(11) NOT NULL,
  `date` VARCHAR(20) NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `comments` VARCHAR(200) NULL DEFAULT NULL,
  `idCategory` INT(11) NULL DEFAULT NULL,
  `idAccount` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idCategory` (`idCategory` ASC),
  INDEX `idAccount` (`idAccount` ASC),
  CONSTRAINT `expenses_ibfk_1`
    FOREIGN KEY (`idCategory`)
    REFERENCES `pocketmanager`.`category` (`id`),
  CONSTRAINT `expenses_ibfk_2`
    FOREIGN KEY (`idAccount`)
    REFERENCES `pocketmanager`.`account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pocketmanager`.`transfer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pocketmanager`.`transfer` (
  `id` INT(11) NOT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `idSender` INT(11) NULL DEFAULT NULL,
  `idReceiver` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idSender` (`idSender` ASC),
  INDEX `idReceiver` (`idReceiver` ASC),
  CONSTRAINT `transfer_ibfk_1`
    FOREIGN KEY (`idSender`)
    REFERENCES `pocketmanager`.`account` (`id`),
  CONSTRAINT `transfer_ibfk_2`
    FOREIGN KEY (`idReceiver`)
    REFERENCES `pocketmanager`.`account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
