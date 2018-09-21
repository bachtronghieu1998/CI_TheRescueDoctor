package zombie;

import bases.*;
import player.Player;

import java.awt.*;

public class Zombie extends GameObject {

    public Zombie(int x, int y) {
        super(x, y);
        renderer =new Animation(5,false,
                ImageUtil.LoadImage("images/zombie/Run5.png"),
                ImageUtil.LoadImage("images/zombie/Run6.png"),
                ImageUtil.LoadImage("images/zombie/Run7.png"),
                ImageUtil.LoadImage("images/zombie/Run8.png"),
                ImageUtil.LoadImage("images/zombie/Run9.png"),
                ImageUtil.LoadImage("images/zombie/Run10.png")
        );
        boxCollider=new BoxCollider(x,y,50,50); // change after
    }

    public Zombie() {
       this(0,0);
    }

    @Override
    public void run() {
        super.run();
        zombieRun();
        detectiveIfNeeded();
        hitPlayer();
    }

    private void hitPlayer() {
        Player player = GameObject.checkCollision(this.boxCollider,Player.class);
            if (player!=null){
                System.out.println("Game over");
                player.getHit();
                this.destroy();
            }
        }


    private void detectiveIfNeeded() {
        if(this.position.x==0){
            this.isActive=false;
        }
    }

    private void zombieRun() {
        this.position.addUp(-2,0);
    }


    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    public void getHit() {
        this.destroy();
    }
}
