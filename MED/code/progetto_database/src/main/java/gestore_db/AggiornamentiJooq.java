package gestore_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import med_db.jooq.generated.tables.*;

public class AggiornamentiJooq {
	
	public void personale(String ID, String attr, String newVal) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				switch(attr) {
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void degente(String cod, String attr, String newVal) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				switch(attr) {
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void rilevazione(String attr) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				switch(attr) {
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void reparto(String attr) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				switch(attr) {
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void modulo(String attr) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				switch(attr) {
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void letto(String attr) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				switch(attr) {
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void assegnazioneLetto(String attr) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				switch(attr) {
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void diariaInf(String attr) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				switch(attr) {
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void diariaMed(String attr) {
		try {
			Connection conn = DriverManager.getConnection(CreateDB.DB_URL);
			if (conn != null) {
				switch(attr) {
				default:
					System.out.println("Attributo da modificare selezionato non valido");
					break;
				}
		
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		
	}

}
