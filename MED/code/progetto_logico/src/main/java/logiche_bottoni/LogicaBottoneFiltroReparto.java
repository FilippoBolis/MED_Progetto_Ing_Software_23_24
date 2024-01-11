package logiche_bottoni;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDelReparto;
import logiche_frame_pronto_soccorso.LogicaDellUrgenzaPazienteTabella;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneFiltroReparto extends LogicaBottone{
	
	private LogicaDelReparto tabellaReparto;
	private LogicaDellaPosizionePazienteTabella tabellaPosizioneNonFiltrata;
	private String opzione;
	
	public LogicaBottoneFiltroReparto(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.repartoComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent  e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					modello.modelloGestorePaziente.deselezionaPaziente();
					frameDeiPazienti.updateStringaPaziente();
					opzione = (String) frameDeiPazienti.repartoComboBox.getSelectedItem();
					if (!opzione.isBlank()) {
						tabellaReparto = new LogicaDelReparto(frameDeiPazienti, modello, opzione);
						tabellaReparto.update();
					}
					else {
	                    tabellaPosizioneNonFiltrata = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello, frameDeiPazienti.posizioneAttuale);
	                    tabellaPosizioneNonFiltrata.update();
					}
                }
				frameDeiPazienti.cercaTextField.setText("");
				SwingUtilities.invokeLater(new Runnable() {
					@Override
				public void run() {
					frameDeiPazienti.updateViewTabella();
				}
				});
			}
		});
	}
}
