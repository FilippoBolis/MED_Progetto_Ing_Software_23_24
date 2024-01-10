package modelli;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ModelloGestoreTabella {
	//per le tabelle dei pazienti
	private List<String> nomi = new ArrayList<>();
	private List<String> codice = new ArrayList<>();
	private List<String> cognomi = new ArrayList<>();
	private List<String> sesso = new ArrayList<>();
	private List<LocalDate> dateArrivo = new ArrayList<>();
	private List<LocalTime> oreArrivo = new ArrayList<>();
	private List<String> urgenza = new ArrayList<>();
	private List<String> reparto = new ArrayList<>();
    private List<String> modulo = new ArrayList<>();
    private List<Integer> numeroLetto = new ArrayList<>();
	
    public void setNumeroLetto(List<Integer> numeroLetto) {
		this.numeroLetto = numeroLetto;
	}
    
    public void setTableReparto(List<String> reparto) {
		this.reparto = reparto;
	}
	
    public void setTableModulo(List<String> modulo) {
		this.modulo = modulo;
	}
    
	public void setTableNomi(List<String> nomi) {
		this.nomi = nomi;
	}
	
	public void setTableCodice(List<String> codice) {
		this.codice = codice;
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
	
	public void setTableUrgenza(List<String> urgenza) {
		this.urgenza = urgenza;
	}
	
	public List<String> getTableNomi(){
		return nomi;
	}
	
	public List<String> getTableCodice(){
		return codice;
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
	
	public List<String> getTableUrgenza(){
		return urgenza;
	}
	
	public List<String> getTableReparto(){
		return reparto;
	}
	
	public List<String> getTableModulo(){
		return modulo;
	}
	
	public List<Integer> getTableNumeroLetto(){
		return numeroLetto;
	}
	
}
