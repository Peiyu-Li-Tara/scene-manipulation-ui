package graphic;
import tags301.Comp301Tags;
import util.annotations.Tags;

@Tags(Comp301Tags.DELEGATING_BRIDGE_SCENE_VIEW)

public class ADelegatingBridgeSceneView implements DelegatingBridgeSceneView{
	ObservableBridgeScenePainter painter;
	BridgeScene bridgeScene;

	public ADelegatingBridgeSceneView() {
		painter = new AnObservableBridgeScenePainter();

//		painter.addPaintListener(new AnObservableGorgePainter(bridgeScene.getGorge()));
//		painter.addPaintListener(new AnObservableAreaPainter(bridgeScene.getGuardArea()));
//		painter.addPaintListener(new AnObservableAreaPainter(bridgeScene.getKnightArea()));
//		painter.addPaintListener(new AnObservableAvatarPainter(bridgeScene.getArthur()));
//		painter.addPaintListener(new AnObservableAvatarPainter(bridgeScene.getLancelot()));
//		painter.addPaintListener(new AnObservableAvatarPainter(bridgeScene.getGalahad()));
//		painter.addPaintListener(new AnObservableAvatarPainter(bridgeScene.getRobin()));
//		painter.addPaintListener(new AnObservableAvatarPainter(bridgeScene.getGuard()));
	}
	
	public ADelegatingBridgeSceneView(BridgeScene scene) {
		this.bridgeScene = scene;
		painter = new AnObservableBridgeScenePainter();
		painter.addPaintListener(new AnObservableGorgePainter(bridgeScene.getGorge()));
		painter.addPaintListener(new AnObservableAreaPainter(bridgeScene.getGuardArea()));
		painter.addPaintListener(new AnObservableAreaPainter(bridgeScene.getKnightArea()));
		painter.addPaintListener(new AnObservableAvatarPainter(bridgeScene.getArthur()));
		painter.addPaintListener(new AnObservableAvatarPainter(bridgeScene.getLancelot()));
		painter.addPaintListener(new AnObservableAvatarPainter(bridgeScene.getGalahad()));
		painter.addPaintListener(new AnObservableAvatarPainter(bridgeScene.getRobin()));
		painter.addPaintListener(new AnObservableAvatarPainter(bridgeScene.getGuard()));
	}

}
