package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestore_db.RimozioneJooq;
import gui.DimettiPazienteFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import logiche_frame_pronto_soccorso.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;

public class ConfermaDimettiPaziente {

	private DimettiPazienteFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private PazientiFrame frameDeiPazienti;
	private LogicaDellaPosizionePazienteTabella tabellaInReparto;

	public ConfermaDimettiPaziente(DimettiPazienteFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frame = v1;
		frameDeiPazienti = v2;
		modello = m;
		tabellaInReparto = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti,modello,"in Reparto");
		start();
	}

	protected void start() {
		frame.confermaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (RimozioneJooq.getIstanza().degente(modello.modelloGestorePaziente.getCodice())>0) {
					modello.modelloGestorePaziente.deselezionaPaziente();
					frameDeiPazienti.updateStringaPaziente();
					tabellaInReparto.update();
					frameDeiPazienti.updateViewTabella();
				}
				else {
					new ErroreFrame(frame.sfondoFrame, "E' avvenuto un problema durante la rimozione del paziente, se il problema persiste chiamare un tecnico");
				}
				frameDeiPazienti.sfondoFrame.setEnabled(true);
				frame.sfondoFrame.dispose();
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
