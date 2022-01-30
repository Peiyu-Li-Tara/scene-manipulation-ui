package graphic;

import java.util.List;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.OBSERVABLE_BRIDGE_SCENE_PAINTER)
public interface ObservableBridgeScenePainter {
	public void addPaintListener(PaintListener listener);
	public List getPaintListeners();
}
