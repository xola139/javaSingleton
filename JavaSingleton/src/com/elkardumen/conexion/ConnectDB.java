package com.elkardumen.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private static Connection connect;
	private static ConnectDB instance;

	private ConnectDB() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			// connect DB
			connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/MyDataBase","root", "");
		}

		catch (SQLException e) {
			System.err.println(e.getMessage());

		}

		catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	public static ConnectDB getInstance() {
		//Esto servira para que solo se haga una vez garantizando el patron singleton
		if (instance == null) {
			System.out.println("Se crea la instancia solo una vez garantizanco el patron Singleton");
			instance = new ConnectDB();
		}

		return instance;

	}

	public static Connection getConnect() {
		return connect;
	}

	public static void setConnect(Connection connect) {
		ConnectDB.connect = connect;
	}


}