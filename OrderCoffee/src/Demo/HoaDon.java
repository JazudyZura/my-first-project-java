package Demo;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;

import ConnectSqlServer.Connect;


public class HoaDon extends JPanel implements ActionListener {
	
	public HoaDon(int MaBan)
	{
		
		setLayout(null);
		ImageIcon cof=new ImageIcon("coc-cafe.jpg");
        JLabel lbcof=new JLabel(cof);
        JPanel pmon=new JPanel();
        
        JLabel lbNametabel=new JLabel("Bàn "+MaBan);
        JLabel lbGioDen=new JLabel("Giờ đến:... ");
        JLabel lbStatus =new JLabel("Status: trống ");
        JButton btnOrder=new JButton("Gọi món");
        
        lbNametabel.setBounds(170, 10, 130, 50);
        lbNametabel.setFont(new Font("Serif", Font.PLAIN, 35));
        
        lbGioDen.setBounds(20, 100, 250, 30);
        lbStatus.setBounds(20, 130, 200, 30);
        btnOrder.setBounds(100, 400, 130, 30);
        lbcof.setBounds(15, 180, 250, 200);    
        pmon.setBounds(15, 180, 250, 200);
        
        add(lbNametabel);
        add(lbcof);
        add(lbGioDen);
        add(lbStatus);
        add(btnOrder);
        add(pmon);
        
        //
        
		
		btnOrder.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				Connect.insertHoaDon(MaBan);
 				
 				Connect.updateTTBan(MaBan);
 				Connect.DemBanCoNguoi();
 				
 				Interface.pBill.removeAll();
 				Interface.pBill.add(new HoaDon1(MaBan));
 				Interface.pTable.removeAll();
 				Interface.loadTable();
 				
 				
 				
 			}

 		});
	}
	//update trangj thasi banf
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
