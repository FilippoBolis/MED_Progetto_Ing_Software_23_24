package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import gui.InserisciDiariaFrame;
import gui.InserisciInformazioniFrame;
import gui.AssegnaPostoFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaAggiungiDiariaMedica {
	
	private InserisciDiariaFrame frameDiaria;
	private ModelloGestoreLogicaGenerale modello;
	private PazientiFrame frameDeiPazienti;
		
	public ConfermaAggiungiDiariaMedica(InserisciDiariaFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frameDeiPazienti = v2;
		frameDiaria = v1;
		modello = m;
		start();
	}
		
	protected void start() {
		frameDiaria.avantiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String motivo = frameDiaria.motivoTextField.getText();
				String storico = frameDiaria.storicoTextField.getText();
				String farmaci = frameDiaria.farmaciTextArea.getText();
				String repartoconsigliato = frameDiaria.repartoComboBox.getSelectedItem().toString();
				if(!motivo.isBlank() && !storico.isBlank() && !farmaci.isBlank()) {
					InserisciInformazioniFrame frameInformazioniExtra = new InserisciInformazioniFrame();
					ConfermaInformazioniExtra button = new ConfermaInformazioniExtra(frameInformazioniExtra,frameDeiPazienti,modello,motivo,repartoconsigliato,storico,farmaci);
					frameDiaria.sfondoFrame.dispose();
				}else {
					new ErroreFrame(frameDiaria.sfondoFrame, "Alcuni campi sono vuoti");
				}
			}
		});
	}
}
