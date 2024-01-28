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
import modelli.ModelloGestoreLogicaGenerale;

/**
 * Classe contenente il frame per visualizzare tutte le rilevazioni fatte al paziente;
 * contiene solo parte grafica, è resa utilizzabile dal progetto_logico;
 * sono stati utilizzati java swing e WindowBuilder
 */
public class VisualizzaRilevazioniFrame {
	private ImageIcon rilevazioniImage = new ImageIcon("../progetto_gui/src/main/resources/rilevazioni.png");
	public JFrame sfondoFrame;
	public DefaultTableModel tableModel;
	public JTable table;
	public boolean updating;
	public JLabel rilevazioniLabel;
	private ModelloGestoreLogicaGenerale modello;
	
	/**
	 * @param modello utilizzato aggiornate le stringhe con i valori contunuti nel progetto_model;
	 */
	@SuppressWarnings("serial")
	public VisualizzaRilevazioniFrame(ModelloGestoreLogicaGenerale m) {
		modello = m;
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		sfondoFrame = new JFrame();
		sfondoFrame.setSize(1200, 540);
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
		rilevazioniPanel.setBounds(10, 10, 1166, 482);
		rilevazioniPanel.setBackground(Color.WHITE);
		rilevazioniPanel.setLayout(null);
		sfondoPanel.add(rilevazioniPanel);
		
		JLabel titoloLabel = new JLabel("Visualizza rilevazioni");
		titoloLabel.setBounds(100, 30, 1036, 48);
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
		};
		immagineLabel.setBounds(30, 30, 48, 48);
		rilevazioniPanel.add(immagineLabel);
		
		rilevazioniLabel = new JLabel("Rilevazioni");
		rilevazioniLabel.setBounds(30, 96, 1106, 30);
		rilevazioniLabel.setForeground(Color.GRAY);
		rilevazioniLabel.setFont(Stile.TESTO.getFont());
		rilevazioniPanel.add(rilevazioniLabel);
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("<html><div align='center'>Codice<br>Personale</div></html>");
		tableModel.addColumn("<html>Pressione Max.<br><div align='center'>(mmHg)</div></html>");
		tableModel.addColumn("<html>Pressione Min.<br><div align='center'>(mmHg)</div></html>");
		tableModel.addColumn("<html>Frequenza Card.<br><div align='center'>(bpm)</div></html>");
		tableModel.addColumn("<html>Temperatura<br><div align='center'>(°C)</div></html>");
		tableModel.addColumn("<html>Glicemia<br><div align='center'>(mg/dL)</div></html>");
		tableModel.addColumn("<html>Dolore<br><div align='center'>(1/10)</div></html>");
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
        scrollPanel.setBounds(30, 129, 1106, 323);
        scrollPanel.getViewport().setBackground(UIManager.getColor("Panel.background"));
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.setViewportView(table);
        rilevazioniPanel.add(scrollPanel);
        
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

	/**
	 * @param persona per aggiornare rilevazioniLabel con nome e cognome del paziente
	 */
	public void setPersonaView(String persona) {
		rilevazioniLabel.setText("Diarie infermieristiche di " + persona);
	}
	
	/**
	 * Aggiorna i valori nella tabella prendendoli dal progetto_model
	 */
	public synchronized void updateViewTabella() {
		if (updating) {
            return;
        }
		updating = true;
		for (int i = 0; i < modello.modelloGestoreRilevazioni.getCodicePersonale().size(); i++) {
	    	   tableModel.addRow(new Object[] {
	    			   modello.modelloGestoreRilevazioni.getCodicePersonale().get(i),
	    			   modello.modelloGestoreRilevazioni.getPressioneMax().get(i),
	    			   modello.modelloGestoreRilevazioni.getPressioneMin().get(i),
	    			   modello.modelloGestoreRilevazioni.getFrequenza().get(i),
	    			   modello.modelloGestoreRilevazioni.getTemperatura().get(i),
	    			   modello.modelloGestoreRilevazioni.getGlicemia().get(i),
	    			   modello.modelloGestoreRilevazioni.getDolore().get(i),
	    			   modello.modelloGestoreRilevazioni.getTableDateArrivo().get(i),
	    			   modello.modelloGestoreRilevazioni.getTableOraArrivo().get(i),
	    	   });
		}
        for(int i = 0; i < tableModel.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new TabellaRenderer());
        }
		updating = false;
	}
	
	/**
	 * Classe per gestire la grafica delle celle della tabella in base al valore contenuto;
	 * in base al valore possono essere cambiati colori o font
	 */
	@SuppressWarnings("serial")
	static class TabellaRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(SwingConstants.CENTER);
            
            if (value instanceof Integer || value instanceof Double) {
            	component.setFont(Stile.TESTO.getFont());
            	double valore = Double.parseDouble(value.toString());
            	switch(column) {
                case 1:
                	if(valore >= 140 || valore <= 80) {
                		component.setForeground(Stile.ROSSO.getColore());
                	} else if(valore >= 90 && valore <= 120) {
                		component.setForeground(Stile.VERDE.getColore());
                	} else {
                		component.setForeground(Stile.GIALLO.getColore());	
                	}
                	break;
                case 2:
                	if(valore >= 90 || valore <= 50) {
                		component.setForeground(Stile.ROSSO.getColore());
                	} else if(valore >= 60 && valore <= 80) {
                		component.setForeground(Stile.VERDE.getColore());
                	} else {
                		component.setForeground(Stile.GIALLO.getColore());	
                	} 
                	break;
            	case 3:
            		if(valore >= 120 || valore <= 50) {
            			component.setForeground(Stile.ROSSO.getColore());
            		} else if(valore >= 60 && valore <= 100) {
            			component.setForeground(Stile.VERDE.getColore());
            		} else {
            			component.setForeground(Stile.GIALLO.getColore());	
            		}
            		break;
            	case 4:
            		if(valore >= 38 || valore <= 35) {
            			component.setForeground(Stile.ROSSO.getColore());
            		} else if(valore >= 36 && valore <= 37.3) {
            			component.setForeground(Stile.VERDE.getColore());
            		} else {
            			component.setForeground(Stile.GIALLO.getColore());	
            		}
            		break;
            	case 5:
            		if(valore >= 180 || valore <= 50) {
            			component.setForeground(Stile.ROSSO.getColore());
            		} else if(valore >= 70 && valore <= 130) {
            			component.setForeground(Stile.VERDE.getColore());
            		} else {
            			component.setForeground(Stile.GIALLO.getColore());	
            		}
            		break;
            	case 6:
            		if(valore >= 7 || valore < 0) {
            			component.setForeground(Stile.ROSSO.getColore());
            		} else if(valore >= 0 && valore <= 4) {
            			component.setForeground(Stile.VERDE.getColore());
            		} else {
            			component.setForeground(Stile.GIALLO.getColore());	
            		}
            		break; 
            	} 
            }
            return component;
        }
	}
}
