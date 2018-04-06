package application.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class DAO<e> {
	protected static Connection conn;
	protected List<e> dati; 
	
	public DAO() {
		if (conn==null) 
			conn = MyConnection.getInstance().setUser("root").setPassword("mysql123").open();
		dati=new ArrayList<>();
	}
	
	/**
	 * fa una select sul database, recuperando i record da una tabella per aggiungerli alla lista dati
	 * @return int numero di record estratti dal database
	 */
	public abstract int leggi();
	
	/**
	 * fa una insert sul database, aggiungendo i dati nel tabella
	 * @return int numero di record aggiornati o inseriti
	 */
	public abstract int scrivi();
	
	/**
	 * 
	 * @return ObservableList<e> ottiene una lista osservabile di dati
	 */
	public ObservableList<e> getDati() {
		return FXCollections.observableArrayList(dati);
	}

	/**
	 * setta la lista di dati per poter scriverli poi sul database
	 * @param dati
	 */
	public void setDati(List<e> dati) {
		this.dati = dati;
	}
	
	@Override
	public abstract String toString();
	
	protected void chiudi() {
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Nessuna connessiona da chiudere");
		}
	}
}
