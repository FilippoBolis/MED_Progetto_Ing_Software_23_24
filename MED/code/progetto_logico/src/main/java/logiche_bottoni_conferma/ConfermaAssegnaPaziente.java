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
import gui.AssegnaPazienteFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import med_db.jooq.generated.tables.Diariamed;
import med_db.jooq.generated.tables.Reparto;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaAssegnaPaziente {

	private AssegnaPazienteFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private PazientiFrame frameDeiPazienti;
	private LogicaDellaPosizionePazienteTabella tabellaInAttesa;

	public ConfermaAssegnaPaziente(AssegnaPazienteFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frame = v1;
		frameDeiPazienti = v2;
		modello = m;
		tabellaInAttesa = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti,modello,"in Attesa");
		start();
	}

	protected void start() {
		frame.confermaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				try {
					conn = DriverManager.getConnection(CreateDB.DB_URL);
					String nomeReparto = (String) frame.repartoComboBox.getSelectedItem();
					String modulo = (String) frame.moduloComboBox.getSelectedItem();
					int letto = (int) frame.postoComboBox.getSelectedItem();
					DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
					conn = DriverManager.getConnection(CreateDB.DB_URL);
					String codiceReparto = contesto.select(Reparto.REPARTO.CODICE).from(Reparto.REPARTO).where(Reparto.REPARTO.NOME_REPARTO.eq(nomeReparto)).fetchOneInto(String.class);
					SwingUtilities.invokeLater(new Runnable() {
					    @Override
					    public void run() {
					    	System.out.println(modello.modelloGestorePaziente.getCodice());
							if (InserimentoJooq.getIstanza().assegnazioneLetto(modello.modelloGestorePaziente.getCodice(),codiceReparto,modulo,letto,LocalDate.now())==1) {
								modello.modelloGestorePaziente.deselezionaPaziente();
								frameDeiPazienti.updateStringaPaziente();
								tabellaInAttesa.update();
								frameDeiPazienti.updateViewTabella();
							}
							else {
								new ErroreFrame(frame.sfondoFrame, "E' avvenuto un problema durante l'assegnazione del posto letto, se il problema persiste chiamare un tecnico");
							}
							frame.sfondoFrame.dispose();
					    }
					});
				}catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
}}
