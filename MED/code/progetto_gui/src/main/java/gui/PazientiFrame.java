package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import com.formdev.flatlaf.FlatIntelliJLaf;

//import logiche_bottoni.LoginLogic;
import modelli.ModelloGestoreLogicaGenerale;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class PazientiFrame {
	
	private final ImageIcon ripristinaImage = new ImageIcon("../progetto_gui/src/main/resources/ripristina.png");
	private final ImageIcon cercaImage = new ImageIcon("../progetto_gui/src/main/resources/cerca.png");
	private final ImageIcon logoImage = new ImageIcon("../progetto_gui/src/main/resources/logo.png");
	private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public JFrame sfondoFrame;
	public JToggleButton prontoSoccorsoToggleButton;
	public JToggleButton repartoToggleButton;
	public JToggleButton inCaricoToggleButton;
	public JComboBox<String> urgenzaComboBox;
	public JTable table;
	public JPanel prontoSoccorsoBottoniPanel;
	public JPanel prendereCaricoBottoniPanel;
	public JPanel repartoBottoniPanel;
	public String posizioneAttuale;
	public JTextField cercaTextField;
	public JButton cercaButton;
	public JButton indietroButton;
	public JButton dimettiButton;
	public JButton visualizzaInformazioniButton;
	public JButton visualizzaFarmaciButton;
	public JButton visualizzaStoricoButton;
	public JButton inserisciDiariaInfButton;
	public JButton modificaDiariaMedButton;
	public JButton visualizzaDiarieInfButton;
	public JButton inserisciRilevazioneButton;
	public JButton visualizzaRilevazioniButton;
	public JButton assegnaLettoButton;
	public JButton inserisciDiariaButton;
	public JButton inserisciPazienteButton;
	public JComboBox<String> repartoComboBox;
	public JLabel repartoLabel;
    private JLabel dataPazienteLabel;
    private JLabel motivoPazienteLabel;
	private JLabel pazienteLabel;
	private DefaultTableModel tableModel;
	private JLabel utenteLabel;
	private JLabel pazienteTitoloLabel;
	private ModelloGestoreLogicaGenerale modello;
    public boolean updating = false;

	public PazientiFrame(ModelloGestoreLogicaGenerale modello) {
		
		this.modello = modello;
		
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
		sfondoFrame.setResizable(true);
		sfondoFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel sfondoPanel = new JPanel();
		sfondoPanel.setLayout(null);
		sfondoFrame.getContentPane().add(sfondoPanel);
		
        JPanel infoPanel = new JPanel();
        infoPanel.setBounds(0, 0, WIDTH, (int)(HEIGHT * 0.25));
        infoPanel.setLayout(null);
        sfondoPanel.add(infoPanel);
        
        JPanel pazientePanel = new JPanel();
        pazientePanel.setBounds(0, 0, WIDTH, (int) (infoPanel.getHeight() * 0.8));
        pazientePanel.setBackground(Stile.BLU.getColore());
        pazientePanel.setLayout(null);
        infoPanel.add(pazientePanel);
        
        pazienteTitoloLabel = new JLabel("Selezionare un paziente");
        pazienteTitoloLabel.setBounds(20, 0, (int) (pazientePanel.getWidth() - 20), (int) (pazientePanel.getHeight() * 0.4));
        pazienteTitoloLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        pazienteTitoloLabel.setForeground(Color.WHITE);
        pazienteTitoloLabel.setFont(Stile.TITOLO_FINE.getFont());
        pazientePanel.add(pazienteTitoloLabel);

        pazienteLabel = new JLabel();
        pazienteLabel.setVerticalAlignment(SwingConstants.TOP);
        pazienteLabel.setBounds(20, pazienteTitoloLabel.getHeight(), (int) (pazientePanel.getWidth() - 20), 30);
        pazienteLabel.setForeground(Color.WHITE);
        pazienteLabel.setFont(Stile.SOTTOTITOLO_FINE.getFont());
        pazientePanel.add(pazienteLabel);

        dataPazienteLabel = new JLabel("    Data arrivo in struttura: ...");
        dataPazienteLabel.setBounds(20, pazienteTitoloLabel.getHeight() + 10, (int) (pazientePanel.getWidth() - 40), 30);
        dataPazienteLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.LIGHT_GRAY));
        dataPazienteLabel.setForeground(Color.WHITE);
        dataPazienteLabel.setFont(Stile.SOTTOTITOLO_FINE.getFont());
        pazientePanel.add(dataPazienteLabel);
       
        motivoPazienteLabel = new JLabel("    Motivo: ...");
        motivoPazienteLabel.setBounds(20, pazienteTitoloLabel.getHeight() + dataPazienteLabel.getHeight() + 10, dataPazienteLabel.getWidth(), 30);
        motivoPazienteLabel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.LIGHT_GRAY));
        motivoPazienteLabel.setForeground(Color.WHITE);
        motivoPazienteLabel.setFont(Stile.SOTTOTITOLO_FINE.getFont());
        pazientePanel.add(motivoPazienteLabel);
        
        JPanel menuPanel = new JPanel();
        menuPanel.setBounds((int) (WIDTH * 0.5), infoPanel.getHeight() - ((int) (infoPanel.getHeight() * 0.2)), (int) (WIDTH * 0.5), (int) (infoPanel.getHeight() * 0.2));
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setLayout(null);
        infoPanel.add(menuPanel);
         
        prontoSoccorsoToggleButton = new JToggleButton("IN PRONTO SOCCORSO");
        prontoSoccorsoToggleButton.setBounds(0, 0, (int) (menuPanel.getWidth() * 0.34), menuPanel.getHeight());
        prontoSoccorsoToggleButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.LIGHT_GRAY)); 
        prontoSoccorsoToggleButton.setForeground(Stile.BLU_SCURO.getColore());
        prontoSoccorsoToggleButton.setFont(Stile.TESTO.getFont());
        menuPanel.add(prontoSoccorsoToggleButton);
        
        inCaricoToggleButton = new JToggleButton("DA PRENDERE IN CARICO");
        inCaricoToggleButton.setBounds(prontoSoccorsoToggleButton.getWidth(), 0, (int) (menuPanel.getWidth() * 0.34), menuPanel.getHeight());
        inCaricoToggleButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY)); 
        inCaricoToggleButton.setForeground(Stile.BLU_SCURO.getColore());
        inCaricoToggleButton.setFont(Stile.TESTO.getFont());
        menuPanel.add(inCaricoToggleButton);
        
        repartoToggleButton = new JToggleButton("IN REPARTO");
        repartoToggleButton.setBounds(inCaricoToggleButton.getWidth() * 2, 0, (int) (menuPanel.getWidth() * 0.34), menuPanel.getHeight());
        repartoToggleButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY)); 
        repartoToggleButton.setForeground(Stile.BLU_SCURO.getColore());
        repartoToggleButton.setFont(Stile.TESTO.getFont());
        menuPanel.add(repartoToggleButton);
        
		JPanel sinistraPanel = new JPanel();
		sinistraPanel.setBounds(0, pazientePanel.getHeight(), (int) (WIDTH * 0.155), HEIGHT - pazientePanel.getHeight());
		sinistraPanel.setBackground(Stile.BLU_SCURO.getColore());
		sinistraPanel.setLayout(null);
		sfondoPanel.add(sinistraPanel);
		
		JPanel centroPanel = new JPanel();
		centroPanel.setBounds(sinistraPanel.getWidth(), (int) (HEIGHT * 0.25), (int) (WIDTH * 0.85), (int) (HEIGHT * 0.75));
        centroPanel.setLayout(null);
		sfondoPanel.add(centroPanel);
		
		JPanel filtriPanel = new JPanel();
		filtriPanel.setBounds(0, 0, centroPanel.getWidth(), (int) (centroPanel.getHeight() * 0.1));
		filtriPanel.setBackground(Stile.AZZURRO.getColore());
        filtriPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.LIGHT_GRAY));
        filtriPanel.setLayout(null);
        centroPanel.add(filtriPanel);
        
		JPanel spazioPanel = new JPanel();
        spazioPanel.setBounds(0, menuPanel.getY(), sinistraPanel.getWidth(), menuPanel.getHeight());
        spazioPanel.setBackground(Stile.BLU_SCURO.getColore());
        spazioPanel.setLayout(null);
        infoPanel.add(spazioPanel);
		
		JPanel logoPanel = new JPanel();
        logoPanel.setBounds(0, spazioPanel.getHeight(), sinistraPanel.getWidth(), filtriPanel.getHeight());
        logoPanel.setBackground(Stile.BLU_SCURO.getColore());
        logoPanel.setLayout(null);
        sinistraPanel.add(logoPanel);
        
        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(20, (int) ((logoPanel.getHeight() - 40) / 2), 155, 40);
        logoLabel.setIcon(logoImage);
        logoPanel.add(logoLabel);
        
        JLabel titoloLabel = new JLabel("<html>Medical<br>Environment<br>Database</html>");
        titoloLabel.setBounds(20, logoPanel.getY() + logoPanel.getHeight() + 10, sinistraPanel.getWidth() - 20, 56);
        titoloLabel.setForeground(Color.WHITE);
        titoloLabel.setFont(Stile.SOTTOTITOLO.getFont());
        sinistraPanel.add(titoloLabel);
        
        utenteLabel = new JLabel();
        utenteLabel.setBounds(sinistraPanel.getWidth() + 20, menuPanel.getY(), WIDTH - sinistraPanel.getWidth() - menuPanel.getWidth() - 20, menuPanel.getHeight());
        utenteLabel.setForeground(Stile.BLU_SCURO.getColore());
        utenteLabel.setFont(Stile.TESTO_FINE.getFont());
        infoPanel.add(utenteLabel);
		
		prontoSoccorsoBottoniPanel = new JPanel();
		prontoSoccorsoBottoniPanel.setBounds(0, (int) (sinistraPanel.getHeight() * 0.34), sinistraPanel.getWidth(), (int) (sinistraPanel.getHeight() * 0.65));
		prontoSoccorsoBottoniPanel.setBackground(Stile.BLU_SCURO.getColore()); 
		prontoSoccorsoBottoniPanel.setLayout(null);
		prontoSoccorsoBottoniPanel.setVisible(true);
		sinistraPanel.add(prontoSoccorsoBottoniPanel);
		
		inserisciPazienteButton = new JButton("Inserisci nuovo paziente");
		inserisciPazienteButton.setBounds(0, 0, prontoSoccorsoBottoniPanel.getWidth(), 36);
		inserisciPazienteButton.setBackground(Stile.BLU_SCURO.getColore());
		inserisciPazienteButton.setForeground(Color.WHITE);
		inserisciPazienteButton.setFont(Stile.TESTO.getFont());
		inserisciPazienteButton.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Stile.BLU.getColore()));
		prontoSoccorsoBottoniPanel.add(inserisciPazienteButton);
		
		inserisciDiariaButton = new JButton("Inserisci prima diaria medica");
		inserisciDiariaButton.setBounds(0, inserisciPazienteButton.getHeight(), prontoSoccorsoBottoniPanel.getWidth(), 36);
		inserisciDiariaButton.setBackground(Stile.BLU_SCURO.getColore());
		inserisciDiariaButton.setForeground(Color.WHITE);
		inserisciDiariaButton.setFont(Stile.TESTO.getFont());
		inserisciDiariaButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Stile.BLU.getColore()));
		prontoSoccorsoBottoniPanel.add(inserisciDiariaButton);
		
		prendereCaricoBottoniPanel = new JPanel();
		prendereCaricoBottoniPanel.setBounds(0, (int) (sinistraPanel.getHeight() * 0.34), sinistraPanel.getWidth(), (int) (sinistraPanel.getHeight() * 0.65));
		prendereCaricoBottoniPanel.setBackground(Stile.BLU_SCURO.getColore()); 
		prendereCaricoBottoniPanel.setLayout(null);
		prendereCaricoBottoniPanel.setVisible(false);
		sinistraPanel.add(prendereCaricoBottoniPanel);
		
		assegnaLettoButton = new JButton("Assegna posto letto");
		assegnaLettoButton.setBounds(0, 0, prendereCaricoBottoniPanel.getWidth(), 36);
		assegnaLettoButton.setBackground(Stile.BLU_SCURO.getColore());
		assegnaLettoButton.setForeground(Color.WHITE);
		assegnaLettoButton.setFont(Stile.TESTO.getFont());
        assegnaLettoButton.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Stile.BLU.getColore()));
		prendereCaricoBottoniPanel.add(assegnaLettoButton);
		
		repartoBottoniPanel = new JPanel();
		repartoBottoniPanel.setBounds(0, (int) (sinistraPanel.getHeight() * 0.34), sinistraPanel.getWidth(), (int) (sinistraPanel.getHeight() * 0.65));
		repartoBottoniPanel.setBackground(Stile.BLU_SCURO.getColore()); 
		repartoBottoniPanel.setLayout(null);
		repartoBottoniPanel.setVisible(false);
		sinistraPanel.add(repartoBottoniPanel);
		
		modificaDiariaMedButton = new JButton("Modifica diaria medica");
		modificaDiariaMedButton.setBounds(0, 0, repartoBottoniPanel.getWidth(), 36);
		modificaDiariaMedButton.setBackground(Stile.BLU_SCURO.getColore());
		modificaDiariaMedButton.setForeground(Color.WHITE);
		modificaDiariaMedButton.setFont(Stile.TESTO.getFont());
        modificaDiariaMedButton.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(modificaDiariaMedButton);
		
		inserisciDiariaInfButton = new JButton("Inserisci diaria infermieristica");
		inserisciDiariaInfButton.setBounds(0, modificaDiariaMedButton.getHeight(), repartoBottoniPanel.getWidth(), 36);
		inserisciDiariaInfButton.setBackground(Stile.BLU_SCURO.getColore());
		inserisciDiariaInfButton.setForeground(Color.WHITE);
		inserisciDiariaInfButton.setFont(Stile.TESTO.getFont());
        inserisciDiariaInfButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(inserisciDiariaInfButton);
		
		inserisciRilevazioneButton = new JButton("Inserisci rilevazione");
		inserisciRilevazioneButton.setBounds(0, modificaDiariaMedButton.getHeight() * 2, repartoBottoniPanel.getWidth(), 36);
		inserisciRilevazioneButton.setBackground(Stile.BLU_SCURO.getColore());
		inserisciRilevazioneButton.setForeground(Color.WHITE);
		inserisciRilevazioneButton.setFont(Stile.TESTO.getFont());
        inserisciRilevazioneButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(inserisciRilevazioneButton);
		
		visualizzaDiarieInfButton = new JButton("Visualizza diarie infermieristiche");
		visualizzaDiarieInfButton.setBounds(0, modificaDiariaMedButton.getHeight() * 3, repartoBottoniPanel.getWidth(), 36);
		visualizzaDiarieInfButton.setBackground(Stile.BLU_SCURO.getColore());
		visualizzaDiarieInfButton.setForeground(Color.WHITE);
		visualizzaDiarieInfButton.setFont(Stile.TESTO.getFont());
        visualizzaDiarieInfButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(visualizzaDiarieInfButton);
		
		visualizzaRilevazioniButton = new JButton("Visualizza rilevazioni");
		visualizzaRilevazioniButton.setBounds(0, modificaDiariaMedButton.getHeight() * 4, repartoBottoniPanel.getWidth(), 36);
		visualizzaRilevazioniButton.setBackground(Stile.BLU_SCURO.getColore());
		visualizzaRilevazioniButton.setForeground(Color.WHITE);
		visualizzaRilevazioniButton.setFont(Stile.TESTO.getFont());
        visualizzaRilevazioniButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(visualizzaRilevazioniButton);
		
		visualizzaStoricoButton = new JButton("Visualizza storico");
		visualizzaStoricoButton.setBounds(0, modificaDiariaMedButton.getHeight() * 5, repartoBottoniPanel.getWidth(), 36);
		visualizzaStoricoButton.setBackground(Stile.BLU_SCURO.getColore());
		visualizzaStoricoButton.setForeground(Color.WHITE);
		visualizzaStoricoButton.setFont(Stile.TESTO.getFont());
        visualizzaStoricoButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(visualizzaStoricoButton);
		
		visualizzaFarmaciButton = new JButton("Visualizza farmaci");
		visualizzaFarmaciButton.setBounds(0, modificaDiariaMedButton.getHeight() * 6, repartoBottoniPanel.getWidth(), 36);
		visualizzaFarmaciButton.setBackground(Stile.BLU_SCURO.getColore());
		visualizzaFarmaciButton.setForeground(Color.WHITE);
		visualizzaFarmaciButton.setFont(Stile.TESTO.getFont());
        visualizzaFarmaciButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(visualizzaFarmaciButton);
		
		visualizzaInformazioniButton = new JButton("Visualizza informazioni");
		visualizzaInformazioniButton.setBounds(0, modificaDiariaMedButton.getHeight() * 7, repartoBottoniPanel.getWidth(), 36);
		visualizzaInformazioniButton.setBackground(Stile.BLU_SCURO.getColore());
		visualizzaInformazioniButton.setForeground(Color.WHITE);
		visualizzaInformazioniButton.setFont(Stile.TESTO.getFont());
        visualizzaInformazioniButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(visualizzaInformazioniButton);
		
		dimettiButton = new JButton("Dimetti paziente");
		dimettiButton.setBounds(0, modificaDiariaMedButton.getHeight() * 8, repartoBottoniPanel.getWidth(), 36);
		dimettiButton.setBackground(Stile.BLU_SCURO.getColore());
		dimettiButton.setForeground(Color.WHITE);
		dimettiButton.setFont(Stile.TESTO.getFont());
        dimettiButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(dimettiButton);
		
		JLabel cercaLabel = new JLabel("Cerca Nome e Cognome");
		cercaLabel.setBounds(20, 0, 130, filtriPanel.getHeight());
		cercaLabel.setForeground(Color.WHITE);
		filtriPanel.add(cercaLabel);
        
        cercaTextField = new JTextField();
		cercaTextField.setBounds(cercaLabel.getWidth() + 40, (cercaLabel.getHeight() - 24) / 2, 200, 24);
		filtriPanel.add(cercaTextField);
		
		cercaButton = new JButton();
		cercaButton.setBounds(cercaTextField.getX() + cercaTextField.getWidth(), (cercaLabel.getHeight() - 24) / 2, 24, 24);
		cercaButton.setBackground(Stile.AZZURRO.getColore());
		cercaButton.setIcon(cercaImage);
        cercaButton.setBorder(BorderFactory.createEmptyBorder());
		filtriPanel.add(cercaButton);
		
		JLabel urgenzaLabel = new JLabel("Urgenza");
		urgenzaLabel.setBounds(cercaButton.getX() + cercaButton.getWidth() + 30, 0, 50, filtriPanel.getHeight());
		urgenzaLabel.setForeground(Color.WHITE);
		filtriPanel.add(urgenzaLabel);
		
		urgenzaComboBox = new JComboBox<String>();
		urgenzaComboBox.setBounds(urgenzaLabel.getX() + urgenzaLabel.getWidth(), (cercaLabel.getHeight() - 24) / 2, cercaLabel.getWidth(), 24);
	    urgenzaComboBox.addItem(" ");
        urgenzaComboBox.addItem("Rosso");
        urgenzaComboBox.addItem("Giallo");
        urgenzaComboBox.addItem("Verde");
		filtriPanel.add(urgenzaComboBox);
		
		repartoLabel = new JLabel("Reparto");
		repartoLabel.setBounds(urgenzaComboBox.getX() + urgenzaComboBox.getWidth() + 30, 0, 50, filtriPanel.getHeight());
		repartoLabel.setForeground(Color.WHITE);
		repartoLabel.setVisible(false);
		filtriPanel.add(repartoLabel);
		
		repartoComboBox = new JComboBox<String>();
		repartoComboBox.setBounds(repartoLabel.getX() + urgenzaLabel.getWidth(), (cercaLabel.getHeight() - 24) / 2, cercaLabel.getWidth(), 24);
		repartoComboBox.addItem(" ");
		for (String nomeReparto : modello.modelloGestoreLogistica.getNomiReparti()) {
			repartoComboBox.addItem(nomeReparto);
		}
		repartoComboBox.setVisible(false);
		filtriPanel.add(repartoComboBox);

		indietroButton = new JButton();
		indietroButton.setBounds(filtriPanel.getWidth() - 36, (cercaLabel.getHeight() - 24) / 2, 24, 24);
		indietroButton.setBackground(Stile.AZZURRO.getColore());
		indietroButton.setIcon(ripristinaImage);
	    indietroButton.setBorder(BorderFactory.createEmptyBorder());
		filtriPanel.add(indietroButton);
		
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Cognome");
        tableModel.addColumn("Sesso");
        tableModel.addColumn("Data di Arrivo");
        tableModel.addColumn("Ora di Arrivo");
        tableModel.addColumn("Urgenza");
        tableModel.addColumn("Codice");
        
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
        
        for(int i = 0; i < tableModel.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new TabellaRenderer());
        }
        
		JScrollPane scrollPanel = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setBounds(0, filtriPanel.getHeight(), centroPanel.getWidth(), centroPanel.getHeight());
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.setViewportView(table);
        centroPanel.add(scrollPanel);
        
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(table.getColumnModel().getTotalColumnWidth(), 30));
        tableHeader.setBackground(Stile.BLU.getColore());
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setFont(Stile.TESTO.getFont());
        tableHeader.setReorderingAllowed(false);
       
        TableRowSorter<DefaultTableModel> ordineColonna = new TableRowSorter<>(tableModel);
        table.setRowSorter(ordineColonna);
       
		sfondoFrame.setVisible(true);
	}
	
	public void updateViewUtente() {
		utenteLabel.setText(modello.modelloGestoreUtente.getUtente());
		
	}
	
	public synchronized  void updateViewTabella() {
			if (updating) {
                return;
            }
			updating = true;
			tableModel.setRowCount(0);
			if (!posizioneAttuale.equals("in Reparto")) {
				tableModel.setColumnCount(7);
			}
			else {
				tableModel.addColumn("Reparto");
		        tableModel.addColumn("Modulo");
		        tableModel.addColumn("Letto");
		        tableModel.setColumnCount(10);
			}
			for (int i = 0; i < modello.modelloGestoreTabella.getTableNomi().size(); i++) {
		    	   tableModel.addRow(new Object[] {modello.modelloGestoreTabella.getTableNomi().get(i), modello.modelloGestoreTabella.getTableCognomi().get(i), 
		    			   modello.modelloGestoreTabella.getTableSesso().get(i), modello.modelloGestoreTabella.getTableDateArrivo().get(i),
		    			   modello.modelloGestoreTabella.getTableOraArrivo().get(i), modello.modelloGestoreTabella.getTableUrgenza().get(i), 
		    			   modello.modelloGestoreTabella.getTableCodice().get(i), modello.modelloGestoreTabella.getTableReparto().get(i), modello.modelloGestoreTabella.getTableModulo().get(i), modello.modelloGestoreTabella.getTableNumeroLetto().get(i)});
			}
	        for(int i = 0; i < tableModel.getColumnCount(); i++) {
	            table.getColumnModel().getColumn(i).setCellRenderer(new TabellaRenderer());
	        }
			updating = false;
	}
	
	public void updateStringaPaziente() {
		pazienteTitoloLabel.setText(modello.modelloGestoreVisualizzazioneDatiPaziente.getStringaDatiPaziente());
		dataPazienteLabel.setText(modello.modelloGestoreVisualizzazioneDatiPaziente.getStringaArrivoPaziente());
		motivoPazienteLabel.setText(modello.modelloGestoreVisualizzazioneDatiPaziente.getStringaCondizionePaziente());
	}
	
    static class TabellaRenderer extends DefaultTableCellRenderer {

    	private final ImageIcon rossoImage = new ImageIcon("../progetto_gui/src/main/resources/rosso.png");
    	private final ImageIcon gialloImage = new ImageIcon("../progetto_gui/src/main/resources/giallo.png");
    	private final ImageIcon verdeImage = new ImageIcon("../progetto_gui/src/main/resources/verde.png");
    	private final ImageIcon maschioImage = new ImageIcon("../progetto_gui/src/main/resources/maschio.png");
    	private final ImageIcon femminaImage = new ImageIcon("../progetto_gui/src/main/resources/femmina.png");

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            this.setHorizontalAlignment(SwingConstants.CENTER);
            if (value instanceof String) {
                if ("rosso".equals(value)) {
                    setIcon(rossoImage);
                    setText("");
                } else if ("giallo".equals(value)) {
                    setIcon(gialloImage);
                    setText(""); 
                } else if ("verde".equals(value)) {
                    setIcon(verdeImage);
                    setText("");  
                } else if ("M".equals(value)) {
                    setIcon(maschioImage);
                    setText("");
                } else if ("F".equals(value)) {
                    setIcon(femminaImage);
                    setText("");
                }
                
            }
            return component;
        }
    }
	
	/*
	public static void main(String[] args) {
		new PazientiFrame();
	}*/
}
