CREATE DATABASE CHNONGSAN
GO
USE CHNONGSAN
GO

CREATE TABLE nhomhang (
    ma_nhomhang    INT IDENTITY PRIMARY KEY,
    ten_nhomhang   NVARCHAR(50)
)

INSERT INTO nhomhang (ten_nhomhang) VALUES (N'Trái cây');

CREATE TABLE hanghoa 
(
    ma_hang       INT  IDENTITY PRIMARY KEY,
    ma_nhomhang   INT,
    tenhang       NVARCHAR(50),
    dvt           NVARCHAR(20), 
    giaban INT,
    gianhap INT,
    hinhanh VARCHAR(50),
    soluongton INT,
    CONSTRAINT fk_hanhghoa_nhomhang FOREIGN KEY ( ma_nhomhang )
        REFERENCES nhomhang ( ma_nhomhang )
)

INSERT INTO hanghoa (MA_NHOMHANG, TENHANG, DVT, GIABAN, GIANHAP, HINHANH, SOLUONGTON)
VALUES
(1, N'Chuối', 'Kg', 10000, 80000, 'chuoi.jpg', 10);

CREATE TABLE nhacungcap
(
        ma_ncc INT  IDENTITY PRIMARY KEY,
        ten_ncc NVARCHAR(50),
        sdt_ncc varchar(11),
        diachi NVARCHAR(50)
)

CREATE TABLE nhanvien
(
    ma_nv INT  IDENTITY PRIMARY KEY,
    ten_nv NVARCHAR(50),
    sdt varchar(11),
    username varchar(30),
    password varchar(30),
    chuc_vu nvarchar(50),
)

CREATE TABLE khachhang
(
    ma_kh INT  IDENTITY PRIMARY KEY,
    ten_kh NVARCHAR(50),
    sdt varchar(11),
	diachi nvarchar(50)
)

CREATE TABLE hoadon
(
    ma_hd INT  IDENTITY PRIMARY KEY,
    ma_nv INT,
    ma_kh INT,
    ngay_tao Date,
    tongtien INT,
    CONSTRAINT fk_hoadon_nhanvien FOREIGN KEY ( ma_nv )
        REFERENCES nhanvien ( ma_nv ),
    CONSTRAINT fk_hoadon_khachhang FOREIGN KEY ( ma_kh )
        REFERENCES khachhang ( ma_kh )
)

CREATE TABLE chitiethoadon
(
    ma_hang INT,
    ma_hd INT,
    giaban INT,
    soluong int,
    thanhtien INT,
    constraint pk_chitiethoadon primary key (ma_hang, ma_hd),
    CONSTRAINT fk_chitiethoadon_mahang FOREIGN KEY ( ma_hang )
        REFERENCES hanghoa ( ma_hang ),
    CONSTRAINT fk_chitiethoadon_hoadon FOREIGN KEY ( ma_hd )
        REFERENCES hoadon ( ma_hd )
)

CREATE TABLE phieunhap
(
    ma_pn INT  IDENTITY PRIMARY KEY,
    ma_nv INT,
    ma_ncc INT,
    ngay_nhap Date,
    tongtien INT,
    CONSTRAINT fk_phieunhap_nhanvien FOREIGN KEY ( ma_nv )
        REFERENCES nhanvien ( ma_nv ),
    CONSTRAINT fk_phieunhap_nhacungcap FOREIGN KEY ( ma_ncc )
        REFERENCES nhacungcap ( ma_ncc ) 
)

CREATE TABLE chitietphieunhap
(
    ma_pn int,
    ma_hang int,
    gianhap INT,
    soluong int,
    thanhtien INT,
    constraint pk_chitietphieunhap primary key (ma_pn, ma_hang),
    CONSTRAINT fk_chitietphieunhap_mahang FOREIGN KEY ( ma_hang )
        REFERENCES hanghoa ( ma_hang ),
    CONSTRAINT fk_chitietphieunhap_phieunhap FOREIGN KEY ( ma_pn )
        REFERENCES phieunhap ( ma_pn ) 
)