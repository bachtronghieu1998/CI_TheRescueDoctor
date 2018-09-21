package player;

import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;

import java.awt.*;

public class Player extends GameObject {

    PlayerMove playerMove;
    PlayerShoot playerShoot;
    PlayerAnimator playerAnimator;
    public Player(int x, int y) {
        super(x,y);
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        playerAnimator = new PlayerAnimator();
        renderer = this.playerAnimator;
        boxCollider = new BoxCollider(x,y,60,111);
    }

    @Override
    public void run() {
        super.run();
        move();
        shoot();
        animate();
    }

    private void move() {
        playerMove.run(position);
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
        this.gameOver();

    }
}
