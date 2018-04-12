package application.model;

import java.util.ArrayList;

import application.db.DAOProdotto;

public class ModelListProdotto extends ListModel<Prodotto> {

	public ModelListProdotto() {
		listE=new ArrayList<>();
	}

	@Override
	public void save() {
		DAOProdotto dao=new DAOProdotto();
		dao.scrivi((ListModel<Prodotto>) this);
		setChange(false);
	}
}
