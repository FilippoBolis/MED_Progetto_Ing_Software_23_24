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
	ImageIcon dimettiPazienteImage = new ImageIcon("../progetto_gui/src/main/resources/dimetti_paziente.png");
	public JFrame sfondoFrame;
	private JTextField tipoTextField;

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

		JPanel dimettiPanel = new JPanel();
		dimettiPanel.setBounds(10, 10, 646, 342);
		dimettiPanel.setBackground(Color.WHITE);
		dimettiPanel.setLayout(null);
		sfondoPanel.add(dimettiPanel);

		JLabel dimettiPazienteLabel = new JLabel("Dimetti Paziente");
		dimettiPazienteLabel.setBounds(10, 11, 261, 40);
		dimettiPazienteLabel.setForeground(Stile.BLU_SCURO.getColore());
		dimettiPazienteLabel.setFont(Stile.TITOLO.getFont());
		dimettiPazienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dimettiPanel.add(dimettiPazienteLabel);

		JLabel tipoLabel = new JLabel("Tipo");
		tipoLabel.setBounds(55, 98, 46, 14);
		dimettiPanel.add(tipoLabel);

		tipoTextField = new JTextField();
		tipoTextField.setBounds(137, 95, 86, 20);
		dimettiPanel.add(tipoTextField);
		tipoTextField.setColumns(10);
		
		JButton confermaButton = new JButton("Conferma");
		confermaButton.setBounds(440, 309, 89, 23);
		dimettiPanel.add(confermaButton);
		
		sfondoFrame.setVisible(true);

	}
}
