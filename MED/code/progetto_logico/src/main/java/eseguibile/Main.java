package eseguibile;

import gui.*;
import logiche_bottoni.*;

public class Main {

	public static void main(String[] args) {
		try {
			LoginFrame frameLogin = new LoginFrame();
			new LoginLogic(frameLogin);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
