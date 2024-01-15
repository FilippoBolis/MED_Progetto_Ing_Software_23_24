package logiche_bottoni_chiudi;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gui.AggiungiInfoPazienteFrame;
import gui.PazientiFrame;
import logiche_bottoni.BloccaFramePadre;

public class ChiudiInserisciDiariaMedicaInfoPaziente {
	
	private AggiungiInfoPazienteFrame frame;
	private PazientiFrame frameDeiPazienti;
	
	public ChiudiInserisciDiariaMedicaInfoPaziente(AggiungiInfoPazienteFrame v1,  PazientiFrame v2) {
		frame = v1;
		frameDeiPazienti = v2;
		start();
	}
	
	protected void start() {
	       frame.sfondoFrame.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
					BloccaFramePadre b = new BloccaFramePadre();
					b.setAbilitaComponenti(frameDeiPazienti.sfondoFrame, true);
	            	System.exit(0);
	            }
	        });
	}
}
