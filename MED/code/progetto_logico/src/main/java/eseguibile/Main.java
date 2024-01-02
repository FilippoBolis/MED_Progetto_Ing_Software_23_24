package eseguibile;

import gui.*;
import logiche_bottoni_login.*;

public class Main {

	public static void main(String[] args) {
		try {
			LoginFrame frameLogin = new LoginFrame();
			new loginLogic(frameLogin);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
