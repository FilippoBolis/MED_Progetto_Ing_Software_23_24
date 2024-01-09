package modelli;

public class ModelloGestoreUtente {
	private String mansione;
	private String nome;
	private String cognome;
	private String utente;
	
	public void setUtente(String mansione, String nome, String cognome, String utente) {
		this.mansione = mansione;
		this.nome = nome;
		this.cognome = cognome;
		this.utente = utente;
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
