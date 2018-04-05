package application.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ModelListNegozio extends ListModel<SuperMercato>{

	public ModelListNegozio(List<SuperMercato> listE) {
		super(listE);
		// TODO Auto-generated constructor stub
	}
	
	public int cerca(String nomeNegozio) {
		Comparator<? super SuperMercato> c=new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				return ((SuperMercato) o1).getNome().compareToIgnoreCase(((SuperMercato) o1).getNome());
			} 
		};
		this.getListE().sort(c);
		
		return Collections.binarySearch(this.getListE(), new SuperMercato(0,nomeNegozio), c);
	}

}
