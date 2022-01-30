package graphic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags(Comp301Tags.LOCATABLE)
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public interface Locatable extends PropertyListenerRegisterer {
	public int getX();
	public int getY();
	public void setX(int newVal);
	public void setY(int newVal);
	public void move(int deltaX, int deltaY);
	public PropertyListenerSupport getPropertySupport();
}
