package Demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JScrollPane;

import ConnectSqlServer.Connect;
import ConnectSqlServer.MonOrderClick;

public class showMilkTea extends JButton implements ActionListener {
	
	public showMilkTea(int MaBan)
	{
		
		setLayout(new GridLayout(Connect.getFoodMT().size(),1,5,5));
		 for (int i = 0; i <Connect.getFoodMT().size(); i++) {
	         		JButton btnMenu=new JButton(Connect.getFoodMT().get(i).getTenFood()+"\t   "+Connect.getFoodMT().get(i).getGiaTien()+" VND");
	         		btnMenu.setFont(new Font("Serif", Font.PLAIN, 16));
	             	btnMenu.setBackground(Color.decode("#558000"));
	             	btnMenu.setForeground(Color.WHITE);
	             	btnMenu.setFont(new Font("Serif", Font.PLAIN, 17));
	             	JScrollPane pane = new JScrollPane(btnMenu);
	         		add(pane);
	         		//add(btnMenu);
	         		MonOrderClick idFood=new MonOrderClick(Connect.getFoodMT().get(i).getMaFood());
	         		
	         		btnMenu.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
											
							int idTable=MaBan, idBill;						//mã bàn hiện tại đang order
							
							if(Connect.DemHD(MaBan)!=0)
							{
								idBill=Connect.getHDUnCheckBill(MaBan).get(0).getMaHD();		//mã hóa đơn của khách
							}
							else {
								idBill=-1;
							}
							int maFood= idFood.getMaFood();				//mã món khách chọn
							//JOptionPane.showMessageDialog(null, "mamon "+idFood.getMaFood());
							if(idBill!=-1)
							{
								//JOptionPane.showMessageDialog(null, "ba da co hoa don");
								Connect.insertChiTietHD(idBill, maFood);
								HoaDon1.table.removeAll();
								HoaDon1.ShowMon(MaBan);
							}
							else
							{
								
//								JOptionPane.showMessageDialog(null, "ba chua  co hoa don, moi them hvao");
								Connect.insertHoaDon(idTable);
								idBill=Connect.getHDUnCheckBill(MaBan).get(0).getMaHD();
								Connect.insertChiTietHD(idBill, maFood);
										
								HoaDon1.table.removeAll();
								HoaDon1.ShowMon(MaBan);
							}
							
						}
					});
	         	
	                
	         }
		        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
