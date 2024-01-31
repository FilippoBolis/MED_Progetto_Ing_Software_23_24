package logiche_bottoni_conferma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestore_db.RimozioneJooq;
import gui.DimettiPazienteFrame;
import gui.ErroreFrame;
import gui.PazientiFrame;
import logiche_frame_sezioni_ospedaliere.LogicaDellaPosizionePazienteTabella;
import modelli.ModelloGestoreLogicaGenerale;


public class ConfermaDimettiPaziente {

	private DimettiPazienteFrame frame;
	private ModelloGestoreLogicaGenerale modello;
	private PazientiFrame frameDeiPazienti;
	private LogicaDellaPosizionePazienteTabella tabellaInReparto;

	/** Classe che permette la rimozione del degente selezionato
	 * @param v1 riferimento al frame per la rimozione del degente
	 * @param v2 riferimento al frame principale
	 * @param m riferimento al modello
	 */
	public ConfermaDimettiPaziente(DimettiPazienteFrame v1, PazientiFrame v2, ModelloGestoreLogicaGenerale m) {
		frame = v1;
		frameDeiPazienti = v2;
		modello = m;
		tabellaInReparto = new LogicaDellaPosizionePazienteTabella(frameDeiPazienti,modello,"in Reparto");
		start();
	}

	/**Una volta premuto il pulsante "conferma" nel frame di rimozione, rimuove il paziente selezionato
	 * dalla tabella degente del database
	 * Inoltre permete la chiusura della finestra, premendo la X oppure confermando l'inserimento.
	 * Alla chiusura della finestra il frame principale viene riabilitato e aggiornato.
	 */
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
