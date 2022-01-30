package animation;

import exception.ImpossibleAngleException;
import graphic.AnAvatar;
import graphic.BridgeSceneFactory;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.ANIMATING_COMMAND)
public class AnAnimatingAvatarCommand implements AnimatingAvatarCommand{

	AvatarAnimator avatarAnimator;
	AnAvatar avatar;
	BroadcastingClearanceManager clearanceManager;
	boolean isSynchronized;
	
	public AnAnimatingAvatarCommand(AvatarAnimator initialAvatarAnimator, AnAvatar initialAvatar, boolean status) {
		avatarAnimator = initialAvatarAnimator;
		avatar = initialAvatar;
		clearanceManager = BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod();
		isSynchronized = status;
	}
	
	public AnAnimatingAvatarCommand(CoordinatingAvatarAnimator initialAvatarAnimator, AnAvatar initialAvatar, boolean status) {
		avatarAnimator = initialAvatarAnimator;
		avatar = initialAvatar;
		clearanceManager = BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod();
		isSynchronized = status;
	}
	
	@Override
	public void run() {
//		System.out.println(Thread.currentThread() + " about to call animateAvatar in:" + avatarAnimator);
		if (isSynchronized) {
			clearanceManager.waitForProceed();
		} 
		avatarAnimator.animateAvatar(avatar);
//		System.out.println(Thread.currentThread().getName() + " finished call to animateAvatar in:" + avatarAnimator);
	}
	
}
