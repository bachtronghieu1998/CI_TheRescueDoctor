package player;

import Platform.Platform;
import bases.*;
import bases.scenes.SceneManager;
import plant.PlantExplosion;
import scenes.GameOverScene;
import zombie.Zombie;
import Platform.Water;
import java.awt.*;

public class Player extends GameObject {

    PlayerMove playerMove;
    public static PlayerShoot playerShoot;
    PlayerAnimator playerAnimator;
    public  float gravity=0.8f;
    public int count;
   public BloodBar bloodBar;
    FrameCounter frameCounter;
    public Player(int x, int y) {
        super(x,y);
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        playerAnimator = new PlayerAnimator();
        renderer = this.playerAnimator;
        boxCollider = new BoxCollider(x,y,60,111);
        count = 3;
        bloodBar = new BloodBar();
        frameCounter=new FrameCounter(36);
    }

    public Vector2D getPosition(){
        return this.position;
    }

    @Override
    public void run() {
        super.run();
        if(!this.isAlive){
            Destroy();
        }
         move();
        shoot();
        animate();
        getHit();
        dropWater();
        bloodBar.position.x=this.position.x;
        bloodBar.position.y=this.position.y;
    }


    public void dropWater(){
        Water water = GameObject.checkCollision(this.boxCollider, Water.class);
        if(water!=null){
            if(frameCounter.expired){
                this.isAlive=false;
                frameCounter.reset();
            }else{
                GameObject.add(new PlantExplosion((int)this.position.x,(int)this.position.y));
                frameCounter.run();
            }


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
    public void render(Graphics g, ViewPort viewPort) {
        super.render(g, viewPort);
        bloodBar.render(g,viewPort.translate(this.position));
    }

    public void getHit() {
        Zombie zombie = GameObject.checkCollision(this.boxCollider, Zombie.class);
        if (zombie != null) {
            count--;
           //zombie.position.x+=10;

             BoxCollider tempBox=  this.boxCollider.shift(-30,0);
             if(GameObject.checkCollision(tempBox,Platform.class)!=null){
                 int distance=-1;
                 boolean moveContinue=true;
                 while(moveContinue){
                     BoxCollider temp=this.boxCollider.shift(distance,0);
                     if(GameObject.checkCollision(temp, Platform.class)!=null){
                         moveContinue=false;
                     }else{
                         distance-=1;
                         this.position.addUp(distance,0);
                         this.boxCollider.position.addUp(distance,0);
                     }

                 }
             }else{
                 this.position.addUp(-30,-30);
                 this.boxCollider.position.addUp(-30,-30);
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
            this.Destroy();
        }
    }

    public void Destroy(){
        SceneManager.changeScene(new GameOverScene());
    }
}
