package graphic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface PropertyListenerSupport {
	public void clear();
	public void shiftUp(int startIndex);
	public boolean isFull();
	public void add(PropertyChangeListener listener);
	public PropertyChangeListener get(int index); 
	public int size();
	public void notifyAllListeners(PropertyChangeEvent event);
	public void remove(PropertyChangeListener element) ;
	public void remove(int startIndex) ;
	public int indexOf(PropertyChangeListener element);
	public boolean member(PropertyChangeListener element);
}
