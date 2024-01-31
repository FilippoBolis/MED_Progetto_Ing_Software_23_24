package gestore_db;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * classe utilizzata per popolare con più rapidità il database a seguito di modifiche alla sua struttura
 */
public class PopulateDB {

	public static void main(String[] args) throws Exception{
		/*file unico per la costruzione del DB*/
		CreateDB.getIstanza().creaDB();
		CreateDB.getIstanza().creaTable();
		
		//inserimento personale default
		InserimentoJooq.getIstanza().personale("m","ADMIN","Medico","M", "m");
		InserimentoJooq.getIstanza().personale("i","ADMIN","Infermiere","I", "i");
		InserimentoJooq.getIstanza().personale("o","ADMIN","Operatore","S", "o");
		
		//inserimento reparti e moduli di cardiologia
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
		
		//inserimento reparti e moduli di ortopedia
		InserimentoJooq.getIstanza().reparto("Re2","Ortopedia");
		InserimentoJooq.getIstanza().modulo("Re2","ModuloA");
		InserimentoJooq.getIstanza().modulo("Re2","ModuloB");
		InserimentoJooq.getIstanza().modulo("Re2","ModuloC");
		
		//inserimento dei letti nei moduli di ortopedia
		for(int i=1; i<=15; i++ ) {
			InserimentoJooq.getIstanza().letto("Re2","ModuloA",i);
			InserimentoJooq.getIstanza().letto("Re2","ModuloB",i);
			InserimentoJooq.getIstanza().letto("Re2","ModuloC",i);
		}
		
		//inserimento reparti e moduli di psichiatria
		InserimentoJooq.getIstanza().reparto("Re3","Psichiatria");
		InserimentoJooq.getIstanza().modulo("Re3","ModuloA");
		InserimentoJooq.getIstanza().modulo("Re3","ModuloB");
		InserimentoJooq.getIstanza().modulo("Re3","ModuloC");
		
		//inserimento dei letti nei moduli di psichiatria
		for(int i=1; i<=15; i++ ) {
			InserimentoJooq.getIstanza().letto("Re3","ModuloA",i);
			InserimentoJooq.getIstanza().letto("Re3","ModuloB",i);
			InserimentoJooq.getIstanza().letto("Re3","ModuloC",i);
		}	
		
		//inserimento reparti e moduli di medicina interna
		InserimentoJooq.getIstanza().reparto("Re4","Medicina Interna");
		InserimentoJooq.getIstanza().modulo("Re4","ModuloA");
		InserimentoJooq.getIstanza().modulo("Re4","ModuloB");
		InserimentoJooq.getIstanza().modulo("Re4","ModuloC");
		
		//inserimento dei letti nei moduli di medicina interna
		for(int i=1; i<=15; i++ ) {
			InserimentoJooq.getIstanza().letto("Re4","ModuloA",i);
			InserimentoJooq.getIstanza().letto("Re4","ModuloB",i);
			InserimentoJooq.getIstanza().letto("Re4","ModuloC",i);
		}	
		
		//inserimento degenti
		InserimentoJooq.getIstanza().degente("D1","Gabriele","Mazzoleni","M",LocalDate.now(), LocalTime.now().withNano(0),"verde");
		InserimentoJooq.getIstanza().degente("D2","Jacopo","Bellosi","M",LocalDate.now(), LocalTime.now().withNano(0),"rosso");
		InserimentoJooq.getIstanza().degente("D3","Lara","Longhi","F",LocalDate.now(), LocalTime.now().withNano(0),"giallo");
		InserimentoJooq.getIstanza().degente("D4","Alessia","Lazzari","F",LocalDate.now(), LocalTime.now().withNano(0),"rosso");
		InserimentoJooq.getIstanza().degente("D5","Giorgia","Mezzera","F",LocalDate.now(), LocalTime.now().withNano(0),"giallo");
		InserimentoJooq.getIstanza().degente("D6","Federica","Gervasoni","F",LocalDate.now(), LocalTime.now().withNano(0),"verde");
		InserimentoJooq.getIstanza().degente("D7","Daniele","Gotti","M",LocalDate.now(), LocalTime.now().withNano(0),"giallo");
		InserimentoJooq.getIstanza().degente("D8","Filippo","Bolis","M",LocalDate.now(), LocalTime.now().withNano(0),"giallo");
		InserimentoJooq.getIstanza().degente("D9","Gabriele","Masinari","M",LocalDate.now(), LocalTime.now().withNano(0),"rosso");
		
		//inserimento diarie mediche
		InserimentoJooq.getIstanza().diariaMed(1,"D1","m","Nessuno","Dolore al braccio","Ortopedia","Antidolorifico",LocalDate.now(),LocalTime.now().withNano(0),"Nessuna allergia");
		InserimentoJooq.getIstanza().diariaMed(1,"D2","m","Il paziente soffre di un forte allergia", "Attacco allergico, necessaria cura immediata","Medicina Interna", "Antiallergene", LocalDate.now(), LocalTime.now().withNano(0), "Allergia ad alcuni farmaci");
		InserimentoJooq.getIstanza().diariaMed(1,"D3","m","Nessuno","Forte influenza","Medicina Interna","Tachipirina",LocalDate.now(),LocalTime.now().withNano(0),"Nessuna allergia");
		InserimentoJooq.getIstanza().diariaMed(1,"D4","m","Il paziente è spesso stressato","Pressione molto alta","Cardiologia","Pastiglia della pressione e riposo",LocalDate.now(),LocalTime.now().withNano(0),"Nessuna allergia");
		InserimentoJooq.getIstanza().diariaMed(1,"D5","m","Nessuno","Forte dolore alla gamba","Ortopedia","Antidolorifico e ulteriori esami",LocalDate.now(),LocalTime.now().withNano(0),"Nessuna allergia");
		InserimentoJooq.getIstanza().diariaMed(1,"D6","m","Il paziente soffre di disturbo della personalità","Necessario consulto psichiatrico","Medicina Interna","Tranquillante",LocalDate.now(),LocalTime.now().withNano(0),"Intolleranza al lattosio");
		InserimentoJooq.getIstanza().diariaMed(1,"D7","m","Il paziente si infortuna facendo sport","Strappo muscolare","Ortopedia","Esami specifici, fisioterapia e antidolorifici",LocalDate.now(),LocalTime.now().withNano(0),"Allergia al polline");
		InserimentoJooq.getIstanza().diariaMed(1,"D8","m","Il paziente soffre di asma","Attacco d'asma","Medicina Interna","Farmaci Broncodilatatori",LocalDate.now(),LocalTime.now().withNano(0),"Nessuna allergia");
		
		//assegnazione dei letti
		InserimentoJooq.getIstanza().assegnazioneLetto("D1","Re2","ModuloC",1,LocalDate.now());
		InserimentoJooq.getIstanza().assegnazioneLetto("D2","Re4","ModuloA",1,LocalDate.now());
		InserimentoJooq.getIstanza().assegnazioneLetto("D3","Re4","ModuloB",1,LocalDate.now());
		InserimentoJooq.getIstanza().assegnazioneLetto("D4","Re1","ModuloA",1,LocalDate.now());
		InserimentoJooq.getIstanza().assegnazioneLetto("D5","Re2","ModuloC",2,LocalDate.now());
		InserimentoJooq.getIstanza().assegnazioneLetto("D6","Re3","ModuloA",1,LocalDate.now());
		
		//inserimento diarie infermieristiche
		InserimentoJooq.getIstanza().diariaInf(1,"D1","i",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente sembra migliorare",false,"Diminuire antidolorifici");
		InserimentoJooq.getIstanza().diariaInf(2,"D1","i",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente non sente più dolore",true,"Nessuno");
		InserimentoJooq.getIstanza().diariaInf(3,"D2","i",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente reagisce ai farmaci", false, "Continuare con antiallergeni");
		InserimentoJooq.getIstanza().diariaInf(4,"D3","i",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente sta peggiorando", true, "Aumentare tachipirina e consultare di nuovo il medico");
		InserimentoJooq.getIstanza().diariaInf(5,"D4","i",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente sembra stabile", false, "Continuare con pastiglie della pressione");
		InserimentoJooq.getIstanza().diariaInf(6,"D4","i",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente è peggiorato all'improvviso", true, "Aumentare dose pastiglie e consultare chirurgia");
		InserimentoJooq.getIstanza().diariaInf(7,"D6","i",LocalDate.now(),LocalTime.now().withNano(0),"Il paziente è stabile e migliora", true, "Tranquillanti");		
		
		//inserimento rilevazioni
		InserimentoJooq.getIstanza().rilevazione(1,"D1","i",36.6,116,78,115, LocalDate.now(),LocalTime.now().withNano(0),62,6);
		InserimentoJooq.getIstanza().rilevazione(2,"D2","i",37.6,142,83,97, LocalDate.now(),LocalTime.now().withNano(0),63,8);
		InserimentoJooq.getIstanza().rilevazione(3,"D3","i",38.2,119,71,114, LocalDate.now(),LocalTime.now().withNano(0),55,4);
		InserimentoJooq.getIstanza().rilevazione(4,"D4","i",36.5,153,94,120, LocalDate.now(),LocalTime.now().withNano(0),94,5);
		InserimentoJooq.getIstanza().rilevazione(5,"D6","i",36.4,105,68,103, LocalDate.now(),LocalTime.now().withNano(0),61,0);
	}

}
