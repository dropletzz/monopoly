package monopoly;

import java.util.Vector;

public abstract class MessageSender {

	private Vector<Observer> observers;
	
	public MessageSender() {
		observers = new Vector<Observer>();
	}
	
	public void notice(String message) {
		for (Observer o:observers) {
			o.update(message);
		}
	}
	
	public void notice() {
		for (Observer o:observers) {
			o.update();
		}
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
}
