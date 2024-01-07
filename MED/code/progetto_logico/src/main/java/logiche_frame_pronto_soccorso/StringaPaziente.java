package logiche_frame_pronto_soccorso;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.PazientiFrame;
import med_db.jooq.generated.tables.Degente;
import modelli.ModelloGestoreLogicaGenerale;

public class StringaPaziente {
	
	private PazientiFrame prontoSoccorso;
	private ModelloGestoreLogicaGenerale modello;
	private static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	private static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	int row;
	private String codice;
	private String nome;
	private String cognome;
	private String sesso;
	
	
	public void updateStringaPaziente() {
		// si registra al mouse nella tabella
		prontoSoccorso.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			 public void valueChanged(ListSelectionEvent e) {
				System.out.println("entrato");
				try {
					Connection conn = DriverManager.getConnection(DB_URLLOGIC);
					if (conn != null) {
						DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
						row = prontoSoccorso.table.getSelectedRow();
						if (row >= 0) {
							codice = (String) prontoSoccorso.table.getValueAt(row, 6);
							cognome = contesto.select(Degente.DEGENTE.COGNOME).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codice)).fetchOneInto(String.class);
						   	nome = contesto.select(Degente.DEGENTE.NOME).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codice)).fetchOneInto(String.class);
						   	sesso = contesto.select(Degente.DEGENTE.SESSO).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codice)).fetchOneInto(String.class);
						   	modello.modelloGestoreStringaPaziente.setDatiPaziente(codice, cognome, nome, sesso);
						}
					}
				}
				catch (SQLException ev) {
					System.out.println(ev.getMessage());
				}	
			}
		});
	}
}
