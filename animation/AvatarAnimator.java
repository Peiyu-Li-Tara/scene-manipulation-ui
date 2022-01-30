package animation;

import exception.ImpossibleAngleException;
import graphic.AnAvatar;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.ANIMATOR)
public interface AvatarAnimator {
	public void animateAvatar(AnAvatar avatar);
	public void clappingAvatar(AnAvatar avatar);
}
