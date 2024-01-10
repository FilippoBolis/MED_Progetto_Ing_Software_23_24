package classi_test_db;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import gestore_db.InserimentoJooq;

public class Test_Inserimenti implements MetodiDaTestare{


	@Test
	public void testDegente() {
		int risultato;
		//primo test: inserimento corretto  
		//da giustamente errore a lanci successivi, chiave primaria viene rispettata
		risultato=InserimentoJooq.getIstanza().degente("D5","Giorgia","Mezzera","F",LocalDate.now(), LocalTime.now().withNano(0),"verde");
		assertEquals(1,risultato);
		//secondo test: tentativo di inserimento con dati scorretti
		//risultato=InserimentoJooq.getIstanza().degente("D5","Giorgia" ,"Mezzera" ,"F",LocalDate.now(), LocalTime.now().withNano(0), "fuchsia");
		//assertEquals(1,risultato);
	}

	@Test
	public void testPersonale() {
		int risultato;
		//primo test: inserimento corretto  
		risultato= InserimentoJooq.getIstanza().personale("P4", "Alessia", "Lazzari", "M", "Pippo");
		assertEquals(1,risultato);
		//secondo test: tentativo di inserimento con dati scorretti
		//risultato=InserimentoJooq.getIstanza().personale("P5", "Alessia", "Lazzari", "asdf", "Pippo");
		//assertEquals(1,risultato);
		
	}

	@Test
	public void testDiariaInf() {
		int risultato;
		//primo test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().diariaInf("DiariaInf2", "D2", "P2", LocalDate.now(), LocalTime.now().withNano(0), "Il paziente sembra migliorare", false, "aspirina");
		assertEquals(1,risultato);
		//secondo test: tentativo di inserimento con dati scorretti
		//risultato=InserimentoJooq.getIstanza().diariaInf("DiariaInf1", "D8", "P2", LocalDate.now(), LocalTime.now().withNano(0), "Il paziente sembra migliorare", false, "aspirina");
		//assertEquals(1,risultato);
		
	}

	@Test
	public void testDIariaMed() {
		int risultato;
		//primo test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().diariaMed("DiariaMed2", "D2", "P1", "Il paziente soffre di allergia agli anticoagulanti?", "Necessaria cura","fisioterapia", "Antiallergene", LocalDate.now(), LocalTime.now().withNano(0), "anticoagulanti");
		assertEquals(1,risultato);
		//secondo test: tentativo di inserimento con dati scorretti
		//risultato=InserimentoJooq.getIstanza().diariaMed("DiariaMed1", "D8", "P1", "Il paziente soffre di allergia agli anticoagulanti?", "Necessaria cura","fisioterapia","Antiallergene", LocalDate.now(), LocalTime.now().withNano(0), "anticoagulanti");

		//assertEquals(1,risultato);
		
	}

	@Test
	public void testReparto() {
		int risultato;
		risultato=InserimentoJooq.getIstanza().reparto("Re2", "Fisioterapia");
		assertEquals(1,risultato);
		
	}

	@Test
	public void testModulo() {
		int risultato;
		//primo test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().modulo("Re2", "ModuloA");
		assertEquals(1,risultato);
		//secondo test: inserimento in un reparto inesistente
		//risultato=InserimentoJooq.getIstanza().modulo("Re5", "ModuloA");
		//assertEquals(1,risultato);
		
	}

	@Test
	public void testLetto() {
		int risultato;
		//primo test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().letto("Re2", "ModuloA",12);
		assertEquals(1,risultato);
		//secondo test: inserimento in un reparto inesistente
		//risultato=InserimentoJooq.getIstanza().letto("Re5", "ModuloA",12);
		//assertEquals(1,risultato);
		
	}

	@Test
	public void testAssegnazioneLetto() {
		int risultato;
		//primo test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().assegnazioneLetto("D2","Re2", "ModuloA",12,LocalDate.now());
		assertEquals(1,risultato);
		//secondo test: inserimento con riferimenti (letto/degente) inesistenti
		//risultato=InserimentoJooq.getIstanza().assegnazioneLetto("D10","Re2", "ModuloA",12,LocalDate.now());
		//assertEquals(1,risultato);
		
	}

	@Test
	public void testRilevazione() {
		int risultato;
		//primo test: inserimento corretto
		risultato=InserimentoJooq.getIstanza().rilevazione("Ri2","D1", 35, 120, 80, 30, LocalDate.now(), LocalTime.now().withNano(0), 60, 2);
		assertEquals(1,risultato);
		//secondo test: tentativo di inserimento con dati scorretti
		//risultato=InserimentoJooq.getIstanza().rilevazione("Ri2","D8", 35, 75, 110, 30, LocalDate.now(), LocalTime.now().withNano(0), 60, 2);
		//assertEquals(1,risultato);

	}

}
