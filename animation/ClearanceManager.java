package animation;

import util.models.ListenableVector;
import util.models.PropertyListenerRegisterer;

public interface ClearanceManager extends PropertyListenerRegisterer{
	public void proceed();
	public void waitForProceed();	
	public ListenableVector getWaitingThreads();
}
