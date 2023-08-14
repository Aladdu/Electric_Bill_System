package Electricity_Billing_System;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
public class CustomerDetails extends JFrame implements ActionListener  {
		Choice meternumber,monthchoice;
		JTable table;
		JButton search,print;
		CustomerDetails(){
			super("CustomerDetails");
			
			
			
			table=new JTable();
			
			try {
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery("select * from  NewCustomer");
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			JScrollPane sp=new JScrollPane(table);
			add(sp);

			print=new JButton("Print");
			print.addActionListener(this);
			add(print,"South");
			
			setSize(1200,650);
			setLocation(200,150);
			
			
			
			setVisible(true);
			
		}
		public void actionPerformed(ActionEvent ae) {
			
				try {
					table.print();
					}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
		public static void main(String[] args) {
			new CustomerDetails();

		}

	}