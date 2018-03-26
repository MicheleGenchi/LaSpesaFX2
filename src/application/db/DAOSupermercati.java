package application.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.model.SuperMercato;

public class DAOSupermercati extends DAO<SuperMercato> {

	public DAOSupermercati() {

	}

	@Override
	public int leggi() {
		int conta=0;
		String SQL = "select idNegozio, nome from spesa2.Negozio order by nome";

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

}
