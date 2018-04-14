package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelNegozio  {
	private IntegerProperty key=new SimpleIntegerProperty();
	private StringProperty nome=new SimpleStringProperty();
	
	public ModelNegozio(int key, String nome) {
		setKey(key);
		setNome(nome);
	}

	public ModelNegozio(Negozio superMercato) {
		this(superMercato.getKey(),superMercato.getNome());
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

}
