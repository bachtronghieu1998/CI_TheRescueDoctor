package scenes;

import bases.GameObject;
import bases.ImageRenderer;
import bases.scenes.Scene;
import bases.scenes.SceneManager;
import game.Background;
import javafx.util.Duration;
import tklibs.AudioUtils;

public class GameOverScene implements Scene {
    Background background;
    @Override
    public void denit() {
        SceneManager.mediaPlayer.dispose();
        GameObject.clearAll();
    }

    @Override
    public void init() {
        AudioUtils.initialize();
        SceneManager.mediaPlayer = AudioUtils.playMedia("Sound/Power Bots Loop.wav");
//        SceneManager.mediaPlayer.setOnEndOfMedia(new Runnable() {
//            public void run() {
//                SceneManager.mediaPlayer.seek(Duration.ZERO);
//            }
//        });
        background=new Background(0,0);
        GameObject.add(background);
    }
}
