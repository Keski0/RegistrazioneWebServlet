package it.betacom.service;

import java.sql.Date;

import it.betacom.dao.UtenteDao;
import it.betacom.dao.impl.UtenteDaoImpl;
import it.betacom.entity.Utente;

public class Operations {

	private Connessione connessione;
	
	public Operations() {
		connessione = new Connessione();
	}
	
	public String inserisciUtente(String nome, String cognome, String sesso, String luogoNascita, String provincia,
			String dataNascita, String codiceFiscale, String password, String trovato) {
		
		UtenteDao utenteDao = new UtenteDaoImpl(connessione);
		Utente utente = new Utente(nome, cognome, sesso, luogoNascita, provincia, Date.valueOf(dataNascita), codiceFiscale, password, trovato);
		String stampa = utenteDao.insertUtenteEStampa(utente);
		
		return stampa;
	}
	
	public void closeConnection() {
		connessione.close();
	}
}
