package graphic;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class GorgeImplementation implements Gorge{
	int x, y;
	Line leftGorge, rightGorge, upperBridge, underBridge;
	static final int LEFT_GORGE_X = 400, RIGHT_GORGE_X = 500,
			LEFT_GORGE_Y = 200, RIGHT_GORGE_Y = 200,
			UPPER_BRIDGE_X = 400, UNDER_BRIDGE_X = 400,
					UPPER_BRIDGE_Y = 300, UNDER_BRIDGE_Y = 350;
	static final double GORGE_RADIUS = 300.0, GORGE_ANGLE = 90.0,
			BRIDGE_RADIUS = 100.0, BRIDGE_ANGLE = 0.0;

	@PropertyNames({
		"X",
		"Y",
		"LeftGorge",
		"RightGorge",
		"UpperBridge",
		"UnderBridge"
	})
	
	public GorgeImplementation() {
		this.leftGorge = new RotatingLine(LEFT_GORGE_X, LEFT_GORGE_Y, GORGE_RADIUS, GORGE_ANGLE);
		this.rightGorge = new RotatingLine(RIGHT_GORGE_X, RIGHT_GORGE_Y, GORGE_RADIUS, GORGE_ANGLE);
		this.upperBridge = new RotatingLine(UPPER_BRIDGE_X, UPPER_BRIDGE_Y, BRIDGE_RADIUS, BRIDGE_ANGLE);
		this.underBridge = new RotatingLine(UNDER_BRIDGE_X, UNDER_BRIDGE_Y, BRIDGE_RADIUS, BRIDGE_ANGLE);
		this.x = this.leftGorge.getX();
		this.y = this.leftGorge.getY();
	}
	
	@Override
	public int getX() {return this.x;}
	@Override
	public int getY() {return this.y;}
	@Override
	public Line getLeftGorge() {return this.leftGorge;}
	@Override
	public Line getRightGorge() {return this.rightGorge;}
	@Override
	public Line getUpperBridge() {return this.upperBridge;}
	@Override
	public Line getUnderBridge() {return this.underBridge;}
	@Override
	public void move(int newX, int newY) {
		this.leftGorge.move(newX, newY);
		this.rightGorge.move(newX, newY);
		this.upperBridge.move(newX, newY);
		this.underBridge.move(newX, newY);
		this.x += newX;
		this.y += newY;
	}
}
