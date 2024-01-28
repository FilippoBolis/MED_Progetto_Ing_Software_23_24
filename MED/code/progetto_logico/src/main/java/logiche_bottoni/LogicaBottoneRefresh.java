package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import logiche_frame_sezioni_ospedaliere.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

/** Classe controller per il pulsante refresh.
 *  Questo pulsante può essere utilizzato qualora il sistema non si aggiorni correttamente
 *  dopo l'inserimento/la rimozione di dati sul database.
 */
public class LogicaBottoneRefresh extends LogicaBottone{
	
	private LogicaDellaPosizionePazienteTabella tabellaProntoSoccorso;
	
	public LogicaBottoneRefresh(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	/** Alla pressione del pulsante viene deselezionato il degente selezionato(se ce n'è uno) 
	 *  per poi ricaricare la tabella con i dati aggiornati del database.
	 */
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
