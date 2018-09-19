package zombie;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class ZombieSpawner extends GameObject {
    FrameCounter frameCounter;

    public static  ZombieSpawner zombieSpawner=new ZombieSpawner();
    public ZombieSpawner() {
        super();
        frameCounter=new FrameCounter(30);
    }

    public  void addZombie(){
        if(frameCounter.expired){
            Random rd=new Random();
             GameObject.add(new Zombie(890,550));
             frameCounter.reset();
        }else{
            frameCounter.run();
        }
    }


}
