package graphic;

import java.beans.PropertyChangeListener;

import collection.Table;
import tags301.Comp301Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags(Comp301Tags.BRIDGE_SCENE)
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public interface BridgeScene extends PropertyListenerRegisterer{
	public AnAvatar getArthur();
	public AnAvatar getLancelot();
	public AnAvatar getRobin();
	public AnAvatar getGalahad();
	public AnAvatar getGuard();
	public Gorge getGorge();
	public Area getKnightArea();
	public Area getGuardArea(); 
	public void approach(AnAvatar avatar);
	public void approach(String avatar);
	public boolean preApproach();
	public boolean getOccupied();
	public boolean getKnightTurn();
	public AnAvatar getInteractingKnight();
	public void say(String sentence);
	public boolean preSay();
	public void passed();
	public boolean prePassed();
	public void failed();
	public boolean preFailed();
	public void scroll(int xDirectionUnit, int yDirectionUnit);
	public Table<AnAvatar> getTable();
	public void asynchronousArthur();
	public void asynchronousRobin();
	public void asynchronousLancelot();
	public void asynchronousGalahad();
	public void asynchronousGuard();
	public void waitingArthur();
	public void waitingGalahad();
	public void waitingLancelot();
	public void waitingRobin();
	public void startAnimation();
	public void lockstepArthur();
	public void lockstepGalahad();
	public void lockstepLancelot();
	public void lockstepRobin();
	public void lockstepGuard();
}