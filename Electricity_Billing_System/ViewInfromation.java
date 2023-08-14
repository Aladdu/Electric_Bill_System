package Electricity_Billing_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
public class ViewInfromation extends JFrame implements ActionListener {
	JButton cancel,search;
	String meter;
	ViewInfromation(String meter){
		this.meter=meter;
		setBounds(350,150,850,650);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
		JLabel heading=new JLabel("View Customer Infromation");
		heading.setBounds(250, 0, 500, 40);
		heading.setFont(new Font("Tohama",Font.PLAIN,20));
		add(heading);
		
		JLabel LB1name=new JLabel("Name");
		LB1name.setBounds(70, 80, 100, 20);
		LB1name.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1name);
		
		JLabel name=new JLabel(" ");
		name.setBounds(250, 80, 100, 20);
		name.setFont(new Font("Tohama",Font.PLAIN,15));
		add(name);
		
		JLabel LB1meterno=new JLabel("Meter Number");
		LB1meterno.setBounds(70, 140, 100, 20);
		LB1meterno.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1meterno);
		
		JLabel meterno=new JLabel(" ");
		meterno.setBounds(250,140, 100, 20);
		meterno.setFont(new Font("Tohama",Font.PLAIN,15));
		add(meterno);
		

		JLabel LB1address=new JLabel("Address");
		LB1address.setBounds(70, 200, 100, 20);
		LB1address.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1address);
		
		JLabel address=new JLabel(" ");
		address.setBounds(250,200, 100, 20);
		address.setFont(new Font("Tohama",Font.PLAIN,15));
		add(address);
		
		JLabel LB1city=new JLabel("City");
		LB1city.setBounds(70, 260, 100, 20);
		LB1city.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1city);
		
		JLabel city=new JLabel(" ");
		city.setBounds(250,260, 100, 20);
		city.setFont(new Font("Tohama",Font.PLAIN,15));
		add(city);
		
		JLabel LB1state=new JLabel("State");
		LB1state.setBounds(500, 80, 100, 20);
		LB1state.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1state);
		
		JLabel state=new JLabel(" ");
		state.setBounds(650,80, 100, 20);
		state.setFont(new Font("Tohama",Font.PLAIN,15));
		add(state);
		
		JLabel LB1email=new JLabel("Email");
		LB1email.setBounds(500, 140, 100, 20);
		LB1email.setFont(new Font("Tohama",Font.PLAIN,15));
		add(LB1email);
		
		JLabel email=new JLabel(" ");
		email.setBounds(650,140, 100, 20);
		email.setFont(new Font("Tohama",Font.PLAIN,15));
		add(email);
		
		JLabel LB1phoneno=new JLabel("Phone_NO");
		 LB1phoneno.setBounds(500, 200, 100, 20);
		 LB1phoneno.setFont(new Font("Tohama",Font.PLAIN,15));
		add( LB1phoneno);
		
		JLabel phoneno=new JLabel(" ");
		phoneno.setBounds(650,200, 100, 20);
		phoneno.setFont(new Font("Tohama",Font.PLAIN,15));
		add(phoneno);
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from NewCustomer where Meter_number='"+meter+"'");
			while(rs.next()) {
				name.setText(rs.getString("Name"));
				address.setText(rs.getString("address"));
				city.setText(rs.getString("city"));
				state.setText(rs.getString("state"));
				email.setText(rs.getString("email"));
				phoneno.setText(rs.getString("phoneno"));
				meterno.setText(rs.getString("Meter_Number"));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(350,320, 100, 25);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
		Image i2=i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(20, 350, 600,300);
		add(image);
		
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}
	public static void main(String[] args) {
		new ViewInfromation("");
	}

}
