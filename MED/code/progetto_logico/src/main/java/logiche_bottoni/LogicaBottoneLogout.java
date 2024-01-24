package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import modelli.ModelloGestoreLogicaGenerale;

public class LogicaBottoneLogout extends LogicaBottone{
	
	
	public LogicaBottoneLogout(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			frameDeiPazienti.sfondoFrame.dispose();
			LoginFrame loginFrame = new LoginFrame();
			new LoginLogic(loginFrame,modello);
			}
		});
	}
}
