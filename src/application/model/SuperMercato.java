package application.model;

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
	
	public void setFromModel(ModelSuperMercato supermercato) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (!(obj instanceof SuperMercato)) {
			return false;
		}
		SuperMercato other = (SuperMercato) obj;
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
