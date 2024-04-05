CREATE DATABASE CHNONGSAN
GO

USE CHNONGSAN

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
  TenHang nvarchar(50) NOT NULL,
  DVT nvarchar(30) DEFAULT N'Chưa xác định',
  GiaBan float DEFAULT 0,
  HeSo float DEFAULT 1.2,
  GiaNhap float NOT NULL,
  HinhAnh nvarchar(50) DEFAULT N'Chưa xác định',
  SoLuongTon int DEFAULT 0,
  TrangThai bit DEFAULT 1
) 

INSERT INTO hanghoa (MaNhomHang, MaNCC, TenHang, DVT, GiaBan, HeSo, GiaNhap, HinhAnh, SoLuongTon) VALUES
(4, 1, N'Chuối già Nam Mỹ', N'Kg', 20000, 1, 8000, 'chuoiGia.jpg', 16),
(4, 2, N'Dưa hấu đỏ', N'Kg', 12000, 1, 7000, 'duaHauDo.jpg', 8),
(4, 1, N'Dưa lưới', N'Kg', 70000, 1, 55000, 'duaLuoi.jpg', 12),
(4, 2, N'Cam vàng nội địa Trung', N'Kg', 41000, 1, 20000, 'camVang.jpg', 20),
(4, 3, N'Nho xanh Nam Phi', N'Kg', 140000, 1, 90000, 'nhoXanh.jpg', 8),
(4, 4, N'Dừa xiêm', N'Trái', 9000, 1, 4000, 'duaXiem.jpg', 10),
(4, 4, N'Quýt giống Úc', N'Kg', 45000, 1, 28000, 'quytUc.jpg', 12),
(4, 3, N'Cam sành', N'Kg', 18000, 1, 10000, 'camSanh.jpg', 23),
(4, 5, N'Táo Autumn Mỹ', N'Kg', 50500, 1, 27500, 'taoMy.jpg', 8),
(4, 5, N'Ổi Đài Loan', N'Kg', 21000, 1, 14000, 'oiDaiLoan.jpg', 6),
(1, 1, N'Cải bẹ xanh', N'Kg', 20000, 1, 7000, 'caiBeXanh.jpg', 9),
(1, 1, N'Cải ngọt', N'Kg', 19000, 1, 7500, 'caiNgot.jpg', 6),
(1, 2, N'Cải thìa', N'Kg', 18000, 1, 6000, 'caiThia.jpg', 11),
(1, 3, N'Cải bẹ dún', N'Kg', 31000, 1, 16500, 'caiBeDun.jpg', 9),
(1, 3, N'Rau dền', N'Kg', 20000, 1, 9000, 'rauDen.jpg', 12),
(1, 2, N'Rau lang', N'Kg', 28000, 1, 12000, 'rauLang.jpg', 14),
(1, 4, N'Rau mồng tơi', N'Kg', 20000, 1, 8500, 'rauMongToi.jpg', 6),
(1, 5, N'Rau muống nước', N'Kg', 20000, 1, 9000, 'rauMuongNuoc.jpg', 13),
(1, 5, N'Rau ngót', N'Kg', 48000, 1, 29500, 'rauNgot.jpg', 5),
(1, 4, N'Rau tần ô', N'Kg', 36000, 1, 21000, 'rauTanO.jpg', 6),
(2, 1, N'Khoai lang Nhật', N'Kg', 31500, 1, 23000, 'khoaiLangNhat.jpg', 7),
(2, 2, N'Bí đỏ hồ lô', N'Kg', 19000, 1, 9500, 'biDoHoLo.jpg', 12),
(2, 1, N'Bí xanh', N'Kg', 19500, 1, 11000, 'biXanh.jpg', 7),
(2, 2, N'Cà chua', N'Kg', 16000, 1, 9000, 'caChua.jpg', 12),
(2, 3, N'Cà rốt', N'Kg', 25000, 1, 12000, 'caRot.jpg', 9),
(2, 3, N'Khoai tây', N'Kg', 25000, 1, 13000, 'khoaiTay.jpg', 15),
(2, 4, N'Củ cải trắng', N'Kg', 22000, 1, 14000, 'cuCaiTrang.jpg', 6),
(2, 5, N'Củ dền', N'Kg', 36000, 1, 19500, 'cuDen.jpg', 9),
(2, 5, N'Khoai mỡ', N'Kg', 35000, 1, 26000, 'khoaiMo.jpg', 10),
(2, 4, N'Ớt chuông', N'Kg', 23000, 0.25, 73000, 'otChuong.jpg', 8),
(3, 5, N'Nấm hương', N'Kg', 28000, 0.15, 100000, 'namHuong.jpg', 6),
(3, 4, N'Nấm bào ngư trắng', N'Kg', 20000, 0.3, 51000, 'namBaoNguTrang.jpg', 5),
(3, 5, N'Nấm kim châm', N'Kg', 11000, 0.15, 55000, 'namKimCham.jpg', 7),
(3, 4, N'Nấm mối đen', N'Kg', 57500, 0.15, 300000, 'namMoiDen.jpg', 4),
(3, 5, N'Nấm linh chi', N'Kg', 33000, 0.15, 145000, 'namLinhChi.jpg', 6),
(3, 4, N'Nấm đùi gà', N'Kg', 25500, 0.2, 97000, 'namDuiGa.jpg', 3),
(3, 5, N'Nấm rơm', N'Kg', 30000, 0.18, 120000, 'namRom.jpg', 10),
(3, 4, N'Nấm Notaly', N'Kg', 18000, 0.2, 70000, 'namNotaly.jpg', 4),
(3, 5, N'Nấm tuyết', N'Kg', 30000, 0.05, 510000, 'namTuyet.jpg', 3),
(3, 5, N'Nấm mỡ nâu', N'Kg', 54000, 0.15, 280000, 'namMoNau.jpg', 7);

CREATE TABLE hoadon (
  MaHD int IDENTITY(1,1) NOT NULL,
  MaNV int NOT NULL,
  MaKH int DEFAULT NULL,
  NgayTao datetime DEFAULT GETDATE(),
  TongTien float DEFAULT 0,
  TrangThai nvarchar(50) DEFAULT N'Đang xử lý'
) 

INSERT INTO hoadon (MaNV, MaKH, NgayTao, TongTien) VALUES
(1, 1, '2024-04-04 15:19:11', 0);

CREATE TABLE khachhang (
  MaKH int IDENTITY(1,1) NOT NULL,
  TenKH nvarchar(50) NOT NULL,
  SDT nvarchar(30) DEFAULT N'Chưa xác định',
  DiaChi nvarchar(50) DEFAULT N'Chưa xác định',
  TrangThai bit DEFAULT 1
) 


INSERT INTO khachhang (TenKH, SDT, DiaChi) VALUES
(N'Nguyễn Văn Phú', '0987654321', N'Lê Trọng Tấn'),
(N'Trần Thị Dung', '0123456789', N'Bình Chánh'),
(N'Lê Văn Sỹ', '0912345678', N'Lạc Long Quân'),
(N'Phạm Thị Kim', '0876543210', N'Thành Thái'),
(N'Hoàng Văn Cường', '0965432187', N'Điện Biên Phủ');

CREATE TABLE nhacungcap (
  MaNCC int IDENTITY(1,1) NOT NULL,
  TenNCC nvarchar(50) NOT NULL,
  SDT nvarchar(30) DEFAULT N'Chưa xác định',
  DiaChi nvarchar(50) DEFAULT N'Chưa xác định',
  TrangThai bit DEFAULT 1
) 

INSERT INTO nhacungcap (TenNCC, SDT, DiaChi) VALUES
(N'LangFarm', '0765486382', N'Bình Thạnh'),
(N'Nông sản Nguyên Vy', '0765486383', N'Lâm Đồng'),
(N'SUNRISE INS', '0765486384', 'Tp.HCM'),
(N'Thành Nam', '0765486385', N'Bình Dương'),
(N'Nam Đô', '0765486386', N'Đà Nẵng');

CREATE TABLE nhanvien (
  MaNV int IDENTITY(1,1) NOT NULL,
  TenNV nvarchar(50) NOT NULL,
  SDT nvarchar(30) DEFAULT N'Chưa xác định',
  UserName nvarchar(30) NOT NULL,
  Password nvarchar(30) NOT NULL,
  ChucVu nvarchar(50) DEFAULT N'Nhân viên',
  DiaChi nvarchar(50) DEFAULT N'Chưa xác định',
  TrangThai bit DEFAULT 1
) 

INSERT INTO nhanvien (TenNV, SDT, UserName, Password, ChucVu, DiaChi) VALUES
(N'Nguyễn Văn Bình', '0897785658', 'admin', 'admin123', N'Quản lý', 'TPHCM'),
(N'Hồ Văn Cường', '0897785623', 'cuong', '123', N'Nhân viên', 'TPHCM'),
(N'Trương Thị Tuyết Linh', '0897785612', 'linh', '123', N'Nhân viên', 'TPHCM'),
(N'Võ Văn Minh', '0897785123', 'minh', '123', N'Nhân viên', 'TPHCM');

CREATE TABLE nhomhang (
  MaNhomHang int IDENTITY(1,1) NOT NULL,
  TenNhomHang nvarchar(50) NOT NULL,
  TrangThai bit DEFAULT 1
) 

INSERT INTO nhomhang (TenNhomHang) VALUES
(N'Rau'),
(N'Củ'),
(N'Nấm'),
(N'Trái cây');

CREATE TABLE phieunhap (
  MaPN int IDENTITY(1,1) NOT NULL,
  MaNV int NOT NULL,
  MaNCC int NOT NULL,
  NgayNhap datetime DEFAULT GETDATE(),
  TongTien float NOT NULL,
  TrangThai nvarchar(50) DEFAULT N'Đang xử lý'
) 

INSERT INTO phieunhap (MaNV, MaNCC, NgayNhap, TongTien, TrangThai) VALUES
(1, 1, '2024-04-04 15:33:29', 2000000, N'Đang xử lý');

ALTER TABLE khachhang
  ADD CONSTRAINT PK_KhachHang PRIMARY KEY (MaKH);
ALTER TABLE phieunhap
  ADD CONSTRAINT PK_PhieuNhap PRIMARY KEY (MaPN);
ALTER TABLE nhanvien
  ADD CONSTRAINT PK_NhanVien PRIMARY KEY (MaNV);
ALTER TABLE nhanvien
  ADD CONSTRAINT UQ_NhanVien_UserName UNIQUE (UserName);
ALTER TABLE nhacungcap
  ADD CONSTRAINT PK_NhaCungCap PRIMARY KEY (MaNCC);
ALTER TABLE nhacungcap
  ADD CONSTRAINT UQ_NhaCungCap_TenNCC UNIQUE (TenNCC);
ALTER TABLE hanghoa
  ADD CONSTRAINT PK_HangHoa PRIMARY KEY (MaHang);
ALTER TABLE hanghoa
  ADD CONSTRAINT UQ_HangHoa_TenHang UNIQUE (TenHang);
ALTER TABLE nhomhang
  ADD CONSTRAINT PK_NhomHang PRIMARY KEY (MaNhomHang);
ALTER TABLE nhomhang
  ADD CONSTRAINT UQ_NhomHang_TenNhomHang UNIQUE (TenNhomHang);
ALTER TABLE hoadon
  ADD CONSTRAINT PK_HoaDon PRIMARY KEY (MaHD);
ALTER TABLE hanghoa
  ADD CONSTRAINT FK_HangHoa_NhomHang FOREIGN KEY (MaNhomHang) REFERENCES nhomhang (MaNhomHang);
ALTER TABLE hanghoa
  ADD CONSTRAINT FK_HangHoa_NhaCungCap FOREIGN KEY (MaNCC) REFERENCES nhacungcap (MaNCC);

ALTER TABLE hoadon
  ADD CONSTRAINT FK_HoaDon_NhanVien FOREIGN KEY (MaNV) REFERENCES nhanvien (MaNV);
ALTER TABLE hoadon
  ADD CONSTRAINT FK_HoaDon_KhachHang FOREIGN KEY (MaKH) REFERENCES khachhang (MaKH);

ALTER TABLE phieunhap
  ADD CONSTRAINT FK_PhieuNhap_NhanVien FOREIGN KEY (MaNV) REFERENCES nhanvien (MaNV);
ALTER TABLE phieunhap
  ADD CONSTRAINT FK_PhieuNhap_NhaCungCap FOREIGN KEY (MaNCC) REFERENCES nhacungcap (MaNCC);
ALTER TABLE chitiethoadon
  ADD CONSTRAINT PK_ChiTietHoaDon PRIMARY KEY (MaHang, MaHD);
ALTER TABLE chitiethoadon
  ADD CONSTRAINT FK_ChiTietHoaDon_HoaDon FOREIGN KEY (MaHD) REFERENCES hoadon (MaHD);
ALTER TABLE chitietphieunhap
  ADD CONSTRAINT PK_ChiTietPhieuNhap PRIMARY KEY (MaPN, MaHang);
ALTER TABLE chitietphieunhap
  ADD CONSTRAINT FK_ChiTietPhieuNhap_MaHang FOREIGN KEY (MaHang) REFERENCES hanghoa (MaHang);
