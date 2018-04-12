package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.ModelSuperMercato;
import application.model.SuperMercato;
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

    ModelSuperMercato model;
    
    @FXML
    void doAggiungiSupermercato(ActionEvent event) {
    	SuperMercato superMercato=new SuperMercato();
    	superMercato.setFromModel(model);
    	MenuController.mainController.getListaNegozi().aggiungi(superMercato);
    }

    @FXML
    void initialize() {
        assert textNomeSupermercato != null : "fx:id=\"textNomeSupermercato\" was not injected: check your FXML file 'UpdateSuperMercato.fxml'.";
        assert btnAggiungiSupermercato != null : "fx:id=\"btnAggiungiSupermercato\" was not injected: check your FXML file 'UpdateSuperMercato.fxml'.";
        model=new ModelSuperMercato();
        textNomeSupermercato.textProperty().bind(model.nomeProperty());
    }
}

