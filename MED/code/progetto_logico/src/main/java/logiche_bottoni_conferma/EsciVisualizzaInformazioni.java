package logiche_bottoni_conferma;

import gui.PazientiFrame;
import gui.VisualizzaInformazioniFrame;

public class EsciVisualizzaInformazioni {
	
	private VisualizzaInformazioniFrame frame;
	private PazientiFrame frameDeiPazienti;

	public EsciVisualizzaInformazioni(VisualizzaInformazioniFrame v1, PazientiFrame v2) {
		frame = v1;
		frameDeiPazienti = v2;
		start();
	}

	protected void start() {
		frame.sfondoFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frameDeiPazienti.sfondoFrame.setEnabled(true);
                frame.sfondoFrame.dispose();
            }
        });
	}
}
