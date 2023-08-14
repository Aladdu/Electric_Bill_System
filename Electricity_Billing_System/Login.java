package Electricity_Billing_System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	JButton Bt1,Bt2,Bt3;
	Choice Tf3;
	JTextField Tf1,Tf2;
    public Login(){
	super("Login Page");
	getContentPane().setBackground(Color.WHITE);
	setLayout(null);
	
	ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
	Image l1=image.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	ImageIcon l2=new ImageIcon(l1);
	JLabel l3=new JLabel(l2);
	l3.setBounds(0, 0, 250, 250);
	add(l3);
	
	JLabel Lb1=new JLabel("User name");
	Lb1.setBounds(300, 20, 100, 20);
	add(Lb1);
	
	JLabel Lb2=new JLabel("Password");
	Lb2.setBounds(300, 60, 100, 20);
	add(Lb2);
	
	JLabel Lb3=new JLabel("Login As");
	Lb3.setBounds(300, 100, 100, 20);
	add(Lb3);
	
	Tf1=new JTextField();
	Tf1.setBounds(400, 20, 150, 20);
	add(Tf1);
	
    Tf2=new JTextField();
	Tf2.setBounds(400, 60, 150, 20);
	add(Tf2);
	 
	 Tf3=new Choice();
	Tf3.add("Not Selected");
	Tf3.add("Admin");
	Tf3.add("Customer");
	Tf3.setBounds(400, 100, 150, 20);
	add(Tf3);
	
	 Bt1=new JButton("Login");
	Bt1.setBounds(330, 160, 100, 20);
    Bt1.setBackground(Color.black);
    Bt1.setForeground(Color.white);
    Bt1.addActionListener(this);
	add(Bt1);
	
	Bt2=new JButton("Cancal");
	Bt2.setBounds(450, 160, 100, 20);
    Bt2.setBackground(Color.black);
    Bt2.setForeground(Color.white);
    Bt2.addActionListener(this);
	add(Bt2);
	
	Bt3=new JButton("Signup");
	Bt3.setBounds(330, 200, 220, 20);
    Bt3.setBackground(Color.black);
    Bt3.setForeground(Color.white);
    Bt3.addActionListener(this);
	add(Bt3);
	
	setSize(640,300);
	setLocation(400,200);
	setVisible(true);
		
}
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==Bt1) {
		String susername=Tf1.getText();
		String spassword=Tf2.getText();
		String suser=Tf3.getSelectedItem();
		
		if(susername.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Username name requied");	
		}
		else if(spassword.equals("")) {
			JOptionPane.showMessageDialog(null, "Password name requied");	
			
		}
		else if(suser.equals("")) {
			JOptionPane.showMessageDialog(null, "User name requied");	
			
		}else {
		try {
			Conn c=new Conn();
			String query="select * from signin where User_name='"+susername+"'and password='"+spassword+"'and Accounttype='"+suser+"'";
			
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next()) {
				String meter=rs.getString("Meter_number");
				setVisible(false);
				new Project(suser,meter);
			}else {
				JOptionPane.showMessageDialog(null,"Invalid Details");
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		
	}}else if(ae.getSource()==Bt2) {
		setVisible(false);
	}else if(ae.getSource()==Bt3) {
		setVisible(false);
		new Signin();
	}
	
}
	
public static void main(String[] args) {
		new Login();

	}

}
