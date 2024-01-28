package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_frame_sezioni_ospedaliere.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;


/**Logica del pulsante di selezione della sezione dell'ospedale "da prendere in carico"
 */
public class LogicaBottoneDaPrendereInCarico extends LogicaBottone{
	
	private LogicaDellaPosizionePazienteTabella tabellaInReparto;
	
	public LogicaBottoneDaPrendereInCarico(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		tabellaInReparto = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello,"in Attesa");
		start();
	}
	
	/**Alla selezione della sezione, vengono sostituiti i pulsanti laterali 
	 * e viene mostrata a schermo la lista dei degenti da prendere in carico
	 */
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.inCaricoToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			frameDeiPazienti.prontoSoccorsoToggleButton.setSelected(false);
			frameDeiPazienti.inCaricoToggleButton.setSelected(true);
			frameDeiPazienti.repartoToggleButton.setSelected(false);
			frameDeiPazienti.urgenzaComboBox.setSelectedItem(" ");
			frameDeiPazienti.cercaTextField.setText("");
			frameDeiPazienti.repartoComboBox.setSelectedItem(" ");
			modello.modelloGestorePaziente.deselezionaPaziente();
			tabellaInReparto.update();
			SwingUtilities.invokeLater(new Runnable() {
			@Override
				public void run() {
					frameDeiPazienti.repartoComboBox.setVisible(false);
					frameDeiPazienti.repartoLabel.setVisible(false);
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
