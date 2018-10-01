package player;

import Platform.Platform;
import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;
import bases.ImageUtil;
import bases.scenes.SceneManager;
import javafx.scene.media.MediaPlayer;
import tklibs.AudioUtils;
import zombie.Zombie;

public class PlayerBullet extends GameObject {

    public PlayerBullet(int x, int y) {
        super(x,y);
        renderer = new Animation(ImageUtil.LoadImage("images/bullets/bullet2.png"),
                ImageUtil.LoadImage("images/bullets/bullet1.png"),
                ImageUtil.LoadImage("images/bullets/bullet3.png"));
        this.boxCollider = new BoxCollider(x,y,10,10);
    }

    @Override
    public void run() {
        super.run();
//        deactivateIfNeeded();
        move();
        hitZombies();
        hitPlatForm();
    }

    private void hitZombies() {
        Zombie zombie = GameObject.checkCollision(this.boxCollider, Zombie.class);
        if (zombie!=null){
          AudioUtils.playMedia("Sound/zombie/348310__redafs__zombie-monster-scream.wav");
           AudioUtils.playMedia("Sound/162464__kastenfrosch__message.mp3");
            zombie.getHit();
            this.isActive=false;
            Player.countZom++;
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

    private void hitPlatForm() {
        Platform platform = GameObject.checkCollision(boxCollider,Platform.class);
        if (platform != null) {
            this.isActive = false;
        }
    }
}
