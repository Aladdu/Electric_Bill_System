package Electricity_Billing_System;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;


public class NewCustomer extends JFrame implements ActionListener{
	
	JTextField JT1,JT2,JT3,JT4,JT5,JT6;
	JButton next,cancel;
	JLabel JL4;
	NewCustomer(){
		
	JPanel p=new JPanel();
	p.setLayout(null);
	p.setBackground(new Color(173,213,230));
	add(p);
		
	JLabel JL1=new JLabel("New Customer");
	JL1.setBounds(180, 10, 200, 25);
	JL1.setFont(new Font("tahoma",Font.PLAIN,24));
	p.add(JL1);
	
	JLabel JL2=new JLabel("Customer name");
	JL2.setBounds(100, 80, 100, 22);
	p.add(JL2);
	
	
	JT1=new JTextField();
	JT1.setBounds(220, 80, 200, 20);
	p.add(JT1);
	
	JLabel JL3=new JLabel("Meter Number");
	JL3.setBounds(100, 120, 100, 20);
	p.add(JL3);
	
	 JL4=new JLabel(" ");
	JL4.setBounds(220, 120, 100, 20);
	p.add(JL4);
	
	
	Random ran=new Random();
	long number=ran.nextLong() % 1000000;
    JL4.setText(""+Math.abs(number));
	
    JLabel JL5=new JLabel("Address");
	JL5.setBounds(100, 160, 100, 22);
	p.add(JL5);
	
	JT2=new JTextField();
	JT2.setBounds(220, 160, 200, 20);
	p.add(JT2);
	
	JLabel JL6=new JLabel("City");
	JL6.setBounds(100, 200, 100, 22);
	p.add(JL6);
	
	JT3=new JTextField();
	JT3.setBounds(220, 200, 200, 20);
	p.add(JT3);
	
	JLabel JL7=new JLabel("State");
	JL7.setBounds(100, 240, 100, 22);
	p.add(JL7);
	
	JT4=new JTextField();
	JT4.setBounds(220, 240, 200, 20);
	p.add(JT4);
	
	JLabel JL8=new JLabel("Email");
	JL8.setBounds(100, 280, 100, 22);
	p.add(JL8);
	
	JT5=new JTextField();
	JT5.setBounds(220, 280, 200, 20);
	p.add(JT5);
	
	JLabel JL9=new JLabel("Phone No");
	JL9.setBounds(100, 320, 100, 22);
	p.add(JL9);
	
	JT6=new JTextField();
	JT6.setBounds(220, 320, 200, 20);
	p.add(JT6);
	
    next=new JButton("Next");
	next.setBounds(220, 360, 80, 20);
	next.setForeground(Color.white);
	next.setBackground(Color.black);
	next.addActionListener(this);
	p.add(next);
	
	cancel=new JButton("Cancel");
	cancel.setBounds(330, 360, 80, 20);
	cancel.setForeground(Color.white);
	cancel.setBackground(Color.black);
	cancel.addActionListener(this);
	p.add(cancel);
	
	setLayout(new BorderLayout());
	add(p,"Center");
	
	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
	Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image=new JLabel(i3);
	add(image,"West");
	
   getContentPane().setBackground(Color.white);
	
	setSize(700,500);
	setLocation(400,200);
	
	setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==next) {
			String name=JT1.getText();
			String meter_number=JL4.getText();
			String address= JT2.getText();
			String city= JT3.getText();
			String state= JT4.getText();
			String email= JT5.getText();
			String phone_no= JT6.getText();
			
			String query1="insert into NewCustomer values('"+name+"','"+meter_number+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone_no+"')";
			String query2="insert into signin values('','"+meter_number+"','','"+name+"','')";
			 try {
				 Conn c=new Conn();
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
			JOptionPane.showMessageDialog(null, "Customer detailes added succussfully"); 
			setVisible(false);
			new Meter_Details(meter_number);
			 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
						
		}else {
		setVisible(false);
	}
		
		
	}

	public static void main(String[] args) {
		
     new NewCustomer();    
	}

}
