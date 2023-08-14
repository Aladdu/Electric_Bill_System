package Electricity_Billing_System;

import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame implements ActionListener {
	String meter;
	JButton back;
	Paytm(String meter){
		
		this.meter=meter;
		
		JEditorPane j=new JEditorPane();
		j.setEditable(false);
		try {
			j.setPage("https://paytm.com/online-payments");
		}catch(Exception e) {
			j.setContentType("text/html");
			j.setText("<html> Could not Load</html>");
		}
		JScrollPane pane=new JScrollPane();
		add(pane);
		
		back=new JButton("back");
		back.setBounds(640, 20, 80,30);
		back.addActionListener(this);
		j.add(back);
		
		setSize(800,600);
		setLocation(400,150);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		
	}

	public static void main(String[] args) {
		new Paytm("");

	}

}
