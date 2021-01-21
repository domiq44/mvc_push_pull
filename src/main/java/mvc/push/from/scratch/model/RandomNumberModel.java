package mvc.push.from.scratch.model;

import java.util.Random;

import mvc.push.from.scratch.util.Subject;

/**
 * En général, dans le modèle MVC, toutes les dépendances pointent vers le
 * modèle. Le modèle ne sait rien du contrôleur ni de la vue.
 */
public class RandomNumberModel extends Subject<Integer> {

	private final Random random;

	public RandomNumberModel() {
		random = new Random();
	}

	/**
	 * Génère un nombre aléatoire entier compris entre 0 et 100, notifiant et
	 * diffusant son état à tous les observateurs.
	 */
	public void generateRandomNumber() {
		final int number = random.nextInt(101);
		notifyObservers(number);
	}
}
