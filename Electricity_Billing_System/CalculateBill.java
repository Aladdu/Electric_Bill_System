
package Electricity_Billing_System;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
public class CalculateBill  extends JFrame implements ActionListener{
		
		JTextField JT1,JT3,JT4,JT5,JT6;
		JButton next,cancel;
		JLabel JL4,JT2;
		Choice lblmeternumber,cmonth;
		String meter;
		CalculateBill(String meter){
			this.meter=meter;
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173,213,230));
		add(p);
			
		JLabel JL1=new JLabel("Calculate Electricity Bill");
		JL1.setBounds(180, 10, 200, 20);
		JL1.setFont(new Font("tahoma",Font.PLAIN,24));
		p.add(JL1);
		
		JLabel JL2=new JLabel("Meter Number");
		JL2.setBounds(100, 80, 100, 22);
		p.add(JL2);
		
		
		lblmeternumber=new Choice();
		try {
			Conn c=new Conn();
			ResultSet re=c.s.executeQuery("select * from NewCustomer");
			while(re.next()) {
				lblmeternumber.add(re.getString("Meter_number"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		lblmeternumber.setBounds(220, 80, 200, 20);
		p.add(lblmeternumber);
		
		JLabel JL3=new JLabel("Name");
		JL3.setBounds(100, 120, 100, 20);
		p.add(JL3);
		
		 JL4=new JLabel(" ");
		JL4.setBounds(220, 120, 100, 20);
		p.add(JL4);
		
		
		
	    JLabel JL5=new JLabel("Address");
		JL5.setBounds(100, 160, 100, 22);
		p.add(JL5);
		
		JT2=new JLabel();
		JT2.setBounds(220, 160, 200, 20);
		p.add(JT2);
		
		
		lblmeternumber.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ae) {
				try {
					Conn c=new Conn();
					ResultSet rs=c.s.executeQuery("select * from NewCustomer where Meter_number='"+lblmeternumber.getSelectedItem()+"'");
					while(rs.next()) {
						 JL4.setText(rs.getString("Name"));
						 JT2.setText(rs.getString("address"));
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		JLabel JL6=new JLabel("Unit Consumed");
		JL6.setBounds(100, 200, 100, 22);
		p.add(JL6);
		
		JT3=new JTextField();
		JT3.setBounds(220, 200, 200, 20);
		p.add(JT3);
		
		JLabel JL7=new JLabel("Month");
		JL7.setBounds(100, 240, 100, 22);
		p.add(JL7);
		
		cmonth=new Choice();
		cmonth.add("Not selected");
		cmonth.add("January");
		cmonth.add("February");
		cmonth.add("March");
		cmonth.add("April");
		cmonth.add("May");
		cmonth.add("June");
		cmonth.add("July");
		cmonth.add("August");
		cmonth.add("September");
		cmonth.add("October");
		cmonth.add("Navember");
		cmonth.add("December");
		
		cmonth.setBounds(220, 240, 200, 20);
		p.add(cmonth);
		
		
		
	    next=new JButton("Submit");
		next.setBounds(220, 350, 80, 20);
		next.setForeground(Color.white);
		next.setBackground(Color.black);
		next.addActionListener(this);
		p.add(next);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(330, 350, 80, 20);
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
		setLocation(400,150);
		
		setVisible(true);
		
		}
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==next) {
				
				String meter_number=lblmeternumber.getSelectedItem();
				String units= JT3.getText();
				String month= cmonth.getSelectedItem();
				
				int totalbill=0;
				int unit_consumed=Integer.parseInt(units);
				
				String query="select * from tax";
				
				 try {
					 Conn c=new Conn();
					ResultSet rs=c.s.executeQuery(query);
					while(rs.next()) {
						totalbill +=unit_consumed*Integer.parseInt(rs.getString("cost_per_unit"));
						totalbill +=Integer.parseInt(rs.getString("meter_rent"));
						totalbill +=Integer.parseInt(rs.getString("service_charge"));
						totalbill +=Integer.parseInt(rs.getString("service_tax"));
						totalbill +=Integer.parseInt(rs.getString("swacch_bharat_cess"));
						totalbill +=Integer.parseInt(rs.getString("fixed_tax"));	
					}
				 }catch(Exception e) {
					e.printStackTrace(); 
				 }
				 String query2="insert into bill values('"+meter_number+"','"+month+"','"+units+"','"+totalbill+"','Not Paid')";
					try {
						Conn c=new Conn();
						c.s.executeUpdate(query2);
						
						JOptionPane.showMessageDialog(null,"Customer bill Updated Succussfully");
						setVisible(false);
						
					}catch(Exception e) {
						e.printStackTrace();
					}
			}
			else {
			setVisible(false);
		}
			
			
		}

		public static void main(String[] args) {
			
	     new CalculateBill("");    
		}

	}

