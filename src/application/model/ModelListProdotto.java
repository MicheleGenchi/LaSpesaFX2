package application.model;

import java.util.ArrayList;

import application.db.DAOProdotto;

public final class ModelListProdotto extends ListModel<ModelProdotto> {
	private static ModelListProdotto instance;

	private ModelListProdotto() {
		setListE(new ArrayList<>());
		setDao(DAOProdotto.getInstance());
	}

	public static ModelListProdotto getInstance() {
		if (instance == null) {
			synchronized (ModelListProdotto.class) {
				if (instance == null)
					instance=new ModelListProdotto();
			}
		}
		return instance;
	}
}
