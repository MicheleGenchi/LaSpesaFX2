package application.model;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelNegozio  {
	private IntegerProperty key=new SimpleIntegerProperty();
	private StringProperty nome=new SimpleStringProperty();
	private ObservableList<Integer> listaIdProdotti=FXCollections.observableArrayList();
	
	public ModelNegozio(int key, String nome) {
		setKey(key);
		setNome(nome);
	}

	public ModelNegozio(Negozio negozio) {
		this(negozio.getKey(),negozio.getNome());
	}
	
	public ModelNegozio() {
		this(0, "");
	}

	public final IntegerProperty keyProperty() {
		return this.key;
	}
	
	public final int getKey() {
		return this.keyProperty().get();
	}

	public final void setKey(final int key) {
		this.keyProperty().set(key);
	}
	
	public final StringProperty nomeProperty() {
		return this.nome;
	}

	public final String getNome() {
		return this.nomeProperty().get();
	}

	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}


	/**
	 * @return the listaIdProdotti
	 */
	public ObservableList<Integer> getListaIdProdotti() {
		return listaIdProdotti;
	}

	/**
	 * @param listaIdProdotti the listaIdProdotti to set
	 */
	public void setListaIdProdotti(List<Integer> listaIdProdotti) {
		this.listaIdProdotti = FXCollections.observableList(listaIdProdotti);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(key.get());
	}
}
