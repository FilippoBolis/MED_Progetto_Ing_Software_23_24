package logiche_bottoni;

import gui.PazientiFrame;
import modelli.ModelloGestoreLogicaGenerale;

public abstract class LogicaBottone {

	
	protected PazientiFrame frameDeiPazienti;
	protected ModelloGestoreLogicaGenerale modello;
	
	public LogicaBottone(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prende i riferimenti
		frameDeiPazienti = v2;
		modello = m;
		/*metodo start non è lanciato nel costruttore della superclasse in quanto alcuni
		 * bottoni potrebbero aver necessità di istanziare altre variabili prima di avviarsi
		 */
	}
	
	protected abstract void start(); //ogni bottone eseguirà un compito differente
	
}
