package graphic;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags(Comp301Tags.LOCATABLE)

public abstract class LocatableImplementation implements Locatable {
//	List<PropertyChangeListener> propertySupport = new ArrayList<PropertyChangeListener>();
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	int x, y;
	
	@PropertyNames({
		"X",
		"Y"
	})
	
	@EditablePropertyNames({
		"X",
		"Y"
	})
	
	public LocatableImplementation() {
//		propertySupport.add(BridgeSceneFactory.consoleSceneViewFactoryMethod());
//		propertySupport.add(BridgeSceneFactory.inheritingBridgeScenePainterFactoryMethod());
	}
	
	@Override
	public int getX() {return this.x;}
	@Override
	public int getY() {return this.y;}
	@Override
	public void setX(int newVal) {
		int oldVal = getX();
		this.x = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldVal, newVal));
	}
	@Override
	public void setY(int newVal) {
		int oldVal = getY();
		this.y = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVal, newVal));
	}
	@Override
	public void move(int deltaX, int deltaY) {
		setX(this.x + deltaX);
		setY(this.y + deltaY);
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertySupport.add(aListener); 
	}
	@Override
	public PropertyListenerSupport getPropertySupport() {
		return this.propertySupport;
	}
//	@Override
//	public int size() {
//		return propertySupport.size();
//	}
//	@Override
//	public PropertyChangeListener get(int index) {
//		return propertySupport.get(index);
//	}
//	@Override
//	public List getPropertyListenerSupport() {
//		return this.propertySupport;
//	}
//	@Override
//	public void notifyAllListeners(PropertyChangeEvent event) {
//		for (int index = 0; index < size(); index++) {			
//			get(index).propertyChange(event);
//		}
//	}
//	
}
