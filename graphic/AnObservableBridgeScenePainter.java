package graphic;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.OBSERVABLE_BRIDGE_SCENE_PAINTER)

public class AnObservableBridgeScenePainter extends Panel implements ObservableBridgeScenePainter{
	List<PaintListener> paintListeners = new ArrayList<PaintListener>();	
	
	public AnObservableBridgeScenePainter() {
		setFocusable(true);
		requestFocus();
	}

	@Override
	public void addPaintListener(PaintListener listener) {
		paintListeners.add(listener);
	}
	@Override
	public List getPaintListeners() {
		return this.paintListeners;
	}
	@Override
	public void paint(Graphics graph) {
		for(PaintListener listener: paintListeners) {
			listener.paint((Graphics2D) graph);
		}
	}
	
}
