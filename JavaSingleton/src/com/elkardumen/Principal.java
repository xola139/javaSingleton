package com.elkardumen;

import java.sql.ResultSet;
import java.sql.Statement;

import com.elkardumen.conexion.ConnectDB;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
		
			
		//Creamos El primer llamado	
		ConnectDB con = ConnectDB.getInstance();
		
		Statement stmt =  con.getConnect().createStatement();
		
		String query = "select * from micatalogo;" ;
		ResultSet rs = stmt.executeQuery(query) ;
		
		while (rs.next())
		{
		    System.out.println (rs.getInt (1) + " - " + rs.getString (2)+ " - " + rs.getString(3));
		}
		
		//Creamos El segundo llamado
		ConnectDB con2 = ConnectDB.getInstance();
		Statement stmt2 =  con2.getConnect().createStatement();
		 
		rs = stmt.executeQuery(query) ;
		
		while (rs.next())
		{
		    System.out.println (rs.getInt (1) + " - " + rs.getString (2)+ " - " + rs.getString(3));
		}
		
		}catch(Exception e){
			e.printStackTrace();
			
		}


		
	}

}
