package application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DATABASE = "spesa2?autoReconnect=true&useSSL=false";
	private final static String USER = "root";
	private final static String PASSWORD = "mysql123";
	private String user;
	private String password;
	private static MyConnection instance;

	private MyConnection() {
		user = "";
		password = "";
	}

	public static MyConnection getInstance() {
		if (instance == null) {
			// Thread Safe. Might be costly operation in some case
			synchronized (MyConnection.class) {
				if (instance == null) {
					instance = new MyConnection();
				}
			}
		}
		return instance;
	}

	public MyConnection setUser(String user) {
		this.user = user;
		return this;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public MyConnection setPassword(String password) {
		this.password = password;
		return this;
	}

	@Override
	public String toString() {
		return String.format("%-20s\n%-15s - %-15s\n", URL + DATABASE, user, password);
	}

	public Connection open() {
		if (isCredenzialiAccesso()) {
			System.out.println("Credenziali di accesso corrette");
			System.out.println("Attendere la connessione al database...");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				return DriverManager.getConnection(URL + DATABASE, user, password);
			} catch (ClassNotFoundException e1) {
				System.out.println("Driver JDBC mancante");
				System.exit(0);
			} catch (SQLException e) {
				System.out.println("Database non presente");
				System.exit(0);
			}
		} else {
			System.out.println("Credendiziali errate");
		}
		return null;
	}

	private boolean isCredenzialiAccesso() {
		return (USER == user && PASSWORD == password);
	}
}