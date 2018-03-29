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
import javafx.scene.layout.VBox;

public class MenuController extends MainController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private MenuItem diAggiungiSupermercato;

	@FXML
	void doAggiungiSupermercato(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/UpdateSuperMercato.fxml"));

		Node viewAggiungiSupermercato = null;
		try {
			viewAggiungiSupermercato = loader.load();
			// viewAggiungiSupermercato.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			System.out.println(super.toString());
			super.getBorderPane().setCenter(viewAggiungiSupermercato);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("viewAggiungiSupermercato = (VBox) loader.load();");
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		assert diAggiungiSupermercato != null : "fx:id=\"diAggiungiSupermercato\" was not injected: check your FXML file 'menu.fxml'.";

	}
}
