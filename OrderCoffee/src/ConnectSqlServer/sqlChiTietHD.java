package ConnectSqlServer;

public class sqlChiTietHD {
	private int MaChiTietHD,MaHD, MaFood,SoLuong;
	
	public sqlChiTietHD()
	{
		
	}
	public sqlChiTietHD(int MaChiTietHD, int MaHD,int MaFood,int SoLuong)
	{
		this.MaChiTietHD=MaChiTietHD;
		this.MaHD=MaHD;
		this.MaFood=MaFood;
		
		this.SoLuong=SoLuong;
	}
	public int getMaChiTietHD()
	{
		return MaChiTietHD;
	}
	
	public void setMaChiTietHD(int MaChiTietHD)
	{
		this.MaChiTietHD=MaChiTietHD;
	}
	public int getMaHD()
	{
		return MaHD;
	}
	
	public void setMaHD(int MaHD)
	{
		this.MaHD=MaHD;
	}
	
	
	public int getMaFood()
	{
		return MaFood;
	}
	
	public void setMaFood(int MaFood)
	{
		this.MaFood=MaFood;
	}
	//
	
	//
	public int getSoLuong()
	{
		return SoLuong;
	}
	public void setSoLuong(int SoLuong)
	{
		this.SoLuong=SoLuong;
	}
}
