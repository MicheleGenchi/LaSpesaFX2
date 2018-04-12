package application.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import application.model.ListModel;
import application.model.Prodotto;
import application.model.SuperMercato;

public class DAOSupermercati extends DAO<SuperMercato> {

	public DAOSupermercati() {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tabella Supermercato";
	}

	@Override
	public int leggi(ListModel<SuperMercato> dati) {
		int conta = 0;
		String SQL = "select Negozio.idNegozio, Negozio.nome  from spesa2.Negozio";
		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				SuperMercato record = new SuperMercato(rs.getInt("idNegozio"), rs.getString("nome"));
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
	public int scrivi(ListModel<SuperMercato> dati) {
		String SQL = "Insert into Spesa2.negozio (idNegozio, nome) values (?,?);";
		int conta = 0;
		try {
			PreparedStatement st = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			for (SuperMercato record : dati.getListE()) {
				ResultSet rs = st.getGeneratedKeys();  
				int key = rs.next() ? rs.getInt(1) : 0;
				st.setInt(1, key);
				st.setString(2, record.getNome());
				st.executeUpdate();
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

}
