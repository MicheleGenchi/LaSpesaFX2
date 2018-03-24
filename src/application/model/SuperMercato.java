package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SuperMercato {
	private IntegerProperty key=new SimpleIntegerProperty();
	private StringProperty nome=new SimpleStringProperty();
	
	public SuperMercato(int key, String nome) {
		setKey(key);
		setNome(nome);
	}

	public SuperMercato() {
		// TODO Auto-generated constructor stub
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
}
