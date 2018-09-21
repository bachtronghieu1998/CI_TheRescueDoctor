package game;

import Platform.Platform;
import bases.GameObject;
import player.Player;
import zombie.ZombieSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    BufferedImage backBuffer;
    Graphics backBufferGraphic;
    public GameCanvas(){
           GameObject.add(new Background(0,0));
           GameObject.add(new Player(100,550));
           GameObject.add(new ZombieSpawner());
           Platform ground=new Platform(0,605,886,50);
           GameObject.add(ground);
           // Resize when have background
            backBuffer=new BufferedImage(886,667,BufferedImage.TYPE_INT_ARGB );
            backBufferGraphic=backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0,0,null);
    }

    public void run(){
        GameObject.runAll();
    }

    public void render(){
        GameObject.renderAll(backBufferGraphic);
        this.repaint();
    }
}
