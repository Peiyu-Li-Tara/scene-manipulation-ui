package graphic;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import bus.uigen.ObjectEditor;
import tags301.Comp301Tags;
@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
//@Tags(Comp301Tags.LOCATABLE)

public class CharacterHead extends BoundedShapeImplementation implements Images {
	static final int 
	INITIAL_X = 40, 
	INITIAL_Y = 80, 
	INITIAL_WIDTH = 10, 
	INITIAL_HEIGHT =5;
//	int x = INITIAL_X, y = INITIAL_Y;     
//	int width = INITIAL_WIDTH, height = INITIAL_HEIGHT; 
	String imageFileName, stringShape = "Hello World";	
	
	@PropertyNames({
//		"X",
//		"Y",
//		"Width",
//		"Height",
		"ImageFileName",
		"StringShape"
	})
	
	@EditablePropertyNames({
//		"X",
//		"Y",
//		"Width",
//		"Height",
		"ImageFileName",
		"StringShape"
	})
	
	public CharacterHead(String fileName) {
		Icon icon = new ImageIcon(fileName);
		setText(fileName);
		setHeight(icon.getIconHeight());
		setWidth(icon.getIconWidth());
	}
	
	public CharacterHead(String fileName, String text) {
		Icon icon = new ImageIcon(fileName);
		setText(fileName);
		setHeight(icon.getIconHeight());
		setWidth(icon.getIconWidth());
		this.stringShape = text;
	}
	
//	@Override
//	public void move(int deltaX, int deltaY) {
//		setX(this.x + deltaX);
//		setY(this.y + deltaY);
//	}
//	@Override
//	public int getX() {return x;}
//	@Override
//	public void setX(int newX) {x = newX;}
//	@Override
// 	public int getY() { return y; }
//	@Override
// 	public void setY(int newY) {y = newY;}
//	@Override
// 	public int getWidth() {return width;}
	@Override
	public void setWidth(int newVal) {
		int oldVal = getWidth(); 
		super.setWidth(newVal); 
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldVal,
				newVal));
	}
//	@Override
//	public int getHeight() {return height;}
	@Override
	public void setHeight(int newVal) {
		int oldVal = getHeight(); 
		super.setHeight(newVal); 
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldVal,
				newVal));
	}
	@Override
	public String getImageFileName() {return imageFileName;}  
	@Override
	public void setImageFileName(String newVal) {imageFileName = newVal;} 
	@Override
	public String getText() {return stringShape;}
	@Override
	public void setText(String newVal) {imageFileName = newVal;}  
}