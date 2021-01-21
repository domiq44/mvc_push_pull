package mvc.push.from.scratch.app;

import mvc.push.from.scratch.controller.RandomNumberController;
import mvc.push.from.scratch.model.RandomNumberModel;
import mvc.push.from.scratch.view.RandomNumberView;

public class MVCPushFromScratch {

	public static void main(String[] args) {
		// Le modèle ne sait rien du contrôleur ni de la vue.
		final RandomNumberModel rnm = new RandomNumberModel();

		// Le contrôleur connaît le modèle mais pas la vue.
		final RandomNumberController rnc = new RandomNumberController(rnm);

		// La vue ne connaît que le contrôleur.
		// Le modèle pousse ses données via l'interface Observer.
		final RandomNumberView rnv = new RandomNumberView(rnc);

		// Le modèle enregistre la vue.
		rnm.registerObserver(rnv);

		int i = 0;
		while (i < 5) {
			/*
			 * Imaginez que cela puisse être un ActionEvent déclenché par un Button.
			 * c'est-à-dire "generateRandomNumberButton"
			 */
			rnv.generateRandomNumber();
			i++;
		}

		/**
		 * Sortie
		 *
		 * <pre>
		 * 1. 66
		 * 2. 17
		 * 3. 75
		 * 4. 94
		 * 5. 39
		 * </pre>
		 *
		 * La sortie variera en raison de son caractère aléatoire.
		 */
	}
}
