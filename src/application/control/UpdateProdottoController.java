package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import Utils.TIPOCONTENITORE;
import application.model.ModelListNegozio;
import application.model.ModelListProdotto;
import application.model.ModelNegozio;
import application.model.ModelProdotto;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
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
	private ComboBox<ModelNegozio> negozio;
	@FXML
	private TextField testValueContenitore;
	@FXML
	private TextField testValueidNegozio;
	@FXML
	private Button btnAggiungiProdotto;

	private ModelProdotto model;
	private ModelListNegozio listaNegozi;
	private ModelListProdotto listaProdotti;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new ModelProdotto();
		listaNegozi=ModelListNegozio.getInstance();
		listaNegozi.caricaDB();
		listaProdotti=ModelListProdotto.getInstance();
		listaProdotti.caricaDB();
		model.setIdprodotto(listaProdotti.getListE().size()+1);
		idprodotto.textProperty().bindBidirectional(model.idprodottoProperty(), new NumberStringConverter());
		nome.textProperty().bindBidirectional(model.nomeProperty());
		descrizione.textProperty().bindBidirectional(model.descrizioneProperty());
		marca.textProperty().bindBidirectional(model.marcaProperty());
		contenitore.getItems().addAll(TIPOCONTENITORE.values());
		contenitore.getSelectionModel().selectFirst();
		testValueContenitore.textProperty().bind(Bindings.convert(contenitore.valueProperty()));
		model.contenitoreProperty().bind(Bindings.convert(contenitore.valueProperty()));
		negozio.setItems(listaNegozi.getoListE());
		populateNomeNegozi(negozio);
		negozio.valueProperty().addListener(new ChangeListener<ModelNegozio>() {
				@Override
				public void changed(ObservableValue<? extends ModelNegozio> observable, ModelNegozio oldValue,
						ModelNegozio newValue) {
					// TODO Auto-generated method stub
					int idNegozio=listaNegozi.cerca(observable.getValue().getNome());
					model.setNegozio_idNegozio(idNegozio);
					testValueidNegozio.setText(String.valueOf(idNegozio));
				}
		});
		
		nome.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> ov, String t, String t1) {
				// System.out.println(t+"====="+t1);
				if (t1.equals(""))
					btnAggiungiProdotto.setDisable(true);
				else
					btnAggiungiProdotto.setDisable(false);
			}
		});
		btnAggiungiProdotto.setDisable(true);
	}

	public void populateNomeNegozi(ComboBox<ModelNegozio> combo) {
		
		combo.setItems(listaNegozi.getoListE());
		combo.setConverter(new StringConverter<ModelNegozio>() {
			@Override
			public String toString(ModelNegozio object) {
				return object == null ? null : object.getNome();
			}

			@Override
			public ModelNegozio fromString(String string) {
				return combo.getItems().stream().filter(i -> i.getNome().equals(string)).findAny().orElse(null);
			}
		});

		combo.setCellFactory(lv -> new ListCell<ModelNegozio>() {
			@Override
			protected void updateItem(ModelNegozio item, boolean empty) {
				super.updateItem(item, empty);

				// use full text in list cell (list popup)
				setText(item == null ? null : item.getNome());
			}
		});
	}

	@FXML
	void doAggiungiProdotto(ActionEvent event) {
		boolean success=listaProdotti.aggiungi(model);
		if (success) {
			btnAggiungiProdotto.setDisable(true);
			listaProdotti.setChange(true);
		}
	}
}
