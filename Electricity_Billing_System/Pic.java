package Electricity_Billing_System;

import java.awt.Image;
import javax.swing.*;

public class Pic extends JFrame implements Runnable{

	
		Thread t;
		Pic(){
		ImageIcon l1=new ImageIcon(ClassLoader.getSystemResource("icon/2.png")); 
		Image l2=l1.getImage().getScaledInstance(730, 800, Image.SCALE_DEFAULT);
		ImageIcon l3=new ImageIcon(l2);
		JLabel image=new JLabel(l3);
		add(image);
		
		setVisible(true);
		
		setBounds(300,100,730,500);
		
		
		t=new Thread(this);
		t.start();
		
		setVisible(true);
	}
	public void run() {
		try {
			Thread.sleep(5000);
			setVisible(false);
			new Project("", "");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		public static void main(String[] args) {
			new Pic();
		}

	}

