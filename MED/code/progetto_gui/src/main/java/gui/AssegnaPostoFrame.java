package gui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatIntelliJLaf;

import modelli.ModelloGestoreLogicaGenerale;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AssegnaPostoFrame {

	ImageIcon assegnaPazienteImage = new ImageIcon("../progetto_gui/src/main/resources/sposta_paziente.png");
	public JFrame sfondoFrame;
	public JComboBox<String> repartoComboBox;
	public JComboBox<String> moduloComboBox;
	public JComboBox<Integer> postoComboBox;
	public JButton confermaButton;
	private ModelloGestoreLogicaGenerale modello;

	public AssegnaPostoFrame(ModelloGestoreLogicaGenerale modello) {
		
		this.modello = modello;
		
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(530, 401);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Assegna posto letto</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel pazientePanel = new JPanel();
		pazientePanel.setBounds(10, 10, 496, 343);
		pazientePanel.setBackground(Color.WHITE);
		pazientePanel.setLayout(null);
		sfondoPanel.add(pazientePanel);

		JLabel assegnaPazienteLabel = new JLabel("Assegna posto letto");
		assegnaPazienteLabel.setBounds(100, 30, 366, 48);
		assegnaPazienteLabel.setForeground(Stile.BLU_SCURO.getColore());
		assegnaPazienteLabel.setFont(Stile.TITOLO_FINESTRE.getFont());
		assegnaPazienteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pazientePanel.add(assegnaPazienteLabel);

		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(30, 30, 48, 48);
		immagineLabel.setIcon(assegnaPazienteImage);
		pazientePanel.add(immagineLabel);
		
		JLabel repartoLabel = new JLabel("Reparto");
		repartoLabel.setBounds(30, 96, 436, 30);
		repartoLabel.setForeground(Color.GRAY);
		repartoLabel.setFont(Stile.TESTO.getFont());
		pazientePanel.add(repartoLabel);
		
		repartoComboBox = new JComboBox<String>();
		repartoComboBox.addItem(" ");
		for (String nomeReparto : modello.modelloGestoreLogistica.getNomiReparti()) {
			repartoComboBox.addItem(nomeReparto);
		}
		repartoComboBox.setBounds(30, 129, 436, 30);
		pazientePanel.add(repartoComboBox);

		JLabel moduloLabel = new JLabel("Modulo");
		moduloLabel.setBounds(30, 162, 436, 30);
		moduloLabel.setForeground(Color.GRAY);
		moduloLabel.setFont(Stile.TESTO.getFont());
		pazientePanel.add(moduloLabel);
		
		moduloComboBox = new JComboBox<String>();
		moduloComboBox.addItem(" ");
		moduloComboBox.setBounds(30, 195, 436, 30);
		pazientePanel.add(moduloComboBox);

		JLabel postoLabel = new JLabel("Posto Letto");
		postoLabel.setBounds(30, 228, 436, 30);
		postoLabel.setForeground(Color.GRAY);
		postoLabel.setFont(Stile.TESTO.getFont());
		pazientePanel.add(postoLabel);
		
		postoComboBox = new JComboBox<Integer>();
		postoComboBox.setBounds(30, 261, 436, 30);
		pazientePanel.add(postoComboBox);

		confermaButton = new JButton("Conferma");
		confermaButton.setBounds(346, 302, 120, 30);
		confermaButton.setBackground(Stile.AZZURRO.getColore());
		confermaButton.setForeground(Color.WHITE);
		confermaButton.setFont(Stile.SOTTOTITOLO.getFont());
		pazientePanel.add(confermaButton);
		
		sfondoFrame.setVisible(true);

	}
	
	public void aggiornaModuliRepartoView() {
		moduloComboBox.removeAllItems();
		postoComboBox.removeAllItems();
		moduloComboBox.addItem(" ");
		for (String nomeModulo : modello.modelloGestoreLogistica.getNomiModuli()) {
			moduloComboBox.addItem(nomeModulo);
		}
	}
	
	public void aggiornaLettiRepartoView() {
		postoComboBox.removeAllItems();
		postoComboBox.addItem(null);
		for (Integer numeroLetto : modello.modelloGestoreLogistica.getNumeroLettiDisponibili()) {
			postoComboBox.addItem(numeroLetto);
		}
	}
	
}