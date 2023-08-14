package Electricity_Billing_System;
import java.awt.Image;
import javax.swing.*;
public class Splash extends JFrame implements Runnable{
	Thread t;
Splash(){
	ImageIcon l1=new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg")); 
	Image l2=l1.getImage().getScaledInstance(730, 800, Image.SCALE_DEFAULT);
	ImageIcon l3=new ImageIcon(l2);
	JLabel image=new JLabel(l3);
	add(image);
	
	setVisible(true);
	
	int x=1;
	for(int i=2;i<600;i+=4, x+=1) {
		setSize(i+x,i);
		setLocation(700-((i+x)/2),400-(i/2));
		try {
			Thread.sleep(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	t=new Thread(this);
	t.start();
	
	setVisible(true);
}
public void run() {
	try {
		Thread.sleep(5000);
		setVisible(false);
		new Login();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	
	public static void main(String[] args) {
		new Splash();
	}

}
