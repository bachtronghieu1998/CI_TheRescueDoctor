package game;

import bases.GameObject;
import bases.ImageUtil;
import bases.Vector2D;
import bases.ViewPort;
import game.maps.Map;
import plant.Plant;
import plant.PlantBullet;
import plant.PlantSpawner;
import player.Player;
import player.PlayerBullet;
import zombie.ZombieSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameCanvas extends JPanel {

    BufferedImage backBuffer;
    Graphics backBufferGraphic;
    ViewPort viewPort;
    Player player;
    public GameCanvas(){
           GameObject.add(new Background(0,0));
           player=new Player(100,300);
           GameObject.add(player);
           viewPort=new ViewPort();
           viewPort.followOffset.x=-80/2;
          // viewPort.followOffset.y=-1100/2;
           GameObject.add(new ZombieSpawner());
        GameObject.add(new PlantSpawner());

        // Resize when have background
            backBuffer=new BufferedImage(886,667,BufferedImage.TYPE_INT_ARGB );
        addPlatform();
       addZombie();
       addPlant();
        backBufferGraphic=backBuffer.getGraphics();
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
        GameObject.plantPostion.add(new Vector2D(329*32,13*32-50));
        GameObject.plantPostion.add(new Vector2D(338*32,12*32-50));
        GameObject.plantPostion.add(new Vector2D(358*32,11*32-50));
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
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0,0,null);
    }

    public void run(){
        GameObject.runAll();
        viewPort.follow(player);
    }

    public void render(){

     Graphics2D g2d=  (Graphics2D) backBufferGraphic;
        GameObject.renderAll(backBufferGraphic,viewPort);
        g2d.drawImage(ImageUtil.LoadImage("images/bullets/bullet1.png"), 10, 10,null);
        g2d.drawString(Integer.toString(player.playerShoot.count),50,40);
        g2d.drawImage(ImageUtil.LoadImage("images/zombie/icon/zomIcon.png"), 100, 20,null);
        g2d.drawString(Integer.toString(PlayerBullet.count),140,40);
        g2d.drawImage(ImageUtil.LoadImage("images/plant/icon/Plant bite anim1.png"), 170, 15,null);
        g2d.drawString(Integer.toString(Plant.count),200,40);
        this.repaint();
    }
}
