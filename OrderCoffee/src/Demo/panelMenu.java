package Demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class panelMenu extends JPanel implements ActionListener{
	 static JPanel pMenu;
	public panelMenu(int MaBan) {
		
		 pMenu=new JPanel();
        
      JButton btnCF=new JButton("Coffee");
      JButton btnMT=new JButton("MilkTea");
      JButton btnBakery=new JButton("Bakery");
      
      
      pMenu.setBounds(1, 0, 375, 40);
      pMenu.setLayout(new FlowLayout());
      
      btnCF.setBackground(Color.decode("#8f2424"));
      btnMT.setBackground(Color.decode("#558000"));
      btnBakery.setBackground(Color.decode("#800060"));
      btnCF.setForeground(Color.WHITE);
      btnMT.setForeground(Color.WHITE);
      btnBakery.setForeground(Color.WHITE);
      pMenu.setBorder(new LineBorder(Color.GRAY));
      
      pMenu.add(btnCF);
      pMenu.add(btnMT);
      pMenu.add(btnBakery);
      add(pMenu);
      
      //
      //hien thi chi tiết tên và giá của loại nước
      //
      
      
      ImageIcon Menuimg=new ImageIcon("imgMe.jpg"); 
      JLabel img=new JLabel(Menuimg);
     img.setBounds(700, 110, 375, 450);
     add(img);
      
      JPanel pLoadMenu1=new JPanel();
      pLoadMenu1.setLayout(new BorderLayout());
      pLoadMenu1.setBounds(1, 50, 375, 450);
      
      JPanel pLoadMenu2=new JPanel();
      pLoadMenu2.setLayout(new BorderLayout());
      pLoadMenu2.setBounds(1, 50, 375, 450);
      
      JPanel pLoadMenu3=new JPanel();
      pLoadMenu3.setLayout(new BorderLayout());
      pLoadMenu3.setBounds(1, 50, 375, 450);
      
     
      add(pLoadMenu1);
      add(pLoadMenu2);
      add(pLoadMenu3);
      //add(pLoadMenu);
        
      
  //	hiển thị danh mục món coffee
  	
           btnCF.addActionListener(new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent e) {
   				
  				img.setVisible(false);
  				pLoadMenu2.setVisible(false);
  				pLoadMenu3.setVisible(false);
  				pLoadMenu1.setVisible(true);
  				pLoadMenu1.add(new  showCoffee(MaBan));
  				
  			}
  		});
         //hiển thị danh mục món
           btnMT.addActionListener(new ActionListener() {
   			
   			@Override
   			public void actionPerformed(ActionEvent e) {
   				img.setVisible(false);
   				pLoadMenu1.setVisible(false);
   				pLoadMenu3.setVisible(false);
  				pLoadMenu2.setVisible(true);
   				pLoadMenu2.add(new showMilkTea(MaBan));
   				
   			}
   		});
         //hiển thị danh mục món
           btnBakery.addActionListener(new ActionListener() {
   			
   			@Override
   			public void actionPerformed(ActionEvent e) {
   				img.setVisible(false);
   				pLoadMenu1.setVisible(false);
  				pLoadMenu2.setVisible(false);
  				pLoadMenu3.setVisible(true);
   				pLoadMenu3.add(new showBakery(MaBan));
   				
   								
   			}
   			});
  	       
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
