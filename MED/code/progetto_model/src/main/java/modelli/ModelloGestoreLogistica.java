package modelli;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ModelloGestoreLogistica {
	//per le tabelle dei pazienti
	private List<String> nomiReparti = new ArrayList<>();
	
    public void setNomiReparti(List<String> nomiReparti) {
		this.nomiReparti = nomiReparti;
	}
	
	public List<String> getNomiReparti(){
		return nomiReparti;
	}
	
}
