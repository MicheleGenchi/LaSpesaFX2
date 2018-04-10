package application.model;

public class Prodotto {
	private int idprodotto;
	private String nome;
	private String descrizione;
	private String marca;
	private String contenitore;
	private int peso;
	private int quantit�;
	private float prezzo;
	private int negozio_idNegozio; 
	private String nomeSuperMercato;

	public Prodotto() {
		this(0, "", "", "", "", 0, 0, 0.0f,0,"");
	}

	public Prodotto(int idprodotto, String nome, String descrizione, String marca, String contenitore, 
			int peso, int quantit�, float prezzo, int negozio_idNegozio, String nomeSuperMercato) {
		this.idprodotto = idprodotto;
		this.nome = nome;
		this.descrizione = descrizione;
		this.marca = marca;
		this.contenitore = contenitore;
		this.peso = peso;
		this.quantit� = quantit�;
		this.prezzo = prezzo;
	    this.negozio_idNegozio = negozio_idNegozio; 
	    this.nomeSuperMercato = nomeSuperMercato;
	}

	public Prodotto(ModelProdotto modelProdotto) {
		
		this(modelProdotto.getIdprodotto(), 
				modelProdotto.getNome(),
		modelProdotto.getDescrizione(),
		modelProdotto.getMarca(),
		modelProdotto.getContenitore(),
		modelProdotto.getPeso(),
		modelProdotto.getQuantit�(),
		modelProdotto.getPrezzo(),
		modelProdotto.getNegozio_idNegozio(),
		modelProdotto.getNomeSuperMercato()); 
	}

	
	public void setFromModel(ModelProdotto prodotto) {
		setIdprodotto(prodotto.getIdprodotto());
		setNome(prodotto.getNome());
		setDescrizione(prodotto.getDescrizione());
		setMarca(prodotto.getMarca());
		setContenitore(prodotto.getContenitore());
		setPeso(prodotto.getPeso());
		setQuantit�(prodotto.getQuantit�());
		setPrezzo(prodotto.getPrezzo());
	    setNegozio_idNegozio(prodotto.getNegozio_idNegozio());
	    setNomeSuperMercato(prodotto.getNomeSuperMercato());
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
	public int getPeso() {
		return peso;
	}

	/**
	 * @param peso
	 *            the peso to set
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

	/**
	 * @return the quantit�
	 */
	public int getQuantit�() {
		return quantit�;
	}

	/**
	 * @param quantit�
	 *            the quantit� to set
	 */
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
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
	 * @return the nomeSuperMercato
	 */
	public String getNomeSuperMercato() {
		return nomeSuperMercato;
	}

	/**
	 * @param nomeSuperMercato
	 *            the nomeSuperMercato to set
	 */
	public void setNomeSuperMercato(String nomeSuperMercato) {
		this.nomeSuperMercato = nomeSuperMercato;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prodotto [idprodotto=" + idprodotto + ", nome=" + nome + ", descrizione=" + descrizione + ", marca="
				+ marca + ", contenitore=" + contenitore + ", peso=" + peso + ", quantit�=" + quantit� + ", prezzo="
				+ prezzo + ",\n negozio_idNegozio=" + negozio_idNegozio + ", nomeSuperMercato=" + nomeSuperMercato + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Prodotto)) {
			return false;
		}
		Prodotto other = (Prodotto) obj;
		if (marca == null) {
			if (other.marca != null) {
				return false;
			}
		} else if (!marca.equals(other.marca)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

}
