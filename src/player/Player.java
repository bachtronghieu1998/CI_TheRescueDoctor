package player;

import Platform.Platform;
import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;
import inputs.InputManager;
import zombie.Zombie;

import java.awt.*;

public class Player extends GameObject {

    PlayerMove playerMove;
    PlayerShoot playerShoot;
    PlayerAnimator playerAnimator;
    public final float gravity=0.8f;
    int count;

    boolean isDown;
    public Player(int x, int y) {
        super(x,y);
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        playerAnimator = new PlayerAnimator();
        renderer = this.playerAnimator;
        boxCollider = new BoxCollider(x,y,60,111);
        count = 3;
    }

    @Override
    public void run() {
        super.run();
         move();
        shoot();
        animate();
        getHit();
    }

    private void move() {
        playerMove.run(this);
    }

    private void shoot() {
        playerShoot.run(this);
    }

    private void animate() {
        playerAnimator.selectAnimation(playerMove.velocity);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    public void getHit() {
        Zombie zombie = GameObject.checkCollision(this.boxCollider, Zombie.class);
        if (zombie != null) {
            count--;
            this.position.addUp(-50,0);
        }
        if (count == 0) {
            this.destroy();
        }
    }
}
