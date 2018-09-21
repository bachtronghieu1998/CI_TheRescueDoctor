package player;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;

public class PlayerBulletl extends GameObject {

    public PlayerBulletl(int x, int y) {
        super(x,y);
        this.renderer = new ImageRenderer("images/bullets/bullet.png");
    }

    @Override
    public void run() {
        super.run();
        move();
        deactiveIfNeeded();
    }

    private void move() {
        position.addUp(-10,0);
    }

    private void deactiveIfNeeded() {
        if (this.position.x < 0) {
            this.isActive = false;
        }
    }
}
