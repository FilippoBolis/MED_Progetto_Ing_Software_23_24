package modelli;

public class ModelloGestoreStringaPaziente {
	private String codice;
	private String cognome;
	private String nome;
	private String sesso;
	
	public void setDatiPaziente(String codice, String cognome, String nome, String sesso) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
	}
	
	public String getDatiPaziente() {
		if(sesso.equals("M")) {
			return "Paziente: Signor " + nome + " " + cognome + " ( Codice" + codice + " )";
		}
		else if (sesso.equals("F")) {
			return "Paziente: Signora "  + nome + " " + cognome + " ( Codice" + codice + " )";
		}
		else {
			return "Paziente: " + nome + " " + cognome + " ( Codice " + codice + " )";
		}
	}
}
