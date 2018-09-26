package player;

import bases.*;

import java.awt.*;

public class Player extends GameObject {

    PlayerMove playerMove;
    PlayerShoot playerShoot;
    PlayerAnimator playerAnimator;
    public final float gravity=0.8f;

    boolean isDown;
    public Player(int x, int y) {
        super(x,y);
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        playerAnimator = new PlayerAnimator();
        renderer = this.playerAnimator;
        boxCollider = new BoxCollider(x,y,60,111);

    }

    public Vector2D getPosition(){
        return this.position;
    }

    @Override
    public void run() {
        super.run();
         move();
        shoot();
        animate();

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
    public void render(Graphics g, ViewPort viewPort) {
        super.render(g, viewPort);
    }

    public void getHit() {
        this.gameOver();

    }
}
