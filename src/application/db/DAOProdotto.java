package application.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import application.model.Prodotto;

public class DAOProdotto extends DAO<Prodotto> {

	public DAOProdotto() {

	}

	@Override
	public boolean leggi() {
		String SQL = "select  idprodotto,prodotto.nome,descrizione,contenitore,peso,quantità,prezzo,negozio_idNegozio,negozio.nome" + 
				"	from spesa2.prodotto, spesa2.negozio" + 
				"	where prodotto.negozio_idNegozio=negozio.idNegozio order by prodotto.nome";

		try (Statement st = conn.createStatement()) {
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				Prodotto record = new Prodotto(rs.getInt("idProdotto"),
						rs.getString("nome"),
						rs.getString("descrizione"),
						rs.getString("contenitore"),
						rs.getInt("peso"),
						rs.getInt("quantità"),
						rs.getFloat("prezzo"),
						rs.getInt("negozio_idNegozio"));
				record.setNomeSuperMercato(rs.getString("negozio.nome"));
				dati.add(record);
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int scrivi() {
		String SQL = "Insert Into spesa2.Prodotto (nome,descrizione,contenitore,peso,quantità,prezzo,negozio.idNegozio) "
				+ "value (%1,%2,%3,%4,%5,%6,%7);";
		int conta = 0;
		try {
			PreparedStatement st = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			for (Prodotto record : dati) {
				st.setString(1, record.getNome());
				st.setString(2, record.getDescrizione());
				st.setString(3, record.getContenitore());
				st.setInt(4, record.getPeso());
				st.setInt(5, record.getQuantità());
				st.setFloat(6, record.getPrezzo());
				st.setInt(7, record.getNegozio_idNegozio());
				conta = st.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conta;
	}

}
