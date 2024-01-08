package eseguibile;

import gui.LoginFrame;
import gui.PazientiFrame;
import logiche_bottoni.LogicaBottoneDaPrendereInCarico;
import logiche_bottoni.LogicaBottoneFiltroNomeCognome;
import logiche_bottoni.LogicaBottoneFiltroUrgenza;
import logiche_bottoni.LogicaBottoneInProntoSoccorso;
import logiche_bottoni.LogicaBottoneInReparto;
import logiche_bottoni.LogicaBottoneRefresh;
import logiche_bottoni.LoginLogic;
import logiche_frame_pronto_soccorso.StringaPaziente;
import modelli.ModelloGestoreLogicaGenerale;

public class GestoreLogicaAttivazionePulsanti {
	
	private LoginFrame loginFrame;
	private PazientiFrame prontoSoccorso;
	private ModelloGestoreLogicaGenerale modello;
	private StringaPaziente controlloTabella;
	private LoginLogic l;
	private LogicaBottoneInProntoSoccorso bottoneInProntoSoccorso;
	private LogicaBottoneInReparto bottoneInReparto;
	private LogicaBottoneDaPrendereInCarico bottoneDaPrendereInCarico;
	private LogicaBottoneFiltroUrgenza filtroUrgenza;
	private LogicaBottoneFiltroNomeCognome logicaFiltroNomeCognome;
	private LogicaBottoneRefresh logicaBottoneRefresh;
	
	
	public GestoreLogicaAttivazionePulsanti(LoginFrame v, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prede i refs
		loginFrame = v;
		prontoSoccorso = v2;
		modello = m;
		logicaBottoneRefresh = new LogicaBottoneRefresh(prontoSoccorso,modello);
		logicaFiltroNomeCognome = new LogicaBottoneFiltroNomeCognome(prontoSoccorso,modello);
		filtroUrgenza = new LogicaBottoneFiltroUrgenza(prontoSoccorso,modello);
	   	controlloTabella = new StringaPaziente(prontoSoccorso,modello);
	   	bottoneInReparto = new LogicaBottoneInReparto(prontoSoccorso,modello);
	   	bottoneDaPrendereInCarico = new LogicaBottoneDaPrendereInCarico(prontoSoccorso,modello);
		bottoneInProntoSoccorso = new LogicaBottoneInProntoSoccorso(prontoSoccorso,modello);
	   	l = new LoginLogic(v,v2,m);
	}
	
}
