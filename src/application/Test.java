package application;

import application.db.DAO;
import application.db.DAONegozio;
import application.db.DAOProdotto;
import application.model.ModelListNegozio;
import application.model.ModelListProdotto;
import application.model.Prodotto;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.run();
	}

	private void run() {
		DAONegozio dao=new DAONegozio();
		ModelListNegozio lista = ModelListNegozio.getInstance();
		dao.leggi(lista);
		System.out.println(dao);
		lista.getListE().forEach(System.out::print);

		DAOProdotto dao2=new DAOProdotto();
		ModelListProdotto lista2 =  ModelListProdotto.getInstance();
		dao2.leggi(lista2);
		System.out.println(dao2);
		lista2.getListE().forEach(System.out::print);
		
		String negozioDaCercare="Auchan";
		System.out.printf("\n\n\nCerca il negozio (%3s)\t->\t",negozioDaCercare);
		int idNegozio=lista.cerca(negozioDaCercare);
		System.out.printf("key = %2s\n",idNegozio);
		System.out.println("Prodotti venduti ");
		dao.getIdProdotti(idNegozio).forEach(e -> {
			Prodotto record=new Prodotto();
			System.out.println((dao2.cerca(e, record)?	
				(String.format("%-10s\t%-10s\t%-5s",record.getMarca(),record.getNome(),record.getPrezzo())):
				"non ci sono prodotti"));
		});
		
		dao.chiudi();
		dao2.chiudi();
		
	}
}
