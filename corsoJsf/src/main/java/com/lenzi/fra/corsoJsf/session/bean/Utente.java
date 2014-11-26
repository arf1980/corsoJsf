package com.lenzi.fra.corsoJsf.session.bean;

import org.apache.commons.lang3.StringUtils;

public class Utente {
	private String nome;
	private String cognome;
	private boolean logged = false;
	
	private int livello;
	
	public boolean isValido(){
		return StringUtils.isNotBlank(getNome()) && StringUtils.isNotBlank(getCognome());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	public int getLivello() {
		return livello;
	}
	public void setLivello(int livello) {
		this.livello = livello;
	}
	
	
}
