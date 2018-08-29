CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  PRIMARY KEY (`idusuario`)
);

INSERT INTO `usuarios`(`usuario`,`ciudad`)
VALUES('Usuario1','Capital Federal');
INSERT INTO `usuarios`(`usuario`,`ciudad`)
VALUES('Usuario2','Córdoba');

CREATE TABLE `formas_pago` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `formas_pago`(`tipo`)
VALUES('Efectivo');
INSERT INTO `formas_pago`(`tipo`)
VALUES('Tarjeta VISA');

CREATE TABLE `estado_pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `estado_pedido`(`estado`)
VALUES('Pendiente');
INSERT INTO `estado_pedido`(`estado`)
VALUES('En tramite');
INSERT INTO `estado_pedido`(`estado`)
VALUES('Completo');


CREATE TABLE `direccion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calle` varchar(100) NOT NULL,
  `numero` int NOT NULL,
  `piso` int NULL,
  `depto` varchar(100) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `productos` varchar(500) NOT NULL,
  `idDireccionOrigen` int(11) DEFAULT NULL,
  `idDireccionDestino` int(11) DEFAULT NULL,
  `ida_vuelta` bit(1) NOT NULL,
  `comision` decimal(10,0) NOT NULL,
  `idFormaPago` int(11) NOT NULL,
  `pago` decimal(10,0) NOT NULL,
  `idEstadoPedido` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pedido_usuario_idx` (`idUsuario`),
  KEY `FK_pedido_direccion_origen_idx` (`idDireccionOrigen`),
  KEY `FK_pedido_direccion_destino_idx` (`idDireccionDestino`),
  KEY `FK_pedido_formas_pago_idx` (`idFormaPago`),
  KEY `FK_pedido_estado_pedido_idx` (`idEstadoPedido`),
  CONSTRAINT `FK_pedido_direccion_destino` FOREIGN KEY (`idDireccionDestino`) REFERENCES `direccion` (`id`),
  CONSTRAINT `FK_pedido_direccion_origen` FOREIGN KEY (`idDireccionOrigen`) REFERENCES `direccion` (`id`),
  CONSTRAINT `FK_pedido_estado_pedido` FOREIGN KEY (`idEstadoPedido`) REFERENCES `estado_pedido` (`id`),
  CONSTRAINT `FK_pedido_formas_pago` FOREIGN KEY (`idFormaPago`) REFERENCES `formas_pago` (`id`),
  CONSTRAINT `FK_pedido_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idusuario`)
);

