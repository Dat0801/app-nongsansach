CREATE DATABASE CHNONGSAN
GO

USE CHNONGSAN

CREATE TABLE hanghoa (
  MaHang varchar(10) NOT NULL,
  MaNhomHang varchar(10) NOT NULL,
  MaNCC varchar(10) NOT NULL,
  TenHang nvarchar(50) NOT NULL,
  DVT nvarchar(30) DEFAULT N'Kg',
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

INSERT INTO hanghoa (MaHang, MaNhomHang, MaNCC, TenHang, DVT, HeSo, GiaNhap, HinhAnh, SoLuongTon) VALUES
('HH001', 'NH004', 'NCC001', N'Chuối già Nam Mỹ', N'Kg', 1.2, 25000, 'traicay\chuoiGia.jpg', 16.5),
('HH002', 'NH004', 'NCC002', N'Dưa hấu đỏ', N'Kg', 1.2, 12500, 'traicay\duaHauDo.jpg', 15),
('HH003', 'NH004', 'NCC001', N'Dưa lưới', N'Kg',  1.2, 45000, 'traicay\duaLuoi.jpg', 20),
('HH004', 'NH004', 'NCC002', N'Cam vàng nội địa Trung', N'Kg',  1.2, 40000, 'traicay\camVang.jpg', 20.5),
('HH005', 'NH004', 'NCC003', N'Nho xanh Nam Phi', N'Kg',  1.2, 125000, 'traicay\nhoXanh.jpg', 10.5),
('HH006', 'NH004', 'NCC004', N'Quýt giống Úc', N'Kg',  1.2, 40000, 'traicay\quytUc.jpg', 12.5),
('HH007', 'NH004', 'NCC003', N'Cam sành', N'Kg', 1.2, 12500, 'traicay\camSanh.jpg', 23),
('HH008', 'NH004', 'NCC005', N'Táo Autumn Mỹ', N'Kg', 1.2, 57500, 'traicay\taoMy.jpg', 8),
('HH009', 'NH004', 'NCC005', N'Ổi Đài Loan', N'Kg',  1.2, 17500, 'traicay\oiDaiLoan.jpg', 6),
('HH010', 'NH001', 'NCC001', N'Cải bẹ xanh', N'Kg', 1.2, 15000, 'rau\caiBeXanh.jpg', 9),
('HH011', 'NH001', 'NCC001', N'Cải ngọt', N'Kg',  1.2, 15000, 'rau\caiNgot.jpg', 6),
('HH012', 'NH001', 'NCC002', N'Cải thìa', N'Kg',  1.2, 15000, 'rau\caiThia.jpg', 11),
('HH013', 'NH001', 'NCC003', N'Cải bẹ dún', N'Kg', 1.2, 15000, 'rau\caiBeDun.jpg', 9),
('HH014', 'NH001', 'NCC003', N'Rau dền', N'Kg', 1.2, 12500, 'rau\rauDen.jpg', 12),
('HH015', 'NH001', 'NCC002', N'Rau lang', N'Kg',  1.2, 15000, 'rau\rauLang.jpg', 14),
('HH016', 'NH001', 'NCC004', N'Rau mồng tơi', N'Kg', 1.2, 12500, 'rau\rauMongToi.jpg', 10.5),
('HH017', 'NH001', 'NCC005', N'Rau muống nước', N'Kg', 1.2, 7500, 'rau\rauMuongNuoc.jpg', 13),
('HH018', 'NH001', 'NCC005', N'Rau ngót', N'Kg', 1.2, 15000, 'rau\rauNgot.jpg', 5.2),
('HH019', 'NH001', 'NCC004', N'Rau tần ô', N'Kg', 1.2, 22500, 'rau\rauTanO.jpg', 6.6),
('HH020', 'NH002', 'NCC001', N'Khoai lang Nhật', N'Kg', 1.2, 15000, 'cu\khoaiLangNhat.jpg', 7),
('HH021', 'NH002', 'NCC002', N'Bí đỏ hồ lô', N'Kg',  1.2, 12500, 'cu\biDoHoLo.jpg', 12),
('HH022', 'NH002', 'NCC001', N'Bí xanh', N'Kg', 1.2, 22500, 'cu\biXanh.jpg', 7),
('HH023', 'NH002', 'NCC002', N'Cà chua', N'Kg',  1.2, 20000, 'cu\caChua.jpg', 12),
('HH024', 'NH002', 'NCC003', N'Cà rốt', N'Kg', 1.2, 17500, 'cu\caRot.jpg', 9),
('HH025', 'NH002', 'NCC003', N'Khoai tây', N'Kg', 1.2, 25000, 'cu\khoaiTay.jpg', 15),
('HH026', 'NH002', 'NCC004', N'Củ cải trắng', N'Kg',  1.2, 15000, 'cu\cuCaiTrang.jpg', 6),
('HH027', 'NH002', 'NCC005', N'Củ dền', N'Kg', 1.2, 25000, 'cu\cuDen.jpg', 9),
('HH028', 'NH002', 'NCC005', N'Khoai mỡ', N'Kg',  1.2, 25000, 'cu\khoaiMo.jpg', 10),
('HH029', 'NH002', 'NCC004', N'Ớt chuông', N'Kg', 1.2, 17500, 'cu\otChuong.jpg', 8),
('HH030', 'NH003', 'NCC005', N'Nấm hương', N'Kg', 1.2, 190000, 'nam\namHuong.jpg', 6),
('HH031', 'NH003', 'NCC004', N'Nấm bào ngư trắng', N'Kg',  1.2, 190000, 'nam\namBaoNguTrang.jpg', 5),
('HH032', 'NH003', 'NCC005', N'Nấm kim châm', N'Kg', 1.2, 190000, 'nam\namKimCham.jpg', 7),
('HH033', 'NH003', 'NCC004', N'Nấm mối đen', N'Kg', 1.2, 190000, 'nam\namMoiDen.jpg', 4),
('HH034', 'NH003', 'NCC005', N'Nấm linh chi nâu', N'Kg', 1.2, 185000, 'nam\namLinhChi.jpg', 6),
('HH035', 'NH003', 'NCC004', N'Nấm đùi gà', N'Kg', 1.2, 185000, 'nam\namDuiGa.jpg', 3),
('HH036', 'NH003', 'NCC005', N'Nấm rơm', N'Kg',  1.2, 100000, 'nam\namRom.jpg', 10),
('HH037', 'NH003', 'NCC004', N'Nấm Notaly', N'Kg',  1.2, 190000, 'nam\namNotaly.jpg', 4),
('HH038', 'NH003', 'NCC005', N'Nấm tuyết', N'Kg',  1.2, 500000, 'nam\namTuyet.jpg', 3),
('HH039', 'NH003', 'NCC005', N'Nấm mỡ nâu', N'Kg',  1.2, 290000, 'nam\namMoNau.jpg', 7);

CREATE TABLE hoadon (
  MaHD varchar(10) NOT NULL,
  MaNV varchar(10) NOT NULL,
  MaKH varchar(10) DEFAULT 'KH000',
  NgayTao datetime DEFAULT GETDATE(),
  TongTien float DEFAULT 0,
  TrangThai nvarchar(50) DEFAULT N'Đã hoàn thành'
) 

INSERT INTO hoadon (MaHD, MaNV, MaKH, TongTien) VALUES
('HD001', 'NV001', 'KH001', 0),
('HD002', 'NV002', 'KH002', 0),
('HD003', 'NV003', 'KH003', 0);

CREATE TABLE chitiethoadon (
  MaHang varchar(10) NOT NULL,
  MaHD varchar(10) NOT NULL,
  SoLuong float DEFAULT 1,
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
('HH001', 'HD001', 2.5, 0),
('HH011', 'HD002', 3, 0),
('HH012', 'HD002', 3, 0),
('HH013', 'HD003', 2, 0),
('HH014', 'HD003', 5, 0),
('HH023', 'HD001', 2, 0),
('HH036', 'HD002', 3, 0);

CREATE TABLE phieunhap (
  MaPN varchar(10) NOT NULL,
  MaNV varchar(10) NOT NULL,
  MaNCC varchar(10) NOT NULL,
  NgayNhap datetime DEFAULT GETDATE(),
  TongTien float NOT NULL,
  TrangThai nvarchar(50) DEFAULT N'Đã nhập hàng'
) 



CREATE TABLE chitietphieunhap (
  MaPN varchar(10) NOT NULL,
  MaHang varchar(10) NOT NULL,
  GiaNhap float NOT NULL,
  SoLuong float DEFAULT 5,
  ThanhTien float DEFAULT 0
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




CREATE TABLE khachhang (
  MaKH varchar(10) NOT NULL,
  TenKH nvarchar(50) NOT NULL,
  SDT nvarchar(30) DEFAULT N'Chưa xác định',
  DiaChi nvarchar(50) DEFAULT N'Chưa xác định',
  TrangThai bit DEFAULT 1
) 


INSERT INTO khachhang (MaKH, TenKH, SDT, DiaChi) VALUES
('KH000', N'Khách Lẻ', N'Chưa xác định', N'Chưa xác định'),
('KH001', N'Nguyễn Văn Phú', '0946711010', N'Lê Trọng Tấn'),
('KH002', N'Trần Thị Dung', '0399839888', N'Bình Chánh'),
('KH003', N'Lê Văn Sỹ', '0798032455', N'Lạc Long Quân'),
('KH004', N'Phạm Thị Kim', '0977148512', N'Thành Thái'),
('KH005', N'Hoàng Văn Cường', '0397845124', N'Điện Biên Phủ');

CREATE TABLE nhacungcap (
  MaNCC varchar(10) NOT NULL,
  TenNCC nvarchar(50) NOT NULL,
  SDT nvarchar(30) DEFAULT N'Chưa xác định',
  DiaChi nvarchar(50) DEFAULT N'Chưa xác định',
  TrangThai bit DEFAULT 1
) 

INSERT INTO nhacungcap (MaNCC, TenNCC, SDT, DiaChi) VALUES
('NCC001', N'LangFarm', '0765486382', N'Bình Thạnh'),
('NCC002', N'Nông sản Nguyên Vy', '0765486383', N'Lâm Đồng'),
('NCC003', N'SUNRISE INS', '0765486384', 'Tp.HCM'),
('NCC004', N'Thành Nam', '0765486385', N'Bình Dương'),
('NCC005', N'Nam Đô', '0765486386', N'Đà Nẵng');

CREATE TABLE nhanvien (
  MaNV varchar(10) NOT NULL,
  TenNV nvarchar(50) NOT NULL,
  SDT nvarchar(30) DEFAULT N'Chưa xác định',
  UserName nvarchar(30) NOT NULL,
  Password nvarchar(30) NOT NULL,
  ChucVu nvarchar(50) DEFAULT N'Nhân viên',
  DiaChi nvarchar(50) DEFAULT N'Chưa xác định',
  TrangThai bit DEFAULT 1
) 

INSERT INTO nhanvien (MaNV, TenNV, SDT, UserName, Password, ChucVu, DiaChi) VALUES
('NV001', N'Nguyễn Văn Bình', '0897785658', 'admin', 'admin123', N'Quản lý', 'TPHCM'),
('NV002', N'Hồ Văn Cường', '0897785623', 'cuong', '123', N'Nhân viên', 'TPHCM'),
('NV003', N'Trương Thị Tuyết Linh', '0897785612', 'linh', '123', N'Nhân viên', 'TPHCM'),
('NV004', N'Võ Văn Minh', '0897785123', 'minh', '123', N'Nhân viên', 'TPHCM');

CREATE TABLE nhomhang (
  MaNhomHang varchar(10) NOT NULL,
  TenNhomHang nvarchar(50) NOT NULL,
  TrangThai bit DEFAULT 1
) 

INSERT INTO nhomhang (MaNhomHang, TenNhomHang) VALUES
('NH001', N'Rau'),
('NH002', N'Củ'),
('NH003', N'Nấm'),
('NH004', N'Trái cây');

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
ALTER TABLE chitiethoadon
  ADD CONSTRAINT FK_ChiTietHoaDon_HangHoa FOREIGN KEY (MaHang) REFERENCES hanghoa (MaHang);
ALTER TABLE chitietphieunhap
  ADD CONSTRAINT PK_ChiTietPhieuNhap PRIMARY KEY (MaPN, MaHang);
ALTER TABLE chitietphieunhap
  ADD CONSTRAINT FK_ChiTietPhieuNhap_MaPN FOREIGN KEY (MaPN) REFERENCES phieunhap (MaPN);
ALTER TABLE chitietphieunhap
  ADD CONSTRAINT FK_ChiTietPhieuNhap_MaHang FOREIGN KEY (MaHang) REFERENCES hanghoa (MaHang);

 -- Store procedure on table HangHoa
 -- Update HangHoa
 GO
 CREATE PROCEDURE sp_UpdateHangHoa
    @MaHang varchar(10),
    @MaNhomHang varchar(10),
    @MaNCC varchar(10),
    @TenHang NVARCHAR(255),
    @DVT NVARCHAR(50),
    @GiaNhap DECIMAL(18, 2),
    @HeSo FLOAT,
    @HinhAnh NVARCHAR(255),
	@SoLuongTon FLOAT
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
        HinhAnh = @HinhAnh
    WHERE MaHang = @MaHang;
END
GO

-- Insert HangHoa
CREATE PROCEDURE sp_InsertHangHoa
	@MaHang varchar(10),
    @MaNhomHang varchar(10),
    @MaNCC varchar(10),
    @TenHang NVARCHAR(255),
    @DVT NVARCHAR(50),
    @GiaNhap DECIMAL(18, 2),
    @HeSo FLOAT,
    @HinhAnh NVARCHAR(255),
	@SoLuongTon FLOAT
AS
BEGIN
    INSERT INTO hanghoa (MaHang, MaNhomHang, MaNCC, TenHang, DVT, GiaNhap, HeSo, HinhAnh, SoLuongTon)
    VALUES (@MaHang, @MaNhomHang, @MaNCC, @TenHang, @DVT, @GiaNhap, @HeSo, @HinhAnh, @SoLuongTon);
END
GO

-- Search HangHoa
CREATE PROCEDURE sp_SearchInHangHoa 
	@seachStr nvarchar(50)
AS
BEGIN
    SELECT * FROM hanghoa WHERE MaHang = @seachStr or TenHang like N'%' + @seachStr +  '%'
END
GO

-- Search HangHoa with MaHang
CREATE PROCEDURE sp_SearchHangHoaWithMaHang 
	@seachStr nvarchar(50)
AS
BEGIN
    SELECT * FROM hanghoa WHERE MaHang = @seachStr
END
GO

-- Get List HangHoa
CREATE PROCEDURE sp_getListHangHoa
	@trangThai int
AS
BEGIN
    SELECT * FROM hanghoa WHERE TrangThai = @trangThai;
END
GO

-- Get HangHoa
CREATE PROCEDURE sp_getHangHoa
	@MaHang varchar(10)
AS
BEGIN
	Select * from hanghoa where MaHang= @MaHang
END
GO

-- Get Last HangHoa
CREATE PROCEDURE sp_getLastHangHoa
AS
BEGIN
	SELECT TOP 1 * FROM hanghoa ORDER BY mahang DESC
END
GO

-- Delete HangHoa
CREATE PROCEDURE sp_deleteHangHoa
	@MaHang varchar(10)
AS
BEGIN
	Update hanghoa set TrangThai=0 where MaHang= @MaHang
END
GO

-- Recover HangHoa
CREATE PROCEDURE sp_recoverHangHoa
	@MaHang varchar(10)
AS
BEGIN
	Update hanghoa set TrangThai=1 where MaHang= @MaHang
END
GO

-- Get List HangHoa Theo MaNhom
CREATE PROCEDURE sp_getListHangHoaTheoMaNhom
	@MaNhom varchar(10)
AS
BEGIN
    SELECT * FROM hanghoa WHERE MaNhomHang = @MaNhom AND TrangThai = 1;
END
GO

--Procedure ChiTietHoaDon
--Get List ChiTietHoaDon
CREATE PROCEDURE sp_getListCTHD
AS
BEGIN
    SELECT chitiethoadon.MaHang, MaHD, TenHang, SoLuong, SoLuongTon, DVT, GiaBan, ThanhTien FROM chitiethoadon JOIN hanghoa ON chitiethoadon.MaHang = hanghoa.MaHang;
END
GO

--Get List ChiTietHoaDon Theo Ma
CREATE PROCEDURE sp_getListCTHDTheoMa
	@MaHD varchar(10)
AS
BEGIN
    SELECT chitiethoadon.MaHang, MaHD, TenHang, SoLuong, SoLuongTon, DVT, GiaBan, ThanhTien FROM chitiethoadon JOIN hanghoa ON chitiethoadon.MaHang = hanghoa.MaHang where MaHD = @MaHD;
END
GO

--Procedure KhachHang
-- Get List KhachHang
CREATE PROCEDURE sp_getListKhachHang
	@trangThai int
AS
BEGIN
    SELECT * FROM KhachHang WHERE TrangThai = @trangThai;
END
GO

-- Get KhachHang
CREATE PROCEDURE sp_getKhachHang
	@MaKH varchar(10)
AS
BEGIN
    SELECT * FROM KhachHang WHERE TrangThai = 1 AND MaKH = @MaKH;
END
GO

-- Get KhachHang theo sdt
CREATE PROCEDURE sp_getKhachHangTheoSDT
	@sdt nvarchar(30)
AS
BEGIN
    SELECT * FROM KhachHang WHERE TrangThai = 1 AND SDT = @sdt;
END
GO

-- Get Last KhachHang
CREATE PROCEDURE sp_getLastKhachHang
AS
BEGIN
	SELECT TOP 1 * FROM khachhang ORDER BY MaKH DESC
END
GO

-- Update KhachHang
CREATE PROCEDURE sp_updateKH
    @MaKH nvarchar(10),
    @TenKH NVARCHAR(50),
    @SDT VARCHAR(30),    
    @DiaChi NVARCHAR(50)    
AS
BEGIN
    UPDATE khachhang
    SET 
        TenKH = @TenKH,
        SDT = @SDT,
        DiaChi = @DiaChi        
    WHERE MaKH = @MaKH;
END
GO

-- Insert KhachHang
CREATE PROCEDURE sp_insertKH
    @MaKH nvarchar(10),
    @TenKH NVARCHAR(50),
    @SDT VARCHAR(30),    
    @DiaChi NVARCHAR(50)    
AS
BEGIN
    INSERT INTO khachhang(MaKH, TenKH, SDT, DiaChi)
    VALUES (@MaKH, @TenKH, @SDT, @DiaChi);
END

GO
-- Delete KhachHang
CREATE PROCEDURE sp_deleteKhachHang
	@MaKH varchar(10)
AS
BEGIN
	Update khachhang set TrangThai=0 where MaKH= @MaKH
END
GO

-- Recover KhachHang
CREATE PROCEDURE sp_recoverKhachHang
	@MaKH varchar(10)
AS
BEGIN
	Update khachhang set TrangThai=1 where MaKH= @MaKH
END
GO

-- Search KhachHang
CREATE PROCEDURE sp_SearchInKhachHang
	@seachStr nvarchar(50)
AS
BEGIN
    SELECT * FROM khachhang WHERE MaKH = @seachStr or TenKH like N'%' + @seachStr +  '%' or SDT like '%' + @seachStr +  '%' or DiaChi like '%' + @seachStr +  '%'
END
GO

--procedure hoadon
-- Get List KhachHang
CREATE PROCEDURE sp_getListHoaDon
	@trangThai int
AS
BEGIN
    SELECT * FROM HoaDon WHERE TrangThai = @trangThai;
END
GO

-- Get KhachHang
CREATE PROCEDURE sp_getHoaDon
	@MaHD varchar(10)
AS
BEGIN
    SELECT * FROM HoaDon WHERE TrangThai = 1 AND MaHD = @MaHD;
END
GO

-- get last hoadon
CREATE PROCEDURE sp_getLastHoaDon
AS
BEGIN
	SELECT TOP 1 * FROM HoaDon ORDER BY MaHD DESC
END
GO

-- Insert HoaDon
CREATE PROCEDURE sp_insertHoaDon
    @MaHD varchar(10),
    @MaNV varchar(10),
    @MaKH varchar(10),    
	@TongTien float
AS
BEGIN
    INSERT INTO hoadon(MaHD, MaNV, MaKH, TongTien)
    VALUES (@MaHD, @MaNV, @MaKH, @TongTien);
END
GO

-- Insert ChiTietHoaDon
CREATE PROCEDURE sp_insertChiTietHoaDon
    @MaHang varchar(10),
    @MaHD varchar(10),
	@SoLuong float,
	@ThanhTien float  
AS
BEGIN
    INSERT INTO chitiethoadon(MaHang, MaHD, SoLuong, ThanhTien)
    VALUES (@MaHang, @MaHD, @SoLuong, @ThanhTien);
END
GO

--procedure nhacungcap
--update
CREATE PROCEDURE sp_updateNCC
    @MaNCC nvarchar(10),
    @TenNCC NVARCHAR(50),
    @SDT VARCHAR(30),    
    @DiaChi NVARCHAR(50)    
AS
BEGIN
    UPDATE nhacungcap
    SET 
        TenNCC = @TenNCC,
        SDT = @SDT,
        DiaChi = @DiaChi        
    WHERE MaNCC = @MaNCC;
END
GO
--insert
CREATE PROCEDURE sp_insertNCC    
    @MaNCC nvarchar(10),
    @TenNCC NVARCHAR(50),
    @SDT VARCHAR(30),    
    @DiaChi NVARCHAR(50)  
AS
BEGIN
    INSERT INTO nhacungcap(MaNCC, TenNCC, SDT, DiaChi)
    VALUES (@MANCC, @TenNCC, @SDT, @DiaChi);
END
GO

--Procedure CTPN
--Get List CTPN
CREATE PROCEDURE sp_getListCTPN
AS
BEGIN
    SELECT chitietphieunhap.MaHang, MaPN, TenHang, SoLuong, SoLuongTon, DVT, chitietphieunhap.GiaNhap, GiaBan, ThanhTien FROM chitietphieunhap JOIN hanghoa ON chitietphieunhap.MaHang = hanghoa.MaHang;
END
GO
select * from chitietphieunhap
select * from phieunhap
select * from chitiethoadon
GO

CREATE PROCEDURE sp_getListCTPNTheoMa
	@MaPN varchar(10)
AS
BEGIN
    SELECT chitietphieunhap.MaHang, MaPN, TenHang, SoLuong, SoLuongTon, DVT, chitietphieunhap.GiaNhap, GiaBan, ThanhTien FROM chitietphieunhap JOIN hanghoa ON chitietphieunhap.MaHang = hanghoa.MaHang where MaPN = @MaPN;
END
GO

--procedure phieunhap
CREATE PROCEDURE sp_getListPN
AS
BEGIN
    SELECT * FROM phieunhap;
END
GO

-- Insert ChiTietHoaDon
CREATE PROCEDURE sp_insertCTPN
    @MaPN varchar(10),
    @MaHang varchar(10),
	@GiaNhap float,
	@SoLuong float,
	@ThanhTien float  
AS
BEGIN
    INSERT INTO chitietphieunhap(MaPN, MaHang, GiaNhap, SoLuong, ThanhTien)
    VALUES (@MaPN, @MaHang, @GiaNhap, @SoLuong, @ThanhTien);
END
GO
-- Get List HangHoa Theo MaNhom va MaNCC
CREATE PROCEDURE sp_getListHangHoaTheoMaNhomVaMaNCC
	@MaNhom varchar(10),
	@MaNCC varchar(10)
AS
BEGIN
    SELECT * FROM hanghoa WHERE MaNhomHang = @MaNhom AND MaNCC = @MaNCC AND TrangThai = 1;
END
GO
-- Get List HangHoa Theo MaNCC
CREATE PROCEDURE sp_getListHangHoaTheoMaNCC	
	@MaNCC varchar(10)
AS
BEGIN
    SELECT * FROM hanghoa WHERE MaNCC = @MaNCC AND TrangThai = 1;
END
GO
-- Procedure for account
-- Login
CREATE PROCEDURE sp_Login
    @username NVARCHAR(50),
    @password NVARCHAR(50)
AS
BEGIN
    SELECT * FROM nhanvien WHERE UserName = @username AND Password = @password
END
GO


-- Procedure ThongKe
-- Thong ke doanh thu theo ngay
CREATE PROCEDURE sp_DoanhThuTheoNgay  
AS
BEGIN
    SELECT TOP 7
        CONVERT(DATE, NgayTao) AS Ngay,
        SUM(TongTien) AS DoanhThu
    FROM hoadon
    GROUP BY CONVERT(DATE, NgayTao)
    ORDER BY Ngay
END
GO

-- Doanh thu va so hoa don ngay hien tai 
CREATE PROCEDURE sp_DoanhThuVaSoHoaDonHomNay
AS
BEGIN
    SELECT 
        CONVERT(DATE, GETDATE()) AS Ngay,
		COUNT(*) AS SoLuongHoaDon,
        SUM(TongTien) AS DoanhThu
    FROM hoadon
    WHERE CONVERT(DATE, NgayTao) = CONVERT(DATE, GETDATE());
END
GO

CREATE PROCEDURE sp_TangGiamPhanTramDoanhThu
AS
BEGIN
    DECLARE @DoanhThuHomNay DECIMAL(18, 2);
    SELECT 
        @DoanhThuHomNay = ISNULL(SUM(TongTien), 0)
    FROM hoadon
    WHERE CONVERT(DATE, NgayTao) = CONVERT(DATE, GETDATE());

    DECLARE @DoanhThuHomQua DECIMAL(18, 2);
    SELECT 
        @DoanhThuHomQua = ISNULL(SUM(TongTien), 0)
    FROM hoadon
    WHERE CONVERT(DATE, NgayTao) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()));

    DECLARE @PhanTramThayDoi DECIMAL(18, 2);

    IF @DoanhThuHomQua != 0
    BEGIN
        SET @PhanTramThayDoi = ((@DoanhThuHomNay - @DoanhThuHomQua) / @DoanhThuHomQua) * 100;
    END
    ELSE
    BEGIN
        IF @DoanhThuHomNay = 0
        BEGIN
            SET @PhanTramThayDoi = 0; 
        END
        ELSE
        BEGIN
            SET @PhanTramThayDoi = 100;
        END
    END
    SELECT 
        @PhanTramThayDoi AS PhanTramThayDoi;
END
GO

-- Thong ke hang hoa ban chay theo so luong
CREATE PROCEDURE sp_HangHoaBanChayTheoSoLuong  
AS
BEGIN
    SELECT TOP 10
    hanghoa.TenHang,
    SUM(chitiethoadon.SoLuong) AS SoLuong
	FROM 
    hanghoa JOIN chitiethoadon ON chitiethoadon.MaHang = hanghoa.MaHang
	GROUP BY hanghoa.TenHang
	ORDER BY SoLuong DESC
END
GO

--Procedure for phieunhap
CREATE PROCEDURE sp_getLastPhieuNhap
AS
BEGIN
	SELECT TOP 1 * FROM phieunhap ORDER BY MaPN DESC
END
GO

exec sp_getLastPhieuNhap
select * from phieunhap
select * from chitietphieunhap
select * from nhacungcap
select * from hoadon
select * from chitiethoadon
select * from hanghoa
go
--procedure insert
CREATE PROCEDURE sp_insertPN
    @MaPN varchar(10),
    @MaNV varchar(10),
    @MaNCC varchar(10),    
	@TongTien float
AS
BEGIN
    INSERT INTO phieunhap(MaPN, MaNV, MaNCC, TongTien)
    VALUES (@MaPN, @MaNV, @MaNCC, @TongTien);
END
