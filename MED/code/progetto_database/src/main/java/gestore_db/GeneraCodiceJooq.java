package gestore_db;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;


public class GeneraCodiceJooq {

	public static void main(String[] args) throws Exception {
		
		Jdbc JDBC = new Jdbc().withDriver("org.sqlite.JDBC").withUrl(CreateDB.DB_URL);
		Database database = new Database().withName("org.jooq.meta.sqlite.SQLiteDatabase").withIncludes(".*").withExcludes("");
		Target target = new Target().withPackageName("med_db.jooq.generated").withDirectory("src/main/java/");
		Generator generator = new Generator().withDatabase(database).withTarget(target);
		Configuration configuration = new Configuration().withJdbc(JDBC).withGenerator(generator);
		GenerationTool.generate(configuration);		
	}
}
