package modelli;


/**Modello dei dati dell'utente utilizzatore del programma
 */
public class ModelloGestoreUtente {
	private String mansione;
	private String nome;
	private String cognome;
	private String utente;
	private String codice;
	
	public void setUtente(String mansione, String nome, String cognome, String utente, String codice) {
		this.mansione = mansione;
		this.nome = nome;
		this.cognome = cognome;
		this.utente = utente;
		this.codice = codice;
	}
	
	public String getUtente() {
		if(mansione.equals("M")) {
			return "Utente: Dottor " + nome + " " + cognome + " (" + utente + ")";
		}
		else if (mansione.equals("I")) {
			return "Utente: Infermiere "  + nome + " " + cognome + " (" + utente + ")";
		}
		else {
			return "Utente: Operatore " + nome + " " + cognome + " (" + utente + ")";
		}
	}
	
	public String getCodiceUtente() {
		return codice;
	}
	
	public String getMansioneUtente() {
		if(mansione.equals("M")) {
			return "Medico";
		}
		else if (mansione.equals("I")) {
			return "Infermiere";
		}
		else {
			return "Operatore";
		}
	}
}
