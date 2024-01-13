package classi_test_db;

import static org.junit.Assert.*;

import org.junit.Test;

import gestore_db.AggiornamentiJooq;

public class Test_Aggiornamenti implements MetodiDaTestare{

	@Test
	public void testDegente() {
		int risultato=AggiornamentiJooq.getIstanza().degente("D3", "urgenza", "verde");
		assertEquals(1,risultato);
	}
	
	@Test
	public void testPersonale() {
		int risultato=AggiornamentiJooq.getIstanza().personale("P2", "CaviAreMyLife");
		assertEquals(1,risultato);
	}
	
	@Test
	public void testDiariaInf() {
		int risultato=AggiornamentiJooq.getIstanza().diariaInf(1, "D1", "true");
		assertEquals(1,risultato);
	}
	
	@Test
	public void testDIariaMed() {
		int risultato=AggiornamentiJooq.getIstanza().diariaMed(1, "D1", "farmaci", "trembolone");
		assertEquals(1,risultato);
	}

	//i seguenti metodi non vanno testati perchè non presenti nella classe da testare
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

}
