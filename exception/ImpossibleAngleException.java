package exception;

import java.io.IOException;

import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.IMPOSSIBLE_ANGLE)
public class ImpossibleAngleException extends IOException{
	public ImpossibleAngleException(String message) {
		super(message);
	}
}
