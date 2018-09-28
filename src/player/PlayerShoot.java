package player;

import bases.FrameCounter;
import bases.GameObject;
import inputs.InputManager;

public class PlayerShoot {
    private boolean shootLock;
    FrameCounter frameCounter = new FrameCounter(20);
    public int count = 100;
    boolean limit = true;

    public void run(Player player) {
        if (InputManager.instance.xPressed && !shootLock && limit) {
            if (PlayerAnimator.currentAnimation == PlayerAnimator.leftAnimation ||
                    PlayerAnimator.currentAnimation == PlayerAnimator.straightlAnimation){
                GameObject.generic((int)player.position.x,(int)player.position.y,PlayerBulletl.class);
            }
            else {
                GameObject.generic((int)player.position.x,(int)player.position.y,PlayerBullet.class);
            }

            shootLock = true;
            count--;
            if (count == 0) {
                limit = false;
            }
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
