package application.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperMercato {
	private int key;
	private String nome;
	private List<Prodotto> listaProdotti;
	
	public SuperMercato(int key, String nome) {
		setKey(key);
		setNome(nome);
	}

	public SuperMercato() {
		this(0, "");
	}
	
	public SuperMercato(ModelSuperMercato supermercato) {
		this(supermercato.getKey(),supermercato.getNome());
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
	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	/**
	 * @param listaProdotti the listaProdotti to set
	 */
	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuperMercato [key=" + getKey() + ", nome=" + getNome() + "]"+"\n"+
				(getListaProdotti().size()==0?"Non ci sono prodotti in questo negozio":"I prodotti in questo negozio sono:\n"+ getListaProdotti())+"\n\n";
	}
}
