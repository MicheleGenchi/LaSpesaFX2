package application.control;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import application.db.DAONegozio;
import application.db.MyConnection;
import application.model.ModelLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField utente;

    @FXML
    private TextField password;

    @FXML
    private Button btnLogin;

    private ModelLogin model;
    
    @FXML
    void doLogin(ActionEvent event) {
    	Connection conn = MyConnection.getInstance().setUser(model.getUtente()).setPassword(model.getPassword()).open();
    	if (conn==null) {
    		System.exit(0);
    	}
    }

    @FXML
    void initialize() {
        assert utente != null : "fx:id=\"utente\" was not injected: check your FXML file 'Login.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model=new ModelLogin();
		utente.textProperty().bindBidirectional(model.utenteProperty());
		password.textProperty().bindBidirectional(model.passwordProperty());
	}
}

