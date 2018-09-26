package player;

import bases.*;

import java.awt.*;

public class BloodBar {
    Vector2D position;
  Image image;

    public BloodBar() {
        position = new Vector2D();
      //  this.renderer=new ImageRenderer("images/player/bloodbar/bloodbar1.png");
        this.image = ImageUtil.LoadImage("images/player/bloodbar/bloodbar1.png");
    }

    public void render(Graphics g,Vector2D position) {
        int imageWidth=this.image.getWidth(null);
        int imageHeight=this.image.getHeight(null);
        Vector2D renderPos=position.substract(imageWidth/2,imageHeight/2);
        g.drawImage(image,(int)renderPos.x,(int)renderPos.y-70,null);
    }
}
