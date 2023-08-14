package Electricity_Billing_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class UpdateInformation extends JFrame implements ActionListener{
	JButton cancel,Update;
	JTextField tfaddress,tfcity, tfstate,tfemail,tfphoneno;
	String meter;
	UpdateInformation(String meter){
		this.meter=meter;
		setBounds(300,150,1050,450);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading=new JLabel("Update Customer Infromation");
		heading.setBounds(110, 0, 400, 30);
		heading.setFont(new Font("Tohama",Font.PLAIN,20));
		add(heading);
		
		JLabel LB1name=new JLabel("Name");
		LB1name.setBounds(30, 70, 110, 20);
		LB1name.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1name);
		
		JLabel name=new JLabel(" ");
		name.setBounds(230, 70, 200, 20);
		name.setFont(new Font("Tohama",Font.PLAIN,15));
		add(name);
		
		JLabel LB1meterno=new JLabel("Meter Number");
		LB1meterno.setBounds(30, 110, 100, 20);
		LB1meterno.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1meterno);
		
		JLabel meterno=new JLabel(" ");
		meterno.setBounds(230,110, 200,20);
		meterno.setFont(new Font("Tohama",Font.PLAIN,15));
		add(meterno);
		

		JLabel LB1address=new JLabel("Address");
		LB1address.setBounds(30, 150, 100, 20);
		LB1address.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1address);
		
		 tfaddress=new JTextField();
		 tfaddress.setBounds(230,150, 200, 20);
		 tfaddress.setFont(new Font("Tohama",Font.PLAIN,15));
		add(tfaddress);
		
		JLabel LB1city=new JLabel("City");
		LB1city.setBounds(30, 190, 100, 20);
		LB1city.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1city);
		
	    tfcity=new JTextField();
	    tfcity.setBounds(230,190, 200, 20);
	    tfcity.setFont(new Font("Tohama",Font.PLAIN,15));
		add(tfcity);
		
		JLabel LB1state=new JLabel("State");
		LB1state.setBounds(30,230, 100, 20);
		LB1state.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1state);
		
		 tfstate=new JTextField();
		 tfstate.setBounds(230,230, 200, 20);
		 tfstate.setFont(new Font("Tohama",Font.PLAIN,15));
		add( tfstate);
		
		JLabel LB1email=new JLabel("Email");
		LB1email.setBounds(30, 270, 100, 20);
		LB1email.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1email);
		
		 tfemail=new JTextField();
		 tfemail.setBounds(230,270, 200, 20);
		 tfemail.setFont(new Font("Tohama",Font.PLAIN,15));
		add(tfemail);
		
		JLabel LB1phoneno=new JLabel("Phone_NO");
		 LB1phoneno.setBounds(30, 310, 100, 20);
		 LB1phoneno.setFont(new Font("Tohama",Font.PLAIN,15));
		add( LB1phoneno);
		
		 tfphoneno=new JTextField();
		 tfphoneno.setBounds(230,310, 200, 20);
		 tfphoneno.setFont(new Font("Tohama",Font.PLAIN,15));
		add(tfphoneno);
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from NewCustomer where Meter_number='"+meter+"'");
			while(rs.next()) {
				name.setText(rs.getString("Name"));
				tfaddress.setText(rs.getString("address"));
				tfcity.setText(rs.getString("city"));
				tfstate.setText(rs.getString("state"));
				tfemail.setText(rs.getString("email"));
				tfphoneno.setText(rs.getString("phoneno"));
				meterno.setText(rs.getString("Meter_Number"));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		Update=new JButton("Update");
		Update.setBackground(Color.black);
		Update.setForeground(Color.white);
		Update.setBounds(70,360, 100, 25);
		Update.addActionListener(this);
		add(Update);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(260,360, 100, 25);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
		Image i2=i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(550, 50, 400,300);
		add(image);
		

		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==Update) {
			String address=tfaddress.getText();
			String city=tfcity.getText();
			String state=tfstate.getText();
			String email=tfemail.getText();
			String phoneno=tfphoneno.getText();
			try {
				Conn c=new Conn();
				c.s.executeUpdate("update newcustomer set address='"+address+"',city='"+city+"',state='"+state+"',email='"+email+"',phoneno='"+phoneno+"' where Meter_number='"+meter+"'");
				
				JOptionPane.showMessageDialog(null, "user Information update Succussfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			}else {
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateInformation("");

	}

}
