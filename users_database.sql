-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 18, 2022 at 03:18 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `biodata`
--

CREATE TABLE `biodata` (
  `id` int(10) NOT NULL,
  `namaibu` varchar(100) NOT NULL,
  `namaayah` varchar(100) NOT NULL,
  `namabayi` varchar(100) NOT NULL,
  `usiabayi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `biodata`
--

INSERT INTO `biodata` (`id`, `namaibu`, `namaayah`, `namabayi`, `usiabayi`) VALUES
(1, 'ayu', 'agus', 'ina', '4bulan'),
(2, 'Dita ', 'Koko', 'Ihsan ', '4 bulan '),
(3, '-', '-', 'Efrida ', '3 bulan '),
(4, '-', '-', 'Muhammad Arkan Saputra ', '2 bulan '),
(5, '-', '-', 'Ratu Azzahra', '4 bulan '),
(6, '-', '-', 'Azka ', '1 bulan '),
(7, '-', '-', 'Mochammad Aldi ', '4 bulan '),
(8, '-', '-', 'Nawasena Khayri Achmad ', '3 bulan '),
(9, '-', '-', 'Aditya ', '4 bulan '),
(10, '-', '-', 'Niswa ', '4 bulan '),
(11, '-', '-', 'Alif Pramuditya ', '4 bulan '),
(12, '-', '-', 'Nabillah Aulia Aisyah', '2 bulan '),
(13, '-', '-', 'Arsena Malik', '7 bulan '),
(14, '-', '-', 'Arfa S ', '2 bulan '),
(15, '-', '-', 'Bagas Putr ', '0 bulan '),
(18, '-', '-', 'Bagas Putra ', '0 bulan '),
(19, '-', '-', 'Bintang Gemilang', '2 bulan '),
(20, '-', '-', 'Andrian ', '5 bulan '),
(21, '-', '-', 'Nugroho', '0 bulan '),
(22, '-', '-', 'Bima Cakra Winata', '0 bulan');

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_penyakit`
--

CREATE TABLE `riwayat_penyakit` (
  `id` int(10) NOT NULL,
  `get_namabayi` varchar(100) NOT NULL,
  `get_hasil_diagnosa` varchar(100) NOT NULL,
  `get_pengobatan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `riwayat_penyakit`
--

INSERT INTO `riwayat_penyakit` (`id`, `get_namabayi`, `get_hasil_diagnosa`, `get_pengobatan`) VALUES
(3, 'Nama Bayi : Elfrida ', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(4, 'Nama Bayi : Ratu Azzahra ', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(5, 'Nama Bayi : Azka ', 'Anda Menderita Penyakit :\nDermatitis Seboroik', 'Pengobatan :\nPengobatan dengan obat oles yang mengandung steroid'),
(6, 'Nama Bayi : Mochammad Aldi', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(7, 'Nama Bayi : Nawasena Khayri Achmad ', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(8, 'Nama Bayi : Aditya ', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(9, 'Nama Bayi : Niswa ', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(10, 'Nama Bayi : Alif Pramuditya ', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(11, 'Nama Bayi : Nabillah Aulia Aisyah ', 'Anda Menderita Penyakit :\nDermatitis Seboroik', 'Pengobatan :\nPengobatan dengan obat oles yang mengandung steroid'),
(12, 'Nama Bayi : Arsena Malik', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(13, 'Nama Bayi : Arfa S ', 'Anda Menderita Penyakit :\nDermatitis Seboroik', 'Pengobatan :\nPengobatan dengan obat oles yang mengandung steroid'),
(17, 'Nama Bayi : Bagas Putra ', 'Anda Menderita Penyakit :\nDermatitis Seboroik Leiners Disease', 'Pengobatan :\n Diberikan obat oles\n Obat minum seperti antihistamin\n Antibiotik bila dicurigai ada in'),
(18, 'Nama Bayi : Bintang Gemilang ', 'Anda Menderita Penyakit :', 'Pengobatan :'),
(19, 'Nama Bayi : Andrian ', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(20, 'Nama Bayi : Nugroho', 'Anda Menderita Penyakit :\nDermatitis Seboroik', 'Pengobatan :\nPengobatan dengan obat oles yang mengandung steroid'),
(21, 'Nama Bayi : Bima cakra winata', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(22, 'Nama Bayi : Muhammad Arkan Saputra ', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi'),
(23, 'Nama Bayi : Elfrida', 'Anda Menderita Penyakit :\nDermatitis Atopik', 'Pengobatan :\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat mi');

-- --------------------------------------------------------

--
-- Table structure for table `users_table`
--

CREATE TABLE `users_table` (
  `ID` int(11) NOT NULL,
  `username` text NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `mobile` text NOT NULL,
  `gender` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_table`
--

INSERT INTO `users_table` (`ID`, `username`, `email`, `password`, `mobile`, `gender`) VALUES
(1, 'bettyayu', 'bettyayu@gmail.com', 'Betty12345', '08999999', 'Female');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `riwayat_penyakit`
--
ALTER TABLE `riwayat_penyakit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_table`
--
ALTER TABLE `users_table`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `biodata`
--
ALTER TABLE `biodata`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `riwayat_penyakit`
--
ALTER TABLE `riwayat_penyakit`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `users_table`
--
ALTER TABLE `users_table`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
