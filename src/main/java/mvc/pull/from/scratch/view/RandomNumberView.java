package mvc.pull.from.scratch.view;

import mvc.pull.from.scratch.controller.RandomNumberController;
import mvc.pull.from.scratch.model.RandomNumberModel;
import mvc.pull.from.scratch.util.Observer;

/**
 * Dans le modèle "Observer Pull", la vue connaît le contrôleur et le modèle.
 */
public class RandomNumberView implements Observer {

	private final RandomNumberController rnc;
	private final RandomNumberModel rnm;
	private int position;

	public RandomNumberView(RandomNumberModel rnm, RandomNumberController rnc) {
		this.rnm = rnm;
		this.rnc = rnc;
		this.rnm.registerObserver(this);
	}

	/**
	 * Ceci est appelé lorsque le modèle appelle notifyObservers().
	 */
	@Override
	public void update() {
		getRandomNumber();
		updatePosition();
		printRandomNumber();
	}

	private int getRandomNumber() {
		return rnm.getRandomNumber();
	}

	private void updatePosition() {
		position++;
	}

	private void printRandomNumber() {
		System.out.printf("%-1d. %s%n", position, getRandomNumber());
	}

	/**
	 * Les commandes sont envoyées via la référence du contrôleur.
	 */
	public void generateRandomNumber() {
		rnc.generateRandomNumber();
	}
}
