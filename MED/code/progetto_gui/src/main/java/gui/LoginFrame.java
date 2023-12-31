package gui;

import java.awt.Color;

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

	ImageIcon logoImage = new ImageIcon("./src/main/resources/logo.png");
	ImageIcon docImage = new ImageIcon("./src/main/resources/doc.png");
	ImageIcon keyImage = new ImageIcon("./src/main/resources/key.png");
	ImageIcon sfondoImage = new ImageIcon("./src/main/resources/sfondo.png");
	private JTextField userField;
	private JPasswordField passwordField;

	public LoginFrame() {

		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		JFrame sfondoFrame = new JFrame();
		sfondoFrame.setSize(680, 400);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Login</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);

		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);

		JPanel sinistraPanel = new JPanel();
		sinistraPanel.setBounds(0, 0, 330, 363);
		sinistraPanel.setBackground(Stile.BLU_SCURO.getColore());
		sinistraPanel.setLayout(null);
		sfondoPanel.add(sinistraPanel);

		JLabel titoloLabel = new JLabel("<html>Medical<br>Environment<br>Database</html>");
		titoloLabel.setBounds(0, 103, 330, 181);
		titoloLabel.setForeground(Color.WHITE);
		titoloLabel.setFont(Stile.TITOLO.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sinistraPanel.add(titoloLabel);
		
		JLabel logoLabel = new JLabel();
		logoLabel.setBounds(34, 33, 250, 81);
		logoLabel.setIcon(logoImage);
		sinistraPanel.add(logoLabel);
		
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
		loginLabel.setBounds(10, 66, 296, 40);
		loginLabel.setForeground(Stile.BLU_SCURO.getColore());
		loginLabel.setFont(Stile.TITOLO.getFont());
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		destraPanel.add(loginLabel);
		
		JLabel userLabel = new JLabel();
		userLabel.setBounds(41, 130, 30, 30);
		userLabel.setIcon(docImage);
		destraPanel.add(userLabel);
		
		userField = new JTextField();
		userField.setBounds(76, 130, 200, 30);
		userField.setColumns(20);
		destraPanel.add(userField);
		
		JLabel passwordLabel = new JLabel();
		passwordLabel.setBounds(41, 170, 30, 30);
		passwordLabel.setIcon(keyImage);
		destraPanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(76, 170, 200, 30);
		passwordField.setColumns(20);
		destraPanel.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(41, 211, 235, 40);
		loginButton.setBackground(Stile.AZZURRO.getColore());
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(Stile.SOTTOTITOLO.getFont());
		destraPanel.add(loginButton);

		sfondoFrame.setVisible(true);
	}
	
	/*
	private ImageIcon scaleImage(ImageIcon icon, int width, int height) {
	    Image image = icon.getImage();
	    Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    return new ImageIcon(scaledImage);
	}
	*/
	
	public static void main(String[] args) throws Exception {
		new LoginFrame();

	}
}
