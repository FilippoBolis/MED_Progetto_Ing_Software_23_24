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
import gui.AssegnaPostoFrame;
import gui.InserisciDiariaInfermieristicaFrame;
import gui.DimettiPazienteFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import med_db.jooq.generated.tables.Diariainf;
import med_db.jooq.generated.tables.Diariamed;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaAggiungiDiariaInfermieristica {

	private InserisciDiariaInfermieristicaFrame frame;
	private PazientiFrame frameDeiPazienti;
	private ModelloGestoreLogicaGenerale modello;

	public ConfermaAggiungiDiariaInfermieristica(InserisciDiariaInfermieristicaFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
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
							modello.modelloGestorePaziente.deselezionaPaziente();
							frameDeiPazienti.updateStringaPaziente();
						}
						else {
							new ErroreFrame(frame.sfondoFrame, "E' avvenuto un problema nell'inserimento della diaria infermieristica, se il problema persiste chiamare un tecnico");
						}
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
	}
}
