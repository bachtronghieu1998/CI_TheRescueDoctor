package player;

import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;
import bases.ImageUtil;
import zombie.Zombie;

public class PlayerBullet extends GameObject {

    public static int count;
    public PlayerBullet(int x, int y) {
        super(x,y);
        renderer = new Animation(ImageUtil.LoadImage("images/bullets/bullet2.png"),
                ImageUtil.LoadImage("images/bullets/bullet1.png"),
                ImageUtil.LoadImage("images/bullets/bullet3.png"));
        this.boxCollider = new BoxCollider(x,y,10,10);
        this.count = 0;
    }

    @Override
    public void run() {
        super.run();
//        deactivateIfNeeded();
        move();
        hitZombies();
    }

    private void hitZombies() {
        Zombie zombie = GameObject.checkCollision(this.boxCollider, Zombie.class);
        if (zombie!=null){
            zombie.getHit();
            this.isActive=false;
            count++;
            BulletExplosion bulletExplosion = new BulletExplosion(
                    (int)zombie.position.x,
                    (int)zombie.position.y
            );
            GameObject.add(bulletExplosion);
        }
    }


    private void move() {
        position.addUp(10,0);
    }

    private void deactivateIfNeeded() {
        if (this.position.x > 886) {
            this.isActive = false;
        }
    }
}
