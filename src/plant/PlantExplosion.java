package plant;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;

public class PlantExplosion extends GameObject {

    public PlantExplosion(int x, int y) {
        super(x, y);
//        this.renderer= new Animation(10,true,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire2.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire3.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire4.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire5.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire6.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire7.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire8.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire9.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire10.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire11.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire12.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire13.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire14.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire15.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire16.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire17.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire18.png") ,
//                ImageUtil.LoadImage("images/plant/plantExplosion/fire19.png")
//        );
        this.renderer=new Animation(10,true,
                ImageUtil.LoadImage("images/plant/plantExplosion2/fire1.png") ,
                ImageUtil.LoadImage("images/plant/plantExplosion2/fire2.png") ,
                ImageUtil.LoadImage("images/plant/plantExplosion2/fire3.png") ,
                ImageUtil.LoadImage("images/plant/plantExplosion2/fire4.png") ,
                ImageUtil.LoadImage("images/plant/plantExplosion2/fire5.png") ,
                ImageUtil.LoadImage("images/plant/plantExplosion2/fire6.png") ,
                ImageUtil.LoadImage("images/plant/plantExplosion2/fire7.png") ,
                ImageUtil.LoadImage("images/plant/plantExplosion2/fire8.png")
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
