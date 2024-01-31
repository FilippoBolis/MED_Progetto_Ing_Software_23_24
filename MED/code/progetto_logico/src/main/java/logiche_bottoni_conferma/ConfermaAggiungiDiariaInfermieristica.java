package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gestore_db.CreateDB;
import gestore_db.InserimentoJooq;
import gui.InserisciDiariaInfermieristicaFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import med_db.jooq.generated.tables.Diariainf;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaAggiungiDiariaInfermieristica {

	private InserisciDiariaInfermieristicaFrame frame;
	private PazientiFrame frameDeiPazienti;
	private ModelloGestoreLogicaGenerale modello;

	/** Classe che prende i dati digitati nel relativo frame e li inserisce nel database
	 * @param v1 riferimento al frame per l'inserimento diarieInf
	 * @param v2 riferimento al frame principale
	 * @param m riferimento al modello
	 */
	public ConfermaAggiungiDiariaInfermieristica(InserisciDiariaInfermieristicaFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frame = v1;
		frameDeiPazienti = v2;
		modello = m;
		start();
	}

	/**Una volta premuto il pulsante "conferma" nel frame di inserimento, prende i dati scritti e li utilizza
	 * per eseguire un insert nella tabella diariaInf del database.
	 * Inoltre permete la chiusura della finestra, premendo la X oppure confermando l'inserimento.
	 * Alla chiusura della finestra il frame principale viene riabilitato.
	 */
	protected void start() {
		frame.confermaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				try {
					conn = DriverManager.getConnection(CreateDB.DB_URL);
					DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
					if (!frame.farmacoTextArea.getText().isBlank()) {
						String farmaco = frame.farmacoTextArea.getText();
						String note;
						if (frame.noteTextArea.getText().isBlank()) {
							note = "Non è stata lasciata alcuna nota";
						}
						else {
							note = frame.noteTextArea.getText();
						}
						Boolean importante = frame.importanteCheckBox.isSelected();
						Integer risultato = contesto.select(Diariainf.DIARIAINF.CODICE).from(Diariainf.DIARIAINF).where(Diariainf.DIARIAINF.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice())).orderBy(Diariainf.DIARIAINF.CODICE.desc()).limit(1).fetchOneInto(int.class);
						int ultimoCodice;
						if (risultato == null) {
							ultimoCodice = 0;
						}
						else {
							ultimoCodice = risultato;
						}
						if (InserimentoJooq.getIstanza().diariaInf(ultimoCodice+1,modello.modelloGestorePaziente.getCodice(),modello.modelloGestoreUtente.getCodiceUtente(),LocalDate.now(),LocalTime.now().withNano(0),note,importante,farmaco) == 1) {
						}
						else {
							new ErroreFrame(frame.sfondoFrame, "E' avvenuto un problema nell'inserimento della diaria infermieristica, se il problema persiste chiamare un tecnico");
						}
						frameDeiPazienti.sfondoFrame.setEnabled(true);
						frame.sfondoFrame.dispose();
					}
					else {
						new ErroreFrame(frame.sfondoFrame, "Alcuni campi sono vuoti");
					}
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
