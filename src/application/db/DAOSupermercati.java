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
	public boolean leggi() {
		String SQL = "select idNegozio, nome from spesa2.Negozio order by nome";

		try (Statement st = conn.createStatement()) {
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				SuperMercato record = new SuperMercato(rs.getInt("idNegozio"), rs.getString("nome"));
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
