package player;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import inputs.InputManager;
import zombie.Zombie;

public class PlayerBullet extends GameObject {

    public PlayerBullet(int x, int y) {
        super(x,y);
        renderer = new ImageRenderer("images/bullets/bullet.png");
        this.boxCollider = new BoxCollider(x,y,10,10);
    }

    @Override
    public void run() {
        super.run();
        deactivateIfNeeded();
        move();
        hitZombies();
    }

    private void hitZombies() {
        Zombie zombie = GameObject.checkCollision(this.boxCollider);
        if (zombie!=null){
            zombie.getHit();
            this.destroy();
        }
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