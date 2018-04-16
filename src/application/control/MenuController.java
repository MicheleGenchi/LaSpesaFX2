package application.control;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.db.DAONegozio;
import application.model.ModelListNegozio;
import application.model.ModelNegozio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuController {

    static MainController mainController;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem menuLogin;

    @FXML
    private MenuItem menuFine;

    @FXML
    private MenuItem menuAggiungiNegozio;

    @FXML
    private MenuItem menuVisualizzaNegozio;

    @FXML
    private MenuItem menuAggiungiProdotto;

    @FXML
    private MenuItem menuVisualizzaProdotto;

    @FXML
    private MenuItem menuInformazioni;

    @FXML
    void doAggiungiNegozio(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/UpdateNegozio.fxml"));

		Node viewAggiungiNegozio = null;
		try {
			viewAggiungiNegozio = loader.load();
			viewAggiungiNegozio.getStyleClass().add(getClass().getResource("../view/application.css").toExternalForm());
			mainController.getBorderPane().setCenter(viewAggiungiNegozio);
		} catch (IOException e) {
			System.err.println("viewAggiungiNegozio = (VBox) loader.load();");
			e.printStackTrace();
		}
    }

    @FXML
    void doAggiungiProdotto(ActionEvent event) {

    }

    @FXML
    void doChiudiProgramma(ActionEvent event) {

    }

    @FXML
    void doInformazioni(ActionEvent event) {

    }

    @FXML
    void doLogin(ActionEvent event) {

    }

    @FXML
    void doVisualizzaProdotto(ActionEvent event) {

    }

    @FXML
    void doVisuallizzaNegozio(ActionEvent event) {
    	/*
    	Class<ModelNegozio> negozio=ModelNegozio.class;
    	DAONegozio dao=new DAONegozio();
    	ModelListNegozio dati = ModelListNegozio.getInstance();
    	dao.leggi(dati);
    	TableView<ModelNegozio> controller=new TableView<>();
    	controller.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
    	controller.setStyle("pane");
    	//dati.setoListE(dati.getListE());
    	controller=new Table<ModelNegozio>().get(negozio, dati.getoListE());
    	mainController.getBorderPane().setCenter(controller);
    	*/
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/viewNegozi.fxml"));
    	try {
			TableView<ModelNegozio> table = loader.load();
			mainController.getBorderPane().setCenter(table);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    @FXML
    void initialize() {
        assert menuLogin != null : "fx:id=\"menuLogin\" was not injected: check your FXML file 'menu.fxml'.";
        assert menuFine != null : "fx:id=\"menuFine\" was not injected: check your FXML file 'menu.fxml'.";
        assert menuAggiungiNegozio != null : "fx:id=\"menuAggiungiNegozio\" was not injected: check your FXML file 'menu.fxml'.";
        assert menuVisualizzaNegozio != null : "fx:id=\"menuVisualizzaNegozio\" was not injected: check your FXML file 'menu.fxml'.";
        assert menuAggiungiProdotto != null : "fx:id=\"menuAggiungiProdotto\" was not injected: check your FXML file 'menu.fxml'.";
        assert menuVisualizzaProdotto != null : "fx:id=\"menuVisualizzaProdotto\" was not injected: check your FXML file 'menu.fxml'.";
        assert menuInformazioni != null : "fx:id=\"menuInformazioni\" was not injected: check your FXML file 'menu.fxml'.";
    }

	public static void injection(MainController mainController) {
		MenuController.mainController=mainController;
	}
}


