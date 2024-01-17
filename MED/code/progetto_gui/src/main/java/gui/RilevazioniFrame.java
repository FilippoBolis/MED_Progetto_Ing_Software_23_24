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

public class RilevazioniFrame {
	private ImageIcon rilevazioniImage = new ImageIcon("../progetto_gui/src/main/resources/rilevazioni.png");
	public JFrame sfondoFrame;
	public DefaultTableModel tableModel;
	public JTable table;
	
	@SuppressWarnings("serial")
	public RilevazioniFrame() {
		
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(720, 540);
		sfondoFrame.setTitle("<html><font color='white'>M.E.D Visualizza rilevazioni</font></html>");
		sfondoFrame.getRootPane().setBackground(Stile.AZZURRO.getColore());
		sfondoFrame.getRootPane().setForeground(Color.WHITE);
		sfondoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sfondoFrame.setLocationRelativeTo(null);
		sfondoFrame.setResizable(false);
		
		JPanel sfondoPanel = new JPanel();
		sfondoFrame.getContentPane().add(sfondoPanel);
		sfondoPanel.setLayout(null);
		
		JPanel rilevazioniPanel = new JPanel();
		rilevazioniPanel.setBounds(10, 10, 686, 482);
		rilevazioniPanel.setBackground(Color.WHITE);
		rilevazioniPanel.setLayout(null);
		sfondoPanel.add(rilevazioniPanel);
		
		JLabel titoloLabel = new JLabel("Visualizza rilevazioni");
		titoloLabel.setBounds(100, 30, 556, 48);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rilevazioniPanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel();
		immagineLabel.setBounds(30, 30, 48, 48);
		immagineLabel.setIcon(rilevazioniImage);
		rilevazioniPanel.add(immagineLabel);
		
		JLabel rilevazioniLabel = new JLabel("Rilevazioni");
		rilevazioniLabel.setBounds(30, 96, 626, 30);
		rilevazioniLabel.setForeground(Color.GRAY);
		rilevazioniLabel.setFont(Stile.TESTO.getFont());
		rilevazioniPanel.add(rilevazioniLabel);
		
		tableModel = new DefaultTableModel();
        tableModel.addColumn("Glicemia");
        tableModel.addColumn("Temperatura");
        tableModel.addColumn("Pressione");
        tableModel.addColumn("Frequenza Cardiaca");
        tableModel.addColumn("Dolore");
       
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
        scrollPanel.setBounds(30, 129, 626, 323);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.setViewportView(table);
        rilevazioniPanel.add(scrollPanel);
        
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
	
	public static void main(String[] args) {
		new RilevazioniFrame();
	}

}
