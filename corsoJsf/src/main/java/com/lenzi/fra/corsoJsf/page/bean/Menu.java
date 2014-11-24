package com.lenzi.fra.corsoJsf.page.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.lenzi.fra.corsoJsf.session.bean.Utente;

@ManagedBean(name="menu")
public class Menu {
	
	@ManagedProperty(value="#{utente}")
	private Utente utente;
	
	public String goToUtenteInfo(){
		return "utente";
	}
	
	
	public Utente getUtente() {
		return utente;
	}
	
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
