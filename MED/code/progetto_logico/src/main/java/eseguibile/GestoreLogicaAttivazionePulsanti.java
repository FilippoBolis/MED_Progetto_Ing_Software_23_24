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
	private LogicaBottoneInProntoSoccorso bottoneInProntoSoccorso;
	private LogicaBottoneInReparto bottoneInReparto;
	private LogicaBottoneDaPrendereInCarico bottoneDaPrendereInCarico;
	private LogicaBottoneFiltroUrgenza filtroUrgenza;
	private LogicaBottoneFiltroNomeCognome logicaFiltroNomeCognome;
	private LogicaBottoneRefresh logicaBottoneRefresh;
	private LogicaBottoneDimetti logicaBottoneDimetti;
	private LogicaBottoneVisualizzaInformazioni logicaBottoneVisualizzaInformazioni;
	private LogicaBottoneVisualizzaFarmaci logicaBottoneVisualizzaFarmaci;
	private LogicaBottoneVisualizzaStorico logicaBottoneVisualizzaStorico;
	private LogicaBottoneInserisciDiariaInfermieristica logicaBottoneInserisciDiariaInfermieristica;
	private LogicaBottoneInserisciDiariaMedica logicaBottoneInserisciDiariaMedica;
	private LogicaBottoneAssegnaLetto logicaBottoneAssegnaLetto;
	private LogicaBottoneModificaDiariaMedica logicaBottoneModificaDiariaMedica;
	private LogicaBottoneInserisciPaziente logicaBottoneInserisciPaziente;
	
	
	public GestoreLogicaAttivazionePulsanti(LoginFrame v, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		// prede i refs
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
