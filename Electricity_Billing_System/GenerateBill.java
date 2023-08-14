package Electricity_Billing_System;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class GenerateBill extends JFrame implements ActionListener{
	Choice month;
	String meter;
	JButton  bill;
	JTextArea area;
	GenerateBill(String meter){
		this.meter=meter;
		setSize(500,800);
		setLocation(550,30);
		setLayout(new BorderLayout());
		Panel panel=new Panel();
		
		JLabel heading=new JLabel("Generate Bill");
		JLabel meternumber=new JLabel("Meter No");
		
		month=new Choice();
		month.add("January");
		month.add("February");
		month.add("March");
		month.add("April");
		month.add("May");
		month.add("June");
		month.add("July");
		month.add("August");
		month.add("September");
		month.add("October");
		month.add("Navember");
		month.add("December");
		add(month);
		
		 area=new JTextArea(50,15);
		area.setText("\n\n\t------Click on the-------\n\t Generate bill button to get\n\t the bill of the month selected");
		area.setFont(new Font("Senserif",Font.ITALIC,18));
		
		
		JScrollPane pane=new JScrollPane(area);
		
		  bill=new JButton("Generete bill");
		  bill.addActionListener(this);
		
		panel.add(heading);
		panel.add(meternumber);
		panel.add(month);
		add(panel,"North");
		
		add(pane,"Center");
		add(bill,"South");
		
		setVisible(true);
		area.setEditable(false);	}
	public void actionPerformed(ActionEvent ae)  {
	 try {
		 Conn c=new Conn();
		 
		 String cmonth=month.getSelectedItem();
		
		 area.setText("\tReliance Power Limited\n Electricity Bill Generated For The Month\n\tof"+cmonth+",2023\n\n\n");
		 ResultSet rs=c.s.executeQuery("select * from NewCustomer where Meter_number='"+meter+"'");
		 if(rs.next()) {
			 area.append("\n   Customer name :"+rs.getString("name"));
			 area.append("\n   Meter number  :"+rs.getString("Meter_number"));
			 area.append("\n   address         :"+rs.getString("address"));
			 area.append("\n   city            :"+rs.getString("city"));
			 area.append("\n   state           :"+rs.getString("state"));
			 area.append("\n   Email           :"+rs.getString("email"));
			 area.append("\n   PhoneNo         :"+rs.getString("phoneno"));
			 area.append("\n------------------------------------------");
			 area.append("\n");
			 
		 }
		 rs=c.s.executeQuery("select * from Meter_Details where Meter_number='"+meter+"'");
		 if(rs.next()) {
			 area.append("\n   Meter Location   :"+rs.getString("meter_location"));
			 area.append("\n   Meter PhaseCode  :"+rs.getString("Meter_phasecode"));
			 area.append("\n   BillType         :"+rs.getString("Meter_billtype"));
			 area.append("\n   Days             :"+rs.getString("Days"));
			 area.append("\n------------------------------------------");
			 area.append("\n");
			 
		 }
		 rs=c.s.executeQuery("select * from tax ");
		 if(rs.next()) {
			 area.append("\n   Cost_per_units  :"+rs.getString("cost_per_unit"));
			 area.append("\n   Meter rent  :"+rs.getString("meter_rent"));
			 area.append("\n   Service chagre         :"+rs.getString("service_charge"));
			 area.append("\n   Service Tax           :"+rs.getString("service_tax"));
			 area.append("\n   Swatcha Bharath Tax         :"+rs.getString("swacch_bharat_cess"));
			 area.append("\n   Field tax           :"+rs.getString("fixed_tax"));
			 area.append("\n------------------------------------------");
			 area.append("\n");
			 
		 }
		 rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"' and Month='"+cmonth+"' ");
		 if(rs.next()) {
			 area.append("\n  Month  :"+rs.getString("month"));
			 area.append("\n   Units :"+rs.getString("units"));
			 area.append("\n   TotalBill:"+rs.getString("totalbill"));
			 area.append("\n------------------------------------------");
			 area.append("\n   TotalBill:"+rs.getString("totalbill"));
			 area.append("\n");
			 
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
 }
	public static void main(String[] args) {
		new GenerateBill("");
		

	}

}
