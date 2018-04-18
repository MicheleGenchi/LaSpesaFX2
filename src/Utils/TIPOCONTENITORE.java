package Utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public enum TIPOCONTENITORE {
	busta("busta"), bottiglia("bottiglia"), pacco("pacco"), confezione("confezione"), brik("brik");

	private StringProperty nome=new SimpleStringProperty();

	private TIPOCONTENITORE(String nome) {
		this.setNome(nome);
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
