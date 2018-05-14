package application;

import application.db.DAONegozio;
import application.db.DAOProdotto;
import application.model.ModelListNegozio;
import application.model.ModelListProdotto;
import application.model.ModelProdotto;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.run();
	}

	private void run() {
		System.out.println("TABELLA NEGOZIO");
		ModelListNegozio lista = ModelListNegozio.getInstance();
		if (lista.caricaDB()) {

			lista.getListE().forEach(System.out::println);
		}

		System.out.println("TABELLA PRODOTTO");
		ModelListProdotto lista2 = ModelListProdotto.getInstance();
		if (lista2.caricaDB()) {
			lista2.getListE().forEach(System.out::print);

			int negozioDaCercare = 1;
			System.out.printf("\n\n\nCerca il negozio (id=%s)\t->\t", negozioDaCercare);
			String nomeNegozio = lista.cerca(negozioDaCercare);
			System.out.printf("nome = %2s\n", nomeNegozio);
			System.out.println("Prodotti venduti ");
			DAONegozio.getInstance().getIdProdotti(negozioDaCercare).forEach(e -> {
				ModelProdotto record = new ModelProdotto();
				DAOProdotto dao = DAOProdotto.getInstance();
				System.out.println((dao.cerca(e, record)
						? (String.format("%-10s\t%-10s\t%-5s", record.getMarca(), record.getNome(), record.getPrezzo()))
						: "non ci sono prodotti"));
			});
			DAONegozio.getInstance().chiudi();
			DAOProdotto.getInstance().chiudi();
		}
	}
}
