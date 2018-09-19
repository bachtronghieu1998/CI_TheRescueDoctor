package zombie;

import bases.*;

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
        boxCollider=new BoxCollider(x,y,50,50);
    }

    @Override
    public void run() {
        super.run();
        zombieRun();
    }

    private void zombieRun() {
        this.position.addUp(-2,0);
    }


    @Override
    public void render(Graphics g) {
        super.render(g);
    }
}
