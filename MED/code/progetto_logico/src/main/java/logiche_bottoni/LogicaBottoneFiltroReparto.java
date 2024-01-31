package logiche_bottoni;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import gui.*;
import logiche_frame_sezioni_ospedaliere.LogicaDelReparto;
import logiche_frame_sezioni_ospedaliere.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneFiltroReparto extends LogicaBottone{
	
	private LogicaDelReparto tabellaReparto;
	private LogicaDellaPosizionePazienteTabella tabellaPosizioneNonFiltrata;
	private String opzione;
	
	/**Filtro che permette la ricerca dei degenti attraverso il reparto in cui sono situati.
	 */
	public LogicaBottoneFiltroReparto(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	/**Alla selezione di un campo della tendina vengono selezionati e mostrati all'utente 
	 *solo i degenti situati in tale reparto.
	 *Se viene selezionato il riquadro vuoto la selezione viene annullata e vengono posti a schermo
	 *i dati di tutti i degenti nella sezione.
	 */
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
				frameDeiPazienti.urgenzaComboBox.setSelectedItem(" ");
			}
		});
	}
}
