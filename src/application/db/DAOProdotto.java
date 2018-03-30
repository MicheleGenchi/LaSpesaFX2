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
	public int leggi() {
		int conta=0;
		String SQL = "select  idprodotto,prodotto.nome,descrizione,marca, contenitore,peso,quantità,prezzo,negozio_idNegozio,negozio.nome" + 
				"	from spesa2.prodotto, spesa2.negozio" + 
				"	where prodotto.negozio_idNegozio=negozio.idNegozio order by prodotto.nome";

		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Prodotto record = new Prodotto(
						rs.getInt("idProdotto"),
						rs.getString("nome"),
						rs.getString("descrizione"),
						rs.getString("marca"),
						rs.getString("contenitore"),
						rs.getInt("peso"),
						rs.getInt("quantità"),
						rs.getFloat("prezzo"),
						rs.getInt("negozio_idNegozio"),
						rs.getString("negozio.nome"));
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
		String SQL = "Insert Into spesa2.Prodotto (nome,descrizione,marca, contenitore,peso,quantità,prezzo,negozio.idNegozio) "
				+ "value (%1,%2,%3,%4,%5,%6,%7);";
		int conta = 0;
		try {
			PreparedStatement st = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			for (Prodotto record : dati) {
				st.setString(1, record.getNome());
				st.setString(2, record.getDescrizione());
				st.setString(3, record.getMarca());
				st.setString(4, record.getContenitore());
				st.setInt(5, record.getPeso());
				st.setInt(6, record.getQuantità());
				st.setFloat(7, record.getPrezzo());
				st.setInt(8, record.getNegozio_idNegozio());
				conta = st.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conta;
	}

}
