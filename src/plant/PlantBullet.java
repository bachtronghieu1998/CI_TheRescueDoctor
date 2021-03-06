package plant;

import Platform.Platform;
import bases.*;
import bases.scenes.SceneManager;
import player.Player;
import tklibs.AudioUtils;

import java.awt.*;

public class PlantBullet extends GameObject {

  int count =0;
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
        hitPlatForm();
    }

    void move(){
        this.position.addUp(-7,0);
        hitPlayer();
    }

    void hitPlayer(){
        Player player= GameObject.checkCollision(this.boxCollider,Player.class);
        boolean check=true;
        if(count<1){
            if(player!=null){
                AudioUtils.playMedia("Sound/player/44428__thecheeseman__hurt1.wav");
                count++;
                this.isActive=false;
                player.backWard();
                player.countLive--;
                if (player.countLive == 2) {
                    player.bloodBar.image = ImageUtil.LoadImage("images/player/bloodbar/bloodbar2.png");
                }else  if (player.countLive == 1){
                    player.bloodBar.image= ImageUtil.LoadImage("images/player/bloodbar/bloodbar3.png");

                }

                if (player.countLive == 0) {
                    player.Destroy();
                }

            }
        }else{
            count=0;
        }

    }

    private void hitPlatForm() {
         Platform platform = GameObject.checkCollision(boxCollider,Platform.class);
             if (platform != null) {
                 this.isActive = false;
             }
    }

    @Override
    public void render(Graphics g, ViewPort viewPort) {
        super.render(g, viewPort);
    }
}
