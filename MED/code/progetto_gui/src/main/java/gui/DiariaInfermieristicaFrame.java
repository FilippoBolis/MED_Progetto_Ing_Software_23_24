package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.JTextArea;

public class DiariaInfermieristicaFrame {

	ImageIcon diariaImage = new ImageIcon("../progetto_gui/src/main/resources/diaria.png");
	public JFrame sfondoFrame;
	public JTextArea noteTextArea;
	public JCheckBox importanteCheckBox;
	public JTextArea farmacoTextArea;
	public JButton confermaButton;

	
	public DiariaInfermieristicaFrame() {

		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(530, 533);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Inserisci diaria infermieristica </font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel diariaInfPanel = new JPanel();
		diariaInfPanel.setBounds(10, 10, 496, 475);
		diariaInfPanel.setBackground(Color.WHITE);
		diariaInfPanel.setLayout(null);
		sfondoPanel.add(diariaInfPanel);

		JLabel diariaInfermieristicaLabel = new JLabel("Inserisci diaria Infermieristica");
		diariaInfermieristicaLabel.setBounds(100, 30, 366, 48);
		diariaInfermieristicaLabel.setForeground(Stile.BLU_SCURO.getColore());
		diariaInfermieristicaLabel.setFont(Stile.TITOLO_FINESTRE.getFont());
		diariaInfermieristicaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		diariaInfPanel.add(diariaInfermieristicaLabel);

		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(30, 30, 48, 48);
		immagineLabel.setIcon(diariaImage);
		diariaInfPanel.add(immagineLabel);
		
		JLabel noteLabel = new JLabel("Note particolari");
		noteLabel.setBounds(30, 96, 436, 30);
		noteLabel.setForeground(Color.GRAY);
		noteLabel.setFont(Stile.TESTO.getFont());
		diariaInfPanel.add(noteLabel);

		noteTextArea = new JTextArea();
		noteTextArea.setBounds(30, 129, 436, 98);
		noteTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		noteTextArea.setLineWrap(true); 
		noteTextArea.setWrapStyleWord(true);
		diariaInfPanel.add(noteTextArea);
		sfondoFrame.setVisible(true);

		JLabel importanteLabel = new JLabel("Importante");
		importanteLabel.setBounds(30, 228, 436, 30);
		importanteLabel.setForeground(Color.GRAY);
		importanteLabel.setFont(Stile.TESTO.getFont());
		diariaInfPanel.add(importanteLabel);
		
		importanteCheckBox = new JCheckBox("Importante");
		importanteCheckBox.setBounds(30, 261, 436, 30);
		importanteCheckBox.setBackground(Color.WHITE);
		diariaInfPanel.add(importanteCheckBox);

		JLabel farmacoLabel = new JLabel("Farmaci");
		farmacoLabel.setBounds(30, 294, 436, 30);
		farmacoLabel.setForeground(Color.GRAY);
		farmacoLabel.setFont(Stile.TESTO.getFont());
		diariaInfPanel.add(farmacoLabel);
		
		farmacoTextArea = new JTextArea();
		farmacoTextArea.setBounds(30, 327, 436, 98);
		farmacoTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		farmacoTextArea.setLineWrap(true); 
		farmacoTextArea.setWrapStyleWord(true);

		confermaButton = new JButton("Conferma");
		confermaButton.setBounds(346, 434, 120, 30);
		confermaButton.setBackground(Stile.AZZURRO.getColore());
		confermaButton.setForeground(Color.WHITE);
		confermaButton.setFont(Stile.SOTTOTITOLO.getFont());
		diariaInfPanel.add(confermaButton);

		diariaInfPanel.add(farmacoTextArea);

	}
}
