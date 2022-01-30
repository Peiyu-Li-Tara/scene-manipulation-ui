package graphic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.CONSOLE_SCENE_VIEW)

public class AConsoleSceneView implements ConsoleSceneView{
	
	BridgeScene initialBridgeScene;
	
	public AConsoleSceneView() throws ImpossibleAngleException {
		initialBridgeScene = BridgeSceneFactory.bridgeSceneFactoryMethod();
		initialBridgeScene.addPropertyChangeListener(this);
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
	}
	@Override
	public BridgeScene getBridgeScene() {
		return this.initialBridgeScene;
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
	}
	
}
