package graphic;
import tags301.Comp301Tags;
import util.annotations.Explanation;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;
@Tags(Comp301Tags.ROTATING_LINE)
@StructurePattern(StructurePatternNames.POINT_PATTERN)
@Explanation("Location in Java coordinate System.")
public interface Point extends PropertyListenerRegisterer{
	public int getX(); 
	public int getY(); 	
	public double getAngle(); 
	public double getRadius(); 
}