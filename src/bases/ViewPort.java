package bases;

public class ViewPort extends Renderer {
   public Vector2D position;
   public Vector2D followOffset;
    public ViewPort() {
        position=new Vector2D();
        followOffset =new Vector2D();
    }

    public void follow(GameObject object){
        position.x=object.position.x+followOffset.x-200;
    }

    public Vector2D translate(Vector2D pos){
        return pos.substract(this.position);
    }
}
