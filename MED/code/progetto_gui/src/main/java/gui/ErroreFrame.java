package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Classe contenente il frame per gestire gli errori;
 * tutti gli errori dell'utente sono gestiti inviando al metodo di questa classe il messaggio da stampare a schermo;
 * sono stati utilizzati java swing e WindowBuilder
 */
public class ErroreFrame {
	
	/**
	 * @param frame contiene il frame il cui errato utilizzo ha generato un errore
	 * @param messaggio stringa contenente la motivazione dell'errore e possibile soluzione
	 */
	public ErroreFrame(JFrame frame, String messaggio) {
		
		JOptionPane.showMessageDialog(frame, messaggio, "Errore", JOptionPane.ERROR_MESSAGE);

	}
}
