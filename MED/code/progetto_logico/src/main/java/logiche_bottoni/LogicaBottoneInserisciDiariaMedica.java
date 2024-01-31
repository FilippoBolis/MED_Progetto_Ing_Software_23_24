package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_bottoni_conferma.ConfermaAggiungiDiariaMedica;
import modelli.ModelloGestoreLogicaGenerale;


public class LogicaBottoneInserisciDiariaMedica extends LogicaBottone{
	
	/**Controller del bottone "inserisci prima diaria medica".
	 * Il pulsante può essere utilizzato soltanto da un medico
	 */
	public LogicaBottoneInserisciDiariaMedica(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	/**Alla pressione del bottone verifica la selezione di un utente e la mansione dell'utilizzatore corrente:
	 * se tutto è in regola delega l'operazione di inserimento alla classe logica "ConfermaAggiungiDiariaMedica", 
	 * avviando anche i frame appositi.
	 * Se qualcosa non è in linea con l'utilizzo previsto, mostra a schermo un relativo messaggio di errore
	 */
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.inserisciDiariaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (modello.modelloGestoreUtente.getMansioneUtente().equals("Medico")) {
					InserisciDiariaFrame frame = new InserisciDiariaFrame(modello);
					frameDeiPazienti.sfondoFrame.setEnabled(false);
					new ConfermaAggiungiDiariaMedica(frame,frameDeiPazienti,modello);
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato alla creazione di diarie mediche");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente del quale vuole inserire la diaria medica");
			}
			}
		});
	}
}
