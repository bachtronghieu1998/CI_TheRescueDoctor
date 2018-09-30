package buff;

import bases.GameObject;
import player.Player;
import zombie.Zombie;

import java.util.ArrayList;

public class AddBulletSpawner extends GameObject {

    @Override
    public void run() {
        super.run();
        Player p=null;
        p=  GameObject.getPlayer();
        if(p!=null){
            float tempX=p.position.x+750;
            for(int i=0;i<GameObject.addBulletPostion.size();i++){
                if(GameObject.addBulletPostion.get(i).x<tempX && GameObject.addBulletPostion.get(i).x>0){
                    GameObject.generic((int)GameObject.addBulletPostion.get(i).x, (int) GameObject.addBulletPostion.get(i).y, AddBullet.class);
                    GameObject.addBulletPostion.get(i).x=-99;
                }
            }
        }
    }
}
