package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gestore_db.CreateDB;
import gui.*;
import med_db.jooq.generated.tables.Diariamed;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneVisualizzaFarmaci extends LogicaBottone{
	
	
	public LogicaBottoneVisualizzaFarmaci(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.visualizzaFarmaciButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (!modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
					VisualizzaFarmaciFrame frame = new VisualizzaFarmaciFrame();
					Connection conn;
					try {
						conn = DriverManager.getConnection(CreateDB.DB_URL);
						DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
						String farmaci = contesto.select(Diariamed.DIARIAMED.FARMACI).from(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice()),Diariamed.DIARIAMED.CODICE.eq(1)).fetchOneInto(String.class);
						frame.farmaciTextArea.setText(farmaci);
						frame.setPersonaView(modello.modelloGestorePaziente.getNome() + " " + modello.modelloGestorePaziente.getCognome());
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche di privacy, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato alla visualizzazione dei farmaci prescritti ai pazienti");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente del quale vuole visualizzare i farmaci prescritti");
			}
			SwingUtilities.invokeLater(new Runnable() {
			@Override
				public void run() {
					
				}
			});
			}
		});
	}
}
