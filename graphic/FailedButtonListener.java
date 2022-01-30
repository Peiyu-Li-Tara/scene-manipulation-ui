package graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FailedButtonListener implements ActionListener{
	BridgeScene scene;
	
	public FailedButtonListener(BridgeScene givenScene) {
		scene = givenScene;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Pass botton clicked");
		scene.failed();
	}
}	
