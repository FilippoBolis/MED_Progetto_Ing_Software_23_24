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
import med_db.jooq.generated.tables.Reparto;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneAggiornamentoLettiDisponibili{
	
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	private AssegnaPostoFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	
	/**Controller del filtro "Letto" all'interno dei selettori per l'inserimento di un'assegnazione di un letto;
	 * permette la visualizzazione di un letto libero all'interno del reparto e modulo selezionato.
	 * @param v2 riferimento al frame per l'assegnazione del letto
	 * @param m riferimento al modello generale
	 */
	public LogicaBottoneAggiornamentoLettiDisponibili(AssegnaPostoFrame v2, ModelloGestoreLogicaGenerale m) {
		frame = v2;
		modello = m;
		start();
	}
	
	/**Alla selezione del nome del reparto e del modulo viene eseguita una ricerca sul database
	 * per trovare i letti non assegnati;
	 * se ce ne sono, ne inserisce i numeri ordinati nel filtro di selezione.
	 */
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
							DSLContext contesto2= DSL.using(conn, SQLDialect.SQLITE);
							Result<Record1<Integer>> letto = contesto
								    .select(Letto.LETTO.NUMERO)
								    .from(Letto.LETTO,Reparto.REPARTO)
								    .where(
								    	Letto.LETTO.NOME_MODULO.eq(nomeModulo),
								        Letto.LETTO.CODICE_REPARTO.eq(Reparto.REPARTO.CODICE),
								        Reparto.REPARTO.NOME_REPARTO.eq(nomeReparto),
								        Letto.LETTO.NUMERO.notIn(contesto2.select(Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO)
								        								  .from(Assegnazioneletto.ASSEGNAZIONELETTO)
								        								  .where(Assegnazioneletto.ASSEGNAZIONELETTO.NUMERO_LETTO.eq(Letto.LETTO.NUMERO),
								        										 Assegnazioneletto.ASSEGNAZIONELETTO.NOME_MODULO.eq(Letto.LETTO.NOME_MODULO),
								        										 Assegnazioneletto.ASSEGNAZIONELETTO.CODICE_REPARTO.eq(Letto.LETTO.CODICE_REPARTO)))
								    ).orderBy(Letto.LETTO.NUMERO)
								    .fetch();
							for (Record1<Integer> lettoRecord : letto) {
							    letti.add(lettoRecord.value1());
							}
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
