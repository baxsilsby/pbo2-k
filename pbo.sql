-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2019 at 03:37 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idadmin` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nohp` varchar(15) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `idkota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hargapertqnian`
--

CREATE TABLE `hargapertqnian` (
  `idharga` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `tanggal` datetime NOT NULL,
  `idkota` int(11) NOT NULL,
  `idjenis` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hasilpertanian`
--

CREATE TABLE `hasilpertanian` (
  `idhasil` int(11) NOT NULL,
  `hasil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jenistanaman`
--

CREATE TABLE `jenistanaman` (
  `idjenis` int(11) NOT NULL,
  `idhasil` int(11) NOT NULL,
  `jenis` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kota`
--

CREATE TABLE `kota` (
  `idkota` int(11) NOT NULL,
  `namakota` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idadmin`),
  ADD KEY `idkota` (`idkota`);

--
-- Indexes for table `hargapertqnian`
--
ALTER TABLE `hargapertqnian`
  ADD PRIMARY KEY (`idharga`),
  ADD KEY `idkota` (`idkota`,`idjenis`),
  ADD KEY `idjenis` (`idjenis`);

--
-- Indexes for table `hasilpertanian`
--
ALTER TABLE `hasilpertanian`
  ADD PRIMARY KEY (`idhasil`);

--
-- Indexes for table `jenistanaman`
--
ALTER TABLE `jenistanaman`
  ADD PRIMARY KEY (`idjenis`),
  ADD KEY `idhasil` (`idhasil`);

--
-- Indexes for table `kota`
--
ALTER TABLE `kota`
  ADD PRIMARY KEY (`idkota`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `idadmin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hargapertqnian`
--
ALTER TABLE `hargapertqnian`
  MODIFY `idharga` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hasilpertanian`
--
ALTER TABLE `hasilpertanian`
  MODIFY `idhasil` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jenistanaman`
--
ALTER TABLE `jenistanaman`
  MODIFY `idjenis` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kota`
--
ALTER TABLE `kota`
  MODIFY `idkota` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`idkota`) REFERENCES `kota` (`idkota`);

--
-- Constraints for table `hargapertqnian`
--
ALTER TABLE `hargapertqnian`
  ADD CONSTRAINT `hargapertqnian_ibfk_1` FOREIGN KEY (`idjenis`) REFERENCES `jenistanaman` (`idjenis`),
  ADD CONSTRAINT `hargapertqnian_ibfk_2` FOREIGN KEY (`idkota`) REFERENCES `kota` (`idkota`);

--
-- Constraints for table `jenistanaman`
--
ALTER TABLE `jenistanaman`
  ADD CONSTRAINT `jenistanaman_ibfk_1` FOREIGN KEY (`idhasil`) REFERENCES `hasilpertanian` (`idhasil`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
