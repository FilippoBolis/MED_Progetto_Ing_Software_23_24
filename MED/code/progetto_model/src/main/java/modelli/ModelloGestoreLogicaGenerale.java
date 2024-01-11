package modelli;

public class ModelloGestoreLogicaGenerale {	
	
	public ModelloGestoreUtente modelloGestoreUtente = new ModelloGestoreUtente();
	public ModelloGestoreTabella modelloGestoreTabella = new ModelloGestoreTabella();
	public ModelloGestoreVisualizzazioneDatiPaziente modelloGestoreVisualizzazioneDatiPaziente = new ModelloGestoreVisualizzazioneDatiPaziente();
	public ModelloGestorePaziente modelloGestorePaziente = new ModelloGestorePaziente(modelloGestoreVisualizzazioneDatiPaziente);
	public ModelloGestoreLogistica modelloGestoreLogistica = new ModelloGestoreLogistica();
}
