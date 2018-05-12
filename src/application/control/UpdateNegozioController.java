package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.ModelListNegozio;
import application.model.ModelNegozio;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class UpdateNegozioController implements Initializable {
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

	private ModelNegozio model;
	private ModelListNegozio listaNegozi= ModelListNegozio.getInstance();

	@FXML
	void doAggiungiNegozio(ActionEvent event) {
		listaNegozi.clean();
		boolean success=listaNegozi.aggiungi(model);
		if (success) {
			btnAggiungiNegozio.setDisable(true);
			listaNegozi.setChange(true);
		}
	}

	@FXML
	void initialize() {
		assert textNomeNegozio != null : "fx:id=\"textNomeNegozio\" was not injected: check your FXML file 'UpdateSuperMercato.fxml'.";
		assert btnAggiungiNegozio != null : "fx:id=\"btnAggiungiNegozio\" was not injected: check your FXML file 'UpdateSuperMercato.fxml'.";
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new ModelNegozio();
		listaNegozi.caricaDB();
		listaNegozi.setChange(false);
		model.setKey(listaNegozi.getListE().size() + 1);
		textidNegozio.textProperty().bindBidirectional(model.keyProperty(), new NumberStringConverter());
		textNomeNegozio.textProperty().bindBidirectional(model.nomeProperty());
		btnAggiungiNegozio.setDisable(true);
		textNomeNegozio.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> ov, String t, String t1) {
				// System.out.println(t+"====="+t1);
				if (t1.equals(""))
					btnAggiungiNegozio.setDisable(true);
				else
					btnAggiungiNegozio.setDisable(false);
			}
		});

	}
}
