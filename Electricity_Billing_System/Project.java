package Electricity_Billing_System;
import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
public class Project extends JFrame implements ActionListener{
	JMenuItem newcustomer,calculater,customerdetails,depositedetails,calculatebill,updateinformation,viewinformation,paybills,billdetails,generatebill,notepad,exit;
	String atype,meter;
	Project(String atype,String meter){
		this.atype=atype;
		this.meter=meter;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/1.png"));
		Image i2=i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
		ImageIcon image=new ImageIcon(i2);
		JLabel L1=new JLabel(image);
		add(L1);
		
		JMenuBar mg=new JMenuBar();
		setJMenuBar(mg);
		
		JMenu master=new JMenu("Master");
		master.setForeground(Color.BLUE);
		
		
		newcustomer=new JMenuItem("New Customer");
		newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
		newcustomer.setBackground(Color.white);
		ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
		Image image1=i3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		newcustomer.setIcon(new ImageIcon(image1));
		newcustomer.setMnemonic('D');
		newcustomer.addActionListener(this);
		newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		master.add(newcustomer);
		
		customerdetails=new JMenuItem("Customer Details");
		customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
		customerdetails.setBackground(Color.white);
		ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
		Image image2=i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		customerdetails.setIcon(new ImageIcon(image2));
		customerdetails.setMnemonic('M');
		customerdetails.addActionListener(this);
		customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		master.add(customerdetails);
		
	    depositedetails=new JMenuItem("Deposite Bill");
		depositedetails.setFont(new Font("monospaced",Font.PLAIN,12));
		depositedetails.setBackground(Color.white);
		ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
		Image image3=i5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		depositedetails.setIcon(new ImageIcon(image3));
		depositedetails.setMnemonic('N');
		depositedetails.addActionListener(this);
		depositedetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		master.add(depositedetails);
		
		calculatebill=new JMenuItem("Calculate Bill");
		calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
		calculatebill.setBackground(Color.white);
		ImageIcon i6=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
		Image image4=i6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		calculatebill.setIcon(new ImageIcon(image4));
		calculatebill.setMnemonic('L');
		calculatebill.addActionListener(this);
		calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		master.add(calculatebill);
		
		JMenu information=new JMenu("Information");
		information.setForeground(Color.RED);
	
		
		updateinformation=new JMenuItem("Update Information");
		updateinformation.setFont(new Font("monospaced",Font.PLAIN,12));
		updateinformation.setBackground(Color.white);
		ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
		Image image5=i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		updateinformation.setIcon(new ImageIcon(image5));
		updateinformation.setMnemonic('U');
		updateinformation.addActionListener(this);
		updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
		information.add(updateinformation);
		
		viewinformation=new JMenuItem("View Information");
		viewinformation.setFont(new Font("monospaced",Font.PLAIN,12));
		viewinformation.setBackground(Color.white);
		ImageIcon i8=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
		Image image6=i8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		viewinformation.setIcon(new ImageIcon(image6));
		viewinformation.setMnemonic('V');
		viewinformation.addActionListener(this);
		viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		information.add(viewinformation);
		
		JMenu user=new JMenu("User");
		user.setForeground(Color.BLUE);
		
		
		paybills=new JMenuItem("Pay Bill");
		paybills.setFont(new Font("monospaced",Font.PLAIN,12));
		paybills.setBackground(Color.white);
		ImageIcon i9=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
		Image image7=i9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		paybills.setIcon(new ImageIcon(image7));
		paybills.setMnemonic('P');
		paybills.addActionListener(this);
		paybills.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		user.add(paybills);
		
		
		billdetails=new JMenuItem("Bill Details");
		billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
		billdetails.setBackground(Color.white);
		ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
		Image image8=i10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		billdetails.setIcon(new ImageIcon(image8));
		billdetails.setMnemonic('B');
		billdetails.addActionListener(this);
		billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		user.add(billdetails);
		
		JMenu report=new JMenu("Report");
		report.setForeground(Color.RED);
		
		
		generatebill=new JMenuItem("Generate BIll");
		generatebill.setFont(new Font("monospaced",Font.PLAIN,12));
		generatebill.setBackground(Color.white);
		ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
		Image image9=i11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		generatebill.setIcon(new ImageIcon(image9));
		generatebill.setMnemonic('G');
		generatebill.addActionListener(this);
		generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		report.add(generatebill);
		
		JMenu utility=new JMenu("Utility");
		utility.setForeground(Color.BLUE);
		
		
		notepad=new JMenuItem("Note Pad");
		notepad.setFont(new Font("monospaced",Font.PLAIN,12));
		notepad.setBackground(Color.white);
		ImageIcon i12=new ImageIcon(ClassLoader.getSystemResource("icon/icon10.png"));
		Image image10=i12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		notepad.setIcon(new ImageIcon(image10));
		notepad.setMnemonic('I');
		notepad.addActionListener(this);
		notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		utility.add(notepad);
		
		calculater=new JMenuItem("Calculater");
		calculater.setFont(new Font("monospaced",Font.PLAIN,12));
		calculater.setBackground(Color.white);
		ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
		Image image11=i13.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		calculater.setIcon(new ImageIcon(image11));
		calculater.setMnemonic('I');
		calculater.addActionListener(this);
		calculater.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		utility.add(calculater);
		
		JMenu mexit=new JMenu("Exit");
		mexit.setForeground(Color.RED);
		
		
		exit=new JMenuItem("Exit");
		exit.setFont(new Font("monospaced",Font.PLAIN,12));
		exit.setBackground(Color.white);
		ImageIcon i14=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
		Image image12=i14.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		exit.setIcon(new ImageIcon(image12));
		exit.setMnemonic('I');
		exit.addActionListener(this);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		mexit.add(exit);
		
		
		if(atype.equals("Admin")) {
			mg.add(master);
		}else {

			mg.add(information);
			mg.add(user);
			mg.add(report);
			
			
		}
		mg.add(utility);
		mg.add(mexit);
		
		
		setLayout(new FlowLayout());
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		String mg=ae.getActionCommand();
		if(mg.equals("New Customer")) {
			new NewCustomer();
		}else if(mg.equals("Customer Details")) {
			new CustomerDetails();
		}else if(mg.equals("Deposite Bill")) {
			new DepositeDetails();
			
		}else if(mg.equals("Calculate Bill")) {
			new CalculateBill(" ");
		}else if(mg.equals("View Information")) {
			new ViewInfromation(meter);
		}else if(mg.equals("Update Information")) {
			new UpdateInformation(meter);
		}else if(mg.equals("Bill Details")) {
			new BillDetails(meter);
		}
		else if(mg.equals("Pay Bill")) {
			new PayBill(meter);
		}
		else if(mg.equals("Generate BIll")) {
			new GenerateBill(meter);
		}
		else if(mg.equals("Note Pad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(mg.equals("Calculater")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(mg.equals("Exit")) {
			setVisible(false);
			new Login();
		}
	}

	public static void main(String[] args) {
		new Project("","");
	}

}
