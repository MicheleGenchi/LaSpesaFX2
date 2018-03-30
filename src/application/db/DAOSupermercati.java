package application.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import application.model.Prodotto;
import application.model.SuperMercato;

public class DAOSupermercati extends DAO<SuperMercato> {

	public DAOSupermercati() {

	}

	@Override
	public int leggi() {
		int conta=0;
		String SQL = "select Negozio.idNegozio, Negozio.nome  from spesa2.Negozio order by nome";

		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				SuperMercato record = new SuperMercato(rs.getInt("idNegozio"), rs.getString("nome"));
				conta++;
				dati.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
	}

	@Override
	public int scrivi() {
		String SQL = "Insert Into spesa2.Negozio (nome) value (%1);";
		int conta = 0;
		try {
			PreparedStatement st = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			for (SuperMercato record : dati) {
				st.setString(1, record.getNome());
				conta = st.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conta;
	}
	
	public int getProdotti(List<Prodotto> lista, SuperMercato superMercato) {
		int conta=0;
		String SQL = "select  idprodotto,prodotto.nome,descrizione,marca, contenitore,peso,quantit�,prezzo,negozio_idNegozio,negozio.nome" + 
				"	from spesa2.prodotto, spesa2.negozio" + 
				"	where negozio_idNegozio=? order by prodotto.nome";

		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			st.setInt(1, superMercato.getKey());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Prodotto record = new Prodotto(
						rs.getInt("idProdotto"),
						rs.getString("nome"),
						rs.getString("descrizione"),
						rs.getString("marca"),
						rs.getString("contenitore"),
						rs.getInt("peso"),
						rs.getInt("quantit�"),
						rs.getFloat("prezzo"),
						rs.getInt("negozio_idNegozio"),
						rs.getString("negozio.nome"));
				conta++;
				lista.add(record);
			}
			superMercato.setProdotti(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
	}
}
