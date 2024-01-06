package modelli;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class modelloLogicaPazienti {	
	
	//per il personale (LOGIN)
	private String mansione;
	private String nome;
	private String cognome;
	private String utente;
	
	//per le tabelle dei pazienti
	private List<String> nomi = new ArrayList<>();
	private List<String> cognomi = new ArrayList<>();
	private List<String> sesso = new ArrayList<>();
	private List<LocalDate> dateArrivo = new ArrayList<>();
	private List<LocalTime> oreArrivo = new ArrayList<>();
	private List<Integer> urgenza = new ArrayList<>();
	
	
	// per il personale (LOGIN)
	public void setUtente(String mansione, String nome, String cognome,String utente) {
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
	
	//per le tabelle dei pazienti
	
	public void setTableNomi(List<String> nomi) {
		this.nomi = nomi;
	}
	
	public void setTableCognomi(List<String> cognomi) {
		this.cognomi = cognomi;
	}
	
	public void setTableSesso(List<String> sesso) {
		this.sesso = sesso;
	}
	
	public void setTableDateArrivo(List<LocalDate> dateArrivo) {
		this.dateArrivo = dateArrivo;
	}
	
	public void setTableOreArrivo(List<LocalTime> oreArrivo) {
		this.oreArrivo = oreArrivo;
	}
	
	public void setTableUrgenza(List<Integer> urgenza) {
		this.urgenza = urgenza;
	}
	
	public List<String> getTableNomi(){
		return nomi;
	}
	
	public List<String> getTableCognomi(){
		return cognomi;
	}
	
	public List<String> getTableSesso(){
		return sesso;
	}
	
	public List<LocalDate> getTableDateArrivo(){
		return dateArrivo;
	}
	
	public List<LocalTime> getTableOraArrivo(){
		return oreArrivo;
	}
	
	public List<Integer> getTableUrgenza(){
		return urgenza;
	}
}
