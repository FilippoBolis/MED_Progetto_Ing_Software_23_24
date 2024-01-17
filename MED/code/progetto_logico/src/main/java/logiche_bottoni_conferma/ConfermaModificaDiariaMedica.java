package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTextField;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import gestore_db.AggiornamentiJooq;
import gestore_db.CreateDB;
import gui.InserisciDiariaFrame;
import gui.InserisciInformazioniFrame;
import gui.ModificaDiariaFrame;
import gui.AssegnaPostoFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaModificaDiariaMedica {
	
	private ModificaDiariaFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private PazientiFrame frameDeiPazienti;
		
	public ConfermaModificaDiariaMedica(ModificaDiariaFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frameDeiPazienti = v2;
		frame = v1;
		modello = m;
		start();
	}
		
	protected void start() {
		frame.confermaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					String motivo = frame.motivoTextField.getText();
					String storico = frame.storicoTextField.getText();
					String farmaci = frame.farmaciTextArea.getText();
					String codicePaziente = modello.modelloGestorePaziente.getCodice();
					if(!motivo.isBlank() && !storico.isBlank() && !farmaci.isBlank()) {
						AggiornamentiJooq.getIstanza().diariaMed(1, codicePaziente, "storico", storico);
						AggiornamentiJooq.getIstanza().diariaMed(1, codicePaziente, "motivo", motivo);
						AggiornamentiJooq.getIstanza().diariaMed(1, codicePaziente, "farmaci", farmaci);
						frameDeiPazienti.sfondoFrame.setEnabled(true);
						frame.sfondoFrame.dispose();
					}else {
						new ErroreFrame(frame.sfondoFrame, "Alcuni campi sono vuoti");
					}
			}
		});
		
		frame.sfondoFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frameDeiPazienti.sfondoFrame.setEnabled(true);
                frame.sfondoFrame.dispose();
            }
        });
	}
}
