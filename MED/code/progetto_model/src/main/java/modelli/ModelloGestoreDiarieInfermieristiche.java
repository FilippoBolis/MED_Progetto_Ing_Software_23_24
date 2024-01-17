package modelli;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ModelloGestoreDiarieInfermieristiche {
	//per le tabelle delle diarie
	private List<String> codiceInfermiere = new ArrayList<>();
	private List<String> noteParticolari = new ArrayList<>();
	private List<String> farmaci = new ArrayList<>();
	private List<Boolean> importante = new ArrayList<>();
	private List<LocalDate> dataCreazione = new ArrayList<>();
	private List<LocalTime> oreCreazione = new ArrayList<>();
    
	public void setTableCodiceInfermiere(List<String> codice) {
		this.codiceInfermiere = codice;
	}
	
	public void setTableNoteParticolari(List<String> note) {
		this.noteParticolari = note;
	}
	
	public void setTableFarmaci(List<String> farmaci) {
		this.farmaci = farmaci;
	}
	
	public void setTableImportante(List<Boolean> importante) {
		this.importante = importante;
	}
	
	public void setTableDateArrivo(List<LocalDate> dateArrivo) {
		this.dataCreazione = dateArrivo;
	}
	
	public void setTableOreArrivo(List<LocalTime> oreArrivo) {
		this.oreCreazione = oreArrivo;
	}
	
	public List<String> getCodiceInfermiere(){
		return codiceInfermiere;
	}
	
	public List<String> getTableNoteParticolari(){
		return noteParticolari;
	}
	
	public List<String> getTableFarmaci(){
		return farmaci;
	}
	
	public List<Boolean> getTableImportante(){
		return importante;
	}
	
	public List<LocalDate> getTableDateArrivo(){
		return dataCreazione;
	}
	
	public List<LocalTime> getTableOraArrivo(){
		return oreCreazione;
	}
	
}
