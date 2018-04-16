package application.model;

import java.util.ArrayList;

import application.db.DAOProdotto;

public class ModelListProdotto extends ListModel<ModelProdotto> {
	private static ModelListProdotto instance;
	
	private ModelListProdotto() {
		listE=new ArrayList<>();
	}
	
	public static ModelListProdotto getInstance() {
		if (instance == null) {
			// Thread Safe. Might be costly operation in some case
			synchronized (ModelListProdotto.class) {
				if (instance == null) {
					instance = new ModelListProdotto();
				}
			}
		}
		return instance;
	}

	@Override
	public void save() {
		DAOProdotto dao=new DAOProdotto();
		dao.scrivi(this);
		setChange(false);
	}
}
