package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_bottoni_conferma.ConfermaAggiungiPaziente;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneInserisciPaziente extends LogicaBottone{

	
	public LogicaBottoneInserisciPaziente(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.inserisciPazienteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("entrato");
			if (modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
				InserisciPazienteFrame frame = new InserisciPazienteFrame();
				ConfermaAggiungiPaziente confermaButton = new ConfermaAggiungiPaziente(frame,frameDeiPazienti,modello);
				
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
