package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gestore_db.AggiornamentiJooq;
import gestore_db.CreateDB;
import gestore_db.InserimentoJooq;
import gui.InserisciDiariaFrame;
import gui.InserisciInfoFrame;
import gui.AssegnaPostoFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import med_db.jooq.generated.tables.Degente;
import med_db.jooq.generated.tables.Diariamed;
import med_db.jooq.generated.tables.records.DiariamedRecord;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaInformazioniExtra {
	
	private InserisciInfoFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private String motivo;
	private String storico;
	private String farmaci;
	private String reparto;
	private PazientiFrame frameDeiPazienti;
	private LogicaDellaPosizionePazienteTabella tabellaInProntoSoccorso;
		
	public ConfermaInformazioniExtra(InserisciInfoFrame v1,  PazientiFrame v2, ModelloGestoreLogicaGenerale m, String motivo, String repartoConsigliato, String storico, String farmaci) {
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
		
	protected void start() {
		frame.confermaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				try {
					conn = DriverManager.getConnection(CreateDB.DB_URL);
					String informazioni = frame.informazioniTextArea.getText();
					DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
					int ultimoCodice = contesto.select(Diariamed.DIARIAMED.CODICE).from(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice())).orderBy(Diariamed.DIARIAMED.CODICE.desc()).limit(1).fetchOneInto(int.class);
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
							frame.sfondoFrame.dispose();
					    }
					});
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
	}
}
