package com.lenzi.fra.corsoJsf.page.bean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.lenzi.fra.corsoJsf.dao.UtenteDao;
import com.lenzi.fra.corsoJsf.session.bean.Utente;

@ManagedBean
public class Benvenuto {
	
	@ManagedProperty(value="#{utenteDao}")
	private UtenteDao dao;
	
	private String messaggio = "Benvenuto Utente";
	
	@ManagedProperty(value="#{utente}")
	private Utente utente;
	
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public String login(){
		if (utente.isValido()){
			utente.setLogged(true);
			return "loggato";
		}
		
		return null;
	}
	
	public String getMessaggio() {
		return messaggio;
	}
	
	public void selectUtenti() throws SQLException{
		dao.getUtenti();
	}
	
	public UtenteDao getDao() {
		return dao;
	}
	
	public void setDao(UtenteDao dao) {
		this.dao = dao;
	}

}
