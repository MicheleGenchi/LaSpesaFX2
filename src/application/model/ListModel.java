package application.model;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListModel<E>  {

	private List<E> listE; 
	private ObservableList<E> oListE;
	
	public ListModel(List<E> listE) {
		this.listE=listE;
		setoListE(listE);
	}
	
	public boolean aggiungiNegozio(E negozio) {
		return listE.add(negozio);
	}
	
	public boolean deleteNegozio(E negozio) {
		return listE.remove(negozio);
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
}
