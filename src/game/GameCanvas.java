package game;

import bases.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    BufferedImage backBuffer;
    Graphics backBufferGraphic;
    public GameCanvas(){

           // Resize when have background
            backBuffer=new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB );
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
