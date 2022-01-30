package animation;

import util.annotations.ComponentWidth;
import util.annotations.Row;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class ABroadcastingClearanceManager extends AClearanceManager implements BroadcastingClearanceManager {
	
	@Row(1)
	@ComponentWidth(COMPONENT_WIDTH)
	@Override
	public synchronized void proceedAll() {
		notifyAll();
//		System.out.println( Thread.currentThread()  + ": after notifyAll");
	}

}
