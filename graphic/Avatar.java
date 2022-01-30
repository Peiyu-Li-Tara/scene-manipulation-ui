package graphic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags(Comp301Tags.AVATAR)
//@Tags(Comp301Tags.LOCATABLE)

public class Avatar extends LocatableImplementation implements AnAvatar {
	Shape arms;
	Leg legs;
	Line body;
	Images head;
	StringShape stringShape;
//	int x, y;
	static final int BODY_HEIGHT = 50, MOVE_INDEX_1 = 2, MOVE_INDEX_2 = 4;
	static final double ARM_ANGLE = 80, BODY_ANGLE = 90, ARM_RADIUS = 50;
	double scaleSize;
	
	@PropertyNames({
//		"X",
//		"Y",
		"Arms",
		"Legs",
		"Body",
		"Head",
		"StringShape"
	})
	
	@EditablePropertyNames({
//		"X",
//		"Y",
		"Arms",
		"Legs",
		"Body",
		"Head",
		"StringShape"
	})
	
	public Avatar(Images defaltHead) {
		this.head = defaltHead;
		this.body = new RotatingLine(defaltHead.getX() + defaltHead.getWidth() / MOVE_INDEX_1, 
				defaltHead.getY() + defaltHead.getHeight(), BODY_HEIGHT, BODY_ANGLE);
		this.arms = new Angle(body.getX(), body.getY(), ARM_ANGLE, ARM_RADIUS);
		this.legs = BridgeSceneFactory.legsFactoryMethod(body.getX(), body.getY() + BODY_HEIGHT, ARM_ANGLE, ARM_RADIUS);
		this.stringShape = new StringShapeImplementation(defaltHead.getText());
		this.x = legs.getLeftLine().getX();
		this.y = legs.getLeftLine().getY() + legs.getLeftLine().getHeight();
	}
	
	public Avatar(Images defaltHead, int initialX, int initialY) {
		this.head = defaltHead;
		this.head.setX(initialX);
		this.head.setY(initialY);
		this.body = new RotatingLine(this.head.getX() + this.head.getWidth() / MOVE_INDEX_1, 
				this.head.getY() + this.head.getHeight(), BODY_HEIGHT, BODY_ANGLE);
		this.arms = new Angle(body.getX(), body.getY(), ARM_ANGLE, ARM_RADIUS);
		this.legs = BridgeSceneFactory.legsFactoryMethod(body.getX(), body.getY() + BODY_HEIGHT, ARM_ANGLE, ARM_RADIUS);
		this.stringShape = new StringShapeImplementation(this.head.getText());
		this.x = legs.getLeftLine().getX();
		this.y = legs.getLeftLine().getY() + legs.getLeftLine().getHeight();
	}
	
	@Override
	public void move(int deltaX, int deltaY) {
		head.move(deltaX, deltaY);
		stringShape.move(deltaX, deltaY);
		body.move(deltaX, deltaY);
		arms.move(deltaX, deltaY);
		legs.move(deltaX, deltaY);
		this.x = legs.getLeftLine().getX();
		this.y = legs.getLeftLine().getY() + legs.getLeftLine().getHeight();
	}
	@Override
	public void moveTo(int finalX, int finalY) {
		int currentX = this.x;
		int currentY = this.y;
		int deltaX = finalX - currentX;
		int deltaY = finalY - currentY;
		move(deltaX, deltaY);
	}
	@Override
	//Extra Credit
	public void scale(double modifyScale) {
		head.setWidth((int) (head.getWidth() * modifyScale));
		head.setHeight((int) (head.getHeight() * modifyScale));
		head.move(-head.getWidth() / MOVE_INDEX_2, -head.getHeight() / MOVE_INDEX_1);
		
		double oldBodyLength = body.getRadius();
		body.setRadius(oldBodyLength * modifyScale);
		
		arms.getRightLine().setRadius(arms.getRightLine().getRadius() * modifyScale);
		arms.getLeftLine().setRadius(arms.getLeftLine().getRadius() * modifyScale);
		
		legs.getRightLine().setRadius(legs.getRightLine().getRadius() * modifyScale);
		legs.getLeftLine().setRadius(legs.getLeftLine().getRadius() * modifyScale);
		legs.move(0, (int) (body.getHeight() - oldBodyLength));
	}	
//	@Override
//	public int getX() {return this.x;}
//	@Override
//	public void setX(int newVal) {this.x = newVal;}
//	@Override
//	public int getY() {return this.y;}
//	@Override
//	public void setY(int newVal) {this.y = newVal;}
	@Override
	public void setX(int newVal) {
		int oldVal = getX(); 
		super.setX(newVal); 
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldVal,
				newVal));
	}
	@Override
	public void setY(int newVal) {
		int oldVal = getY(); 
		super.setY(newVal); 
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVal,
				newVal));
	}
	@Override
	public Shape getArms() {return this.arms;}
	@Override
	public void setArms(Shape newArms) {
		Shape oldArms = getArms();
		this.arms = newArms;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Arms", oldArms,
				newArms));
	}
	@Override
	public Leg getLegs() {return this.legs;}
	@Override
	public void setLegs(Leg newLegs) {
		Leg oldLegs = getLegs();
		this.legs = newLegs;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Legs", oldLegs,
				newLegs));
	}
	@Override
	public Line getBody() {return this.body;}
	@Override
	public void setBody(Line newBody) {
		Line oldBody = getBody();
		this.body = newBody;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Body", oldBody,
				newBody));
	}
	@Override
	public Images getHead() {return this.head;}
	@Override
	public void setHead(Images newHead) {
		Images oldHead = getHead();
		this.head = newHead;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Head", oldHead,
				newHead));
	}
	@Override
	public StringShape getStringShape() {return this.stringShape;}
	@Override
	public void setStringShape(StringShape newSS) {
		StringShape oldSS = getStringShape();
		this.stringShape = newSS;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "StringShape", oldSS,
				newSS));
	}
	
}