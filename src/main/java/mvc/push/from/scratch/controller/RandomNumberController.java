package mvc.push.from.scratch.controller;

import mvc.push.from.scratch.model.RandomNumberModel;

/**
 * Le contrôleur connaît le modèle mais pas la vue. Son objectif principal est
 * d'envoyer des commandes de la vue au modèle. (Les "commandes" changent l'état
 * du système et ne renvoient rien).
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
