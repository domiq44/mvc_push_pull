package mvc.push.controller;

import mvc.push.model.RandomNumberModel;

/**
 * Le contrôleur connaît le modèle mais pas la vue.
 */
public class RandomNumberController {

	private final RandomNumberModel rnm;

	public RandomNumberController(RandomNumberModel rnm) {
		this.rnm = rnm;
	}

	/**
	 * Encapsule l'appel. (Principe "Dites", ne "demandez pas").
	 */
	public void generateRandomNumber() {
		rnm.generateRandomNumber();
	}
}
