package game;

import bases.BoxCollider;
import bases.GameObject;

public class Platform extends GameObject {

    public Platform(int x, int y) {
        super(x,y);
        this.boxCollider = new BoxCollider(886,1);
    }

}
