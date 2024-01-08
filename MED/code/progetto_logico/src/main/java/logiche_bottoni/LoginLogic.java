package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import org.jooq.DSLContext;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import med_db.jooq.generated.tables.Personale;
import modelli.ModelloGestoreLogicaGenerale;

public class LoginLogic {
	
	private LoginFrame loginFrame;
	private PazientiFrame prontoSoccorso;
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private String utente;
	private String password;
	private String mansione;
	private String nome;
	private String cognome;
	private ModelloGestoreLogicaGenerale modello;
	private LogicaDellaPosizionePazienteTabella tabellaProntoSoccorso;
	
	public LoginLogic(LoginFrame v, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prede i refs
		loginFrame = v;
		prontoSoccorso = v2;
		modello = m;
		tabellaProntoSoccorso = new LogicaDellaPosizionePazienteTabella(prontoSoccorso, modello,"in Pronto Soccorso");
		registerLogin();
	}
	
	private void registerLogin() {
		prontoSoccorso.sfondoFrame.setVisible(false);
		// si registra al bottone loginButton
		loginFrame.loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(DB_URLLOGIC);
					if (conn != null) {
						DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
						utente = loginFrame.userField.getText();
						password = new String(loginFrame.passwordField.getPassword());
						int result = contesto.select().from(Personale.PERSONALE).where(Personale.PERSONALE.PASSWORD.eq(password).and(Personale.PERSONALE.CODICE.eq(utente))).execute();
						if (result == 1) {
						   	cognome = contesto.select(Personale.PERSONALE.COGNOME).from(Personale.PERSONALE).where(Personale.PERSONALE.CODICE.eq(utente)).fetchOneInto(String.class);
						   	nome = contesto.select(Personale.PERSONALE.NOME).from(Personale.PERSONALE).where(Personale.PERSONALE.CODICE.eq(utente)).fetchOneInto(String.class);
						   	mansione = contesto.select(Personale.PERSONALE.MANSIONE).from(Personale.PERSONALE).where(Personale.PERSONALE.CODICE.eq(utente)).fetchOneInto(String.class);
						   	modello.modelloGestoreUtente.setUtente(mansione,nome,cognome,utente);
						   	tabellaProntoSoccorso.update();
						   	SwingUtilities.invokeLater(new Runnable() {
							    @Override
							    public void run() {
							    	loginFrame.sfondoFrame.setVisible(false);
							    	prontoSoccorso.updateViewUtente();
							    	prontoSoccorso.sfondoFrame.setVisible(true);
							    }
							});
						}
						else {
							new ErroreFrame(loginFrame.sfondoFrame, "Username o Password errati");
						}
					}
				} catch (SQLException ev) {
					System.out.println(ev.getMessage());
				}	
			}
		});
	}
}
