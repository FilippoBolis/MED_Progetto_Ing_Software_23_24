package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class VisualizzaInformazioniFrame {
	private ImageIcon infoImage = new ImageIcon("../progetto_gui/src/main/resources/info.png");
	public JFrame sfondoFrame;
	public JTextArea infoTextArea;
	private JLabel informazioniLabel;
	
	@SuppressWarnings("serial")
	public VisualizzaInformazioniFrame() {
		
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(530, 518);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Visualizza informazioni</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);
		
		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBounds(10, 10, 496, 460);
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setLayout(null);
		sfondoPanel.add(infoPanel);
		
		JLabel titoloLabel = new JLabel("Visualizza informazioni");
		titoloLabel.setBounds(100, 30, 366, 48);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO_FINESTRE.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		infoPanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(infoImage.getImage(), 0 , 0, this.getWidth(), this.getHeight(), this);
			}
		};;
		immagineLabel.setBounds(30, 30, 48, 48);
		infoPanel.add(immagineLabel);
		
		informazioniLabel = new JLabel("Informazioni");
		informazioniLabel.setBounds(30, 96, 436, 30);
		informazioniLabel.setForeground(Color.GRAY);
		informazioniLabel.setFont(Stile.TESTO.getFont());
		infoPanel.add(informazioniLabel);
		
		infoTextArea = new JTextArea();
		infoTextArea.setBounds(30, 129, 436, 301);
		infoTextArea.setBackground(Color.WHITE);
		infoTextArea.setLineWrap(true); 
        infoTextArea.setWrapStyleWord(true); 
        infoTextArea.setEditable(false);
		infoPanel.add(infoTextArea);
		
        JScrollPane scrollPane = new JScrollPane(infoTextArea);
		scrollPane.setBounds(30, 129, 436, 301);
		scrollPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		infoPanel.add(scrollPane);
		
		sfondoFrame.setVisible(true);
	
	}
	public void setPersonaView(String persona) {
		informazioniLabel.setText("Informazioni di " + persona);
	}
}
