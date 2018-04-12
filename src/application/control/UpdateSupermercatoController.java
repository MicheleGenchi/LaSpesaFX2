package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import application.db.DAONegozio;
import application.model.ModelNegozio;
import application.model.Negozio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

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

    ModelNegozio model; 
    @FXML
    void doAggiungiSupermercato(ActionEvent event) {
    	Negozio superMercato=new Negozio();
    	superMercato.setFromModel(model);
    	MenuController.mainController.getListaNegozi().aggiungi(superMercato);
    	MenuController.mainController.getListaNegozi().setChange(true);
    }

    @FXML
    void initialize() {
        assert textNomeSupermercato != null : "fx:id=\"textNomeSupermercato\" was not injected: check your FXML file 'UpdateSuperMercato.fxml'.";
        assert btnAggiungiSupermercato != null : "fx:id=\"btnAggiungiSupermercato\" was not injected: check your FXML file 'UpdateSuperMercato.fxml'.";
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        model=new ModelNegozio();
        model.setKey(new DAONegozio().lastRecord()+1);
        textidNegozio.textProperty().bindBidirectional(model.keyProperty(),new NumberStringConverter());
        textNomeSupermercato.textProperty().bindBidirectional(model.nomeProperty());
	}
}

