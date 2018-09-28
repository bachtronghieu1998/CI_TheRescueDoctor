package Platform;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;

public class Water extends GameObject {

    public Water(int x,int y,int width,int height) {
        super(x,y);
        this.boxCollider=new BoxCollider(x,y,width,height);
        this.renderer=new ImageRenderer("images/background/platform/water.jpg");
    }


}
