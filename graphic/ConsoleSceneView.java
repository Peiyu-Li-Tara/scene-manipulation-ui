package graphic;

import java.beans.PropertyChangeListener;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.CONSOLE_SCENE_VIEW)

public interface ConsoleSceneView extends PropertyChangeListener {
	public BridgeScene getBridgeScene();
}
