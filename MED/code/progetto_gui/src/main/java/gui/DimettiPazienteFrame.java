package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.JTextField;

public class DimettiPazienteFrame {
	ImageIcon dimettiPazienteImage = new ImageIcon("../progetto_gui/src/main/resources/diaria.png");
	public JFrame sfondoFrame;
	private JTextField textField;

	public DimettiPazienteFrame() {

		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(680, 400);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Dimetti Paziente </font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel dimettiPazPanel = new JPanel();
		dimettiPazPanel.setBounds(10, 10, 646, 342);
		dimettiPazPanel.setBackground(Color.WHITE);
		dimettiPazPanel.setLayout(null);
		sfondoPanel.add(dimettiPazPanel);

		JLabel dimettiPazienteLabel = new JLabel("Info Paziente");
		dimettiPazienteLabel.setBounds(10, 11, 261, 40);
		dimettiPazienteLabel.setForeground(Stile.BLU_SCURO.getColore());
		dimettiPazienteLabel.setFont(Stile.TITOLO.getFont());
		dimettiPazienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dimettiPazPanel.add(dimettiPazienteLabel);

		JButton annullaButton = new JButton("Annulla");
		annullaButton.setBounds(256, 309, 89, 23);
		dimettiPazPanel.add(annullaButton);

		JButton confermaButton = new JButton("Conferma");
		confermaButton.setBounds(440, 309, 89, 23);
		dimettiPazPanel.add(confermaButton);

		JLabel tipoLabel = new JLabel("Tipo");
		tipoLabel.setBounds(55, 98, 46, 14);
		dimettiPazPanel.add(tipoLabel);

		textField = new JTextField();
		textField.setBounds(137, 95, 86, 20);
		dimettiPazPanel.add(textField);
		textField.setColumns(10);
		sfondoFrame.setVisible(true);

	}
	/*
	 * public static void main(String[] args) { new DimettiPazienteFrame(); }
	 */
}
