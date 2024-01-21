package classi_test_db;

import static org.junit.Assert.*;

import org.junit.Test;

import gestore_db.RimozioneJooq;

public class Test_Rimozioni implements MetodiDaTestare{

	@Test
	public void testDegente() {
		//int risultato=RimozioneJooq.getIstanza().degente("D2");
		//ci si aspetta che il risultato sia 4, dato che vengono rimossi il degente, una diaria inf, una diaria med e un'assegnazione del letto
		//assertEquals(4,risultato);
	}

	@Test
	public void testPersonale() {
		//P4 non è nel database, quindi la rimozione fallisce, restituendo 0
		int risultato=RimozioneJooq.getIstanza().personale("P4");
		assertEquals(0,risultato);
	}

	@Test
	public void testDiariaInf() {
		int risultato;
		//rimozione di una diaria inesistente fallisce, restituendo 0
		risultato=RimozioneJooq.getIstanza().diariaInf(1,"D4");
		assertEquals(0,risultato);
		//rimozione di una diaria esistente ha successo
		//risultato=RimozioneJooq.getIstanza().diariaInf(2, "D2");
		//assertEquals(1,risultato);
		
		
	}

	@Test
	public void testDIariaMed() {
		int risultato;
		//rimozione di una diaria inesistente fallisce, restituendo 0
		risultato=RimozioneJooq.getIstanza().diariaMed(1,"D4");
		assertEquals(0,risultato);
		//rimozione di una diaria esistente ha successo
		//risultato=RimozioneJooq.getIstanza().diariaMed(2, "D2");
		//assertEquals(1,risultato);
	}

	@Test
	public void testReparto() {
		int risultato;
		//rimozione di un reparto inesistente fallisce, restituendo 0
		risultato=RimozioneJooq.getIstanza().reparto("Re24");
		assertEquals(0,risultato);
		//rimozione di un reparto esistente ha successo
		//risultato=RimozioneJooq.getIstanza().reparto("Re1");
		//ci aspettiamo risultato=4, vengono eliminati un reparto, un modulo, dei letti e delle assegnazioneLetto
		//assertEquals(4,risultato);
		
	}

	@Test
	public void testModulo() {
		//rimozione di un reparto inesistente fallisce, restituendo 0
		int risultato=RimozioneJooq.getIstanza().reparto("Re24");
		assertEquals(0,risultato);
				
		//rimozione di un reparto esistente ha successo
		//int risultato=RimozioneJooq.getIstanza().modulo("Re2", "ModuloA");
		//ci aspettiamo risultato=3, vengono eliminati un modulo, un letto e un'assegnazione letto
		//assertEquals(3,risultato);
				
		
	}

	@Test
	public void testLetto() {
		//rimozione di un letto inesistente fallisce, restituendo 0
		int risultato=RimozioneJooq.getIstanza().letto("Re24","ModuloA",2);
		assertEquals(0,risultato);
						
		//rimozione di un letto esistente ha successo
		//int risultato=RimozioneJooq.getIstanza().letto("Re2", "ModuloA",12);
		//ci aspettiamo risultato=2, vengono eliminati un letto e un'assegnazione letto
		//assertEquals(2,risultato);
		
	}

	@Test
	public void testAssegnazioneLetto() {
		//rimozione di un'assegnazione letto inesistente fallisce, restituendo 0
		int risultato=RimozioneJooq.getIstanza().assegnazioneLetto("D2","Re2","ModuloA",10);
		assertEquals(0,risultato);
								
		//rimozione di un'assegnazione letto esistente ha successo
		//int risultato=RimozioneJooq.getIstanza().assegnazioneLetto("D2","Re2", "ModuloA",12);
		//assertEquals(1,risultato);
		
	}

	@Test
	public void testRilevazione() {
		//rimozione di una rilevazione inesistente fallisce, restituendo 0
		int risultato=RimozioneJooq.getIstanza().rilevazione(15,"D2");
		assertEquals(0,risultato);
										
		//rimozione di una rilevazione esistente ha successo
		//int risultato=RimozioneJooq.getIstanza().rilevazione(2,"D1");
		//assertEquals(1,risultato);
		
	}

}
