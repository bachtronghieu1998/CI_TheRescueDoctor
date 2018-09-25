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
        this(0,0);
    }
    public BloodBar(int x, int y) {
        this.position = new Vector2D(x,y);
        this.image = ImageUtil.LoadImage("images/player/bloodbar/bloodbar1.png");
    }

    public void run(Player player) {
        position.x = player.position.x - 30;
        position.y = player.position.y - 70;
    }

    public void render(Graphics g) {
        g.drawImage(image,(int)position.x,(int)position.y,null);
    }
}
