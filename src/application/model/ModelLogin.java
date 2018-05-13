package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelLogin {
	private StringProperty utente=new SimpleStringProperty();
	private StringProperty password=new SimpleStringProperty();
	private static boolean access;
	
	
	public ModelLogin() {
		
	}
	
	public ModelLogin(String utente, String password) {
		setUtente(utente);
		setPassword(password);
	}

	public final StringProperty utenteProperty() {
		return this.utente;
	}
	

	public final String getUtente() {
		return this.utenteProperty().get();
	}
	

	public final void setUtente(final String utente) {
		this.utenteProperty().set(utente);
	}
	

	public final StringProperty passwordProperty() {
		return this.password;
	}
	

	public final String getPassword() {
		return this.passwordProperty().get();
	}
	

	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}

	public static boolean isAccess() {
		return access;
	}

	public static void setAccess(boolean access) {
		ModelLogin.access = access;
	}
}
