package application.db;

import java.sql.Connection;
import java.sql.SQLException;

import application.model.ListModel;

public abstract class DAO<e> {
	protected static Connection conn;

	public DAO() {
		if (conn == null)
			conn = MyConnection.getInstance().setUser("root").setPassword("mysql123").open();
	}

	/**
	 * fa una select sul database, recuperando i record da una tabella per
	 * aggiungerli alla lista dati
	 * 
	 * @return int numero di record estratti dal database
	 */
	public abstract int leggi(ListModel<e> modello);

	/**
	 * fa una insert sul database, aggiungendo i dati nel tabella
	 * 
	 * @return int numero di record aggiornati o inseriti
	 */
	public abstract int scrivi(ListModel<e> list);
	
	public abstract int lastRecord();
	
	
	@Override
	public abstract String toString();

	public static void chiudi() {
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Nessuna connessiona da chiudere");
		}
	}
}
