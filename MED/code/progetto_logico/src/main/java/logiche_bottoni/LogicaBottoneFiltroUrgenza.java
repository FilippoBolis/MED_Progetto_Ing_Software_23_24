package logiche_bottoni;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import gui.*;
import logiche_frame_pronto_soccorso.LogicaDellUrgenzaPazienteTabella;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneFiltroUrgenza extends LogicaBottone{
	
	private LogicaDellUrgenzaPazienteTabella tabellaFiltrataUrgenza;
	private LogicaDellaPosizionePazienteTabella tabellaPosizioneNonFiltrata;
	private String opzione;
	
	public LogicaBottoneFiltroUrgenza(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.urgenzaComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent  e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					modello.modelloGestorePaziente.deselezionaPaziente();
					frameDeiPazienti.updateStringaPaziente();
					opzione = (String) frameDeiPazienti.urgenzaComboBox.getSelectedItem();
                    switch(opzione) {
                    	case "Rosso":
                    		tabellaFiltrataUrgenza = new LogicaDellUrgenzaPazienteTabella(frameDeiPazienti, modello,"rosso");
                        	tabellaFiltrataUrgenza.update();
                        	break;
                    	case "Giallo":
                    		tabellaFiltrataUrgenza = new LogicaDellUrgenzaPazienteTabella(frameDeiPazienti, modello,"giallo");
                        	tabellaFiltrataUrgenza.update();
                        	break;
                    	case "Verde":
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
				frameDeiPazienti.repartoComboBox.setSelectedItem(" ");
			}
		});
	}
}
