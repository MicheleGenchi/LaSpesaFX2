 package application.db;

import java.beans.Beans;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.Utils;
import application.model.ListModel;
import application.model.ModelProdotto;
import application.model.Prodotto;

public class DAOProdotto extends DAO<ModelProdotto> {
	
	public DAOProdotto() {

	}
	
	@Override
	public String toString() {
		return  "Tabella Prodotto";
	}

	@Override
	public int leggi(ListModel<ModelProdotto> dati) {
		int conta=0;
		String SQL = "select  idprodotto,prodotto.nome,descrizione,marca, contenitore,peso,quantità,prezzo,negozio_idNegozio,negozio.nome" + 
				"	from spesa2.prodotto, spesa2.negozio" + 
				"	where prodotto.negozio_idNegozio=negozio.idNegozio order by prodotto.nome";

		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				ModelProdotto record = new ModelProdotto(
						rs.getInt("idProdotto"),
						rs.getString("nome"),
						rs.getString("descrizione"),
						rs.getString("marca"),
						rs.getString("contenitore"),
						rs.getInt("peso"),
						rs.getInt("quantità"),
						rs.getFloat("prezzo"),
						rs.getInt("negozio_idNegozio"));
				conta++;
				dati.aggiungi(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
	}

	@Override
	public int scrivi(ListModel<ModelProdotto> dati) {
		String SQL = "Insert Into spesa2.Prodotto (nome,descrizione,marca, contenitore,peso,quantità,prezzo,negozio.idNegozio) "
				+ "value (?,?,?,?,?,?,?,?);";
		int conta = 0;
		try {
			PreparedStatement st = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			for (ModelProdotto record : dati.getListE()) {
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
			e.printStackTrace();
		}
		return conta;
	}

	@Override
	public  int lastRecord() {
		int conta=0;
		final String SQL = "Select count(*) from Prodotto";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(SQL);
			conta=rs.getInt(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return conta;
	}
	
	public boolean cerca(int idProdotto, Prodotto record) {
		boolean trovato=false;
		String SQL = "select  idprodotto,prodotto.nome,descrizione,marca, contenitore,peso,quantità,prezzo,negozio_idNegozio" + 
				"	from spesa2.prodotto" + 
				"	where prodotto.idprodotto=? order by prodotto.nome";

		try (PreparedStatement st = conn.prepareStatement(SQL)) {
			st.setInt(1,idProdotto);
			ResultSet rs = st.executeQuery();
			if (rs.first()) {
				trovato=true;
				for (Field field:record.getClass().getDeclaredFields()) {
					Utils.callSetter(record,field.getName(),rs.getObject(field.getName()));
				}
			}
		} catch (SQLException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return trovato;
	}
}
