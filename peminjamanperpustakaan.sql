-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Jan 2021 pada 16.44
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `peminjamanperpustakaan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akunmahasiswa`
--

CREATE TABLE `akunmahasiswa` (
  `id_akun` int(10) NOT NULL,
  `universitas` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `akunmahasiswa`
--

INSERT INTO `akunmahasiswa` (`id_akun`, `universitas`) VALUES
(10000001, 'unila');

-- --------------------------------------------------------

--
-- Struktur dari tabel `akunpelajar`
--

CREATE TABLE `akunpelajar` (
  `id_akun` int(10) NOT NULL,
  `nama_sekolah` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `datapinjam`
--

CREATE TABLE `datapinjam` (
  `id_buku` int(10) NOT NULL,
  `nama_buku` varchar(100) DEFAULT NULL,
  `tanggal_pinjam` date DEFAULT NULL,
  `id_akun` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `datapinjam`
--

INSERT INTO `datapinjam` (`id_buku`, `nama_buku`, `tanggal_pinjam`, `id_akun`) VALUES
(17210, 'doujin 4646', '2021-01-19', 10000001);

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjam`
--

CREATE TABLE `peminjam` (
  `id_akun` int(10) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `peminjam`
--

INSERT INTO `peminjam` (`id_akun`, `email`, `password`) VALUES
(10000001, 'anggie.t17210@gmail.com', 'achi1234');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `akunmahasiswa`
--
ALTER TABLE `akunmahasiswa`
  ADD PRIMARY KEY (`id_akun`);

--
-- Indeks untuk tabel `akunpelajar`
--
ALTER TABLE `akunpelajar`
  ADD PRIMARY KEY (`id_akun`);

--
-- Indeks untuk tabel `datapinjam`
--
ALTER TABLE `datapinjam`
  ADD PRIMARY KEY (`id_buku`),
  ADD KEY `id_akun` (`id_akun`);

--
-- Indeks untuk tabel `peminjam`
--
ALTER TABLE `peminjam`
  ADD PRIMARY KEY (`id_akun`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `akunmahasiswa`
--
ALTER TABLE `akunmahasiswa`
  ADD CONSTRAINT `akunmahasiswa_ibfk_1` FOREIGN KEY (`id_akun`) REFERENCES `peminjam` (`id_akun`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `akunpelajar`
--
ALTER TABLE `akunpelajar`
  ADD CONSTRAINT `akunpelajar_ibfk_1` FOREIGN KEY (`id_akun`) REFERENCES `peminjam` (`id_akun`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `datapinjam`
--
ALTER TABLE `datapinjam`
  ADD CONSTRAINT `datapinjam_ibfk_1` FOREIGN KEY (`id_akun`) REFERENCES `peminjam` (`id_akun`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
