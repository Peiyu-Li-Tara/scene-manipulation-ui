package animation;

import graphic.AnAvatar;
import graphic.BridgeSceneFactory;
import tags301.Comp301Tags;
import util.annotations.Tags;
import util.annotations.Visible;
import util.misc.ThreadSupport;

@Tags(Comp301Tags.COORDINATING_ANIMATOR)
public class ACoordinatingAvatarAnimator extends AnAvatarAnimator implements CoordinatingAvatarAnimator{
	BroadcastingClearanceManager manager;
	
	public ACoordinatingAvatarAnimator() {
		manager = BridgeSceneFactory.broadcastingClearanceManagerFactoryMethod();
	}
	
	@Override
	@Visible(false)
	public synchronized void animateAvatar(AnAvatar avatar) {
		for (int i = 0; i < CLAPPING_TIMES; i ++) {
			avatar.move(X_PACE, Y_PACE);
			manager.waitForProceed();
		}
	}
	
	@Override
	public synchronized void clappingAvatar(AnAvatar avatar) {
		for(int i = 0; i < CLAPPING_TIMES; i ++) {
			avatar.getArms().getLeftLine().rotate(CLAPPING_UNIT);
			avatar.getArms().getRightLine().rotate(-CLAPPING_UNIT);
			ThreadSupport.sleep(TIME_BETWEEN_MOVE);
			manager.proceedAll();
			avatar.getArms().getLeftLine().rotate(-CLAPPING_UNIT);
			avatar.getArms().getRightLine().rotate(CLAPPING_UNIT);
			ThreadSupport.sleep(TIME_BETWEEN_MOVE);
			manager.proceedAll();
		}
	}
	
}
