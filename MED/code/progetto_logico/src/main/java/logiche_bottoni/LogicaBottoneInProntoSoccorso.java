package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_frame_sezioni_ospedaliere.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneInProntoSoccorso extends LogicaBottone{
	
	private LogicaDellaPosizionePazienteTabella tabellaProntoSoccorso;
	
	public LogicaBottoneInProntoSoccorso(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		tabellaProntoSoccorso = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello,"in Pronto Soccorso");
		start();
	}
	
	protected void start() {
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
			frameDeiPazienti.repartoComboBox.setSelectedItem(" ");
			modello.modelloGestorePaziente.deselezionaPaziente();
			tabellaProntoSoccorso.update();
			SwingUtilities.invokeLater(new Runnable() {
			@Override
				public void run() {
					frameDeiPazienti.repartoComboBox.setVisible(false);
					frameDeiPazienti.repartoLabel.setVisible(false);
					frameDeiPazienti.repartoBottoniPanel.setVisible(false);
					frameDeiPazienti.prendereCaricoBottoniPanel.setVisible(false);
					frameDeiPazienti.prontoSoccorsoBottoniPanel.setVisible(true);
					frameDeiPazienti.updateViewTabella();
					frameDeiPazienti.updateStringaPaziente();
				}
			});
			}
		});
	}
}
