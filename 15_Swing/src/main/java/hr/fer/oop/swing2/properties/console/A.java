package hr.fer.oop.swing2.properties.console;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class A {
	private int value;
	private int changeCounter = 0;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		if (this.value != value) {
			int old = this.value;
			this.value = value;
			pcs.firePropertyChange("Value", old, this.value);			
		}
		++changeCounter;
		pcs.firePropertyChange("ChangeCounter", changeCounter - 1, changeCounter);
	}

	public int getChangeCounter() {
		return changeCounter;
	}	
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
}