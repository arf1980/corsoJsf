package com.lenzi.fra.corsoJsf.page.bean;

import com.lenzi.fra.corsoJsf.session.bean.Utente;

public class Benvenuto {
	
	private String messaggio = "Benvenuto Utente";
	
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

}
