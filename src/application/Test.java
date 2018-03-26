package application;



import java.util.List;

import application.db.DAOProdotto;
import application.db.DAOSupermercati;
import application.model.Prodotto;
import application.model.SuperMercato;

public class Test {

	public static void main(String[] args) {
		DAOSupermercati dao=new DAOSupermercati();
		System.out.println(dao.leggi()+"\trecord "+(dao.leggi()==1?"letto":"letti")); 
		List<SuperMercato> lista=dao.getDati(); 
		lista.forEach(System.out::println);
		
		DAOProdotto dao2=new DAOProdotto();
		System.out.println(dao2.leggi()+"\trecord"+(dao.leggi()==1?"letto":"letti"));
		List<Prodotto> lista2=dao2.getDati();
		lista2.forEach(System.out::println);
	}

}
