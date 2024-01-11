package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class InfoPazienteFrame {

	ImageIcon infoPazienteImage = new ImageIcon("../progetto_gui/src/main/resources/diaria.png");
	public JFrame sfondoFrame;

	public InfoPazienteFrame() {

		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(680, 400);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Info Paziente </font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel infoPazPanel = new JPanel();
		infoPazPanel.setBounds(10, 10, 646, 342);
		infoPazPanel.setBackground(Color.WHITE);
		infoPazPanel.setLayout(null);
		sfondoPanel.add(infoPazPanel);

		JLabel infoPazienteLabel = new JLabel("Info Paziente");
		infoPazienteLabel.setBounds(10, 11, 261, 40);
		infoPazienteLabel.setForeground(Stile.BLU_SCURO.getColore());
		infoPazienteLabel.setFont(Stile.TITOLO.getFont());
		infoPazienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoPazPanel.add(infoPazienteLabel);

		JButton annullaButton = new JButton("Indietro");
		annullaButton.setBounds(256, 309, 89, 23);
		infoPazPanel.add(annullaButton);

		JButton confermaButton = new JButton("Modifica");
		confermaButton.setBounds(440, 309, 89, 23);
		infoPazPanel.add(confermaButton);

		JLabel noteLabel = new JLabel("Nota");
		noteLabel.setBounds(51, 84, 55, 14);
		infoPazPanel.add(noteLabel);

		JTextArea noteTextArea = new JTextArea();
		noteTextArea.setBounds(127, 80, 108, 69);
		noteTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		noteTextArea.setLineWrap(true); // Abilita il riavvolgimento automatico delle righe
		noteTextArea.setWrapStyleWord(true);
		infoPazPanel.add(noteTextArea);
		sfondoFrame.setVisible(true);

	}
	/*
	 * public static void main(String[] args) { new InfoPazienteFrame(); }
	 */

}
