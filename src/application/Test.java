package application;



import java.util.ArrayList;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

import application.db.DAOProdotto;
import application.db.DAOSupermercati;
import application.model.Prodotto;
import application.model.SuperMercato;

public class Test {

	public static void main(String[] args) {
		DAOSupermercati dao=new DAOSupermercati();
		int conta=dao.leggi();
		System.out.printf("%-3d%10s\n",conta,conta==1?" record letto":" records letti"); 
		List<SuperMercato> lista=dao.getDati(); 
		
		lista.forEach(System.out::println);
		
		DAOProdotto dao2=new DAOProdotto();
		conta=dao2.leggi();
		System.out.printf("%-3d%10s\n",conta,conta==1?" record letto":"records letti");
		List<Prodotto> lista2=dao2.getDati();
		lista2.forEach(System.out::println);
	}

}
