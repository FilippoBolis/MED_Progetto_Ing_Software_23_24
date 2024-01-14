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

public class LogicaBottoneAggiornamentoModulo{
	
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private AssegnaPazienteFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	
	public LogicaBottoneAggiornamentoModulo(AssegnaPazienteFrame v2, ModelloGestoreLogicaGenerale m) {
		frame = v2;
		modello = m;
		start();
	}
	
	private void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frame.repartoComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent  e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					try {
						Connection conn = DriverManager.getConnection(DB_URLLOGIC);
						List<String> nomi = new ArrayList<>();
						String nomeReparto = (String) frame.repartoComboBox.getSelectedItem();
						if (conn != null) {
							DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
							Result<Record1<String>> moduli = contesto.selectDistinct(Letto.LETTO.NOME_MODULO).from(Letto.LETTO,Reparto.REPARTO).leftJoin(Assegnazioneletto.ASSEGNAZIONELETTO).on(Letto.LETTO.NUMERO.eq(Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO)).where(Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO.isNull(),Letto.LETTO.CODICE_REPARTO.eq(Reparto.REPARTO.CODICE),Reparto.REPARTO.NOME_REPARTO.eq(nomeReparto)).orderBy(Letto.LETTO.NOME_MODULO).fetch();
							for (Record1<String> moduloRecord : moduli) {
							    nomi.add(moduloRecord.value1());
							}
							modello.modelloGestoreLogistica.setNomiModuli(nomi);
						}
						frame.aggiornaModuliRepartoView();
					}catch (SQLException ev) {
						System.out.println(ev.getMessage());
					}	
                    
                }
			}
		});
	}
}
