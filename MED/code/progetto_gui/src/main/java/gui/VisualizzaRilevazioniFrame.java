package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class VisualizzaRilevazioniFrame {
	private ImageIcon rilevazioniImage = new ImageIcon("../progetto_gui/src/main/resources/rilevazioni.png");
	public JFrame sfondoFrame;
	public DefaultTableModel tableModel;
	public JTable table;
	
	@SuppressWarnings("serial")
	public VisualizzaRilevazioniFrame() {
		
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(760, 540);
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
		rilevazioniPanel.setBounds(10, 10, 726, 482);
		rilevazioniPanel.setBackground(Color.WHITE);
		rilevazioniPanel.setLayout(null);
		sfondoPanel.add(rilevazioniPanel);
		
		JLabel titoloLabel = new JLabel("Visualizza rilevazioni");
		titoloLabel.setBounds(100, 30, 596, 48);
		titoloLabel.setForeground(Stile.BLU_SCURO.getColore());
		titoloLabel.setFont(Stile.TITOLO.getFont());
		titoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rilevazioniPanel.add(titoloLabel);
		
		JLabel immagineLabel = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(rilevazioniImage.getImage(), 0 , 0, this.getWidth(), this.getHeight(), this);
			}
		};;
		immagineLabel.setBounds(30, 30, 48, 48);
		rilevazioniPanel.add(immagineLabel);
		
		JLabel rilevazioniLabel = new JLabel("Rilevazioni");
		rilevazioniLabel.setBounds(30, 96, 666, 30);
		rilevazioniLabel.setForeground(Color.GRAY);
		rilevazioniLabel.setFont(Stile.TESTO.getFont());
		rilevazioniPanel.add(rilevazioniLabel);
		
		tableModel = new DefaultTableModel();
        tableModel.addColumn("Glicemia (mg/dL)");
        tableModel.addColumn("Temperatura (°C)");
        tableModel.addColumn("Pressione (mmHg)");
        tableModel.addColumn("Frequenza Cardiaca (bpm)");
        tableModel.addColumn("Dolore");
       
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setSelectionBackground(Stile.AZZURRO_TRASP.getColore());    
        
        for(int i = 0; i < tableModel.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new TabellaRenderer());
        }
        
		JScrollPane scrollPanel = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setBounds(30, 129, 666, 323);
        scrollPanel.getViewport().setBackground(UIManager.getColor("Panel.background"));
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
	
	@SuppressWarnings("serial")
	static class TabellaRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            setHorizontalAlignment(SwingConstants.CENTER);
            setFont(Stile.TESTO.getFont());
            if (value instanceof Boolean) {
                double valore = Double.parseDouble(value.toString());
            	switch(column) {
                case 0:
                	if(valore >= 200) {
                		setForeground(Stile.ROSSO.getColore());
                	} else if( valore < 140) {
                		setForeground(Stile.VERDE.getColore());
                	} else {
                		setForeground(Stile.GIALLO.getColore());	
                	}
                	break;
                case 1:
                	if(valore >= 38.6) {
                		setForeground(Stile.ROSSO.getColore());
                	} else if(valore < 38.6 && valore >= 37.6) {
                		setForeground(Stile.GIALLO.getColore());
                	} else if(valore < 37.6 && valore >= 35.9){
                		setForeground(Stile.VERDE.getColore());	
                	} else {
                		setForeground(Stile.AZZURRO.getColore());
                	}
                	break;
            	case 2:
            		if(valore >= 140) {
            			setForeground(Stile.ROSSO.getColore());
            		} else if( valore < 120) {
            			setForeground(Stile.VERDE.getColore());
            		} else {
            			setForeground(Stile.GIALLO.getColore());	
            		}
            		break;
            	case 3:
            		if(valore >= 140) {
            			setForeground(Stile.ROSSO.getColore());
            		} else if( valore < 120) {
            			setForeground(Stile.VERDE.getColore());
            		} else {
            			setForeground(Stile.GIALLO.getColore());	
            		}
            		break;
            	case 4:
            		if(valore >= 7) {
            			setForeground(Stile.ROSSO.getColore());
            		} else if( valore < 5) {
            			setForeground(Stile.VERDE.getColore());
            		} else {
            			setForeground(Stile.GIALLO.getColore());	
            		}
            		break;            	
            	}  
            }
            return component;
        }
	}
	
}
