CREATE TABLE `prestamo`.`contrato` (
`id` INT NOT NULL AUTO_INCREMENT,
`id_cliente` INT NULL,
`numero` VARCHAR(50) NOT NULL,
`monto` VARCHAR(50) NOT NULL,
`interes` VARCHAR(50) NOT NULL,
`divisa` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`),
INDEX `FK_cliente_idx` (`id_cliente` ASC) VISIBLE,
CONSTRAINT `FK_cliente2`
FOREIGN KEY (`id_cliente`)
REFERENCES `prestamo`.`cliente` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

CREATE TABLE `prestamo`.`documento` (
`id` INT NOT NULL AUTO_INCREMENT,
`tipo` VARCHAR(50) NOT NULL,
`numero` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`));

CREATE TABLE `prestamo`.`cuenta` (
`id` INT NOT NULL AUTO_INCREMENT,
`id_cliente` INT NULL,
`numero` VARCHAR(50) NOT NULL,
`monto` VARCHAR(50) NOT NULL,
`divisa` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`),
INDEX `FK_cliente_idx` (`id_cliente` ASC) VISIBLE,
CONSTRAINT `FK_cliente`
FOREIGN KEY (`id_cliente`)
REFERENCES `prestamo`.`cliente` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);


CREATE TABLE `prestamo`.`contrato` (
`id` INT NOT NULL AUTO_INCREMENT,
`id_documento` INT NULL,
PRIMARY KEY (`id`),
INDEX `FK_documento_idx` (`id_documento` ASC) VISIBLE,
CONSTRAINT `FK_documento`
FOREIGN KEY (`id_documento`)
REFERENCES `prestamo`.`documento` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)