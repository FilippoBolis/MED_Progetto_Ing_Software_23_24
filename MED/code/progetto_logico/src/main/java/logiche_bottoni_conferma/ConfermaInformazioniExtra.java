package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.SwingUtilities;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gestore_db.CreateDB;
import gestore_db.InserimentoJooq;
import gui.InserisciInformazioniFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import logiche_frame_sezioni_ospedaliere.LogicaDellaPosizionePazienteTabella;
import med_db.jooq.generated.tables.Diariamed;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaInformazioniExtra {
	
	private InserisciInformazioniFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private String motivo;
	private String storico;
	private String farmaci;
	private String reparto;
	private PazientiFrame frameDeiPazienti;
	private LogicaDellaPosizionePazienteTabella tabellaInProntoSoccorso;
	
	
	/**Classe che prende i dati passati da "ConfermaAggiungiDiariaMedica",
	 * oltre ad altri digitati nel relativo frame e li inserisce nel database
	 * @param v1 riferimento al frame per l'inserimento delle informazioni della diariaMed
	 * @param v2 riferimento al frame principale
	 * @param m riferimento al modello
	 * @param motivo dato fornito, da inserire in diariaMed
	 * @param repartoConsigliato dato fornito, da inserire in diariaMed
	 * @param storico dato fornito, da inserire in diariaMed
	 * @param farmaci dato fornito, da inserire in diariaMed
	 */
	public ConfermaInformazioniExtra(InserisciInformazioniFrame v1,  PazientiFrame v2, ModelloGestoreLogicaGenerale m, String motivo, String repartoConsigliato, String storico, String farmaci) {
		frame = v1;
		frameDeiPazienti = v2;
		this.modello = m;
		tabellaInProntoSoccorso = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti,modello,"in Pronto Soccorso");
		this.motivo=motivo;
		this.storico=storico;
		this.farmaci=farmaci;
		this.reparto = repartoConsigliato;
		start();
	}
		
	/**Una volta premuto il pulsante "conferma" nel frame di inserimento, prende i dati scritti e passati e li utilizza
	 * per eseguire un insert nella tabella diariaMed del database.
	 * Inoltre permete la chiusura della finestra, premendo la X oppure confermando l'inserimento.
	 * Alla chiusura della finestra il frame principale viene riabilitato e aggiornato (il degente viene posto nella sezione "in attesa").
	 */
	protected void start() {
		frame.confermaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				try {
					conn = DriverManager.getConnection(CreateDB.DB_URL);
					String informazioni = frame.informazioniTextArea.getText();
					DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
					Integer risultato = contesto.select(Diariamed.DIARIAMED.CODICE).from(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice())).orderBy(Diariamed.DIARIAMED.CODICE.desc()).limit(1).fetchOneInto(int.class);
					int ultimoCodice;
					if (risultato == null) {
						ultimoCodice = 0;
					}
					else {
						ultimoCodice = risultato;
					}
					SwingUtilities.invokeLater(new Runnable() {
					    @Override
					    public void run() {
							if (InserimentoJooq.getIstanza().diariaMed(ultimoCodice+1,modello.modelloGestorePaziente.getCodice(),modello.modelloGestoreUtente.getCodiceUtente(),storico,motivo,reparto,farmaci,LocalDate.now(),LocalTime.now().withNano(0),informazioni)==1) {
								modello.modelloGestorePaziente.deselezionaPaziente();
								frameDeiPazienti.updateStringaPaziente();
								tabellaInProntoSoccorso.update();
								frameDeiPazienti.updateViewTabella();
							}
							else {
								new ErroreFrame(frame.sfondoFrame, "E' avvenuto un problema durante l'aggiunta della diaria medica, se il problema persiste chiamare un tecnico");
							}
							frameDeiPazienti.sfondoFrame.setEnabled(true);
							frame.sfondoFrame.dispose();
					    }
					});
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		
		frame.sfondoFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frameDeiPazienti.sfondoFrame.setEnabled(true);
                frame.sfondoFrame.dispose();
            }
        });
	}
}
