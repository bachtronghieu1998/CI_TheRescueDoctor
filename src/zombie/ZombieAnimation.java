package zombie;

import bases.Animation;
import bases.ImageUtil;
import bases.Renderer;
import bases.Vector2D;

import java.awt.*;

public class ZombieAnimation extends Renderer {
    public  Animation rightAnimation;
    public  Animation leftAnimation;
    public  Animation currentAnimation;
   public int number ;
    public ZombieAnimation() {
        leftAnimation=new Animation(5,false,
                ImageUtil.LoadImage("images/zombie/Run5.png"),
                ImageUtil.LoadImage("images/zombie/Run6.png"),
                ImageUtil.LoadImage("images/zombie/Run7.png"),
                ImageUtil.LoadImage("images/zombie/Run8.png"),
                ImageUtil.LoadImage("images/zombie/Run9.png"),
                ImageUtil.LoadImage("images/zombie/Run10.png"));
        rightAnimation=new Animation(5,false,
                ImageUtil.LoadImage("images/zombie/ZomRight/Run5.png"),
                ImageUtil.LoadImage("images/zombie/ZomRight/Run6.png"),
                ImageUtil.LoadImage("images/zombie/ZomRight/Run7.png"),
                ImageUtil.LoadImage("images/zombie/ZomRight/Run8.png"),
                ImageUtil.LoadImage("images/zombie/ZomRight/Run9.png"),
                ImageUtil.LoadImage("images/zombie/ZomRight/Run10.png"));
        currentAnimation=leftAnimation;
        number=0;

    }


    @Override
    public void render(Graphics g, Vector2D position) {
        currentAnimation.render(g,position);
    }

    public void selectAnimation(int number) {
        if (number== 0) {
            currentAnimation = leftAnimation;
        } else{
            currentAnimation = rightAnimation;

        }
        this.number=number;
    }
}
