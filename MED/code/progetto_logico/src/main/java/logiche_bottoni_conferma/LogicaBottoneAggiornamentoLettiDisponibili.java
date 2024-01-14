package logiche_bottoni_conferma;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellUrgenzaPazienteTabella;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import med_db.jooq.generated.tables.Assegnazioneletto;
import med_db.jooq.generated.tables.Degente;
import med_db.jooq.generated.tables.Letto;
import med_db.jooq.generated.tables.Modulo;
import med_db.jooq.generated.tables.Reparto;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneAggiornamentoLettiDisponibili{
	
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private AssegnaPazienteFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	
	public LogicaBottoneAggiornamentoLettiDisponibili(AssegnaPazienteFrame v2, ModelloGestoreLogicaGenerale m) {
		frame = v2;
		modello = m;
		start();
	}
	
	private void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frame.moduloComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent  e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					try {
						Connection conn = DriverManager.getConnection(DB_URLLOGIC);
						List<Integer> letti = new ArrayList<>();
						String nomeReparto = (String) frame.repartoComboBox.getSelectedItem();
						String nomeModulo = (String) frame.moduloComboBox.getSelectedItem();
						if (conn != null) {
							DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
							Result<Record1<Integer>> letto = contesto
								    .select(Letto.LETTO.NUMERO)
								    .from(Letto.LETTO)
								    .leftJoin(Assegnazioneletto.ASSEGNAZIONELETTO)
								    .on(Letto.LETTO.NUMERO.eq(Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO))
								    .where(
								        Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO.isNull(),
								        Letto.LETTO.CODICE_REPARTO.eq(nomeReparto),
								        Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO.eq(nomeModulo)
								    ).orderBy(Letto.LETTO.NUMERO)
								    .fetch();
							for (Record1<Integer> lettoRecord : letto) {
							    letti.add(lettoRecord.value1());
							    System.out.println("valore: " + lettoRecord.value1());
							}
							System.out.println("valore: " + nomeModulo + nomeReparto);
							modello.modelloGestoreLogistica.setNumeroLettiDisponibili(letti);
						}
						frame.aggiornaLettiRepartoView();
					}catch (SQLException ev) {
						System.out.println(ev.getMessage());
					}	
                    
                }
			}
		});
	}
}
