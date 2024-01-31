package modelli;

/**Modello della struttura dei dati da visualizzare alla selezione del paziente
 */
public class ModelloGestoreVisualizzazioneDatiPaziente {
	
	private String stringaAnagrafica;
	private String stringaArrivoPaziente;
	private String condizionePaziente;
	
	public void setStringaAnagraficaPaziente(String frase) {
		stringaAnagrafica = frase;
	}
	
	public void setStringaCondizionePaziente(String frase) {
		condizionePaziente = frase;
	}
	
	public void setStringaArrivoPaziente(String frase) {
		stringaArrivoPaziente = frase;
	}
	
	public String getStringaCondizionePaziente() {
		return condizionePaziente;
	}
	
	public String getStringaDatiPaziente() {
		return stringaAnagrafica;
	}
	
	public String getStringaArrivoPaziente() {
		return stringaArrivoPaziente;
	}
	
}
