package application.db;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class DAO<e> {
	Connection conn;
	protected List<e> dati;
	
	public DAO() {
		conn = new MyConnection().setUser("root").setPassword("mysql123").open();
		dati=new ArrayList<>();
	}
	
	public abstract boolean leggi();
	
	public abstract int scrivi();
	
	public ObservableList<e> getDati() {
		return FXCollections.observableArrayList(dati);
	}

	public void setDati(List<e> dati) {
		this.dati = dati;
	}
}
