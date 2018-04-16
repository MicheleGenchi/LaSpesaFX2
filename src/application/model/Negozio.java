package application.model;

import java.util.List;

public class Negozio {
	private int key;
	private String nome;
	private List<Integer> listaIdProdotti;
	
	public Negozio(int key, String nome) {
		setKey(key);
		setNome(nome);
	}

	public Negozio() {
		this(0, "");
	}
	
	public void setFromModel(ModelNegozio supermercato) {
		setKey(supermercato.getKey());
		setNome(supermercato.getNome());
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
	 * @return the listaProdotti
	 */
	public List<Integer> getListaIdProdotti() {
		return listaIdProdotti;
	}

	/**
	 * @param listaProdotti the listaProdotti to set
	 */
	public void setListaIdProdotti(List<Integer> listaIdProdotti) {
		this.listaIdProdotti = listaIdProdotti;
	}
}
