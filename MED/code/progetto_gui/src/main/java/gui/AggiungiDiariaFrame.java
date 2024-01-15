package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatIntelliJLaf;
import modelli.ModelloGestoreLogicaGenerale;
import javax.swing.JTextArea;

public class AggiungiDiariaFrame {

	ImageIcon aggiungiDiariaImage = new ImageIcon("../progetto_gui/src/main/resources/aggiungi_diaria.png");
	public JFrame sfondoFrame;
	public JTextField motivoTextField;
	public JTextField storicoTextField;
	public JButton avantiButton;
	public JTextArea farmaciTextArea;
	public JComboBox<String> repartoComboBox;
	
	public AggiungiDiariaFrame(ModelloGestoreLogicaGenerale modello) {
        
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
		sfondoFrame.setResizable(false);
		
		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);
		
		JPanel diariaPanel = new JPanel();
		diariaPanel.setBounds(10, 10, 646, 342);
		diariaPanel.setBackground(Color.WHITE);
		diariaPanel.setLayout(null);
		sfondoPanel.add(diariaPanel);
		
		JLabel titoloLabel = new JLabel("Diaria Medica");
		titoloLabel.setBounds(10, 11, 296, 40);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		diariaPanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(316, 14, 48, 48);
		immagineLabel.setIcon(aggiungiDiariaImage);
		diariaPanel.add(immagineLabel);
		
		JLabel motivoLabel = new JLabel("Motivo");
		motivoLabel.setBounds(10, 74, 116, 21);
		diariaPanel.add(motivoLabel);
		
		motivoTextField = new JTextField();
		motivoTextField.setBounds(153, 74, 96, 20);
		diariaPanel.add(motivoTextField);
		motivoTextField.setColumns(10);
		
		JLabel storicoLabel = new JLabel("Storico");
		storicoLabel.setBounds(10, 120, 137, 21);
		diariaPanel.add(storicoLabel);
		
		storicoTextField = new JTextField();
		storicoTextField.setBounds(153, 120, 96, 20);
		diariaPanel.add(storicoTextField);
		storicoTextField.setColumns(10);
		
		JLabel repartoLabel = new JLabel("Reparto consigliato");
		repartoLabel.setBounds(10, 168, 137, 21);
		diariaPanel.add(repartoLabel);
		
		repartoComboBox = new JComboBox<String>();
		for (String nomeReparto : modello.modelloGestoreLogistica.getNomiReparti()) {
			repartoComboBox.addItem(nomeReparto);
		}
		repartoComboBox.setBounds(153, 168, 100, 21);
		diariaPanel.add(repartoComboBox);
		
		JLabel farmaciLabel = new JLabel("Farmaci");
		farmaciLabel.setBounds(10, 230, 128, 27);
		diariaPanel.add(farmaciLabel);
		
		farmaciTextArea = new JTextArea();
		farmaciTextArea.setBounds(165, 231, 218, 30);
		farmaciTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
        farmaciTextArea.setLineWrap(true); 
        farmaciTextArea.setWrapStyleWord(true);
		diariaPanel.add(farmaciTextArea);

        JScrollPane scrollPane = new JScrollPane(farmaciTextArea);
		scrollPane.setBounds(165, 231, 218, 64);
        diariaPanel.add(scrollPane);
		
        avantiButton = new JButton("Avanti");
		avantiButton.setBounds(440, 309, 89, 23);
		diariaPanel.add(avantiButton);

		sfondoFrame.setVisible(true);
	
	}
}
