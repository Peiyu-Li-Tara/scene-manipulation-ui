package graphic;

import java.awt.Component;
import java.beans.PropertyChangeListener;

import animation.ABroadcastingClearanceManager;
import animation.BroadcastingClearanceManager;
import collection.ATable;
import collection.Table;
import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.FACTORY_CLASS)

public class BridgeSceneFactory {
	static BridgeScene scene;
	static ConsoleSceneView consoleScene;
	static BridgeSceneView bridgeScene;
	static Table<AnAvatar> table;
	static BridgeSceneMouseAndKeyListener mouseAndKeyListener;
	static ObservableBridgeScenePainter bridgeScenePainter;
	static DelegatingBridgeSceneView delegatingBridgeSceneView;
	static Leg legs;
	static BroadcastingClearanceManager clearanceManager;
	
	public static BridgeScene bridgeSceneFactoryMethod() throws ImpossibleAngleException{
		if (scene == null) 
			scene = new BridgeSceneImplementation();
		return scene;
	}
	
	public static Table<AnAvatar> avatarTableFactoryMethod() {
		if(table == null)
			table = new ATable<AnAvatar>();
		return table;
	}
	
	public static Leg legsFactoryMethod(int initialX, int initialY, double initialAngle, double initialRadius){
		return new Legs(initialX, initialY, initialAngle, initialRadius);	
	}
	
	public static BridgeSceneView inheritingBridgeScenePainterFactoryMethod() throws ImpossibleAngleException {
		if (bridgeScene == null)
			bridgeScene = new ABridgeSceneView();
		return bridgeScene;
	}
	
	public static ConsoleSceneView consoleSceneViewFactoryMethod() {
		if(consoleScene == null)
			try {
				consoleScene = new AConsoleSceneView();
			} catch (ImpossibleAngleException e) {
				e.printStackTrace();
			}
		return consoleScene;
	}
	
	public static BridgeSceneMouseAndKeyListener bridgeSceneControllerFactoryMethod() throws ImpossibleAngleException {
		if(mouseAndKeyListener == null) 
			mouseAndKeyListener = new ABridgeSceneMouseAndKeyController((Component) inheritingBridgeScenePainterFactoryMethod());
		return mouseAndKeyListener;
	}
	
	public static ObservableBridgeScenePainter observableBridgeScenePainterFactoryMethod() {
		if (bridgeScenePainter == null)
			bridgeScenePainter = new AnObservableBridgeScenePainter();
		return bridgeScenePainter;
	}
	
	public static DelegatingBridgeSceneView delegatingBridgeSceneViewFactoryMethod() {
		if(delegatingBridgeSceneView == null) 
			delegatingBridgeSceneView = new ADelegatingBridgeSceneView();
		return delegatingBridgeSceneView;
	}
	
	public static BroadcastingClearanceManager broadcastingClearanceManagerFactoryMethod() {
		if (clearanceManager == null) {
			clearanceManager = new ABroadcastingClearanceManager();
		}
		return clearanceManager;
	}
	
}
