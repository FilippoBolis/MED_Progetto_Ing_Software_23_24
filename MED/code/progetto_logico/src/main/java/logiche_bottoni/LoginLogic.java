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
import logiche_frame_pronto_soccorso.LogicaDellaStringaPaziente;
import med_db.jooq.generated.tables.Personale;
import modelli.ModelloGestoreLogicaGenerale;

public class LoginLogic {
	
	private LoginFrame loginFrame;
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private String utente;
	private String password;
	private String mansione;
	private String nome;
	private String cognome;
	private String codice;
	private ModelloGestoreLogicaGenerale modello;
	
	public LoginLogic(LoginFrame v, ModelloGestoreLogicaGenerale m) {
		// prede i refs
		loginFrame = v;
		modello = m;
		registerLogin();
	}
	
	private void registerLogin() {
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
						   	codice = contesto.select(Personale.PERSONALE.CODICE).from(Personale.PERSONALE).where(Personale.PERSONALE.CODICE.eq(utente)).fetchOneInto(String.class);
						   	//setup della view
						   	modello.modelloGestoreUtente.setUtente(mansione,nome,cognome,utente,codice);
						   	SwingUtilities.invokeLater(new Runnable() {
							    @Override
							    public void run() {
							    	PazientiFrame pazientiFrame = new PazientiFrame(modello);
							    	LogicaDellaPosizionePazienteTabella tabella	= new LogicaDellaPosizionePazienteTabella(pazientiFrame, modello,"in Pronto Soccorso");
								   	new LogicaBottoneVisualizzaDiarieInfermieristiche(pazientiFrame,modello);
							    	new LogicaBottoneFiltroReparto(pazientiFrame,modello);
								   	new LogicaBottoneInserisciPaziente(pazientiFrame,modello);
									new LogicaBottoneModificaDiariaMedica(pazientiFrame,modello);
									new LogicaBottoneAssegnaLetto(pazientiFrame,modello);
									new LogicaBottoneInserisciDiariaMedica(pazientiFrame,modello);
									new LogicaBottoneInserisciDiariaInfermieristica(pazientiFrame,modello);
									new LogicaBottoneVisualizzaStorico(pazientiFrame,modello);
									new LogicaBottoneVisualizzaFarmaci(pazientiFrame,modello);
									new LogicaBottoneVisualizzaInformazioni(pazientiFrame,modello);
									new LogicaBottoneDimetti(pazientiFrame,modello);
									new LogicaBottoneRefresh(pazientiFrame,modello);
									new LogicaBottoneFiltroNomeCognome(pazientiFrame,modello);
									new LogicaBottoneFiltroUrgenza(pazientiFrame,modello);
								   	new LogicaDellaStringaPaziente(pazientiFrame,modello);
								   	new LogicaBottoneInReparto(pazientiFrame,modello);
								   	new LogicaBottoneDaPrendereInCarico(pazientiFrame,modello);
									new LogicaBottoneInProntoSoccorso(pazientiFrame,modello);
									new LogicaBottoneInserisciRilevazione(pazientiFrame,modello);
									new LogicaBottoneVisualizzaRilevazioni(pazientiFrame,modello);
									new LogicaBottoneCambiaLetto(pazientiFrame,modello);
							    	loginFrame.sfondoFrame.dispose();
							    	tabella.update();
							    	pazientiFrame.updateViewUtente();
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
