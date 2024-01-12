package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
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
import javax.swing.JTextArea;

public class DiariaInfermieristicaFrame {

	ImageIcon diariaInfImage = new ImageIcon("../progetto_gui/src/main/resources/diaria.png");
	public JFrame sfondoFrame;
	public JTextArea noteTextArea;
	public JComboBox<String> importanteComboBox;
	public JTextArea farmacoTextArea;

	
	public DiariaInfermieristicaFrame() {

		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(680, 400);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Diaria Infermieristica </font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel diariaInfPanel = new JPanel();
		diariaInfPanel.setBounds(10, 11, 646, 342);
		diariaInfPanel.setBackground(Color.WHITE);
		diariaInfPanel.setLayout(null);
		sfondoPanel.add(diariaInfPanel);

		JLabel diariaInfermieristicaLabel = new JLabel("Diaria Infermieristica");
		diariaInfermieristicaLabel.setBounds(10, 11, 297, 40);
		diariaInfermieristicaLabel.setForeground(Stile.BLU_SCURO.getColore());
		diariaInfermieristicaLabel.setFont(Stile.TITOLO.getFont());
		diariaInfermieristicaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		diariaInfPanel.add(diariaInfermieristicaLabel);

		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(316, 14, 48, 48);
		immagineLabel.setIcon(diariaInfImage);
		diariaInfPanel.add(immagineLabel);
		
		JLabel noteLabel = new JLabel("Note particolari");
		noteLabel.setBounds(10, 85, 96, 14);
		diariaInfPanel.add(noteLabel);

		noteTextArea = new JTextArea();
		noteTextArea.setBounds(116, 81, 108, 69);
		noteTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		noteTextArea.setLineWrap(true); 
		noteTextArea.setWrapStyleWord(true);
		diariaInfPanel.add(noteTextArea);
		sfondoFrame.setVisible(true);

		JLabel importanteLabel = new JLabel("Importante");
		importanteLabel.setBounds(10, 160, 137, 21);
		diariaInfPanel.add(importanteLabel);
		
		importanteComboBox = new JComboBox<String>();
		importanteComboBox.setBounds(137, 159, 149, 22);
		diariaInfPanel.add(importanteComboBox);

		JLabel farmacoLabel = new JLabel("Farmaci");
		farmacoLabel.setBounds(10, 189, 96, 20);
		diariaInfPanel.add(farmacoLabel);
		
		farmacoTextArea = new JTextArea();
		farmacoTextArea.setBounds(116, 199, 108, 69);
		farmacoTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		farmacoTextArea.setLineWrap(true); 
		farmacoTextArea.setWrapStyleWord(true);
		diariaInfPanel.add(farmacoTextArea);
		sfondoFrame.setVisible(true);

		JButton confermaButton = new JButton("Conferma");
		confermaButton.setBounds(440, 309, 89, 23);
		diariaInfPanel.add(confermaButton);



	}
	/*
	public static void main(String[] args) { new DiariaInfermieristicaFrame(); }
	*/ 
}
