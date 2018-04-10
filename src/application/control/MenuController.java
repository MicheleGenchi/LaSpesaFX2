package application.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;

public class MenuController {

    private static MainController mainController;

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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/UpdateSuperMercato.fxml"));

		Node viewAggiungiSupermercato = null;
		try {
			viewAggiungiSupermercato = loader.load();
			viewAggiungiSupermercato.getStyleClass().add(getClass().getResource("../view/application.css").toExternalForm());
			mainController.getBorderPane().setCenter(viewAggiungiSupermercato);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("viewAggiungiSupermercato = (VBox) loader.load();");
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
		// TODO Auto-generated method stub
		MenuController.mainController=mainController;
	}
}


