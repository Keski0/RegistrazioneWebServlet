package it.betacom.dao;

import java.util.ArrayList;

import it.betacom.entity.Utente;

public interface UtenteDao {

	ArrayList<Utente> getAllUtenti();
	Utente getUtenteById(int id);
	void insertUtente(Utente utente);
	String insertUtenteEStampa(Utente utente);
	void deleteUtente(Utente utente);
	void updateUtente(Utente utente);
	
}
