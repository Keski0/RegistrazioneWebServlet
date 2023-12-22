package it.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.service.Operations;

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
		
		Operations op = new Operations();
		
		String stampa = inserimento(request, op);
		response.getWriter().append(stampa);
		
		op.closeConnection();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private String inserimento(HttpServletRequest request, Operations op) {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String sesso = request.getParameter("sesso");
		String luogoNascita = request.getParameter("luogoNascita");
		String provincia = request.getParameter("provincia");
		String dataNascita = request.getParameter("dataNascita");
		String codiceFiscale = request.getParameter("codiceFiscale");
		String password = request.getParameter("password");
		String trovato = request.getParameter("trovato");
		
		String stampa = op.inserisciUtente(nome, cognome, sesso, luogoNascita, provincia, dataNascita, codiceFiscale, password, trovato);
		
		return stampa;
	}

}
