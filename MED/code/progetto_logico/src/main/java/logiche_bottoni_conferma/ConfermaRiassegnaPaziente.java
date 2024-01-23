package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.SwingUtilities;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gestore_db.CreateDB;
import gestore_db.InserimentoJooq;
import gestore_db.RimozioneJooq;
import gui.AssegnaPostoFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import med_db.jooq.generated.tables.Assegnazioneletto;
import med_db.jooq.generated.tables.Reparto;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaRiassegnaPaziente {

	private AssegnaPostoFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private PazientiFrame frameDeiPazienti;
	private LogicaDellaPosizionePazienteTabella tabellaInAttesa;

	public ConfermaRiassegnaPaziente(AssegnaPostoFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frame = v1;
		frameDeiPazienti = v2;
		modello = m;
		tabellaInAttesa = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti,modello,"in Reparto");
		start();
	}

	protected void start() {
		frame.confermaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				try {
					int letto;
					conn = DriverManager.getConnection(CreateDB.DB_URL);
					String nomeReparto = (String) frame.repartoComboBox.getSelectedItem();
					String modulo = (String) frame.moduloComboBox.getSelectedItem();
					if ((Integer) frame.postoComboBox.getSelectedItem() != null) {
						letto = ((Integer) frame.postoComboBox.getSelectedItem()).intValue();
					}
					else {
						letto = 0;
					}
					DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
					conn = DriverManager.getConnection(CreateDB.DB_URL);
					String codiceReparto = contesto.select(Reparto.REPARTO.CODICE).from(Reparto.REPARTO).where(Reparto.REPARTO.NOME_REPARTO.eq(nomeReparto)).fetchOneInto(String.class);
					String codiceRepartoOld = contesto.select(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO).from(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice())).fetchOneInto(String.class);
					String moduloOld = contesto.select(Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO).from(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice())).fetchOneInto(String.class);
					Integer lettoOld = contesto.select(Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO).from(Assegnazioneletto.ASSEGNAZIONELETTO).where(Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice())).fetchOneInto(Integer.class);
					if (!nomeReparto.equals(" ") && !modulo.equals(" ") && letto != 0) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override
						    public void run() {
								if (InserimentoJooq.getIstanza().assegnazioneLetto(modello.modelloGestorePaziente.getCodice(),codiceReparto,modulo,letto,LocalDate.now())==1) {
									RimozioneJooq.getIstanza().assegnazioneLetto(modello.modelloGestorePaziente.getCodice(), codiceRepartoOld, moduloOld, lettoOld);
									modello.modelloGestorePaziente.deselezionaPaziente();
									frameDeiPazienti.updateStringaPaziente();
									tabellaInAttesa.update();
									frameDeiPazienti.updateViewTabella();
								}
								else {
									new ErroreFrame(frame.sfondoFrame, "E' avvenuto un problema durante l'assegnazione del posto letto, se il problema persiste chiamare un tecnico");
								}
								frameDeiPazienti.sfondoFrame.setEnabled(true);
								frame.sfondoFrame.dispose();
						    }
						});
					}
					else {
						new ErroreFrame(frame.sfondoFrame, "Alcuni campi sono vuoti");
					}
				}catch (SQLException e1) {
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
}}
