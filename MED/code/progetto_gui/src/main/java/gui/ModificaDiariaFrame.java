package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class ModificaDiariaFrame {
	ImageIcon diariaImage = new ImageIcon("../progetto_gui/src/main/resources/modifica_diaria.png");
	public JFrame sfondoFrame;
	public JTextField motivoTextField;
	public JTextField storicoTextField;
	public JButton confermaButton;
	public JTextArea farmaciTextArea;
	private JTextArea infoTextArea;
	
	public ModificaDiariaFrame() {
        
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(530, 616);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Modifica diaria medica</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);
		
		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);
		
		JPanel diariaPanel = new JPanel();
		diariaPanel.setBounds(10, 10, 496, 558);
		diariaPanel.setBackground(Color.WHITE);
		diariaPanel.setLayout(null);
		sfondoPanel.add(diariaPanel);
		
		JLabel titoloLabel = new JLabel("Modifica diaria medica");
		titoloLabel.setBounds(100, 30, 366, 48);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO_FINESTRE.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		diariaPanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(30, 30, 48, 48);
		immagineLabel.setIcon(diariaImage);
		diariaPanel.add(immagineLabel);
		
		JLabel motivoLabel = new JLabel("Motivo");
		motivoLabel.setBounds(30, 96, 436, 30);
		motivoLabel.setForeground(Color.GRAY);
		motivoLabel.setFont(Stile.TESTO.getFont());
		diariaPanel.add(motivoLabel);
		
		motivoTextField = new JTextField();
		motivoTextField.setBounds(30, 129, 436, 30);
		motivoTextField.setColumns(30);
		diariaPanel.add(motivoTextField);
		
		JLabel storicoLabel = new JLabel("Storico");
		storicoLabel.setBounds(30, 162, 436, 30);
		storicoLabel.setForeground(Color.GRAY);
		storicoLabel.setFont(Stile.TESTO.getFont());
		diariaPanel.add(storicoLabel);
		
		storicoTextField = new JTextField();
		storicoTextField.setBounds(30, 195, 436, 30);
		storicoTextField.setColumns(30);
		diariaPanel.add(storicoTextField);
		
		JLabel farmaciLabel = new JLabel("Farmaci");
		farmaciLabel.setBounds(30, 228, 436, 30);
		farmaciLabel.setForeground(Color.GRAY);
		farmaciLabel.setFont(Stile.TESTO.getFont());
		diariaPanel.add(farmaciLabel);
		
		farmaciTextArea = new JTextArea();
		farmaciTextArea.setBounds(165, 261, 218, 30);
        farmaciTextArea.setLineWrap(true); 
        farmaciTextArea.setWrapStyleWord(true);
		diariaPanel.add(farmaciTextArea);

        JScrollPane farmaciScrollPane = new JScrollPane(farmaciTextArea);
		farmaciScrollPane.setBounds(30, 261, 436, 103);
		farmaciScrollPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
        diariaPanel.add(farmaciScrollPane);
        
        JLabel infoLabel = new JLabel("Informazioni (allergie, patologie, ecc...)");
		infoLabel.setBounds(30, 367, 436, 30);
		infoLabel.setForeground(Color.GRAY);
		infoLabel.setFont(Stile.TESTO.getFont());
		diariaPanel.add(infoLabel);
		
		infoTextArea = new JTextArea();
		infoTextArea.setBounds(165, 400, 218, 30);
        infoTextArea.setLineWrap(true); 
        infoTextArea.setWrapStyleWord(true);
		diariaPanel.add(infoTextArea);

        JScrollPane infoScrollPane = new JScrollPane(infoTextArea);
		infoScrollPane.setBounds(30, 400, 436, 103);
		infoScrollPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
        diariaPanel.add(infoScrollPane);
		
        confermaButton = new JButton("Conferma");
        confermaButton.setBounds(346, 517, 120, 30);
		confermaButton.setBackground(Stile.AZZURRO.getColore());
		confermaButton.setForeground(Color.WHITE);
		confermaButton.setFont(Stile.SOTTOTITOLO.getFont());
        diariaPanel.add(confermaButton);

		sfondoFrame.setVisible(true);
	
	}
}
