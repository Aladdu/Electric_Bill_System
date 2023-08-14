package Electricity_Billing_System;

import java.sql.*;

public class Conn {
	Connection c;
	public Statement s;
  public Conn(){
	  try {
	  //Class.forName("con.mysql.cj.jdbc.Driver");
	  c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","123143");
	  s=c.createStatement();
  }catch(Exception e) {
	  e.printStackTrace();
  }
  }
}
