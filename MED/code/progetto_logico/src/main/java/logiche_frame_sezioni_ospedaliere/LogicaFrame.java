package logiche_frame_sezioni_ospedaliere;

import gui.PazientiFrame;
import modelli.ModelloGestoreLogicaGenerale;

/**Classe astratta che definisce i collegamenti delle classi logiche agli altri progetti del programma.
 * Fa riferimento al modello, alla GUI e alla directory relativa del database.
 */
public abstract class LogicaFrame {
	//riferimenti agli altri pacchetti di lavoro 
	protected PazientiFrame frameDeiPazienti;
	protected ModelloGestoreLogicaGenerale modello;
	//riferimenti al database
	protected static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	protected static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
	
	public LogicaFrame(PazientiFrame p, ModelloGestoreLogicaGenerale m) {
		frameDeiPazienti = p;
		modello = m;
	}


}
