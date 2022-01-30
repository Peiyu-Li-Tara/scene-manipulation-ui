package graphic;

import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags(Comp301Tags.AVATAR)
//@Tags(Comp301Tags.LOCATABLE)

public interface AnAvatar extends Locatable {
	public Shape getArms();
	public void setArms(Shape newArms);
	public Leg getLegs();
	public void setLegs(Leg newLegs);
	public Line getBody();
	public void setBody(Line line);
	public Images getHead();
	public void setHead(Images newHead);
	public StringShape getStringShape();
	public void setStringShape(StringShape ss);
	public void moveTo(int newX, int newY);
	public void scale(double modifyScale);
//	public void move(int newX, int newY);
}