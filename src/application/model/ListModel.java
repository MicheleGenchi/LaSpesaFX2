package application.model;

import java.util.ArrayList;
import java.util.List;
import application.db.DAOProdotto;
import application.db.DAOSupermercati;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ListModel<E>  {
	private E obj;
	protected List<E> listE; 
	protected ObservableList<E> oListE;
	protected boolean change;
	
	public ListModel() {
		listE=new ArrayList<>();
	}
	
	public boolean aggiungi(E e) {
		change=true;
		return listE.add(e);
	}
	
	public boolean delete(E e) {
		change=true;
		return listE.remove(e);
	}
	
	/**
	 * @return the listaNegozi
	 */
	public List<E> getListE() {
		return listE;
	}

	/**
	 * @param listaNegozi the listaNegozi to set
	 */
	public void setoListE(List<E> listE) {
		this.oListE = FXCollections.observableList(listE);
	}

	public ObservableList<E> getoListE() {
		return oListE;
	}

	protected void save() {
		if (obj instanceof DAOSupermercati) {
			DAOSupermercati dao=new DAOSupermercati();
			dao.scrivi((ListModel<SuperMercato>) this);
		}
		if (obj instanceof DAOProdotto) {
			DAOProdotto dao=new DAOProdotto();
			dao.scrivi((ListModel<Prodotto>) this);
		}
		change=false;
	}
	
	public boolean isChange() {
		return change;
	}

	public void setChange(boolean change) {
		this.change = change;
	}
}
