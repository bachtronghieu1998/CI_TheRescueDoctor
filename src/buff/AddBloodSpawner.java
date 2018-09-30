package buff;

import bases.GameObject;
import player.Player;

public class AddBloodSpawner extends GameObject {

    @Override
    public void run() {
        super.run();
        Player p=null;
        p=  GameObject.getPlayer();
        if(p!=null){
            float tempX=p.position.x+750;
            for(int i=0;i<GameObject.addBloodPostion.size();i++){
                if(GameObject.addBloodPostion.get(i).x<tempX && GameObject.addBloodPostion.get(i).x>0){
                    GameObject.generic((int)GameObject.addBloodPostion.get(i).x, (int) GameObject.addBloodPostion.get(i).y, AddBlood.class);
                    GameObject.addBloodPostion.get(i).x=-99;
                }
            }
        }
    }
}
