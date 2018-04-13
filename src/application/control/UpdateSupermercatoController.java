package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import application.db.DAONegozio;
import application.model.ModelNegozio;
import application.model.Negozio;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private TextField textNomeNegozio;

    @FXML
    private Button btnAggiungiNegozio;

    ModelNegozio model; 
    @FXML
    void doAggiungiNegozio(ActionEvent event) {
    	Negozio superMercato=new Negozio();
    	superMercato.setFromModel(model);
    	MenuController.mainController.getListaNegozi().clean();
    	MenuController.mainController.getListaNegozi().aggiungi(superMercato);
    	MenuController.mainController.getListaNegozi().setChange(true);
    }

    @FXML
    void initialize() {
        assert textNomeNegozio != null : "fx:id=\"textNomeNegozio\" was not injected: check your FXML file 'UpdateSuperMercato.fxml'.";
        assert btnAggiungiNegozio != null : "fx:id=\"btnAggiungiNegozio\" was not injected: check your FXML file 'UpdateSuperMercato.fxml'.";
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        model=new ModelNegozio();
        model.setKey(new DAONegozio().lastRecord()+1);
        textidNegozio.textProperty().bindBidirectional(model.keyProperty(),new NumberStringConverter());
        textNomeNegozio.textProperty().bindBidirectional(model.nomeProperty());
        btnAggiungiNegozio.setDisable(true);
        textNomeNegozio.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                //System.out.println(t+"====="+t1);
               if(t1.equals(""))
            	   btnAggiungiNegozio.setDisable(true);
               else
            	   btnAggiungiNegozio.setDisable(false);
            }
        });

	}
}

