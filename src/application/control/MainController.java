package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import application.db.DAOProdotto;
import application.db.DAOSupermercati;
import application.model.ModelListNegozio;
import application.model.ModelListProdotto;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MainController {

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

	private ModelListNegozio listaNegozi;
	private ModelListProdotto listaProdotti;

	@FXML
	void initialize() {
		assert borderPane != null : "fx:id=\"borderPane\" was not injected: check your FXML file 'Main.fxml'.";
		assert mnuLogin != null : "fx:id=\"mnuLogin\" was not injected: check your FXML file 'Main.fxml'.";
		assert mnuChiudi != null : "fx:id=\"mnuChiudi\" was not injected: check your FXML file 'Main.fxml'.";
		assert mnuInformazioni != null : "fx:id=\"mnuInformazioni\" was not injected: check your FXML file 'Main.fxml'.";
		
		MenuController.injection(this);

		DAOSupermercati dao1 = new DAOSupermercati();
		listaNegozi = new ModelListNegozio();
		dao1.leggi(listaNegozi);
		DAOProdotto dao2 = new DAOProdotto();
		listaProdotti = new ModelListProdotto();
		dao2.leggi(listaProdotti);
		boolean b1=listaNegozi.changeProperty().getValue();
		boolean b2=listaProdotti.changeProperty().getValue();
		System.out.println(b1+"\t"+b2);
		buttonSalva.disableProperty().bind(Bindings.not(
				listaNegozi.changeProperty().or(listaProdotti.changeProperty())));
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

	/**
	 * @return the listaNegozi
	 */
	public ModelListNegozio getListaNegozi() {
		return listaNegozi;
	}

	/**
	 * @param listaNegozi
	 *            the listaNegozi to set
	 */
	public void setListaNegozi(ModelListNegozio listaNegozi) {
		this.listaNegozi = listaNegozi;
	}

	/**
	 * @return the listaProdotti
	 */
	public ModelListProdotto getListaProdotti() {
		return listaProdotti;
	}

	/**
	 * @param listaProdotti
	 *            the listaProdotti to set
	 */
	public void setListaProdotti(ModelListProdotto listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	@FXML
	void doSalva(ActionEvent event) {
//		listaNegozi.save();
//		listaProdotti.save();
		Alert alert = new Alert(AlertType.INFORMATION, "I dati sono stati scritti sul database");
		alert.show();
		listaNegozi.setChange(false);
		listaProdotti.setChange(false);
		boolean b1=listaNegozi.changeProperty().getValue();
		boolean b2=listaProdotti.changeProperty().getValue();
		System.out.println(b1+"\t"+b2);
	}

}
