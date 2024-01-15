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
import modelli.ModelloGestoreLogicaGenerale;

public class AggiungiPazienteFrame {
	
	ImageIcon aggiungiPazienteImage = new ImageIcon("../progetto_gui/src/main/resources/aggiungi_paziente.png");
	public JFrame sfondoFrame;
	public JTextField codiceTextField;
	public JTextField nomeTextField;
	public JTextField cognomeTextField;
	public JComboBox<String> sessoComboBox;
	public JComboBox<String> urgenzaComboBox;
	public JButton confermaButton;
	
	public AggiungiPazienteFrame(ModelloGestoreLogicaGenerale modello) {
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(680, 400);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Aggiungi Diaria</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setAlwaysOnTop(true);
		sfondoFrame.setResizable(false);
	
		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);
		
		JPanel aggiungiPazientePanel = new JPanel();
		aggiungiPazientePanel.setBounds(10, 10, 646, 342);
		aggiungiPazientePanel.setBackground(Color.WHITE);
		aggiungiPazientePanel.setLayout(null);
		sfondoPanel.add(aggiungiPazientePanel);
		
		JLabel titoloLabel = new JLabel("Inserisci Nuovo Paziente");
		titoloLabel.setBounds(10, 11, 519, 40);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		aggiungiPazientePanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(356, 33, 48, 48);
		immagineLabel.setIcon(aggiungiPazienteImage);
		aggiungiPazientePanel.add(immagineLabel);
		
		JLabel CodiceLabel = new JLabel("Codice");
		CodiceLabel.setBounds(10, 74, 116, 21);
		aggiungiPazientePanel.add(CodiceLabel);
		
		codiceTextField = new JTextField();
		codiceTextField.setBounds(153, 74, 96, 20);
		aggiungiPazientePanel.add(codiceTextField);
		codiceTextField.setColumns(10);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(10, 120, 137, 21);
		aggiungiPazientePanel.add(nomeLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(153, 120, 96, 20);
		aggiungiPazientePanel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		JLabel cognomeLabel = new JLabel("Cognome");
		cognomeLabel.setBounds(10, 168, 137, 21);
		aggiungiPazientePanel.add(cognomeLabel);
		
		cognomeTextField = new JTextField();
		cognomeTextField.setBounds(153, 168, 96, 20);
		aggiungiPazientePanel.add(cognomeTextField);
		cognomeTextField.setColumns(10);
		
		JLabel sessoLabel = new JLabel("Sesso");
		sessoLabel.setBounds(10, 200, 128, 27);
		aggiungiPazientePanel.add(sessoLabel);
		
		sessoComboBox = new JComboBox<String>();
		sessoComboBox.setBounds(149, 203, 100, 21);
		aggiungiPazientePanel.add(sessoComboBox);
		
		JLabel urgenzaLabel = new JLabel("Urgenza");
		urgenzaLabel.setBounds(10, 230, 128, 27);
		aggiungiPazientePanel.add(urgenzaLabel);
		
		urgenzaComboBox = new JComboBox<String>();
		urgenzaComboBox.setBounds(153, 235, 100, 21);
		aggiungiPazientePanel.add(urgenzaComboBox);
		
        confermaButton = new JButton("Conferma");
		confermaButton.setBounds(440, 309, 89, 23);
		aggiungiPazientePanel.add(confermaButton);

		sfondoFrame.setVisible(true);
	
	}
	
}
