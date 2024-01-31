package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.InserisciDiariaFrame;
import gui.InserisciInformazioniFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaAggiungiDiariaMedica {
	
	private InserisciDiariaFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private PazientiFrame frameDeiPazienti;
	
	/** Classe che prende i dati digitati nel relativo frame e li fornisce alla classe
	 * "ConfermaInformazioniExtra".
	 * @param v1 riferimento al frame per l'inserimento diarieMed
	 * @param v2 riferimento al frame principale
	 * @param m riferimento al modello
	 */
	public ConfermaAggiungiDiariaMedica(InserisciDiariaFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frameDeiPazienti = v2;
		frame = v1;
		modello = m;
		start();
	}
	
	/**Una volta premuto il pulsante "conferma" nel frame di inserimento, prende i dati scritti e delega
	 * il loro inserimento nel database alla classe logica "ConfermaInformazioniExtra".
	 * Inoltre permete la chiusura della finestra, premendo la X.
	 * Alla chiusura della finestra il frame principale viene riabilitato.
	 */
	protected void start() {
		frame.avantiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String motivo = frame.motivoTextField.getText();
				String storico = frame.storicoTextField.getText();
				String farmaci = frame.farmaciTextArea.getText();
				String repartoconsigliato = frame.repartoComboBox.getSelectedItem().toString();
				if(!motivo.isBlank() && !storico.isBlank() && !farmaci.isBlank()) {
					InserisciInformazioniFrame frameInformazioniExtra = new InserisciInformazioniFrame();
					new ConfermaInformazioniExtra(frameInformazioniExtra,frameDeiPazienti,modello,motivo,repartoconsigliato,storico,farmaci);
					frameDeiPazienti.sfondoFrame.setEnabled(true);
					frame.sfondoFrame.dispose();
				}else {
					new ErroreFrame(frame.sfondoFrame, "Alcuni campi sono vuoti");
				}
			}
		});
		
		frame.sfondoFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frameDeiPazienti.sfondoFrame.setEnabled(true);
                frame.sfondoFrame.dispose();
            }
        });
	}
}
