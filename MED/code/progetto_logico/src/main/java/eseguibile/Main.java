package eseguibile;

import javax.swing.SwingUtilities;

import gui.*;
import modelli.ModelloGestoreLogicaGenerale;

public class Main {

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	try {
	            		ModelloGestoreLogicaGenerale modello = new ModelloGestoreLogicaGenerale();
	        			new GestoreLogicaSetup(modello);
	        		} catch (Exception e) {
	        			e.printStackTrace();
	        		}
	            }
	        });
	}

}

/*
 * 
 * 
*/
