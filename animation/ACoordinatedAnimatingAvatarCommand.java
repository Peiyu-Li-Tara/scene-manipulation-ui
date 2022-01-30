package animation;

import graphic.AnAvatar;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.COORDINATED_ANIMATING_COMMAND)
public class ACoordinatedAnimatingAvatarCommand extends AnAnimatingAvatarCommand implements CoordinatedAnimatingAvatarCommand{

	public ACoordinatedAnimatingAvatarCommand(CoordinatingAvatarAnimator initialAvatarAnimator, AnAvatar initialAvatar, boolean status) {
		super(initialAvatarAnimator, initialAvatar, status);
	}
	
	@Override
	public void run() {
		if (isSynchronized) clearanceManager.waitForProceed();
		avatarAnimator.animateAvatar(avatar);
	}
}
