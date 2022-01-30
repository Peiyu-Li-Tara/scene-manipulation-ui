package graphic;

import java.beans.PropertyChangeEvent;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.RESTRICTED_LINE)
public class ARestrictedLine extends RotatingLine implements RestrictedLine{
	double minimumAngle, maximumAngle;
	
	public ARestrictedLine(double minimumNumber, double maximumNumber){
		super();
		minimumAngle = minimumNumber;
		maximumAngle = maximumNumber;
	}
	public ARestrictedLine(int initX, int initY, double initRadius, double initAngle, double minimumNumber, double maximumNumber) {
		super(initX, initY, initRadius, initAngle);
		minimumAngle = minimumNumber;
		maximumAngle = maximumNumber;
	}
	
	@Override
	public void setAngle(double newVal) throws ImpossibleAngleException{
		if(newVal < minimumAngle){
			throw new ImpossibleAngleException("new value "+newVal+" is lower than the minimum accepted value:" + minimumAngle);
		} else if (newVal > maximumAngle) {
			throw new ImpossibleAngleException("new value "+newVal+" is larger than the maximum accepted value:" + maximumAngle);
		} else {
			double oldVal = getAngle();
			this.angle = newVal;
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Angle", oldVal, newVal));
		}
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
