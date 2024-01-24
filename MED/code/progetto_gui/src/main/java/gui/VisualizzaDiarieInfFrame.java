package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import com.formdev.flatlaf.FlatIntelliJLaf;
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
		sfondoFrame.setSize(860, 540);
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
		diariePanel.setBounds(10, 10, 826, 482);
		diariePanel.setBackground(Color.WHITE);
		diariePanel.setLayout(null);
		sfondoPanel.add(diariePanel);
		
		JLabel titoloLabel = new JLabel("Visualizza diarie infermieristiche");
		titoloLabel.setBounds(100, 30, 696, 48);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		diariePanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(diariaImage.getImage(), 0 , 0, this.getWidth(), this.getHeight(), this);
			}
		};
		immagineLabel.setBounds(30, 30, 48, 48);
		diariePanel.add(immagineLabel);
		
		diarieLabel = new JLabel("Diarie infermieristiche");
		diarieLabel.setBounds(30, 96, 766, 30);
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
        
        table.setBackground(Color.WHITE);
        table.setRowHeight(40);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setSelectionBackground(Stile.AZZURRO_TRASP.getColore()); 
        table.setCellSelectionEnabled(false);
        table.setFocusable(false);
        
		JScrollPane scrollPanel = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setBounds(30, 129, 766, 323);
        scrollPanel.getViewport().setBackground(UIManager.getColor("Panel.background"));
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.setViewportView(table);
        diariePanel.add(scrollPanel);
        
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(table.getColumnModel().getTotalColumnWidth(), 40));
        tableHeader.setBackground(Stile.BLU.getColore());
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setFont(Stile.TESTO.getFont());
        tableHeader.setReorderingAllowed(false);
       
        TableRowSorter<DefaultTableModel> ordineColonna = new TableRowSorter<>(tableModel);
        table.setRowSorter(ordineColonna);
        
        for(int i = 0; i < tableModel.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new TabellaRenderer());
        }

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
	    	   tableModel.addRow(new Object[] {
	    			   modello.modelloGestoreDiarieInfermieristiche.getCodiceInfermiere().get(i),
	    			   modello.modelloGestoreDiarieInfermieristiche.getTableNoteParticolari().get(i),
	    			   modello.modelloGestoreDiarieInfermieristiche.getTableImportante().get(i),
	    			   modello.modelloGestoreDiarieInfermieristiche.getTableFarmaci().get(i),
	    			   modello.modelloGestoreDiarieInfermieristiche.getTableDateArrivo().get(i),
	    			   modello.modelloGestoreDiarieInfermieristiche.getTableOraArrivo().get(i)
	    	   });
		}
        for(int i = 0; i < tableModel.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new TabellaRenderer());
        }
		updating = false;
	}
	
	@SuppressWarnings("serial")
	static class TabellaRenderer extends DefaultTableCellRenderer {

	    private final ImageIcon trueImage = new ImageIcon("../progetto_gui/src/main/resources/spunta.png");
		private final ImageIcon falseImage = new ImageIcon("../progetto_gui/src/main/resources/x.png");

		@Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	    	Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    		setHorizontalAlignment(SwingConstants.CENTER);
    		setVerticalAlignment(SwingConstants.CENTER);
    		setLayout(null);
	    	
    		if(column == 1 || column == 3) {
		    	JTextArea textArea = new JTextArea();
		        textArea.setLineWrap(true);
		        textArea.setWrapStyleWord(true);

		        TableColumnModel columnModel = table.getColumnModel();
		        int larghezzaColonna = columnModel.getColumn(column).getWidth();
		        textArea.setSize(larghezzaColonna, 40);
		        String testo = String.valueOf(value) + "\n";
		        textArea.setText(testo);
		        int preferredHeight = textArea.getPreferredSize().height;
		        table.setRowHeight(row, preferredHeight);		        	
		        
		        textArea.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, UIManager.getColor("Table.gridColor")));
		        textArea.setFont(new Font(getFont().getFontName(), Font.ITALIC, 12));
		        
		        return textArea;
	
	    	} else if (column == 2){
	            if (value instanceof Boolean) {
	                if (Boolean.parseBoolean(value.toString()) == true) {
	                    setIcon(trueImage);
	                    setText("");
	                } else {
	                    setIcon(falseImage);
	                    setText("");
	                }
	            }
	    		return component;
	    	
	    	} else {
	    		return component;
	    	}
	    }
	}

}
