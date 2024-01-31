package classi_test_db;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import gestore_db.InserimentoJooq;

public class Test_Inserimenti implements MetodiDaTestare{

	/*NOTA: alcuni test sono commentati per evitare problematiche nelle fasi di installazione Maven.
	 * Questo perchè tentare di inserire due volte lo stesso elemento nel database porta ad errori,
	 * come è corretto che sia.
	 * Se eseguiti una sola volta nell'ordine in cui sono scritti tutti i test vanno a buon fine.
	 */

	@Test
	public void testDegente() {
		int risultato;
		//test: tentativo di inserimento con dati scorretti
		//ci si aspetta che l'inserimento non avvenga, valore atteso è 0
		risultato=InserimentoJooq.getIstanza().degente("D10","Giorgio" ,"Bonifazzi" ,"M",LocalDate.now(), LocalTime.now().withNano(0), "fuchsia");
		assertEquals(0,risultato);
	}
	
	@Test
	public void testDegente2() {
		/* test commentato, da errore su esecuzioni successive
		int risultato;
		//test: inserimento corretto  
		risultato=InserimentoJooq.getIstanza().degente("D10","Gianfranco","Barbero","M",LocalDate.now(), LocalTime.now().withNano(0),"giallo");
		assertEquals(1,risultato);
		*/
		
	}

	@Test
	public void testPersonale() {
		int risultato;
		//test: tentativo di inserimento con dati scorretti
		//ci si aspetta non inserisca, valore atteso è 0
		risultato=InserimentoJooq.getIstanza().personale("P5", "Alessia", "Lazzari", "asdf", "Pippo");
		assertEquals(0,risultato);
		
	}

	@Test
	public void testPersonale2() {
		/* test commentato, da errore su esecuzioni successive
		int risultato;
		//test: inserimento corretto  
		risultato= InserimentoJooq.getIstanza().personale("P10", "Alba", "Ghisleni", "M", "Sole");
		assertEquals(1,risultato);
		*/
		
	}
	
	@Test
	public void testDiariaInf() {
		int risultato;
		//test: tentativo di inserimento con dati scorretti
		//ci si aspetta non inserisca, valore atteso è 0
		risultato=InserimentoJooq.getIstanza().diariaInf(1, "D100", "P27", LocalDate.now(), LocalTime.now().withNano(0), "Il paziente sembra migliorare", false, "aspirina");
		assertEquals(0,risultato);
		
	}
	
	@Test
	public void testDiariaInf2() {
		/* test commentato, da errore su esecuzioni successive
		int risultato;
		//test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().diariaInf(1, "D10", "P2", LocalDate.now(), LocalTime.now().withNano(0), "Il paziente sembra migliorare", false, "anticoagulante");
		assertEquals(1,risultato);
		*/
	}

	@Test
	public void testDiariaMed() {
		int risultato;
		//test: tentativo di inserimento con dati scorretti
		//ci si aspetta non inserisca, valore atteso è 0
		risultato=InserimentoJooq.getIstanza().diariaMed(1, "D10", "m", "Il paziente soffre di allergia agli anticoagulanti?", "Necessaria cura","fisioterapia","Antiallergene", LocalDate.now(), LocalTime.now().withNano(0), "anticoagulanti");
		assertEquals(0,risultato);
		
	}
	
	@Test
	public void testDiariaMed2() {
		/* test commentato, da errore su esecuzioni successive
		int risultato;
		//test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().diariaMed(1, "D10", "P1", "Il paziente ha recentemente subito un'operazione alle anche", "Necessaria riabilitazione","fisioterapia", "Anticoagulante", LocalDate.now(), LocalTime.now().withNano(0), "nessuna allergia");
		assertEquals(1,risultato);
		*/
	}

	@Test
	public void testReparto() {
		/* test commentato, da errore su esecuzioni successive
		int risultato;
		//test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().reparto("Re3", "Fisioterapia");
		assertEquals(1,risultato);
		*/
	}
	
	@Override
	public void testReparto2() {
		//non esiste un modo scorretto di inserire un reparto, dunque l'inserimento corretto avviene in test1
		
	}

	@Test
	public void testModulo() {
		int risultato;
		//test: inserimento in un reparto inesistente
		//ci si aspetta che l'inserimento non avvenga, valore atteso è 0
		risultato=InserimentoJooq.getIstanza().modulo("Re5", "ModuloA");
		assertEquals(0,risultato);
		
	}
	
	@Test
	public void testModulo2() {
		/* test commentato, da errore su esecuzioni successive
		int risultato;
		//test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().modulo("Re3", "ModuloA");
		assertEquals(1,risultato);
		*/
	}

	@Test
	public void testLetto() {
		int risultato;
		//test: inserimento in un reparto inesistente
		//ci si aspetta che l'inserimento non avvenga, valore atteso è 0
		risultato=InserimentoJooq.getIstanza().letto("Re5", "ModuloA",12);
		assertEquals(0,risultato);
		
	}
	
	@Test
	public void testLetto2() {
		/* test commentato, da errore su esecuzioni successive
		int risultato;
		//test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().letto("Re3", "ModuloA",1);
		assertEquals(1,risultato);
		*/
		
	}

	@Test
	public void testAssegnazioneLetto() {
		int risultato;
		//test: inserimento con riferimenti (letto/degente) inesistenti
		//ci si aspetta che l'inserimento non avvenga, valore atteso è 0
		risultato=InserimentoJooq.getIstanza().assegnazioneLetto("D100","Re2", "ModuloA",12,LocalDate.now());
		assertEquals(0,risultato);
		
	}
	
	@Test
	public void testAssegnazioneLetto2() {
		/* test commentato, da errore su esecuzioni successive
		int risultato;
		//primo test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().assegnazioneLetto("D10","Re3", "ModuloA",1,LocalDate.now());
		assertEquals(1,risultato);
		*/
	}

	@Test
	public void testRilevazione() {
		int risultato;
		//test: tentativo di inserimento con dati scorretti
		//ci si aspetta che l'inserimento non avvenga, valore atteso è 0
		risultato=InserimentoJooq.getIstanza().rilevazione(15,"D11","i",37.6,142,83,97, LocalDate.now(),LocalTime.now().withNano(0),63,8);
		assertEquals(0,risultato);

	}
	
	@Test
	public void testRilevazione2() {
		/* test commentato, da errore su esecuzioni successive
		int risultato;
		//test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().rilevazione(1,"D10","P2", 35, 120, 80, 30, LocalDate.now(), LocalTime.now().withNano(0), 60, 2);
		assertEquals(1,risultato);
		*/
	}

	

}
