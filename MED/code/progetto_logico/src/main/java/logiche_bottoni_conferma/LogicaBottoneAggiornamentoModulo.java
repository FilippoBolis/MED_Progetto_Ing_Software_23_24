package logiche_bottoni_conferma;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.*;
import med_db.jooq.generated.tables.Assegnazioneletto;
import med_db.jooq.generated.tables.Letto;
import med_db.jooq.generated.tables.Modulo;
import med_db.jooq.generated.tables.Reparto;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneAggiornamentoModulo{
	
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private AssegnaPostoFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	
	public LogicaBottoneAggiornamentoModulo(AssegnaPostoFrame v2, ModelloGestoreLogicaGenerale m) {
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
							Result<Record1<String>> moduli = contesto.selectDistinct(Modulo.MODULO.NOME).
							from(Modulo.MODULO, Reparto.REPARTO,Letto.LETTO).
							where(Modulo.MODULO.CODICE_REPARTO.eq(Reparto.REPARTO.CODICE),
									Reparto.REPARTO.NOME_REPARTO.eq(nomeReparto),
									Letto.LETTO.NOME_MODULO.eq(Modulo.MODULO.NOME),
									Letto.LETTO.NUMERO.notIn(contesto.select(Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO)
	        								  .from(Assegnazioneletto.ASSEGNAZIONELETTO)
	        								  .where(Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO.eq(Letto.LETTO.NUMERO),
	        										 Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO.eq(Letto.LETTO.NOME_MODULO),
	        										 Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(Letto.LETTO.CODICE_REPARTO)))).
									orderBy(Modulo.MODULO.NOME).fetch();
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
