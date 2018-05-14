package application.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelInformazioni {
	private StringProperty programmatore = new SimpleStringProperty();
	private StringProperty versione = new SimpleStringProperty();
	private StringProperty tipoLicenza = new SimpleStringProperty();
	private StringProperty contratto = new SimpleStringProperty();

	public ModelInformazioni() {
		setProgrammatore("");
		setVersione("");
		setTipoLicenza("");
		setContratto("");
	}

	public ModelInformazioni(Locale locale, String suffisso) {
		ResourceBundle res = ResourceBundle.getBundle(suffisso, locale);
		setProgrammatore(res.getString("programmatore"));
		setVersione(res.getString("versione"));
		setTipoLicenza(res.getString("tipoLicenza"));
		setContratto(res.getString("contratto"));
	}

	public final StringProperty programmatoreProperty() {
		return this.programmatore;
	}

	public final String getProgrammatore() {
		return this.programmatoreProperty().get();
	}

	public final void setProgrammatore(final String programmatore) {
		this.programmatoreProperty().set(programmatore);
	}

	public final StringProperty versioneProperty() {
		return this.versione;
	}

	public final String getVersione() {
		return this.versioneProperty().get();
	}

	public final void setVersione(final String versione) {
		this.versioneProperty().set(versione);
	}

	public final StringProperty tipoLicenzaProperty() {
		return this.tipoLicenza;
	}

	public final String getTipoLicenza() {
		return this.tipoLicenzaProperty().get();
	}

	public final void setTipoLicenza(final String tipoLicenza) {
		this.tipoLicenzaProperty().set(tipoLicenza);
	}

	public final StringProperty contrattoProperty() {
		return this.contratto;
	}

	public final String getContratto() {
		return this.contrattoProperty().get();
	}

	public final void setContratto(final String contratto) {
		this.contrattoProperty().set(contratto);
	}

}
