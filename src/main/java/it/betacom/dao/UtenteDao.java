package it.betacom.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import it.betacom.entity.Utente;

public interface UtenteDao {

	ArrayList<Utente> getAllUtenti();
	Utente getUtenteById(int id);
	void insertUtente(Utente utente);
	void insertUtente(HttpServletResponse response, Utente utente);
	void deleteUtente(Utente utente);
	void updateUtente(Utente utente);
	
}
