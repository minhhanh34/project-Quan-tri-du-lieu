-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 10, 2022 lúc 12:29 PM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlsv`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diem`
--

CREATE TABLE `diem` (
  `MSSV` varchar(8) CHARACTER SET utf8 NOT NULL,
  `QuanTriHeThong` double NOT NULL,
  `PhanTichThietKeHeThong` double NOT NULL,
  `QuanTriDuLieu` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `diem`
--

INSERT INTO `diem` (`MSSV`, `QuanTriHeThong`, `PhanTichThietKeHeThong`, `QuanTriDuLieu`) VALUES
('B1234567', 9, 8.6, 8.7),
('B1900255', 10, 7.2, 8),
('B1901234', 5, 4.8, 7),
('B1909911', 9, 8.6, 8.7),
('B1910360', 8.6, 8.2, 8.8),
('B1998822', 9, 8.6, 8.7),
('B2109945', 7, 7, 7),
('B3001243', 6.5, 7, 8);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giangvien`
--

CREATE TABLE `giangvien` (
  `maGV` varchar(8) NOT NULL,
  `tenGV` varchar(50) NOT NULL,
  `tenMonHoc` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `giangvien`
--

INSERT INTO `giangvien` (`maGV`, `tenGV`, `tenMonHoc`) VALUES
('B0000245', 'Thái Minh Tuấn', 'Quản Trị Hệ Thống'),
('B0002255', 'Trần Công Án', 'Quản Trị Dữ Liệu'),
('B0002333', 'Trương Quốc Định', 'Phân Tích Thiết Kế Hệ Thống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `MSSV` varchar(8) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `DiaChi` text NOT NULL,
  `Lop` varchar(10) NOT NULL,
  `soDienThoai` decimal(10,0) NOT NULL,
  `gioiTinh` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`MSSV`, `Ten`, `DiaChi`, `Lop`, `soDienThoai`, `gioiTinh`) VALUES
('B1234567', 'Lê Văn Chuột', 'Cà Mau', '19A4V8', '1234567890', 'Nam'),
('B1900255', 'Hà Đức Huỳnh', 'Sóc Trăng', '19V7A4', '123456789', 'nam'),
('B1901234', 'Trần Dần', 'Mỹ Tho', '20V7A11', '345312123', 'Nam'),
('B1909911', 'Trịnh Minh Hạnh', 'Châu Thành, An Giang', '19V7A1', '123456789', 'Nam'),
('B1910360', 'Nguyễn Phát Đạt', 'Thoại Sơn, An Giang', '19V7A4', '123456789', 'Nam'),
('B1998822', 'Hồ Thị Đồ', 'Hà Giang', '19V7A1', '313521245', 'Nam'),
('B2109945', 'Trần Chí Phèo', 'DăK LăK', '19V7A1', '467436843', 'Nam'),
('B3001243', 'Nguyễn Thị Nở', 'Nghệ An', '18V7A5', '132454217', 'Nữ');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `diem`
--
ALTER TABLE `diem`
  ADD PRIMARY KEY (`MSSV`);

--
-- Chỉ mục cho bảng `giangvien`
--
ALTER TABLE `giangvien`
  ADD PRIMARY KEY (`maGV`);

--
-- Chỉ mục cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`MSSV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
