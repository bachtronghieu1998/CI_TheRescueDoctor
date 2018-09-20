package player;

import bases.GameObject;
import bases.ImageRenderer;
import inputs.InputManager;

public class PlayerBullet extends GameObject {

    public PlayerBullet(int x, int y) {
        super(x,y);
        renderer = new ImageRenderer("images/bullets/bullet.png");
    }

    @Override
    public void run() {
        super.run();
        deactivateIfNeeded();
        move();
    }

    private void move() {
        position.addUp(10,0);
    }

    private void deactivateIfNeeded() {
        if (this.position.x > 886 || this.position.x < 0) {
            this.isActive = false;
        }
    }
}
