package zombie;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;
import bases.scenes.SceneManager;
import tklibs.AudioUtils;

public class ZombieExplosion extends GameObject {

    public ZombieExplosion(int x, int y) {
        super(x,y);
        this.renderer = new Animation(15,true, ImageUtil.LoadImage("images/human/human.png"),
                ImageUtil.LoadImage("images/human/human1.png"),
                ImageUtil.LoadImage("images/human/human2.png"),
                ImageUtil.LoadImage("images/human/human3.png"),
                ImageUtil.LoadImage("images/human/human4.png"),
                ImageUtil.LoadImage("images/human/human5.png"),
                ImageUtil.LoadImage("images/human/human6.png"),
                ImageUtil.LoadImage("images/human/human7.png"),
                ImageUtil.LoadImage("images/human/human8.png")
                );
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
