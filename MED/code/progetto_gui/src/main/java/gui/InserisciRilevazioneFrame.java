package gui;

import java.awt.Color;
import java.awt.Graphics;

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

/**
 * Classe contenente il frame per gestire l'inserimento di una nuova rilevazione;
 * contiene solo parte grafica, è resa utilizzabile dal progetto_logico;
 * sono stati utilizzati java swing e WindowBuilder
 */
public class InserisciRilevazioneFrame {
	
	ImageIcon rilevazioneImage = new ImageIcon("../progetto_gui/src/main/resources/inserisci_rilevazione.png");
	public JFrame sfondoFrame;
	public JTextField glicemiaTextField;
	public JTextField temperaturaTextField;
	public JTextField pressioneMaxTextField;
	public JTextField pressioneMinTextField;
	public JTextField frequenzaTextField;
	public JTextField doloreTextField;
	public JButton confermaButton;

	@SuppressWarnings("serial")
	public InserisciRilevazioneFrame() {

		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(530, 599);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Inserisci rilevazione</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel rilevazionePanel = new JPanel();
		rilevazionePanel.setBounds(10, 10, 496, 541);
		rilevazionePanel.setBackground(Color.WHITE);
		rilevazionePanel.setLayout(null);
		sfondoPanel.add(rilevazionePanel);

		JLabel inserisciRilevazioneLabel = new JLabel("Inserisci rilevazione");
		inserisciRilevazioneLabel.setBounds(100, 30, 366, 48);
		inserisciRilevazioneLabel.setForeground(Stile.BLU_SCURO.getColore());
		inserisciRilevazioneLabel.setFont(Stile.TITOLO_FINESTRE.getFont());
		inserisciRilevazioneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rilevazionePanel.add(inserisciRilevazioneLabel);

		JLabel immagineLabel = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(rilevazioneImage.getImage(), 0 , 0, this.getWidth(), this.getHeight(), this);
			}
		};
		immagineLabel.setBounds(30, 30, 48, 48);
		rilevazionePanel.add(immagineLabel);

		JLabel pressioneMaxLabel = new JLabel("Pressione Max (mmHg)");
		pressioneMaxLabel.setBounds(30, 96, 436, 30);
		pressioneMaxLabel.setForeground(Color.GRAY);
		pressioneMaxLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(pressioneMaxLabel);
		
		pressioneMaxTextField = new JTextField();
		pressioneMaxTextField.setBounds(30, 129, 436, 30);
		pressioneMaxTextField.setColumns(30);
		rilevazionePanel.add(pressioneMaxTextField);

		JLabel pressioneMinLabel = new JLabel("Pressione Min (mmHg)");
		pressioneMinLabel.setBounds(30, 162, 436, 30);
		pressioneMinLabel.setForeground(Color.GRAY);
		pressioneMinLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(pressioneMinLabel);
		
		pressioneMinTextField = new JTextField();
		pressioneMinTextField.setBounds(30, 195, 436, 30);
		pressioneMinTextField.setColumns(30);
		rilevazionePanel.add(pressioneMinTextField);
		
		JLabel frequenzaLabel = new JLabel("Frequenza Cardiaca (bpm)");
		frequenzaLabel.setBounds(30, 228, 436, 30);
		frequenzaLabel.setForeground(Color.GRAY);
		frequenzaLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(frequenzaLabel);
		
		frequenzaTextField = new JTextField();
		frequenzaTextField.setBounds(30, 261, 436, 30);
		frequenzaTextField.setColumns(30);
		rilevazionePanel.add(frequenzaTextField);
	
		JLabel temperaturaLabel = new JLabel("Temperatura (°C)");
		temperaturaLabel.setBounds(30, 294, 436, 30);
		temperaturaLabel.setForeground(Color.GRAY);
		temperaturaLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(temperaturaLabel);

		temperaturaTextField = new JTextField();
		temperaturaTextField.setBounds(30, 327, 436, 30);
		temperaturaTextField.setColumns(30);
		rilevazionePanel.add(temperaturaTextField);

		JLabel glicemiaLabel = new JLabel("Glicemia (mg/dL)");
		glicemiaLabel.setBounds(30, 360, 436, 30);
		glicemiaLabel.setForeground(Color.GRAY);
		glicemiaLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(glicemiaLabel);
		
		glicemiaTextField = new JTextField();
		glicemiaTextField.setBounds(30, 393, 436, 30);
		glicemiaTextField.setColumns(30);
		rilevazionePanel.add(glicemiaTextField);

		JLabel doloreLabel = new JLabel("Dolore (1/10)");
		doloreLabel.setBounds(30, 426, 436, 30);
		doloreLabel.setForeground(Color.GRAY);
		doloreLabel.setFont(Stile.TESTO.getFont());
		rilevazionePanel.add(doloreLabel);
		
		doloreTextField = new JTextField();
		doloreTextField.setBounds(30, 459, 436, 30);
		sfondoFrame.setVisible(true);
		doloreTextField.setColumns(30);
		rilevazionePanel.add(doloreTextField);

		confermaButton = new JButton("Conferma");
		confermaButton.setBounds(346, 500, 120, 30);
		confermaButton.setBackground(Stile.AZZURRO.getColore());
		confermaButton.setForeground(Color.WHITE);
		confermaButton.setFont(Stile.SOTTOTITOLO.getFont());
		rilevazionePanel.add(confermaButton);
	}

}
