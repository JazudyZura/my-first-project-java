create database QLOrderCoffee
use QLOrderCoffee
go

--tao table ban ngoi

create table BanNgoi(
				MaBan INT IDENTITY PRIMARY KEY,
				TenBan NVARCHAR(100) NOT NULL DEFAULT N'Bàn chưa có tên',
				TrangThaiBan int NOT NULL DEFAULT 0	-- 0:Trống ||1: Có người
			);
			go


insert BanNgoi(TenBan,TrangThaiBan)
valu

create table LoaiFoods(
				MaLoaiFoods Varchar(5) PRIMARY KEY,
				TenLoaiFoods NVARCHAR(100) NOT NULL DEFAULT N'Chưa đặt tên'
			);
			go


CREATE TABLE Foods
(
	MaFoods INT IDENTITY PRIMARY KEY,
	TenFoods NVARCHAR(100) NOT NULL DEFAULT N'Chưa đặt tên',
	MaLoaiFoods Varchar(5) NOT NULL,
	GiaTien int NOT NULL DEFAULT 0
	
	FOREIGN KEY (MaLoaiFoods) REFERENCES LoaiFoods(MaLoaiFoods)
)
go


CREATE TABLE HoaDon
(
	MaHD INT IDENTITY PRIMARY KEY,
	MaBan INT NOT NULL,
	TimeDen DATETime NOT NULL DEFAULT GETDATE(),--thoi gian luc gọi món
	TimeThanhToan Datetime,
	TrangThaiHD NVARCHAR(100) NOT NULL DEFAULT N'Chưa thanh toán',	-- chưa thanh toán || đã thanh toán
	GiamGia int not null DEFAULT 0,
	TongTien int not null
	
	FOREIGN KEY (MaBan) REFERENCES BanNgoi(MaBan),
	
)
GO


CREATE TABLE ChiTietHD
(
	MaChiTietHD INT IDENTITY PRIMARY KEY,
	MaHD int not null,
	MaFoods INT NOT NULL,
	SoLuong int not null,
	
	FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
	FOREIGN KEY (MaFoods) REFERENCES Foods(MaFoods)
)
GO

-- nhap du lieu

--them loai foods
INSERT LoaiFoods
        (MaLoaiFoods, 
		TenLoaiFoods )
VALUES  ( 'CF',
		'Coffee'  -- name - nvarchar(100)
          )

INSERT LoaiFoods
        ( MaLoaiFoods,
		TenLoaiFoods )
VALUES  ( 'MT',
		'MilkTea'  -- name - nvarchar(100)
          )

INSERT LoaiFoods
        ( MaLoaiFoods,
		TenLoaiFoods )
VALUES  ( 'BK',
		'Bakery'  -- name - nvarchar(100)
          )
go

-- them nuoc banh
INSERT dbo.Foods
        ( TenFoods, MaLoaiFoods, GiaTien )
VALUES  ( 'AMERICANO', -- name - nvarchar(100)
          'CF', -- idCategory - int
          35000),
		  (
		  'CAPPUCCINO', -- name - nvarchar(100)
          'CF', -- idCategory - int
          35000
		  )

INSERT dbo.Foods
        ( TenFoods, MaLoaiFoods, GiaTien )
VALUES  ( 'CARAMEL MACCHIATO', -- name - nvarchar(100)
          'CF', -- idCategory - int
          55000),
		  (
		  'ESPRESSO Milk', -- name - nvarchar(100)
          'CF', -- idCategory - int
          45000
		  ),
		  (
		  'ESPRESSO', -- name - nvarchar(100)
          'CF', -- idCategory - int
          30000
		  ),
		  (
		  'LATTE', -- name - nvarchar(100)
          'CF', -- idCategory - int
          45000
		  ),
		  (
		  'MOCHA', -- name - nvarchar(100)
          'CF', -- idCategory - int
          49000
		  ),
		  (
		  'VIETNAMESE WHITE COFFEE', -- name - nvarchar(100)
          'CF', -- idCategory - int
          29000
		  )

INSERT dbo.Foods
        ( TenFoods, MaLoaiFoods, GiaTien )
VALUES  ( 'BLACK TEA MACCHIATO', -- name - nvarchar(100)
          'MT', -- idCategory - int
          38000),
		  (
		  'FLAVOURED TEA', -- name - nvarchar(100)
          'MT', -- idCategory - int
          35000
		  ),
		  (
		  'MATCHA ICE BLENDED', -- name - nvarchar(100)
          'MT', -- idCategory - int
          59000
		  ),
		  (
		  'MATCHA LATTE', -- name - nvarchar(100)
          'MT', -- idCategory - int
          45000
		  ),
		  (
		  'PEACH TEA MANIA', -- name - nvarchar(100)
          'MT', -- idCategory - int
          42000
		  ),
		  (
		  'RASPBERRY MACCHIATO', -- name - nvarchar(100)
          'MT', -- idCategory - int
          42000
		  ),
		  (
		  'HOT BLACK TEA', -- name - nvarchar(100)
          'MT', -- idCategory - int
          35000
		  )

go

INSERT dbo.Foods
        ( TenFoods, MaLoaiFoods, GiaTien )
VALUES  ( 'Cookies Dừa', -- name - nvarchar(100)
          'BK', -- idCategory - int
          13000),
		  (
		  'Blueberry Muffin', -- name - nvarchar(100)
          'BK', -- idCategory - int
          23000
		  ),
		   (
		  'Chocolate Muffin', -- name - nvarchar(100)
          'BK', -- idCategory - int
          25000
		  ),
		   (
		  'Pudding', -- name - nvarchar(100)
          'BK', -- idCategory - int
          22000
		  ),
		   (
		  'Brownie', -- name - nvarchar(100)
          'BK', -- idCategory - int
          28000
		  ),
		   (
		  'Orange Vani', -- name - nvarchar(100)
          'BK', -- idCategory - int
          32000
		  ),
		   (
		  'Blueberry Vani', -- name - nvarchar(100)
          'BK', -- idCategory - int
          32000
		  ),
		   (
		  'Marble Cheesecake', -- name - nvarchar(100)
          'BK', -- idCategory - int
          38000
		  ),
		   (
		  'Lemon Cream Cake', -- name - nvarchar(100)
          'BK', -- idCategory - int
          35000
		  )
go


--them ban
DECLARE @i INT = 1

WHILE @i <= 10
BEGIN
	INSERT dbo.BanNgoi(TenBan)VALUES  ( N'Bàn ' + CAST(@i AS nvarchar(100)))
	SET @i = @i + 1
END

go


--cau truy vấn

select dbo.BanNgoi.MaBan,dbo.BanNgoi.TenBan,dbo.BanNgoi.TrangThaiBan from dbo.BanNgoi 

select * from Foods
select *from LoaiFoods

update BanNgoi set TrangThaiBan=1 where MaBan='3'
select MaLoaiFoods from LoaiFoods where TenLoaiFoods=N'Coffee'

select * from Foods where MaFoods='12'
--them bill
insert HoaDon
		(MaBan,TimeDen,TimeThanhToan,GiamGia,TrangThaiHD,TongTien)
values	
		(3,
		GETDATE(),
		null,
		0,
		N'Chưa thanh toán',
		70000)

insert HoaDon
		(MaBan,TimeDen,TimeThanhToan,GiamGia,TrangThaiHD,TongTien)
values	
		(3,
		GETDATE(),
		GETDATE(),
		0,
		N'Đã Thanh Toán',
		70000)

		go


insert ChiTietHD(MaHD,MaFoods,SoLuong)
values (3,
		1,
		1)


select * from ChiTietHD
select * from HoaDon
select * from Foods where MaLoaiFoods='CF'
select count(*) from Foods where MaLoaiFoods='MT'
select count(*) from Foods where MaLoaiFoods='BK'
select count(*)from BanNgoi where TrangThaiBan=1

--trả về bàng chi tiết hóa đơn từ câu lệnh select
CREATE FUNCTION CTHD (@tenBan NVARCHAR(100))
RETURNS TABLE  
AS  
RETURN 
	(select MaChiTietHD ,TenBan,TimeDen,TimeThanhToan,TenFoods,GiaTien,SoLuong, GiamGia,TongTien,TrangThaiHD 
		from ChiTietHD c,HoaDon h, Foods f , BanNgoi b
		where c.MaHD=h.MaHD and f.MaFoods=c.MaFoods and b.MaBan=h.MaBan  and TrangThaiHD=N'Chưa thanh toán' and b.TenBan=@tenBan
	);
go



update Foods 
set TenFoods='vghvgjvg',MaLoaiFoods='BK', GiaTien='25000' 
WHERE MaFoods='24'
go

update BanNgoi
set TrangThaiBan=0
where TenBan=N'Bàn 6'

INSERT into CTHD(N'Bàn 3')
        ( TenFoods, GiaTien, SoLuong )
VALUES  ( 'ESPRESSO','35000','1')
          
          
go		  
		
--insert HoaDon
create proc USP_InsertHoaDon
@MaBan int
as
begin
	insert HoaDon
		(MaBan,TimeDen,TimeThanhToan,GiamGia,TrangThaiHD, TongTien)
values	
		(@MaBan,
		GETDATE(),
		null,
		0,
		N'Chưa thanh toán',
		0)
end
go

--insert ChiTietHD
create proc USP_InsertChiTietHD
@MaHD int,@MaFood int
as
begin
	insert ChiTietHD
			(MaHD,MaFoods,SoLuong)
	values 
		(@MaHD,
		@MaFood,
		1)
end
go

exec USP_InsertChiTietHD  8, 0

--l
create  proc xoaHD
@idban int
as
begin
	update BanNgoi
	set TrangThaiBan=0
	where MaBan=@idban

end
go
--
exec xoaHD 10



SELECT count(*)  FROM HoaDon WHERE MaBan=2 AND TrangThaiHD=N'Chưa thanh toán' 

insert ChiTietHD
			(MaHD,MaFoods,SoLuong)
	values 
		( 39,9,8)
		go

		insert HoaDon
		(MaBan,TimeDen,TimeThanhToan,GiamGia,TrangThaiHD, TongTien)
values	
		(6,
		GETDATE(),
		null,
		0,
		N'Chưa thanh toán',
		0)

	
	go

select MaChiTietHD,h.MaHD,b.MaBan,TimeDen,TimeThanhToan,f.MaFoods,TenFoods,GiaTien,SoLuong, GiamGia,TongTien,TrangThaiHD 
		from ChiTietHD c,HoaDon h, Foods f , BanNgoi b
		where c.MaHD=h.MaHD and f.MaFoods=c.MaFoods and b.MaBan=h.MaBan  and TrangThaiHD=N'Chưa thanh toán'	 and h.MaBan=6

		go

select * from ChiTietHD where MaHD=39




---------delete from HoaDon  where TrangThaiHD=N'Chưa thanh toán'




 update HoaDon 
 set TimeThanhToan=GETDATE(), GiamGia=0,TongTien=200000, TrangThaiHD=N'Đã thanh toán' 
 where MaBan=3 and TrangThaiHD=N'Chưa thanh toán'

 select * from BanNgoi

select * from HoaDon where MaBan=2 and TrangThaiHD=N'Chưa thanh toán'