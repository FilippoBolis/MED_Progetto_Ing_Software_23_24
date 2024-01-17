package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import com.formdev.flatlaf.FlatIntelliJLaf;

import gui.PazientiFrame.TabellaRenderer;
import modelli.ModelloGestoreLogicaGenerale;

public class VisualizzaDiarieInfFrame {
	private ImageIcon diariaImage = new ImageIcon("../progetto_gui/src/main/resources/diaria.png");
	public JFrame sfondoFrame;
	public DefaultTableModel tableModel;
	public JTable table;
	public boolean updating;
	private JLabel diarieLabel;
	private ModelloGestoreLogicaGenerale modello;
	@SuppressWarnings("serial")
	public VisualizzaDiarieInfFrame(ModelloGestoreLogicaGenerale m) {
		modello = m;
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(760, 540);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Visualizza diarie infermieristiche</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);
		
		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);
		
		JPanel diariePanel = new JPanel();
		diariePanel.setBounds(10, 10, 726, 482);
		diariePanel.setBackground(Color.WHITE);
		diariePanel.setLayout(null);
		sfondoPanel.add(diariePanel);
		
		JLabel titoloLabel = new JLabel("Visualizza diarie infermieristiche");
		titoloLabel.setBounds(100, 30, 596, 48);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		diariePanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(30, 30, 48, 48);
		immagineLabel.setIcon(diariaImage);
		diariePanel.add(immagineLabel);
		
		diarieLabel = new JLabel("Diarie infermieristiche");
		diarieLabel.setBounds(30, 96, 666, 30);
		diarieLabel.setForeground(Color.GRAY);
		diarieLabel.setFont(Stile.TESTO.getFont());
		diariePanel.add(diarieLabel);
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Codice Personale");
		tableModel.addColumn("Note");
        tableModel.addColumn("Importante");
        tableModel.addColumn("Farmaci");
        tableModel.addColumn("Data");
        tableModel.addColumn("Ora");
       
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setBackground(UIManager.getColor("Panel.background"));
        table.setRowHeight(30);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setSelectionBackground(Stile.AZZURRO_TRASP.getColore());    
        
		JScrollPane scrollPanel = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setBounds(30, 129, 666, 323);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.setViewportView(table);
        diariePanel.add(scrollPanel);
        
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
	public void setPersonaView(String persona) {
		diarieLabel.setText("Diarie infermieristiche di " + persona);
	}
	
	public synchronized  void updateViewTabella() {
		if (updating) {
            return;
        }
		updating = true;
		for (int i = 0; i < modello.modelloGestoreDiarieInfermieristiche.getCodiceInfermiere().size(); i++) {
	    	   tableModel.addRow(new Object[] {modello.modelloGestoreDiarieInfermieristiche.getCodiceInfermiere().get(i),modello.modelloGestoreDiarieInfermieristiche.getTableNoteParticolari().get(i),modello.modelloGestoreDiarieInfermieristiche.getTableImportante().get(i),modello.modelloGestoreDiarieInfermieristiche.getTableFarmaci().get(i),modello.modelloGestoreDiarieInfermieristiche.getTableDateArrivo().get(i),modello.modelloGestoreDiarieInfermieristiche.getTableOraArrivo().get(i)});
		}
        for(int i = 0; i < tableModel.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new TabellaRenderer());
        }
		updating = false;
	}
}
