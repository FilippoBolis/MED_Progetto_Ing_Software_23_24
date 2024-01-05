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

import com.formdev.flatlaf.FlatIntelliJLaf;

public class PazientiFrame {
	
	public JFrame sfondoFrame;
	public DefaultTableModel tableModel;
	public JTable table;
	
	private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
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
		sfondoFrame.setResizable(true);
		sfondoFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel sfondoPanel = new JPanel();
		sfondoPanel.setLayout(null);
		sfondoFrame.getContentPane().add(sfondoPanel);
		
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.RED);
        infoPanel.setBounds((int) (WIDTH * 0.25), 0, WIDTH, (int)(HEIGHT * 0.25));
        infoPanel.setLayout(null);
        sfondoPanel.add(infoPanel);

		JPanel sinistraPanel = new JPanel();
		sinistraPanel.setBounds(0, 0, (int) (WIDTH * 0.25), HEIGHT);
		sinistraPanel.setBackground(Stile.BLU_SCURO.getColore());
		sinistraPanel.setLayout(null);
		sfondoPanel.add(sinistraPanel);
		
		JPanel centroPanel = new JPanel();
		centroPanel.setBounds((int) (WIDTH * 0.25), (int) (HEIGHT * 0.25), (int) (WIDTH * 0.75), (int) (HEIGHT * 0.75));
		centroPanel.setLayout(null);
		sfondoPanel.add(centroPanel);
		
        tableModel = new DefaultTableModel();
        tableModel.addColumn("CODICE");
        tableModel.addColumn("NOME");
        tableModel.addColumn("COGNOME");
        tableModel.addColumn("URGENZA");
        tableModel.addColumn("IN ATTESA");
        
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setRowHeight(40);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setSelectionBackground(Stile.AZZURRO_TRASP.getColore());
        
		JScrollPane scrollPanel = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanel.setBounds(20, 20, (int) (WIDTH * 0.75) - 40, (int) (HEIGHT * 0.75) - 90 );
        scrollPanel.setBorder(BorderFactory.createEmptyBorder()); 
        scrollPanel.setViewportView(table);
        centroPanel.add(scrollPanel);
        
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(table.getColumnModel().getTotalColumnWidth(), 40));
        tableHeader.setBackground(Stile.AZZURRO.getColore());
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setFont(Stile.SOTTOTITOLO.getFont());
        tableHeader.setEnabled(false);
        
        

        
        //TOGLIERE
        for (int i = 0; i < 30; i++) {
            tableModel.addRow(new Object[]{"a", "a", "a", "a", "a"});
        }
       
        
		
		
		sfondoFrame.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		new PazientiFrame();
	}
}
