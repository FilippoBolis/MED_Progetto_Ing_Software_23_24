package logiche_bottoni;

import gui.PazientiFrame;
import modelli.ModelloGestoreLogicaGenerale;

/**
 * Superclasse astratta per le logiche dei bottoni;
 * ogni elemento logico fa riferimento alla GUI e al modello
 * @param frameDeiPazienti collegamento agli elementi grafici
 * @param modello collegamento al modello
 */
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
	
	
	/**
	 * Avvia le funzionalità del bottone
	 */
	protected abstract void start();
	
}
