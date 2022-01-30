
package graphic;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.annotations.Visible;
@Tags(Comp301Tags.BRIDGE_SCENE_CONTROLLER)
public class ABridgeSceneMouseAndKeyController implements BridgeSceneMouseAndKeyListener {
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	Component bridgeComponent;
	BridgeScene bridgeScene;
	AnAvatar movingObject;
	JButton say, pass, fail, approach;
	int finalX, finalY;
	static final int ARTHUR_X = 100, ARTHUR_Y = 200, 
			LANCELOT_X = 200, LANCELOT_Y = 200,
			ROBIN_X = 100, ROBIN_Y = 400,
			GALAHAD_X = 200, GALAHAD_Y = 400;

	@Visible(false)
	public ABridgeSceneMouseAndKeyController(Component aBridgeComponent) throws ImpossibleAngleException {
		this.bridgeComponent = aBridgeComponent;
		this.bridgeScene = BridgeSceneFactory.bridgeSceneFactoryMethod();
		this.bridgeComponent.addMouseListener(this);
		this.bridgeComponent.addKeyListener(this);
		
		this.say = new JButton("Say");
		say.setFocusable(false);
		say.addActionListener(this);
		this.approach = new JButton("Approach");
		approach.setFocusable(false);
		approach.addActionListener(this);
		this.fail = new JButton("Fail");
		fail.setFocusable(false);
		fail.addActionListener(this);
		this.pass = new JButton("Pass");
		pass.setFocusable(false);
		pass.addActionListener(this);
		
		bridgeScene.addPropertyChangeListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		System.out.println("Mouse clicked.");
			
		if(this.movingObject != null) {
			finalX = event.getX();
			finalY = event.getY();
			System.out.print("Find an object to move.");
			movingObject.moveTo(finalX, finalY);
		}
		else
			System.out.print("No target to move!");
	}
	@Override
	public void mousePressed(MouseEvent event) {}
	@Override
	public void mouseReleased(MouseEvent event) {}
	@Override
	public void mouseEntered(MouseEvent event) {}
	@Override
	public void mouseExited(MouseEvent event) {}
	@Override
	public void keyTyped(KeyEvent event) {
		char typedChar = event.getKeyChar();
		System.out.println ("Key typed:" + typedChar);
		switch (typedChar) {
    	case 'a' :
    		movingObject = bridgeScene.getArthur();
    		movingObject.moveTo(finalX, finalY);
    		break;
    	case 'g':
    		movingObject = bridgeScene.getGalahad();
    		movingObject.moveTo(finalX, finalY);
    		break;
    	case 'l':
    		movingObject = bridgeScene.getLancelot();
    		movingObject.moveTo(finalX, finalY);
    		break;
    	case 'r':
    		movingObject = bridgeScene.getRobin();
    		movingObject.moveTo(finalX, finalY);
    		break;
    	case 'o':
    		bridgeScene.getArthur().moveTo(ARTHUR_X, ARTHUR_Y);
    		bridgeScene.getLancelot().moveTo(LANCELOT_X, LANCELOT_X);
    		bridgeScene.getRobin().moveTo(ROBIN_X, ROBIN_Y);
    		bridgeScene.getGalahad().moveTo(GALAHAD_X, GALAHAD_Y);
    		bridgeScene.getGuard().moveTo(bridgeScene.getGuardArea().getCenterX(), bridgeScene.getGuardArea().getCenterY());
    		break;
    	}    
	}
	@Override
	public void keyPressed(KeyEvent event) {
		System.out.println("pressed");
	}
	@Override
	public void keyReleased(KeyEvent event) {
		System.out.println("released");
	}
	@Override
	public JButton getSay() {
		return say;
	}
	@Override
	public JButton getApproach() {
		return approach;
	}
	@Override
	public JButton getFailed() {
		return fail;
	}
	@Override
	public JButton getPassed() {
		return pass;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Action performed");
    	if(event.getSource() == approach)
    		bridgeScene.approach("Lancelot");
    	else if (event.getSource() == say)
    		bridgeScene.say("Hi");
    	else if (event.getSource() == pass)
    		bridgeScene.passed();
    	else if (event.getSource() == fail)
    		bridgeScene.failed();	
	}
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(bridgeScene.preApproach()) approach.setEnabled(true);
		else approach.setEnabled(false);
		if(bridgeScene.preSay()) say.setEnabled(true);
		else say.setEnabled(false);
		if(bridgeScene.preFailed()) fail.setEnabled(true);
		else fail.setEnabled(false);
		if(bridgeScene.prePassed()) pass.setEnabled(true);
		else pass.setEnabled(false);
	}
}
