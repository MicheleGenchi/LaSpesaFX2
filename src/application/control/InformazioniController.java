package application.control;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import application.model.ModelInformazioni;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InformazioniController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label programmatore;

    @FXML
    private Label versione;

    @FXML
    private Label tipoLicenza;

    @FXML
    private Label contratto;

    @FXML
    private Button btnConferma;
    
    private ModelInformazioni informazioni;
    
    @FXML
    void initialize() {
        assert programmatore != null : "fx:id=\"programmatore\" was not injected: check your FXML file 'viewInformazioni.fxml'.";
        assert versione != null : "fx:id=\"versione\" was not injected: check your FXML file 'viewInformazioni.fxml'.";
        assert tipoLicenza != null : "fx:id=\"tipoLicenza\" was not injected: check your FXML file 'viewInformazioni.fxml'.";
        assert contratto != null : "fx:id=\"contratto\" was not injected: check your FXML file 'viewInformazioni.fxml'.";
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ModelInformazioni model=new ModelInformazioni(Locale.getDefault(), "Bundle.informazioni");
		programmatore.setText(programmatore.getText().concat(" : ").concat(model.getProgrammatore()));
		versione.setText(versione.getText().concat(" : ").concat(model.getVersione()));
		tipoLicenza.setText(tipoLicenza.getText().concat(" : ").concat(model.getTipoLicenza()));
		contratto.setText(contratto.getText().concat(" :\n").concat(model.getContratto()));
	}
	
    @FXML
    void doConferma(ActionEvent event) {
    	MenuController.mainController.getBorderPane().setCenter(null);
    }
}