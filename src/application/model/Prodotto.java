package application.model;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prodotto {
	private IntegerProperty idprodotto=new SimpleIntegerProperty();
	private StringProperty nome=new SimpleStringProperty();
	private StringProperty descrizione=new SimpleStringProperty();
	private StringProperty contenitore=new SimpleStringProperty();
	private IntegerProperty peso=new SimpleIntegerProperty();
	private IntegerProperty quantit‡=new SimpleIntegerProperty();
	private FloatProperty prezzo=new SimpleFloatProperty();
	private IntegerProperty negozio_idNegozio=new SimpleIntegerProperty();
	private StringProperty nomeSuperMercato=new SimpleStringProperty();
	
	
	public Prodotto(int idprodotto, String nome, String descrizione,
			String contenitore, int peso, int quantit‡, float prezzo,
			int negozio_idNegozio) {
		setIdprodotto(idprodotto);
		setNome(nome);
		setDescrizione(descrizione);
		setContenitore(contenitore);
		setPeso(peso);
		setQuantit‡(quantit‡);
		setPrezzo(prezzo);
		setNegozio_idNegozio(negozio_idNegozio);
	}


	public final IntegerProperty idprodottoProperty() {
		return this.idprodotto;
	}
	


	public final int getIdprodotto() {
		return this.idprodottoProperty().get();
	}
	


	public final void setIdprodotto(final int idprodotto) {
		this.idprodottoProperty().set(idprodotto);
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
	


	public final StringProperty descrizioneProperty() {
		return this.descrizione;
	}
	


	public final String getDescrizione() {
		return this.descrizioneProperty().get();
	}
	


	public final void setDescrizione(final String descrizione) {
		this.descrizioneProperty().set(descrizione);
	}
	


	public final StringProperty contenitoreProperty() {
		return this.contenitore;
	}
	


	public final String getContenitore() {
		return this.contenitoreProperty().get();
	}
	


	public final void setContenitore(final String contenitore) {
		this.contenitoreProperty().set(contenitore);
	}
	


	public final IntegerProperty pesoProperty() {
		return this.peso;
	}
	


	public final int getPeso() {
		return this.pesoProperty().get();
	}
	


	public final void setPeso(final int peso) {
		this.pesoProperty().set(peso);
	}
	


	public final IntegerProperty quantit‡Property() {
		return this.quantit‡;
	}
	


	public final int getQuantit‡() {
		return this.quantit‡Property().get();
	}
	


	public final void setQuantit‡(final int quantit‡) {
		this.quantit‡Property().set(quantit‡);
	}
	


	public final FloatProperty prezzoProperty() {
		return this.prezzo;
	}
	


	public final float getPrezzo() {
		return this.prezzoProperty().get();
	}
	


	public final void setPrezzo(final float prezzo) {
		this.prezzoProperty().set(prezzo);
	}


	public final IntegerProperty negozio_idNegozioProperty() {
		return this.negozio_idNegozio;
	}
	


	public final int getNegozio_idNegozio() {
		return this.negozio_idNegozioProperty().get();
	}
	


	public final void setNegozio_idNegozio(final int negozio_idNegozio) {
		this.negozio_idNegozioProperty().set(negozio_idNegozio);
	}


	public final StringProperty nomeSuperMercatoProperty() {
		return this.nomeSuperMercato;
	}
	


	public final String getNomeSuperMercato() {
		return this.nomeSuperMercatoProperty().get();
	}
	


	public final void setNomeSuperMercato(final String nomeSuperMercato) {
		this.nomeSuperMercatoProperty().set(nomeSuperMercato);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prodotto [idprodotto=" + getIdprodotto() + ", nome=" + getNome() + ", descrizione=" + getDescrizione()
				+ ", contenitore=" + getContenitore() + ", peso=" + getPeso() + ", quantit‡=" + getQuantit‡() + ", prezzo=" + getPrezzo()
				+ ", negozio_idNegozio=" + getNegozio_idNegozio() + ", nomeSuperMercato=" + getNomeSuperMercato() + "]";
	}
	
}


