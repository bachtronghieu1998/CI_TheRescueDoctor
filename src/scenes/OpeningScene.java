package scenes;

import bases.GameObject;
import bases.scenes.Scene;

public class OpeningScene implements Scene {
    @Override
    public void denit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

    }
}
