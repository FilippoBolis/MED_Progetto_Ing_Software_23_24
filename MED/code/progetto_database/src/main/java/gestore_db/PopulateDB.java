package gestore_db;

import java.time.LocalDate;
import java.time.LocalTime;

public class PopulateDB {

	public static void main(String[] args) throws Exception{
		/*file unico per la costruzione del DB
		CreateDB.getIstanza().creaDB();
		CreateDB.getIstanza().creaTable();
		*/
		//inserimento personale
		InserimentoJooq.getIstanza().personale("P1","Daniele","Gotti","M", "SpostamiSeCiRiesci");
		InserimentoJooq.getIstanza().personale("P2","Filippo","Bolis","I","HaiGiocatoAdOuterWilds");
		InserimentoJooq.getIstanza().personale("P3","Gabriele","Masinari","S","PileBunker");
		
		//inserimento personale (nomi meno realistici, usati per il testing
		InserimentoJooq.getIstanza().personale("m","ADMIN","Medico","M", "m");
		InserimentoJooq.getIstanza().personale("i","ADMIN","Infermiere","I", "i");
		InserimentoJooq.getIstanza().personale("o","ADMIN","Operatore","S", "o");
		
		//inserimento reparti, moduli e letti
		InserimentoJooq.getIstanza().reparto("Re1","Cardiologia");
		InserimentoJooq.getIstanza().modulo("Re1","ModuloA");
		InserimentoJooq.getIstanza().modulo("Re1","ModuloB");
		InserimentoJooq.getIstanza().modulo("Re1","ModuloC");
		
		//inserimento dei letti nei moduli di cardiologia
		for(int i=1; i<=15; i++ ) {
			InserimentoJooq.getIstanza().letto("Re1","ModuloA",i);
			InserimentoJooq.getIstanza().letto("Re1","ModuloB",i);
			InserimentoJooq.getIstanza().letto("Re1","ModuloC",i);
		}

		InserimentoJooq.getIstanza().reparto("Re2","Medicina Interna");
		InserimentoJooq.getIstanza().modulo("Re2","ModuloA");
		InserimentoJooq.getIstanza().modulo("Re2","ModuloB");
		InserimentoJooq.getIstanza().modulo("Re2","ModuloC");
		
		//inserimento dei letti nei moduli di medicina interna
				for(int i=1; i<=15; i++ ) {
					InserimentoJooq.getIstanza().letto("Re2","ModuloA",i);
					InserimentoJooq.getIstanza().letto("Re2","ModuloB",i);
					InserimentoJooq.getIstanza().letto("Re2","ModuloC",i);
				}
			
		//inserimento degenti
		InserimentoJooq.getIstanza().degente("D1","Gabriele","Mazzoleni","M",LocalDate.now(), LocalTime.now().withNano(0),"verde");
		InserimentoJooq.getIstanza().degente("D2","Jacopo","Bellosi","M",LocalDate.now(), LocalTime.now().withNano(0),"rosso");
		InserimentoJooq.getIstanza().degente("D3","Lara","Longhi","F",LocalDate.now(), LocalTime.now().withNano(0),"giallo");
		InserimentoJooq.getIstanza().degente("D4","Alessia","Lazzari","F",LocalDate.now(), LocalTime.now().withNano(0),"rosso");
		InserimentoJooq.getIstanza().degente("D5","Giorgia","Mezzera","F",LocalDate.now(), LocalTime.now().withNano(0),"giallo");
		
		//inserimento diarie mediche
		InserimentoJooq.getIstanza().diariaMed(1,"D1","P1","il paziente non soffre di nulla in particolare","Vuole diventare più grosso","Cardiologia","Trembolone",LocalDate.now(),LocalTime.now().withNano(0),"nessun allergia");
		InserimentoJooq.getIstanza().diariaMed(2, "D2", "P1", "Il paziente soffre di allergia agli anticoagulanti?", "Necessaria cura","Cardiologia", "Antiallergene", LocalDate.now(), LocalTime.now().withNano(0), "anticoagulanti");
		InserimentoJooq.getIstanza().diariaMed(3,"D3","P1","il paziente è prono ad ammalarsi","Si teme malattia virale","Medicina Interna","Aspirina",LocalDate.now(),LocalTime.now().withNano(0),"nessun allergia");
		InserimentoJooq.getIstanza().diariaMed(4,"D4","P1","il paziente è stressato","Necessita riposo","Medicina Interna","Sciroppo rilassante",LocalDate.now(),LocalTime.now().withNano(0),"nessun allergia");
		
		//assegnazione dei letti
		InserimentoJooq.getIstanza().assegnazioneLetto("D1","Re1","ModuloA",1,LocalDate.now());
		InserimentoJooq.getIstanza().assegnazioneLetto("D2","Re1","ModuloA",2,LocalDate.now());
		InserimentoJooq.getIstanza().assegnazioneLetto("D4","Re2","ModuloA",1,LocalDate.now());
		
		//inserimento diarie infermieristiche
		InserimentoJooq.getIstanza().diariaInf(1,"D1","P2",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente è diventato enorme dottore",true,"Trembolone");
		InserimentoJooq.getIstanza().diariaInf(2, "D2", "P2", LocalDate.now(), LocalTime.now().withNano(0), "Il paziente sembra migliorare", false, "aspirina");
		
		//inserimento rilevazioni
		InserimentoJooq.getIstanza().rilevazione(1,"D1","P2",36.8,150,90,100, LocalDate.now(),LocalTime.now().withNano(0),60,5);
		InserimentoJooq.getIstanza().rilevazione(2,"D1","P2",35, 120, 80, 30, LocalDate.now(), LocalTime.now().withNano(0), 60, 2);
	}

}
