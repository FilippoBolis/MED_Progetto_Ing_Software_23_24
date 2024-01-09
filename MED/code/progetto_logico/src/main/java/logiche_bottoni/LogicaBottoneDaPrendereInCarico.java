package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneDaPrendereInCarico {
	
	private PazientiFrame frameDeiPazienti;
	private ModelloGestoreLogicaGenerale modello;
	private LogicaDellaPosizionePazienteTabella tabellaInReparto;
	
	public LogicaBottoneDaPrendereInCarico(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prede i refs
		frameDeiPazienti = v2;
		modello = m;
		tabellaInReparto = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello,"in Attesa");
		start();
	}
	
	private void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.inCaricoToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			frameDeiPazienti.prontoSoccorsoToggleButton.setSelected(false);
			frameDeiPazienti.inCaricoToggleButton.setSelected(true);
			frameDeiPazienti.repartoToggleButton.setSelected(false);
			frameDeiPazienti.urgenzaComboBox.setSelectedItem(" ");
			frameDeiPazienti.cercaTextField.setText("");
			modello.modelloGestorePaziente.deselezionaPaziente();
			tabellaInReparto.update();
			SwingUtilities.invokeLater(new Runnable() {
			@Override
				public void run() {
					frameDeiPazienti.repartoBottoniPanel.setVisible(false);
					frameDeiPazienti.prontoSoccorsoBottoniPanel.setVisible(false);
					frameDeiPazienti.prendereCaricoBottoniPanel.setVisible(true);
					frameDeiPazienti.updateViewTabella();
					frameDeiPazienti.updateStringaPaziente();
				}
			});
			}
		});
	}
}
