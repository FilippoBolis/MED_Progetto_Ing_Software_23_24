package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class LoginFrame extends JFrame {

	public LoginFrame() {
		
	 	try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	 	
	 	JFrame loginFrame = new JFrame();
	 	loginFrame.setSize(900, 500);
	 	loginFrame.setTitle("Login");
	 	loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	loginFrame.setLocationRelativeTo(null);
	 	loginFrame.setResizable(false);
	 	
	 	JPanel loginPanel = new JPanel();
	 	loginPanel.setBackground(new Color(192, 192, 192));
        loginFrame.getContentPane().add(loginPanel);
        loginPanel.setLayout(null);
        
        loginFrame.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		LoginFrame f = new LoginFrame();
		
	}
	
}
