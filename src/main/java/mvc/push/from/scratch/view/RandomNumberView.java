package mvc.push.from.scratch.view;

import mvc.push.from.scratch.controller.RandomNumberController;
import mvc.push.from.scratch.util.Observer;

/**
 * La vue connaît le contrôleur mais pas le modèle, ou du moins le type de
 * données poussé.
 */
public class RandomNumberView implements Observer<Integer> {

	private final RandomNumberController rnc;
	private int position;
	private int number;

	public RandomNumberView(RandomNumberController rnc) {
		this.rnc = rnc;
	}

	public void generateRandomNumber() {
		rnc.generateRandomNumber();
	}

	/**
	 * Ceci est appelé lorsque le modèle appelle notifyObservers().
	 */
	@Override
	public void update(Integer t) {
		number = t;
		updatePosition();
		printRandomNumber();
	}

	private void updatePosition() {
		position++;
	}

	private void printRandomNumber() {
		System.out.printf("%-1d. %s%n", position, number);
	}
}
