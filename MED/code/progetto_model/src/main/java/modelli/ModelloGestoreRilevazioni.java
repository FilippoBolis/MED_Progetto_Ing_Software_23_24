package modelli;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


/**Modello della struttura dei dati delle rilevazioni
 * 
 */
public class ModelloGestoreRilevazioni {
	//per le tabelle delle rilevazioni
	private List<String> codicePersonale = new ArrayList<>();
	private List<Integer> glicemia = new ArrayList<>();
	private List<Double> temperatura = new ArrayList<>();
	private List<Integer> pressioneMax = new ArrayList<>();
	private List<Integer> pressioneMin = new ArrayList<>();
	private List<Integer> frequenza = new ArrayList<>();
	private List<Integer> dolore = new ArrayList<>();
	private List<LocalDate> dataCreazione = new ArrayList<>();
	private List<LocalTime> oreCreazione = new ArrayList<>();
    
	public void setTableCodicePersonale(List<String> codice) {
		this.codicePersonale = codice;
	}
	
	public void setTableGlicemia(List<Integer> glicemia) {
		this.glicemia = glicemia;
	}
	
	public void setTableTemperatura(List<Double> temperatura) {
		this.temperatura = temperatura;
	}
	
	public void setTablePressioneMax(List<Integer> pressioneMax) {
		this.pressioneMax = pressioneMax;
	}
	
	public void setTableFrequenza(List<Integer> frequenza) {
		this.frequenza = frequenza;
	}
	
	public void setTablePressioneMin(List<Integer> pressioneMin) {
		this.pressioneMin = pressioneMin;
	}
	
	public void setTableDolore(List<Integer> dolore) {
		this.dolore = dolore;
	}
	
	public void setTableDateArrivo(List<LocalDate> dateArrivo) {
		this.dataCreazione = dateArrivo;
	}
	
	public void setTableOreArrivo(List<LocalTime> oreArrivo) {
		this.oreCreazione = oreArrivo;
	}
	
	public List<String> getCodicePersonale(){
		return codicePersonale;
	}
	
	public List<Integer> getGlicemia(){
		return glicemia;
	}
	
	public List<Double> getTemperatura(){
		return temperatura;
	}
	
	public List<Integer> getPressioneMax(){
		return pressioneMax;
	}
	
	public List<Integer> getPressioneMin(){
		return pressioneMin;
	}
	
	public List<Integer> getFrequenza(){
		return frequenza;
	}
	
	public List<Integer> getDolore(){
		return dolore;
	}
	
	public List<LocalDate> getTableDateArrivo(){
		return dataCreazione;
	}
	
	public List<LocalTime> getTableOraArrivo(){
		return oreCreazione;
	}
	
}
