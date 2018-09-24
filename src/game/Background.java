package game;

import bases.GameObject;
import bases.ImageRenderer;
import bases.ImageUtil;

import java.awt.*;

public class Background extends GameObject {

    public Background(int x, int y) {
        super(x, y);
        renderer =new ImageRenderer("images/background/Background.png");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.renderer.img,0,0,null);
    }
}
