package application.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.db.DAONegozio;
import application.db.DAOProdotto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class MenuController {

	static MainController mainController;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private MenuItem menuLogin;

	@FXML
	private MenuItem menuFine;

	@FXML
	private MenuItem menuAggiungiNegozio;

	@FXML
	private MenuItem menuVisualizzaNegozio;

	@FXML
	private MenuItem menuAggiungiProdotto;

	@FXML
	private MenuItem menuVisualizzaProdotto;

	@FXML
	private MenuItem menuInformazioni;

	@FXML
	void doAggiungiNegozio(ActionEvent event) {
		Node schermata= loader("../view/UpdateNegozio.fxml");
		mainController.getBorderPane().setCenter(schermata);
	}

	@FXML
	void doAggiungiProdotto(ActionEvent event) {
		Node schermata=loader("../view/UpdateProdotto.fxml");
		mainController.getBorderPane().setCenter(schermata);
	}

	@FXML
	void doChiudiProgramma(ActionEvent event) {
		if (DAONegozio.getInstance().isConnect())
			DAONegozio.getInstance().chiudi();
		if (DAOProdotto.getInstance().isConnect())
			DAOProdotto.getInstance().chiudi();
		MainController.getPrimaryStage().close();
	}

	@FXML
	void doInformazioni(ActionEvent event) {
		Node schermata = loader("../view/viewInformazioni.fxml");
		mainController.getBorderPane().setCenter(schermata);
	}

	@FXML
	void doLogin(ActionEvent event) {
		Node schermata = loader("../view/Login.fxml");
		mainController.getBorderPane().setCenter(schermata);
	}

	@FXML
	void doVisualizzaProdotto(ActionEvent event) {
		Node schermata = loader("../view/viewProdotti.fxml");
		mainController.getBorderPane().setCenter(schermata);
	}

	@FXML
	void doVisuallizzaNegozio(ActionEvent event) {
		/*
		 * Class<ModelNegozio> negozio=ModelNegozio.class; DAONegozio dao=new
		 * DAONegozio(); ModelListNegozio dati = ModelListNegozio.getInstance();
		 * dao.leggi(dati); TableView<ModelNegozio> controller=new TableView<>();
		 * controller.getStylesheets().add(getClass().getResource(
		 * "../view/application.css").toExternalForm()); controller.setStyle("pane");
		 * //dati.setoListE(dati.getListE()); controller=new
		 * Table<ModelNegozio>().get(negozio, dati.getoListE());
		 * mainController.getBorderPane().setCenter(controller);
		 */
		Node schermata = loader("../view/viewNegozi.fxml");
		mainController.getBorderPane().setCenter(schermata);
	}

	private Node loader(String path) {
		Node schermata = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
		try {
			schermata = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schermata;
	}

	@FXML
	void initialize() {
		assert menuLogin != null : "fx:id=\"menuLogin\" was not injected: check your FXML file 'menu.fxml'.";
		assert menuFine != null : "fx:id=\"menuFine\" was not injected: check your FXML file 'menu.fxml'.";
		assert menuAggiungiNegozio != null : "fx:id=\"menuAggiungiNegozio\" was not injected: check your FXML file 'menu.fxml'.";
		assert menuVisualizzaNegozio != null : "fx:id=\"menuVisualizzaNegozio\" was not injected: check your FXML file 'menu.fxml'.";
		assert menuAggiungiProdotto != null : "fx:id=\"menuAggiungiProdotto\" was not injected: check your FXML file 'menu.fxml'.";
		assert menuVisualizzaProdotto != null : "fx:id=\"menuVisualizzaProdotto\" was not injected: check your FXML file 'menu.fxml'.";
		assert menuInformazioni != null : "fx:id=\"menuInformazioni\" was not injected: check your FXML file 'menu.fxml'.";
	}

	public static void injection(MainController mainController) {
		MenuController.mainController = mainController;
	}
}
