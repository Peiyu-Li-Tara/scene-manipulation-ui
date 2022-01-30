package animation;

import graphic.AnAvatar;
import tags301.Comp301Tags;
import util.annotations.Tags;
@Tags(Comp301Tags.COORDINATED_ANIMATING_COMMAND)
public class AClappingGuardCommand implements ClappingGuardCommand{

	AvatarAnimator animator;
	AnAvatar avatar;
	
	public AClappingGuardCommand(AvatarAnimator initialAvatarAnimator, AnAvatar initialAvatar) {
		animator = initialAvatarAnimator;
		avatar = initialAvatar;
	}
	
	@Override
	public void run() {
//		System.out.println(Thread.currentThread() + " about to call animateAvatar in:" + animator);
		animator.clappingAvatar(avatar);
//		System.out.println(Thread.currentThread().getName() + " finished call to animateAvatar in:" + animator);
	}
}
