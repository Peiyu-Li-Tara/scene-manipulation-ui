package graphic;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public interface Gorge {
	public int getX();
	public int getY();
	public Line getLeftGorge();
	public Line getRightGorge();
	public Line getUpperBridge();
	public Line getUnderBridge();
	public void move(int newX, int newY);
}
