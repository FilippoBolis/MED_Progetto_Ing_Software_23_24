package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class DimettiPazienteFrame {
	
	ImageIcon dimettiPazienteImage = new ImageIcon("../progetto_gui/src/main/resources/dimetti_paziente.png");
	public JFrame sfondoFrame;
	public JButton confermaButton;

	public DimettiPazienteFrame() {
		
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(530, 302);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Dimetti paziente</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel dimettiPanel = new JPanel();
		dimettiPanel.setBounds(10, 10, 496, 244);
		dimettiPanel.setBackground(Color.WHITE);
		dimettiPanel.setLayout(null);
		sfondoPanel.add(dimettiPanel);

		JLabel dimettiPazienteLabel = new JLabel("Dimetti paziente");
		dimettiPazienteLabel.setBounds(100, 30, 366, 48);
		dimettiPazienteLabel.setForeground(Stile.BLU_SCURO.getColore());
		dimettiPazienteLabel.setFont(Stile.TITOLO_FINESTRE.getFont());
		dimettiPazienteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dimettiPanel.add(dimettiPazienteLabel);
		
		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(30, 30, 48, 48);
		immagineLabel.setIcon(dimettiPazienteImage);
		dimettiPanel.add(immagineLabel);

		JLabel tipoLabel = new JLabel("Attenzione");
		tipoLabel.setBounds(30, 129, 436, 30);
		tipoLabel.setForeground(Color.GRAY);
		tipoLabel.setFont(Stile.TESTO.getFont());
		dimettiPanel.add(tipoLabel);
		
		JLabel scrittaLabel = new JLabel("La dimissione non può essere annullata, sei sicuro di voler continuare?");
		scrittaLabel.setBounds(30, 162, 436, 30);
		dimettiPanel.add(scrittaLabel);
		
		confermaButton = new JButton("Conferma");
		confermaButton.setBounds(346, 203, 120, 30);
		confermaButton.setBackground(Stile.AZZURRO.getColore());
		confermaButton.setForeground(Color.WHITE);
		confermaButton.setFont(Stile.SOTTOTITOLO.getFont());
		dimettiPanel.add(confermaButton);
		
		sfondoFrame.setVisible(true);

	}
}
