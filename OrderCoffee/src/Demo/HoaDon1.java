package Demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

import ConnectSqlServer.Connect;
import ConnectSqlServer.TableShowcheckBill;
import ConnectSqlServer.saveMaFood;



public class HoaDon1 extends JPanel implements ActionListener {
	 static JLabel lbNameTable,lbStatus,lbGiamGia,lbTongTien,lbGioDen;
	 static JButton btnHuyGoi,btnThanhToan,btntick;
	 static JTextField  txtGiamGia,txtTongTien;
	 static JTable table;
	 
	 //
	 static  JLabel lbtenMon,lbSolg, lbGia , lbtenBan;
	 static JButton btnXoaMon,btnDongY;
	 static JTextField txtSL,txtGia;
		
	 static int thanhtien=0;
	 static DefaultTableModel model;
	 
	 private static String DB_URL = "jdbc:sqlserver://localhost:11305;"
	            + "databaseName=QLOrderCoffee;"
	            + "integratedSecurity=true";
	    private static String USER_NAME = "sa";
	    private static String PASSWORD = "97";
	     static TableShowcheckBill idBan;
	    static int getidFood;
	    
	public  HoaDon1(int MaBan)
	{
		
	  
	  
		setLayout(null); 
		
      
		
		
		//gán mã bàn cho 1 biến
	      idBan=new TableShowcheckBill(MaBan);
	      
	     
	      
		String s=Connect.getTimeDen(MaBan);
		
			lbGioDen=new JLabel("Giờ đến: "+s);
			 
        // //  +gio.format(new Date(System.currentTimeMillis()))+" at"+ngay.format(new Date(System.currentTimeMillis())));
        lbNameTable=new JLabel("Bàn "+MaBan);
			lbStatus =new JLabel("Status: đang Phục vụ");
        JPanel pmon=new JPanel();
        btnHuyGoi=new JButton("Hủy gọi món");
         lbGiamGia=new JLabel("Giảm giá");
          lbTongTien=new JLabel("Thành tiền");
         btnThanhToan=new JButton("Thanh toán");
          txtGiamGia=new JTextField("0");
         txtTongTien=new JTextField();
         
         lbNameTable.setBounds(170, 10, 150, 50);
         lbNameTable.setFont(new Font("Serif", Font.PLAIN, 35));
         
         lbNameTable.setBounds(170, 10, 130, 50);
         lbGioDen.setBounds(20, 70, 250, 30);
         lbStatus.setBounds(20, 100, 200, 30);
         
         pmon.setBounds(5,150,290,200);
         
         btnHuyGoi.setBounds(100, 360, 110, 30);
         lbGiamGia.setBounds(200, 450, 100, 25);
         lbTongTien.setBounds(200, 410, 100, 25);
         txtGiamGia.setBounds(20, 450, 150, 25);
         txtTongTien.setBounds(20, 410, 150, 30);
         btnThanhToan.setBounds(100, 490, 100, 30);
         //hiển thị món khách chọn
         table = new JTable();
         table.setBackground(Color.decode("#336699"));
         table.setFont(new Font("Serif", Font.BOLD, 20));
         table.setRowHeight(40);
         table.setForeground(Color.white);
         txtGiamGia.setFont(new Font("Serif", Font.BOLD, 16));
         txtTongTien.setFont(new Font("Serif", Font.BOLD, 18));
         txtTongTien.setForeground(Color.RED);
         
 //table.setModel(model);
        pmon.setLayout(new BorderLayout());
	        JScrollPane pane = new JScrollPane(table);
	        ShowMon(MaBan);
	        pmon.add(pane,BorderLayout.CENTER);
	    add(pmon); 
	    add(lbNameTable);
        add(lbGioDen);
        add(lbStatus);
        add(btnHuyGoi);
        add(lbGiamGia);
        add(lbTongTien);
        add(txtGiamGia);
        add(txtTongTien);
        add(btnThanhToan);
        table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e)
        	{
        		
        		jTable1MouseClicked(e);
        		lbtenBan.setText("bàn "+MaBan);
        		 getidFood=table.rowAtPoint(e.getPoint());
        	}
		});
       
		// nút hủy gọi món
		
      btnHuyGoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "bạn muốn hủy gọi món cho bàn "+MaBan+"?");
				
				Connect.delChiTietHD(Connect.getMaHD(MaBan));
				Connect.delHoaDon(MaBan);
				Connect.updateTTBantrong(MaBan);
				Connect.DemBanCoNguoi();
				
 				Interface.pBill.removeAll();
 				Interface.pBill.add(new HoaDon(MaBan));
 				Interface.pTable.removeAll();
 				Interface.loadTable();
 				
			 
						
		 		}
		 	});
		
      btnThanhToan.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			 FthanhToan();
			
		
		}
	});
      
   	
      
      
	}
	
	JLabel nameTable, lbtong,lbgiamGia,lbTienPhaiTra, lbTienKhachDua,lbTienDu;
	JTextField txTong,txGiam,txTienPT,txKhachDua,txTienDu;
	JButton btnHuyTT,btnTT,btnYes;
	
	private void FthanhToan() {

			JFrame farmTT=new JFrame("khách thanh toán");
			
			farmTT.setSize(300, 400);
			farmTT.setLayout(null);
			farmTT.setLocation(200,200);
			farmTT.setVisible(true);
			nameTable=new JLabel("Bàn "+idBan.getMaBan());
			lbtong=new JLabel("Tổng ");
			lbgiamGia=new JLabel("Giảm giá ");
			lbTienPhaiTra=new JLabel("phải trả");
			lbTienKhachDua=new JLabel("Khách đưa");
			lbTienDu=new JLabel("Tiền Dư trả lại ");
			
			txTong=new JTextField(txtTongTien.getText());
			txGiam=new JTextField(txtGiamGia.getText());
			txTienPT=new JTextField();
			txKhachDua=new JTextField();
			txTienDu=new JTextField();
			//
			int tong=Integer.parseInt(txTong.getText());
			
			int phaitra=tong + tong*Integer.parseInt(txGiam.getText())/100;
			
			txTienPT.setText(Integer.toString(phaitra));
			
			//
			
			 btnHuyTT=new JButton("Hủy");
			 btnTT=new JButton("Thanh toán");
			 btnYes=new JButton("Yes");
			 
			 nameTable.setBounds(50, 10, 100, 30);
			 lbtong.setBounds(150, 50, 100, 30);
			 lbgiamGia.setBounds(150, 100, 100, 30);
			 lbTienPhaiTra.setBounds(150, 150, 100, 30);
			 lbTienKhachDua.setBounds(150, 200, 100, 30);
			 lbTienDu.setBounds(150, 250, 100, 30);
			 
			 txTong.setBounds(10, 50, 100, 30);
			 txGiam.setBounds(10, 100, 100, 30);
			 txTienPT.setBounds(10, 150, 100, 30);
			 txKhachDua.setBounds(10, 200, 100, 30);
			 txTienDu.setBounds(10, 250, 100, 30);
			 
			 btnHuyTT.setBounds(215, 300, 60, 30);
			 btnTT.setBounds(80, 300, 100, 30);
			 btnYes.setBounds(5, 300, 60, 30);
			 
			 farmTT.add(nameTable);
			 
			 farmTT.add(lbtong);
			 farmTT.add(lbgiamGia);
			 farmTT.add(lbTienPhaiTra);
			 farmTT.add(lbTienKhachDua);
			 farmTT.add(lbTienDu);
			 
			 farmTT.add(txTong);
			 farmTT.add(txGiam);
			 farmTT.add(txTienPT);
			 farmTT.add(txKhachDua);
			 farmTT.add(txTienDu);
			 
			 farmTT.add(btnTT);
			 farmTT.add(btnHuyTT);
			 farmTT.add(btnYes);
			 
			 btnHuyTT.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					farmTT.setVisible(false);
				}
			});
			 
			 btnYes.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					int tong=Integer.parseInt(txTong.getText());
					
					int phaitra=tong + tong*Integer.parseInt(txGiam.getText())/100;
					
					txTienPT.setText(Integer.toString(phaitra));
					
					int tienKD=Integer.parseInt(txKhachDua.getText());
					
					txTienDu.setText(Integer.toString(tienKD-phaitra));
					
				}
			});
			 
			 btnTT.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int MaBan=idBan.getMaBan();
					int giamgia=Integer.parseInt(txGiam.getText());
					int tongtien=Integer.parseInt(txTong.getText());
					
					Connect.UpdateHoaDon(MaBan, giamgia, tongtien);
					
					JOptionPane.showMessageDialog(null, "Thanh toán thành công!");
					Connect.updateTTBantrong(MaBan);
					farmTT.setVisible(false);
					Connect.DemBanCoNguoi();
				
	 				Interface.pBill.removeAll();
	 				Interface.pBill.add(new HoaDon(MaBan));
	 				Interface.pTable.removeAll();
	 				Interface.loadTable();
	 				
				}
			});

	}
	
	
	
	//hiển thị món khách chọn và tổng tiền theo bàn 
	
	public static void ShowMon( int MaBan)
	{
		
		
		 table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"","",""}));
		  model = (DefaultTableModel)table.getModel();
		 
		  model.setRowCount(0);

	        Object[] rowData = new Object[3];
	        
	        thanhtien=0;
	        for(int i = 0; i < Connect.getHoaDon1(MaBan).size(); i++){
			     rowData[0] =Connect.getHoaDon1(MaBan).get(i).getTenFood() ;
			      rowData[1] = Connect.getHoaDon1(MaBan).get(i).getGiaTien();
			      rowData[2] = Connect.getHoaDon1(MaBan).get(i).getSoLuong();
			       model.addRow(rowData);
			      
			        thanhtien= thanhtien+Connect.getHoaDon1(MaBan).get(i).getGiaTien()*Connect.getHoaDon1(MaBan).get(i).getSoLuong();
			 }
	        int tongtien=thanhtien+thanhtien*Integer.parseInt(txtGiamGia.getText())/100;
	        
	        txtTongTien.setText(Integer.toString(tongtien));
	        
	       
	}
	
	//hển thị frame chọn số lượng của món hoặc xóa món trong frame moiws
	
	
	public  void FrameByClickModel()
	{
		
		
				
		JFrame fMon=new JFrame("món khách đã chọn");
		fMon.setSize(300, 250);
		fMon.setLocation(250,250);
		fMon.setLayout(null);
		fMon.setVisible(true);
		 btnXoaMon=new JButton("Xóa");
		 btnDongY=new JButton("Đồng ý");
		JButton btnHuy=new JButton("Hủy");
		lbtenBan=new JLabel();
		lbtenMon=new JLabel();
		lbSolg=new JLabel("Số lượng: ");
		ImageIcon icontick=new ImageIcon("tick.png");
		btntick=new JButton(icontick);
		lbGia=new JLabel("Giá: ");
		txtSL=new JTextField();
		txtGia=new JTextField();
		
		//set vị trí
		lbtenBan.setBounds(210, 5, 50, 25);
		lbtenMon.setBounds(40, 20, 250, 25);
		lbSolg.setBounds(10, 60, 60, 25);
		btntick.setBounds(200, 50, 50, 50);
		lbGia.setBounds(10, 100, 60, 25);
		txtSL.setBounds(80, 60, 100, 25);
		txtGia.setBounds(80, 100, 100, 25);
		btnDongY.setBounds(10, 140, 90, 35);
		btnXoaMon.setBounds(110, 140, 90, 35);
		btnHuy.setBounds(210, 140, 60, 35);
		
		lbtenMon.setFont(new Font("Serif", Font.BOLD, 18));
		//add
		fMon.add(lbtenBan);
		fMon.add(lbtenMon);
		fMon.add(lbSolg);
		fMon.add(lbGia);
		fMon.add(txtSL);
		fMon.add(btntick);
		fMon.add(txtGia);
		fMon.add(btnDongY);
		fMon.add(btnXoaMon);
		fMon.add(btnHuy);
		
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fMon.setVisible(false);
				
			}
		});
		
//		// lấy mã bàn
//		String tenban=lbtenBan.getText();
//		String s=tenban.substring(4);
//		int Maban=Integer.parseInt(s);
//		
		btntick.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index =table.getSelectedRow();
				int gia=Integer.parseInt(txtSL.getText())*Integer.parseInt(model.getValueAt(index, 1).toString());
				txtGia.setText(Integer.toString(gia));
				
			}
		});
		
		btnXoaMon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fMon.setVisible(true);
				try {
					Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
					PreparedStatement ps=con.prepareStatement("delete  from ChiTietHD  where MaHD=? and MaFoods=?");
					
					ps.setInt(1, (Connect.getHoaDon1(idBan.getMaBan()).get(0).getMaHD()));
					ps.setInt(2, (Connect.getHoaDon1(idBan.getMaBan()).get(0).getMaFood()));
					ps.executeUpdate();
					fMon.setVisible(false);
					JOptionPane.showMessageDialog(null, "Đã món thành công!");
					
					ShowMon(idBan.getMaBan());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Xóa món không thành công!");
				}
			
			}
		});
		
		btnDongY.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				fMon.setVisible(true);
				int index =table.getSelectedRow();
				
				try {
					Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
					PreparedStatement ps=con.prepareStatement("update ChiTietHD set SoLuong=? where MaFoods=? and MaHD=?");
					//JOptionPane.showMessageDialog(null, "dong thu " +getidFood);
					
					ps.setInt(1, (Integer.parseInt(txtSL.getText())));
					ps.setInt(2, (Connect.getHoaDon1(idBan.getMaBan()).get(getidFood).getMaFood()));
					ps.setInt(3, (Connect.getMaHD(idBan.getMaBan())));
					
					ps.executeUpdate();
					fMon.setVisible(false);
					JOptionPane.showMessageDialog(null, "Đã sửa số lượng  thành công!");
					Connect.getHoaDon1(idBan.getMaBan());
					ShowMon(idBan.getMaBan());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "thay doi ố lượng không thành công!");
				}
			}
		});

	}
	//check xem cos bao nhieeu so luong cua mon
	
	private void  jTable1MouseClicked(MouseEvent ev)
	{
	
		
		int index =table.getSelectedRow();
		
		FrameByClickModel();
		
		lbtenMon.setText((String) model.getValueAt(index, 0));
		txtSL.setText(model.getValueAt(index, 2).toString());
		
			int gia=Integer.parseInt(txtSL.getText())*Integer.parseInt(model.getValueAt(index, 1).toString());
			txtGia.setText(Integer.toString(gia));
		
			//txtGia.setText(model.getValueAt(index, 1).toString());
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
