package player;

import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;
import bases.ImageUtil;
import zombie.Zombie;

public class PlayerBulletl extends GameObject {

    public PlayerBulletl(int x, int y) {
        super(x,y);
        this.renderer = new Animation(ImageUtil.LoadImage("images/bullets/bullet2.png"),
                ImageUtil.LoadImage("images/bullets/bullet1.png"),
                ImageUtil.LoadImage("images/bullets/bullet3.png"));
        this.boxCollider = new BoxCollider(10,10);
    }

    @Override
    public void run() {
        super.run();
        move();
        hitZombies();
        deactiveIfNeeded();
    }

    private void move() {
        position.addUp(-10,0);
    }

    private void hitZombies() {
        Zombie zombie = GameObject.checkCollision(this.boxCollider, Zombie.class);
        if (zombie!=null){
            zombie.getHit();
            this.isActive=false;
        }
    }

    private void deactiveIfNeeded() {
        if (this.position.x < 0) {
            this.isActive = false;
        }
    }
}
