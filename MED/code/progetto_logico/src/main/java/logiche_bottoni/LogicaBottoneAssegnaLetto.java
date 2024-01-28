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
import logiche_bottoni_conferma.ConfermaAssegnaPaziente;
import logiche_bottoni_conferma.LogicaBottoneAggiornamentoLettiDisponibili;
import logiche_bottoni_conferma.LogicaBottoneAggiornamentoModulo;
import med_db.jooq.generated.tables.Diariamed;
import modelli.ModelloGestoreLogicaGenerale;

/**Controller del bottone "assegna letto", utilizzabile solo da un membro del personale "operatore" (mansione "S")
 */
public class LogicaBottoneAssegnaLetto extends LogicaBottone{
	
	public LogicaBottoneAssegnaLetto(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	/**Alla pressione del bottone verifica la selezione di un utente e la mansione dell'utilizzatore corrente:
	 * se tutto è in regola delega l'operazione di assegnazione alla classe logica "confermaAssegnaPaziente", 
	 * avviando anche i frame appositi e mostrando il reparto consigliato dal medico;
	 * se qualcosa non è in linea con l'utilizzo previsto, mostra a schermo un relativo messaggio di errore
	 */
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.assegnaLettoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
					AssegnaPostoFrame frame = new AssegnaPostoFrame(modello);
					frameDeiPazienti.sfondoFrame.setEnabled(false);
					new LogicaBottoneAggiornamentoModulo(frame,modello);
					new LogicaBottoneAggiornamentoLettiDisponibili(frame,modello);
					new ConfermaAssegnaPaziente(frame,frameDeiPazienti,modello);
					Connection conn;
					try {
						conn = DriverManager.getConnection(CreateDB.DB_URL);
						DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
						String repartoConsigliato = contesto.select(Diariamed.DIARIAMED.REPARTO_CONSIGLIATO).from(Diariamed.DIARIAMED).where(Diariamed.DIARIAMED.CODICE_DEGENTE.eq(modello.modelloGestorePaziente.getCodice()),Diariamed.DIARIAMED.CODICE.eq(1)).fetchOneInto(String.class);
						frame.aggiornaRepartoView("Il medico consiglia il reparto: " + repartoConsigliato);
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}

				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato all'assegnazione di posti letto, provi a contattare il reparto di logistica");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente a cui vuole assegnare un letto");
			}
			}
		});
	}
}
