package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_bottoni_conferma.EsciVisualizzaDiarieInfermieristiche;
import logiche_frame_sezioni_ospedaliere.LogicaDelleDiarieInfermieristicheTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneVisualizzaDiarieInfermieristiche extends LogicaBottone{
	
	
	public LogicaBottoneVisualizzaDiarieInfermieristiche(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
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
