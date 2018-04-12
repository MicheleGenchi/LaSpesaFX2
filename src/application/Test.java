package application;

import application.db.DAO;
import application.db.DAONegozio;
import application.db.DAOProdotto;
import application.model.ModelListNegozio;
import application.model.ModelListProdotto;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.run();
	}

	private void run() {
		DAONegozio dao=new DAONegozio();
		ModelListNegozio lista = new ModelListNegozio();
		dao.leggi(lista);
		System.out.println(dao);
		lista.getListE().forEach(System.out::print);

		DAOProdotto dao2=new DAOProdotto();
		ModelListProdotto lista2 = new ModelListProdotto();
		dao2.leggi(lista2);
		System.out.println(dao2);
		lista2.getListE().forEach(System.out::print);
		
		String negozioDaCercare="Auchan";
		System.out.printf("\n\n\nCerca il negozio (%3s)\t->\t",negozioDaCercare);
		int idNegozio=lista.cerca(negozioDaCercare);
		System.out.printf("key = %2s\n",idNegozio);
		dao.getProdotti(idNegozio).forEach(System.out::print);
		DAO.chiudi();
		
	}
}
