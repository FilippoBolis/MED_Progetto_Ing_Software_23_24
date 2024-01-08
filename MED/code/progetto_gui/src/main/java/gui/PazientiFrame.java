package gui;

import java.awt.Color;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import com.formdev.flatlaf.FlatIntelliJLaf;

//import logiche_bottoni.LoginLogic;
import modelli.ModelloGestoreLogicaGenerale;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class PazientiFrame {
	
	ImageIcon ripristinaImage = new ImageIcon("../progetto_gui/src/main/resources/ripristina.png");
	ImageIcon cercaImage = new ImageIcon("../progetto_gui/src/main/resources/cerca.png");
	private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public JFrame sfondoFrame;
	public String infoPaziente = "Seleziona un paziente nel database";
	private DefaultTableModel tableModel;
	public JTable table;
	private JLabel utenteLabel;
	private JLabel pazienteTitoloLabel;
	private ModelloGestoreLogicaGenerale modello;
    public boolean updating = false;

	@SuppressWarnings("serial")
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
        
        utenteLabel = new JLabel();
        utenteLabel.setBounds(20, 0, WIDTH, (int) (infoPanel.getHeight() * 0.2));
        utenteLabel.setForeground(Stile.BLU_SCURO.getColore());
        utenteLabel.setFont(Stile.TESTO.getFont());
        infoPanel.add(utenteLabel);
        
        JPanel pazientePanel = new JPanel();
        pazientePanel.setBounds(0, utenteLabel.getHeight(), WIDTH, (int) (infoPanel.getHeight() * 0.8));
        pazientePanel.setBackground(Stile.BLU.getColore());
        pazientePanel.setLayout(null);
        infoPanel.add(pazientePanel);
        
        pazienteTitoloLabel = new JLabel("Paziente");
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
        
        JPanel menuPanel = new JPanel();
        menuPanel.setBounds((int) (WIDTH * 0.5), pazientePanel.getHeight() - ((int) (pazientePanel.getHeight() * 0.2)), (int) (WIDTH * 0.5), (int) (pazientePanel.getHeight() * 0.2));
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setLayout(null);
        pazientePanel.add(menuPanel);
        
        //FILIPPO
        //Questi ToggleButton sono pulsanti speciali che rimangono cliccati se schiacciati. 
        //Nella logica devi fare in modo che solo uno sia selezionato (ora possono essere cliccati anche tutti e 3 insieme),
        //e che pronto soccorso sia già cliccato all'avvio.    
        //IMPORTANTE
        //In generale in ogni frame direi di mettere tutti i bottoni possibili sempre visibili per tutti, doc, infermiera, segreteria.
        //Se poi ad esempio un infermiera clicca su pulsante riservato a dottore facciamo uscire l'errore con ErroreFrame,
        //oppure anche se per esempio vuoi compilare la diaria ma non hai neancora selezionato il paziente,
        //oppure se ho cercato un nome paziente che non esiste.
        //Direi di gestirli tutti cosi, in questo modo basta chiamare la classe errere e scrivere il messaggio da visualizzare come errore
        
        JToggleButton prontoSoccorsoToggleButton = new JToggleButton("IN PRONTO SOCCORSO");
        prontoSoccorsoToggleButton.setBounds(0, 0, (int) (menuPanel.getWidth() * 0.34), menuPanel.getHeight());
        prontoSoccorsoToggleButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY)); 
        prontoSoccorsoToggleButton.setForeground(Stile.BLU_SCURO.getColore());
        prontoSoccorsoToggleButton.setFont(Stile.TESTO.getFont());
        menuPanel.add(prontoSoccorsoToggleButton);
        
        JToggleButton inCaricoToggleButton = new JToggleButton("DA PRENDERE IN CARICO");
        inCaricoToggleButton.setBounds(prontoSoccorsoToggleButton.getWidth(), 0, (int) (menuPanel.getWidth() * 0.34), menuPanel.getHeight());
        inCaricoToggleButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY)); 
        inCaricoToggleButton.setForeground(Stile.BLU_SCURO.getColore());
        inCaricoToggleButton.setFont(Stile.TESTO.getFont());
        menuPanel.add(inCaricoToggleButton);
        
        JToggleButton repartoToggleButton = new JToggleButton("IN REPARTO");
        repartoToggleButton.setBounds(inCaricoToggleButton.getWidth() * 2, 0, (int) (menuPanel.getWidth() * 0.34), menuPanel.getHeight());
        repartoToggleButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY)); 
        repartoToggleButton.setForeground(Stile.BLU_SCURO.getColore());
        repartoToggleButton.setFont(Stile.TESTO.getFont());
        menuPanel.add(repartoToggleButton);
        
		JPanel sinistraPanel = new JPanel();
		sinistraPanel.setBounds(0, (int) (HEIGHT * 0.25), (int) (WIDTH * 0.15), (int) (HEIGHT * 0.75));
		sinistraPanel.setBackground(Stile.BLU_SCURO.getColore());
		sinistraPanel.setLayout(null);
		sfondoPanel.add(sinistraPanel);
        		
        JLabel titoloLabel = new JLabel("<html>Medical<br>Environment<br>Database</html>");
        titoloLabel.setBounds(20, 0, sinistraPanel.getWidth(), (int) (infoPanel.getHeight() * 0.5));
        titoloLabel.setForeground(Color.WHITE);
        titoloLabel.setFont(Stile.SOTTOTITOLO.getFont());
        sinistraPanel.add(titoloLabel);
		
		JPanel logoPanel = new JPanel();
        logoPanel.setBounds(0, titoloLabel.getHeight(), sinistraPanel.getWidth(), 60);
        logoPanel.setBackground(Stile.BLU_SCURO.getColore());
        logoPanel.setLayout(null);
        sinistraPanel.add(logoPanel);
        
        JLabel logoLabel = new JLabel("logo");
        logoLabel.setBounds(20, 10, 155, 50);
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(Stile.SOTTOTITOLO.getFont());
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        logoLabel.setVerticalAlignment(JLabel.CENTER);
        logoLabel.setBorder(new LineBorder(Color.RED, 4));
        logoPanel.add(logoLabel);
        
        //FILIPPO: METTERE setVIsible(false) QUESTO PANEL SE NON IN PRONTO SOCCORSO
		JPanel prontoSoccorsoBottoniPanel = new JPanel();
		prontoSoccorsoBottoniPanel.setBounds(0, (int) (sinistraPanel.getHeight() * 0.35), sinistraPanel.getWidth(), (int) (sinistraPanel.getHeight() * 0.65));
		prontoSoccorsoBottoniPanel.setBackground(Stile.BLU_SCURO.getColore()); 
		prontoSoccorsoBottoniPanel.setLayout(null);
		prontoSoccorsoBottoniPanel.setVisible(true);
		sinistraPanel.add(prontoSoccorsoBottoniPanel);
		
		JButton inserisciPazienteButton = new JButton("Inserisci nuovo paziente");
		inserisciPazienteButton.setBounds(0, 0, prontoSoccorsoBottoniPanel.getWidth(), 40);
		inserisciPazienteButton.setBackground(Stile.BLU_SCURO.getColore());
		inserisciPazienteButton.setForeground(Color.WHITE);
		inserisciPazienteButton.setFont(Stile.TESTO.getFont());
        inserisciPazienteButton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Stile.BLU.getColore()));
		prontoSoccorsoBottoniPanel.add(inserisciPazienteButton);
		
		JButton inserisciDiariaButton = new JButton("Inserisci prima diaria medica");
		inserisciDiariaButton.setBounds(0, inserisciPazienteButton.getHeight(), prontoSoccorsoBottoniPanel.getWidth(), 40);
		inserisciDiariaButton.setBackground(Stile.BLU_SCURO.getColore());
		inserisciDiariaButton.setForeground(Color.WHITE);
		inserisciDiariaButton.setFont(Stile.TESTO.getFont());
        inserisciDiariaButton.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Stile.BLU.getColore()));
		prontoSoccorsoBottoniPanel.add(inserisciDiariaButton);
		
        //FILIPPO: METTERE setVIsible(false) QUESTO PANEL SE NON IN DA PRENDERE IN CARICO
		JPanel prendereCaricoBottoniPanel = new JPanel();
		prendereCaricoBottoniPanel.setBounds(0, (int) (sinistraPanel.getHeight() * 0.35), sinistraPanel.getWidth(), (int) (sinistraPanel.getHeight() * 0.65));
		prendereCaricoBottoniPanel.setBackground(Stile.BLU_SCURO.getColore()); 
		prendereCaricoBottoniPanel.setLayout(null);
		prendereCaricoBottoniPanel.setVisible(false);
		sinistraPanel.add(prendereCaricoBottoniPanel);
		
		JButton assegnaLettoButton = new JButton("Assegna posto letto");
		assegnaLettoButton.setBounds(0, 0, prendereCaricoBottoniPanel.getWidth(), 40);
		assegnaLettoButton.setBackground(Stile.BLU_SCURO.getColore());
		assegnaLettoButton.setForeground(Color.WHITE);
		assegnaLettoButton.setFont(Stile.TESTO.getFont());
        assegnaLettoButton.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Stile.BLU.getColore()));
		prendereCaricoBottoniPanel.add(assegnaLettoButton);
		
		 //FILIPPO: METTERE setVIsible(false) QUESTO PANEL SE NON IN REPARTO
		JPanel repartoBottoniPanel = new JPanel();
		repartoBottoniPanel.setBounds(0, (int) (sinistraPanel.getHeight() * 0.35), sinistraPanel.getWidth(), (int) (sinistraPanel.getHeight() * 0.65));
		repartoBottoniPanel.setBackground(Stile.BLU_SCURO.getColore()); 
		repartoBottoniPanel.setLayout(null);
		repartoBottoniPanel.setVisible(false);
		sinistraPanel.add(repartoBottoniPanel);
		
		JButton modificaDiariaMedButton = new JButton("Modifica diaria medica");
		modificaDiariaMedButton.setBounds(0, 0, repartoBottoniPanel.getWidth(), 40);
		modificaDiariaMedButton.setBackground(Stile.BLU_SCURO.getColore());
		modificaDiariaMedButton.setForeground(Color.WHITE);
		modificaDiariaMedButton.setFont(Stile.TESTO.getFont());
        modificaDiariaMedButton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(modificaDiariaMedButton);
		
		JButton inserisciDiariaInfButton = new JButton("Inserisci diaria infermieristica");
		inserisciDiariaInfButton.setBounds(0, modificaDiariaMedButton.getHeight(), repartoBottoniPanel.getWidth(), 40);
		inserisciDiariaInfButton.setBackground(Stile.BLU_SCURO.getColore());
		inserisciDiariaInfButton.setForeground(Color.WHITE);
		inserisciDiariaInfButton.setFont(Stile.TESTO.getFont());
        inserisciDiariaInfButton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(inserisciDiariaInfButton);
		
		JButton visualizzaStoricoButton = new JButton("Visualizza storico");
		visualizzaStoricoButton.setBounds(0, modificaDiariaMedButton.getHeight() * 2, repartoBottoniPanel.getWidth(), 40);
		visualizzaStoricoButton.setBackground(Stile.BLU_SCURO.getColore());
		visualizzaStoricoButton.setForeground(Color.WHITE);
		visualizzaStoricoButton.setFont(Stile.TESTO.getFont());
        visualizzaStoricoButton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(visualizzaStoricoButton);
		
		JButton visualizzaFarmaciButton = new JButton("Visualizza farmaci");
		visualizzaFarmaciButton.setBounds(0, modificaDiariaMedButton.getHeight() * 3, repartoBottoniPanel.getWidth(), 40);
		visualizzaFarmaciButton.setBackground(Stile.BLU_SCURO.getColore());
		visualizzaFarmaciButton.setForeground(Color.WHITE);
		visualizzaFarmaciButton.setFont(Stile.TESTO.getFont());
        visualizzaFarmaciButton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(visualizzaFarmaciButton);
		
		JButton visualizzaInformazioniButton = new JButton("Visualizza informazioni");
		visualizzaInformazioniButton.setBounds(0, modificaDiariaMedButton.getHeight() * 4, repartoBottoniPanel.getWidth(), 40);
		visualizzaInformazioniButton.setBackground(Stile.BLU_SCURO.getColore());
		visualizzaInformazioniButton.setForeground(Color.WHITE);
		visualizzaInformazioniButton.setFont(Stile.TESTO.getFont());
        visualizzaInformazioniButton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(visualizzaInformazioniButton);
		
		JButton dimettiButton = new JButton("Dimetti paziente");
		dimettiButton.setBounds(0, modificaDiariaMedButton.getHeight() * 5, repartoBottoniPanel.getWidth(), 40);
		dimettiButton.setBackground(Stile.BLU_SCURO.getColore());
		dimettiButton.setForeground(Color.WHITE);
		dimettiButton.setFont(Stile.TESTO.getFont());
        dimettiButton.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Stile.BLU.getColore()));
		repartoBottoniPanel.add(dimettiButton);
        
		JPanel centroPanel = new JPanel();
		centroPanel.setBounds(prendereCaricoBottoniPanel.getWidth(), (int) (HEIGHT * 0.25), (int) (WIDTH * 0.85), (int) (HEIGHT * 0.75));
        centroPanel.setLayout(null);
		sfondoPanel.add(centroPanel);
		
		JPanel filtriPanel = new JPanel();
		filtriPanel.setBounds(0, 0, centroPanel.getWidth(), (int) (centroPanel.getHeight() * 0.1));
		filtriPanel.setBackground(Stile.AZZURRO.getColore());
        filtriPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.LIGHT_GRAY));
        filtriPanel.setLayout(null);
        centroPanel.add(filtriPanel);
		
		JLabel cercaLabel = new JLabel("Cerca inserendo Nome e Cognome");
		cercaLabel.setBounds(20, 0, 200, filtriPanel.getHeight());
		cercaLabel.setForeground(Color.WHITE);
		filtriPanel.add(cercaLabel);
        
        JTextField cercaTextField = new JTextField();
		cercaTextField.setBounds(cercaLabel.getWidth() + 20, (cercaLabel.getHeight() - 24) / 2, cercaLabel.getWidth(), 24);
		filtriPanel.add(cercaTextField);
		
		JButton cercaButton = new JButton();
		cercaButton.setBounds(cercaTextField.getX() + cercaTextField.getWidth(), (cercaLabel.getHeight() - 24) / 2, 24, 24);
		cercaButton.setBackground(Stile.AZZURRO.getColore());
		cercaButton.setIcon(cercaImage);
        cercaButton.setBorder(BorderFactory.createEmptyBorder());
		filtriPanel.add(cercaButton);
		
		JLabel urgenzaLabel = new JLabel("Filtra per urgenza");
		urgenzaLabel.setBounds(centroPanel.getWidth() / 2, 0, 100, filtriPanel.getHeight());
		urgenzaLabel.setForeground(Color.WHITE);
		filtriPanel.add(urgenzaLabel);
		
		JComboBox<String> urgenzaComboBox = new JComboBox<String>();
		urgenzaComboBox.setBounds(urgenzaLabel.getX() + urgenzaLabel.getWidth(), (cercaLabel.getHeight() - 24) / 2, cercaLabel.getWidth(), 24);
	    urgenzaComboBox.addItem(" ");
        urgenzaComboBox.addItem("ROSSO");
        urgenzaComboBox.addItem("GIALLO");
        urgenzaComboBox.addItem("VERDE");
		filtriPanel.add(urgenzaComboBox);

		JButton indietroButton = new JButton();
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
	public synchronized  void updateViewTabellaProntoSoccorso() {
			if (updating) {
                return;
            }
			updating = true;
			tableModel.setRowCount(0);
			for (int i=0; i<modello.modelloGestoreTabella.getTableNomi().size(); i++) {
	    	   tableModel.addRow(new Object[] {modello.modelloGestoreTabella.getTableNomi().get(i),modello.modelloGestoreTabella.getTableCognomi().get(i),modello.modelloGestoreTabella.getTableSesso().get(i),modello.modelloGestoreTabella.getTableDateArrivo().get(i),modello.modelloGestoreTabella.getTableOraArrivo().get(i),modello.modelloGestoreTabella.getTableUrgenza().get(i),modello.modelloGestoreTabella.getTableCodice().get(i)});
			}
			updating = false;
	}
	
	public void updateStringaPaziente() {
		pazienteTitoloLabel.setText(modello.modelloGestoreStringaPaziente.getDatiPaziente());
	}
	
	/*
	//NON CANCELLARE, ROBA CHE MI SERVIRA' PER METTERE ICONE NELLA TABELLA  
    static class IconRenderer extends DefaultTableCellRenderer {
        private final ImageIcon iconA = new ImageIcon("path-to-icon1.png");
        private final ImageIcon iconB = new ImageIcon("path-to-icon2.png");

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Verifica se il valore nella cella è una stringa
            if (value instanceof String) {
                // Confronta il valore con "A" o "B" e imposta l'icona corrispondente
                if ("A".equals(value)) {
                    setIcon(iconA);
                    setText(""); // Rimuovi il testo
                } else if ("B".equals(value)) {
                    setIcon(iconB);
                    setText(""); // Rimuovi il testo
                }
            }

            return component;
        }
    }
	*/
	
	/*
	public static void main(String[] args) {
		new PazientiFrame();
	}
	*/
}
