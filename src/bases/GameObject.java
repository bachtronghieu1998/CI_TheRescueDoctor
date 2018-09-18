package bases;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    Vector2D position;
     Renderer renderer;
     // public BoxCollider boxCollider;
     static private ArrayList<GameObject> gameObjects=new ArrayList<>();
     private static ArrayList<GameObject> newGameObjects=new ArrayList<>();
    public boolean isActive;

    
    public GameObject(int x,int y) {
        position=new Vector2D(x,y);
        renderer=null;
        this.isActive=true;
        //boxcollider=null;
    }

    public GameObject() {
        this(0,0);
    }

    public void run(){

    }

    public static void runAll() {
        for (GameObject go: gameObjects) {
            go.run();
        }
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
