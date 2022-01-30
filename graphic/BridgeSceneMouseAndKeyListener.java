
package graphic;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.BRIDGE_SCENE_CONTROLLER)

public interface BridgeSceneMouseAndKeyListener extends PropertyChangeListener, MouseListener, KeyListener, ActionListener{
	public JButton getSay();
	public JButton getApproach();
	public JButton getFailed();
	public JButton getPassed();
}
