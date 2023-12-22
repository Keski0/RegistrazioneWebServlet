package it.betacom.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.interceptor.StatementCache;

public class Connessione {
	
	private Connection connection;
	private Statement statement;
	
	public Connessione() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Errore nella ricerca del driver JDBC: " + e.getMessage());
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/es_registrazione_servlet","root","root");
		} catch (SQLException e) {
			System.out.println("Errore nella ricerca connessione al DB: " + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public Statement getStatement() {
		statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Errore nella creazione dello Statement SQL: " + e.getMessage());
		}
		
		return statement;
	}
	
	public void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Errore nella chiusura dello Statement / Connection: " + e.getMessage());
		}
	}

}
