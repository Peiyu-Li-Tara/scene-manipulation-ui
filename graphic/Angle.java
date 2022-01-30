package graphic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags(Comp301Tags.ANGLE)
//@Tags(Comp301Tags.LOCATABLE)
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class Angle extends LocatableImplementation implements Shape{
	Line rightLine;
	Line leftLine;
	double angle, radius;
//	int x, y;
	static final int X = 50, Y = 50;
	static final double ANGLE = 80.0, RADIUS = 50.0, ANGLE_DIFFERENCE = 20.0;
	
	@PropertyNames({
//		"X",
//		"Y",
		"LeftLine",
		"RightLine",
		"Angle",
		"Radius"
	})
	
	@EditablePropertyNames({
//		"X",
//		"Y",
		"LeftLine",
		"RightLine",
		"Angle"
	})
	
	public Angle() {
		this.x = X;
		this.y = Y;
		this.angle = ANGLE;
		this.radius = RADIUS;
		this.rightLine = new RotatingLine(x, y, radius, angle);
		this.leftLine = new RotatingLine(x, y, radius, angle + ANGLE_DIFFERENCE);
	}
	
	public Angle(int initX, int initY, double initAngle, double initRadius) {
		this.x = initX;
		this.y = initY;
		this.angle = initAngle;
		this.radius = initRadius;
		this.rightLine = new RotatingLine(x, y, radius, angle);
		this.leftLine = new RotatingLine(x, y, radius, angle + ANGLE_DIFFERENCE);
	}
//	@Override
//	public int getX() {return this.x;}
//	@Override
//	public int getY() {return this.y;}
//	@Override
//	public void setX(int newVal) {this.x = newVal;}
//	@Override
//	public void setY(int newVal) {this.y = newVal;}
	@Override
	public void setX(int newVal) {
		int oldVal = getX(); 
		super.setX(newVal); 
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldVal, newVal));
	}
	@Override
	public void setY(int newVal) {
		int oldVal = getY(); 
		super.setY(newVal); 
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVal, newVal));
	}
	@Override
	public void move(int newX, int newY) {
		this.rightLine.move(newX, newY);
		this.leftLine.move(newX, newY);
		this.x = this.rightLine.getX();
		this.y = this.rightLine.getY();
	}
	@Override
	public Line getLeftLine() {return leftLine;}
	@Override
	public void setLeftLine(Line newLine) {
		Line oldLeftLine = getLeftLine();
		this.leftLine = newLine;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "LeftLine", oldLeftLine, newLine));
	}
	@Override
	public Line getRightLine() {return rightLine;}
	@Override
	public void setRightLine(Line newLine) {
		Line oldRightLine = getRightLine();
		this.rightLine = newLine;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "RightLine", oldRightLine, newLine));
	}
	@Override
	public double getAngle() {return angle;}
	@Override
	public void setAngle(double newVal) {
		double oldAngle = getAngle();
		this.angle = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Angle", oldAngle, newVal));
	}
	
}