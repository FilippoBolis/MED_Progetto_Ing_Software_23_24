package gui;

import java.awt.Color;
import java.awt.Font;

public enum Stile {
	
    BLU(new Color(26, 69, 120)),
    BLU_SCURO(new Color(17, 45, 78)),
    AZZURRO(new Color(63, 114, 175)),
    GRIGIO_CHIARO(new Color(240, 240, 240)),
	VERDE(new Color(60, 179, 113)),
    
	TITOLO(new Font("sanserif", Font.BOLD, 30)),
    SOTTOTITOLO(new Font("sanserif", Font.BOLD, 16)),
    TESTO(new Font("sanserif", Font.BOLD, 12));

    private final Color colore;
    private final Font font;

    Stile(Color colore) {
        this.colore = colore;
        this.font = null;
    }
    
    Stile(Font font) {
        this.colore = null;
    	this.font = font;
    }

    public Color getColore() {
        return colore;
    }
    
    public Font getFont() {
        return font;
    }
}
