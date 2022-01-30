package graphic;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN)
public interface Area {
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public int getCenterX();
	public int getCenterY();
	public void move(int newX, int newY);
}
