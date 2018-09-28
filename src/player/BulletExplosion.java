package player;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;

public class BulletExplosion extends GameObject {

    public BulletExplosion(int x, int y) {
        super(x,y);
        this.renderer = new Animation(3,true, ImageUtil.LoadImage("images/bullets/bulletex1.png"),
                ImageUtil.LoadImage("images/bullets/bulletex2.png"),
                ImageUtil.LoadImage("images/bullets/bulletex3.png"),
                ImageUtil.LoadImage("images/bullets/bulletex4.png"),
                ImageUtil.LoadImage("images/bullets/bulletex5.png"),
                ImageUtil.LoadImage("images/bullets/bulletex6.png"),
                ImageUtil.LoadImage("images/bullets/bulletex7.png"));
    }

    @Override
    public void run() {
        super.run();
        Animation animation = (Animation)this.renderer;
        if (animation.finish) {
            this.destroy();
        }
    }
}
