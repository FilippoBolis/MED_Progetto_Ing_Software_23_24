package sql;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {

	public static String DB_REL_FILE= "./db/db.db3";
	public static String DB_URL= "jdbc:sqlite:" + DB_REL_FILE;
	
	
	public static void main(String[] args) throws IOException, SQLException {
		if (new File(DB_REL_FILE).exists()) {
			System.out.println("Il DB gia' esiste");
		}
		else {
			Connection conn = DriverManager.getConnection(DB_URL);
			System.out.println("Il DB e' stato creato");
			
		}
	}

}
