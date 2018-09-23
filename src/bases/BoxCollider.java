package bases;

import java.awt.*;

public class BoxCollider extends GameObject{
    public int width;
    public int height;
    public BoxCollider(int x, int y, int width,int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public BoxCollider(int width,int height){
         this(0,0,width,height);
    }

    public BoxCollider shift(float dx, float dy){
        BoxCollider shiftedBoxCollider=new BoxCollider(this.width,this.height);
       Vector2D temp= this.position.add(dx,dy);
        shiftedBoxCollider.position.x=temp.x;
        shiftedBoxCollider.position.y=temp.y;
      //  shiftedBoxCollider.screenPosition.set(this.screenPosition.add(dx,dy));

        return shiftedBoxCollider;
    }

    private float top(){
        return this.position.y - this.height/2;
    }
    private float bot(){
        return this.position.y + this.height/2;
    }
    private float left(){
        return this.position.x -this.width/2;
    }
    private float right(){
        return this.position.x + this.width/2;
    }
    public boolean collideWith(BoxCollider other){
        // this vs other
        boolean xOverlap = this.left() <= other.right() &&
                other.left()<=this.right();
        boolean yOverlap = this.top() <= other.bot()&&
                other.top()<=this.bot();
        return xOverlap&&yOverlap;
    }

  //  @Override
//    public void render(Graphics g) {
//        g.drawRect((int)this.left(),(int)this.top(),this.width,this.height);
//    }
}
