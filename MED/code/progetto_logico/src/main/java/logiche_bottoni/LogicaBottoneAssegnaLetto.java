package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_bottoni_conferma.ConfermaAssegnaPaziente;
import logiche_bottoni_conferma.LogicaBottoneAggiornamentoLettiDisponibili;
import logiche_bottoni_conferma.LogicaBottoneAggiornamentoModulo;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneAssegnaLetto extends LogicaBottone{
	
	public LogicaBottoneAssegnaLetto(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.assegnaLettoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			if(modello.modelloGestorePaziente.qualcunoSelezionato()) {
				if (modello.modelloGestoreUtente.getMansioneUtente().equals("Operatore")) {
					AssegnaPostoFrame frame = new AssegnaPostoFrame(modello);
					frameDeiPazienti.sfondoFrame.setEnabled(false);
					new LogicaBottoneAggiornamentoModulo(frame,modello);
					new LogicaBottoneAggiornamentoLettiDisponibili(frame,modello);
					new ConfermaAssegnaPaziente(frame,frameDeiPazienti,modello);

				}
				else {
					new ErroreFrame(frameDeiPazienti.sfondoFrame, "Ci dispiace informarla che, secondo le nostre politiche, il suo account da " + modello.modelloGestoreUtente.getMansioneUtente() + " non è abilitato all'assegnazione di posti letto, provi a contattare il reparto di logistica");
				}
			}
			else {
				new ErroreFrame(frameDeiPazienti.sfondoFrame, "Deve selezionare prima il paziente a cui vuole assegnare un letto");
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
