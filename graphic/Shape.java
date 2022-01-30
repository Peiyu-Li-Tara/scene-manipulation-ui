package graphic;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

import java.beans.PropertyChangeListener;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
@Tags(Comp301Tags.ANGLE)
//@Tags(Comp301Tags.LOCATABLE)
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public interface Shape extends Locatable{
	public Line getLeftLine();
	public void setLeftLine(Line newLine);
	public Line getRightLine();
	public void setRightLine(Line newLine);
	public double getAngle();
	public void setAngle(double newVal);
	public void move(int newX, int newY);
}