package Platform;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;

import java.awt.*;

public class Platform extends GameObject
{

    public Platform(int x,int y,int width,int height,String url) {
        super(x,y);
        this.boxCollider=new BoxCollider(x,y,width,height);
        if(url!=null){
            this.renderer=new ImageRenderer(url);

        }
    }


}
