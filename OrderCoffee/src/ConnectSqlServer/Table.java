package ConnectSqlServer;



public class Table {
	private int MaBan , TrangThaiB;
	private String TenBan;
	
	
	public Table() {
		
	}
	public Table(int MaBan,String TenBan, int TrangThaiB)
	{
		this.MaBan=MaBan;
		this.TenBan=TenBan;
		this.TrangThaiB=TrangThaiB;
	}
	public int getMaBan() {
		return MaBan;
	}
	public void setMaBan(int MaBan)
	{
		this.MaBan=MaBan;
	}
	public String getTenBan()
	{
		return TenBan;
	}
	public void setTenBan(String TenBan)
	{
		this.TenBan=TenBan;
	}
	public int getTrangThaiB()
	{
		return TrangThaiB;
	}
	public void setTrangThaiB(int TrangThaiB)
	{
		this.TrangThaiB=TrangThaiB;
        }
        
}

