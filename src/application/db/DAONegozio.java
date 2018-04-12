package application.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.model.ListModel;
import application.model.Negozio;
import application.model.Prodotto;

public class DAONegozio extends DAO<Negozio> {

	public DAONegozio() {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tabella Supermercato";
	}

	@Override
	public int leggi(ListModel<Negozio> dati) {
		int conta = 0;
		String SQL = "select Negozio.idNegozio, Negozio.nome  from spesa2.Negozio";
		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Negozio record = new Negozio(rs.getInt("idNegozio"), rs.getString("nome"));
				conta++;
				record.setListaProdotti(getProdotti(record.getKey()));
				dati.aggiungi(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
	}

	@Override
	public int scrivi(ListModel<Negozio> model) {
		String SQL = "Insert into Spesa2.negozio (idNegozio, nome) values (?,?);";
		int conta = 0;
		try {
			PreparedStatement st = conn.prepareStatement(SQL);
			for (Negozio record : model.getListE()) {
				st.setInt(1, record.getKey());
				st.setString(2, record.getNome());
				st.executeUpdate();
				conta++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conta;
	}

	public List<Prodotto> getProdotti(int fkidNegozio) {
		List<Prodotto> lista = new ArrayList<>();
		String SQL = "select  idprodotto,prodotto.nome,descrizione,marca, contenitore,"
				+ "   peso,quantità,prezzo, negozio_idNegozio,negozio.nome" + "	from spesa2.prodotto, spesa2.Negozio"
				+ "	where negozio_idNegozio=Negozio.idNegozio " + "and negozio_idNegozio=? order by prodotto.nome";

		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			st.setInt(1, fkidNegozio);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Prodotto record = new Prodotto(rs.getInt("idProdotto"), rs.getString("nome"),
						rs.getString("descrizione"), rs.getString("marca"), rs.getString("contenitore"),
						rs.getInt("peso"), rs.getInt("quantità"), rs.getFloat("prezzo"), rs.getInt("negozio_idNegozio"),
						rs.getString("negozio.nome"));
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
			rs.next();
			conta=rs.getInt(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return conta;
	}

}
