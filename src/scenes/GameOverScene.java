package scenes;

import bases.GameObject;
import bases.ImageRenderer;
import bases.scenes.Scene;
import game.Background;

public class GameOverScene implements Scene {
    Background background;
    @Override
    public void denit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        background=new Background(0,0);
        GameObject.add(background);
    }
}
