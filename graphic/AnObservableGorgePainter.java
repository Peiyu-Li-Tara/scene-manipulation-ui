package graphic;

import java.awt.Component;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.PAINT_LISTENER)
public class AnObservableGorgePainter extends Component implements PaintListener{

	Gorge gorge;
	
	public AnObservableGorgePainter(){
		setFocusable(true);
		requestFocus();
	}
	
	public AnObservableGorgePainter(Gorge initialGorge) {
		this.gorge = initialGorge;
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
