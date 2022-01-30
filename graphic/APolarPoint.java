package graphic;

import java.beans.PropertyChangeListener;

import util.annotations.PropertyNames;

public class APolarPoint implements Point {
	double radius, angle;
	int x, y;
	
	@PropertyNames({
		"X",
		"Y",
		"Radius",
		"Angle"
	})
	
	public APolarPoint(double theRadius, double theAngle) {
		radius = theRadius;
		angle = theAngle;
	}
	public APolarPoint(int theX, int theY) {
		radius = Math.sqrt(theX * theX + theY * theY);
		angle = Math.atan((double) theY/theX);
	}
	
	@Override
	public int getX() { return (int) (radius * Math.cos(angle)); } //x in this case represents width
	@Override
	public int getY() { return (int) (radius * Math.sin(angle)); } //y in this case represents height
	@Override
	public double getAngle() { return angle; } 
	@Override
	public double getRadius() { return radius;}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}	
}
