package player;

import bases.FrameCounter;
import bases.GameObject;
import inputs.InputManager;

public class PlayerShoot {
    private boolean shootLock;
    FrameCounter frameCounter = new FrameCounter(20);

    public void run(Player player) {
        if (InputManager.instance.xPressed && !shootLock) {
            GameObject.generic((int)player.position.x,(int)player.position.y,PlayerBullet.class);
            shootLock = true;
        }

        if (shootLock) {
            frameCounter.run();
            if (frameCounter.expired) {
                frameCounter.reset();
                shootLock = false;
            }
        }


    }
}