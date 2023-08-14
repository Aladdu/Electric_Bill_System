package Electricity_Billing_System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.*;

public class PayBill extends JFrame implements ActionListener {
	Choice monthchoice;
	String meter;
	JButton pay,back;
	PayBill(String meter){
		this.meter=meter;
		
		JLabel heading=new JLabel("Electricity Bill");
		heading.setBounds(120, 5, 400, 20);
		heading.setFont(new Font("Tohoma",Font.BOLD,24));
		add(heading);
		
		JLabel lb1meternumber=new JLabel("Meter Number");
		lb1meternumber.setBounds(35, 80,200, 20);
		add(lb1meternumber);
		
		JLabel meternumber=new JLabel("");
		meternumber.setBounds(300, 80,200, 20);
		add(meternumber);
		
		JLabel lb1name=new JLabel("Meter Number");
		lb1name.setBounds(35, 140,200, 20);
		add(lb1name);
		
		JLabel name=new JLabel("");
		name.setBounds(300, 140,200, 20);
		add(name);
		
		JLabel lb1month=new JLabel("Month");
		lb1month.setBounds(35, 200,200, 20);
		add(lb1month);
		
		monthchoice=new Choice();
	
		monthchoice.add("January");
		monthchoice.add("February");
		monthchoice.add("March");
		monthchoice.add("April");
		monthchoice.add("May");
		monthchoice.add("June");
		monthchoice.add("July");
		monthchoice.add("August");
		monthchoice.add("September");
		monthchoice.add("October");
		monthchoice.add("Navember");
		monthchoice.add("December");
		monthchoice.setBounds(300,200,200,20);
		add(monthchoice);
		
		JLabel lb1units=new JLabel("Units");
		lb1units.setBounds(35, 260,200, 20);
		add(lb1units);
		
		JLabel units=new JLabel("");
		units.setBounds(300, 260,200, 20);
		add(units);
		
		JLabel lb1totalbill=new JLabel("Total Bill");
		lb1totalbill.setBounds(35,320,200, 20);
		add(lb1totalbill);
		
		JLabel totalbill=new JLabel("");
		totalbill.setBounds(300, 320,200, 20);
		add(totalbill);
		
		JLabel lb1status=new JLabel("Status");
		lb1status.setBounds(35,380,200, 20);
		add(lb1status);
		
		JLabel status=new JLabel("");
		 status.setBounds(300, 380,200, 20);
		 status.setForeground(Color.red);
		add( status);
		
		
		try {
			try {
			    Conn c = new Conn();
			    
			    ResultSet rs = c.s.executeQuery("SELECT * FROM NewCustomer WHERE Meter_number = '" + meter + "'");
			    while (rs.next()) {
			        meternumber.setText(meter);
			        name.setText(rs.getString("name"));
			    }
			    
			    String query = "SELECT * FROM bill WHERE Meter_No = '" + meter + "' AND Month = '" + monthchoice.getSelectedItem() + "'";
			    //System.out.println("Query: " + query); // Print the query for debugging
			    rs = c.s.executeQuery(query);
                while (rs.next()) {
			        units.setText(rs.getString("units"));
			        totalbill.setText(rs.getString("totalbill"));
			        status.setText(rs.getString("status"));
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * FROM NewCustomer WHERE Meter_number = '"+meter+"'");
			while(rs.next()) {
				meternumber.setText(meter);
				name.setText(rs.getString("name"));
			}
			rs=c.s.executeQuery("select * from bill WHERE Meter_No = '"+meter+"' AND Month = 'January'");
			while(rs.next()) {
				units.setText(rs.getString("units"));
				totalbill.setText(rs.getString("totalbill"));
				status.setText(rs.getString("status"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		monthchoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ae) {

				try {
					Conn c=new Conn();
					
					ResultSet rs=c.s.executeQuery("select * from bill where Meter_No = '"+meter+"' AND Month = '"+monthchoice.getSelectedItem()+"'");
					while(rs.next()) {
						units.setText(rs.getString("units"));
						totalbill.setText(rs.getString("totalbill"));
						status.setText(rs.getString("status"));
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				

			}
		});
		pay=new JButton("Pay");
		pay.setBackground(Color.black);
		pay.setForeground(Color.white);
		pay.setBounds(100, 460,100, 20);
		pay.addActionListener(this);
		add(pay);
		
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(230, 460,100, 20);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
		Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(400, 120, 600, 300);
		add(image);
		
		
		setLayout(null);
		setBounds(300,150,900,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==pay) {
			try {
				Conn c=new Conn();
				c.s.executeUpdate("update bill set status='paid' where meter_no='"+meter+"' And month='"+monthchoice.getSelectedItem()+"'");
			}catch(Exception e) {
				e.printStackTrace();
			}
			setVisible(false);
			new Pic();
			
		}else {
			setVisible(false);
			new Project("","");
			
		}
	}
	public static void main(String[] args) {
		
   new PayBill("");
	}

}
