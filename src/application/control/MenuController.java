package application.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

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
			System.err.println("viewAggiungiNegozio = loader.load();");
			e.printStackTrace();
		}
    }

    @FXML
    void doAggiungiProdotto(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/UpdateProdotto.fxml"));

		Node viewAggiungiProdotto = null;
		try {
			viewAggiungiProdotto = loader.load();
			viewAggiungiProdotto.getStyleClass().add(getClass().getResource("../view/application.css").toExternalForm());
			mainController.getBorderPane().setCenter(viewAggiungiProdotto);
		} catch (IOException e) {
			System.err.println("viewAggiungiProdotto = loader.load();");
			e.printStackTrace();
		}
    }

    @FXML
    void doChiudiProgramma(ActionEvent event) {

    }

    @FXML
    void doInformazioni(ActionEvent event) {

    }

    @FXML
    void doLogin(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Login.fxml"));

		Node viewLogin = null;
		try {
			viewLogin = loader.load();
			viewLogin.getStyleClass().add(getClass().getResource("../view/application.css").toExternalForm());
			mainController.getBorderPane().setCenter(viewLogin);
		} catch (IOException e) {
			System.err.println("viewLogin = loader.load();");
			e.printStackTrace();
		}
    }

    @FXML
    void doVisualizzaProdotto(ActionEvent event) {
       	FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/viewProdotti.fxml"));
    	try {
			AnchorPane a = (AnchorPane) loader.load();
			mainController.getBorderPane().setCenter(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
			AnchorPane a = (AnchorPane) loader.load();
			mainController.getBorderPane().setCenter(a);
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


