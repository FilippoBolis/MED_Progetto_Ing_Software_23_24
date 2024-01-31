package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gestore_db.CreateDB;
import gui.*;
import logiche_bottoni_conferma.EsciVisualizzaInformazioni;
import med_db.jooq.generated.tables.Diariamed;
import modelli.ModelloGestoreLogicaGenerale;


public class LogicaBottoneVisualizzaInformazioni extends LogicaBottone{
	
	/** Classe che permette di aprire il frame delle visualizzazioni delle informazioni relative a un degente
	 */
	public LogicaBottoneVisualizzaInformazioni(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	/**Alla pressione del bottone verifica la selezione di un utente e la mansione dell'utilizzatore corrente (ammessi solo medico o infermiere):
	 * se tutto è in regola, attiva e compila il frame delle informazioni mediche (nel database indicate sotto il nome di "allergie"),
	 * bloccando l'interazione con il frame principale.
	 * Se qualcosa non è in linea con l'utilizzo previsto, mostra a schermo un relativo messaggio di errore
	 */
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.visualizzaInformazioniButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (!modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
					VisualizzaInformazioniFrame frame = new VisualizzaInformazioniFrame();
					new EsciVisualizzaInformazioni(frame, frameDeiPazienti);
					Connection conn;
					try {
						conn = DriverManager.getConnection(CreateDB.DB_URL);
						DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
						String informazioni = contesto.select(Diariamed.DIARIAMED.ALLERGIE).from(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice()),Diariamed.DIARIAMED.CODICE.eq(1)).fetchOneInto(String.class);
						frame.infoTextArea.setText(informazioni);
						frame.setPersonaView(modello.modelloGestorePaziente.getNome() + " " + modello.modelloGestorePaziente.getCognome());
						frameDeiPazienti.sfondoFrame.setEnabled(false);
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche di privacy, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato alla visualizzazione delle informazioni mediche dei pazienti");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente del quale vuole visualizzare le informazioni");
			}
			}
		});
	}
}
