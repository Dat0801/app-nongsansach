CREATE DATABASE QL_NONG_SAN_SACH
USE QL_NONG_SAN_SACH

CREATE TABLE chitiethoadon (
  MaHang int NOT NULL,
  MaHD int NOT NULL,
  SoLuong int DEFAULT 1,
  ThanhTien float DEFAULT 0
);

INSERT INTO chitiethoadon (MaHang, MaHD, SoLuong, ThanhTien) VALUES
(1, 1, 2, 0);

CREATE TABLE chitietphieunhap (
  MaPN int NOT NULL,
  MaHang int NOT NULL,
  GiaNhap int NOT NULL,
  SoLuong int DEFAULT 5,
  ThanhTien int DEFAULT 0
) 

INSERT INTO chitietphieunhap (MaPN, MaHang, GiaNhap, SoLuong, ThanhTien) VALUES
(1, 1, 50000, 5, 0);

CREATE TABLE hanghoa (
  MaHang int IDENTITY(1,1) NOT NULL,
  MaNhomHang int NOT NULL,
  MaNCC int NOT NULL,
  TenHang varchar(50) NOT NULL,
  DVT varchar(30) DEFAULT 'Chưa xác định',
  GiaBan float NOT NULL,
  HeSo float DEFAULT 1.2,
  GiaNhap float NOT NULL,
  HinhAnh varchar(50) DEFAULT 'Chưa xác định',
  SoLuongTon int DEFAULT 0,
  TrangThai bit DEFAULT 1
) 

INSERT INTO hanghoa (MaHang, MaNhomHang, MaNCC, TenHang, DVT, GiaBan, HeSo, GiaNhap, HinhAnh, SoLuongTon) VALUES
(1, 4, 1, 'Chuối già Nam Mỹ', 'Kg', 20000, 1, 8000, 'chuoiGia.jpg', 16),
(2, 4, 2, 'Dưa hấu đỏ', 'Kg', 12000, 1, 7000, 'duaHauDo.jpg', 8),
(3, 4, 1, 'Dưa lưới', 'Kg', 70000, 1, 55000, 'duaLuoi.jpg', 12),
(4, 4, 2, 'Cam vàng nội địa Trung', 'Kg', 41000, 1, 20000, 'camVang.jpg', 20),
(5, 4, 3, 'Nho xanh Nam Phi', 'Kg', 140000, 1, 90000, 'nhoXanh.jpg', 8),
(6, 4, 4, 'Dừa xiêm', 'Trái', 9000, 1, 4000, 'duaXiem.jpg', 10),
(7, 4, 4, 'Quýt giống Úc', 'Kg', 45000, 1, 28000, 'quytUc.jpg', 12),
(8, 4, 3, 'Cam sành', 'Kg', 18000, 1, 10000, 'camSanh.jpg', 23),
(9, 4, 5, 'Táo Autumn Mỹ', 'Kg', 50500, 1, 27500, 'taoMy.jpg', 8),
(10, 4, 5, 'Ổi Đài Loan', 'Kg', 21000, 1, 14000, 'oiDaiLoan.jpg', 6),
(11, 1, 1, 'Cải bẹ xanh', 'Kg', 20000, 1, 7000, 'caiBeXanh.jpg', 9),
(12, 1, 1, 'Cải ngọt', 'Kg', 19000, 1, 7500, 'caiNgot.jpg', 6),
(13, 1, 2, 'Cải thìa', 'Kg', 18000, 1, 6000, 'caiThia.jpg', 11),
(14, 1, 3, 'Cải bẹ dún', 'Kg', 31000, 1, 16500, 'caiBeDun.jpg', 9),
(15, 1, 3, 'Rau dền', 'Kg', 20000, 1, 9000, 'rauDen.jpg', 12),
(16, 1, 2, 'Rau lang', 'Kg', 28000, 1, 12000, 'rauLang.jpg', 14),
(17, 1, 4, 'Rau mồng tơi', 'Kg', 20000, 1, 8500, 'rauMongToi.jpg', 6),
(18, 1, 5, 'Rau muống nước', 'Kg', 20000, 1, 9000, 'rauMuongNuoc.jpg', 13),
(19, 1, 5, 'Rau ngót', 'Kg', 48000, 1, 29500, 'rauNgot.jpg', 5),
(20, 1, 4, 'Rau tần ô', 'Kg', 36000, 1, 21000, 'rauTanO.jpg', 6),
(21, 2, 1, 'Khoai lang Nhật', 'Kg', 31500, 1, 23000, 'khoaiLangNhat.jpg', 7),
(22, 2, 2, 'Bí đỏ hồ lô', 'Kg', 19000, 1, 9500, 'biDoHoLo.jpg', 12),
(23, 2, 1, 'Bí xanh', 'Kg', 19500, 1, 11000, 'biXanh.jpg', 7),
(24, 2, 2, 'Cà chua', 'Kg', 16000, 1, 9000, 'caChua.jpg', 12),
(25, 2, 3, 'Cà rốt', 'Kg', 25000, 1, 12000, 'caRot.jpg', 9),
(26, 2, 3, 'Khoai tây', 'Kg', 25000, 1, 13000, 'khoaiTay.jpg', 15),
(27, 2, 4, 'Củ cải trắng', 'Kg', 22000, 1, 14000, 'cuCaiTrang.jpg', 6),
(28, 2, 5, 'Củ dền', 'Kg', 36000, 1, 19500, 'cuDen.jpg', 9),
(29, 2, 5, 'Khoai mỡ', 'Kg', 35000, 1, 26000, 'khoaiMo.jpg', 10),
(30, 2, 4, 'Ớt chuông', 'Kg', 23000, 0.25, 73000, 'otChuong.jpg', 8),
(31, 3, 5, 'Nấm hương', 'Kg', 28000, 0.15, 100000, 'namHuong.jpg', 6),
(32, 3, 4, 'Nấm bào ngư trắng', 'Kg', 20000, 0.3, 51000, 'namBaoNguTrang.jpg', 5),
(33, 3, 5, 'Nấm kim châm', 'Kg', 11000, 0.15, 55000, 'namKimCham.jpg', 7),
(34, 3, 4, 'Nấm mối đen', 'Kg', 57500, 0.15, 300000, 'namMoiDen.jpg', 4),
(35, 3, 5, 'Nấm linh chi', 'Kg', 33000, 0.15, 145000, 'namLinhChi.jpg', 6),
(36, 3, 4, 'Nấm đùi gà', 'Kg', 25500, 0.2, 97000, 'namDuiGa.jpg', 3),
(37, 3, 5, 'Nấm rơm', 'Kg', 30000, 0.18, 120000, 'namRom.jpg', 10),
(38, 3, 4, 'Nấm Notaly', 'Kg', 18000, 0.2, 70000, 'namNotaly.jpg', 4),
(39, 3, 5, 'Nấm tuyết', 'Kg', 30000, 0.05, 510000, 'namTuyet.jpg', 3),
(40, 3, 5, 'Nấm mỡ nâu', 'Kg', 54000, 0.15, 280000, 'namMoNau.jpg', 7);

CREATE TABLE hoadon (
  MaHD int IDENTITY(1,1) NOT NULL,
  MaNV int NOT NULL,
  MaKH int DEFAULT NULL,
  NgayTao datetime DEFAULT GETDATE(),
  TongTien float DEFAULT 0,
  TrangThai varchar(50) DEFAULT 'Đang xử lý'
) 

INSERT INTO hoadon (MaHD, MaNV, MaKH, NgayTao, TongTien) VALUES
(1, 1, 1, '2024-04-04 15:19:11', 0);

CREATE TABLE khachhang (
  MaKH int IDENTITY(1,1) NOT NULL,
  TenKH varchar(50) NOT NULL,
  SDT varchar(30) DEFAULT 'Chưa xác định',
  DiaChi varchar(50) DEFAULT 'Chưa xác định',
  TrangThai bit DEFAULT 1
) 


INSERT INTO khachhang (MaKH, TenKH, SDT, DiaChi) VALUES
(1, 'Nguyễn Văn Phú', '0987654321', 'Lê Trọng Tấn'),
(2, 'Trần Thị Dung', '0123456789', 'Bình Chánh'),
(3, 'Lê Văn Sỹ', '0912345678', 'Lạc Long Quân'),
(4, 'Phạm Thị Kim', '0876543210', 'Thành Thái'),
(5, 'Hoàng Văn Cường', '0965432187', 'Điện Biên Phủ');

CREATE TABLE nhacungcap (
  MaNCC int IDENTITY(1,1) NOT NULL,
  TenNCC varchar(50) NOT NULL,
  SDT varchar(30) DEFAULT 'Chưa xác định',
  DiaChi varchar(50) DEFAULT 'Chưa xác định',
  TrangThai bit DEFAULT 1
) 

INSERT INTO nhacungcap (MaNCC, TenNCC, SDT, DiaChi) VALUES
(1, 'LangFarm', '0765486382', 'Bình Thạnh'),
(2, 'Nông sản Nguyên Vy', '0765486383', 'Lâm Đồng'),
(3, 'SUNRISE INS', '0765486384', 'Tp.HCM'),
(4, 'Thành Nam', '0765486385', 'Bình Dương'),
(5, 'Nam Đô', '0765486386', 'Đà Nẵng');

CREATE TABLE nhanvien (
  MaNV int IDENTITY(1,1) NOT NULL,
  TenNV varchar(50) NOT NULL,
  SDT varchar(30) DEFAULT 'Chưa xác định',
  UserName varchar(30) NOT NULL,
  Password varchar(30) NOT NULL,
  ChucVu varchar(50) DEFAULT 'Nhân viên',
  DiaChi varchar(50) DEFAULT 'Chưa xác định',
  TrangThai bit DEFAULT 1
) 

INSERT INTO nhanvien (MaNV, TenNV, SDT, UserName, Password, ChucVu, DiaChi) VALUES
(1, 'Nguyễn Văn Bình', '0897785658', 'admin', 'admin123', 'Quản lý', 'TPHCM'),
(2, 'Hồ Văn Cường', '0897785623', 'cuong', '123', 'Nhân viên', 'TPHCM'),
(3, 'Trương Thị Tuyết Linh', '0897785612', 'linh', '123', 'Nhân viên', 'TPHCM'),
(4, 'Võ Văn Minh', '0897785123', 'minh', '123', 'Nhân viên', 'TPHCM');

CREATE TABLE nhomhang (
  MaNhomHang int IDENTITY(1,1) NOT NULL,
  TenNhomHang varchar(50) NOT NULL,
  TrangThai bit DEFAULT 1
) 

INSERT INTO nhomhang (MaNhomHang, TenNhomHang, TrangThai) VALUES
(1, 'Rau'),
(2, 'Củ'),
(3, 'Nấm'),
(4, 'Trái cây');

CREATE TABLE phieunhap (
  MaPN int IDENTITY(1,1) NOT NULL,
  MaNV int NOT NULL,
  MaNCC int NOT NULL,
  NgayNhap datetime DEFAULT GETDATE(),
  TongTien float NOT NULL,
  TrangThai varchar(50) DEFAULT 'Đang xử lý'
) 

INSERT INTO phieunhap (MaPN, MaNV, MaNCC, NgayNhap, TongTien, TrangThai) VALUES
(1, 1, 1, '2024-04-04 15:33:29', 2000000, 'Đang xử lý');

ALTER TABLE chitiethoadon
  ADD CONSTRAINT PK_ChiTietHoaDon PRIMARY KEY (MaHang, MaHD)
ALTER TABLE chitiethoadon
  ADD CONSTRAINT FK_ChiTietHoaDon_HoaDon FOREIGN KEY (MaHD) REFERENCES hoadon (MaHD);

ALTER TABLE chitietphieunhap
  ADD CONSTRAINT PK_ChiTietPhieuNhap PRIMARY KEY (MaPN, MaHang)
ALTER TABLE chitietphieunhap
  ADD CONSTRAINT FK_ChiTietPhieuNhap_MaHang FOREIGN KEY (MaHang) REFERENCES hanghoa (MaHang);

ALTER TABLE hanghoa
  ADD CONSTRAINT PK_HangHoa PRIMARY KEY (MaHang)
ALTER TABLE hanghoa
  ADD CONSTRAINT UQ_HangHoa_TenHang UNIQUE (TenHang)
ALTER TABLE hanghoa
  ADD CONSTRAINT FK_HangHoa_NhomHang FOREIGN KEY (MaNhomHang) REFERENCES nhomhang (MaNhomHang)
ALTER TABLE hanghoa
  ADD CONSTRAINT FK_HangHoa_NhaCungCap FOREIGN KEY (MaNCC) REFERENCES nhacungcap (MaNCC)

ALTER TABLE hoadon
  ADD CONSTRAINT PK_HoaDon PRIMARY KEY (MaHD)
ALTER TABLE hoadon
  ADD CONSTRAINT FK_HoaDon_NhanVien FOREIGN KEY (MaNV) REFERENCES nhanvien (MaNV)
ALTER TABLE hoadon
  ADD CONSTRAINT FK_HoaDon_KhachHang FOREIGN KEY (MaKH) REFERENCES khachhang (MaKH);

ALTER TABLE khachhang
  ADD CONSTRAINT PK_KhachHang PRIMARY KEY (MaKH);

ALTER TABLE nhacungcap
  ADD CONSTRAINT PK_NhaCungCap PRIMARY KEY (MaNCC)
ALTER TABLE nhacungcap
  ADD CONSTRAINT UQ_NhaCungCap_TenNCC UNIQUE (TenNCC);

ALTER TABLE nhanvien
  ADD CONSTRAINT PK_NhanVien PRIMARY KEY (MaNV)
ALTER TABLE nhanvien
  ADD CONSTRAINT UQ_NhanVien_UserName UNIQUE (UserName);

ALTER TABLE nhomhang
  ADD CONSTRAINT PK_NhomHang PRIMARY KEY (MaNhomHang)
ALTER TABLE nhomhang
  ADD CONSTRAINT UQ_NhomHang_TenNhomHang UNIQUE (TenNhomHang);

ALTER TABLE phieunhap
  ADD CONSTRAINT PK_PhieuNhap PRIMARY KEY (MaPN)
ALTER TABLE phieunhap
  ADD CONSTRAINT FK_PhieuNhap_NhanVien FOREIGN KEY (MaNV) REFERENCES nhanvien (MaNV)
ALTER TABLE phieunhap
  ADD CONSTRAINT FK_PhieuNhap_NhaCungCap FOREIGN KEY (MaNCC) REFERENCES nhacungcap (MaNCC);

