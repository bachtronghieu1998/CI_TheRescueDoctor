package player;

import bases.GameObject;
import bases.ImageRenderer;
import bases.ImageUtil;
import bases.Vector2D;

import java.awt.*;

public class BloodBar {
    Vector2D position;
    Image image;

    public BloodBar() {
        position = new Vector2D();
        this.image = ImageUtil.LoadImage("images/player/bloodbar/bloodbar1.png");
    }

    public void render(Graphics g, Vector2D position) {
        g.drawImage(image,(int)position.x-30,(int)position.y-70,null);
    }
}
