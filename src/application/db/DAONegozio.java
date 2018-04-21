package application.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.model.ListModel;
import application.model.ModelNegozio;

public class DAONegozio extends DAO<ModelNegozio> {

	public DAONegozio() {

	}

	@Override
	public String toString() {
		return "Tabella Supermercato";
	}

	@Override
	public int leggi(ListModel<ModelNegozio> dati) {
		int conta = 0;
		String SQL = "select Negozio.idNegozio, Negozio.nome from spesa2.Negozio";
		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				ModelNegozio record = new ModelNegozio(rs.getInt("idNegozio"), rs.getString("nome"));
				conta++;
				record.setListaIdProdotti(getIdProdotti(record.getKey()));
				dati.aggiungi(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
	}
	
	public boolean cercaNegozio(int idNegozio, ModelNegozio record) {
		boolean trovato=false;
		String SQL = "select Negozio.idNegozio, Negozio.nome from spesa2.Negozio"
				+ "where Negozio.idNegozio=?";
		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			ResultSet rs = st.executeQuery();
			if (rs.first()) {
				record.setKey(rs.getInt("idNegozio"));
				record.setNome(rs.getString("nome"));
				record.setListaIdProdotti(getIdProdotti(record.getKey()));
				trovato=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trovato;
	}
	
	@Override
	public int scrivi(ListModel<ModelNegozio> model) {
		String SQL = "Insert into Spesa2.negozio (idNegozio, nome) values (?,?);";
		int conta = 0;
		try {
			PreparedStatement st = conn.prepareStatement(SQL);
			for (ModelNegozio record : model.getListE()) {
				st.setInt(1, record.getKey());
				st.setString(2, record.getNome());
				st.executeUpdate();
				conta++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
	}

	public List<Integer> getIdProdotti(int fkidNegozio) {
		List<Integer> lista = new ArrayList<>();
		String SQL = "select  idprodotto from spesa2.prodotto, spesa2.Negozio"
				+ "	where negozio_idNegozio=Negozio.idNegozio " + "and negozio_idNegozio=? order by prodotto.idProdotto";

		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			st.setInt(1, fkidNegozio);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Integer record = new Integer(rs.getInt("idProdotto"));
				lista.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}


	@Override
	public  int lastRecord() {
		int conta=0;
		final String SQL = "Select count(*) from Negozio";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(SQL);
			if (rs.first())
				conta=rs.getInt(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return conta;
	}

}
