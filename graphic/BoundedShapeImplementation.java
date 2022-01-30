package graphic;

import java.beans.PropertyChangeEvent;
import java.util.List;

import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags(Comp301Tags.BOUNDED_SHAPE)

public abstract class BoundedShapeImplementation extends LocatableImplementation implements BoundedShape {

	//int x, y;
	int width, height;
	
	@PropertyNames({
		"Width",
		"Height"
	})
	
	@EditablePropertyNames({
		"Width",
		"Height"
	})

//	@Override
//	public int getX() {return this.x;}
//	@Override
//	public int getY() {return this.y;}
	@Override
	public void setX(int newVal) {
		int oldVal = getX(); 
		super.setX(newVal); 
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldVal,
				newVal));
	}
	@Override
	public void setY(int newVal) {
		int oldVal = getY(); 
		super.setY(newVal); 
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVal,
				newVal));
	}
	@Override
	public void move(int deltaX, int deltaY) {
		int oldXVal = getX();
		int oldYVal = getY();
		super.setX(oldXVal + deltaX);
		super.setY(oldYVal + deltaY);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldXVal,
				deltaX + oldXVal));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldYVal,
				deltaY + oldYVal));
	}
	@Override
	public int getWidth() {return this.width;}
	@Override
	public int getHeight() {return this.height;}
	@Override
	public void setWidth(int newVal) {
		int oldVal = getWidth();
		this.width = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldVal,
				newVal));
	}
	@Override
	public void setHeight(int newVal) {
		int oldVal = getHeight();
		this.height = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldVal,
				newVal));
	}

}
