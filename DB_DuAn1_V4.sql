CREATE DATABASE DuAn1_Velisa_V6
GO
USE DuAn1_Velisa_V6 -- Bản đã sửa 09/11/2023 by Long
GO

-- Mạnh
CREATE TABLE phan_quyen (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    ten_quyen NVARCHAR(50) NOT NULL
);

CREATE TABLE nhan_vien (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(50) NOT NULL,
    ten NVARCHAR(100) NOT NULL,
    ma_dinh_danh NVARCHAR(10) NOT NULL,
    so_dien_thoai NVARCHAR(15) NOT NULL,
    ngay_sinh DATE NOT NULL,
    email NVARCHAR(100) NOT NULL,
    gioi_tinh BIT NOT NULL,
    dia_chi NVARCHAR(200) NOT NULL,
    trang_thai BIT NOT NULL,
    id_phan_quyen BIGINT NOT NULL,
    thoi_gian_tao DATETIME NOT NULL DEFAULT GETDATE(),
    thoi_gian_sua DATETIME NOT NULL DEFAULT GETDATE(),
    FOREIGN KEY (id_phan_quyen) REFERENCES phan_quyen(id)
);

-- Thêm 5 bản ghi vào bảng phan_quyen
INSERT INTO phan_quyen (ten_quyen)
VALUES 
    (N'Quyền 1'),
    (N'Quyền 2'),
    (N'Quyền 3'),
    (N'Quyền 4'),
    (N'Quyền 5');

-- Thêm 5 bản ghi vào bảng nhan_vien
INSERT INTO nhan_vien (username, ten, ma_dinh_danh, so_dien_thoai, ngay_sinh, email, gioi_tinh, dia_chi, trang_thai, id_phan_quyen)
VALUES
    (N'user1', N'Nguyen Van A', N'MA001', N'0987654321', '1990-01-01', N'user1@example.com', 1, N'123 Đường ABC, Quận XYZ, TP HCM', 1, 1),
    (N'user2', N'Nguyen Van B', N'MA002', N'0987654322', '1995-02-15', N'user2@example.com', 0, N'456 Đường XYZ, Quận ABC, TP HCM', 1, 2),
    (N'user3', N'Nguyen Van C', N'MA003', N'0987654323', '1988-03-20', N'user3@example.com', 1, N'789 Đường DEF, Quận LMN, TP HCM', 0, 3), -- Đã thay đổi trạng thái thành nghỉ làm
    (N'user4', N'Nguyen Van D', N'MA004', N'0987654324', '1992-04-25', N'user4@example.com', 0, N'012 Đường UVW, Quận XYZ, TP HCM', 1, 4),
    (N'user5', N'Nguyen Van E', N'MA005', N'0987654325', '1997-05-30', N'user5@example.com', 1, N'345 Đường LMN, Quận DEF, TP HCM', 0, 5); -- Đã thay đổi trạng thái thành nghỉ làm
	
-- Long
CREATE TABLE NhaCungCap(
	IDNhaCungCap BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	TenNhaCungCap NVARCHAR(50) UNIQUE NOT NULL,
	MoTaNhaCungCap NVARCHAR(255) DEFAULT NULL,
	TrangThai BIT NOT NULL,
	SDTNhaCungCap VARCHAR(11) NOT NULL,
	EmailNhaCungCap VARCHAR(255) NOT NULL,
	HopDongThoaThuan VARCHAR(255) NOT NULL,
	ThoiGianTao DATETIME DEFAULT GETDATE(),
	ThoiGianSua DATETIME DEFAULT GETDATE()
)
INSERT INTO NhaCungCap(TenNhaCungCap,MoTaNhaCungCap,TrangThai,SDTNhaCungCap,EmailNhaCungCap,HopDongThoaThuan) 
	VALUES	(N'Xưởng đồ da Long Biên', N'Cung cấp đồ da bò chất lượng loại 1',1,'0969315806', 'philong.inco@gmail.com','xuongdodalongbien.docx'),
			(N'Xưởng đồ da Cầu Giấy', N'Cung cấp đồ da cá sấu chất lượng loại 2',1,'0976597684', 'vinhlong221097@gmail.com','xuongdodacaugiay.docx'),
			(N'Xưởng đồ da Thạch Bàn', N'Cung cấp đồ da đà điểu',1,'0976597333', 'jobdoda11@gmail.com','jobdoda11.docx'),
			(N'Xưởng đồ da Thái Bình', N'Cung cấp đồ da cừu',1,'0976597222', 'dodacaocap89@gmail.com','dodacaocap89.docx'),
			(N'Xưởng đồ da Vĩnh Long', N'Cung cấp đồ da PU cao cấp',1,'0976595555', 'dapuccaocaphn@gmail.com','dapuccaocaphn.docx')

CREATE TABLE Mau(
	IDMau BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	TenMau NVARCHAR(50) UNIQUE NOT NULL,
	MoTaMau NVARCHAR(255) DEFAULT NULL,
	TrangThai BIT NOT NULL
)
INSERT INTO Mau(TenMau,MoTaMau,TrangThai)
	VALUES	(N'Đỏ', N'Đỏ đậm sang trọng', 1),
			(N'Xanh lá', N'Xanh lá đặc biệt', 1),
			(N'Vàng', N'Vàng cam tinh tế', 1),
			(N'Xanh dương', N'Xanh dương năng động', 1),
			(N'Đen', N'Đen bí ẩn quý phái', 1),
			(N'Trắng', N'Trắng tinh tế', 0)

CREATE TABLE TheLoai(
	IDTheLoai BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	MaTheLoai VARCHAR(6) UNIQUE NOT NULL,
	TenTheLoai NVARCHAR(255) UNIQUE NOT NULL,
	MoTaTheLoai NVARCHAR(255) DEFAULT NULL,
	TrangThai BIT NOT NULL,
	ThoiGianTao DATETIME DEFAULT GETDATE(),
	ThoiGianSua DATETIME DEFAULT GETDATE()
)
SELECT t.IDTheLoai, t.MaTheLoai,t.TenTheLoai,t.MoTaTheLoai,t.TrangThai, t.ThoiGianTao, t.ThoiGianSua, COUNT(*)
	FROM TheLoai t 
	LEFT JOIN SanPham s ON t.IDTheLoai=s.IDTheLoai 
	GROUP BY t.IDTheLoai, t.MaTheLoai,t.TenTheLoai,t.MoTaTheLoai,t.TrangThai, t.ThoiGianTao, t.ThoiGianSua

INSERT INTO TheLoai(MaTheLoai,TenTheLoai,MoTaTheLoai,TrangThai)
	VALUES	('TL0001', N'Túi hàng hiệu', N'Túi xách hàng hiệu từ các nhãn hàng nổi tiếng', 1),
			('TL0002', N'Túi xách tay', N'Túi xách tay nhỏ gọn thời trang', 1),
			('TL0003', N'Túi đeo vai', N'Túi đeo vai tinh tế cách điệu', 1),
			('TL0004', N'Túi đeo chéo', N'Túi xách đeo chéo linh hoạt', 1),
			('TL0005', N'Balo nữ', N'Balo nữ thời trang', 0)

CREATE TABLE SanPham(
	IDSanPham BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	MaSanPham VARCHAR(6) NOT NULL,
	TenSanPham NVARCHAR(255) UNIQUE NOT NULL,
	MoTaSanPham NVARCHAR (255) NOT NULL,
	MainImage VARCHAR(255) NOT NULL,
	IDNhaCungCap BIGINT NOT NULL FOREIGN KEY REFERENCES NhaCungCap(IDNhaCungCap),
	TrangThai BIT NOT NULL,
	IDTheLoai BIGINT NOT NULL FOREIGN KEY REFERENCES TheLoai(IDTheLoai),
	IDNhanVien BIGINT NOT NULL FOREIGN KEY REFERENCES nhan_vien(id),
	ThoiGianTao DATETIME DEFAULT GETDATE(),
	ThoiGianSua DATETIME DEFAULT GETDATE()
)

INSERT INTO SanPham(MaSanPham,TenSanPham,MoTaSanPham,MainImage,IDNhaCungCap,TrangThai,IDTheLoai,IDNhanVien)
	VALUES	('SP0001',N'TÚI ĐEO VAI MINI', N'1 Ngăn lớn, 3 ngăn nhỏ','img/Untitled-1.png',1,1,3,1),
			('SP0002',N'TÚI XÁCH TAY DỄ THƯƠNG', N'1 Ngăn lớn, 3 ngăn nhỏ','img/Untitled-2.png',2,1,2,1),
			('SP0003',N'TÚI CHANNEL', N'1 Ngăn lớn, 3 ngăn nhỏ','img/Untitled-3.png',1,1,2,2),
			('SP0004',N'TÚI HERMES', N'1 Ngăn lớn, 3 ngăn nhỏ','img/Untitled-4.png',2,1,2,1),
			('SP0005',N'TÚI ĐEO VAI CỠ VỪA', N'1 Ngăn lớn, 3 ngăn nhỏ','img/Untitled-5.png',1,1,3,1),
			('SP0006',N'TÚI XÁCH TAY QUÝ PHÁI', N'1 Ngăn lớn, 3 ngăn nhỏ','img/Untitled-1.png',2,1,2,1),
			('SP0007',N'TÚI GUCCI', N'1 Ngăn lớn, 3 ngăn nhỏ','img/Untitled-3.png',1,1,2,2),
			('SP0008',N'TÚI LV', N'1 Ngăn lớn, 3 ngăn nhỏ','img/Untitled-4.png',2,1,2,1)

CREATE TABLE AnhSanPham(
	IDAnhSanPham BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Link VARCHAR(255) NOT NULL,
	IDSanPham BIGINT NOT NULL FOREIGN KEY REFERENCES SanPham(IDSanPham)
)
INSERT INTO AnhSanPham(Link,IDSanPham) VALUES
	('img/Untitled-1.png',1),
	('img/Untitled-1.png',1),
	('img/Untitled-1.png',1),
	('img/Untitled-1.png',1),

	('img/Untitled-1.png',2),
	('img/Untitled-1.png',2),
	('img/Untitled-1.png',2),
	('img/Untitled-1.png',2),

	('img/Untitled-1.png',3),
	('img/Untitled-1.png',3),
	('img/Untitled-1.png',3),
	('img/Untitled-1.png',3),

	('img/Untitled-1.png',4),
	('img/Untitled-1.png',4),
	('img/Untitled-1.png',4),
	('img/Untitled-1.png',4),

	('img/Untitled-1.png',5),
	('img/Untitled-1.png',5),
	('img/Untitled-1.png',5),
	('img/Untitled-1.png',5),

	('img/Untitled-1.png',6),
	('img/Untitled-1.png',6),
	('img/Untitled-1.png',6),
	('img/Untitled-1.png',6),

	('img/Untitled-1.png',7),
	('img/Untitled-1.png',7),
	('img/Untitled-1.png',7),
	('img/Untitled-1.png',7),

	('img/Untitled-1.png',8),
	('img/Untitled-1.png',8),
	('img/Untitled-1.png',8),
	('img/Untitled-1.png',8)


CREATE TABLE ChuongTrinhBanSi(
	IDChuongTrinhBanSi BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	SoLuong INT NOT NULL,
	GiaSiApDung FLOAT NOT NULL,
	TrangThai BIT NOT NULL,
	IDSanPham BIGINT NOT NULL FOREIGN KEY REFERENCES SanPham(IDSanPham),
	ThoiHanHieuLuc DATE NOT NULL,
	ThoiGianTao DATETIME DEFAULT GETDATE(),
	ThoiGianSua DATETIME DEFAULT GETDATE()
)
INSERT INTO ChuongTrinhBanSi(SoLuong,GiaSiApDung,TrangThai,IDSanPham,ThoiHanHieuLuc) VALUES
	(5, 250.500, 1, 1, '2023-12-01'),
	(10, 220.800, 1, 1, '2023-12-23'),
	(15, 200.700, 1, 1, '2023-12-22'),
	(30, 180.900, 1, 1, '2023-12-07'),

	(7, 550.900, 1, 2, '2023-12-25'),
	(9, 520.200, 1, 2, '2023-12-27'),
	(13, 490.600, 1, 2, '2023-12-27'),
	(40, 350.200, 1, 2, '2023-12-27')


CREATE TABLE SanPhamChiTiet(
	IDSanPhamChiTiet BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	SoLuong INT NOT NULL,
	TrangThai BIT NOT NULL,
	MainImage VARCHAR(255) NOT NULL,
	IDSanPham BIGINT NOT NULL FOREIGN KEY REFERENCES SanPham(IDSanPham),
	IDMau BIGINT NOT NULL FOREIGN KEY REFERENCES Mau(IDMau),
	GiaBan FLOAT NOT NULL
)
INSERT INTO SanPhamChiTiet(SoLuong,TrangThai,MainImage,IDSanPham,IDMau,GiaBan) VALUES
	(23, 1, 'tuideovaimini-1.png',1,1,350.000),
	(67, 1, 'tuideovaimini-2.png',1,3,340.000),
	(12, 1, 'tuideovaimini-3.png',1,1,370.000),
	(22, 1, 'tuixachtay-1.png',2,1, 630.000),
	(8, 1, 'tuixachtay-2.png',2,1, 650.000),
	(0, 0, 'tuixachtay-3.png',2,1,615.000)
	
CREATE TABLE SanPhamChiTietHistory(
	IDSanPhamChiTietHistory BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	SoLuong INT NOT NULL,
	TrangThai BIT NOT NULL,
	MainImage VARCHAR(255) NOT NULL,
	IDSanPham INT NOT NULL,
	IDLoaiKhoa INT NOT NULL,
	IDMau INT NOT NULL,
	IDChatLieu INT NOT NULL,
	GiaNiemYet FLOAT NOT NULL,
	GiaBan FLOAT NOT NULL,
	NgaySaoLuu DATE NOT NULL,
	IDSanPhamChiTiet BIGINT NOT NULL FOREIGN KEY REFERENCES SanPhamChiTiet(IDSanPhamChiTiet)
)
INSERT INTO SanPhamChiTietHistory(SoLuong,TrangThai,MainImage,IDSanPham,IDLoaiKhoa,IDMau,IDChatLieu,GiaNiemYet,GiaBan,NgaySaoLuu,IDSanPhamChiTiet) VALUES
	(23, 1, 'tuideovaimini-1.png',1,1,1,1,450.000,350.000, GETDATE(),1),
	(23, 1, 'tuideovaimini-1.png',1,1,1,1,750.000,750.000, GETDATE(),1),
	(23, 1, 'tuideovaimini-1.png',1,1,1,1,755.000,750.000, GETDATE(),1),
	(23, 1, 'tuideovaimini-1.png',1,1,1,1,754.000,750.000, GETDATE(),1),
	(23, 1, 'tuideovaimini-1.png',1,1,1,1,751.000,750.000, GETDATE(),1)
	
-- Yến
create table loai_voucher(
	id BIGINT identity(1,1) primary key,
	ten_loai_voucher nvarchar(100),
	mo_ta nvarchar(200)
)
INSERT INTO loai_voucher(ten_loai_voucher,mo_ta)
VALUES
	('Giảm giá', 'Loại voucher giảm giá sản phẩm hoặc dịch vụ.'),
	('Tặng quà', 'Loại voucher cho phép nhận quà tặng khi mua sản phẩm hoặc dịch vụ.'),
	('Miễn phí vận chuyển', 'Loại voucher miễn phí vận chuyển khi mua sản phẩm hoặc dịch vụ.'),
	('Khuyến mãi sinh nhật', 'Loại voucher đặc biệt dành cho sinh nhật khách hàng.'),
	('Quà tặng kèm', 'Loại voucher cho phép nhận quà tặng kèm sản phẩm hoặc dịch vụ mua.');
	
create table trang_thai_voucher(
	id BIGINT identity(1,1) primary key,
	ten_trang_thai nvarchar(100),
	mo_ta nvarchar(200),
	thoi_gian_sua date,
	thoi_gian_tao date
)
INSERT INTO trang_thai_voucher(ten_trang_thai,mo_ta,thoi_gian_sua,thoi_gian_tao)
VALUES
	('Hoạt động', 'Voucher đang hoạt động và có thể sử dụng.','2023-01-01', '2023-02-28'),
	('Hết hạn', 'Voucher đã hết hạn và không còn hiệu lực.', '2023-03-01', '2023-04-30'),
	('Chưa kích hoạt', 'Voucher đã được tạo nhưng chưa kích hoạt.', '2023-05-01', '2023-06-30'),
	('Hết lượt sử dụng', 'Voucher đã sử dụng hết số lần cho phép.', '2023-05-01', '2023-07-01'),
	('Chưa kích hoạt', 'Voucher chưa được kích hoạt và có thể sử dụng sau khi kích hoạt.','2023-05-01', '2023-09-01');
	
create table voucher(
	id_voucher BIGINT identity(1,1) primary key,
	ten_voucher nvarchar(50),
	loai_voucher nvarchar(200),
	ngay_bat_dau date,
	ngay_ket_thuc date,
	mo_ta nvarchar(200),
	so_lan_su_dung_toi_da int,
	dieu_kien nvarchar(200),
	trang_thai nvarchar(200),
	id_trang_thai BIGINT foreign key references trang_thai_voucher(id),
	id_loai_voucher BIGINT  foreign key references loai_voucher(id)
)
INSERT INTO voucher(ten_voucher, loai_voucher,ngay_bat_dau,ngay_ket_thuc,so_lan_su_dung_toi_da,dieu_kien,trang_thai,id_loai_voucher,id_trang_thai)
VALUES
	('Voucher Mùa Hè 2022', 'Giảm giá 20%', '2022-06-01', '2022-08-31', 200, 'Áp dụng cho túi xách da nữ', 'Hoạt động', 1, 1),
	('Khuyến Mãi Sinh Nhật', 'Giảm giá 15%', '2023-01-01', '2023-12-31', 150, 'Áp dụng cho sinh nhật', 'Hoạt động', 1, 1),
	('Voucher Hóa Đơn Trên $100', 'Giảm giá 10%', '2023-03-01', '2023-04-30', 100, 'Áp dụng cho hóa đơn trên $100', 'Hoạt động', 2, 1),
	('Voucher Chương Trình Học Tập', 'Giảm giá 15%', '2023-05-01', '2023-06-30', 150, 'Áp dụng cho túi xách cho học sinh', 'Hoạt động', 3, 1),
	('Voucher Chào Mừng Mùa Giáng Sinh', 'Giảm giá 25%', '2023-12-01', '2023-12-25', 200, 'Áp dụng cho mùa giáng sinh', 'Hoạt động', 4, 1);


	
-- Hùng --
CREATE TABLE khach_hang(
	id BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	ho_ten VARCHAR(50) NOT NULL,
	gioi_tinh BIT,
	sdt VARCHAR(12),
	dia_chi VARCHAR(255) ,
	email VARCHAR(125) NOT NULL,
	ngay_sinh DATE ,
	cap_bac int,
	thoi_gian_tao DATE,
	thoi_gian_sua DATE,
)

INSERT INTO khach_hang (ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua)
VALUES
    (N'Nguyen Van An', 1, '0987654321', N'Quỳnh Lưu - Nghệ An', 'nguyenvana@example.com', '2000-01-15', 1, GETDATE(), GETDATE()),
    (N'Tran Thi Bình', 0, '0123456789', N'Thanh Trì - Hà Nội', 'tranthib@example.com', '1995-05-20', 2, GETDATE(), GETDATE()),
    (N'Le Van Chính', 1, '0978563412', N'Đống đa - Hà Nội', 'levanc@example.com', '1980-09-10', 1, GETDATE(), GETDATE()),
    (N'Pham Van Dũng', 1, '0956743218', N'63 Lê đức thọ - Hà Nội', 'phamvand@example.com', '1992-03-25', 3, GETDATE(), GETDATE()),
    (N'Nguyen Thi Em', 0, '0912345678', N'Thanh Hóa', 'nguyenthe@example.com', '1998-07-30', 1, GETDATE(), GETDATE()),
    (N'Tran Van Phong', 1, '0945632178', N'Quỳnh Long - Nghệ An', 'tranvanf@example.com', '1975-11-05', 2, GETDATE(), GETDATE()),
    (N'Le Thi Giang', 0, '0909876543', N'Bình Định', 'lethig@example.com', '1988-12-12', 1, GETDATE(), GETDATE()),
    (N'Pham Thi Hương', 0, '0932167845', N'Đô Lương - Nghệ An', 'phamthih@example.com', '1990-02-28', 3, GETDATE(), GETDATE()),
    (N'Nguyen Van Yến', 1, '0965432178', N'Tràng an - Ninh Bình', 'nguyenvani@example.com', '2002-08-18', 1, GETDATE(), GETDATE()),
    (N'Tran Van Khiên', 1, '0978563421', N'Kiểu mai - Hà Nội', 'tranvank@example.com', '1994-06-10', 2, GETDATE(), GETDATE());

	-- Hóa đơn --
	CREATE TABLE HoaDon(
		IDHoaDon BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
		NgayTao DATE,
		GhiChu NVARCHAR(255),
		TongTienHoaDon FLOAT NOT NULL,
		TongTienSauKhuyenMai FLOAT NOT NULL,
		IDNhanVien BIGINT NOT NULL FOREIGN KEY REFERENCES nhan_vien(id),
		IDKhachHang BIGINT NOT NULL FOREIGN KEY REFERENCES khach_hang(id),
		IDVoucher BIGINT NOT NULL FOREIGN KEY REFERENCES voucher(id_voucher),
		TrangThai BIT NOT NULL,
		SoTienDaGiam FLOAT NOT NULL,
		TongTienPhaiTra FLOAT NOT NULL,
		TongSanPham INT NOT NULL,
		MaHoaDon VARCHAR(6) NOT NULL,
		ThoiGianSua DATETIME DEFAULT GETDATE(),
		THoiGianTao DATETIME DEFAULT GETDATE()
	)

INSERT INTO HoaDon (NgayTao, GhiChu, TongTienHoaDon, TongTienSauKhuyenMai, IDNhanVien, IDKhachHang, IDVoucher, TrangThai, SoTienDaGiam, TongTienPhaiTra, TongSanPham, MaHoaDon, ThoiGianSua, THoiGianTao)
VALUES
	('2023-11-01', 'Giao dịch mua hàng', 1000000, 900000, 1, 1, 1, 1, 10000, 890000, 5, 'HD0001', '2023-11-01 10:30:00', '2023-11-01 10:30:00'),
	('2023-11-02', 'Giao dịch mua hàng', 1500000, 1400000, 2, 2, 2, 1, 10000, 1390000, 7, 'HD0002', '2023-11-02 11:45:00', '2023-11-02 11:45:00'),
	('2023-11-03', 'Giao dịch mua hàng', 800000, 750000, 3, 3, 3, 1, 5000, 745000, 3, 'HD0003', '2023-11-03 12:15:00', '2023-11-03 12:15:00'),
	('2023-11-10', 'Giao dịch mua hàng', 1200000, 1100000, 4, 4, 4, 1, 10000, 1090000, 6, 'HD0010', '2023-11-10 14:20:00', '2023-11-10 14:20:00'),
	('2023-11-11', 'Giao dịch mua hàng', 900000, 850000, 1, 1, 1, 1, 5000, 845000, 4, 'HD0011', '2023-11-11 15:30:00', '2023-11-11 15:30:00'),
	('2023-11-12', 'Giao dịch mua hàng', 1100000, 1000000, 2, 2, 2, 1, 10000, 990000, 6, 'HD0012', '2023-11-12 16:45:00', '2023-11-12 16:45:00'),
	('2023-11-13', 'Giao dịch mua hàng', 750000, 700000, 3, 3, 3, 1, 5000, 695000, 2, 'HD0013', '2023-11-13 17:15:00', '2023-11-13 17:15:00'),
	('2023-11-14', 'Giao dịch mua hàng', 1300000, 1200000, 4, 4, 4, 1, 10000, 1190000, 7, 'HD0014', '2023-11-14 18:20:00', '2023-11-14 18:20:00'),
	('2023-11-15', 'Giao dịch mua hàng', 950000, 900000, 1, 1, 1, 1, 5000, 895000, 3, 'HD0015', '2023-11-15 19:30:00', '2023-11-15 19:30:00'),
	('2023-11-16', 'Giao dịch mua hàng', 1200000, 1100000, 2, 2, 2, 1, 10000, 1090000, 5, 'HD0016', '2023-11-16 20:45:00', '2023-11-16 20:45:00');

CREATE TABLE HoaDon_SanPham(
	ID BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	IDHoaDon BIGINT NOT NULL FOREIGN KEY REFERENCES HoaDon(IDHoaDon),
	IDSanPham BIGINT NOT NULL FOREIGN KEY REFERENCES SanPham(IDSanPham),
	GiaTien FLOAT NOT NULL,
	SoLuong INT NOT NULL
)
INSERT INTO HoaDon_SanPham(IDHoaDon, IDSanPham, GiaTien, SoLuong) VALUES 
	(1,2,470.83,2),
	(1,4,270.84,4),
	(2,3,470.81,7),
	(2,1,660.89,5),
	(3,2,220.82,1)
	
-- Nghĩa --
CREATE TABLE phieu_giao_hang (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    ma NVARCHAR(50),
    so_luong BIGINT,
    gia_tri BIGINT,
    gia_giam_toi_da BIGINT,
    gia_giam_toi_thieu BIGINT,
	thoi_gian_sua BIGINT,
	thoi_gian_tao BIGINT,
	mo_ta NVARCHAR(MAX),
    trang_thai BIT,
)

-- Thêm dữ liệu vào bảng phieu_giao_hang
INSERT INTO phieu_giao_hang (ma, so_luong, gia_tri, gia_giam_toi_da, gia_giam_toi_thieu, thoi_gian_sua, thoi_gian_tao, mo_ta, trang_thai)
VALUES
    ('MSP001', 10, 1000, 50, 10, 1636336800, 1636336800, N'Mô tả cho bản ghi 1', 1),
    ('MSP002', 5, 500, 30, 5, 1636336900, 1636336900, N'Mô tả cho bản ghi 2', 0),
    ('MSP003', 7, 700, 40, 8, 1636337000, 1636337000, N'Mô tả cho bản ghi 3', 1),
    ('MSP004', 8, 800, 45, 9, 1636337100, 1636337100, N'Mô tả cho bản ghi 4', 0),
    ('MSP005', 12, 1200, 60, 12, 1636337200, 1636337200, N'Mô tả cho bản ghi 5', 1),
    ('MSP006', 3, 300, 20, 4, 1636337300, 1636337300, N'Mô tả cho bản ghi 6', 0),
    ('MSP007', 9, 900, 50, 10, 1636337400, 1636337400, N'Mô tả cho bản ghi 7', 1),
    ('MSP008', 15, 1500, 70, 14, 1636337500, 1636337500, N'Mô tả cho bản ghi 8', 0),
    ('MSP009', 6, 600, 35, 7, 1636337600, 1636337600, N'Mô tả cho bản ghi 9', 1),
    ('MSP010', 11, 1100, 55, 11, 1636337700, 1636337700, N'Mô tả cho bản ghi 10', 0);

-- Tạo bảng id_sanphamchitiet_khuyenmai
CREATE TABLE id_khuyen_mai (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    ten_khuyen_mai NVARCHAR(100),
    phan_tram_giam_gia INT,
    thoi_gian_bat_dau BIGINT,
    thoi_gian_ket_thuc BIGINT,
    thoi_gian_sua BIGINT,
    thoi_gian_tao BIGINT
);

-- Thêm 10 bản ghi vào bảng id_khuyen_mai
INSERT INTO id_khuyen_mai (ten_khuyen_mai, phan_tram_giam_gia, thoi_gian_bat_dau, thoi_gian_ket_thuc, thoi_gian_sua, thoi_gian_tao)
VALUES
    (N'Khuyến mãi 1', 10, 1636336800, 1636337400, 1636336800, 1636336800),
    (N'Khuyến mãi 2', 20, 1636336900, 1636337500, 1636336900, 1636336900),
    (N'Khuyến mãi 3', 30, 1636337000, 1636337600, 1636337000, 1636337000),
    (N'Khuyến mãi 4', 40, 1636337100, 1636337700, 1636337100, 1636337100),
    (N'Khuyến mãi 5', 50, 1636337200, 1636337800, 1636337200, 1636337200),
    (N'Khuyến mãi 6', 10, 1636337300, 1636337400, 1636337300, 1636337300),
    (N'Khuyến mãi 7', 20, 1636337400, 1636337500, 1636337400, 1636337400),
    (N'Khuyến mãi 8', 30, 1636337500, 1636337600, 1636337500, 1636337500),
    (N'Khuyến mãi 9', 40, 1636337600, 1636337700, 1636337600, 1636337600),
    (N'Khuyến mãi 10', 50, 1636337700, 1636337800, 1636337700, 1636337700);


-- Tạo bảng id_sanphamchitiet_khuyenmai
CREATE TABLE id_sanphamchitiet_khuyenmai (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    id_san_pham_chi_tiet BIGINT,
    id_khuyen_mai BIGINT,
    xoa_mem BIT,
    thoi_gian_sua BIGINT,
    thoi_gian_tao BIGINT,
	--CONSTRAINT FK_id_sanphamchitiet FOREIGN KEY (id_san_pham_chi_tiet) REFERENCES id_san_pham_chi_tiet(id),
    CONSTRAINT FK_id_khuyenmai FOREIGN KEY (id_khuyen_mai) REFERENCES id_khuyen_mai(id)
);


-- Thêm 10 bản ghi vào bảng id_sanphamchitiet_khuyenmai
INSERT INTO id_sanphamchitiet_khuyenmai (id_san_pham_chi_tiet, id_khuyen_mai, xoa_mem, thoi_gian_sua, thoi_gian_tao)
VALUES
    (1, 1, 0, 1636336800, 1636336800),
    (2, 2, 1, 1636336900, 1636336900),
    (3, 3, 0, 1636337000, 1636337000),
    (4, 4, 1, 1636337100, 1636337100),
    (5, 5, 0, 1636337200, 1636337200),
    (6, 6, 1, 1636337300, 1636337300),
    (7, 7, 0, 1636337400, 1636337400),
    (8, 8, 1, 1636337500, 1636337500),
    (9, 9, 0, 1636337600, 1636337600),
    (10, 10, 1, 1636337700, 1636337700);

-- Luật --

create table trang_thai_phieu_doi(
	id BIGINT identity(1,1) primary key,
	ten_trang_thai nvarchar(50),
	mo_ta nvarchar(200)
)

create table ly_do_doi(
	id BIGINT identity(1,1) primary key,
	ly_do nvarchar(100),
	mo_ta nvarchar(200)
)

create table phieu_doi(
	id BIGINT identity(1,1) primary key,
	ghi_chu nvarchar(200),
	ngay_doi  date,
	id_hoa_don BIGINT,-- foreign key references hoa_don(id),
	id_trang_thai BIGINT foreign key references trang_thai_phieu_doi(id),
	id_nhan_vien BIGINT foreign key references NhanVien(id)
) 

create table phieu_doi_chi_tiet (
	id BIGINT identity(1,1) primary key,
	gia_ban float , 
	ten_san_pham nvarchar(100),
	mau nvarchar(50),
	chat_lieu nvarchar(100),
	so_luong_doi int,
	id_san_pham_chi_tiet BIGINT foreign key references SanPhamChiTiet(IDSanPhamChiTiet),
	id_phieu_doi BIGINT foreign key references phieu_doi(id)
)

create table ly_do_chi_tiet(
	id BIGINT identity(1,1) primary key,
	id_phieu_doi BIGINT foreign key references phieu_doi(id),
	id_ly_do_doi BIGINT foreign key references ly_do_doi(id)
)
INSERT INTO trang_thai_phieu_doi (ten_trang_thai, mo_ta)
VALUES
    ('Chờ xác nhận', 'Đang chờ xác nhận từ phía cửa hàng'),
    ('Đã xác nhận', 'Phiếu đổi đã được xác nhận'),
    ('Đã hoàn thành', 'Phiếu đổi đã hoàn thành'),
    ('Đã hủy', 'Phiếu đổi đã bị hủy'),
    ('Đang xử lý', 'Phiếu đổi đang trong quá trình xử lý');
INSERT INTO ly_do_doi (ly_do, mo_ta)
VALUES
    ('Sản phẩm bị rách', 'Sản phẩm bị rách do quá trình sản xuất hoặc quá trình vận chuyển.'),    
    ('Sản phẩm có dấu hiệu đã qua sử dụng', 'Sản phẩm có dấu vết cho thấy nó đã sử dụng trước đó.'),
    ('Sản phẩm không đúng với kích thước và màu sắc', 'Sản phẩm không đúng về kích thước hoặc màu sắc.'),
	('Sản phẩm lỗi', 'Sản phẩm bị lỗi trong quá trình sản xuất hoặc có vấn đề kỹ thuật.'),
    ('Lỗi kỹ thuật do nhà sản xuất', 'Sản phẩm gặp lỗi hoặc vấn đề kỹ thuật do quá trình sản xuất.');
INSERT INTO phieu_doi (ghi_chu, ngay_doi, id_hoa_don, id_trang_thai, id_nhan_vien)
VALUES
    ('Khách hàng đổi sản phẩm lỗi', '2023-11-06', 1, 1, 3),
    ('Khách hàng đổi sản phẩm không đúng màu', '2023-11-05', 2, 2, 2),
    ('Khách hàng đổi sản phẩm không đúng kích thước', '2023-11-04', 3, 1, 1),
    ('Khách hàng đổi sản phẩm bị rách', '2023-11-03', 4, 1, 4),
    ('Khách hàng đổi sản phẩm hỏng do quá trình vận chuyển', '2023-11-02', 5, 3, 5);
INSERT INTO phieu_doi_chi_tiet (gia_ban, ten_san_pham, mau, so_luong_doi, id_san_pham_chi_tiet, id_phieu_doi)
VALUES
    (25.5, 'Túi sách da bò', 'Đen',  2, 1, 1),
    (30.0, 'Túi sách da trâu', 'Xanh',  1, 2, 2),
    (15.0, 'Túi sách da heo', 'Trắng',  3, 3, 3),
    (40.0, 'Túi sách da cá sấu', 'Xám',  1, 4, 4),
    (12.5, 'Túi sách da cáo', 'Đỏ', 2, 5, 5);
INSERT INTO  ly_do_chi_tiet (id_phieu_doi, id_ly_do_doi)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

