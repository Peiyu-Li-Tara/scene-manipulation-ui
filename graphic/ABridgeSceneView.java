package graphic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.INHERITING_BRIDGE_SCENE_PAINTER)

	public class ABridgeSceneView extends Component implements BridgeSceneView {
	BridgeScene initialBridgeScene;	
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	
	public ABridgeSceneView() throws ImpossibleAngleException {
		initialBridgeScene = BridgeSceneFactory.bridgeSceneFactoryMethod();
		propertySupport.add(BridgeSceneFactory.consoleSceneViewFactoryMethod());
		initialBridgeScene.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getArms().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getBody().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getLegs().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getLegs().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getHead().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getStringShape().addPropertyChangeListener(this);
		
		initialBridgeScene.getLancelot().getArms().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getArms().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getBody().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getLegs().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getLegs().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getHead().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getStringShape().addPropertyChangeListener(this);
		
		initialBridgeScene.getRobin().getArms().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getArms().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getBody().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getLegs().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getLegs().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getHead().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getStringShape().addPropertyChangeListener(this);
		
		initialBridgeScene.getGalahad().getArms().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getArms().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getBody().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getLegs().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getLegs().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getHead().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getStringShape().addPropertyChangeListener(this);
		
		initialBridgeScene.getGuard().getArms().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getArms().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getBody().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getLegs().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getLegs().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getHead().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getStringShape().addPropertyChangeListener(this);
		setFocusable(true);
		requestFocus();
	}
	
	public ABridgeSceneView(BridgeScene aInitialBridgeScene) throws ImpossibleAngleException {
		super();
		this.initialBridgeScene = aInitialBridgeScene;
		propertySupport.add(BridgeSceneFactory.consoleSceneViewFactoryMethod());
		initialBridgeScene.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getArms().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getBody().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getLegs().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getLegs().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getHead().addPropertyChangeListener(this);
		initialBridgeScene.getArthur().getStringShape().addPropertyChangeListener(this);
		
		initialBridgeScene.getLancelot().getArms().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getArms().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getBody().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getLegs().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getLegs().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getHead().addPropertyChangeListener(this);
		initialBridgeScene.getLancelot().getStringShape().addPropertyChangeListener(this);
		
		initialBridgeScene.getRobin().getArms().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getArms().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getBody().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getLegs().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getLegs().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getHead().addPropertyChangeListener(this);
		initialBridgeScene.getRobin().getStringShape().addPropertyChangeListener(this);
		
		initialBridgeScene.getGalahad().getArms().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getArms().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getBody().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getLegs().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getLegs().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getHead().addPropertyChangeListener(this);
		initialBridgeScene.getGalahad().getStringShape().addPropertyChangeListener(this);
		
		initialBridgeScene.getGuard().getArms().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getArms().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getBody().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getLegs().getLeftLine().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getLegs().getRightLine().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getHead().addPropertyChangeListener(this);
		initialBridgeScene.getGuard().getStringShape().addPropertyChangeListener(this);
		setFocusable(true);
	}
	@Override
	public BridgeScene getBridge() {
		return this.initialBridgeScene;
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertySupport.add(aListener); 
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(("Repaint called by:" + Thread.currentThread()));
		repaint(); 
	}
	@Override
	public void paint(Graphics graph) {
		super.paint(graph);
		System.out.println ("Paint called in Component");
		Graphics2D graph2 = (Graphics2D) graph;
		draw(graph2, initialBridgeScene);
	}
	@Override
	public void draw(Graphics graphics, BridgeScene aBridgeScene) {
		draw(graphics, aBridgeScene.getKnightArea());
		draw(graphics, aBridgeScene.getGuardArea());
		draw(graphics, aBridgeScene.getGorge());
		draw(graphics, aBridgeScene.getArthur());
		draw(graphics, aBridgeScene.getLancelot());
		draw(graphics, aBridgeScene.getRobin());
		draw(graphics, aBridgeScene.getGuard());
		draw(graphics, aBridgeScene.getGalahad());
	}
	@Override
	public void draw(Graphics graphics, AnAvatar anAvatar) {
		draw(graphics, anAvatar.getHead());
		draw(graphics, anAvatar.getBody());
		draw(graphics, anAvatar.getArms());
		draw(graphics, anAvatar.getLegs());
		draw(graphics, anAvatar.getStringShape());
	}
	@Override
	public void draw(Graphics graphics, Gorge aGorge) {
		draw(graphics, aGorge.getLeftGorge());
		draw(graphics, aGorge.getRightGorge());
		draw(graphics, aGorge.getUnderBridge());
		draw(graphics, aGorge.getUpperBridge());
	}
	@Override
	public void draw(Graphics graphics, Area anArea) {
		graphics.drawOval(anArea.getX(), anArea.getY(), anArea.getWidth(), anArea.getHeight());
	}
	@Override
	public void draw(Graphics graphics, Shape anAngle) {
		draw(graphics, anAngle.getLeftLine());
		draw(graphics, anAngle.getRightLine());
	}
	@Override
	public void draw(Graphics graphics, Line aLine) {
		graphics.drawLine(aLine.getX(), aLine.getY(), aLine.getX() + aLine.getWidth(), aLine.getY() + aLine.getHeight());		
	}
	@Override
	public void draw(Graphics graphics, StringShape aString) {
		graphics.drawString(aString.getText(), aString.getX(), aString.getY());	
	}
	@Override
	public void draw(Graphics graphics, Images anImage) {
		Image img = Toolkit.getDefaultToolkit().getImage(anImage.getImageFileName());
		graphics.drawImage(img, anImage.getX(), anImage.getY(), this);
	}
		
}
