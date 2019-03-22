package Demo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConnectSqlServer.Connect;

public class FrameQLMon extends JFrame implements ActionListener {
	private static String DB_URL = "jdbc:sqlserver://localhost:11305;"
            + "databaseName=QLOrderCoffee;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "97";
    
	JFrame fQLMon;
	JTable table ;
    JPanel pCTMon;
    JPanel pTT;
    JTextField txtGia,txtTenMon,txtMaMon;
    JLabel lbMaLoai,lbTenMon,lbGia,lbMaMon;
    JButton btnThem,btnSua,btnXoa;
    JComboBox txtMaLoai;
    
	public FrameQLMon()
	{
		
		 fQLMon=new JFrame("Quản lí món");
		 table = new JTable();
	     pCTMon=new JPanel();
	     pTT=new JPanel();
	    lbMaMon=new JLabel("Mã món");
	     txtGia=new JTextField();
	     txtTenMon=new JTextField();
	    
	     lbMaLoai=new JLabel("Mã loại");
	     lbTenMon=new JLabel("Tên món");
	     lbGia=new JLabel("Giá");
	     btnThem=new JButton("Thêm");
	     btnSua=new JButton("Sửa");
	     btnXoa=new JButton("Xóa");
	    txtMaMon=new JTextField();
	    String MaLoai[]= {"CF","MT","BK"};
	    txtMaLoai=new JComboBox(MaLoai);
		 	fQLMon.setSize(700, 470);
			fQLMon.setLocation(100,100);
			fQLMon.setVisible(true);
			fQLMon.setLayout(null);
			
	        
	        pTT.setBounds(0, 0, 700, 170);
	        pTT.setLayout(null);
	        pCTMon.setBounds(0, 170, 700, 250);
	        lbMaMon.setBounds(70, 10, 60, 25);
	        lbMaLoai.setBounds(70, 50, 60, 25);
	        lbTenMon.setBounds(70, 90, 60, 25);
	        lbGia.setBounds(70, 130, 60, 25);
	        
	        txtMaMon.setBounds(140, 10, 200, 25);
	        txtMaLoai.setBounds(140, 50, 200, 25);
	        txtTenMon.setBounds(140, 90, 200, 25);
	        txtGia.setBounds(140, 130, 200, 25);
	        
	        btnThem.setBounds(530, 10, 70, 30);
	        btnSua.setBounds(530, 60, 70, 30);
	        btnXoa.setBounds(530, 110, 70, 30);

	        
	       pCTMon.setLayout(new BorderLayout());
	       
	       table.setModel(new DefaultTableModel(new Object[][] {},
	    		   					new String[] 
	    		   							{"Mã Món","Tên Món","Mã loại","Giá"}
	       ));
	        JScrollPane pane = new JScrollPane(table);
	        
	        pCTMon.add(pane,BorderLayout.CENTER);
	        showDataJtable();
	        
	        pTT.add(txtGia);
	        pTT.add(txtTenMon);
	        pTT.add(txtMaLoai);
	        pTT.add(txtMaMon);
	        pTT.add(lbGia);
	        pTT.add(lbMaLoai);
	        pTT.add(lbMaMon);
	        pTT.add(lbTenMon);
	        pTT.add(btnSua);
	        pTT.add(btnThem);
	        pTT.add(btnXoa);
	        fQLMon.add(pTT);
	        fQLMon.add(pCTMon);
	        table.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent e)
	        	{
	        		jTable1MouseClicked(e);
	        	}
			});
	        btnThem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					themMon(e);
					
				}
			});
			btnSua.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								SuaMon(e);
								
							}
						});
			btnXoa.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					XoaMon(e);
					
				}
			});
	}

	//kiểm tra textfield có dữ liệu khjoong
	public boolean checkInput()
	{
		if(txtTenMon==null||txtMaMon==null||txtGia==null)
		{
			return false;
		}
		else {
			return true;
		}
	}
	//show du lieuj vào jtable
	public void showDataJtable()
	{
		//tạo các cột 
        DefaultTableModel model =(DefaultTableModel)table.getModel();
        
        //de load lại bảng khi có sự thay đổi thêm sửa xóa
        model.setRowCount(0);
        
        Object[] rowData = new Object[4];
        for(int i = 0; i < Connect.getFood().size(); i++){
		     rowData[0] =Connect.getFood().get(i).getMaFood();
		     rowData[1] = Connect.getFood().get(i).getTenFood();
		     rowData[2] = Connect.getFood().get(i).getMaLoaiF();
		     rowData[3] = Connect.getFood().get(i).getGiaTien();
		     
		      model.addRow(rowData);
        }
	}
	//show dữ liệu vào các textf
	public void showItem(int index)
	{
		txtMaMon.setText(Integer.toString(Connect.getFood().get(index).getMaFood()));
		txtTenMon.setText(Connect.getFood().get(index).getTenFood());
		txtMaLoai.setSelectedItem(Connect.getFood().get(index).getMaLoaiF());
		txtGia.setText(Integer.toString(Connect.getFood().get(index).getGiaTien()));
		
	}
	//xóa du lieu trên textfield
	public void XoaTF()
	{
		txtGia.setText("");
		txtMaLoai.setSelectedItem(null);
		txtMaMon.setText(null);
		txtTenMon.setText(null);
	}
//lấy dữ liệu khi click vaof 1 item món
	
	private void  jTable1MouseClicked(MouseEvent ev)
	{
		int index =table.getSelectedRow();
        showItem(index);

	}
	//
	private void themMon(ActionEvent e )
	{
		if(checkInput())
		{
			txtMaMon.setText(null);
			try {
				Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
				PreparedStatement ps=con.prepareStatement("INSERT dbo.Foods\r\n" + 
						"        ( TenFoods, MaLoaiFoods, GiaTien )\r\n" + 
						"VALUES  ( ?,?,?)");
				ps.setString(1, txtTenMon.getText());
				ps.setString(2, (String) txtMaLoai.getSelectedItem());
				ps.setInt(3, (Integer.parseInt(txtGia.getText())));
				
				ps.executeUpdate();
				showDataJtable();
//				new showBakery();
				new showCoffee(0);
//				new showMilkTea();
				JOptionPane.showMessageDialog(null, "Thêm món thành công!");
				XoaTF();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Thêm món không thành công!");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Dữ liệu trống!");
		}
	}
	//update
	private void SuaMon(ActionEvent e )
	{
		if(checkInput() && txtMaMon.getText()!=null)
		{
			
			try {
				Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
				PreparedStatement ps=con.prepareStatement("update Foods \r\n" + 
										"set TenFoods=?,MaLoaiFoods=?, GiaTien=? \r\n" + 
										"WHERE MaFoods=?");
				
				ps.setString(1, txtTenMon.getText());
				ps.setString(2, (String) txtMaLoai.getSelectedItem());
				ps.setInt(3, (Integer.parseInt(txtGia.getText())));
				ps.setInt(4, (Integer.parseInt(txtMaMon.getText())));
				
				ps.executeUpdate();
				showDataJtable();
				JOptionPane.showMessageDialog(null, "Sửa món thành công!");
				XoaTF();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Sửa món không thành công!");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Dữ liệu trống!");
		}
	}
	//xoa
	private void XoaMon(ActionEvent e )
	{
		if(checkInput( ) && txtMaMon.getText()!=null)
		{
			
			try {
				Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
				PreparedStatement ps=con.prepareStatement("delete from Foods where  MaFoods=?");
				
				ps.setInt(1, (Integer.parseInt(txtMaMon.getText())));
				
				ps.executeUpdate();
				showDataJtable();
				JOptionPane.showMessageDialog(null, "Xóa món thành công!");
				XoaTF();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Xóa món không thành công!");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Dữ liệu trống!");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
//thêm món vào bill-khách chọn thêm món
	private void MonAddBill(ActionEvent e )
	{
		if(checkInput())
		{
			txtMaMon.setText(null);
			try {
				Connection con=Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
				PreparedStatement ps=con.prepareStatement("INSERT dbo.Foods\r\n" + 
						"        ( TenFoods, MaLoaiFoods, GiaTien )\r\n" + 
						"VALUES  ( ?,?,?)");
				ps.setString(1, txtTenMon.getText());
				ps.setString(2, (String) txtMaLoai.getSelectedItem());
				ps.setInt(3, (Integer.parseInt(txtGia.getText())));
				
				ps.executeUpdate();
				showDataJtable();
				JOptionPane.showMessageDialog(null, "Thêm món thành công!");
				XoaTF();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Thêm món không thành công!");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Dữ liệu trống!");
		}
	} 
}
