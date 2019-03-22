package Demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


import ConnectSqlServer.Connect;

import ConnectSqlServer.MonOrderClick;


public class showCoffee extends JButton implements ActionListener {
	
	
	public showCoffee(int MaBan)
	{
		
		setLayout(new GridLayout(Connect.getFoodCF().size(),1,5,5));
		 for (int i = 0; i <Connect.getFoodCF().size(); i++) {
	         		JButton btnMenu=new JButton(Connect.getFoodCF().get(i).getTenFood()+"\t   "+Connect.getFoodCF().get(i).getGiaTien()+" VND");
	         		btnMenu.setFont(new Font("Serif", Font.PLAIN, 16));
	             	btnMenu.setBackground(Color.decode("#660000"));
	             	btnMenu.setForeground(Color.WHITE);
	             	btnMenu.setFont(new Font("Serif", Font.PLAIN, 17));
	             	JScrollPane pane = new JScrollPane(btnMenu);
	         		add(pane);
	         		//add(btnMenu);
	         		MonOrderClick idFood=new MonOrderClick(Connect.getFoodCF().get(i).getMaFood());
	         		
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
									
									if(idBill!=-1)
									{
										
										Connect.insertChiTietHD(idBill, maFood);
										
										HoaDon1.ShowMon(MaBan);
									}
									else
									{
										
//										
										Connect.insertHoaDon(idTable);
										idBill=Connect.getHDUnCheckBill(MaBan).get(0).getMaHD();
										Connect.insertChiTietHD(idBill, maFood);
												
										
										HoaDon1.ShowMon(MaBan);
									}
							}	
						
	         		
					});
	         	
	         	
		 }
	         
		        
	}
	
// add cac gia tri khi click vao button menu


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
