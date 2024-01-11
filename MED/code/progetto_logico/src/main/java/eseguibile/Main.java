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

/*	InserimentoJooq.getIstanza().personale("m","ADMIN","medico","M", "m");
 *	int qualcosa = funzione se esce 1 è giusto se 0 è sbagliato
 *	Non puoi inserire qualcosa che non è m i o s
 *	
*/  
