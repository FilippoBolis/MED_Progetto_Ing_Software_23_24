package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneRefresh extends LogicaBottone{
	
	private LogicaDellaPosizionePazienteTabella tabellaProntoSoccorso;
	
	public LogicaBottoneRefresh(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.indietroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			modello.modelloGestorePaziente.deselezionaPaziente();
			frameDeiPazienti.updateStringaPaziente();
			tabellaProntoSoccorso = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello,frameDeiPazienti.posizioneAttuale);
			tabellaProntoSoccorso.update();
			frameDeiPazienti.urgenzaComboBox.setSelectedItem(" ");
			frameDeiPazienti.cercaTextField.setText("");
			}
		});
	}
}
