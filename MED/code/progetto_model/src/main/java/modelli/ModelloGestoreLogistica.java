package modelli;

import java.util.ArrayList;
import java.util.List;


/**Modello della struttura di reparti, moduli e letti
 */
public class ModelloGestoreLogistica {
	//per le tabelle dei pazienti
	private List<String> nomiReparti = new ArrayList<>();
	private List<String> nomiModuli = new ArrayList<>();
	private List<Integer> numeroLetti = new ArrayList<>();
	
    public void setNomiReparti(List<String> nomiReparti) {
		this.nomiReparti = nomiReparti;
	}
	
	public List<String> getNomiReparti(){
		return nomiReparti;
	}
	
	public void setNomiModuli(List<String> nomiModuli) {
		this.nomiModuli = nomiModuli;
	}
	
	public List<String> getNomiModuli(){
		return nomiModuli;
	}
	
	public void setNumeroLettiDisponibili(List<Integer> numeroLetti) {
		this.numeroLetti = numeroLetti;
	}
	
	public List<Integer> getNumeroLettiDisponibili(){
		return numeroLetti;
	}
	
}
