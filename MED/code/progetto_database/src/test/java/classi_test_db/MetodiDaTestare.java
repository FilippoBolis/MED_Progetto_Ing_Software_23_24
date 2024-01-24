package classi_test_db;

public interface MetodiDaTestare {

	//2 test per ogni tabella: 
	//uno per il corretto svolgimento del metodo, uno per il suo fallimento in caso di dati inseriti errati
	public void testDegente();
	public void testDegente2();
	public void testPersonale();
	public void testPersonale2();
	public void testDiariaInf();
	public void testDiariaInf2();
	public void testDiariaMed();
	public void testDiariaMed2();
	public void testReparto();
	public void testReparto2();
	public void testModulo();
	public void testModulo2();
	public void testLetto();
	public void testLetto2();
	public void testAssegnazioneLetto();
	public void testAssegnazioneLetto2();
	public void testRilevazione();
	public void testRilevazione2();
}
