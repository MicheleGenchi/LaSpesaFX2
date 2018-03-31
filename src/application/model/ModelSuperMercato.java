package application.model;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelSuperMercato {
	private IntegerProperty key=new SimpleIntegerProperty();
	private StringProperty nome=new SimpleStringProperty();
	private ObservableList<Prodotto> listaProdotti=FXCollections.observableArrayList();
	
	public ModelSuperMercato(int key, String nome) {
		setKey(key);
		setNome(nome);
	}

	public ModelSuperMercato(SuperMercato superMercato) {
		this(superMercato.getKey(),superMercato.getNome());
	}
	
	public ModelSuperMercato() {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuperMercato [key=" + getKey() + ", nome=" + getNome() + "]";
	}

	public ObservableList<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = FXCollections.observableArrayList(listaProdotti);
	}
}
