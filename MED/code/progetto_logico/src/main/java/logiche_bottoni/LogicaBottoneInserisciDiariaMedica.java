package logiche_bottoni;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_bottoni_conferma.ConfermaAggiungiDiariaMedica;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneInserisciDiariaMedica extends LogicaBottone{
	
	
	public LogicaBottoneInserisciDiariaMedica(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.inserisciDiariaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (modello.modelloGestoreUtente.getMansioneUtente().equals("Medico")) {
					AggiungiDiariaFrame frame = new AggiungiDiariaFrame(modello);
					ConfermaAggiungiDiariaMedica button = new ConfermaAggiungiDiariaMedica(frame,frameDeiPazienti,modello);
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato alla creazione di diarie mediche");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente del quale vuole inserire la diaria medica");
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
