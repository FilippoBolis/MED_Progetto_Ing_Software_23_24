package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import gui.AggiungiDiariaFrame;
import gui.AssegnaPazienteFrame;
import gui.ErroreFrame;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaAggiungiDiariaMedica {
	
		AggiungiDiariaFrame frame;
		ModelloGestoreLogicaGenerale modello;
		
		public ConfermaAggiungiDiariaMedica(AggiungiDiariaFrame v1, ModelloGestoreLogicaGenerale m) {
			frame = v1;
			start();
		}
		
		protected void start() {
			frame.avantiButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String motivo = frame.motivoTextField.getText();
					String storico = frame.storicoTextField.getText();
					if(!motivo.isBlank() && !storico.isBlank()) {
						frame.sfondoFrame.dispose();
					}else {
						new ErroreFrame(frame.sfondoFrame, "Alcuni campi sono vuoti");
					}
				}
			});
		}
}
