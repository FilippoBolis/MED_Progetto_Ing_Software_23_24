package classi_test_db;

import static org.junit.Assert.*;

import org.junit.Test;
import gestore_db.RimozioneJooq;

public class Test_Rimozioni implements MetodiDaTestare{
	
	//NOTA: alcuni test sono commentati per evitare complicazioni nelle operazioni di Maven install
	//tutti i test in sè sono corretti se eseguiti singolarmente
	//i dati rimossi sono inseriti nel database dai test della classe Test_Inserimenti

	@Test
	public void testDegente() {
		int risultato=RimozioneJooq.getIstanza().degente("D13");
		//D13 non è nel database, quindi la rimozione fallisce, restituendo 0
		assertEquals(0,risultato);
	}
	
	
	@Test
	public void testDegente2() {
		int risultato=RimozioneJooq.getIstanza().degente("D10");
		//D10 è presente, ci si aspetta che il risultato sia 5 siccome oltre al degente vengono rimossi elementi da altre 4 tabelle
		//diariaMed, diariaInf, rilevazione e assegnazioneLetto
		assertEquals(5,risultato);
		
	}
	
	@Test
	public void testPersonale() {
		//P100 non è nel database, quindi la rimozione fallisce, restituendo 0
		int risultato=RimozioneJooq.getIstanza().personale("P100");
		assertEquals(0,risultato);
	}
	
	@Test
	public void testPersonale2() {
		/* test commentato, fallisce se eseguito più volte di seguito senza che ogni volta venga eseguito
		 * il reinserimento del dato del personale
		//P10 è nel database, la rimozione ha successo e restituisce 1
		int risultato=RimozioneJooq.getIstanza().personale("P10");
		assertEquals(1,risultato);
		*/
	}

	@Test
	public void testDiariaInf() {
		int risultato;
		//rimozione di una diaria inesistente fallisce, restituendo 0
		risultato=RimozioneJooq.getIstanza().diariaInf(1,"D4");
		assertEquals(0,risultato);
	}
	
	@Test
	public void testDiariaInf2() {
		/* test commentato, fallisce se eseguito dopo testDegente2 in quanto prova a rimuovere una diaria
		 * già rimossa a causa della rimozione del degente a cui è assegnata
		int risultato;
		//rimozione di una diaria esistente ha successo
		risultato=RimozioneJooq.getIstanza().diariaInf(1, "D10");
		assertEquals(1,risultato);	
		*/
	}

	@Test
	public void testDiariaMed() {
		int risultato;
		//rimozione di una diaria inesistente fallisce, restituendo 0
		risultato=RimozioneJooq.getIstanza().diariaMed(1,"D4");
		assertEquals(0,risultato);
	}
	
	@Test
	public void testDiariaMed2() {
		/* test commentato, fallisce se eseguito dopo testDegente2 in quanto prova a rimuovere una diaria
		 * già rimossa a causa della rimozione del degente a cui è assegnata
		int risultato;
		//rimozione di una diaria esistente ha successo
		risultato=RimozioneJooq.getIstanza().diariaMed(1, "D10");
		assertEquals(1,risultato);
		*/
	}

	@Test
	public void testReparto() {
		int risultato;
		//rimozione di un reparto inesistente fallisce, restituendo 0
		risultato=RimozioneJooq.getIstanza().reparto("Re24");
		assertEquals(0,risultato);
		
	}
	
	@Test
	public void testReparto2() {
		/* test commentato, fallisce se eseguita dopo testDegente2 
		int risultato;
		//rimozione di un reparto esistente ha successo
		risultato=RimozioneJooq.getIstanza().reparto("Re3");
		//ci aspettiamo risultato=3, vengono eliminati un reparto, un modulo, dei letti 
		//(assegnazioneLetto già rimossa con la rimozione del degente)
		assertEquals(3,risultato);
		*/
		
	}

	@Test
	public void testModulo() {
		//rimozione di un modulo inesistente fallisce, restituendo 0
		int risultato=RimozioneJooq.getIstanza().modulo("Re24", "ModuloA");
		assertEquals(0,risultato);
		
	}
	
	@Test
	public void testModulo2() {
		/*test commentato, in quanto fallisce se eseguito dopo testReparto2
		//rimozione di un modulo esistente ha successo
		int risultato=RimozioneJooq.getIstanza().modulo("Re3", "ModuloA");
		//ci aspettiamo risultato=3, vengono eliminati un modulo, un letto e un'assegnazione letto
		assertEquals(3,risultato);	
		*/
	}

	@Test
	public void testLetto() {
		//rimozione di un letto inesistente fallisce, restituendo 0
		int risultato=RimozioneJooq.getIstanza().letto("Re24","ModuloA",2);
		assertEquals(0,risultato);	
	}

	@Test
	public void testLetto2() {
		/*test commentato, in quanto fallisce se eseguito dopo testReparto2 o testModulo2
		//rimozione di un letto esistente ha successo
		int risultato=RimozioneJooq.getIstanza().letto("Re3", "ModuloA",1);
		//ci aspettiamo risultato=2, vengono eliminati un letto e un'assegnazione letto
		assertEquals(2,risultato);
		*/
	}

	
	@Test
	public void testAssegnazioneLetto() {
		//rimozione di un'assegnazione letto inesistente fallisce, restituendo 0
		int risultato=RimozioneJooq.getIstanza().assegnazioneLetto("D2","Re2","ModuloA",10);
		assertEquals(0,risultato);
	}
	
	@Test
	public void testAssegnazioneLetto2() {		
		/* test commentato, fallisce se eseguito dopo testDegente2 o dopo la rimozione del letto in qualunque modo
		//rimozione di un'assegnazione letto esistente ha successo
		int risultato=RimozioneJooq.getIstanza().assegnazioneLetto("D10","Re3", "ModuloA",1);
		assertEquals(1,risultato);
		*/
	}

	@Test
	public void testRilevazione() {
		//rimozione di una rilevazione inesistente fallisce, restituendo 0
		int risultato=RimozioneJooq.getIstanza().rilevazione(15,"D2");
		assertEquals(0,risultato);
	}
	
	@Test
	public void testRilevazione2() {	
		/*test commentato, fallisce se eseguito dopo testDegente2 in quanto prova a rimuovere 
		 * una rilevazione già rimossa a causa della rimozione del degente a cui è assegnata
		//rimozione di una rilevazione esistente ha successo
		int risultato=RimozioneJooq.getIstanza().rilevazione(1,"D10");
		assertEquals(1,risultato);
		*/
	}

}
