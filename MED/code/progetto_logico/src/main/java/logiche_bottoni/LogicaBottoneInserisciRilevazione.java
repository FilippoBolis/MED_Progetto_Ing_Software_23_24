package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_bottoni_conferma.ConfermaAggiungiRilevazione;
import modelli.ModelloGestoreLogicaGenerale;


public class LogicaBottoneInserisciRilevazione extends LogicaBottone{
	
	/**Controller del bottone "inserisci prima diaria medica".
	 * Il pulsante può essere utilizzato da un medico o un'infermiere
	 */
	public LogicaBottoneInserisciRilevazione(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	/**Alla pressione del bottone verifica la selezione di un utente e la mansione dell'utilizzatore corrente:
	 * se tutto è in regola delega l'operazione di inserimento alla classe logica "ConfermaAggiungiRilevazione", 
	 * avviando anche i frame appositi.
	 * Se qualcosa non è in linea con l'utilizzo previsto, mostra a schermo un relativo messaggio di errore
	 */
	protected void start() {
		frameDeiPazienti.inserisciRilevazioneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (!modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
					InserisciRilevazioneFrame frame = new InserisciRilevazioneFrame();
					frameDeiPazienti.sfondoFrame.setEnabled(false);
					new ConfermaAggiungiRilevazione(frame,frameDeiPazienti,modello);	
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato all'aggiunta di rilevazioni");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente del quale vuole inserire la rilevazione");
			}
			}
		});
	}
}
