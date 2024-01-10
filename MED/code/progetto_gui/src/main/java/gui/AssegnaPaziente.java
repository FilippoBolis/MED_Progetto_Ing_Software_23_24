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

public class AssegnaPaziente {

	ImageIcon PazienteImage = new ImageIcon("../progetto_gui/src/main/resources/diaria.png");
	public JFrame sfondoFrame;
	private JTextField textField;
	private JTextField textField_1;

	public AssegnaPaziente() {

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
		sfondoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JLabel AssegnaPazienteLabel = new JLabel("Assegna Paziente");
		AssegnaPazienteLabel.setBounds(10, 11, 296, 40);
		AssegnaPazienteLabel.setForeground(Stile.BLU_SCURO.getColore());
		AssegnaPazienteLabel.setFont(Stile.TITOLO.getFont());
		AssegnaPazienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PazientePanel.add(AssegnaPazienteLabel);

		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(316, 14, 48, 48);
		immagineLabel.setIcon(PazienteImage);
		PazientePanel.add(immagineLabel);

		JLabel moduloLabel = new JLabel("Modulo");
		moduloLabel.setBounds(10, 93, 137, 21);
		PazientePanel.add(moduloLabel);

		JLabel postoLabel = new JLabel("Posto");
		postoLabel.setBounds(10, 128, 96, 20);
		PazientePanel.add(postoLabel);

		textField = new JTextField();
		textField.setBounds(127, 93, 86, 20);
		PazientePanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(127, 128, 86, 20);
		PazientePanel.add(textField_1);
		textField_1.setColumns(10);

		JButton annullaButton = new JButton("Annulla");
		annullaButton.setBounds(256, 309, 89, 23);
		PazientePanel.add(annullaButton);

		JButton confermaButton = new JButton("Conferma");
		confermaButton.setBounds(440, 309, 89, 23);
		PazientePanel.add(confermaButton);

	}
}