package animation;

import java.beans.PropertyChangeListener;

import graphic.APropertyListenerSupport;
import graphic.PropertyListenerSupport;
import util.annotations.ComponentWidth;
import util.annotations.Row;
import util.models.AListenableVector;
import util.models.ListenableVector;

public class AClearanceManager implements ClearanceManager{
	static final int COMPONENT_WIDTH = 150;
	ListenableVector waitingThreads = new AListenableVector<>();
	PropertyListenerSupport propertyListenerSupport = new APropertyListenerSupport();
	@Row(0)
	@ComponentWidth(COMPONENT_WIDTH)
	@Override
	public synchronized void proceed() {
//		System.out.println( Thread.currentThread() + ": before notify");
		notify();
//		System.out.println( Thread.currentThread() + ": after notify");
	}
	@Override
	public synchronized void waitForProceed() {
		try {
			String aThreadID = Thread.currentThread().toString();
//			System.out.println( aThreadID + ": before wait");
			waitingThreads.addElement(aThreadID);
			wait();
//			System.out.println( aThreadID + ": after wait");
			waitingThreads.removeElement(aThreadID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Row(2)
	@Override
	public ListenableVector getWaitingThreads() {
		return waitingThreads;
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyListenerSupport.add(aListener);
	}
}
