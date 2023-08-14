package Electricity_Billing_System;

import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;

public class BillDetails extends JFrame{
	String meter;
	BillDetails(String meter){
		this.meter=meter;
		setSize(7000,650);
		setLocation(400,150);
		
		getContentPane().setBackground(Color.white);
		
		JTable table=new JTable();
		
	try {
		Conn c=new Conn();
		String query="select * from bill where meter_no='"+meter+"'";
		ResultSet rs=c.s.executeQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	JScrollPane sp=new JScrollPane(table);
	sp.setBounds(0, 0,700, 650);
	add(sp);
		
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new BillDetails("");

	}

}
