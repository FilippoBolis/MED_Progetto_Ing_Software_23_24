package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_bottoni_conferma.EsciVisualizzaRilevazioni;
import logiche_frame_sezioni_ospedaliere.LogicaDelleRilevazioniTabella;
import modelli.ModelloGestoreLogicaGenerale;


public class LogicaBottoneVisualizzaRilevazioni extends LogicaBottone{
	
	/** Classe che permette di aprire il frame delle visualizzazioni delle rilevazioni relative a un degente
	 */
	public LogicaBottoneVisualizzaRilevazioni(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	/**Alla pressione del bottone verifica la selezione di un utente e la mansione dell'utilizzatore corrente (ammessi solo medico o infermiere):
	 * se tutto è in regola, attiva e compila il frame delle rilevazioni, bloccando l'interazione con il frame principale.
	 * Se qualcosa non è in linea con l'utilizzo previsto, mostra a schermo un relativo messaggio di errore
	 */
	protected void start() {
		frameDeiPazienti.visualizzaRilevazioniButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (!modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
					VisualizzaRilevazioniFrame frame = new VisualizzaRilevazioniFrame(modello);
					frameDeiPazienti.sfondoFrame.setEnabled(false);
					new LogicaDelleRilevazioniTabella(frame,modello);
					new EsciVisualizzaRilevazioni(frame, frameDeiPazienti);
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche di privacy, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato alla visualizzazione delle rilevazioni dei pazienti");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente del quale vuole visualizzare le rilevazioni");
			}
			}
		});
	}
}
