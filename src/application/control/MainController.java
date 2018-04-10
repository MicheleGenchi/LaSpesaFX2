package application.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    @FXML
    void initialize() {
        assert borderPane != null : "fx:id=\"borderPane\" was not injected: check your FXML file 'Main.fxml'.";
        assert mnuLogin != null : "fx:id=\"mnuLogin\" was not injected: check your FXML file 'Main.fxml'.";
        assert mnuChiudi != null : "fx:id=\"mnuChiudi\" was not injected: check your FXML file 'Main.fxml'.";
        assert mnuInformazioni != null : "fx:id=\"mnuInformazioni\" was not injected: check your FXML file 'Main.fxml'.";
        MenuController.injection(this);
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

