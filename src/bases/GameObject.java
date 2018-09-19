package bases;

import zombie.ZombieSpawner;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
   public Vector2D position;
    public Renderer renderer;
     public BoxCollider boxCollider;
     static private ArrayList<GameObject> gameObjects=new ArrayList<>();
     private static ArrayList<GameObject> newGameObjects=new ArrayList<>();
     public boolean isActive;



    public GameObject(int x,int y) {
        position=new Vector2D(x,y);
        renderer=null;
        this.isActive=true;
        this.boxCollider = null;

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
            go.run();
        }
        gameObjects.addAll(newGameObjects);
        ZombieSpawner.zombieSpawner.addZombie();
    }

    public void render(Graphics g){
        if(this.renderer != null){
            this.renderer.render(g,position);
        }
    }
    public static void renderAll(Graphics backBufferGraphic) {
        for(GameObject go: gameObjects){
            if(go.isActive){
                go.render(backBufferGraphic);
            }
        }
    }
}
