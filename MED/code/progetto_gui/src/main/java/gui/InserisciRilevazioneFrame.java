package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class InserisciRilevazioneFrame {
	ImageIcon insRilevazioneImage = new ImageIcon("../progetto_gui/src/main/resources/rilevazioni.png");
	public JFrame sfondoFrame;
	public JTextField glicemiaTextField;
	public JTextField temperaturaTextField;
	public JTextField pressioneTextField;
	public JTextField frequenzaTextField;
	public JTextField doloreTextField;

	public InserisciRilevazioneFrame() {

		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(680, 400);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Inserisci Rilevazione </font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel rilevazionePanel = new JPanel();
		rilevazionePanel.setBounds(10, 10, 646, 342);
		rilevazionePanel.setBackground(Color.WHITE);
		rilevazionePanel.setLayout(null);
		sfondoPanel.add(rilevazionePanel);

		JLabel inserisciRilevazioneLabel = new JLabel("Inserisci Rilevazione");
		inserisciRilevazioneLabel.setBounds(10, 11, 296, 40);
		inserisciRilevazioneLabel.setForeground(Stile.BLU_SCURO.getColore());
		inserisciRilevazioneLabel.setFont(Stile.TITOLO.getFont());
		inserisciRilevazioneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rilevazionePanel.add(inserisciRilevazioneLabel);

		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(316, 14, 48, 48);
		immagineLabel.setIcon(insRilevazioneImage);
		rilevazionePanel.add(immagineLabel);

		JLabel glicemiaLabel = new JLabel("Glicemia");
		glicemiaLabel.setBounds(10, 93, 137, 21);
		rilevazionePanel.add(glicemiaLabel);
		
		glicemiaTextField = new JTextField();
		glicemiaTextField.setBounds(127, 93, 86, 20);
		rilevazionePanel.add(glicemiaTextField);
		glicemiaTextField.setColumns(10);

		JLabel temperaturaLabel = new JLabel("Temperatura");
		temperaturaLabel.setBounds(10, 128, 96, 20);
		rilevazionePanel.add(temperaturaLabel);

		temperaturaTextField = new JTextField();
		temperaturaTextField.setBounds(127, 128, 86, 20);
		rilevazionePanel.add(temperaturaTextField);
		temperaturaTextField.setColumns(10);
		
		JLabel pressioneLabel = new JLabel("Pressione");
		pressioneLabel.setBounds(10, 168, 65, 14);
		rilevazionePanel.add(pressioneLabel);
		
		pressioneTextField = new JTextField();
		pressioneTextField.setBounds(127, 165, 86, 20);
		rilevazionePanel.add(pressioneTextField);
		pressioneTextField.setColumns(10);

		JLabel frequenzaLabel = new JLabel("Frequenza Cardiaca");
		frequenzaLabel.setBounds(10, 203, 107, 14);
		rilevazionePanel.add(frequenzaLabel);
		
		frequenzaTextField = new JTextField();
		frequenzaTextField.setBounds(127, 200, 86, 20);
		rilevazionePanel.add(frequenzaTextField);
		frequenzaTextField.setColumns(10);

		JLabel doloreLabel = new JLabel("Dolore");
		doloreLabel.setBounds(10, 236, 46, 14);
		rilevazionePanel.add(doloreLabel);
		
		doloreTextField = new JTextField();
		doloreTextField.setBounds(127, 233, 86, 20);
		rilevazionePanel.add(doloreTextField);
		doloreTextField.setColumns(10);
		sfondoFrame.setVisible(true);

		JButton confermaButton = new JButton("Conferma");
		confermaButton.setBounds(440, 309, 89, 23);
		rilevazionePanel.add(confermaButton);
	}
	/*
	 * public static void main(String[] args) { new InserisciRilevazioneFrame(); }
	 */
}
