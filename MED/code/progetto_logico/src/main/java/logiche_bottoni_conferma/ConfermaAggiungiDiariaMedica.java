package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import gui.AggiungiDiariaFrame;
import gui.AggiungiInfoPazienteFrame;
import gui.AssegnaPazienteFrame;
import gui.ErroreFrame;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaAggiungiDiariaMedica {
	
	private AggiungiDiariaFrame frameDiaria;
	private ModelloGestoreLogicaGenerale modello;
		
	public ConfermaAggiungiDiariaMedica(AggiungiDiariaFrame v1, ModelloGestoreLogicaGenerale m) {
		frameDiaria = v1;
		start();
	}
		
	protected void start() {
		frameDiaria.avantiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String motivo = frameDiaria.motivoTextField.getText();
				String storico = frameDiaria.storicoTextField.getText();
				String farmaci = frameDiaria.farmaciTextArea.getText();
				if(!motivo.isBlank() && !storico.isBlank() && !farmaci.isBlank()) {
					AggiungiInfoPazienteFrame frameInformazioniExtra = new AggiungiInfoPazienteFrame();
					ConfermaInformazioniExtra button = new ConfermaInformazioniExtra(frameInformazioniExtra,modello,motivo,storico,farmaci);
					frameDiaria.sfondoFrame.dispose();
				}else {
					new ErroreFrame(frameDiaria.sfondoFrame, "Alcuni campi sono vuoti");
				}
			}
		});
	}
}
