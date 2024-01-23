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
import gestore_db.RimozioneJooq;
import gui.InserisciPazienteFrame;
import gui.InserisciRilevazioneFrame;
import gui.AssegnaPostoFrame;
import gui.InserisciDiariaInfermieristicaFrame;
import gui.DimettiPazienteFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import med_db.jooq.generated.tables.Diariainf;
import med_db.jooq.generated.tables.Diariamed;
import med_db.jooq.generated.tables.Rilevazione;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaAggiungiRilevazione {

	private InserisciRilevazioneFrame frame;
	private PazientiFrame frameDeiPazienti;
	private ModelloGestoreLogicaGenerale modello;

	public ConfermaAggiungiRilevazione(InserisciRilevazioneFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frame = v1;
		frameDeiPazienti = v2;
		modello = m;
		start();
	}

	protected void start() {
		frame.confermaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				try {
					conn = DriverManager.getConnection(CreateDB.DB_URL);
					DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
					if (!frame.glicemiaTextField.getText().isBlank() && !frame.doloreTextField.getText().isBlank() && !frame.temperaturaTextField.getText().isBlank() && !frame.pressioneMaxTextField.getText().isBlank() && !frame.frequenzaTextField.getText().isBlank() && !frame.pressioneMinTextField.getText().isBlank()) {
						int glicemia = Integer.parseInt(frame.glicemiaTextField.getText());
						Double temperatura = Double.parseDouble(frame.temperaturaTextField.getText());
						int pressioneMax = Integer.parseInt(frame.pressioneMaxTextField.getText());
						int pressioneMin = Integer.parseInt(frame.pressioneMinTextField.getText());
						int frequenza = Integer.parseInt(frame.frequenzaTextField.getText());
						int dolore = Integer.parseInt(frame.doloreTextField.getText());
						Integer risultato = contesto.select(Rilevazione.RILEVAZIONE.ID).from(Rilevazione.RILEVAZIONE).where(Rilevazione.RILEVAZIONE.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice())).orderBy(Rilevazione.RILEVAZIONE.ID.desc()).limit(1).fetchOneInto(int.class);
						int ultimoCodice;
						if (risultato == null) {
							ultimoCodice = 0;
						}
						else {
							ultimoCodice = risultato;
						}
						if ((InserimentoJooq.getIstanza().rilevazione(ultimoCodice+1,modello.modelloGestorePaziente.getCodice(),modello.modelloGestoreUtente.getCodiceUtente(), temperatura,pressioneMax,pressioneMin,glicemia, LocalDate.now(),LocalTime.now().withNano(0),frequenza,dolore)) == 1) {
						}
						else {
							new ErroreFrame(frame.sfondoFrame, "E' avvenuto un problema nell'inserimento della rilevazione, se il problema persiste chiamare un tecnico");
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
