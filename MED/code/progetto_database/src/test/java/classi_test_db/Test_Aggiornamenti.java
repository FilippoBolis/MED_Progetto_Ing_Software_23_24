package classi_test_db;

import static org.junit.Assert.*;

import org.junit.Test;

import gestore_db.AggiornamentiJooq;

public class Test_Aggiornamenti implements MetodiDaTestare{
 
	@Test
	public void testDegente() {
		//prove varie di errato tentativo di modifica
		int risultato;
		risultato=AggiornamentiJooq.getIstanza().degente("D3", "asdf", "verde");
		assertEquals(0,risultato);
		
		risultato=AggiornamentiJooq.getIstanza().degente("D3", "urgenza", "arancione");
		assertEquals(0,risultato);
		
		risultato=AggiornamentiJooq.getIstanza().degente("D3", "sesso", "AAA");
		assertEquals(0,risultato);
	}
	
	@Test
	public void testDegente2() {
		int risultato=AggiornamentiJooq.getIstanza().degente("D3", "urgenza", "verde");
		assertEquals(1,risultato);
	}
	
	@Test
	public void testPersonale() {
		int risultato=AggiornamentiJooq.getIstanza().personale("P45", "CaviAreMyLife");
		assertEquals(0,risultato);
	}
	
	@Test
	public void testPersonale2() {
		int risultato=AggiornamentiJooq.getIstanza().personale("P2", "CaviAreMyLife");
		assertEquals(1,risultato);
	}
	
	@Test
	public void testDiariaInf() {
		//tentativo di inserire dati errati
		int risultato=AggiornamentiJooq.getIstanza().diariaInf(1, "D1", "aaaaa");
		assertEquals(0,risultato);
	}
	
	@Test
	public void testDiariaInf2() {
		int risultato=AggiornamentiJooq.getIstanza().diariaInf(1, "D1", "true");
		assertEquals(1,risultato);
	}
	
	@Test
	public void testDiariaMed() {
		//tentativo di modificare dati non presenti
		int risultato=AggiornamentiJooq.getIstanza().diariaMed(14, "D1", "farmaci", "trembolone");
		assertEquals(0,risultato);
		
		//tentativo di modificare un attributo inesistente
		risultato=AggiornamentiJooq.getIstanza().diariaMed(1, "D1", "asdf", "trembolone");
		assertEquals(0,risultato);
	}

	@Test
	public void testDiariaMed2() {
		int risultato=AggiornamentiJooq.getIstanza().diariaMed(1, "D1", "farmaci", "trembolone");
		assertEquals(1,risultato);
	}

	//i seguenti metodi non vanno testati perchè non presenti nella classe AggiornamentiJooq
	
	@Override
	public void testReparto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testModulo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testLetto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testAssegnazioneLetto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testRilevazione() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testReparto2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testModulo2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testLetto2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testAssegnazioneLetto2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testRilevazione2() {
		// TODO Auto-generated method stub
		
	}

}
