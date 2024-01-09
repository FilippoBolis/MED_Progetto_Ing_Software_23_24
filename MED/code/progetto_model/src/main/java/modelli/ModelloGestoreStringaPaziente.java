package modelli;

public class ModelloGestoreStringaPaziente {
	private String codice;
	private String cognome;
	private String nome;
	
	public void setDatiPaziente(String codice, String cognome, String nome) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public String getDatiPaziente() {
		return "Paziente: " + nome + " " + cognome + " (Codice " + codice + ")";
	}
}
