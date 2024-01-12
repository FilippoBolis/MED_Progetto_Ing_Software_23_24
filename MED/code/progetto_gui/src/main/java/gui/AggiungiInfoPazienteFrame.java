package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class AggiungiInfoPazienteFrame {
	private ImageIcon diariaImage = new ImageIcon("../progetto_gui/src/main/resources/aggiungi_info.png");
	public JFrame sfondoFrame;
	public JTextArea informazioniTextArea;
	public JButton confermaButton;
	
	public AggiungiInfoPazienteFrame() {
		
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(680, 400);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Aggiungi Info Paziente</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);
		
		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBounds(10, 10, 646, 342);
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setLayout(null);
		sfondoPanel.add(infoPanel);
		
		JLabel titoloLabel = new JLabel("Aggiungi Informazioni Paziente");
		titoloLabel.setBounds(10, 11, 519, 40);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(539, 29, 48, 48);
		immagineLabel.setIcon(diariaImage);
		infoPanel.add(immagineLabel);
		
		JLabel informazioniLabel = new JLabel("Informazioni");
		informazioniLabel.setBounds(22, 88, 137, 21);
		infoPanel.add(informazioniLabel);
		
		JTextArea informazioniTextArea = new JTextArea();
		informazioniTextArea.setBounds(143, 99, 218, 92);
		informazioniTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
        informazioniTextArea.setLineWrap(true); // Abilita il riavvolgimento automatico delle righe
        informazioniTextArea.setWrapStyleWord(true); // Abilita il riavvolgimento delle parole
		infoPanel.add(informazioniTextArea);
		
        confermaButton = new JButton("Conferma");
		confermaButton.setBounds(440, 309, 89, 23);
		infoPanel.add(confermaButton);

		sfondoFrame.setVisible(true);
	
	}
	/*
	public static void main(String[] args) {
		new AggiungiInfoPazienteFrame();
	}
	*/
}
