package graphic;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags(Comp301Tags.ROTATING_LINE)
//@Tags(Comp301Tags.LOCATABLE)
@StructurePattern(StructurePatternNames.LINE_PATTERN) 

public interface Line extends BoundedShape{
    public double getRadius();
    public void setRadius(double newVal);
    public double getAngle();
    public void setAngle(double newVal) throws ImpossibleAngleException;
    public void rotate (int units);
//    public void move(int newX, int newY);
}