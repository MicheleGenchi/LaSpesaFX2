package application.model;

import application.db.DAOProdotto;

public class ModelListProdotto extends ListModel<Prodotto> {

	public ModelListProdotto() {

	}

	@Override
	public void save() {
		DAOProdotto dao=new DAOProdotto();
		dao.scrivi((ListModel<Prodotto>) this);
		setChange(false);
	}
}
