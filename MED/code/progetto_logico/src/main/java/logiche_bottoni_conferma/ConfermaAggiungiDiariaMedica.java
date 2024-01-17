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
	
	private InserisciDiariaFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private PazientiFrame frameDeiPazienti;
		
	public ConfermaAggiungiDiariaMedica(InserisciDiariaFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frameDeiPazienti = v2;
		frame = v1;
		modello = m;
		start();
	}
		
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
