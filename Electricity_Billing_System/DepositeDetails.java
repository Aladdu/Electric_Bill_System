package Electricity_Billing_System;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
public class DepositeDetails extends JFrame implements ActionListener {
	Choice meternumber,monthchoice;
	JTable table;
	JButton search,print;
	DepositeDetails(){
		super("Deposite Details");
		
		
		JLabel JL1=new JLabel("Search By Meter Number");
		JL1.setBounds(20,20,150,20);
		add(JL1);
		
		meternumber=new Choice();
		meternumber.setBounds(180,20,150,20);
		add(meternumber);
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from NewCustomer");
			while(rs.next()){
				meternumber.add(rs.getString("meter_number"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel JL2=new JLabel("Search by Month");
		JL2.setBounds(400,20,100,20);
		add(JL2);
		
		monthchoice=new Choice();
		monthchoice.add("Not selected");
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
		monthchoice.setBounds(520,20,150,20);
		add(monthchoice);
		
		table=new JTable();
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from bill");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(0, 100,700,600);
		add(sp);
		
		search=new JButton("Search");
		search.setBounds(40, 70, 80, 20);
		search.addActionListener(this);
		add(search);

		print=new JButton("Print");
		print.setBounds(140, 70, 80, 20);
		print.addActionListener(this);
		add(print);
		
		setSize(700,700);
		setLocation(400,100);
		
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==search) {
			String query ="select * from bill where meter_no='"+meternumber.getSelectedItem()+"' and month='"+monthchoice.getSelectedItem()+"'";
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}else {
			try {
				table.print();
				}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new DepositeDetails();

	}

}
