package Electricity_Billing_System;

import java.awt.*;
import java.awt.desktop.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.border.*;
import javax.swing.*;
public class Signin extends JFrame implements ActionListener{
	Choice accounttype;
	JTextField meter,usertext,nametext, passwordtext;
	JButton b1,b2;
	
	public Signin(){
		setLayout(null);
		
		setSize(700,400);
		setLocation(450,150);
		getContentPane().setBackground(Color.white);
		
		JPanel panel=new JPanel();
		panel.setBounds(30,30, 650, 300);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"create account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
		panel.setBackground(Color.white);
		panel.setLayout(null);
		panel.setForeground(new Color(34,139,34));
		add(panel);
		

		JLabel l1=new JLabel("Create Account");
		l1.setBounds(100,50,140,20);
		l1.setForeground(Color.gray);
		l1.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(l1);
		
	    accounttype=new Choice();
		accounttype.add("Admin");
		accounttype.add("Customer");
		accounttype.setBounds(260, 50, 140, 20);
		panel.add(accounttype);
		
		
		
		JLabel l2=new JLabel("Meter No");
		l2.setBounds(100,90,140,20);
		l2.setForeground(Color.gray);
		l2.setFont(new Font("Tahoma",Font.BOLD,14));
		l2.setVisible(false);
		panel.add(l2);
		
	    meter=new JTextField();
		meter.setBounds(260, 90, 140, 20);
		meter.setVisible(false);
		panel.add(meter);
		
		
		
		JLabel l3=new JLabel("User Name");
		l3.setBounds(100,130,140,20);
		l3.setForeground(Color.gray);
		l3.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(l3);
		
		usertext=new JTextField();
		usertext.setBounds(260, 130, 140, 20);
		panel.add(usertext);
		
		JLabel l4=new JLabel("Name");
		l4.setBounds(100,170,140,20);
		l4.setForeground(Color.gray);
		l4.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(l4);
		
		 nametext=new JTextField();
		nametext.setBounds(260, 170, 140, 20);
		panel.add(nametext);
		
		meter.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent fe) {
				
			}@Override
			public void focusLost(FocusEvent fe) {
				try {
					Conn c=new Conn();
					ResultSet rs=c.s.executeQuery("select * from signin where Meter_number='"+meter.getText()+"'");
					while(rs.next()) {
						 nametext.setText(rs.getString("Name"));
					}
				}catch(Exception e) {
					e.printStackTrace();				}
				
			}
			
		});
		
		JLabel l5=new JLabel("Password");
		l5.setBounds(100,210,140,20);
		l5.setForeground(Color.gray);
		l5.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(l5);
		
		passwordtext=new JTextField();
		passwordtext.setBounds(260, 210, 140, 20);
		panel.add(passwordtext);
		
		 accounttype.addItemListener(new ItemListener() {
			 public void itemStateChanged(ItemEvent ae) {
				 String user=accounttype.getSelectedItem();
				 if(user.equals("Customer")) {
					 l2.setVisible(true);
					 meter.setVisible(true);
					 nametext.setEditable(false);
					 
				 }else {
					 l2.setVisible(false);
					 meter.setVisible(false);
					 nametext.setEditable(true);
				 }
				 
			 }

			
		 });
		
		b1=new JButton("create");
		b1.setBounds(120, 250, 120, 25);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		panel.add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(260, 250, 120, 25);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		panel.add(b2);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
		Image image=i1.getImage().getScaledInstance(205, 205, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(image);
		JLabel i3=new JLabel(i2);
		i3.setBounds(410, 30,250, 250);
		panel.add(i3);
	
		setVisible(true);
		}
	/*public void checkLabel() {
		if(meter.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Enter Meter number");
		}
		if(passwordtext.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Enter Meter number");
		}if(usertext.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Enter Meter number");
		}
		
		
	}*/
	public void actionPerformed(ActionEvent ae) {
		
			try {
			 if(ae.getSource()==b1) 
				{
					String atype=accounttype.getSelectedItem();
					String smeter=meter.getText();
					String susername=usertext.getText();
					String sname=usertext.getText();
					String spassword=passwordtext.getText();
					
				if(susername.equals(""))
					{
						JOptionPane.showMessageDialog(null, "User name requied");	
					}
					else if(spassword.equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Password requied");	
					}
					else if(ae.getSource()==b2)
					{
						setVisible(false);
						new Login();
					}
					else {
				    Conn c=new Conn();
			     	String query=null;
				    if(atype.equals("Admin"))
			     	  {
					query="insert into signin values('"+atype+"','"+smeter+"','"+susername+"','"+sname+"','"+spassword+"')";				
			    	  }else 
			    	  {
					query="update signin set User_name='"+susername+"',password='"+spassword+"',Accounttype='"+atype+"' where Meter_number='"+smeter+"'";
			    	  }
				   c.s.executeUpdate(query);
			       JOptionPane.showMessageDialog(null, "Account created successfully");
				   setVisible(false);
				   new Login();
				   
				}	}
				else if(ae.getSource()==b2)
				{
					setVisible(false);
					new Login();
				}}
		  catch(Exception e) 
				{
				e.printStackTrace();
			    }
		}
		
		public static void main(String[] args) {
		new Signin();

	}

}
