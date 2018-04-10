package application;

import java.util.List;

import application.db.DAO;
import application.db.DAOProdotto;
import application.db.DAOSupermercati;
import application.model.ModelListNegozio;
import application.model.ModelListProdotto;
import application.model.Prodotto;
import application.model.SuperMercato;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.run();
	}

	private void run() {
		DAOSupermercati dao=new DAOSupermercati();
		ModelListNegozio lista = new ModelListNegozio((List<SuperMercato>) getListaDAO(dao));
		lista.getListE().forEach(System.out::print);

		ModelListProdotto lista2 = new ModelListProdotto((List<Prodotto>) getListaDAO(new DAOProdotto()));
		lista2.getListE().forEach(System.out::print);
		
		String negozioDaCercare="Auchan";
		System.out.printf("\n\n\nCerca il negozio (%3s)\t->\t",negozioDaCercare);
		int idNegozio=lista.cerca(negozioDaCercare);
		System.out.printf("key = %2s\n",idNegozio);
		dao.getProdotti(idNegozio).forEach(System.out::print);
		DAO.chiudi();
	}

	private List<?> getListaDAO(DAO<?> dao) {
		int conta = dao.leggi();
		System.out.printf(dao + "\n%-3d%10s\n", conta, conta == 1 ? " record letto" : " records letti");
		List<?> lista = dao.getDati();
		return lista;
	}
}
