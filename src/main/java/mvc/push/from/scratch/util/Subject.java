package mvc.push.from.scratch.util;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject<T> {

	private final List<Observer<T>> observers = new ArrayList<>();

	public void registerObserver(Observer<T> o) {
		observers.add(o);
	}

	public void removeObserver(Observer<T> o) {
		observers.remove(o);
	}

	protected void notifyObservers(T t) {
		observers.forEach(o -> o.update(t));
	}

	public void removeAllObservers() {
		observers.clear();
	}
}
