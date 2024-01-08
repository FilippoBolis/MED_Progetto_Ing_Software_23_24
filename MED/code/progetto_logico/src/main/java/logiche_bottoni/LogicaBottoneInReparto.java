package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneInReparto {
	
	private PazientiFrame frameDeiPazienti;
	private ModelloGestoreLogicaGenerale modello;
	private LogicaDellaPosizionePazienteTabella tabellaInReparto;
	
	public LogicaBottoneInReparto(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prede i refs
		frameDeiPazienti = v2;
		modello = m;
		tabellaInReparto = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello,"in Reparto");
		start();
	}
	
	private void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.repartoToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			frameDeiPazienti.urgenzaComboBox.setSelectedItem(" ");
			tabellaInReparto.update();
			SwingUtilities.invokeLater(new Runnable() {
			@Override
				public void run() {
					frameDeiPazienti.updateViewTabellaProntoSoccorso();
				}
			});
			}
		});
	}
}
