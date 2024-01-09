package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneInProntoSoccorso {
	
	private PazientiFrame frameDeiPazienti;
	private ModelloGestoreLogicaGenerale modello;
	private LogicaDellaPosizionePazienteTabella tabellaProntoSoccorso;
	
	public LogicaBottoneInProntoSoccorso(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prede i refs
		frameDeiPazienti = v2;
		modello = m;
		tabellaProntoSoccorso = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello,"in Pronto Soccorso");
		start();
	}
	
	private void start() {
		frameDeiPazienti.prontoSoccorsoToggleButton.setSelected(true);
		frameDeiPazienti.inCaricoToggleButton.setSelected(false);
		frameDeiPazienti.repartoToggleButton.setSelected(false);
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.prontoSoccorsoToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			frameDeiPazienti.prontoSoccorsoToggleButton.setSelected(true);
			frameDeiPazienti.inCaricoToggleButton.setSelected(false);
			frameDeiPazienti.repartoToggleButton.setSelected(false);
			frameDeiPazienti.urgenzaComboBox.setSelectedItem(" ");
			frameDeiPazienti.cercaTextField.setText("");
			tabellaProntoSoccorso.update();
			SwingUtilities.invokeLater(new Runnable() {
			@Override
				public void run() {
					frameDeiPazienti.repartoBottoniPanel.setVisible(false);
					frameDeiPazienti.prendereCaricoBottoniPanel.setVisible(false);
					frameDeiPazienti.prontoSoccorsoBottoniPanel.setVisible(true);
					frameDeiPazienti.updateViewTabella();
				}
			});
			}
		});
	}
}
