package application.model;

import java.util.List;

public class SuperMercato {
	private int key;
	private String nome;
	private List<Prodotto> prodotti;

	public SuperMercato(int key, String nome) {
		setKey(key);
		setNome(nome);
	}

	public SuperMercato() {
		this(0, "");
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(int key) {
		this.key = key;
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
	 * @return the prodotti
	 */
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	/**
	 * @param prodotti the prodotti to set
	 */
	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuperMercato [key=" + getKey() + ", nome=" + getNome() + "]"+ " prodotti =" + getProdotti();
	}
}
