package player;

import Platform.Platform;
import bases.*;
import zombie.Zombie;

import java.awt.*;

public class Player extends GameObject {

    PlayerMove playerMove;
    PlayerShoot playerShoot;
    PlayerAnimator playerAnimator;
    public final float gravity=0.8f;
    int count;
    BloodBar bloodBar;

    public Player(int x, int y) {
        super(x,y);
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        playerAnimator = new PlayerAnimator();
        renderer = this.playerAnimator;
        boxCollider = new BoxCollider(x,y,60,111);
        count = 3;
        bloodBar = new BloodBar();
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
        getHit();
        bloodBar.position.x=this.position.x;
        bloodBar.position.y=this.position.y;
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
        bloodBar.render(g,viewPort.translate(this.position));
    }

    public void getHit() {
        Zombie zombie = GameObject.checkCollision(this.boxCollider,Zombie.class);
        if (zombie != null) {
            count--;
           zombie.position.x+=20;

           boolean moveContinue=true;
           int distance=-1;
           while(moveContinue){
               BoxCollider temp=this.boxCollider.shift(distance,0);
               if(GameObject.checkCollision(temp,Platform.class)!=null){
                   moveContinue=false;
               }else{
                   distance-=1;
                   this.position.addUp(distance,0);
                   this.boxCollider.position.addUp(distance,0);
               }

           }


//            this.position.addUp(0,-800);
        }
        if (count == 2) {
            bloodBar.image = ImageUtil.LoadImage("images/player/bloodbar/bloodbar2.png");
        }
        if (count == 1) {
            bloodBar.image = ImageUtil.LoadImage("images/player/bloodbar/bloodbar3.png");
        }
        if (count == 0) {
            this.destroy();
        }
    }
}
