package logiche_bottoni;

import java.awt.Component;
import java.awt.Container;

public class BloccaFramePadre {
	
    public void setAbilitaComponenti(Container container, boolean enable) {
        container.setEnabled(enable);
        container.setFocusable(true);

        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof Container) {
                setAbilitaComponenti((Container) component, enable);
            }
            component.setEnabled(enable);
            component.setFocusable(true);
        }
    }
}
