package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import animation.BroadcastingClearanceManager;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import collection.ATable;
import collection.Table;
import exception.ImpossibleAngleException;
import graphic.ABridgeSceneMouseAndKeyController;
import graphic.ABridgeSceneView;
import graphic.AnAvatar;
import graphic.Avatar;
import graphic.BridgeScene;
import graphic.BridgeSceneFactory;
import graphic.BridgeSceneMouseAndKeyListener;
import graphic.BridgeSceneView;
import graphic.CharacterHead;
import graphic.DelegatingBridgeSceneView;
import graphic.ObservableBridgeScenePainter;
import util.misc.ThreadSupport;

public class Assignment4 {
	protected final static int CONVERSATION_TURN = 3;
	protected final static long SLEEP_TIME = 500;
	protected final static int X_STEP = 10;
	
	static final int CUSTOM_FRAME_WIDTH = 400;
	static final int CUSTOM_FRAME_HEIGHT = 300;
	static final int OE_FRAME_WIDTH = 400;
	static final int OE_FRAME_HEIGHT = 600;
	static final int INIT_SHUTTLE_X = 25;
	static final int INIT_SHUTTLE_Y = 50;

	static final int FINAL_SHUTTLE_X = 50;
	static final int FINAL_SHUTTLE_Y = 100;
	static final int ROTATE_UNIT = -8;
	static final int ROTATE_IMPOSSIBLE_UNIT = -16;

	public static void main(String args[]) throws ImpossibleAngleException {
		final long aTimeBetweenSteps = 1000;

		BroadcastingClearanceManager manager = BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod();
		BridgeScene initialBridgeScene = BridgeSceneFactory.bridgeSceneFactoryMethod();
		ObservableBridgeScenePainter initialOvservableBridgeScenePainter = BridgeSceneFactory.observableBridgeScenePainterFactoryMethod();
		BridgeSceneView initialBridgeSceneView = BridgeSceneFactory.inheritingBridgeScenePainterFactoryMethod();
		DelegatingBridgeSceneView initialDelegatingBridgeSceneView = BridgeSceneFactory.delegatingBridgeSceneViewFactoryMethod();
		PropertyChangeListener view = new ABridgeSceneView(initialBridgeScene);
		BridgeSceneMouseAndKeyListener aMouseAndKeyController = new ABridgeSceneMouseAndKeyController((Component) view);
		
		JFrame aFrame = new JFrame("Bridge Scene");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JButton sayButton = aMouseAndKeyController.getSay();
		JButton approachButton = aMouseAndKeyController.getApproach();
		JButton failButton = aMouseAndKeyController.getFailed();
		JButton passButton = aMouseAndKeyController.getPassed();
		panel.add(sayButton);
		panel.add(approachButton);
		panel.add(passButton);
		panel.add(failButton);
		aFrame.add((Component) view);
		aFrame.add(panel, BorderLayout.NORTH);
		aFrame.setSize(CUSTOM_FRAME_WIDTH, CUSTOM_FRAME_HEIGHT);
		aFrame.setVisible(true);
		OEFrame anOEFrame = ObjectEditor.edit(initialBridgeScene);
		OEFrame managerOEFrame = ObjectEditor.edit(manager);
	
		initialBridgeScene.asynchronousArthur();
		ThreadSupport.sleep(aTimeBetweenSteps);
		initialBridgeScene.approach("Lancelot");
		ThreadSupport.sleep(aTimeBetweenSteps);
		initialBridgeScene.say("What is your name?");
		ThreadSupport.sleep(aTimeBetweenSteps);
		initialBridgeScene.say("Lancelot.");
		ThreadSupport.sleep(aTimeBetweenSteps);
		initialBridgeScene.passed();
		ThreadSupport.sleep(aTimeBetweenSteps);
		initialBridgeScene.getTable().get("Lancelot").getArms().getRightLine().rotate(ROTATE_UNIT);
		ThreadSupport.sleep(aTimeBetweenSteps);
		initialBridgeScene.getArthur().getLegs().getRightLine().rotate(ROTATE_IMPOSSIBLE_UNIT);
		ThreadSupport.sleep(aTimeBetweenSteps);
		
		initialBridgeScene.asynchronousArthur();
		initialBridgeScene.asynchronousGalahad();
		initialBridgeScene.asynchronousGalahad();
		ThreadSupport.sleep(aTimeBetweenSteps);
		
		initialBridgeScene.lockstepArthur();
		initialBridgeScene.lockstepGalahad();
		initialBridgeScene.lockstepRobin();
		initialBridgeScene.lockstepLancelot();
		initialBridgeScene.lockstepGuard();
		ThreadSupport.sleep(aTimeBetweenSteps);
		
		initialBridgeScene.waitingArthur();
		initialBridgeScene.waitingGalahad();
		initialBridgeScene.waitingRobin();
		initialBridgeScene.waitingLancelot();
		
		//StringTable test
		Table<String> stringTestTable = new ATable<String>();
		String aKey = "aKey";
		String bKey = "bKey";
		String cKey = "cKey";
		String aValue = "aValue";
		String bValue = "bValue";
		String cValue = "cValue";
		stringTestTable.put(aKey, aValue);	
		stringTestTable.put(bKey, bValue);
		stringTestTable.put(cKey, cValue);
		System.out.println("Insert the pair: ("+aKey+", "+aValue+")");
		System.out.println("Insert the pair: ("+bKey+", "+bValue+")");
		System.out.println("Insert the pair: ("+cKey+", "+cValue+")");
		System.out.println("Get the pair: ("+aKey+", "+stringTestTable.get(aValue)+")");
		System.out.println("Get the pair: ("+bKey+", "+stringTestTable.get(bValue)+")");
		System.out.println("Get the pair: ("+cKey+", "+stringTestTable.get(cValue)+")");
	
		//AvatarTable test
		Table<AnAvatar> avatarTestTable = new ATable<AnAvatar>();
		String nameOfAvatarA = "Arthur";
		String nameOfAvatarB = "Lancelot";
		String nameOfAvatarC = "Robin";
		AnAvatar avatarA = new Avatar(new CharacterHead("images/arthur.jpg"));
		AnAvatar avatarB = new Avatar(new CharacterHead("images/lancelot.jpg"));
		AnAvatar avatarC = new Avatar(new CharacterHead("images/robin.jpg"));
		avatarTestTable.put(nameOfAvatarA, avatarA);
		avatarTestTable.put(nameOfAvatarB, avatarB);
		avatarTestTable.put(nameOfAvatarC, avatarC);
		System.out.println("Insert the pair: ("+nameOfAvatarA+", "+avatarA+")");
		System.out.println("Insert the pair: ("+nameOfAvatarB+", "+avatarB+")");
		System.out.println("Insert the pair: ("+nameOfAvatarC+", "+avatarC+")");
		System.out.println("Get the pair: ("+nameOfAvatarA+", "+avatarTestTable.get(nameOfAvatarA)+")");
		System.out.println("Get the pair: ("+nameOfAvatarB+", "+avatarTestTable.get(nameOfAvatarB)+")");
		System.out.println("Get the pair: ("+nameOfAvatarC+", "+avatarTestTable.get(nameOfAvatarC)+")");
	}
}
