package zombie;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import player.Player;

import java.util.ArrayList;
import java.util.Random;

public class ZombieSpawner extends GameObject {
    FrameCounter frameCounter;

    public ZombieSpawner() {
        super();
        frameCounter=new FrameCounter(200);
        frameCounter.count=199;
    }

    @Override
    public void run() {
        super.run();
//        if(frameCounter.expired){
            Player p=null;
            ArrayList<Integer> positonEnemy=new ArrayList<>();
            for(int i=0;i<GameObject.gameObjects.size();i++){
                if(GameObject.gameObjects.get(i) instanceof Player){
                    p=(Player) GameObject.gameObjects.get(i);
                }
            }
            if(p!=null){
                float tempX=p.position.x+900;
                for(int i=0;i<GameObject.zombPosition.size();i++){
                    if(GameObject.zombPosition.get(i).x<tempX && GameObject.zombPosition.get(i).x>0){
                        GameObject.generic((int)GameObject.zombPosition.get(i).x, (int) GameObject.zombPosition.get(i).y,Zombie.class);
                        GameObject.zombPosition.get(i).x=-99;
                    }
                }
            }

    }






}
