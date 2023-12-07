-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2023 at 10:48 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tokoobat`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabelobat`
--

CREATE TABLE `tabelobat` (
  `id` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabelobat`
--

INSERT INTO `tabelobat` (`id`, `nama`, `stok`, `harga`) VALUES
('001', 'vitamin a', 235, 5000),
('002', 'vitamin b', 235, 6000);

-- --------------------------------------------------------

--
-- Table structure for table `tabelpemasok`
--

CREATE TABLE `tabelpemasok` (
  `id` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `nomorhp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabelpemasok`
--

INSERT INTO `tabelpemasok` (`id`, `nama`, `alamat`, `nomorhp`) VALUES
('01', 'pt.kosmetik', 'bogor', '0813314141'),
('02', 'pt.jaya', 'bogor', '0818979685');

-- --------------------------------------------------------

--
-- Table structure for table `tabelpembelian`
--

CREATE TABLE `tabelpembelian` (
  `tgl` date DEFAULT NULL,
  `id` varchar(50) NOT NULL,
  `pemasok` varchar(50) NOT NULL,
  `nama_obat` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabelpembelian`
--

INSERT INTO `tabelpembelian` (`tgl`, `id`, `pemasok`, `nama_obat`, `jumlah`, `harga`, `total`) VALUES
('2023-12-07', '0001', 'pt.kosmetik', 'vitamin a', 20, 4000, 80000);

-- --------------------------------------------------------

--
-- Table structure for table `tabelpenjualan`
--

CREATE TABLE `tabelpenjualan` (
  `tgl` date NOT NULL,
  `id` varchar(50) NOT NULL,
  `petugas` varchar(50) NOT NULL,
  `nama_obat` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabelpenjualan`
--

INSERT INTO `tabelpenjualan` (`tgl`, `id`, `petugas`, `nama_obat`, `jumlah`, `harga`, `total`) VALUES
('2023-12-07', '0001', 'rifqi', 'vitamin a', 10, 5000, 50000);

-- --------------------------------------------------------

--
-- Table structure for table `tabelpenjualansementara`
--

CREATE TABLE `tabelpenjualansementara` (
  `tgl` date NOT NULL,
  `id` varchar(50) NOT NULL,
  `petugas` varchar(50) NOT NULL,
  `nama_obat` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tabelpetugas`
--

CREATE TABLE `tabelpetugas` (
  `id` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `nomorhp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabelpetugas`
--

INSERT INTO `tabelpetugas` (`id`, `nama`, `username`, `password`, `alamat`, `nomorhp`) VALUES
('01', 'rifqi', 'admin', 'admin123', 'jakarta', '0812942194'),
('02', 'angga', 'koble', 'koble', 'kalisari', '08141421421');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabelpemasok`
--
ALTER TABLE `tabelpemasok`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabelpetugas`
--
ALTER TABLE `tabelpetugas`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
