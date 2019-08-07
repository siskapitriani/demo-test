-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Agu 2019 pada 11.29
-- Versi server: 10.1.36-MariaDB
-- Versi PHP: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `cabang_bank`
--

CREATE TABLE `cabang_bank` (
  `kode_cabang` int(11) NOT NULL,
  `nama_cabang` varchar(100) NOT NULL,
  `alamat_cabang` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `cabang_bank`
--

INSERT INTO `cabang_bank` (`kode_cabang`, `nama_cabang`, `alamat_cabang`) VALUES
(163, 'Pasir Kaliki', 'Jl. Pasir Kaliki no. 65 Bandung'),
(164, 'Ahmad Yani', 'Jl. Ahmad Yani no. 9 Bandung'),
(165, 'Kawali', 'Jl. Mas Palembang no. 21 Kawali'),
(166, 'Cipaku', 'Jl. Buniseuri no. 189 Cipaku'),
(167, 'Talaga', 'Jl. Wahid Hasyim no. 109'),
(169, 'Cibenying Kidul', 'Jl. PHH. Mustofa no.19 Bandung'),
(170, 'Setiabudi', 'Jl. Dr.Setiabudi no. 65 Bandung'),
(173, 'Pagarsih', 'Jl. Pagarsih no.20 Bandung');

-- --------------------------------------------------------

--
-- Struktur dari tabel `nasabah`
--

CREATE TABLE `nasabah` (
  `nasabah_id` varchar(10) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `street` varchar(250) NOT NULL,
  `city` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `phone` varchar(14) NOT NULL,
  `email` varchar(100) NOT NULL,
  `no_rekening` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `nasabah`
--

INSERT INTO `nasabah` (`nasabah_id`, `last_name`, `first_name`, `street`, `city`, `state`, `phone`, `email`, `no_rekening`) VALUES
('3786869900', '', 'nurpaidah', 'Cikukut', 'Winduraja', 'Indonesia', '082118786656', 'nurpaidah@gmail.com', '1510098905661114'),
('3976543224', 'rosmiati', 'mia', 'Sukalaharja', 'Lumbung', 'Indonesia', '087666990897', 'mia.r@gmail.com', '1519892223097869'),
('3978886780', 'indriani', 'iin', 'pasir langgir', 'Selacai', 'Indonesia', '089778883341', 'iin.indriani@gmail.com', '1519088792341231'),
('3979905644', 'yulianti', 'yuni', 'Pangsor', 'Linggapura', 'Indonesia', '085786669908', 'yuyu@gmail.com', '0012445534436789'),
('4563332317', 'anggara', 'rangga', 'Nanas', 'Purwokerto', 'Indonesia', '081234432234', 'rangga.a@gmail.com', '0029899998880007'),
('4889876544', 'pajar bahari', 'ipaz', 'Cibolang', 'Panjalu', 'Indonesia', '087654465332', 'ipaz@gmail.com', '1519899998880007'),
('6764442342', 'rohmayani', 'yeyen', 'Gardu', 'Karangpawitan', 'Indonesia', '087666564453', 'yeyen.r@gmail.com', '1511110009998888'),
('6788768769', 'fajreha', 'andryawan', 'Tegal Gede', 'Karangpawitan', 'Indonesia', '089786546345', 'andriawan.f@gmail.com', '9856865876875239'),
('8976766677', 'ariyani', 'ria', 'Poronggol Raya', 'Kawali Mukti', 'Indonesia', '089778140243', 'ariyani@gmail.com', '4346567436549277');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rekening`
--

CREATE TABLE `rekening` (
  `no_rekening` varchar(16) NOT NULL,
  `kode_cabang` varchar(6) NOT NULL,
  `pin` varchar(6) NOT NULL,
  `saldo` bigint(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `rekening`
--

INSERT INTO `rekening` (`no_rekening`, `kode_cabang`, `pin`, `saldo`) VALUES
('0012445534436789', '167', '100909', 540000),
('0029899998880007', '163', '987768', 109890900),
('1510098905661114', '164', '787867', 2789007),
('1511110009998888', '166', '324343', 23050000),
('1519088792341231', '169', '421342', 6543332),
('1519892223097869', '170', '041675', 54750),
('1519899998880007', '165', '878003', 26900),
('4346567436549277', '170', '330300', 11300000),
('9856865876875239', '165', '425466', 46660000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `cabang_bank`
--
ALTER TABLE `cabang_bank`
  ADD PRIMARY KEY (`kode_cabang`);

--
-- Indeks untuk tabel `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`nasabah_id`),
  ADD UNIQUE KEY `no_rekening` (`no_rekening`);

--
-- Indeks untuk tabel `rekening`
--
ALTER TABLE `rekening`
  ADD PRIMARY KEY (`no_rekening`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `cabang_bank`
--
ALTER TABLE `cabang_bank`
  MODIFY `kode_cabang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=174;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
