package zombie;

import Platform.Platform;
import bases.*;
import player.Player;
import Platform.Water;

import java.awt.*;

public class Zombie extends GameObject {
     ZombieAnimation zombieAnimation;
    public Zombie(int x, int y) {
        super(x, y);
        this.zombieAnimation =new ZombieAnimation();
        this.renderer=zombieAnimation;
        boxCollider=new BoxCollider(x,y,50,100); // change after
    }

    public Zombie() {
       this(0,0);
    }

    @Override
    public void run() {
        super.run();
        //hitPlatForm();
        if(!hitPlatForm() && !hitWater()){
            if(zombieAnimation.number==0){
                this.position.addUp(-2,0);
            }else{
                this.position.addUp(2,0);
            }
        }else{
            if(zombieAnimation.number==0){
                this.zombieAnimation.selectAnimation(1);
                this.position.addUp(2,0);
            //   this.boxCollider.position.addUp(2,0);
            }else{
                this.zombieAnimation.selectAnimation(0);
                this.position.addUp(-2,0);
              //  this.boxCollider.position.addUp(-2,0);
            }
        }

       // detectiveIfNeeded();
    }

    private boolean hitWater() {
       Water water=null;
        if(zombieAnimation.number==0){
            water = GameObject.checkCollision(this.boxCollider.shift(-5,2), Water.class);

        }else{
            water = GameObject.checkCollision(this.boxCollider.shift(5,0), Water.class);
        }
        if (water != null) {
            System.out.println("hit water");
            return true;
        }
        return false;
    }

    private boolean hitPlatForm() {
        Platform platform;
        if(zombieAnimation.number==0){
             platform = GameObject.checkCollision(this.boxCollider.shift(-2,0), Platform.class);

        }else{
            platform = GameObject.checkCollision(this.boxCollider.shift(2,0), Platform.class);
        }
        if (platform != null) {
            return true;
        }
        return false;
    }


    private void detectiveIfNeeded() {
        if(this.position.x==0){
            this.isActive=false;
        }
    }

    @Override
    public void render(Graphics g, ViewPort viewPort) {
        super.render(g, viewPort);
    }

    public void getHit() {
        this.destroy();
    }
}
