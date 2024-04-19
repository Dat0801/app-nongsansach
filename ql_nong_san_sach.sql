CREATE DATABASE CHNONGSAN
GO

USE CHNONGSAN

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
  SoLuongTon float DEFAULT 0,
  TrangThai bit DEFAULT 1
) 
GO

-- Tạo trigger trước khi chèn vào bảng "hanghoa"
CREATE TRIGGER insert_giaban
ON hanghoa
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;

    -- Tính toán giá bán và cập nhật cột GiaBan
    UPDATE hanghoa
    SET GiaBan = i.GiaNhap * i.HeSo
    FROM hanghoa
    INNER JOIN inserted i ON hanghoa.MaHang = i.MaHang;
END;
GO

-- Tạo trigger trước khi cập nhật bảng "hanghoa"
CREATE TRIGGER update_giaban
ON hanghoa
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    -- Kiểm tra xem giá nhập hoặc hệ số có thay đổi không
    IF UPDATE(GiaNhap) OR UPDATE(HeSo)
    BEGIN
        -- Tính toán giá bán và cập nhật cột GiaBan
        UPDATE hanghoa
        SET GiaBan = i.GiaNhap * i.HeSo
        FROM hanghoa
        INNER JOIN inserted i ON hanghoa.MaHang = i.MaHang;
    END;
END;
GO

INSERT INTO hanghoa (MaNhomHang, MaNCC, TenHang, DVT, HeSo, GiaNhap, HinhAnh, SoLuongTon) VALUES
(4, 1, N'Chuối già Nam Mỹ', N'Kg', 1.2, 25000, 'chuoiGia.jpg', 16.5),
(4, 2, N'Dưa hấu đỏ', N'Kg', 1.2, 12500, 'duaHauDo.jpg', 15),
(4, 1, N'Dưa lưới', N'Kg',  1.2, 45000, 'duaLuoi.jpg', 20),
(4, 2, N'Cam vàng nội địa Trung', N'Kg',  1.2, 40000, 'camVang.jpg', 20.5),
(4, 3, N'Nho xanh Nam Phi', N'Kg',  1.2, 125000, 'nhoXanh.jpg', 10.5),
(4, 4, N'Quýt giống Úc', N'Kg',  1.2, 40000, 'quytUc.jpg', 12.5),
(4, 3, N'Cam sành', N'Kg', 1.2, 12500, 'camSanh.jpg', 23),
(4, 5, N'Táo Autumn Mỹ', N'Kg', 1.2, 57500, 'taoMy.jpg', 8),
(4, 5, N'Ổi Đài Loan', N'Kg',  1.2, 17500, 'oiDaiLoan.jpg', 6),
(1, 1, N'Cải bẹ xanh', N'Kg', 1.2, 15000, 'caiBeXanh.jpg', 9),
(1, 1, N'Cải ngọt', N'Kg',  1.2, 15000, 'caiNgot.jpg', 6),
(1, 2, N'Cải thìa', N'Kg',  1.2, 15000, 'caiThia.jpg', 11),
(1, 3, N'Cải bẹ dún', N'Kg', 1.2, 15000, 'caiBeDun.jpg', 9),
(1, 3, N'Rau dền', N'Kg', 1.2, 12500, 'rauDen.jpg', 12),
(1, 2, N'Rau lang', N'Kg',  1.2, 15000, 'rauLang.jpg', 14),
(1, 4, N'Rau mồng tơi', N'Kg', 1.2, 12500, 'rauMongToi.jpg', 10.5),
(1, 5, N'Rau muống nước', N'Kg', 1.2, 7500, 'rauMuongNuoc.jpg', 13),
(1, 5, N'Rau ngót', N'Kg', 1.2, 15000, 'rauNgot.jpg', 5.2),
(1, 4, N'Rau tần ô', N'Kg', 1.2, 22500, 'rauTanO.jpg', 6.6),
(2, 1, N'Khoai lang Nhật', N'Kg', 1.2, 15000, 'khoaiLangNhat.jpg', 7),
(2, 2, N'Bí đỏ hồ lô', N'Kg',  1.2, 12500, 'biDoHoLo.jpg', 12),
(2, 1, N'Bí xanh', N'Kg', 1.2, 22500, 'biXanh.jpg', 7),
(2, 2, N'Cà chua', N'Kg',  1.2, 20000, 'caChua.jpg', 12),
(2, 3, N'Cà rốt', N'Kg', 1.2, 17500, 'caRot.jpg', 9),
(2, 3, N'Khoai tây', N'Kg', 1.2, 25000, 'khoaiTay.jpg', 15),
(2, 4, N'Củ cải trắng', N'Kg',  1.2, 15000, 'cuCaiTrang.jpg', 6),
(2, 5, N'Củ dền', N'Kg', 1.2, 25000, 'cuDen.jpg', 9),
(2, 5, N'Khoai mỡ', N'Kg',  1.2, 25000, 'khoaiMo.jpg', 10),
(2, 4, N'Ớt chuông', N'Kg', 1.2, 17500, 'otChuong.jpg', 8),
(3, 5, N'Nấm hương', N'Kg', 1.2, 190000, 'namHuong.jpg', 6),
(3, 4, N'Nấm bào ngư trắng', N'Kg',  1.2, 190000, 'namBaoNguTrang.jpg', 5),
(3, 5, N'Nấm kim châm', N'Kg', 1.2, 190000, 'namKimCham.jpg', 7),
(3, 4, N'Nấm mối đen', N'Kg', 1.2, 190000, 'namMoiDen.jpg', 4),
(3, 5, N'Nấm linh chi nâu', N'Kg', 1.2, 185000, 'namLinhChi.jpg', 6),
(3, 4, N'Nấm đùi gà', N'Kg', 1.2, 185000, 'namDuiGa.jpg', 3),
(3, 5, N'Nấm rơm', N'Kg',  1.2, 100000, 'namRom.jpg', 10),
(3, 4, N'Nấm Notaly', N'Kg',  1.2, 190000, 'namNotaly.jpg', 4),
(3, 5, N'Nấm tuyết', N'Kg',  1.2, 500000, 'namTuyet.jpg', 3),
(3, 5, N'Nấm mỡ nâu', N'Kg',  1.2, 290000, 'namMoNau.jpg', 7);

CREATE TABLE hoadon (
  MaHD int IDENTITY(1,1) NOT NULL,
  MaNV int NOT NULL,
  MaKH int DEFAULT NULL,
  NgayTao datetime DEFAULT GETDATE(),
  TongTien float DEFAULT 0,
  TrangThai nvarchar(50) DEFAULT N'Đã hoàn thành'
) 

INSERT INTO hoadon (MaNV, MaKH, TongTien) VALUES
(1, 1, 0),
(2, 2, 0),
(3, 3, 0),
(3, null, 0);

CREATE TABLE chitiethoadon (
  MaHang int NOT NULL,
  MaHD int NOT NULL,
  SoLuong int DEFAULT 1,
  ThanhTien float DEFAULT 0
);
GO

CREATE TRIGGER update_thanhtien
ON chitiethoadon
AFTER INSERT
AS
BEGIN
    -- Tính toán giá trị mới của ThanhTien và cập nhật
    UPDATE c
    SET ThanhTien = i.SoLuong * h.GiaBan
    FROM chitiethoadon c
    INNER JOIN inserted i ON c.MaHang = i.MaHang
    INNER JOIN hanghoa h ON c.MaHang = h.MaHang;
END;
GO

CREATE TRIGGER update_tongtien
ON chitiethoadon
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;
    UPDATE h
    SET TongTien = (SELECT SUM(ThanhTien) FROM chitiethoadon WHERE MaHD = i.MaHD)
    FROM hoadon h
    INNER JOIN inserted i ON h.MaHD = i.MaHD;
END;
GO

CREATE TRIGGER InsertChiTietHoaDonTrigger
ON chitiethoadon
AFTER INSERT
AS
BEGIN
    -- Cập nhật số lượng tồn của các mặt hàng trong bảng "hanghoa"
    UPDATE h
    SET h.SoLuongTon = h.SoLuongTon - c.SoLuong
    FROM hanghoa h
    INNER JOIN inserted c ON h.MaHang = c.MaHang;
END;
GO


INSERT INTO chitiethoadon (MaHang, MaHD, SoLuong, ThanhTien) VALUES
(1, 1, 2, 0),
(11, 2, 3, 0),
(12, 2, 3, 0),
(13, 3, 2, 0),
(14, 3, 5, 0),
(15, 4, 2, 0),
(16, 4, 4, 0),
(23, 1, 2, 0),
(36, 2, 3, 0);

CREATE TABLE phieunhap (
  MaPN int IDENTITY(1,1) NOT NULL,
  MaNV int NOT NULL,
  MaNCC int NOT NULL,
  NgayNhap datetime DEFAULT GETDATE(),
  TongTien float NOT NULL,
  TrangThai nvarchar(50) DEFAULT N'Đã nhập hàng'
) 

INSERT INTO phieunhap (MaNV, MaNCC, TongTien) VALUES
(1, 1, 2000000);

CREATE TABLE chitietphieunhap (
  MaPN int NOT NULL,
  MaHang int NOT NULL,
  GiaNhap int NOT NULL,
  SoLuong int DEFAULT 5,
  ThanhTien int DEFAULT 0
) 
GO

CREATE TRIGGER tinh_thanh_tien_insert ON chitietphieunhap
AFTER INSERT
AS
BEGIN
	UPDATE chitietphieunhap
    SET ThanhTien = i.GiaNhap * i.SoLuong
    FROM chitietphieunhap c
    INNER JOIN inserted i ON c.MaPN = i.MaPN and c.MaHang = i.MaHang;

	
END;
GO

CREATE TRIGGER tinh_tong_tien_insert ON chitietphieunhap
AFTER INSERT
AS
BEGIN
    UPDATE phieunhap
    SET TongTien = (SELECT SUM(ThanhTien) FROM chitietphieunhap WHERE MaPN = i.MaPN)
    FROM phieunhap
    INNER JOIN inserted i ON phieunhap.MaPN = i.MaPN;
END;
GO

CREATE TRIGGER update_gia_nhap_insert ON chitietphieunhap
AFTER INSERT
AS
BEGIN
    UPDATE hanghoa
    SET GiaNhap = i.GiaNhap
    FROM hanghoa
    INNER JOIN inserted i ON hanghoa.MaHang = i.MaHang
    WHERE hanghoa.GiaNhap < i.GiaNhap;
END;
GO

CREATE TRIGGER update_so_luong_insert ON chitietphieunhap
AFTER INSERT
AS
BEGIN
    UPDATE hanghoa
    SET SoLuongTon = hanghoa.SoLuongTon + i.SoLuong
    FROM hanghoa
    INNER JOIN inserted i ON hanghoa.MaHang = i.MaHang;
END;
GO


INSERT INTO chitietphieunhap (MaPN, MaHang, GiaNhap, SoLuong, ThanhTien) VALUES
(1, 1, 12500, 4, 0),
(1, 3, 50000, 5, 0),
(1, 6, 12000, 5, 0),
(1, 12, 8000, 5, 0),
(1, 15, 8000, 5, 0);

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

 -- Store procedure on table HangHoa
 -- Update HangHoa
 GO
 CREATE PROCEDURE sp_UpdateHangHoa
    @MaHang INT,
    @MaNhomHang INT,
    @MaNCC INT,
    @TenHang NVARCHAR(255),
    @DVT NVARCHAR(50),
    @GiaNhap DECIMAL(18, 2),
    @HeSo FLOAT,
    @HinhAnh NVARCHAR(255),
	@SoLuongTon FLOAT,
    @TrangThai NVARCHAR(50)
AS
BEGIN
    UPDATE hanghoa
    SET MaNhomHang = @MaNhomHang,
        MaNCC = @MaNCC,
        TenHang = @TenHang,
        DVT = @DVT,
        GiaNhap = @GiaNhap,
        HeSo = @HeSo,
        SoLuongTon = @SoLuongTon,
        HinhAnh = @HinhAnh,
        TrangThai = @TrangThai
    WHERE MaHang = @MaHang;
END
GO

-- Insert HangHoa
CREATE PROCEDURE sp_InsertHangHoa
    @MaNhomHang INT,
    @MaNCC INT,
    @TenHang NVARCHAR(255),
    @DVT NVARCHAR(50),
    @GiaNhap DECIMAL(18, 2),
    @HeSo FLOAT,
    @HinhAnh NVARCHAR(255),
	@SoLuongTon FLOAT,
    @TrangThai NVARCHAR(50)
AS
BEGIN
    INSERT INTO hanghoa (MaNhomHang, MaNCC, TenHang, DVT, GiaNhap, HeSo, HinhAnh, SoLuongTon, TrangThai)
    VALUES (@MaNhomHang, @MaNCC, @TenHang, @DVT, @GiaNhap, @HeSo, @HinhAnh, @SoLuongTon, @TrangThai);
END
GO

-- Login
CREATE PROCEDURE sp_Login
    @username NVARCHAR(50),
    @password NVARCHAR(50)
AS
BEGIN
    SELECT * FROM nhanvien WHERE UserName = @username AND Password = @password
END
