package eseguibile;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_bottoni.*;
import modelli.ModelloGestoreLogicaGenerale;

public class Main {

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	try {
	            		ModelloGestoreLogicaGenerale modello = new ModelloGestoreLogicaGenerale();
	        			LoginFrame frameLogin = new LoginFrame();
	        			PazientiFrame pazientiFrame = new PazientiFrame(modello);
	        			new LoginLogic(frameLogin,pazientiFrame,modello);
	        		} catch (Exception e) {
	        			e.printStackTrace();
	        		}
	            }
	        });
	}

}
