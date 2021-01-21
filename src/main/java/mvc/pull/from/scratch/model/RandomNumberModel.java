package mvc.pull.from.scratch.model;

import java.util.Random;

import mvc.pull.from.scratch.util.Subject;

/**
 * En général, dans le modèle MVC, toutes les dépendances pointent vers le
 * modèle. Le modèle ne sait rien du contrôleur ni de la vue.
 */
public class RandomNumberModel extends Subject {

	private int number;
	private final Random random;

	public RandomNumberModel() {
		random = new Random();
	}

	/**
	 * Génère un nombre aléatoire entier compris entre 0 et 100, notifiant ses
	 * observateurs.
	 */
	public void generateRandomNumber() {
		number = random.nextInt(101);
		notifyObservers();
	}

	public int getRandomNumber() {
		return number;
	}
}
