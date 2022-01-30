package graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApproachButtonListener implements ActionListener{
	BridgeScene scene;
	String name;

	public ApproachButtonListener(BridgeScene givenScene, String givenName) {
		scene = givenScene;
		name = givenName;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Pass botton clicked");
		scene.approach(name);
	}
}
