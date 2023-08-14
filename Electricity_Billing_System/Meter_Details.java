package Electricity_Billing_System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Meter_Details extends JFrame implements ActionListener{
	
	
	JTextField JT1,JT2,JT3,JT4,JT5,JT6;
	JButton submit;
	JLabel JL4,meterno;
	Choice meterlocation,metertype,phasecode,billtype;
	String meternumber;
	Meter_Details(String meternumber){
		this.meternumber=meternumber;
		
	JPanel p=new JPanel();
	p.setLayout(null);
	p.setBackground(new Color(173,213,230));
	add(p);
		
	JLabel JL1=new JLabel("Meter Information");
	JL1.setBounds(180, 10, 200, 25);
	JL1.setFont(new Font("tahoma",Font.PLAIN,24));
	p.add(JL1);
	
	JLabel JL2=new JLabel("Meter number");
	JL2.setBounds(100, 80, 100, 22);
	p.add(JL2);
	
	meterno=new JLabel("");
	meterno.setBounds(400, 80,200,20);
	add(meterno);
	try {
		Conn c=new Conn();
		ResultSet rs=c.s.executeQuery("select * from NewCustomer where meter_number='"+meternumber+"'");
			if(rs.next()) {
				meterno.setText(rs.getString("Meter_Number"));;
			}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	JLabel JL3=new JLabel("Meter Location");
	JL3.setBounds(100, 120, 100, 20);
	p.add(JL3);
	
	meterlocation=new  Choice();
	meterlocation.add("Not selected");
	meterlocation.add("Ouside");
	meterlocation.add("Inside");
	meterlocation.setBounds(220, 120, 200, 20);
	p.add(meterlocation);
			
	
    JLabel JL5=new JLabel("Meter Type");
	JL5.setBounds(100, 160, 100, 22);
	p.add(JL5);
	
	metertype=new  Choice();
	metertype.add("Not selected");
	metertype.add("Electric meter");
	metertype.add("Solar meter");
	metertype.add("Smart meter");
	metertype.setBounds(220, 160, 200, 20);
	p.add(metertype);
	
	JLabel JL6=new JLabel("Phase Code");
	JL6.setBounds(100, 200, 100, 22);
	p.add(JL6);
	
	phasecode=new  Choice();
	phasecode.add("Not selected");
	phasecode.add("011");
	phasecode.add("022");
	phasecode.add("033");
	phasecode.add("044");
	phasecode.add("055");
	phasecode.add("066");
	phasecode.add("077");
	phasecode.add("088");
	phasecode.add("099");
	phasecode.setBounds(220, 200, 200, 20);
	p.add(phasecode);
	
	JLabel JL7=new JLabel("Bill Type");
	JL7.setBounds(100, 240, 100, 22);
	p.add(JL7);
	
	billtype=new  Choice();
	billtype.add("Not selected");
	billtype.add("Normal");
	billtype.add("Industrial");
	billtype.setBounds(220, 240, 200, 20);
	p.add(billtype);
	
	JLabel JL8=new JLabel("Days");
	JL8.setBounds(100, 280, 100, 22);
	p.add(JL8);
	
	JLabel JL9=new JLabel("30 Days");
	JL9.setBounds(220, 280, 200, 20);
	p.add(JL9);
	
	JLabel JL10=new JLabel("Note");
	JL10.setBounds(100, 320, 200, 20);
	p.add(JL10);
	
	JLabel JL11=new JLabel("By Default bill is calculated for 30days only");
	JL11.setBounds(220, 320, 250, 20);
	p.add(JL11);
	
	
	submit=new JButton("Submit");
	submit.setBounds(270, 360, 80, 20);
	submit.setForeground(Color.white);
	submit.setBackground(Color.black);
	submit.addActionListener(this);
	p.add(submit);
	
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
		if(ae.getSource()==submit) {
			String meter_number=meternumber;
			String mlocation=meterlocation.getSelectedItem();
			String mphasecode=phasecode.getSelectedItem();
			String mbilltype=billtype.getSelectedItem();
			String days="30";
		
			
			String query1="insert into Meter_Details values('"+meter_number+"','"+mlocation+"','"+mphasecode+"','"+mbilltype+"','"+days+"')";
		
			 try {
				 Conn c=new Conn();
				c.s.executeUpdate(query1);
				
			JOptionPane.showMessageDialog(null, "Meter information added succussfully"); 
			setVisible(false);
			new Project("","");
				 
				 
			 }catch(Exception e) {
				e.printStackTrace(); 
			 }
						
		}else {
		setVisible(false);
	}
		
		
	}

	public static void main(String[] args) {
		
     new Meter_Details("");    
	}

}

	


