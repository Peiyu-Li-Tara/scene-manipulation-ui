package graphic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class APropertyListenerSupport implements PropertyListenerSupport {
	public static final int MAX_SIZE = 50;
	
	PropertyChangeListener[] contents = new PropertyChangeListener[MAX_SIZE];
	int size = 0;

	@Override
	public int size() {
		return size;
	}
	@Override
	public PropertyChangeListener get (int index) {
		return contents[index];
	}
	@Override
	public boolean isFull() {
		return size == MAX_SIZE;
	}
	@Override
	public void add(PropertyChangeListener listener) {
		if (isFull())
			System.out.println("Adding item to a full collection");
		else {
			contents[size] = listener;
			size++;
		}
	}
	@Override
	public void notifyAllListeners(PropertyChangeEvent event) {
		for (int index = 0; index < size(); index++) {			
			get(index).propertyChange(event);
		}
	}
	@Override
	public void remove(PropertyChangeListener element) {
		contents[indexOf(element)] = contents[size - 1];
		size--;
	}
	@Override
	public void remove(int startIndex) {
		shiftUp(startIndex);
		size--;
	}
	@Override
	public void shiftUp(int startIndex) {
		for (int index = startIndex; index + 1 < size; index++)
			contents[index] = contents[index + 1];
	}
	@Override
	public int indexOf(PropertyChangeListener element) {
		int index;
		for (index = 0; index < size && !element.equals(contents[index]); index++)
			;
		return index;
	}
	@Override
	public boolean member(PropertyChangeListener element) {
		return indexOf(element) < size;
	}
	@Override
	public void clear() {
		size = 0;
	}

}
