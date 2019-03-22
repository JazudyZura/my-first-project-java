package ConnectSqlServer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class Connect {
      private static String DB_URL = "jdbc:sqlserver://localhost:11305;"
            + "databaseName=QLOrderCoffee;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "97";
    
    public Connect()
    {
        getConnection(DB_URL, USER_NAME, PASSWORD);
        getTable();
    }
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
      Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            //System.out.println("connect successfully!");
        } catch (Exception ex) {
            //System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    //
    //lay ra danh muc ban 
     public static ArrayList<Table>getTable()
    {
        ArrayList<Table> arrTable=new ArrayList<>();
       
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select * from BanNgoi");
           
            while (rs.next()) {
                
                Table table=new Table(rs.getInt(1), rs.getString(2),rs.getInt(3));
               
                arrTable.add(table);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return arrTable;
    }
     //lay ra danh sách món
     public static ArrayList<Food>getFood()
     {
     	ArrayList<Food>arrFood=new ArrayList<>();
     	
     	try {
     		Connection cn=getConnection(DB_URL, USER_NAME, PASSWORD);
 			Statement st=cn.createStatement();
 			ResultSet rs=st.executeQuery("select * from Foods ");
 			while (rs.next()) {
 				
 				Food food=new Food(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
 				arrFood.add(food);
 			}
 		} catch (SQLException e) {
 		
 			e.printStackTrace();
 		}
     	
     	return arrFood;
     }
     // lay danh muc food theo ma mon 
    public static ArrayList<Food>getFoodCF()
    {
    	ArrayList<Food>arrFood=new ArrayList<>();
    	
    	try {
    		Connection cn=getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from Foods where MaLoaiFoods='CF'  ");
			while (rs.next()) {
				
				Food food=new Food(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				arrFood.add(food);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
    	
    	return arrFood;
    }

    public static ArrayList<Food>getFoodMT()
    {
    	ArrayList<Food>arrFood=new ArrayList<>();
    	
    	try {
    		Connection cn=getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from Foods where MaLoaiFoods='MT'  ");
			while (rs.next()) {
				
				Food food=new Food(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				arrFood.add(food);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
    	
    	return arrFood;
    }
    
    public static ArrayList<Food>getFoodBK()
    {
    	ArrayList<Food>arrFood=new ArrayList<>();
    	
    	try {
    		Connection cn=getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from Foods where MaLoaiFoods='BK'  ");
			while (rs.next()) {
				
				Food food=new Food(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				arrFood.add(food);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
    	
    	return arrFood;
    }
   
    
    public static ArrayList<sqlChiTietHD>getsqlChiTietHD(int MaHD)
    {
    	ArrayList<sqlChiTietHD>arrCTHD=new ArrayList<>();
    	
    	try {
    		Connection cn=getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from ChiTietHD where MaHD='"+MaHD+"' ");
			while (rs.next()) {
				
				sqlChiTietHD hd=new sqlChiTietHD(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
				arrCTHD.add(hd);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
    	
    	return arrCTHD;
    }
    
    //dem so ban dang co nguoi
    
    public static int DemBanCoNguoi()
    {
    	int dem=0;
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select count(*)from BanNgoi where TrangThaiBan=1");
            while (rs.next()) {
				dem=rs.getInt(1);
				
			}
        }catch (Exception e) {
        	e.printStackTrace();
		}
        return dem;
    }
    
    // lấy ra danh sách chi tiết hóa đơn theo tên bàn
    
    public static ArrayList<HoaDonList>getHoaDon()
    {
        ArrayList<HoaDonList> arrHoaDon=new ArrayList<>();
       
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select MaChiTietHD,h.MaHD,b.MaBan,TimeDen,TimeThanhToan,f.MaFoods,TenFoods,GiaTien,SoLuong, GiamGia,TongTien,TrangThaiHD \r\n" + 
            		"		from ChiTietHD c,HoaDon h, Foods f , BanNgoi b\r\n" + 
            		"		where c.MaHD=h.MaHD and f.MaFoods=c.MaFoods and b.MaBan=h.MaBan");
           
            while (rs.next()) {
                
                HoaDonList hoadon=new HoaDonList(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),
                		 rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),rs.getString(12));
               
                arrHoaDon.add(hoadon);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return arrHoaDon;
    }
    
    ///
    public static int DemHD(int MaBan)
    {
    	int dem=0;
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("SELECT count(*)  FROM HoaDon WHERE MaBan='"+MaBan+"' AND TrangThaiHD=N'Chưa thanh toán' ");
            while (rs.next()) {
   				dem=rs.getInt(1);
   				
   			}
        }catch (Exception e) {
        	e.printStackTrace();
   		}
        return dem;
    }
    
    
    //lấy ra danh sách hóa đơn theo bàn mà chưa thanh toán
    
    public static ArrayList<HoaDonList>getHoaDon1(int MaBan)
    {
        ArrayList<HoaDonList> arrHoaDon=new ArrayList<>();
       
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select MaChiTietHD,h.MaHD,b.MaBan,TimeDen,TimeThanhToan,f.MaFoods,TenFoods,GiaTien,SoLuong, GiamGia,TongTien,TrangThaiHD \r\n" + 
            		"		from ChiTietHD c,HoaDon h, Foods f , BanNgoi b\r\n" + 
            		"		where c.MaHD=h.MaHD and f.MaFoods=c.MaFoods and b.MaBan=h.MaBan  and TrangThaiHD=N'Chưa thanh toán'	and h.MaBan='"+MaBan+"'");
           
            while (rs.next()) {
                
                HoaDonList hoadon=new HoaDonList(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),
               		 rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),rs.getString(12));
               
                arrHoaDon.add(hoadon);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return arrHoaDon;
    }
    
   public static void updateTTBan(int maBan)
   {
	   
				try {
					Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
					PreparedStatement ps=con.prepareStatement("update BanNgoi\r\n" + 
							"set TrangThaiBan=1\r\n" + 
							"where MaBan=?");
					
					ps.setInt(1,maBan);
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Bàn về trạng thái có người!");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "lỗi chuyển trạng thái bàn!");
				}
			 
				
			}
   public static void updateTTBantrong(int MaBan)
   {
	   
				try {
					Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
					PreparedStatement ps=con.prepareStatement("update BanNgoi\r\n" + 
							"set TrangThaiBan=0\r\n" + 
							"where MaBan=?");
					
					ps.setInt(1,MaBan);
					ps.executeUpdate();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "lỗi chuyển trạng thái bàn!");
				}
			 
				
			}
    
    
    public static void insertHoaDon(int MaBan) {
		
    	try {
			Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
			PreparedStatement ps=con.prepareStatement("insert HoaDon\r\n" + 
									"		(MaBan,TimeDen,TimeThanhToan,GiamGia,TrangThaiHD, TongTien)\r\n" + 
									"values	\r\n" + 
									"		(?,\r\n" + 
									"		GETDATE(),\r\n" + 
									"		null,\r\n" + 
									"		0,\r\n" + 
									"		N'Chưa thanh toán',\r\n" + 
									"		0)");
			
			ps.setInt(1,MaBan);
			ps.executeUpdate();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "lỗi thêm vào dbo.HoaDon!");
		}
	}
    
    
 public static void insertChiTietHD(int MaHD,int MaFood) {
		
    	try {
			Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
			PreparedStatement ps=con.prepareStatement("insert ChiTietHD\r\n" + 
								"			(MaHD,MaFoods,SoLuong)\r\n" + 
								"	values \r\n" + 
								"		( ?,?,1)");
			
			ps.setInt(1,MaHD);
			ps.setInt(2,MaFood);
			//ps.setInt(3,SoLuong);
			ps.executeUpdate();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "lỗi thêm vào dbo.ChiTietHD!");
		}
	}
 //
 //dem  hoa don chua thanh toan theo ban

 
    //lấy ra hóa dơn chưa thanh toán theo mã bàn
 
	 public static ArrayList<sqlHoaDon>getHDUnCheckBill(int MaBan)
	 {
//		 if(DemHD(MaBan)==0)
//		 {
//			 return null;
//		 }
//		 else
//		 {
	     ArrayList<sqlHoaDon> hd=new ArrayList<>();
	    
	     try {
	         Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	         // crate statement
	         Statement stmt = conn.createStatement();
	         // get data from table 'student'
	         	
			         ResultSet rs = stmt.executeQuery("SELECT * FROM HoaDon WHERE MaBan='"+MaBan+"' AND TrangThaiHD=N'Chưa thanh toán' ");
			        
			         while (rs.next()) {
			             
			        	 sqlHoaDon h=new sqlHoaDon((rs.getInt(1)),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getInt(7));
			            
			             hd.add(h);
			             
			         }
			         
				     } catch (SQLException ex) {
				         Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
				     }     
		   
	  return hd;
	 }
	 
	// xóa taast cả món khách đã chọn
	 public static void delChiTietHD(int MaHD) {
			
	    	try {
				Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
				PreparedStatement ps=con.prepareStatement("delete  from ChiTietHD  where   MaHD=?");
				
				ps.setInt(1,MaHD);
				
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "xóa hết món khách đã chọn thành công!");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "lỗi xóa dbo.ChiTietHD!");
			}
		}
	 
	 //lấy ra dang sách hóa đơn chưa thang toán theo mã bàn
	 
	 public static void delHoaDon(int MaBan) {
			
	    	try {
				Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
				PreparedStatement ps=con.prepareStatement("delete  from HoaDon  where MaBan=?  and TrangThaiHD=N'Chưa thanh toán'");
				
				ps.setInt(1,MaBan);
				ps.executeUpdate();
				
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "lỗi thêm vào dbo.HoaDon!");
			}
		}
	 
	 /// update hóa đươn về trạng thái đã thanh toán và các giá trị khác
	 public static void UpdateHoaDon(int MaBan,int giamgia,int tongtien) {
			
	    	try {
				Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
				PreparedStatement ps=con.prepareStatement("update HoaDon \r\n" + 
						" set TimeThanhToan=GETDATE(), GiamGia=?, TongTien=?, TrangThaiHD=N'Đã thanh toán' \r\n" + 
						" where MaBan=? and TrangThaiHD=N'Chưa thanh toán'");
				
				ps.setInt(1, giamgia);
				ps.setInt(2,tongtien);
				ps.setInt(3,MaBan);
				
				ps.executeUpdate();
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "lỗi update  dbo.HoaDon!");
			}
		}
	 //lấy ra string thời gian khách dến
	 
	 public static String getTimeDen(int MaBan)
	    {
		 String timeden=null;
	        try {
	            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	            // crate statement
	            Statement stmt = conn.createStatement();
	            // get data from table 'student'
	            ResultSet rs = stmt.executeQuery("select TimeDen from HoaDon where MaBan='"+MaBan+"' and TrangThaiHD=N'Chưa thanh toán' ");
	            while (rs.next()) {
	   				timeden=rs.getString(1);
	   				
	   			}
	        }catch (Exception e) {
	        	e.printStackTrace();
	   		}
	        return timeden;
	    }
	 //lấy ra mã hóa đơn
	 
	 public static int getMaHD(int MaBan)
	    {
		 int MaHD=0;
	        try {
	            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	            // crate statement
	            Statement stmt = conn.createStatement();
	            // get data from table 'student'
	            ResultSet rs = stmt.executeQuery("select * from HoaDon where MaBan='"+MaBan+"' and TrangThaiHD=N'Chưa thanh toán'");
	            while (rs.next()) {
	   				MaHD=rs.getInt(1);
	   				
	   			}
	        }catch (Exception e) {
	        	e.printStackTrace();
	   		}
	        return MaHD;
	    }
	 
	 
}
