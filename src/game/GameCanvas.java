package game;

import Platform.Platform;
import bases.GameObject;
import bases.ViewPort;
import game.maps.Map;
import player.Player;
import zombie.ZombieSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
         //  GameObject.add(new ZombieSpawner());
        // Resize when have background
            backBuffer=new BufferedImage(886,667,BufferedImage.TYPE_INT_ARGB );
        addPlatform();

        backBufferGraphic=backBuffer.getGraphics();
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
        this.repaint();
    }
}
