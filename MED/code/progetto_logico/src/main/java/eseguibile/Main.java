package eseguibile;

import javax.swing.SwingUtilities;
import modelli.ModelloGestoreLogicaGenerale;

public class Main {
/* Credenziali per accesso:
	Medico:
		-Nome Utente:m
		-Password:m
	Infermiere:
		-Nome Utente:i
		-Password:i
	Operatore:
		-Nome Utente:o
		-Password:o
*/
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
