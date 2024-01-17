package logiche_bottoni_conferma;

import gui.PazientiFrame;
import gui.VisualizzaFarmaciFrame;

public class EsciVisualizzaFarmaci {
	
	private VisualizzaFarmaciFrame frame;
	private PazientiFrame frameDeiPazienti;

	public EsciVisualizzaFarmaci(VisualizzaFarmaciFrame v1, PazientiFrame v2) {
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
