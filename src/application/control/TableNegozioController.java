package application.control;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.model.ModelListNegozio;
import application.model.ModelNegozio;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableNegozioController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ModelNegozio> tableNegozio;

    @FXML
    private TableColumn<ModelNegozio, Integer> colidNegozio;

    @FXML
    private TableColumn<ModelNegozio, String> colNome;

    @FXML
    private TableColumn<ModelNegozio, List<Integer>> colIdProdotto;
    
    @FXML
    void initialize() {
        assert tableNegozio != null : "fx:id=\"tableNegozio\" was not injected: check your FXML file 'viewNegozi.fxml'.";
        assert colidNegozio != null : "fx:id=\"colidNegozio\" was not injected: check your FXML file 'viewNegozi.fxml'.";
        assert colNome != null : "fx:id=\"colNome\" was not injected: check your FXML file 'viewNegozi.fxml'.";
        assert colIdProdotto != null : "fx:id=\"colIdProdotto\" was not injected: check your FXML file 'viewNegozi.fxml'.";
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colidNegozio.setCellValueFactory(new PropertyValueFactory<>("key"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colIdProdotto.setCellValueFactory(new PropertyValueFactory<>("listaIdProdotti"));
	 	ModelListNegozio dati = ModelListNegozio.getInstance();
    	tableNegozio.setItems(dati.getoListE());
	}

	/**
	 * @return the tableNegozio
	 */
	public TableView<ModelNegozio> getTableNegozio() {
		return tableNegozio;
	}
}

