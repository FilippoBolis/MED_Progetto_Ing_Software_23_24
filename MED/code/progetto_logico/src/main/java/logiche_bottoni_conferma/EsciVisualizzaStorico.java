package logiche_bottoni_conferma;

import gui.PazientiFrame;
import gui.VisualizzaStoricoFrame;

public class EsciVisualizzaStorico {
	
	private VisualizzaStoricoFrame frame;
	private PazientiFrame frameDeiPazienti;

	public EsciVisualizzaStorico(VisualizzaStoricoFrame v1, PazientiFrame v2) {
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
