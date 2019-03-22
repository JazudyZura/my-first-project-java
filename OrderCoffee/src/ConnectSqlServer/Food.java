package ConnectSqlServer;


public class Food {
	private int MaFood,GiaTien;
	private String TenFood,MaLoaiF;
	
	public Food() {
		
	}
	public Food(int MaFood,String TenFood,String MaLoaiF,int GiaTien ) {
		this.MaFood=MaFood;
		this.TenFood=TenFood;
		this.MaLoaiF=MaLoaiF;
		this.GiaTien=GiaTien;
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
	public String getTenFood()
	{
		return TenFood;
	}
	
	public void setTenFood(String TenFood)
	{
		this.TenFood=TenFood;
	}
	//
	public String getMaLoaiF()
	{
		return MaLoaiF;
	}
	
	public void setMaLoaiF(String MaLoaiF)
	{
		this.MaLoaiF=MaLoaiF;
	}
	//
	
	public int getGiaTien()
	{
		return GiaTien;
	}
	
	public void setGiaTien(int GiaTien)
	{
		this.GiaTien=GiaTien;
	}
}
