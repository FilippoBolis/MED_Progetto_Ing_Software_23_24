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
import logiche_bottoni_conferma.ConfermaModificaDiariaMedica;
import med_db.jooq.generated.tables.Diariainf;
import med_db.jooq.generated.tables.Diariamed;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneModificaDiariaMedica extends LogicaBottone{
	
	
	public LogicaBottoneModificaDiariaMedica(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.modificaDiariaMedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (modello.modelloGestoreUtente.getMansioneUtente().equals("Medico")) {
					ModificaDiariaFrame frame = new ModificaDiariaFrame();
					Connection conn;
					try {
						conn = DriverManager.getConnection(CreateDB.DB_URL);
						DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
						String motivo = contesto.select(Diariamed.DIARIAMED.MOTIVO).from(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice()),Diariamed.DIARIAMED.CODICE.eq(1)).fetchOneInto(String.class);
						String storico = contesto.select(Diariamed.DIARIAMED.STORICO).from(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice()),Diariamed.DIARIAMED.CODICE.eq(1)).fetchOneInto(String.class);
						String farmaci = contesto.select(Diariamed.DIARIAMED.FARMACI).from(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice()),Diariamed.DIARIAMED.CODICE.eq(1)).fetchOneInto(String.class);
						frame.farmaciTextArea.setText(farmaci);
						frame.motivoTextField.setText(motivo);
						frame.storicoTextField.setText(storico);
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}
					ConfermaModificaDiariaMedica confermaButton = new ConfermaModificaDiariaMedica(frame,frameDeiPazienti,modello);
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato alla modifica di diarie mediche");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente del quale vuole modificare la diaria medica");
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
