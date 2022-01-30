package graphic;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
@Tags(Comp301Tags.ROTATING_LINE)
//@Tags(Comp301Tags.LOCATABLE)
@StructurePattern(StructurePatternNames.LINE_PATTERN) 

public class RotatingLine extends BoundedShapeImplementation implements Line {
	//int x, y, width, height;
	double angle, radius;
	static final int X = 0, Y = 0;
	static final double RADIUS = 100, ANGLE = 0, DEGREE_TO_ANGLE = Math.PI / 180, UNIT_TO_ANGLE = Math.PI / 32;
	
	@PropertyNames({
//		"X",
//		"Y",
//		"Width",
//		"Height",
		"Angle",
		"Radius"
	})
	
	@EditablePropertyNames({
//		"X",
//		"Y",
//		"Width",
//		"Height",
		"Angle",
		"Radius"
	})
	
	public RotatingLine() {
		this.x = X;
		this.y = Y;
		this.radius = RADIUS;
		this.angle = ANGLE;
	}
	public RotatingLine(int initX, int initY, double initRadius, double initAngle) {
		this.x = initX;
		this.y = initY;
		this.radius = initRadius;
		this.angle = initAngle * DEGREE_TO_ANGLE;
	}
//	@Override
//	public void move(int newX, int newY) {
//		setX(this.x + newX);
//		setY(this.y + newY);
//	}
//	@Override
//	public int getX() {return x;}
//	@Override
//	public void setX(int newVal) {this.x = newVal;}
//	@Override
//	public int getY() {return y;}
//	@Override
//	public void setY(int newVal) {this.y = newVal;}
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
//		int oldXVal = getX();
//		int oldYVal = getY();
//		super.setX(oldXVal + deltaX);
//		super.setY(oldYVal + deltaY);
//		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldXVal,
//				deltaX + oldXVal));
//		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldYVal,
//				deltaY + oldYVal));
//	}
	@Override
	public int getWidth() {return (int) (this.radius * Math.cos(this.angle));}
	@Override 
	public void setWidth(int newVal) {
		int oldVal = getWidth();
		super.setWidth(newVal);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldVal,
				newVal));
	}
	@Override
	public int getHeight() {return (int) (this.radius * Math.sin(this.angle));}
	@Override 
	public void setHeight(int newVal) {
		int oldVal = getHeight();
		super.setHeight(newVal);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldVal,
				newVal));  
	}
	@Override
	public double getRadius() {return radius;}
	@Override
	public void setRadius(double newVal) {
		double oldVal = getRadius();
		this.radius = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Radius", oldVal,
				newVal));  
	}
	@Override
	public double getAngle() {return angle;}
	@Override
	public void setAngle(double newVal) throws ImpossibleAngleException {
		double oldVal = getAngle();
		this.angle = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Angle", oldVal,
				newVal));
	}
	@Override
	public void rotate(int units){
		double newAngle = angle + units * UNIT_TO_ANGLE;
		Point targetPolarPoint = new APolarPoint(radius, newAngle);
		try {
			setAngle(newAngle);
		} catch (ImpossibleAngleException e) {
			e.printStackTrace();
		}
		this.width = targetPolarPoint.getX();
		this.height = targetPolarPoint.getY();
	}
	
}