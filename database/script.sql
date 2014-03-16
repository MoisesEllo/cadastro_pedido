SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `cadastropedido` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `cadastropedido` ;

-- -----------------------------------------------------
-- Table `cadastropedido`.`pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastropedido`.`pedido` ;

CREATE TABLE IF NOT EXISTS `cadastropedido`.`pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NULL,
  `nome_cliente` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadastropedido`.`tipo_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastropedido`.`tipo_item` ;

CREATE TABLE IF NOT EXISTS `cadastropedido`.`tipo_item` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadastropedido`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastropedido`.`item` ;

CREATE TABLE IF NOT EXISTS `cadastropedido`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `descricao` TEXT NULL,
  `id_tipo_item` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_id_tipo_item_idx` (`id_tipo_item` ASC),
  CONSTRAINT `FK_id_tipo_item`
    FOREIGN KEY (`id_tipo_item`)
    REFERENCES `cadastropedido`.`tipo_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadastropedido`.`item_pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cadastropedido`.`item_pedido` ;

CREATE TABLE IF NOT EXISTS `cadastropedido`.`item_pedido` (
  `id_pedido` INT NOT NULL,
  `id_item` INT NOT NULL,
  `quantidade` DOUBLE NULL,
  PRIMARY KEY (`id_pedido`, `id_item`),
  INDEX `FK_id_item_idx` (`id_item` ASC),
  CONSTRAINT `FK_id_pedido`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `cadastropedido`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_id_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `cadastropedido`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `cadastropedido`.`tipo_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `cadastropedido`;
INSERT INTO `cadastropedido`.`tipo_item` (`id`, `nome`) VALUES (1, 'Produto');
INSERT INTO `cadastropedido`.`tipo_item` (`id`, `nome`) VALUES (2, 'Serviço');

COMMIT;

