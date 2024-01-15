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
		sfondoFrame.setSize(530, 540);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Inserisci Diaria Medica</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);
		
		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);
		
		JPanel diariaPanel = new JPanel();
		diariaPanel.setBounds(10, 10, 496, 482);
		diariaPanel.setBackground(Color.WHITE);
		diariaPanel.setLayout(null);
		sfondoPanel.add(diariaPanel);
		
		JLabel titoloLabel = new JLabel("Inserisci diaria medica");
		titoloLabel.setBounds(100, 30, 366, 48);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		diariaPanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(30, 30, 48, 48);
		immagineLabel.setIcon(aggiungiDiariaImage);
		diariaPanel.add(immagineLabel);
		
		JLabel motivoLabel = new JLabel("Motivo");
		motivoLabel.setBounds(30, 96, 116, 30);
		motivoLabel.setForeground(Color.GRAY);
		motivoLabel.setFont(Stile.TESTO.getFont());
		diariaPanel.add(motivoLabel);
		
		motivoTextField = new JTextField();
		motivoTextField.setBounds(30, 129, 436, 30);
		diariaPanel.add(motivoTextField);
		motivoTextField.setColumns(30);
		
		JLabel storicoLabel = new JLabel("Storico");
		storicoLabel.setBounds(30, 162, 137, 30);
		storicoLabel.setForeground(Color.GRAY);
		storicoLabel.setFont(Stile.TESTO.getFont());
		diariaPanel.add(storicoLabel);
		
		storicoTextField = new JTextField();
		storicoTextField.setBounds(30, 195, 436, 30);
		diariaPanel.add(storicoTextField);
		storicoTextField.setColumns(30);
		
		JLabel repartoLabel = new JLabel("Reparto consigliato");
		repartoLabel.setForeground(Color.GRAY);
		repartoLabel.setFont(Stile.TESTO.getFont());
		repartoLabel.setBounds(30, 228, 137, 30);
		diariaPanel.add(repartoLabel);
		
		repartoComboBox = new JComboBox<String>();
		for (String nomeReparto : modello.modelloGestoreLogistica.getNomiReparti()) {
			repartoComboBox.addItem(nomeReparto);
		}
		repartoComboBox.setBounds(30, 261, 436, 30);
		diariaPanel.add(repartoComboBox);
		
		JLabel farmaciLabel = new JLabel("Farmaci");
		farmaciLabel.setBounds(30, 294, 128, 30);
		farmaciLabel.setForeground(Color.GRAY);
		farmaciLabel.setFont(Stile.TESTO.getFont());
		diariaPanel.add(farmaciLabel);
		
		farmaciTextArea = new JTextArea();
		farmaciTextArea.setBounds(165, 231, 218, 30);
        farmaciTextArea.setLineWrap(true); 
        farmaciTextArea.setWrapStyleWord(true);
		diariaPanel.add(farmaciTextArea);

        JScrollPane scrollPane = new JScrollPane(farmaciTextArea);
		scrollPane.setBounds(30, 327, 436, 103);
        diariaPanel.add(scrollPane);
		
        avantiButton = new JButton("Avanti");
        avantiButton.setBounds(346, 441, 120, 30);
		avantiButton.setBackground(Stile.AZZURRO.getColore());
		avantiButton.setForeground(Color.WHITE);
		avantiButton.setFont(Stile.SOTTOTITOLO.getFont());
        diariaPanel.add(avantiButton);

		sfondoFrame.setVisible(true);
	
	}
}
