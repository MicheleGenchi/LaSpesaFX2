package application.control;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.db.DAO;
import application.db.DAOProdotto;
import application.db.DAOSupermercati;
import application.model.ModelListNegozio;
import application.model.ModelListProdotto;
import application.model.SuperMercato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane borderPane;

    @FXML
    private MenuItem mnuLogin;

    @FXML
    private MenuItem mnuChiudi;

    @FXML
    private MenuItem mnuInformazioni;

    @FXML
    void doMnuChiudi(ActionEvent event) {

    }

    @FXML
    void doMnuInformazioni(ActionEvent event) {

    }

    @FXML
    void doMnuLogin(ActionEvent event) {

    }

    ModelListNegozio listaNegozi;
    ModelListProdotto listaProdotti;
    
    @FXML
    void initialize() {
        assert borderPane != null : "fx:id=\"borderPane\" was not injected: check your FXML file 'Main.fxml'.";
        assert mnuLogin != null : "fx:id=\"mnuLogin\" was not injected: check your FXML file 'Main.fxml'.";
        assert mnuChiudi != null : "fx:id=\"mnuChiudi\" was not injected: check your FXML file 'Main.fxml'.";
        assert mnuInformazioni != null : "fx:id=\"mnuInformazioni\" was not injected: check your FXML file 'Main.fxml'.";
        MenuController.injection(this);
        
        DAOSupermercati dao1=new DAOSupermercati();
        listaNegozi=new ModelListNegozio();
        dao1.leggi(listaNegozi);
        DAOProdotto dao2=new DAOProdotto();
        listaProdotti=new ModelListProdotto();
        dao2.leggi(listaProdotti);
    }

	/**
	 * @return the borderPane
	 */
	public BorderPane getBorderPane() {
		return borderPane;
	}

	/**
	 * @param borderPane the borderPane to set
	 */
	public void setBorderPane(BorderPane borderPane) {
		this.borderPane = borderPane;
	}
	
}

