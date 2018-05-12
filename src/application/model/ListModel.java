package application.model;

import java.util.List;

import application.db.DAO;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ListModel<E>  {
	private List<E> listE; 
	private ObservableList<E> oListE;
	private BooleanProperty change=new SimpleBooleanProperty(false);
	private DAO<E> dao;
	
	public void clean() {
		listE.clear();
	}
	
	public boolean aggiungi(E e) {
		return listE.add(e);
	}
	
	public boolean delete(E e) {
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
		return FXCollections.observableList(listE);
	}

	public final BooleanProperty changeProperty() {
		return this.change;
	}

	public final boolean isChange() {
		return this.changeProperty().get();
	}

	public final void setChange(final boolean change) {
		this.changeProperty().set(change);
	}

	/**
	 * @return the dao
	 */
	public DAO<E> getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(DAO<E> dao) {
		this.dao = dao;
	}
	
	public boolean caricaDB() {
		clean();
		return dao.leggi(this)>0?true:false;
	}
	
	public boolean save() {
		if (dao.scrivi(this)>0) {
			setChange(false);
			return true;
		}
		return false;
	}

	/**
	 * @param listE the listE to set
	 */
	public void setListE(List<E> listE) {
		this.listE = listE;
	}

}
