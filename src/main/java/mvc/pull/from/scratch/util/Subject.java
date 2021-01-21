package mvc.pull.from.scratch.util;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private final List<Observer> observers = new ArrayList<>();

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	protected void notifyObservers() {
		observers.forEach(Observer::update);
	}

	public void removeAllObservers() {
		observers.clear();
	}
}
