package application.control;

import java.net.URL;
import java.util.ResourceBundle;
import Utils.TIPOCONTENITORE;
import application.db.DAOProdotto;
import application.model.ModelProdotto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class UpdateProdottoController implements Initializable {
	@FXML
	private TextField idprodotto;
	@FXML
	private TextField nome;
	@FXML
	private TextField descrizione;
	@FXML
	private TextField marca;
	@FXML
	private ComboBox<TIPOCONTENITORE> contenitore;
	@FXML
	private TextField peso;
	@FXML
	private TextField quantita;
	@FXML
	private TextField prezzo;
	@FXML
	private ComboBox<Integer> negozio_idNegozio;

	@FXML
	private Button btnAggiungi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ModelProdotto model = new ModelProdotto();
		model.setIdprodotto(new DAOProdotto().lastRecord() + 1);
		idprodotto.textProperty().bindBidirectional(model.idprodottoProperty(),new NumberStringConverter());
		nome.textProperty().bindBidirectional(model.descrizioneProperty());
		marca.textProperty().bindBidirectional(model.marcaProperty());
		contenitore.setItems(FXCollections.observableArrayList(TIPOCONTENITORE.values()));
	}

}
