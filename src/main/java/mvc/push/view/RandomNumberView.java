package mvc.push.view;

import java.util.Observable;
import java.util.Observer;

import mvc.push.controller.RandomNumberController;

/**
 * Dans le modèle "Observer Push", la vue connaît le contrôleur mais pas le
 * modèle, juste "l'état du modèle" ou du moins son type.
 */
public class RandomNumberView implements Observer {

	private final RandomNumberController rnc;
	private int position;
	private int randomNumber;

	public RandomNumberView(RandomNumberController rnc) {
		this.rnc = rnc;
		position = 1;
	}

	public void generateRandomNumber() {
		rnc.generateRandomNumber();
	}

	/**
	 * @param o   MVCPullFromScratch.RandomNumberModel Object
	 * @param arg Nombre aléatoire entier (Le modèle «pousse» son état)
	 */
	@Override
	public void update(Observable o, Object arg) {
		randomNumber = (int) arg; // <- arg is casted
		updatePosition();
		printRandomNumber();
	}

	private void updatePosition() {
		position++;
	}

	/**
	 * Affiche le numéro dans le flux de sortie standard.
	 */
	private void printRandomNumber() {
		System.out.printf("%-1d. %s\n", position, randomNumber);
	}
}
