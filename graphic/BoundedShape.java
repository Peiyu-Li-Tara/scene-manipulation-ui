package graphic;

import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.BOUNDED_SHAPE)

public interface BoundedShape extends Locatable{
	public int getWidth();
	public int getHeight();
	public void setWidth(int newVal);
	public void setHeight(int newVal);
}
