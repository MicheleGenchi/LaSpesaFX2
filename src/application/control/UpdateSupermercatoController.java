package application.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdateSupermercatoController extends MainController {
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textNomeSupermercato;

    @FXML
    private Button btnAggiungiSupermercato;

    @FXML
    void doAggiungiSupermercato(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
        assert textNomeSupermercato != null : "fx:id=\"textNomeSupermercato\" was not injected: check your FXML file 'UpdateSuperMercato.fxml'.";
        assert btnAggiungiSupermercato != null : "fx:id=\"btnAggiungiSupermercato\" was not injected: check your FXML file 'UpdateSuperMercato.fxml'.";

    }
}
