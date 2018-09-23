package bases;

import player.Player;
import zombie.Zombie;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class GameObject {
   public Vector2D position;
    public Renderer renderer;
     public BoxCollider boxCollider;
     static private ArrayList<GameObject> gameObjects=new ArrayList<>();
     private static ArrayList<GameObject> newGameObjects=new ArrayList<>();
     public boolean isActive;
    public boolean isAlive;


    public GameObject(int x,int y) {
        position=new Vector2D(x,y);
        renderer=null;
        this.isActive=true;
        this.boxCollider = null;
        this.isAlive=true;
    }

    public static void add(GameObject object){
        newGameObjects.add(object);
    }

    public GameObject() {
        this(0,0);
    }

    public void run(){
          if(boxCollider!=null){
              boxCollider.position.x=this.position.x;
              boxCollider.position.y=this.position.y;
          }
    }

    public static void runAll() {
        for (GameObject go: gameObjects) {
            if(go.isActive){
                go.run();
            }
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        System.out.println(gameObjects.size());
    }

    public void render(Graphics g){
        if(this.renderer != null){
            this.renderer.render(g,position);
        }

        if (this.boxCollider != null) {
//            this.boxCollider.render(g);
        }
    }
    public static void renderAll(Graphics backBufferGraphic) {
        for(GameObject go: gameObjects){
            if(go.isActive){
                go.render(backBufferGraphic);
            }
        }
    }

    public static   <T extends GameObject> T generic(int x,int y, Class<T> cls){
        T pb=null;
        for(int i=0;i<gameObjects.size();i++){
            if(!gameObjects.get(i).isActive){
                if(gameObjects.get(i).getClass().equals(cls)){
                    pb=(T)gameObjects.get(i);
                }
            }
        }

        if(pb==null){
            try {
             pb=   cls.getConstructor(int.class ,int.class).newInstance(x,y);
             add(pb);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }else{
            pb.isActive=true;
            pb.position.x=x;
            pb.position.y=y;
        }
        return pb;
    }

    public static <Q extends GameObject> Q checkCollision(BoxCollider boxCollider, Class<Q> cls){
        Q result = null;
        for (GameObject go:gameObjects){
            if(go.isActive&&go.boxCollider !=null){
                if (go.getClass().equals(cls)){
                    if (go.boxCollider.collideWith(boxCollider)){
                        result =(Q) go;
                    }
                }
            }
        }
        return result;
    }

    public static Player checkCollisionP(BoxCollider boxCollider){
        Player result = null;
        for (GameObject go:gameObjects){
            if(go.isActive&&go.boxCollider != null){
                if (go instanceof Player){
                    if (go.boxCollider.collideWith(boxCollider)){
                        result=(Player) go;
                    }
                }
            }
        }
        return result;
    }

    protected void destroy() {
        this.isActive = false;
    }

    protected void gameOver() {
        this.isAlive=false;
        System.exit(0);
    }
}
