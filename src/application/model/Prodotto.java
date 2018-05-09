package application.model;

public class Prodotto {
	private int idprodotto;
	private String nome;
	private String descrizione;
	private String marca;
	private String contenitore;
	private String peso;
	private int quantita;
	private float prezzo;
	private int negozio_idNegozio; 
	private String nomeNegozio;

	public Prodotto() {
		this(0, "", "", "", "", "", 0, 0.0f);
	}

	public Prodotto(int idprodotto, String nome, String descrizione, String marca, String contenitore, 
			String peso, int quantita, float prezzo) {
		this.idprodotto = idprodotto;
		this.nome = nome;
		this.descrizione = descrizione;
		this.marca = marca;
		this.contenitore = contenitore;
		this.peso = peso;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}

	public Prodotto(ModelProdotto modelProdotto) {
		
		this(modelProdotto.getIdprodotto(), 
				modelProdotto.getNome(),
		modelProdotto.getDescrizione(),
		modelProdotto.getMarca(),
		modelProdotto.getContenitore(),
		modelProdotto.getPeso(),
		modelProdotto.getQuantita(),
		modelProdotto.getPrezzo()); 
	}

	
	public void setFromModel(ModelProdotto prodotto) {
		setIdprodotto(prodotto.getIdprodotto());
		setNome(prodotto.getNome());
		setDescrizione(prodotto.getDescrizione());
		setMarca(prodotto.getMarca());
		setContenitore(prodotto.getContenitore());
		setPeso(prodotto.getPeso());
		setQuantita(prodotto.getQuantita());
		setPrezzo(prodotto.getPrezzo());
	}
	
	/**
	 * @return the idprodotto
	 */
	public int getIdprodotto() {
		return idprodotto;
	}

	/**
	 * @param idprodotto
	 *            the idprodotto to set
	 */
	public void setIdprodotto(int idprodotto) {
		this.idprodotto = idprodotto;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione
	 *            the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca
	 *            the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the contenitore
	 */
	public String getContenitore() {
		return contenitore;
	}

	/**
	 * @param contenitore
	 *            the contenitore to set
	 */
	public void setContenitore(String contenitore) {
		this.contenitore = contenitore;
	}

	/**
	 * @return the peso
	 */
	public String getPeso() {
		return peso;
	}

	/**
	 * @param peso
	 *            the peso to set
	 */
	public void setPeso(String peso) {
		this.peso = peso;
	}

	/**
	 * @return the quantità
	 */
	public int getQuantita() {
		return quantita;
	}

	/**
	 * @param quantità
	 *            the quantità to set
	 */
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	/**
	 * @return the prezzo
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo
	 *            the prezzo to set
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return the negozio_idNegozio
	 */
	public int getNegozio_idNegozio() {
		return negozio_idNegozio;
	}

	/**
	 * @param negozio_idNegozio
	 *            the negozio_idNegozio to set
	 */
	public void setNegozio_idNegozio(int negozio_idNegozio) {
		this.negozio_idNegozio = negozio_idNegozio;
	}

	/**
	 * @return the nomeNegozio
	 */
	public String getNomeNegozio() {
		return nomeNegozio;
	}

	/**
	 * @param nomeNegozio the nomeNegozio to set
	 */
	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio = nomeNegozio;
	}

}
