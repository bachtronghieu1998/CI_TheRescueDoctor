package plant;

import bases.*;
import player.Player;

import java.awt.*;

public class PlantBullet extends GameObject {


    public PlantBullet(int x, int y) {
        super(x, y);
        this.renderer=new Animation(5,false,
                ImageUtil.LoadImage("images/plant/plantBullet/enemy2_bullet1.png"),
                ImageUtil.LoadImage("images/plant/plantBullet/enemy2_bullet2.png"),
                ImageUtil.LoadImage("images/plant/plantBullet/enemy2_bullet3.png")
                );
        this.boxCollider=new BoxCollider(30,25);
    }

    @Override
    public void run() {
        super.run();
        move();
        hitPlayer();
    }

    void move(){
        this.position.addUp(-7,0);
        hitPlayer();
    }

    void hitPlayer(){
        Player player= GameObject.checkCollision(this.boxCollider,Player.class);
        if(player!=null){
            player.count--;
            if (player.count == 2) {
                player.bloodBar.image = ImageUtil.LoadImage("images/player/bloodbar/bloodbar2.png");
            }
            if (player.count == 1) {
                player.bloodBar.image= ImageUtil.LoadImage("images/player/bloodbar/bloodbar3.png");
            }
            if (player.count == 0) {
                player.Destroy();
            }
            this.isActive=false;
        }
        System.out.println("-----------------");
    }

    @Override
    public void render(Graphics g, ViewPort viewPort) {
        super.render(g, viewPort);
    }
}
