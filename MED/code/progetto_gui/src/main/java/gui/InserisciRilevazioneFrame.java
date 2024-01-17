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
	ImageIcon insRilevazioneImage = new ImageIcon("../progetto_gui/src/main/resources/aggiungi_rilevazioni.png");
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
		sfondoFrame.setSize(530, 533);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Inserisci rilevazione </font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel rilevazionePanel = new JPanel();
		rilevazionePanel.setBounds(10, 10, 496, 475);
		rilevazionePanel.setBackground(Color.WHITE);
		rilevazionePanel.setLayout(null);
		sfondoPanel.add(rilevazionePanel);

		JLabel inserisciRilevazioneLabel = new JLabel("Inserisci rilevazione");
		inserisciRilevazioneLabel.setBounds(100, 30, 366, 48);
		inserisciRilevazioneLabel.setForeground(Stile.BLU_SCURO.getColore());
		inserisciRilevazioneLabel.setFont(Stile.TITOLO_FINESTRE.getFont());
		inserisciRilevazioneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rilevazionePanel.add(inserisciRilevazioneLabel);

		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(30, 30, 48, 48);
		immagineLabel.setIcon(insRilevazioneImage);
		rilevazionePanel.add(immagineLabel);

		JLabel glicemiaLabel = new JLabel("Glicemia");
		glicemiaLabel.setBounds(30, 96, 436, 30);
		glicemiaLabel.setForeground(Color.GRAY);
		glicemiaLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(glicemiaLabel);
		
		glicemiaTextField = new JTextField();
		glicemiaTextField.setBounds(30, 129, 436, 30);
		glicemiaTextField.setColumns(30);
		rilevazionePanel.add(glicemiaTextField);

		JLabel temperaturaLabel = new JLabel("Temperatura");
		temperaturaLabel.setBounds(30, 162, 436, 30);
		temperaturaLabel.setForeground(Color.GRAY);
		temperaturaLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(temperaturaLabel);

		temperaturaTextField = new JTextField();
		temperaturaTextField.setBounds(30, 195, 436, 30);
		temperaturaTextField.setColumns(30);
		rilevazionePanel.add(temperaturaTextField);
		
		JLabel pressioneLabel = new JLabel("Pressione");
		pressioneLabel.setBounds(30, 228, 436, 30);
		pressioneLabel.setForeground(Color.GRAY);
		pressioneLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(pressioneLabel);
		
		pressioneTextField = new JTextField();
		pressioneTextField.setBounds(30, 261, 436, 30);
		pressioneTextField.setColumns(30);
		rilevazionePanel.add(pressioneTextField);

		JLabel frequenzaLabel = new JLabel("Frequenza Cardiaca");
		frequenzaLabel.setBounds(30, 294, 436, 30);
		frequenzaLabel.setForeground(Color.GRAY);
		frequenzaLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(frequenzaLabel);
		
		frequenzaTextField = new JTextField();
		frequenzaTextField.setBounds(30, 327, 436, 30);
		frequenzaTextField.setColumns(30);
		rilevazionePanel.add(frequenzaTextField);

		JLabel doloreLabel = new JLabel("Dolore");
		doloreLabel.setBounds(30, 360, 436, 30);
		doloreLabel.setForeground(Color.GRAY);
		doloreLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(doloreLabel);
		
		doloreTextField = new JTextField();
		doloreTextField.setBounds(30, 393, 436, 30);
		sfondoFrame.setVisible(true);
		doloreTextField.setColumns(30);
		rilevazionePanel.add(doloreTextField);

		JButton confermaButton = new JButton("Conferma");
		confermaButton.setBounds(346, 434, 120, 30);
		confermaButton.setBackground(Stile.AZZURRO.getColore());
		confermaButton.setForeground(Color.WHITE);
		confermaButton.setFont(Stile.SOTTOTITOLO.getFont());
		rilevazionePanel.add(confermaButton);
	}

}
