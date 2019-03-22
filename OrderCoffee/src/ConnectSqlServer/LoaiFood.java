package ConnectSqlServer;

public class LoaiFood {
	
		private String MaLoai,TenLoai;
		public LoaiFood(String MaLoai, String TenLoai)
		{
			this.MaLoai=MaLoai;
			this.TenLoai=TenLoai;
		}
		
		public LoaiFood()
		{
			
		}
		
		public String getMaLoa()
		{
			return MaLoai;
		}
		public void setMaLoai(String MaLoai)
		{
			this.MaLoai=MaLoai;
		}
		
		//
		public String getTenLoai()
		{
			return TenLoai;
		}
		public void setTenLoai(String TenLoai)
		{
			this.TenLoai=TenLoai;
		}
	}

