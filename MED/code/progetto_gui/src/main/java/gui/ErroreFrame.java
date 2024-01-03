package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErroreFrame {
	
	public ErroreFrame(JFrame frame, String messaggio) {
		
		JOptionPane.showMessageDialog(frame, messaggio, "Errore", JOptionPane.ERROR_MESSAGE);

	}
}
