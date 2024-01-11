package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.AssegnaPazienteFrame;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaAssegnaPaziente {
	
		AssegnaPazienteFrame frame;
		ModelloGestoreLogicaGenerale modello;
		
		public ConfermaAssegnaPaziente(AssegnaPazienteFrame v1, ModelloGestoreLogicaGenerale m) {
			frame = v1;
			start();
		}
		
		protected void start() {
			frame.confermaButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					frame.sfondoFrame.dispose();
				}
			});
		}
}
