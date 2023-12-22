package it.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.dao.UtenteDao;
import it.betacom.dao.impl.UtenteDaoImpl;
import it.betacom.entity.Utente;
import it.betacom.service.Connessione;

/**
 * Servlet implementation class Registra
 */
@WebServlet(description = "Servlet di registrazione", urlPatterns = { "/Registra" })
public class Registra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registra() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connessione connessione = new Connessione();
		UtenteDao utenteDao = new UtenteDaoImpl(connessione);
		Utente utente = new Utente(request);
		utenteDao.insertUtente(response, utente);
		connessione.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
