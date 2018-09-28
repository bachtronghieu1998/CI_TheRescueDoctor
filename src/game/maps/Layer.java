package game.maps;

import Platform.Platform;
import bases.GameObject;
import Platform.Water;
import java.util.List;

public class Layer {
    List<Integer> data;
    int height;
    int width;

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    public void generate(){
        for(int tittleY=0;tittleY<height;tittleY++){
            for(int tittleX=0;tittleX<width;tittleX++){
                int mapData=data.get(tittleY*width+tittleX);
                if(mapData!=3 && mapData!=0){
                     Platform platform=new Platform(tittleX*32,tittleY*32,32,32);
                     platform.addImg(mapData);
                    GameObject.add(platform);
               } else if(mapData==3 ){
                    Water water=new Water(tittleX*32,tittleY*32,32,32);
                    GameObject.add(water);
                }
            }
        }
    }
}
