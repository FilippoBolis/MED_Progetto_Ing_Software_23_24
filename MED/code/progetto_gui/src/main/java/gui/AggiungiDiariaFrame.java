package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.JTextArea;

public class AggiungiDiariaFrame {

	ImageIcon diariaImage = new ImageIcon("../progetto_gui/src/main/resources/diaria.png");
	public JFrame sfondoFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public AggiungiDiariaFrame() {
		
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
		sfondoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);
		
		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);
		
		JPanel diariaPanel = new JPanel();
		diariaPanel.setBounds(10, 10, 646, 342);
		diariaPanel.setBackground(Color.WHITE);
		diariaPanel.setLayout(null);
		sfondoPanel.add(diariaPanel);
		
		JLabel loginLabel = new JLabel("Diaria Medica");
		loginLabel.setBounds(10, 11, 296, 40);
		loginLabel.setForeground(Stile.BLU_SCURO.getColore());
		loginLabel.setFont(Stile.TITOLO.getFont());
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		diariaPanel.add(loginLabel);
		
		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(316, 14, 48, 48);
		immagineLabel.setIcon(diariaImage);
		diariaPanel.add(immagineLabel);
		
		JLabel motivoLabel = new JLabel("Motivo");
		motivoLabel.setBounds(10, 74, 116, 21);
		diariaPanel.add(motivoLabel);
		
		textField = new JTextField();
		textField.setBounds(153, 74, 96, 20);
		diariaPanel.add(textField);
		textField.setColumns(10);
		
		JLabel storicoLabel = new JLabel("Storico");
		storicoLabel.setBounds(10, 120, 137, 21);
		diariaPanel.add(storicoLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 120, 96, 20);
		diariaPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel allergieLabel = new JLabel("Allergie");
		allergieLabel.setBounds(10, 169, 137, 21);
		diariaPanel.add(allergieLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(153, 169, 96, 20);
		diariaPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel farmaciLabel = new JLabel("Farmaci");
		farmaciLabel.setBounds(10, 230, 128, 27);
		diariaPanel.add(farmaciLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(165, 231, 218, 64);
		textArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
        textArea.setLineWrap(true); // Abilita il riavvolgimento automatico delle righe
        textArea.setWrapStyleWord(true); // Abilita il riavvolgimento delle parole
		diariaPanel.add(textArea);

        JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(165, 231, 218, 64);
        diariaPanel.add(scrollPane);
		
        JButton confermaButton = new JButton("Conferma");
		confermaButton.setBounds(440, 309, 89, 23);
		diariaPanel.add(confermaButton);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.setBounds(256, 309, 89, 23);
		diariaPanel.add(annullaButton);

		sfondoFrame.setVisible(true);
	
	}
	/*
	public static void main(String[] args) {
		new AggiungiDiariaFrame();
	}*/
}
