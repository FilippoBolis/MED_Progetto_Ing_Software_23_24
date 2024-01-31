package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_bottoni_conferma.ConfermaAggiungiDiariaInfermieristica;
import modelli.ModelloGestoreLogicaGenerale;


public class LogicaBottoneInserisciDiariaInfermieristica extends LogicaBottone{
	
	/**Controller del bottone "inserisci diaria infermieristica".
	 * Il pulsante può essere utilizzato soltanto da un infermiere
	 */
	public LogicaBottoneInserisciDiariaInfermieristica(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	/**Alla pressione del bottone verifica la selezione di un utente e la mansione dell'utilizzatore corrente:
	 * se tutto è in regola delega l'operazione di inserimento alla classe logica "ConfermaAggiungiDiariaInfermieristica", 
	 * avviando anche i frame appositi.
	 * Se qualcosa non è in linea con l'utilizzo previsto, mostra a schermo un relativo messaggio di errore
	 */
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.inserisciDiariaInfButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (modello.modelloGestoreUtente.getMansioneUtente().equals("Infermiere")) {
					InserisciDiariaInfermieristicaFrame frame = new InserisciDiariaInfermieristicaFrame();
					frameDeiPazienti.sfondoFrame.setEnabled(false);
					new ConfermaAggiungiDiariaInfermieristica(frame,frameDeiPazienti,modello);	
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato alla creazione di diarie infermieristiche");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente del quale vuole inserire la diaria infermieristica");
			}
			}
		});
	}
}
