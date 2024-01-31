package logiche_bottoni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;
import modelli.ModelloGestoreLogicaGenerale;


public class LogicaBottoneLogout extends LogicaBottone{
	
	/**Controllore del pulsante "Logout".
	 * Permette a un utente di uscire dal sistema una volta terminate le operazioni necessarie
	 */
	public LogicaBottoneLogout(PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		super(v2,m);
		start();
	}
	
	/**Alla pressione del pulsante, la schermata principale con sezioni e degenti viene chiusa 
	 * e si ritorna alla schermata di login
	 */
	protected void start() {
		//si registra al bottone prontoSoccorsoToggleButton
		frameDeiPazienti.logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			frameDeiPazienti.sfondoFrame.dispose();
			LoginFrame loginFrame = new LoginFrame();
			new LogicaLogin(loginFrame,modello);
			}
		});
	}
}
