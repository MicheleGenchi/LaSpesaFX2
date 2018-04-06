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
		Comparator<? super SuperMercato> c=new Comparator<SuperMercato>() {

			@Override
			public int compare(SuperMercato o1, SuperMercato o2) {
				return ((SuperMercato) o1).getNome().compareToIgnoreCase(((SuperMercato) o1).getNome());
			} 
		};
		this.getListE().sort(c);
		
		return Collections.binarySearch(this.getListE(), new SuperMercato(1000, nomeNegozio), c);
	}

}
