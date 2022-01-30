package graphic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
//@Tags(Comp301Tags.LOCATABLE)

public class StringShapeImplementation extends LocatableImplementation implements StringShape {
	String text;
//	int x, y;
	
	@PropertyNames({
		"Text"
//		"X",
//		"Y"
	})
	
	@EditablePropertyNames({
		"Text"
//		"X",
//		"Y"
	})
	
	public 	StringShapeImplementation() {
		this.text = "default";
	}
	
	public StringShapeImplementation(String iniText) {
		this.text = iniText;
	}
	
	public StringShapeImplementation(int iniX, int iniY, String iniText) {
		this.x = iniX;
		this.y = iniY;
		this.text = iniText;
	}
	
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
//	@Override
//	public void move(int deltaX, int deltaY) {
//		setX(this.x + deltaX);
//		setY(this.y + deltaY);
//	}
	@Override
	public String getText() {return text;}
	@Override
	public void setText(String newText) {
		String oldText = getText();
		this.text = newText;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Text", oldText,
				newText));
	}
	
}