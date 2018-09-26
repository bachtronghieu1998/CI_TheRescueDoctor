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

    public Platform(int x,int y,int width,int height) {
        super(x,y);
        this.boxCollider=new BoxCollider(x,y,width,height);
    }

    public void addImg(int dataImg){
        switch(dataImg){
            case 1: {
                this.renderer=new ImageRenderer("images/background/platform/platform2.jpg");
                break;
            }
            case 2: {
                this.renderer=new ImageRenderer("images/background/platform/platform1.jpg");
                break;
            }
            case 3: {
                this.renderer=new ImageRenderer("images/background/platform/water.jpg");
                break;
            }
            case 4: {
                this.renderer=new ImageRenderer("images/background/platform/underWater.jpg");
                break;
            }
        }
    }


}
