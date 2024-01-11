package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneInReparto extends LogicaBottone{
	
	private LogicaDellaPosizionePazienteTabella tabellaInReparto;
	
	public LogicaBottoneInReparto(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		tabellaInReparto = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello,"in Reparto");
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.repartoToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			frameDeiPazienti.prontoSoccorsoToggleButton.setSelected(false);
			frameDeiPazienti.inCaricoToggleButton.setSelected(false);
			frameDeiPazienti.repartoToggleButton.setSelected(true);
			frameDeiPazienti.urgenzaComboBox.setSelectedItem(" ");
			frameDeiPazienti.cercaTextField.setText("");
			modello.modelloGestorePaziente.deselezionaPaziente();
			tabellaInReparto.update();
			SwingUtilities.invokeLater(new Runnable() {
			@Override
				public void run() {
					frameDeiPazienti.prendereCaricoBottoniPanel.setVisible(false);
					frameDeiPazienti.prontoSoccorsoBottoniPanel.setVisible(false);
					frameDeiPazienti.repartoBottoniPanel.setVisible(true);
					frameDeiPazienti.updateViewTabella();
					frameDeiPazienti.updateStringaPaziente();
				}
			});
			}
		});
	}
}
