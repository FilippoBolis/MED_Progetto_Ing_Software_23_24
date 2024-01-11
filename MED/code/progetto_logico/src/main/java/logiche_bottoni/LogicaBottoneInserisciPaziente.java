package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneInserisciPaziente extends LogicaBottone{

	
	public LogicaBottoneInserisciPaziente(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.inserisciPazienteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if (modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
				//per ora vuoto
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato all'inserimento di nuovi degenti, provi a contattare il reparto di logistica");
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
