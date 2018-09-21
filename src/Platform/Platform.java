package Platform;

import bases.BoxCollider;
import bases.GameObject;

import java.awt.*;

public class Platform extends GameObject
{
   BoxCollider boxCollider;

    public Platform(int x,int y,int width,int height) {
        super();
        boxCollider=new BoxCollider(x,y,width,height);
    }

    @Override
    public void render(Graphics g) {

        g.drawRect((int)boxCollider.position.x,(int)boxCollider.position.y,boxCollider.width,boxCollider.height);
    }
}
