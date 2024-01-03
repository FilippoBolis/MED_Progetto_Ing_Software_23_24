package logiche_bottoni_login;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gui.*;
import med_db.jooq.generated.tables.Personale;

public class loginLogic {
	
	LoginFrame view;
	public static String DB_REL_FILELOGIC = "../progetto_database/db/db.db3";
	public static String DB_URLLOGIC = "jdbc:sqlite:" + DB_REL_FILELOGIC;
    private static Lock lock = new ReentrantLock();
	
	public loginLogic(LoginFrame v) {
		// prede i refs
		view = v;
		registerLogin();
	}
	
	private void registerLogin() {
		
		// si registra al bottone loginButton
		view.loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (lock.tryLock()) {
					try {
						lock.lock();
						logica();
					}
					finally {
						lock.unlock();
					}
				}
			}
		});
	}
	
	private void logica() {
		try {
			Connection conn = DriverManager.getConnection(DB_URLLOGIC);
			if (conn != null) {
				DSLContext contesto = DSL.using(conn, SQLDialect.SQLITE);
				String utente = view.userField.getText();
				String password = new String(view.passwordField.getPassword());
				int result = contesto.select().from(Personale.PERSONALE).where(Personale.PERSONALE.PASSWORD.eq(password).and(Personale.PERSONALE.CODICE.eq(utente))).execute();
				if (result == 1) {
					System.out.println("ok");
					view.sfondoFrame.setVisible(false);
				}
				else {
					System.out.println("non ok");
				}
			}
		} catch (SQLException ev) {
			System.out.println(ev.getMessage());
		}
	}
}
