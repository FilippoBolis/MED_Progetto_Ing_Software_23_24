package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AssegnaPazienteFrame {

	ImageIcon assPazienteImage = new ImageIcon("../progetto_gui/src/main/resources/sposta_paziente.png");
	public JFrame sfondoFrame;
	public JComboBox<String> repartoComboBox;
	public JComboBox<String> moduloComboBox;
	public JComboBox<String> postoComboBox;
	public JButton confermaButton;

	public AssegnaPazienteFrame() {

		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(680, 400);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Assegna Paziente </font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel PazientePanel = new JPanel();
		PazientePanel.setBounds(10, 10, 646, 342);
		PazientePanel.setBackground(Color.WHITE);
		PazientePanel.setLayout(null);
		sfondoPanel.add(PazientePanel);

		JLabel assegnaPazienteLabel = new JLabel("Assegna Paziente");
		assegnaPazienteLabel.setBounds(10, 11, 261, 40);
		assegnaPazienteLabel.setForeground(Stile.BLU_SCURO.getColore());
		assegnaPazienteLabel.setFont(Stile.TITOLO.getFont());
		assegnaPazienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PazientePanel.add(assegnaPazienteLabel);

		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(316, 14, 48, 48);
		immagineLabel.setIcon(assPazienteImage);
		PazientePanel.add(immagineLabel);
		
		JLabel repartoLabel = new JLabel("Reparto");
		repartoLabel.setBounds(10, 120, 137, 21);
		PazientePanel.add(repartoLabel);
		
		repartoComboBox = new JComboBox<String>();
		repartoComboBox.setBounds(147, 124, 149, 22);
		PazientePanel.add(repartoComboBox);

		JLabel moduloLabel = new JLabel("Modulo");
		moduloLabel.setBounds(10, 157, 137, 21);
		PazientePanel.add(moduloLabel);
		
		moduloComboBox = new JComboBox<String>();
		moduloComboBox.setBounds(147, 156, 149, 22);
		PazientePanel.add(moduloComboBox);

		JLabel postoLabel = new JLabel("Posto Letto");
		postoLabel.setBounds(10, 189, 96, 20);
		PazientePanel.add(postoLabel);
		
		postoComboBox = new JComboBox<String>();
		postoComboBox.setBounds(148, 188, 137, 22);
		PazientePanel.add(postoComboBox);
		sfondoFrame.setVisible(true);

		confermaButton = new JButton("Conferma");
		confermaButton.setBounds(440, 309, 89, 23);
		PazientePanel.add(confermaButton);

	}
}