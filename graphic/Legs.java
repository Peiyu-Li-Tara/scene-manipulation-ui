package graphic;

import java.beans.PropertyChangeEvent;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags(Comp301Tags.LEGS)
public class Legs extends Angle implements Leg{
	static final double MINIMUM_ANGLE_FOR_LEFT = Math.PI / 2, MAXIMUM_ANGLE_FOR_LEFT = Math.PI,
			MINIMUM_ANGLE_FOR_RIGHT = 0, MAXIMUM_ANGLE_FOR_RIGHT = Math.PI / 2;
	
	public Legs(){
		super();
		rightLine = new ARestrictedLine(x, y, radius, angle, MINIMUM_ANGLE_FOR_RIGHT, MAXIMUM_ANGLE_FOR_RIGHT);
		leftLine = new ARestrictedLine(x, y, radius, angle + ANGLE_DIFFERENCE, MINIMUM_ANGLE_FOR_LEFT, MAXIMUM_ANGLE_FOR_LEFT);
	}
	public Legs(int initX, int initY, double initAngle, double initRadius){
		super(initX, initY, initAngle, initRadius);
		rightLine = new ARestrictedLine(x, y, radius, angle, MINIMUM_ANGLE_FOR_RIGHT, MAXIMUM_ANGLE_FOR_RIGHT);
		leftLine = new ARestrictedLine(x, y, radius, angle + ANGLE_DIFFERENCE, MINIMUM_ANGLE_FOR_LEFT, MAXIMUM_ANGLE_FOR_LEFT);
	}
	
}
