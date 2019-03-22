package Demo;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.util.Date;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ConnectSqlServer.Connect;
import ConnectSqlServer.TableShowcheckBill;


public class Interface extends JFrame implements ActionListener, ItemListener {

	Connection cn;
     Statement st;
     ResultSet rs;
     
     
      Connect connect=new Connect();
      
     static JPanel pBill=new JPanel();
     
     static JPanel pTable=new JPanel();
    
     static JPanel pMenu,pBody;
     static JLabel lbStt;
     
	public Interface() 
	{
		setTitle("Order Coffee");
		setLayout(null);
		setSize(1100, 650);
		//setLocation(25, 25);
		setup();
		
	}
	
	public  void setup() {
		//
		//tạo các đối tượng
		//
		
		JPanel pHeader=new JPanel();
		
		pHeader.setLayout(null);
		pHeader.setBackground(Color.decode("#7cb342"));
		
		ImageIcon dx=new ImageIcon("dangXuat.png");
				
		lbStt=new JLabel("Đang phục vụ: "+Connect.DemBanCoNguoi()+"  bàn");
		JLabel lbGio=new JLabel();
		JLabel lbNgay=new JLabel();
		JLabel lbQtv=new JLabel("Qtv: Lê Thị Ni ");
		JButton btnDangXuat=new JButton("Đăng xuất",dx);
		
		//vị trí
		
		pHeader.setBounds(0, 0, 1100, 45);
		pHeader.setBorder(new LineBorder(Color.GRAY));
		
		lbStt.setBounds(5, 5, 200, 30);
		lbGio.setBounds(210, 5, 200, 30);
		lbNgay.setBounds(420, 5, 200, 30);
		lbQtv.setBounds(630, 5, 200, 30);
		btnDangXuat.setBounds(930, 5, 150, 30);
		
		lbStt.setForeground(Color.WHITE);

		//show time
	
		SimpleDateFormat gio=new SimpleDateFormat(" K:mm:ss a ");
		SimpleDateFormat ngay=new SimpleDateFormat(" dd-MM-yyy ");
		Timer time=new Timer(500,new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 			lbGio.setText("Time: "+gio.format(new Date(System.currentTimeMillis())));	
 			lbNgay.setText(" At:   "+ngay.format(new Date(System.currentTimeMillis())));	
 			}
 		});
         time.setRepeats(true);
         time.start();
         
       //
         lbGio.setForeground(Color.WHITE);
         lbGio.setFont(new Font("Serif", Font.PLAIN,20));
         lbNgay.setForeground(Color.WHITE);
         lbNgay.setFont(new Font("Serif", Font.PLAIN, 20));
         lbQtv.setForeground(Color.WHITE);
         lbQtv.setFont(new Font("Serif", Font.PLAIN, 25));
         
         
         //
         //add
         //
         pHeader.add(lbStt);
         pHeader.add(lbGio);
         pHeader.add(lbNgay);
         pHeader.add(lbQtv);
         pHeader.add(btnDangXuat);
         add(pHeader);
         
         //phần thân
         pBody=new JPanel();
         pBody.setLayout(null);
         pBody.setBounds(0, 50, 1100, 600);
         add(pBody);
         //
         //bill: hiển thị hóa đơn
         //
         pBill=new JPanel();
         pBill.setBounds(378, 0, 310, 610);
         pBill.setBorder(new LineBorder(Color.GRAY));
         pBill.setLayout(null);
        
         pBill.setLayout(new BorderLayout());
        
        
         pBody.add(pBill);
         
         //Menu: nơi hiển thị menu món
         pMenu=new JPanel();
         pMenu.setLayout(new BorderLayout());
         pMenu.setBounds(700, 0, 375, 500);
         pBody.add(pMenu);
   
         
         
         ///
//Table: hiển thị bàn theo sql
   //
        
      
	   		loadTable();
         //
	   		
	   		
         
         ImageIcon free=new ImageIcon("hoa.jpg");
         JLabel lbfree=new JLabel(free);
         lbfree.setBounds(0, 420, 200, 150);
         JButton btnDanhMucBill=new JButton("Danh mục bill");
         btnDanhMucBill.setBounds(230, 500, 130, 25);
         pBody.add(btnDanhMucBill);
         pBody.add(lbfree);
         JButton btnQLMon=new JButton("Quản lí món");
         btnQLMon.setBounds(900, 520, 130, 25);
         pBody.add(btnQLMon);
        
         //
         //hien thi chi tiết tên và giá của loại nước
         //
         
//         pLoadMenu.setBorder(new LineBorder(Color.GRAY));
         ImageIcon Menuimg=new ImageIcon("imgMe.jpg"); 
         JLabel img=new JLabel(Menuimg);
        img.setBounds(700, 60, 375, 450);
        pBody.add(img);

 // nut dang xuat        
         btnDangXuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "bạn muốn đăng xuất?");
				setVisible(false);
			}
		});
 
      
	       
         btnDanhMucBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newfram();
				
			}
		});
         
         //hiểm thị frame quan rlis món
         btnQLMon.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				new FrameQLMon();
 				
 			}
 		});
	   
	        
	}

	
	///laod ban 
	public static void loadTable()
	{
		
		// name = new ();
		lbStt.setText("Đang phục vụ: "+Connect.DemBanCoNguoi()+"  bàn");
		
		//
		
		 pTable=new JPanel();

        pTable.setVisible(true);
        pTable.setBounds(5, 25, 350, 400);
      
		
      
      pBody.add(pTable);
      
		 ImageIcon ictable=new ImageIcon("Formalicon.png");
			ImageIcon ictable1=new ImageIcon("pp-table.jpg");
			
	       for (int i = 0; i <Connect.getTable().size(); i++) {
	       	
	       	if(Connect.getTable().get(i).getTrangThaiB()==0)
	       	{
	       		
	       		JButton lb=new JButton(Connect.getTable().get(i).getTenBan(), ictable);
	       		pTable.add(lb);
	       		
	       		lb.setBackground(Color.decode("#ffcccc"));
	       		lb.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							//pBill3.setVisible(false);
							pBill.removeAll();
							
							
							// lấy ra mã bàn từ tên bàn với kí tự cuối cùng
							
							String tenban=lb.getText();
							String s=tenban.substring(4);
							int Maban=Integer.parseInt(s);
							
							
							 pMenu.removeAll();
							pBill.add(new HoaDon(Maban));
							
							
							pMenu.add(new panelMenu(Maban));
								
							
						}
						
					});
	       	}
	       	else 
	       	{
	       		
	       		JButton lb=new JButton(Connect.getTable().get(i).getTenBan(), ictable1);
	       		pTable.add(lb);
	       		lb.setBackground(Color.decode("#ffcccc"));
	       		
	       		
	       		lb.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							pBill.removeAll();
							
							// lấy ra mã bàn từ tên bàn với kí tự cuối cùng
							
							String tenban=lb.getText();
							String s=tenban.substring(4);
							int Maban=Integer.parseInt(s);
							
							TableShowcheckBill idBan=new TableShowcheckBill(Maban);
							pMenu.removeAll();
							
							pBill.add(new HoaDon1(Maban));
							
							pMenu.add(new panelMenu(idBan.getMaBan()));
							
						
						}
					});
	       	}
	       }
	}

	//tạo 1 frame mới
	private void newfram()
	{ 
		JFrame newf=new JFrame("Danh mục bill");
		newf.setSize(800, 500);
		newf.setLocation(80,80);
		newf.setVisible(true);
		JTable table = new JTable();
        JPanel pCTBill=new JPanel();
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[10];
        columnsName[0] = "MaChiTietHD";
        columnsName[1] = "Tên Bàn";
        columnsName[2] = "Time Đến";
        columnsName[3] = "Time TT";
        columnsName[4] = "Tên món";
        columnsName[5] = "Giá Tiền";
        columnsName[6] = "Số lượng";
        columnsName[7] = "giảm giá";
        columnsName[8] = "Tổng tiền";
        columnsName[9] = "Trạng thái HĐ";
    
        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[10];
        for(int i = 0; i < Connect.getHoaDon().size(); i++){
		     rowData[0] =Connect.getHoaDon().get(i).getMaChiTietHD() ;//.getText();
		     rowData[1] = Connect.getHoaDon().get(i).getMaBan();
		     rowData[2] = Connect.getHoaDon().get(i).getTimeDen();
		     rowData[3] = Connect.getHoaDon().get(i).getTimeThanhToan();
		     rowData[4] = Connect.getHoaDon().get(i).getTenFood();
		     rowData[5] = Connect.getHoaDon().get(i).getGiaTien();
		     rowData[6] = Connect.getHoaDon().get(i).getSoLuong();
		     rowData[7] = Connect.getHoaDon().get(i).getGiamGia();
		     rowData[8] = Connect.getHoaDon().get(i).getTongTien();
		     rowData[9] = Connect.getHoaDon().get(i).getTrangThaiHD();
		     model.addRow(rowData);
        }
        table.setModel(model);
        
        pCTBill.setLayout(new BorderLayout());
        
        JScrollPane pane = new JScrollPane(table);
        
        pCTBill.add(pane,BorderLayout.CENTER);
        newf.add(pCTBill);
		
	}
	
	
	
	 public static void main(String[] args)  {
		Interface cf=new Interface();
			cf.setVisible(true);
	}
//
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
