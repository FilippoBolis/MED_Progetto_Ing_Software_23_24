package logiche_frame_pronto_soccorso;

import gui.PazientiFrame;
import modelli.ModelloGestoreLogicaGenerale;

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
