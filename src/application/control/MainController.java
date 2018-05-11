package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.ModelListNegozio;
import application.model.ModelListProdotto;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

	ModelListNegozio listaNegozi;
	ModelListProdotto listaProdotti;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private BorderPane borderPane;

	@FXML
	private MenuItem mnuLogin;

	@FXML
	private MenuItem mnuChiudi;

	@FXML
	private MenuItem mnuInformazioni;

	@FXML
	private Button buttonSalva;

	@FXML
	void doMnuChiudi(ActionEvent event) {

	}

	@FXML
	void doMnuInformazioni(ActionEvent event) {

	}

	@FXML
	void doMnuLogin(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert borderPane != null : "fx:id=\"borderPane\" was not injected: check your FXML file 'Main.fxml'.";
		assert mnuLogin != null : "fx:id=\"mnuLogin\" was not injected: check your FXML file 'Main.fxml'.";
		assert mnuChiudi != null : "fx:id=\"mnuChiudi\" was not injected: check your FXML file 'Main.fxml'.";
		assert mnuInformazioni != null : "fx:id=\"mnuInformazioni\" was not injected: check your FXML file 'Main.fxml'.";
	}

	/**
	 * @return the borderPane
	 */
	public BorderPane getBorderPane() {
		return borderPane;
	}

	/**
	 * @param borderPane
	 *            the borderPane to set
	 */
	public void setBorderPane(BorderPane borderPane) {
		this.borderPane = borderPane;
	}

	@FXML
	void doSalva(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION, "I dati sono stati scritti sul database");
		alert.show();
		boolean b1=listaNegozi.changeProperty().getValue();
		boolean b2=listaProdotti.changeProperty().getValue();
		System.out.println(b1+"\t"+b2);
		if (b1==true) {
			listaNegozi.save();
			listaNegozi.changeProperty().setValue(false);
			listaNegozi.caricaDB();
		}
		if (b2=true) {
			listaProdotti.save();
			listaProdotti.changeProperty().setValue(false);
			listaProdotti.caricaDB();
		}
		borderPane.setCenter(null);
 	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listaNegozi=ModelListNegozio.getInstance();
		listaProdotti=ModelListProdotto.getInstance();
		MenuController.injection(this);
		System.out.println("listaNegozi.isChange()="+listaNegozi.isChange());
		System.out.println("listaProdotti.isChange()="+listaProdotti.isChange());
		buttonSalva.disableProperty().bind(Bindings.not(
				listaNegozi.changeProperty().or
				(listaProdotti.changeProperty())));
	}
}
