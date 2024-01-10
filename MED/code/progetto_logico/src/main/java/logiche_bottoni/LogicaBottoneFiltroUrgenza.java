package logiche_bottoni;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellUrgenzaPazienteTabella;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneFiltroUrgenza {
	
	private PazientiFrame frameDeiPazienti;
	private ModelloGestoreLogicaGenerale modello;
	private LogicaDellUrgenzaPazienteTabella tabellaFiltrataUrgenza;
	private LogicaDellaPosizionePazienteTabella tabellaPosizioneNonFiltrata;
	private String opzione;
	
	public LogicaBottoneFiltroUrgenza(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prede i refs
		frameDeiPazienti = v2;
		modello = m;
		start();
	}
	
	private void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.urgenzaComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent  e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					modello.modelloGestorePaziente.deselezionaPaziente();
					frameDeiPazienti.updateStringaPaziente();
					opzione = (String) frameDeiPazienti.urgenzaComboBox.getSelectedItem();
                    switch(opzione) {
                    	case "ROSSO":
                    		tabellaFiltrataUrgenza = new LogicaDellUrgenzaPazienteTabella(frameDeiPazienti, modello,"rosso");
                        	tabellaFiltrataUrgenza.update();
                        	break;
                    	case "GIALLO":
                    		tabellaFiltrataUrgenza = new LogicaDellUrgenzaPazienteTabella(frameDeiPazienti, modello,"giallo");
                        	tabellaFiltrataUrgenza.update();
                        	break;
                    	case "VERDE":
                    		tabellaFiltrataUrgenza = new LogicaDellUrgenzaPazienteTabella(frameDeiPazienti, modello,"verde");
                    		tabellaFiltrataUrgenza.update();
                    		break;
                    	default:
                    		tabellaPosizioneNonFiltrata = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti, modello, frameDeiPazienti.posizioneAttuale);
                    		tabellaPosizioneNonFiltrata.update();
                    		break;
                    		
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
