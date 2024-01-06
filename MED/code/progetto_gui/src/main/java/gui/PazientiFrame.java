package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class PazientiFrame {
	
	private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public JFrame sfondoFrame;
	public String infoPaziente = "Seleziona un paziente nel database";
	public String mansioneUtente = "Dott.";
	public String cognomeUtente = "Gotti";
	public DefaultTableModel tableModel;
	public JTable table;

	@SuppressWarnings("serial")
	public PazientiFrame() {
		
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(1280, 720);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Pazienti</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);
		sfondoFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel sfondoPanel = new JPanel();
		sfondoPanel.setLayout(null);
		sfondoFrame.getContentPane().add(sfondoPanel);
		
        JPanel infoPanel = new JPanel();
        infoPanel.setBounds((int) (WIDTH * 0.25), 0, (int) (WIDTH * 0.75), (int)(HEIGHT * 0.25));
        infoPanel.setLayout(null);
        sfondoPanel.add(infoPanel);
        
        JLabel utenteLabel = new JLabel("Utente: " + mansioneUtente + " " + cognomeUtente);
        utenteLabel.setBounds(20, 0, (int) (WIDTH * 0.75) - 40, (int) (infoPanel.getHeight() * 0.25));
        utenteLabel.setForeground(Stile.BLU_SCURO.getColore());
        utenteLabel.setFont(Stile.TESTO.getFont());
        infoPanel.add(utenteLabel);
        
        JPanel pazientePanel = new JPanel();
        pazientePanel.setBounds(0, utenteLabel.getHeight(), (int) (WIDTH * 0.75), (int) (infoPanel.getHeight() * 0.75));
        pazientePanel.setBackground(Stile.BLU.getColore());
        infoPanel.add(pazientePanel);
        pazientePanel.setLayout(null);
        
        JLabel pazienteTitoloLabel = new JLabel("Paziente");
        pazienteTitoloLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        pazienteTitoloLabel.setBounds(20, 0, (int) (pazientePanel.getWidth() - 20), (int) (pazientePanel.getHeight() * 0.5));
        pazienteTitoloLabel.setForeground(Color.WHITE);
        pazienteTitoloLabel.setFont(Stile.TITOLO_FINE.getFont());
        pazientePanel.add(pazienteTitoloLabel);
        
        JLabel pazienteLabel = new JLabel(infoPaziente);
        pazienteLabel.setVerticalAlignment(SwingConstants.TOP);
        pazienteLabel.setBounds(20, pazienteTitoloLabel.getHeight(), (int) (pazientePanel.getWidth() - 20), (int) (pazientePanel.getHeight() * 0.5));
        pazienteLabel.setForeground(Color.WHITE);
        pazienteLabel.setFont(Stile.SOTTOTITOLO_FINE.getFont());
        pazientePanel.add(pazienteLabel);
        
		JPanel sinistraPanel = new JPanel();
		sinistraPanel.setBounds(0, 0, (int) (WIDTH * 0.25), HEIGHT);
		sinistraPanel.setBackground(Stile.BLU_SCURO.getColore());
		sinistraPanel.setLayout(null);
		sfondoPanel.add(sinistraPanel);
		
        JLabel titoloLabel = new JLabel("Medical Environment Database");
        titoloLabel.setBounds(20, 0, WIDTH, (int) (infoPanel.getHeight() * 0.25));
        titoloLabel.setForeground(Color.WHITE);
        titoloLabel.setFont(Stile.SOTTOTITOLO.getFont());
        //titoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sinistraPanel.add(titoloLabel);
        		
        JPanel logoPanel = new JPanel();
        logoPanel.setBounds(0, utenteLabel.getHeight(), (int) (WIDTH * 0.75), (int) (infoPanel.getHeight() * 0.75));
        logoPanel.setBackground(Stile.BLU_SCURO.getColore());
        logoPanel.setLayout(new BorderLayout(0, 0));
        sinistraPanel.add(logoPanel);
        
        JLabel logoLabel = new JLabel("logo");
        logoLabel.setBounds(0, 0, WIDTH, (int) (infoPanel.getHeight() * 0.25));
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(Stile.SOTTOTITOLO.getFont());
        //logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoPanel.add(logoLabel);
		
		JPanel centroPanel = new JPanel();
		centroPanel.setBounds((int) (WIDTH * 0.25), (int) (HEIGHT * 0.25), (int) (WIDTH * 0.75), (int) (HEIGHT * 0.75));
		centroPanel.setLayout(null);
		sfondoPanel.add(centroPanel);
		
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Codice");
        tableModel.addColumn("Cognome");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Sesso");
        tableModel.addColumn("Data");
        tableModel.addColumn("Ora");
        tableModel.addColumn("Urgenza");
        
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setRowHeight(30);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setSelectionBackground(Stile.AZZURRO_TRASP.getColore());
        
        //TOGLIERE solo di prova
        tableModel.addRow(new Object[]{"1", "2", "1", "2", "1", "2", "1"});
        tableModel.addRow(new Object[]{"2", "1", "2", "1", "2", "1", "2"});
        for (int i = 0; i < 30; i++) {
            tableModel.addRow(new Object[]{"3", "3", "3", "3", "3", "3", "3"});
        }
        
		JScrollPane scrollPanel = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanel.setBounds(20, 20, (int) (WIDTH * 0.75) - 40, (int) (HEIGHT * 0.75) - 60);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder()); 
        scrollPanel.setViewportView(table);
        centroPanel.add(scrollPanel);
        
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(table.getColumnModel().getTotalColumnWidth(), 30));
        tableHeader.setBackground(Stile.AZZURRO.getColore());
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setFont(Stile.TESTO.getFont());
        
        //FILIPPO se clicchi sul nome di una qualsiasi colonna le ordina crescenti, se riclicchi decrescenti. Può bastare come filtro? 
        TableRowSorter<DefaultTableModel> ordineColonna = new TableRowSorter<>(tableModel);
        table.setRowSorter(ordineColonna);
		
		sfondoFrame.setVisible(true);
	}
	
	public void updateStringaUtente() {
		//FILIPPO
		//Crea e collega il modello a questa funzione come nell'esempio calculator
		//All'avvio del frame la variabile mansioneUtente (se M metti Dott., se I metti Inf.) e cognomeUtente vanno inserite correttamente in base al Login
		//(ho messo le stringhe dichiarate con valori a caso in alto, poi toglile quando hai fatto)
		//Appariranno nel label utenteLabel
	}
	
	public void updateStringaPaziente() {
		//FILIPPO
		//Crea e collega il modello a questa funzione come nell'esempio calculator
		//Se l'utente non ha neancora cliccato sul paziente viene visualizzata la frase: "Selezionare un paziente nel database" nel label pazienteLabel
		//(ho messo la stringa dichiarata con valori a caso in alto, poi toglila quando hai fatto)
		//Se l'utente clicca sulla tabella viene visualizzata una stringa con tutti i dati: "Codice: 3123 Cognome: Gotti ecc..."
	}
	
	//FILIPPO 
	//Sotto al logo che pulsanti metto?
	
	public static void main(String[] args) throws Exception {
		new PazientiFrame();
	}
}
