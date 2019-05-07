-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-06-2018 a las 17:27:42
-- Versión del servidor: 10.1.32-MariaDB
-- Versión de PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cajero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajero`
--

CREATE TABLE `cajero` (
  `codigo` int(1) NOT NULL,
  `dinero` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cajero`
--

INSERT INTO `cajero` (`codigo`, `dinero`) VALUES
(1, 54156);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `num_cuenta` int(28) NOT NULL,
  `saldo` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`num_cuenta`, `saldo`) VALUES
(11111, 3960),
(12345, 4540),
(22222, 59331),
(33333, 12090),
(55555, 70),
(66666, 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `id_movimiento` int(10) NOT NULL,
  `diferencia` int(11) NOT NULL,
  `positivo_negativo` int(11) NOT NULL COMMENT 'positivo - 1 negativo 0',
  `id_cuenta` int(28) NOT NULL,
  `saldo` int(11) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `movimientos`
--

INSERT INTO `movimientos` (`id_movimiento`, `diferencia`, `positivo_negativo`, `id_cuenta`, `saldo`, `fecha`) VALUES
(39, 303, 0, 33333, 12000, '2018-06-09 19:14:50'),
(40, 90, 1, 33333, 12090, '2018-06-09 19:15:02'),
(41, 90, 0, 33333, 12000, '2018-06-09 19:15:51'),
(42, 90, 0, 22222, 4747, '2018-06-09 19:16:45'),
(43, 20, 1, 22222, 4767, '2018-06-09 19:16:51'),
(44, 50, 0, 22222, 4717, '2018-06-09 19:17:09'),
(45, 90, 0, 22222, 4627, '2018-06-09 19:18:48'),
(46, 20, 0, 11111, 4840, '2018-06-09 19:19:50'),
(47, 20, 1, 11111, 4860, '2018-06-09 19:20:10'),
(48, 70, 1, 22222, 4697, '2018-06-09 19:28:40'),
(49, 90, 0, 22222, 4607, '2018-06-09 19:28:52'),
(50, 70, 0, 22222, 4537, '2018-06-09 19:29:02'),
(51, 70, 1, 22222, 4607, '2018-06-09 19:29:16'),
(52, 90, 0, 11111, 4770, '2018-06-09 23:37:45'),
(53, 70, 1, 11111, 4840, '2018-06-09 23:38:23'),
(54, 70, 1, 11111, 4910, '2018-06-09 23:38:30'),
(55, 4000, 0, 22222, 607, '2018-06-09 23:49:22'),
(56, 70, 0, 22222, 537, '2018-06-09 23:51:12'),
(57, 1, 0, 22222, 536, '2018-06-09 23:51:35'),
(58, 1, 0, 22222, 535, '2018-06-09 23:56:31'),
(59, 3333, 1, 22222, 3868, '2018-06-09 23:56:52'),
(60, 55553, 1, 22222, 59421, '2018-06-09 23:57:00'),
(61, 90, 0, 22222, 59331, '2018-06-10 02:46:34'),
(62, 90, 1, 33333, 12090, '2018-06-10 03:01:31'),
(63, 90, 1, 11111, 5000, '2018-06-10 12:10:05'),
(64, 90, 0, 11111, 4910, '2018-06-10 15:42:18'),
(65, 90, 0, 11111, 4820, '2018-06-10 15:43:19'),
(66, 70, 0, 11111, 4750, '2018-06-10 15:44:25'),
(67, 90, 0, 11111, 4660, '2018-06-10 15:44:34'),
(68, 70, 0, 11111, 4590, '2018-06-10 15:45:53'),
(69, 90, 0, 11111, 4500, '2018-06-10 16:23:00'),
(70, 90, 1, 12345, 4590, '2018-06-10 16:23:01'),
(71, 70, 0, 11111, 4430, '2018-06-10 16:23:40'),
(72, 70, 1, 12345, 4500, '2018-06-10 16:23:41'),
(73, 20, 0, 11111, 4410, '2018-06-10 16:24:11'),
(74, 20, 1, 12345, 4430, '2018-06-10 16:24:12'),
(75, 90, 0, 11111, 4320, '2018-06-10 16:29:21'),
(76, 90, 1, 66666, 90, '2018-06-10 16:29:21'),
(77, 20, 0, 11111, 4300, '2018-06-10 16:29:39'),
(78, 20, 1, 66666, 110, '2018-06-10 16:29:40'),
(79, 90, 0, 11111, 4210, '2018-06-10 16:33:47'),
(80, 90, 1, 12345, 4520, '2018-06-10 16:33:48'),
(81, 70, 0, 11111, 4140, '2018-06-10 16:34:17'),
(82, 70, 1, 55555, 70, '2018-06-10 16:34:18'),
(83, 90, 0, 11111, 4050, '2018-06-10 16:35:01'),
(84, 90, 1, 66666, 200, '2018-06-10 16:35:03'),
(85, 0, 0, 11111, 4050, '2018-06-10 16:47:36'),
(86, 0, 1, 12345, 4520, '2018-06-10 16:47:39'),
(87, 20, 0, 11111, 4030, '2018-06-10 16:48:30'),
(88, 20, 1, 12345, 4540, '2018-06-10 16:48:34'),
(89, 0, 0, 11111, 4030, '2018-06-10 16:48:38'),
(90, 0, 1, 12345, 4540, '2018-06-10 16:48:41'),
(91, 0, 0, 11111, 4030, '2018-06-10 16:48:53'),
(92, 0, 1, 12345, 4540, '2018-06-10 16:48:59'),
(93, 70, 0, 11111, 3960, '2018-06-10 16:56:01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE `tarjeta` (
  `id_cuenta` int(28) DEFAULT NULL,
  `activa` int(1) NOT NULL,
  `id` int(11) NOT NULL,
  `clave` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tarjeta`
--

INSERT INTO `tarjeta` (`id_cuenta`, `activa`, `id`, `clave`) VALUES
(33333, 1, 1, 2222),
(11111, 0, 2, 1111),
(33333, 0, 6, 6666),
(33333, 0, 11, 3333),
(22222, 0, 12, 2222),
(33333, 1, 22, 7777),
(11111, 0, 23, 3211);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `id_cuenta` int(28) NOT NULL,
  `Apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `id_cuenta`, `Apellidos`) VALUES
(3, 'Dian', 11111, 'Veselinov Atanasov'),
(4, 'Pepe', 22222, 'Sanchez Garcia'),
(5, 'Peter', 33333, 'Parker'),
(6, 'Jorgedsa', 66666, 'Gomezasdads'),
(7, 'Pereza', 12345, 'sMerez');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cajero`
--
ALTER TABLE `cajero`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`num_cuenta`),
  ADD UNIQUE KEY `num_tarjeta` (`num_cuenta`),
  ADD KEY `num_cuenta` (`num_cuenta`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`id_movimiento`),
  ADD KEY `id_cuenta` (`id_cuenta`),
  ADD KEY `id_cuenta_2` (`id_cuenta`);

--
-- Indices de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cuenta` (`id_cuenta`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `id_cuenta` (`id_cuenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `id_movimiento` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`id_cuenta`) REFERENCES `cuenta` (`num_cuenta`);

--
-- Filtros para la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD CONSTRAINT `tarjeta_ibfk_1` FOREIGN KEY (`id_cuenta`) REFERENCES `cuenta` (`num_cuenta`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_cuenta`) REFERENCES `cuenta` (`num_cuenta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
