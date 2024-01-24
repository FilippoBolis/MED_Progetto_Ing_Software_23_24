package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_bottoni_conferma.ConfermaDimettiPaziente;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneDimetti extends LogicaBottone{
	
	
	public LogicaBottoneDimetti(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.dimettiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (modello.modelloGestoreUtente.getMansioneUtente().equals("Medico")) {
					frameDeiPazienti.sfondoFrame.setEnabled(false);
					DimettiPazienteFrame frame = new DimettiPazienteFrame();
					new ConfermaDimettiPaziente(frame,frameDeiPazienti,modello);
					
				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato alla dimissione, contatti un Medico per procedere");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente che vuole dimettere");
			}
			}
		});
	}
}
