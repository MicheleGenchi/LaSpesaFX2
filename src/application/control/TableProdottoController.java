package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.ModelListNegozio;
import application.model.ModelListProdotto;
import application.model.ModelNegozio;
import application.model.ModelProdotto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableProdottoController implements Initializable {
	
	private ModelListProdotto listaProdotti=ModelListProdotto.getInstance();
	private ModelListNegozio listaNegozi=ModelListNegozio.getInstance();
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TableView<ModelProdotto> tableProdotto;
	@FXML
	private TableColumn<ModelProdotto, Integer> idprodotto;
	@FXML
	private TableColumn<ModelProdotto, String> nome;
	@FXML
	private TableColumn<ModelProdotto, String> descrizione;
	@FXML
	private TableColumn<ModelProdotto, String> marca;
	@FXML
	private TableColumn<ModelProdotto, String> contenitore;
	@FXML
	private TableColumn<ModelProdotto, String> peso;
	@FXML
	private TableColumn<ModelProdotto, Integer> quantita;
	@FXML
	private TableColumn<ModelProdotto, Float> prezzo;
	@FXML
	private TableColumn<ModelNegozio, Integer> idNegozio;
	@FXML
	private TableColumn<ModelNegozio, String> nomeNegozio;
	
	
	@FXML
	void initialize() {
		assert idprodotto != null : "fx:id=\"idprodotto\" was not injected: check your FXML file 'viewProdotti.fxml'.";
		assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'viewProdotti.fxml'.";
		assert descrizione != null : "fx:id=\"descrizione\" was not injected: check your FXML file 'viewProdotti.fxml'.";
		assert marca != null : "fx:id=\"marca\" was not injected: check your FXML file 'viewProdotti.fxml'.";
		assert contenitore != null : "fx:id=\"contenitore\" was not injected: check your FXML file 'viewProdotti.fxml'.";
		assert peso != null : "fx:id=\"peso\" was not injected: check your FXML file 'viewProdotti.fxml'.";
		assert quantita != null : "fx:id=\"quantita\" was not injected: check your FXML file 'viewProdotti.fxml'.";
		assert prezzo != null : "fx:id=\"prezzo\" was not injected: check your FXML file 'viewProdotti.fxml'.";
		assert idNegozio != null : "fx:id=\"idNegozio\" was not injected: check your FXML file 'viewProdotti.fxml'.";
		assert nomeNegozio != null : "fx:id=\"nomeNegozio\" was not injected: check your FXML file 'viewProdotti.fxml'.";
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listaNegozi.caricaDB();
		listaProdotti.caricaDB();
		idprodotto.setCellValueFactory(new PropertyValueFactory<>("idprodotto"));
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		descrizione.setCellValueFactory(new PropertyValueFactory<>("nome"));
		marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		contenitore.setCellValueFactory(new PropertyValueFactory<>("contenitore"));
		peso.setCellValueFactory(new PropertyValueFactory<>("peso"));
		quantita.setCellValueFactory(new PropertyValueFactory<>("quantita"));
		prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
		idNegozio.setCellValueFactory(new PropertyValueFactory<>("negozio_idNegozio"));
		nomeNegozio.setCellValueFactory(new PropertyValueFactory<>("nomeNegozio"));
		tableProdotto.setItems(listaProdotti.getoListE());
	}

	/**
	 * @return the tableNegozio
	 */
	public TableView<ModelProdotto> getTableProdotto() {
		return tableProdotto;
	}
}
