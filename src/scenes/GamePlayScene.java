package scenes;

import bases.GameObject;
import bases.Vector2D;
import bases.ViewPort;
import bases.scenes.Scene;
import game.Background;
import game.maps.Map;
import plant.PlantSpawner;
import player.Player;
import zombie.ZombieSpawner;

public class GamePlayScene implements Scene {
   public Player player;
   public ViewPort viewPort;
   public Background background;
    public GamePlayScene() {

    }

    @Override
    public void denit() {
         GameObject.clearAll();
         viewPort=null;
         player=null;
         background=null;
    }

    @Override
    public void init() {
        viewPort=new ViewPort();
        viewPort.followOffset.x=-80/2;
        background=new Background(0,0);
        player=new Player(100,300);
        GameObject.add(background);
        GameObject.add(player);
        GameObject.add(new ZombieSpawner());
        GameObject.add(new PlantSpawner());
        addPlatform();
        addZombie();
        addPlant();
    }

    public void addPlant(){
        GameObject.plantPostion.add(new Vector2D(864,370));
        GameObject.plantPostion.add(new Vector2D(2304,416-50));

        GameObject.plantPostion.add(new Vector2D(3712,416-50));
        GameObject.plantPostion.add(new Vector2D(5344,512-50));
        GameObject.plantPostion.add(new Vector2D(5728,11*32-50));
        GameObject.plantPostion.add(new Vector2D(201*32,9*32-50));
        GameObject.plantPostion.add(new Vector2D(217*32,11*32-50));
        GameObject.plantPostion.add(new Vector2D(238*32,16*32-50));
        GameObject.plantPostion.add(new Vector2D(254*32,13*32-50));
        GameObject.plantPostion.add(new Vector2D(278*32,14*32-50));
        GameObject.plantPostion.add(new Vector2D(279*32,6*32-50));

        GameObject.plantPostion.add(new Vector2D(297*32,9*32-50));
        GameObject.plantPostion.add(new Vector2D(306*32,12*32-50));

        GameObject.plantPostion.add(new Vector2D(329*32,13*32-50));
        GameObject.plantPostion.add(new Vector2D(335*32,11*32-50));
        GameObject.plantPostion.add(new Vector2D(338*32,12*32-50));

        GameObject.plantPostion.add(new Vector2D(358*32,11*32-50));
        GameObject.plantPostion.add(new Vector2D(364*32,13*32-50));
        GameObject.plantPostion.add(new Vector2D(371*32,15*32-50));

//

    }
    public void addZombie(){
        GameObject.zombPosition.add(new Vector2D(320,540));

        GameObject.zombPosition.add(new Vector2D(1600,540));
        GameObject.zombPosition.add(new Vector2D(4128,540));
        //
        GameObject.zombPosition.add(new Vector2D(6464,540));
        GameObject.zombPosition.add(new Vector2D(7296,540));
        GameObject.zombPosition.add(new Vector2D(6304,540));
        GameObject.zombPosition.add(new Vector2D(7200,540));
        //
        GameObject.zombPosition.add(new Vector2D(8448,540));
        GameObject.zombPosition.add(new Vector2D(8672,540));
        //GameObject.zombPosition.add(new Vector2D(8352,540));
        //
        GameObject.zombPosition.add(new Vector2D(9312,540));
        GameObject.zombPosition.add(new Vector2D(9952,540));
        GameObject.zombPosition.add(new Vector2D(9088,540));
        GameObject.zombPosition.add(new Vector2D(9222,540));

    }

    public void addPlatform(){
        Map map= Map.load("images/background/platform/platform_Temp.json");
        map.generate();
    }
}
