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
		Test test=new Test();
		test.run();
	}

	private void run() {
		System.out.println("Tabella Supermercato");
		System.out.println("--------------------");
		ModelListNegozio lista=new ModelListNegozio(
				(List<SuperMercato>) getListaDAO(new DAOSupermercati()));
		lista.getListE().forEach(System.out::print);
		
		System.out.println("\nTabella Prodotto");
		System.out.println("----------------");
		ModelListProdotto lista2=new ModelListProdotto(
				(List<Prodotto>) getListaDAO(new DAOProdotto()));
		lista2.getListE().forEach(System.out::print);

	}

	private List<?> getListaDAO(DAO<?> dao) {
		int conta=dao.leggi();
		System.out.printf("%-3d%10s\n",conta,conta==1?" record letto":" records letti"); 
		List<?> lista=dao.getDati(); 
		return lista;
	}
}
