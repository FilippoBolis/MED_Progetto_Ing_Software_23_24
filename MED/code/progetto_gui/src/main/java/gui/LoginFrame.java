package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	ImageIcon medicoImage = new ImageIcon("../progetto_gui/src/main/resources/medico.png");
	ImageIcon chiaveImage = new ImageIcon("../progetto_gui/src/main/resources/chiave.png");
	ImageIcon sfondoImage = new ImageIcon("../progetto_gui/src/main/resources/sfondo.png");
	public JTextField userField;
	public JPasswordField passwordField;
	public JButton loginButton;
	public JFrame sfondoFrame;
	
	public LoginFrame() {
		
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(680, 400);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Login</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);
		
		JPanel sfondoPanel = new JPanel();
		sfondoPanel.setLayout(null);
		sfondoFrame.getContentPane().add(sfondoPanel);

		JPanel sinistraPanel = new JPanel();
		sinistraPanel.setBounds(0, 0, 330, 363);
		sinistraPanel.setBackground(Stile.BLU_SCURO.getColore());
		sinistraPanel.setLayout(null);
		sfondoPanel.add(sinistraPanel);

		JLabel titoloLabel = new JLabel("<html>Medical<br>Environment<br>Database</html>");
		titoloLabel.setBounds(0, 0, 330, 338);
		titoloLabel.setForeground(Color.WHITE);
		titoloLabel.setFont(Stile.SPECIALE.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sinistraPanel.add(titoloLabel);
		
		JLabel sinistraLabel = new JLabel();
		sinistraLabel.setBounds(0, 0, 330, 363);
		sinistraLabel.setIcon(sfondoImage);
		sinistraPanel.add(sinistraLabel);
		
		JPanel destraPanel = new JPanel();
		destraPanel.setBounds(340, 11, 316, 340);
		destraPanel.setBackground(Color.WHITE);
		destraPanel.setLayout(null);
		sfondoPanel.add(destraPanel);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setBounds(10, 37, 296, 40);
		loginLabel.setForeground(Stile.BLU_SCURO.getColore());
		loginLabel.setFont(Stile.TITOLO.getFont());
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		destraPanel.add(loginLabel);
		
		JLabel userTitoloLabel = new JLabel("Username");
		userTitoloLabel.setBounds(81, 95, 195, 30);
		userTitoloLabel.setFont(Stile.TESTO.getFont());
		userTitoloLabel.setForeground(Color.GRAY);
		destraPanel.add(userTitoloLabel);
		
		JLabel userLabel = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(medicoImage.getImage(), 0 , 0, getWidth(), getHeight(), this);
			}
		};
		userLabel.setBounds(41, 95, 30, 30);
		destraPanel.add(userLabel);

		userField = new JTextField();
		userField.setBounds(41, 129, 235, 30);
		userField.setColumns(20);
		destraPanel.add(userField);
		
		JLabel passwordTitoloLabel = new JLabel("Password");
		passwordTitoloLabel.setBounds(81, 163, 195, 30);
		passwordTitoloLabel.setFont(Stile.TESTO.getFont());
		passwordTitoloLabel.setForeground(Color.GRAY);
		destraPanel.add(passwordTitoloLabel);
		
		JLabel passwordLabel = new JLabel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(chiaveImage.getImage(), 0 , 0, this.getWidth(), this.getHeight(), this);
			}
		};
		passwordLabel.setBounds(41, 163, 30, 30);
		destraPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(41, 197, 235, 30);
		passwordField.setColumns(20);
		destraPanel.add(passwordField);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(41, 260, 235, 40);
		loginButton.setBackground(Stile.AZZURRO.getColore());
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(Stile.SOTTOTITOLO.getFont());
		destraPanel.add(loginButton);
		sfondoFrame.setVisible(true);
	}
	
}
