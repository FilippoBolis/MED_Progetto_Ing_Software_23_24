package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import gui.AggiungiDiariaFrame;
import gui.AggiungiInfoPazienteFrame;
import gui.AssegnaPazienteFrame;
import gui.ErroreFrame;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaInformazioniExtra {
	
	private AggiungiInfoPazienteFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private String motivo;
	private String storico;
	private String farmaci;
		
	public ConfermaInformazioniExtra(AggiungiInfoPazienteFrame v1, ModelloGestoreLogicaGenerale m, String motivo, String storico, String farmaci) {
		frame = v1;
		this.motivo=motivo;
		this.storico=storico;
		this.farmaci=farmaci;
		start();
	}
		
	protected void start() {
		frame.confermaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String informazioniString = frame.informazioniTextArea.getText();
				frame.sfondoFrame.dispose();
			}
		});
	}
}
