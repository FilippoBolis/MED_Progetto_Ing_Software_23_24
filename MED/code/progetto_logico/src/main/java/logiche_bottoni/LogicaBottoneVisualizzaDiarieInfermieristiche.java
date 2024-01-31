package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_bottoni_conferma.EsciVisualizzaDiarieInfermieristiche;
import logiche_frame_sezioni_ospedaliere.LogicaDelleDiarieInfermieristicheTabella;
import modelli.ModelloGestoreLogicaGenerale;


public class LogicaBottoneVisualizzaDiarieInfermieristiche extends LogicaBottone{
	
	/** Classe che permette di aprire il frame delle visualizzazioni delle diarie infermieristiche.
	 */
	public LogicaBottoneVisualizzaDiarieInfermieristiche(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	
	/** Alla pressione del bottone verifica la selezione di un utente e la mansione dell'utilizzatore corrente (ammessi solo medico o infermiere):
	 * se tutto è in regola, attiva e compila il frame delle diarie infermieristiche, 
	 * bloccando l'interazione con il frame principale.
	 * Se qualcosa non è in linea con l'utilizzo previsto, mostra a schermo un relativo messaggio di errore
	 */
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.visualizzaDiarieInfButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (!modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
					VisualizzaDiarieInfFrame frame = new VisualizzaDiarieInfFrame(modello);
					frameDeiPazienti.sfondoFrame.setEnabled(false);
					new LogicaDelleDiarieInfermieristicheTabella(frame,modello);
					new EsciVisualizzaDiarieInfermieristiche(frame, frameDeiPazienti);
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche di privacy, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato alla visualizzazione delle diarie infermieristiche dei pazienti");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente del quale vuole visualizzare le diarie infermieristiche");
			}
			}
		});
	}
}
