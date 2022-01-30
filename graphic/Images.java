package graphic;

import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@Tags(Comp301Tags.BOUNDED_SHAPE)

public interface Images extends BoundedShape{
	public String getImageFileName();
	public void setImageFileName(String newVal);
	public String getText();
	public void setText(String newVal);
//	public void move(int newX, int newY);
}