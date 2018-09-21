package player;

import Platform.Platform;
import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;

import java.awt.*;

public class Player extends GameObject {

    PlayerMove playerMove;
    PlayerShoot playerShoot;
    PlayerAnimator playerAnimator;
    public final float gravity=0.5f;
    Vector2D verlocity;
    public Player(int x, int y) {
        super(x,y);
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        playerAnimator = new PlayerAnimator();
        renderer = this.playerAnimator;
        boxCollider = new BoxCollider(x,y,60,111);
        verlocity=new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        move();
        verlocity.y+=gravity;
        shoot();
        animate();
        moveVertical();
        this.position.addUp(verlocity);
    }

    private void moveVertical() {
        //Predict collider
        BoxCollider nextBoxCollider=this.boxCollider.shift(0,verlocity.y);

        Platform platform = GameObject.checkCollision(nextBoxCollider, Platform.class);

        if(platform!=null){
            System.out.println("++++++++++++++++++++++++++++++++++++++++");
            boolean moveContinue=true;
            float distance=1;
            while (moveContinue){
                BoxCollider temp = this.boxCollider.shift(0,distance);
                if(GameObject.checkCollision(temp,Platform.class)!=null){
                    moveContinue=false;
                }else{
                    distance++;
                    position.addUp(0,1);
                }
            }
            verlocity.y=0;
        }
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
