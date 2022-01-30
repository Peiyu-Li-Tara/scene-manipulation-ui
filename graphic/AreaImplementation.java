package graphic;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN)
public class AreaImplementation implements Area{
	int x, y, width, height;
	static final int X = 100, Y = 100, WIDTH = 50, HEIGHT = 50;
	static final double HALF = 0.5;
	
	@PropertyNames({
		"X",
		"Y",
		"Width",
		"Height"
	})
	
	public AreaImplementation() {
		this.x = X;
		this.y = Y;
		this.width = WIDTH;
		this.height = HEIGHT;
	}
	
	public AreaImplementation(int initialX, int initialY, int initialWidth, int initialHeight) {
		this.x = initialX;
		this.y = initialY;
		this.width = initialWidth;
		this.height = initialHeight;
	}
	
	@Override
	public int getX() {return this.x;}
	@Override
	public int getY() {return this.y;}
	@Override
	public int getWidth() {return this.width;}
	@Override
	public int getHeight() {return this.height;}
	@Override
	public int getCenterX() {return this.x + (int) (HALF * this.width);}
	@Override
	public int getCenterY() {return this.y + (int) (HALF * this.height);}
	@Override
	public void move(int newX, int newY) {
		this.x += newX;
		this.y += newY;
	}

}
