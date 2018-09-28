package plant;

import bases.GameObject;
import player.Player;
import zombie.Zombie;

import java.util.ArrayList;

public class PlantSpawner extends GameObject {

    @Override
    public void run() {
        super.run();
        Player p=null;
        for(int i=0;i<GameObject.gameObjects.size();i++){
            if(GameObject.gameObjects.get(i) instanceof Player){
                p=(Player) GameObject.gameObjects.get(i);
            }
        }
        if(p!=null){
            float tempX=p.position.x+900;
            for(int i=0;i<GameObject.plantPostion.size();i++){
                if(GameObject.plantPostion.get(i).x<tempX && GameObject.plantPostion.get(i).x>0){
                    GameObject.generic((int)GameObject.plantPostion.get(i).x, (int) GameObject.plantPostion.get(i).y, Plant.class);
                    GameObject.plantPostion.get(i).x=-99;
                }
            }
        }
    }
}
