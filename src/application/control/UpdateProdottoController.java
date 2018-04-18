package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import Utils.TIPOCONTENITORE;
import application.db.DAONegozio;
import application.db.DAOProdotto;
import application.model.ModelListNegozio;
import application.model.ModelNegozio;
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
	private ComboBox<ModelNegozio> negozio_idNegozio;

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
		populateNegozio_idNegozio(negozio_idNegozio);
	}
	
	public void populateNegozio_idNegozio(ComboBox<ModelNegozio> combo) {
		DAONegozio dao=new DAONegozio();
		ModelListNegozio model=ModelListNegozio.getInstance();
		dao.leggi(model);
		combo.setItems(model.getoListE());
	}
}
