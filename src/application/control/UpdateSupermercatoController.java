package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.ModelSuperMercato;
import application.model.SuperMercato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdateSupermercatoController implements Initializable {
	
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private TextField textidNegozio;

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
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        model=new ModelSuperMercato();
        textidNegozio.textProperty().bind(model.keyProperty().asString());
        textNomeSupermercato.textProperty().bindBidirectional(model.nomeProperty());
	}
}

