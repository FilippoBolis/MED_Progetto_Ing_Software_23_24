package eseguibile;

import gui.LoginFrame;
import gui.PazientiFrame;
import logiche_bottoni.*;
import logiche_frame_pronto_soccorso.LogicaDellaStringaPaziente;
import modelli.ModelloGestoreLogicaGenerale;

public class GestoreLogicaAttivazionePulsanti {
	
	private LoginFrame loginFrame;
	private PazientiFrame mainFrameUnit;
	private ModelloGestoreLogicaGenerale mainModelUnit;
	private LogicaDellaStringaPaziente controlloTabella;
	private LoginLogic l;
	private LogicaBottone bottoneInProntoSoccorso;
	private LogicaBottone bottoneInReparto;
	private LogicaBottone bottoneDaPrendereInCarico;
	private LogicaBottone filtroUrgenza;
	private LogicaBottone logicaFiltroNomeCognome;
	private LogicaBottone logicaBottoneRefresh;
	private LogicaBottone logicaBottoneDimetti;
	private LogicaBottone logicaBottoneVisualizzaInformazioni;
	private LogicaBottone logicaBottoneVisualizzaFarmaci;
	private LogicaBottone logicaBottoneVisualizzaStorico;
	private LogicaBottone logicaBottoneInserisciDiariaInfermieristica;
	private LogicaBottone logicaBottoneInserisciDiariaMedica;
	private LogicaBottone logicaBottoneAssegnaLetto;
	private LogicaBottone logicaBottoneModificaDiariaMedica;
	private LogicaBottone logicaBottoneInserisciPaziente;
	
	
	public GestoreLogicaAttivazionePulsanti(LoginFrame v, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prende i riferimenti e avvia tutti i bottoni della GUI
		loginFrame = v;
		mainFrameUnit = v2;
		mainModelUnit = m;
		logicaBottoneInserisciPaziente = new LogicaBottoneInserisciPaziente(mainFrameUnit,mainModelUnit);
		logicaBottoneModificaDiariaMedica = new LogicaBottoneModificaDiariaMedica(mainFrameUnit,mainModelUnit);
		logicaBottoneAssegnaLetto = new LogicaBottoneAssegnaLetto(mainFrameUnit,mainModelUnit);
		logicaBottoneInserisciDiariaMedica = new LogicaBottoneInserisciDiariaMedica(mainFrameUnit,mainModelUnit);
		logicaBottoneInserisciDiariaInfermieristica = new LogicaBottoneInserisciDiariaInfermieristica(mainFrameUnit,mainModelUnit);
		logicaBottoneVisualizzaStorico = new LogicaBottoneVisualizzaStorico(mainFrameUnit,mainModelUnit);
		logicaBottoneVisualizzaFarmaci = new LogicaBottoneVisualizzaFarmaci(mainFrameUnit,mainModelUnit);
		logicaBottoneVisualizzaInformazioni = new LogicaBottoneVisualizzaInformazioni(mainFrameUnit,mainModelUnit);
		logicaBottoneDimetti = new LogicaBottoneDimetti(mainFrameUnit,mainModelUnit);
		logicaBottoneRefresh = new LogicaBottoneRefresh(mainFrameUnit,mainModelUnit);
		logicaFiltroNomeCognome = new LogicaBottoneFiltroNomeCognome(mainFrameUnit,mainModelUnit);
		filtroUrgenza = new LogicaBottoneFiltroUrgenza(mainFrameUnit,mainModelUnit);
	   	controlloTabella = new LogicaDellaStringaPaziente(mainFrameUnit,mainModelUnit);
	   	bottoneInReparto = new LogicaBottoneInReparto(mainFrameUnit,mainModelUnit);
	   	bottoneDaPrendereInCarico = new LogicaBottoneDaPrendereInCarico(mainFrameUnit,mainModelUnit);
		bottoneInProntoSoccorso = new LogicaBottoneInProntoSoccorso(mainFrameUnit,mainModelUnit);
	   	l = new LoginLogic(v,v2,m);
	}
	
}
