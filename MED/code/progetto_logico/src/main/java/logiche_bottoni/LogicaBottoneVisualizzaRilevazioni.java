package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_bottoni_conferma.EsciVisualizzaRilevazioni;
import logiche_frame_pronto_soccorso.LogicaDelleRilevazioniTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneVisualizzaRilevazioni extends LogicaBottone{
	
	
	public LogicaBottoneVisualizzaRilevazioni(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
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
