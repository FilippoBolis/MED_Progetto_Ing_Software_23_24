package modelli;


/**Modello che controlla la selezione di un paziente dalla tabella.
 * Definisce il valore delle stringhe di "ModelloGestoreVisualizzaDatiPaziente" in base alla selezione.
 */
public class ModelloGestorePaziente {
	private String codice;
	private String cognome;
	private String nome;
	private String data;
	private String ora;
	private String condizione;
	private Boolean selezionato = false;
	private ModelloGestoreVisualizzazioneDatiPaziente modelloView;
	
	public ModelloGestorePaziente(ModelloGestoreVisualizzazioneDatiPaziente m) {
		modelloView = m;
	}
	
	public void SelezionaPaziente(String codice, String cognome, String nome, String data, String ora, String condizione) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.data = data;
		this.ora = ora;
		this.condizione = condizione;
		selezionato = true;
		modelloView.setStringaAnagraficaPaziente("Paziente: " + nome + " " + cognome + " (Codice: " + codice + ")");
		modelloView.setStringaArrivoPaziente("    Data arrivo in struttura: " + data + ", alle: " + ora);
		modelloView.setStringaCondizionePaziente("    Motivo: " + condizione);
	}
	
	public void deselezionaPaziente() {
		selezionato = false;
		modelloView.setStringaAnagraficaPaziente("Selezionare un paziente");
		modelloView.setStringaArrivoPaziente("    Data arrivo in struttura: ...");
		modelloView.setStringaCondizionePaziente("    Motivo: ...");
	}
	
	public boolean qualcunoSelezionato() {
		return selezionato;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getData() {
		return data;
	}
	
	public String getOra() {
		return ora;
	}
	
	public String getCondizione() {
		return condizione;
	}
	
	public String getCodice() {
		return codice;
	}
	
	public String getCognome() {
		return cognome;
	}
}
