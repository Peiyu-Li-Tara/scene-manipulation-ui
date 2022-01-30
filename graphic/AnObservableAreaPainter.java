package graphic;

import java.awt.Component;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;

import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.PAINT_LISTENER)
public class AnObservableAreaPainter extends Component implements PaintListener {
	Area area;
	
	public AnObservableAreaPainter(){
		setFocusable(true);
		requestFocus();
	}
	
	public AnObservableAreaPainter(Area initialArea) {
		this.area = initialArea;
	}
	
	@Override
	public void paint(Graphics2D graph) {
		super.paint(graph);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.print("Paint called in Component");
		repaint();
	}
}
