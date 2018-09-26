package zombie;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;

import java.util.Random;

public class ZombieSpawner extends GameObject {
    FrameCounter frameCounter;

    public ZombieSpawner() {
        super();
        frameCounter=new FrameCounter(200);
    }

    @Override
    public void run() {
        super.run();
        if(frameCounter.expired){
            Random rd=new Random();
            GameObject.generic(890,540,Zombie.class);
            //  GameObject.add(new Zombie(890,550));
            frameCounter.reset();
        }else{
            frameCounter.run();
        }
    }




}
