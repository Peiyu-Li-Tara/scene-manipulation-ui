package graphic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;

import tags301.Comp301Tags;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags(Comp301Tags.INHERITING_BRIDGE_SCENE_PAINTER)
public interface BridgeSceneView extends PropertyChangeListener {
	public BridgeScene getBridge();
	public void paint(Graphics graphics);
	public void draw(Graphics graphics, BridgeScene aBridgeScene);
	public void draw(Graphics graphics, AnAvatar anAvatar);
	public void draw(Graphics graphics, Gorge aGorge);
	public void draw(Graphics graphics, Area anArea);
	public void draw(Graphics graphics, Shape anAngle);
	public void draw(Graphics graphics, Line aLine);
	public void draw(Graphics graphics, StringShape aString);
	public void draw(Graphics graphics, Images anImage);
}
