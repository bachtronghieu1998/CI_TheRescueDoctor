package player;

import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;
import game.Platform;

import java.awt.*;

public class Player extends GameObject {

    PlayerMove playerMove;
    PlayerShoot playerShoot;
    PlayerAnimator playerAnimator;
    public final float gravity= 0.5f;
    Vector2D velocity;

    public Player(int x, int y) {
        super(x,y);
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        playerAnimator = new PlayerAnimator();
        renderer = this.playerAnimator;
        boxCollider = new BoxCollider(x,y,60,111);
        velocity=new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        move();
        animate();
        shoot();
        velocity.y+=gravity;
        moveVertical();
        this.position.addUp(velocity);
    }

    private void moveVertical() {

        //Predict collider
        BoxCollider nextBoxCollider=this.boxCollider.shift(0,velocity.y);

        Platform platform = GameObject.checkCollision(nextBoxCollider,Platform.class);
        if (platform != null) {
            boolean moveContinue = true;
            float distance = 1;
            while (moveContinue) {
                if (GameObject.checkCollision(this.boxCollider.shift(0,distance),Platform.class) != null) {
                    moveContinue = false;
                } else {
                    distance += 1;
                    position.addUp(0,1);
                }
            }
            velocity.y = 0;
        }

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
        this.gameOver();

    }
}
