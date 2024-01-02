package LogicheBottoni;

import gui.*;

public class loginLogic {
	private void registerLogin() {
		// si registra al bottone login
		gui.btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.clear();
				view.updateView();
			}
		});
		view.btnMultiply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double d = Double.parseDouble(view.input.getText());
					model.multiply(d);
					view.updateView();
				} catch (Exception ex) {
				}
			}
		});
	}
}
