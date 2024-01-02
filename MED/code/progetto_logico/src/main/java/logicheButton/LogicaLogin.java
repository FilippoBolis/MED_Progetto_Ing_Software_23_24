package logicheButton;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class LogicaLogin {
	 private final DSLContext contesto = DSL.using(SQLDialect.SQLITE);
	 
	public void premuto(String username, String password) {
		 Result<Record> result = contesto
		            .select()
		            //.from(Tables.PERSONALE)
		           // .where(Tables.PERSONALE.CODICE.eq(username)
		           //     .and(Tables.PERSONALE.PASSWORD.eq(password)))
		            .fetch();
		  // Controlla se ci sono risultati (utente autenticato) o meno
        System.out.println("Utente: " + username + " password: " + password);
        if(!result.isEmpty()) {
        	System.out.println("Utente autenticato");
        }
        else {
        	System.out.println("Utente non trovato");
        }
    }
}
