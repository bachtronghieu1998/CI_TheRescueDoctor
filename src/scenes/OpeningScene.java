package scenes;

import bases.GameObject;
import bases.scenes.Scene;
import bases.scenes.SceneManager;
import javafx.util.Duration;
import tklibs.AudioUtils;

public class OpeningScene implements Scene {
    @Override
    public void denit() {
        GameObject.clearAll();
        SceneManager.mediaPlayer.dispose();
    }

    @Override
    public void init() {
        AudioUtils.initialize();
        SceneManager.mediaPlayer = AudioUtils.playMedia("Sound/Power Bots Loop.wav");
        SceneManager.mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                SceneManager.mediaPlayer.seek(Duration.ZERO);
            }
        });
    }
}
