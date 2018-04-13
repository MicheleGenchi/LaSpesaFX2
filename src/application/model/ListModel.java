package application.model;

import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ListModel<E>  {
	protected List<E> listE; 
	protected ObservableList<E> oListE;
	protected BooleanProperty change=new SimpleBooleanProperty(false);
	
	public ListModel() {

	}
	
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
		return oListE;
	}

	protected abstract void save();
	
	public final BooleanProperty changeProperty() {
		return this.change;
	}

	public final boolean isChange() {
		return this.changeProperty().get();
	}

	public final void setChange(final boolean change) {
		this.changeProperty().set(change);
	}
}
