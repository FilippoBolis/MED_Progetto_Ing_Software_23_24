package eseguibile;

import javax.swing.SwingUtilities;

import gui.*;
import logiche_bottoni.*;
import modelli.modelloLogicaPazienti;

public class Main {

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	try {
	            		modelloLogicaPazienti modello = new modelloLogicaPazienti();
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
