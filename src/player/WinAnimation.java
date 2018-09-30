package player;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;

public class WinAnimation extends GameObject {

    public WinAnimation(int x, int y) {
        super(x, y);

        this.renderer=new Animation(5,true,
                ImageUtil.LoadImage("images/player/Win/firework1.png") ,
                ImageUtil.LoadImage("images/player/Win/firework2.png") ,
                ImageUtil.LoadImage("images/player/Win/firework3.png") ,
                ImageUtil.LoadImage("images/player/Win/firework4.png") ,
                ImageUtil.LoadImage("images/player/Win/firework5.png") ,
                ImageUtil.LoadImage("images/player/Win/firework6.png") ,
                ImageUtil.LoadImage("images/player/Win/firework7.png") ,
                ImageUtil.LoadImage("images/player/Win/firework8.png") ,
                ImageUtil.LoadImage("images/player/Win/firework9.png") ,
                ImageUtil.LoadImage("images/player/Win/firework10.png") ,
                ImageUtil.LoadImage("images/player/Win/firework11.png") ,
                ImageUtil.LoadImage("images/player/Win/firework12.png") ,
                ImageUtil.LoadImage("images/player/Win/firework13.png") ,
                ImageUtil.LoadImage("images/player/Win/firework14.png")
        );
    }

    @Override
    public void run() {
        super.run();
        Animation animation=(Animation) this.renderer;
        if(animation.finish){
            this.destroy();
        }
    }
}
