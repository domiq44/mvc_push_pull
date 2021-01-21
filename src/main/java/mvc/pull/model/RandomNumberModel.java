package mvc.pull.model;

import java.util.Observable;
import java.util.Random;

/**
 * En général, dans le modèle MVC, toutes les dépendances pointent vers le
 * modèle. Le modèle ne sait rien du contrôleur ni de la vue.
 */
public class RandomNumberModel extends Observable {

	private final Random random;
	private int number;

	public RandomNumberModel() {
		random = new Random();
	}

	/**
	 * Génère un nombre aléatoire entier compris entre 0 et 100, notifiant ses
	 * observateurs et passant son état.
	 */
	public void generateRandomNumber() {
		number = random.nextInt(101);
		setChanged();
		notifyObservers(); // Pousse "this" par défaut.
	}

	public int getRandomNumber() {
		return number;
	}
}
