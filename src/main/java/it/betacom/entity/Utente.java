package it.betacom.entity;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

public class Utente {
	
	private int id;
	private String nome;
	private String cognome;
	private String sesso;
	private String luogoNascita;
	private String provincia;
	private Date dataNascita;
	private String codiceFiscale;
	private String password;
	private String trovato;
	
	public Utente() {
		super();
	}

	public Utente(int id, String nome, String cognome, String sesso, String luogoNascita, String provincia,
			Date dataNascita, String codiceFiscale, String password, String trovato) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.luogoNascita = luogoNascita;
		this.provincia = provincia;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.password = password;
		this.trovato = trovato;
	}
	
	public Utente(HttpServletRequest request) {
		
		nome = request.getParameter("nome");
		cognome = request.getParameter("cognome");
		sesso = request.getParameter("sesso");
		luogoNascita = request.getParameter("luogoNascita");
		provincia = request.getParameter("provincia");
		dataNascita = Date.valueOf(request.getParameter("dataNascita"));
		codiceFiscale = request.getParameter("codiceFiscale");
		password = request.getParameter("password");
		trovato = request.getParameter("trovato");
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrovato() {
		return trovato;
	}

	public void setTrovato(String trovato) {
		this.trovato = trovato;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", luogoNascita="
				+ luogoNascita + ", provincia=" + provincia + ", dataNascita=" + dataNascita + ", codiceFiscale="
				+ codiceFiscale + ", password=" + password + ", trovato=" + trovato + "]";
	}

}
