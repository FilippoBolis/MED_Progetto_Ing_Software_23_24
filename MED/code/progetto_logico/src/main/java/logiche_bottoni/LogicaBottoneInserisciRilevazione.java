package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_bottoni_conferma.ConfermaAggiungiDiariaInfermieristica;
import logiche_bottoni_conferma.ConfermaAggiungiRilevazione;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneInserisciRilevazione extends LogicaBottone{
	
	
	public LogicaBottoneInserisciRilevazione(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
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
			SwingUtilities.invokeLater(new Runnable() {
			@Override
				public void run() {
					
				}
			});
			}
		});
	}
}
