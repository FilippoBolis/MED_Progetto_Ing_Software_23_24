package logiche_frame_sezioni_ospedaliere;

import javax.swing.SwingUtilities;
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
import med_db.jooq.generated.tables.Diariamed;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaDellaStringaPaziente extends LogicaFrame{
	

	int row;
	private String codice;
	private String nome;
	private String cognome;
	private String data;
	private String ora;
	private String condizione;
	
	
	public LogicaDellaStringaPaziente(PazientiFrame p, ModelloGestoreLogicaGenerale m) {
		super(p,m);
		updateStringaPaziente();
	}
	
	private void updateStringaPaziente() {
		// si registra al mouse nella tabella
		frameDeiPazienti.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			 public void valueChanged(ListSelectionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(DB_URLLOGIC);
					if (conn != null) {
						DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
						row = frameDeiPazienti.table.getSelectedRow();
						if (row >= 0) {
							codice = (String) frameDeiPazienti.table.getValueAt(row, 6);
							cognome = contesto.select(Degente.DEGENTE.COGNOME).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codice)).fetchOneInto(String.class);
						   	nome = contesto.select(Degente.DEGENTE.NOME).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codice)).fetchOneInto(String.class);
						   	data = contesto.select(Degente.DEGENTE.DATA_ARRIVO).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codice)).fetchOneInto(String.class);
						   	ora = contesto.select(Degente.DEGENTE.ORA_ARRIVO).from(Degente.DEGENTE).where(Degente.DEGENTE.CODICE.eq(codice)).fetchOneInto(String.class);
						   	if (contesto.select(Diariamed.DIARIAMED.MOTIVO).from(Degente.DEGENTE,Diariamed.DIARIAMED).where(Degente.DEGENTE.CODICE.eq(Diariamed.DIARIAMED.CODICE_DEGENTE).and(Degente.DEGENTE.CODICE.eq(codice))).execute() == 1){
						   		condizione = contesto.select(Diariamed.DIARIAMED.MOTIVO).from(Degente.DEGENTE,Diariamed.DIARIAMED).where(Degente.DEGENTE.CODICE.eq(Diariamed.DIARIAMED.CODICE_DEGENTE).and(Degente.DEGENTE.CODICE.eq(codice))).fetchOneInto(String.class);
						   	}
						   	else {
						   		condizione = "ancora da definirsi";
						   	}
						   	modello.modelloGestorePaziente.SelezionaPaziente(codice, cognome, nome, data, ora, condizione);
						   	SwingUtilities.invokeLater(new Runnable() {
								@Override
									public void run() {
										frameDeiPazienti.updateStringaPaziente();
									}
							});
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
