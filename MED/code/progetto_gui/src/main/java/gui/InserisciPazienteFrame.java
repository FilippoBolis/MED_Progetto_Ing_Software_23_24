package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class InserisciPazienteFrame {
	
	ImageIcon aggiungiPazienteImage = new ImageIcon("../progetto_gui/src/main/resources/inserisci_paziente.png");
	public JFrame sfondoFrame;
	public JTextField codiceTextField;
	public JTextField nomeTextField;
	public JTextField cognomeTextField;
	public JComboBox<String> sessoComboBox;
	public JComboBox<String> urgenzaComboBox;
	public JButton confermaButton;
	
	public InserisciPazienteFrame() {
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(530, 533);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Inserisci nuovo paziente</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);
	
		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);
		
		JPanel aggiungiPazientePanel = new JPanel();
		aggiungiPazientePanel.setBounds(10, 10, 496, 475);
		aggiungiPazientePanel.setBackground(Color.WHITE);
		aggiungiPazientePanel.setLayout(null);
		sfondoPanel.add(aggiungiPazientePanel);
		
		JLabel titoloLabel = new JLabel("Inserisci nuovo paziente");
		titoloLabel.setBounds(100, 30, 366, 48);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO_FINESTRE.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		aggiungiPazientePanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(30, 30, 48, 48);
		immagineLabel.setIcon(aggiungiPazienteImage);
		aggiungiPazientePanel.add(immagineLabel);
		
		JLabel codiceLabel = new JLabel("Codice");
		codiceLabel.setBounds(30, 96, 436, 30);
		codiceLabel.setForeground(Color.GRAY);
		codiceLabel.setFont(Stile.TESTO.getFont());
		aggiungiPazientePanel.add(codiceLabel);
		
		codiceTextField = new JTextField();
		codiceTextField.setBounds(30, 129, 436, 30);
		codiceTextField.setColumns(30);
		aggiungiPazientePanel.add(codiceTextField);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(30, 162, 436, 30);
		nomeLabel.setForeground(Color.GRAY);
		nomeLabel.setFont(Stile.TESTO.getFont());
		aggiungiPazientePanel.add(nomeLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(30, 195, 436, 30);
		nomeTextField.setColumns(30);
		aggiungiPazientePanel.add(nomeTextField);
		
		JLabel cognomeLabel = new JLabel("Cognome");
		cognomeLabel.setBounds(30, 228, 436, 30);
		cognomeLabel.setForeground(Color.GRAY);
		cognomeLabel.setFont(Stile.TESTO.getFont());
		aggiungiPazientePanel.add(cognomeLabel);
		
		cognomeTextField = new JTextField();
		cognomeTextField.setBounds(30, 261, 436, 30);
		cognomeTextField.setColumns(30);
		aggiungiPazientePanel.add(cognomeTextField);
		
		JLabel sessoLabel = new JLabel("Sesso");
		sessoLabel.setBounds(30, 294, 436, 30);
		sessoLabel.setForeground(Color.GRAY);
		sessoLabel.setFont(Stile.TESTO.getFont());
		aggiungiPazientePanel.add(sessoLabel);
		
		sessoComboBox = new JComboBox<String>();
		sessoComboBox.addItem("maschio");
		sessoComboBox.addItem("femmina");
		sessoComboBox.setBounds(30, 327, 436, 30);
		aggiungiPazientePanel.add(sessoComboBox);
		
		JLabel urgenzaLabel = new JLabel("Urgenza");
		urgenzaLabel.setBounds(30, 360, 436, 30);
		urgenzaLabel.setForeground(Color.GRAY);
		urgenzaLabel.setFont(Stile.TESTO.getFont());
		aggiungiPazientePanel.add(urgenzaLabel);
		
		urgenzaComboBox = new JComboBox<String>();
		urgenzaComboBox.addItem("verde");
		urgenzaComboBox.addItem("giallo");
		urgenzaComboBox.addItem("rosso");
		urgenzaComboBox.setBounds(30, 393, 436, 30);
		aggiungiPazientePanel.add(urgenzaComboBox);
		
        confermaButton = new JButton("Conferma");
		confermaButton.setBounds(346, 434, 120, 30);
		confermaButton.setBackground(Stile.AZZURRO.getColore());
		confermaButton.setForeground(Color.WHITE);
		confermaButton.setFont(Stile.SOTTOTITOLO.getFont());
		aggiungiPazientePanel.add(confermaButton);

		sfondoFrame.setVisible(true);
	
	}
}
