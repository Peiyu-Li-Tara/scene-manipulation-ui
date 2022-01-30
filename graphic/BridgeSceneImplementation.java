package graphic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;

import animation.AClappingGuardCommand;
import animation.ACoordinatedAnimatingAvatarCommand;
import animation.ACoordinatingAvatarAnimator;
import animation.AnAnimatingAvatarCommand;
import animation.AnAvatarAnimator;
import animation.AnimatingAvatarCommand;
import animation.AvatarAnimator;
import animation.BroadcastingClearanceManager;
import animation.ClappingGuardCommand;
import animation.CoordinatedAnimatingAvatarCommand;
import animation.CoordinatingAvatarAnimator;
import collection.Table;
import exception.ImpossibleAngleException;
import tags301.Comp301Tags;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
import util.misc.ThreadSupport;


@Tags(Comp301Tags.BRIDGE_SCENE)
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class BridgeSceneImplementation implements BridgeScene {
	static int threadNumber = 0;
	protected final static String AVATAR_THREAD_NAME = "Avatar Animation";
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	AnAvatar arthur, lancelot, robin, galahad, guard;
	Gorge gorge;
	Area knightArea;
	Area guardArea;
	boolean occupied = OCCUPIED, knightTurn = KNIGHT_TURN;
	AnAvatar interactingKnight; 
	Table<AnAvatar> tableScene;
	
	AvatarAnimator arthurAnimator, lancelotAnimator, robinAnimator, galahadAnimator, guardAnimator;
	CoordinatingAvatarAnimator coordinatingArthurAnimator, coordinatingLancelotAnimator, 
				coordinatingRobinAnimator, coordinatingGalahadAnimator, coordinatingGuardAnimator;
	AnimatingAvatarCommand arthurAnimatorCommand, lancelotAnimatorCommand, 
				robinAnimatorCommand, galahadAnimatorCommand,
				synchronizedArthurCommand, synchronizedLancelotCommand,
				synchronizedRobinCommand, synchronizedGalahadCommand;
	CoordinatedAnimatingAvatarCommand coordinatedArthurCommand, coordinatedRobinCommand,
				coordinatedLancelotCommand, coordinatedGalahadCommand;
	ClappingGuardCommand guardAnimatorCommand, coordinatedGuardCommand;
	BroadcastingClearanceManager broadcastingClearanceManager;
	
	static final int ARTHUR_X = 100, ARTHUR_Y = 200, 
			LANCELOT_X = 200, LANCELOT_Y = 200,
			ROBIN_X = 100, ROBIN_Y = 400,
			GALAHAD_X = 200, GALAHAD_Y = 400,
			PASS_X = 400, PASS_Y = 0,
			LEFT_BRIDGE_X = 450, LEFT_BRIDGE_Y = 200,
			RIGHT_BRIDGE_X = 450, RIGHT_BRIDGE_Y = 600;
	static final int GUARD_AREA_X = 325, GUARD_AREA_Y = 300, GUARD_AREA_WIDTH = 50, GUARD_AREA_HEIGHT = 50,
			KNIGHT_AREA_X = 250, KNIGHT_AREA_Y = 300, KNIGHT_AREA_WIDTH = 50, KNIGHT_AREA_HEIGHT = 50;
	static final boolean OCCUPIED = false, KNIGHT_TURN = false;
	
	@PropertyNames({
		"Arthur",
		"Lancelot",
		"Robin",
		"Galahad",
		"Guard",
		"Gorge",
		"KnightArea",
		"GuardArea",
		"Occupied",
		"KnightTurn",
		"InteractingKnight"
	})
	
	public BridgeSceneImplementation() throws ImpossibleAngleException {
		gorge = new GorgeImplementation();
		knightArea = new AreaImplementation(KNIGHT_AREA_X, KNIGHT_AREA_Y, KNIGHT_AREA_WIDTH, KNIGHT_AREA_HEIGHT);
		guardArea = new AreaImplementation(GUARD_AREA_X, GUARD_AREA_Y, GUARD_AREA_WIDTH, GUARD_AREA_HEIGHT);
		tableScene = BridgeSceneFactory.avatarTableFactoryMethod();
		arthur = new Avatar(new CharacterHead("images/arthur.jpg","Hello World."));
		tableScene.put("Arthur", (Avatar) arthur);
		arthur.moveTo(ARTHUR_X, ARTHUR_Y);
		lancelot = new Avatar(new CharacterHead("images/lancelot.jpg", "I love you"));
		tableScene.put("Lancelot", (Avatar) lancelot);
		lancelot.moveTo(LANCELOT_X, LANCELOT_Y);
		robin = new Avatar(new CharacterHead("images/robin.jpg", "Nihao"));
		tableScene.put("Robin", (Avatar) robin);
		robin.moveTo(ROBIN_X, ROBIN_Y);
		galahad = new Avatar(new CharacterHead("images/galahad.jpg", "Thank you"));
		tableScene.put("Galahad", (Avatar) galahad);
		galahad.moveTo(GALAHAD_X, GALAHAD_Y);
		guard = new Avatar(new CharacterHead("images/guard.jpg", "Nice to meet you."));
		tableScene.put("Guard", (Avatar) guard);
		guard.moveTo(guardArea.getCenterX(), guardArea.getCenterY());
		this.interactingKnight = null;
		broadcastingClearanceManager = BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod();
		
		arthurAnimator = new AnAvatarAnimator();
		coordinatingArthurAnimator = new ACoordinatingAvatarAnimator();
		arthurAnimatorCommand = new AnAnimatingAvatarCommand(arthurAnimator, arthur, false);
		synchronizedArthurCommand = new AnAnimatingAvatarCommand(arthurAnimator, arthur, true);
		coordinatedArthurCommand = new ACoordinatedAnimatingAvatarCommand(coordinatingArthurAnimator, arthur, true);
		
		robinAnimator = new AnAvatarAnimator();
		coordinatingRobinAnimator = new ACoordinatingAvatarAnimator();
		robinAnimatorCommand = new AnAnimatingAvatarCommand(robinAnimator, robin, false);
		synchronizedRobinCommand = new AnAnimatingAvatarCommand(robinAnimator, robin, true);
		coordinatedRobinCommand = new ACoordinatedAnimatingAvatarCommand(coordinatingRobinAnimator, robin, true);
		
		lancelotAnimator = new AnAvatarAnimator();
		coordinatingLancelotAnimator = new ACoordinatingAvatarAnimator();
		lancelotAnimatorCommand = new AnAnimatingAvatarCommand(lancelotAnimator, lancelot, false);
		synchronizedLancelotCommand = new AnAnimatingAvatarCommand(lancelotAnimator, lancelot, true);
		coordinatedLancelotCommand = new ACoordinatedAnimatingAvatarCommand(coordinatingLancelotAnimator, lancelot, true);
		
		galahadAnimator = new AnAvatarAnimator();
		coordinatingGalahadAnimator = new ACoordinatingAvatarAnimator();
		galahadAnimatorCommand = new AnAnimatingAvatarCommand(galahadAnimator, galahad, false);
		synchronizedGalahadCommand = new AnAnimatingAvatarCommand(galahadAnimator, galahad, true);
		coordinatedGalahadCommand = new ACoordinatedAnimatingAvatarCommand(coordinatingGalahadAnimator, galahad, true);
		
		guardAnimator = new AnAvatarAnimator();
		coordinatingGuardAnimator = new ACoordinatingAvatarAnimator();
		guardAnimatorCommand = new AClappingGuardCommand(guardAnimator, guard);
		coordinatedGuardCommand = new AClappingGuardCommand(coordinatingGuardAnimator, guard);
	}
	
	@Override
	public AnAvatar getArthur() {return arthur;}
	@Override
	public AnAvatar getLancelot() {return lancelot;}
	@Override
	public AnAvatar getRobin() {return robin;}
	@Override
	public AnAvatar getGalahad() {return galahad;}
	@Override
	public AnAvatar getGuard() {return guard;}
	@Override
	public Gorge getGorge() {return this.gorge;}
	@Override
	public Area getKnightArea() {return this.knightArea;}
	@Override
	public Area getGuardArea() {return this.guardArea;}
	@Override
	public boolean getOccupied() {return this.occupied;}
	@Override
	public boolean getKnightTurn() {return this.knightTurn;}
	@Override
	@Visible(false)
	public AnAvatar getInteractingKnight() {return this.interactingKnight;}
	@Override
	public void approach(AnAvatar avatar) {
		//If the knight area has not been occupied, the occupied property turns to true and the interacting knight returns a.
		assert preApproach(): "The area has been occupied";
		
		this.interactingKnight = avatar;
		avatar.moveTo(knightArea.getCenterX(), knightArea.getCenterY());
		this.occupied = true;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "approach", false));
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "say", true));
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "passed", true));
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "failed", true));
	}
	@Override
	public void approach(String avatar) {
		approach(tableScene.get(avatar));
	}
	@Override
	public boolean preApproach() {
		return !getOccupied();
	}
	@Override
	public void say(String sentence) {
		//If the knight area has been occupied
		assert preSay(): "No one on the standing area.";
		//If it is the knight's turn, the interacting knight says something
		if(getKnightTurn()) {
			getInteractingKnight().getStringShape().setText(sentence);
			this.knightTurn = false;
			propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "passed", true));
			propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "failed", true));
		}else {
			//If not the knight's turn, then it is guard's turn
			this.guard.getStringShape().setText(sentence);
			this.knightTurn = true;
			propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "passed", false));
			propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "failed", true));
		}
	}
	@Override
	public boolean preSay() {
		return getOccupied();
	}
	@Override
	public Table<AnAvatar> getTable(){
		return this.tableScene;
	}
	@Override
	public void passed() {
		assert prePassed(): "Knight turn or no avatar in the area.";
		
		getInteractingKnight().move(PASS_X, PASS_Y);
		this.interactingKnight = null;
		this.occupied = false;
		this.knightTurn = false;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "passed", false));
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "say", false));
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "failed", false));
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "approach", true));
	}
	@Override
	public boolean prePassed() {
		return !getKnightTurn() && getOccupied();
	}
	@Override
	public void failed() {
		assert preFailed(): "No one is standing on the area.";
		//Guard's turn, knight failed
		if(!getKnightTurn()){
			this.interactingKnight.moveTo(LEFT_BRIDGE_X, LEFT_BRIDGE_Y);
			this.interactingKnight = null;
			
			this.occupied = false;
			
			propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "failed", false));
			propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "approach", true));
			propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "say", false));
			propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "this", "passed", false));
		} else {
			//If knight's turn, guard failed
			this.guard.moveTo(RIGHT_BRIDGE_X, RIGHT_BRIDGE_Y);
			this.knightTurn = false;
		}
	}
	@Override
	public boolean preFailed() {
		return getOccupied();
	}
	@Override
	public void scroll(int xDirectionUnit, int yDirectionUnit) {
		this.arthur.move(-xDirectionUnit, -yDirectionUnit);
		this.lancelot.move(-xDirectionUnit, -yDirectionUnit);
		this.robin.move(-xDirectionUnit, -yDirectionUnit);
		this.galahad.move(-xDirectionUnit, -yDirectionUnit);
		this.guard.move(-xDirectionUnit, -yDirectionUnit);
		this.gorge.move(-xDirectionUnit, -yDirectionUnit);
		this.knightArea.move(-xDirectionUnit, -yDirectionUnit);
		this.guardArea.move(-xDirectionUnit, -yDirectionUnit);
		if(this.interactingKnight != null)
			this.interactingKnight.move(-xDirectionUnit, -yDirectionUnit);
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertySupport.add(aListener);
	}
	@Override
	public void asynchronousArthur() {
		Thread arthurThread = new Thread(arthurAnimatorCommand);
		threadNumber++;
		arthurThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		arthurThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + arthurThread);
	}
	@Override
	public void asynchronousRobin() {
		Thread robinThread = new Thread(robinAnimatorCommand);
		threadNumber++;
		robinThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		robinThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + robinThread);
	}
	@Override
	public void asynchronousLancelot() {
		Thread lancelotThread = new Thread(lancelotAnimatorCommand);
		threadNumber++;
		lancelotThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		lancelotThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + lancelotThread);
	}
	@Override
	public void asynchronousGalahad() {
		Thread galahadThread = new Thread(galahadAnimatorCommand);
		threadNumber++;
		galahadThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		galahadThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + galahadThread);	
	}
	@Override
	public void asynchronousGuard() {
		Thread guardThread = new Thread(guardAnimatorCommand);
		threadNumber ++;
		guardThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		guardThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + guardThread);	
	}
	@Override
	public void waitingArthur() {
		Thread newArthurThread = new Thread(synchronizedArthurCommand);
		threadNumber++;
		newArthurThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		newArthurThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + newArthurThread);
	}
	@Override
	public void waitingGalahad() {
		Thread newGalahadThread = new Thread(synchronizedGalahadCommand);
		threadNumber++;
		newGalahadThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		newGalahadThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + newGalahadThread);
	}
	@Override
	public void waitingLancelot() {
		Thread newLancelotThread = new Thread(synchronizedLancelotCommand);
		threadNumber++;
		newLancelotThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		newLancelotThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + newLancelotThread);
	}
	@Override
	public void waitingRobin() {
		Thread newRobinThread = new Thread(synchronizedRobinCommand);
		threadNumber++;
		newRobinThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		newRobinThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + newRobinThread);
	}
	@Override
	public void startAnimation() {
		broadcastingClearanceManager.proceedAll();
	}
	@Override
	public void lockstepArthur() {
		Thread lockstepArthurThread = new Thread(coordinatedArthurCommand);
		threadNumber++;
		lockstepArthurThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		lockstepArthurThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + lockstepArthurThread);
	}
	@Override
	public void lockstepGalahad() {
		Thread lockstepGalahadThread = new Thread(coordinatedGalahadCommand);
		threadNumber++;
		lockstepGalahadThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		lockstepGalahadThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + lockstepGalahadThread);
	}
	@Override
	public void lockstepLancelot() {
		Thread lockstepLancelotThread = new Thread(coordinatedLancelotCommand);
		threadNumber++;
		lockstepLancelotThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		lockstepLancelotThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + lockstepLancelotThread);
	}
	@Override
	public void lockstepRobin() {
		Thread lockstepRobinThread = new Thread(coordinatedRobinCommand);
		threadNumber++;
		lockstepRobinThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		lockstepRobinThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + lockstepRobinThread);
	}
	@Override
	public void lockstepGuard() {
		Thread lockstepGuardThread = new Thread(coordinatedGuardCommand);
		threadNumber++;
		lockstepGuardThread.setName(AVATAR_THREAD_NAME + " " + threadNumber);
		lockstepGuardThread.start();
//		System.out.println ("Thread:" + Thread.currentThread() + " has started " + lockstepGuardThread);
	}
	
}