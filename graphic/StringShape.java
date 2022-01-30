package graphic;

import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
//@Tags(Comp301Tags.LOCATABLE)

public interface StringShape extends Locatable {
	public String getText();
	public void setText(String newText);
//	public void move(int newX, int newY);
}
