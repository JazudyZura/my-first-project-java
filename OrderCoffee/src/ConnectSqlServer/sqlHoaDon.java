package ConnectSqlServer;

public class sqlHoaDon {

	private int MaHD,MaBan,GiamGia,TongTien;
	private String TimeDen,TimeTT,TrangThaiHD;
	public sqlHoaDon()
	{
		
	}
	public sqlHoaDon(int MaHD,int MaBan,String TimeDen,String TimeTT , String TrangThaiHD ,int GiamGia,int TongTien)
	{
		this.MaHD=MaHD;
		this.MaBan=MaBan;
		this.TimeDen=TimeDen;
		this.TimeTT=TimeTT;
		this.GiamGia=GiamGia;
		this.TongTien=TongTien;
		this.TrangThaiHD=TrangThaiHD;
	}
	
	public int getMaHD()
	{
		return MaHD;
	}
	public void setMaHD(int MaHD) {
		
		this.MaHD=MaHD;
	}
	public int getMaBan()
	{
		return MaBan;
	}
	public void setMaBan(int MaBan)
	{
		
		this.MaBan=MaBan;
	}
	
	//
	public String getTimeDen() {
		return TimeDen;
	}
	public void setTimeDen(String TimeDen) {
		this.TimeDen=TimeDen;
	}
	
	public String getTimeTT() {
		return TimeTT;
	}
	public void setTimeTT(String TimeTT) {
		this.TimeTT=TimeTT;
	}
	//
	
	public String getTrangThaiHD() {
		return TrangThaiHD;
	}
	public void setTrangThaiHD(String TrangThaiHD) {
		this.TrangThaiHD=TrangThaiHD;
	}
	
	public int getGiamGia() {
		return GiamGia;
	}
	public void setGiamGia( int GiamGia) {
		this.GiamGia=GiamGia;
	}
	
	public int getTongTien() {
		return TongTien;
	}
	public void setTongTien(int TongTien) {
		this.TongTien=TongTien;
	}
	
	
	
	
	
}
