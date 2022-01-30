package graphic;

import java.awt.Component;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.PAINT_LISTENER)
public class AnObservableAvatarPainter extends Component implements PaintListener{
	AnAvatar avatar;
	
	public AnObservableAvatarPainter(){
		setFocusable(true);
		requestFocus();
	}
	
	public AnObservableAvatarPainter(AnAvatar initialAvatar) {
		this.avatar = initialAvatar;
	}
	
	@Override
	public void paint(Graphics2D graphics) {
		super.paint(graphics);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.print("Paint called in Component");
		repaint();
	}
}
