package graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SayButtonListener implements ActionListener{
	BridgeScene scene;
	String sentence;
	
	public SayButtonListener(BridgeScene givenScene, String givenSentence) {
		scene = givenScene;
		sentence = givenSentence;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Pass botton clicked");
		scene.say(sentence);
	}

}
