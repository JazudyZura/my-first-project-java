package ConnectSqlServer;

public class HoaDonList {
	private int MaChiTietHD,GiaTien,SoLuong,GiamGia,TongTien,MaBan,MaHD,MaFood;
	private String TimeDen,TimeThanhToan, TenFood,TrangThaiHD;

	public HoaDonList()
	{
		
	}
	public HoaDonList( int MaChiTietHD,int MaHD,int MaBan, String TimeDen,String TimeThanhToan , int MaFood,String TenFood, 
			int GiaTien, int SoLuong,int GiamGia,int TongTien,String TrangThaiHD )
	{
		this.MaChiTietHD=MaChiTietHD;
		this.MaHD=MaHD;
		this.MaBan=MaBan;
		this.TimeDen=TimeDen;
		this.TimeThanhToan=TimeThanhToan;
		this.MaFood=MaFood;
		this.TenFood=TenFood;
		this.GiaTien=GiaTien;
		this.SoLuong=SoLuong;
		this.GiamGia=GiamGia;
		this.TongTien=TongTien;
		this.TrangThaiHD=TrangThaiHD;
	}
	
	public int getMaChiTietHD()
	{
		return MaChiTietHD;
	}
	public void setMaChiTietHD(int MaChiTietHD)
	{
		this.MaChiTietHD=MaChiTietHD;
	}
	
	public int getMaHD( )
	{
		return MaHD;
	}
	public void setMaHD(int MaHD)
	{
		this.MaHD=MaHD;
	}
	
	public int getMaBan( )
	{
		return MaBan;
	}
	public void setMaBan(int MaBan)
	{
		this.MaBan=MaBan;
	}
	
	public String getTimeDen()
	{
		return TimeDen;
	}
	public void setTimeDen(String TimeDen)
	{
		this.TimeDen=TimeDen;
	}
	
	public String getTimeThanhToan()
	{
		return TimeThanhToan;
	}
	public void setTimeThanhToan(String TimeThanhToan)
	{
		this.TimeThanhToan=TimeThanhToan;
	}
	
	public int getMaFood( )
	{
		return MaFood;
	}
	public void setMaFood(int MaFood)
	{
		this.MaFood=MaFood;
	}
	
	public String getTenFood()
	{
		return TenFood;
	}
	public void setTenFood(String TenFood)
	{
		this.TenFood=TenFood;
	}
	
	public int getGiaTien()
	{
		return GiaTien;
	}
	public void setGiaTien(int GiaTien)
	{
		this.GiaTien=GiaTien;
	}
	
	public int getSoLuong()
	{
		return SoLuong;
	}
	public void setSoLuong(int SoLuong)

	
	{
		this.SoLuong=SoLuong;
	}
	
	public int getGiamGia()
	{
		return GiamGia;
	}
	public void setGiamGia(int GiamGia)

	
	{
		this.GiamGia=GiamGia;
	}
	
	public int getTongTien()
	{
		return TongTien;
	}
	public void setTongTien(int TongTien)

	
	{
		this.TongTien=TongTien;
	}
	
	public String getTrangThaiHD()
	{
		return TrangThaiHD;
	}
	public void setTrangThaiHD(String TrangThaiHD)
	{
		this.TrangThaiHD=TrangThaiHD;
	}
	
	
}
