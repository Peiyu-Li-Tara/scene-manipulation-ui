package graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassedButtonListener implements ActionListener{
	BridgeScene scene;
	
	public PassedButtonListener(BridgeScene givenScene) {
		scene = givenScene;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Pass botton clicked");
		scene.passed();
	}
}
