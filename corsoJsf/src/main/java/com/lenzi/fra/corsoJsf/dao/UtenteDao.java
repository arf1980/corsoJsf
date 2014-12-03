package com.lenzi.fra.corsoJsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.sql.DataSource;

import com.lenzi.fra.corsoJsf.session.bean.Utente;

@ManagedBean
public class UtenteDao {

	@Resource(name="jdbc/inRamDb")
	private DataSource dataSource;
	
	public List<Utente> getUtenti() throws SQLException{
		
		List<Utente> utenti = new ArrayList<Utente>();
		
		Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from utente");
		ResultSet result = statement.executeQuery();
		
		while (result.next()){
			Utente u = new Utente();
			
			u.setNome(result.getString("NOME"));
			u.setCognome(result.getString("COGNOME"));
			
			utenti.add(u);
		}
		
		return utenti;
	}

}
