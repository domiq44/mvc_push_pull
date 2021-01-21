package mvc.pull.app;

import mvc.pull.controller.RandomNumberController;
import mvc.pull.model.RandomNumberModel;
import mvc.pull.view.RandomNumberView;

public class MVCPull {

	public static void main(String[] args) {
		// Le modèle ne sait rien du contrôleur ni de la vue.
		final RandomNumberModel rnm = new RandomNumberModel();

		// Le contrôleur connaît le modèle mais pas la vue.
		final RandomNumberController rnc = new RandomNumberController(rnm);

		// La vue connaît le contrôleur et a une référence au modèle dans la méthode
		// update().
		final RandomNumberView rnv = new RandomNumberView(rnc);

		// L'observable (modèle) enregistre l'observateur (vue).
		rnm.addObserver(rnv);

		int i = 0;
		while (i < 5) {
			/*
			 * Imaginez que cela puisse être un ActionEvent déclenché par un Button.
			 * c'est-à-dire "generateRandomNumberButton".
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
