package mvc.pull.from.scratch.app;

import mvc.pull.from.scratch.controller.RandomNumberController;
import mvc.pull.from.scratch.model.RandomNumberModel;
import mvc.pull.from.scratch.view.RandomNumberView;

public class MVCPullFromScratch {

	public static void main(String[] args) {
		// Le modèle ne sait rien du contrôleur ni de la vue.
		final RandomNumberModel rnm = new RandomNumberModel();

		// Le contrôleur connaît le modèle mais pas la vue.
		final RandomNumberController rnc = new RandomNumberController(rnm);

		// La vue connaît le modèle et le contrôleur.
		// La vue a besoin d'une référence au modèle afin d'en extraire les données.
		final RandomNumberView rnv = new RandomNumberView(rnm, rnc);

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
