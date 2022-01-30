package animation;

import graphic.AnAvatar;
import tags301.Comp301Tags;
import util.annotations.Tags;
import util.annotations.Visible;
import util.misc.ThreadSupport;

@Tags(Comp301Tags.ANIMATOR)
public class AnAvatarAnimator implements AvatarAnimator{
	
	static final int MOVING_UNIT = 1, CLAPPING_UNIT = 30;
	static final int STEPS = 5, X_PACE = 5, Y_PACE = 0;
	static final int TIME_BETWEEN_MOVE = 100;
	static final int CLAPPING_TIMES = 10;
	
	public AnAvatarAnimator() {
		
	}
	
	@Override
	@Visible(false)
	public synchronized void animateAvatar(AnAvatar avatar) {
		for (int i = 0; i < STEPS; i ++) {
			avatar.move(X_PACE, Y_PACE);
			ThreadSupport.sleep(TIME_BETWEEN_MOVE);
			avatar.getLegs().getLeftLine().rotate(-MOVING_UNIT);
			avatar.getLegs().getRightLine().rotate(MOVING_UNIT);
			ThreadSupport.sleep(TIME_BETWEEN_MOVE);
			avatar.getLegs().getLeftLine().rotate(MOVING_UNIT);
			avatar.getLegs().getRightLine().rotate(-MOVING_UNIT);
			ThreadSupport.sleep(TIME_BETWEEN_MOVE);
		}
	}
	
	@Override
	public synchronized void clappingAvatar(AnAvatar avatar) {
		for(int i = 0; i < CLAPPING_TIMES; i ++) {
			avatar.getArms().getLeftLine().rotate(CLAPPING_UNIT);
			avatar.getArms().getRightLine().rotate(-CLAPPING_UNIT);
			ThreadSupport.sleep(TIME_BETWEEN_MOVE);
			avatar.getArms().getLeftLine().rotate(-CLAPPING_UNIT);
			avatar.getArms().getRightLine().rotate(CLAPPING_UNIT);
			ThreadSupport.sleep(TIME_BETWEEN_MOVE);
		}
	}
}
