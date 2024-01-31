package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_bottoni_conferma.ConfermaRiassegnaPaziente;
import logiche_bottoni_conferma.LogicaBottoneAggiornamentoLettiDisponibili;
import logiche_bottoni_conferma.LogicaBottoneAggiornamentoModulo;
import modelli.ModelloGestoreLogicaGenerale;


public class LogicaBottoneCambiaLetto extends LogicaBottone{
	
	/**Controller del bottone "riassegna posto letto"
	 * utilizzabile solo da un membro del personale "operatore" (mansione "S")
	 */
	public LogicaBottoneCambiaLetto(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	/**Alla pressione del bottone verifica la selezione di un utente e la mansione dell'utilizzatore corrente:
	 * se tutto è in regola delega l'operazione di assegnazione alla classe logica "confermaRiassegnaPaziente", 
	 * avviando anche i frame appositi e mostrando il reparto consigliato dal medico;
	 * se qualcosa non è in linea con l'utilizzo previsto, mostra a schermo un relativo messaggio di errore
	 */
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.spostaLettoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
					AssegnaPostoFrame frame = new AssegnaPostoFrame(modello);
					frameDeiPazienti.sfondoFrame.setEnabled(false);
					new LogicaBottoneAggiornamentoModulo(frame,modello);
					new LogicaBottoneAggiornamentoLettiDisponibili(frame,modello);
					new ConfermaRiassegnaPaziente(frame,frameDeiPazienti,modello);

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
