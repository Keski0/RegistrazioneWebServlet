package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.betacom.dao.UtenteDao;
import it.betacom.entity.Utente;
import it.betacom.service.Connessione;

public class UtenteDaoImpl implements UtenteDao {

	private Connection con;
	private Statement stm;
	
	public UtenteDaoImpl(Connessione connessione) {
		con = connessione.getConnection();
		stm = connessione.getStatement();
	}

	@Override
	public ArrayList<Utente> getAllUtenti() {
		
		ArrayList<Utente> utenti = new ArrayList<Utente>();
		ResultSet rs;
		try {
			rs = stm.executeQuery("SELECT * FROM utente;");
			while (rs.next())
			{
				int id_autore = rs.getInt("id_utente");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String sesso = rs.getString("sesso");
				String luogo_nascita = rs.getString("luogo_nascita");
				String provincia = rs.getString("provincia");
				Date data_nascita = rs.getDate("data_nascita");
				String codice_fiscale = rs.getString("codice_fiscale");
				String password = rs.getString("password");
				String trovato = rs.getString("trovato");
				utenti.add(new Utente(id_autore, nome, cognome, sesso, luogo_nascita, provincia, data_nascita, codice_fiscale, password, trovato));
			}
		} catch (SQLException e) {
			System.out.println("Errore nella query di getAllUtenti(): " + e.getMessage());
		}
		
		return utenti;
	}

	@Override
	public Utente getUtenteById(int id) {

		Utente utente = null;
		ResultSet rs;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM utente WHERE id_utente=?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next())
			{
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String sesso = rs.getString("sesso");
				String luogo_nascita = rs.getString("luogo_nascita");
				String provincia = rs.getString("provincia");
				Date data_nascita = rs.getDate("data_nascita");
				String codice_fiscale = rs.getString("codice_fiscale");
				String password = rs.getString("password");
				String trovato = rs.getString("trovato");
				utente = new Utente(id, nome, cognome, sesso, luogo_nascita, provincia, data_nascita, codice_fiscale, password, trovato);
			}
		} catch (SQLException e) {
			System.out.println("Errore nella query di getUtenteById(): " + e.getMessage());
		}

		return utente;
		
	}

	@Override
	public void insertUtente(Utente utente) {		
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO utente (nome, cognome, sesso, luogo_nascita, provincia, data_nascita, codice_fiscale, password, trovato) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, utente.getNome());
			ps.setString(2, utente.getCognome());
			ps.setString(3, utente.getSesso());
			ps.setString(4, utente.getLuogoNascita());
			ps.setString(5, utente.getProvincia());
			ps.setDate(6, utente.getDataNascita());
			ps.setString(7, utente.getCodiceFiscale());
			ps.setString(8, utente.getPassword());
			ps.setString(9, utente.getTrovato());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Errore nella query di insertUtente(): " + e.getMessage());
		}
		
	}
	
	@Override
	public String insertUtenteEStampa(Utente utente) {
		
		String stampa = null;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS conteggio FROM utente WHERE codice_fiscale = ?");
			ps.setString(1, utente.getCodiceFiscale());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt("conteggio");
			if(count > 0)
			{
				stampa = ("<html><body>L'utente " + utente.getNome() + " risulta gia' registrato!</body></html>");
			}
			else
			{
				insertUtente(utente);
				
				stampa = ("<html><body>Benvenuto/a " + utente.getNome() + ", la registrazione e' stata effettuata con successo!</body></html>");
			}
		} catch (SQLException e) {
			System.out.println("Errore nella query di insertUtente(): " + e.getMessage());
		}
		
		return stampa;
	}

	@Override
	public void deleteUtente(Utente utente) {
		
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM utente WHERE id_utente=?");
			ps.setInt(1, utente.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Errore nella query deleteUtente(): " + e.getMessage());
		}
		
	}

	@Override
	public void updateUtente(Utente utente) {
		
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE utente SET nome='?', cognome='?', sesso='?', luogo_nascita='?', "
					+ "provincia='?', data_nascita=?, codice_fiscale='?', password='?', trovato='?' WHERE id_utente=?");
			
			ps.setString(1, utente.getNome());
			ps.setString(2, utente.getCognome());
			ps.setString(3, utente.getSesso());
			ps.setString(4, utente.getLuogoNascita());
			ps.setString(5, utente.getProvincia());
			ps.setDate(6, utente.getDataNascita());
			ps.setString(7, utente.getCodiceFiscale());
			ps.setString(8, utente.getPassword());
			ps.setString(9, utente.getTrovato());
			ps.setInt(10, utente.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Errore nella query updateUtente(): " + e.getMessage());
		}
		
	}

}
