package plant;

import bases.*;
import player.Player;
import player.PlayerBullet;

import java.awt.*;

public class Plant extends GameObject {
    public static   FrameCounter counter=new FrameCounter(70);;
    public Plant(int x, int y) {
        super(x, y);
      //  this.renderer=new ImageRenderer("images/plant/Plant bite anim2.png");
        this.renderer=new Animation(10,false,
              ImageUtil.LoadImage("images/plant/Plant bite anim1.png") ,
                ImageUtil.LoadImage("images/plant/Plant bite anim2.png") ,
                ImageUtil.LoadImage("images/plant/Plant bite anim3.png"),
                ImageUtil.LoadImage("images/plant/Plant bite anim5.png")
                );
        this.boxCollider=new BoxCollider(100,66);
        counter=new FrameCounter(70);
    }




    public void run() {
        super.run();

        if(counter.expired){
            GameObject.generic((int)position.x,(int)position.y,PlantBullet.class);
            counter.reset();
        }else{
            counter.run();
        }
        getHit();
    }

    public void getHit(){
        PlayerBullet playerBullet = GameObject.checkCollision(this.boxCollider, PlayerBullet.class);
        if(playerBullet!=null){
            Player.countTree++;
            this.isActive=false;
            playerBullet.isActive=false;
           GameObject.add(new PlantExplosion((int)this.position.x,(int)this.position.y-70));
        }
    }

    @Override
    public void render(Graphics g, ViewPort viewPort) {
        super.render(g, viewPort);
    }
}
