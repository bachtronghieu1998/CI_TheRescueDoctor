package game;

import bases.GameObject;
import bases.ImageUtil;
import bases.Vector2D;
import bases.ViewPort;
import bases.scenes.SceneManager;
import game.maps.Map;
import inputs.InputManager;
import plant.Plant;
import plant.PlantBullet;
import plant.PlantSpawner;
import player.Player;
import player.PlayerBullet;
import scenes.GameOverScene;
import scenes.GamePlayScene;
import scenes.OpeningScene;
import sun.awt.im.InputMethodManager;
import zombie.ZombieSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameCanvas extends JPanel {

    BufferedImage backBuffer;
    Graphics backBufferGraphic;
    public GameCanvas(){

          // viewPort.followOffset.y=-1100/2;

           SceneManager.changeScene(new OpeningScene());
            backBuffer=new BufferedImage(886,667,BufferedImage.TYPE_INT_ARGB );

        backBufferGraphic=backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0,0,null);
    }

    public void run(){
        GameObject.runAll();
        SceneManager.changeSceneIfNeeded();
        if(SceneManager.currentScene instanceof  GamePlayScene){
            GamePlayScene gamePlayScene= (GamePlayScene) SceneManager.currentScene;
            gamePlayScene.viewPort.follow(gamePlayScene.player);
        }
    }

    public void render(){
    // backBufferGraphic.setColor(Color.black);
    // backBufferGraphic.fillRect(0,0,886,666);
     Graphics2D g2d=  (Graphics2D) backBufferGraphic;
     if(SceneManager.currentScene instanceof  GamePlayScene){
        GamePlayScene gamePlayScene= (GamePlayScene) SceneManager.currentScene;
         GameObject.renderAll(backBufferGraphic,gamePlayScene.viewPort);
         Font myFont = new Font ("Courier New", 1, 20);
         g2d.setFont(myFont);
         g2d.drawImage(ImageUtil.LoadImage("images/bullets/bullet1.png"), 10, 10,null);
         g2d.drawString(Integer.toString(gamePlayScene.player.playerShoot.count),50,40);
         g2d.drawImage(ImageUtil.LoadImage("images/zombie/icon/zomIcon.png"), 100, 20,null);
         g2d.drawString(Integer.toString(PlayerBullet.count),140,40);
         g2d.drawImage(ImageUtil.LoadImage("images/plant/icon/Plant bite anim1.png"), 170, 15,null);
         g2d.drawString(Integer.toString(Plant.count),200,40);
     }else if(SceneManager.currentScene instanceof GameOverScene){
         Background background=new Background(0,0);
         background.render(backBufferGraphic);
         Font myFont = new Font ("Courier New", 1, 40);
         g2d.setFont(myFont);
         g2d.drawString("G a m e    O v e r",886/2-200,150);
         g2d.drawString("------------------------",886/2-280,180);
          myFont = new Font ("Courier New", 1, 40);
         g2d.setFont(myFont);
         g2d.drawImage(ImageUtil.LoadImage("images/bullets/bullet1.png"), 10, 5,null);
         g2d.drawString(Integer.toString(Player.playerShoot.count),50,40);
         g2d.drawImage(ImageUtil.LoadImage("images/zombie/icon/zomIcon.png"), 150, 15,null);
         g2d.drawString(Integer.toString(PlayerBullet.count),190,40);
         g2d.drawImage(ImageUtil.LoadImage("images/plant/icon/Plant bite anim1.png"), 250, 10,null);
         g2d.drawString(Integer.toString(Plant.count),290,40);
         myFont = new Font ("Courier New", 1, 20);
         g2d.setFont(myFont);
         g2d.drawString("Press Enter to start again",886/2-200,500);
         if(InputManager.instance.startAgain){
             SceneManager.changeScene(new GamePlayScene());
         }
     }else if(SceneManager.currentScene instanceof OpeningScene){
         Background background=new Background(0,0);
         background.render(backBufferGraphic);
         Font myFont = new Font ("Courier New", 1, 40);
         g2d.setFont(myFont);
         g2d.drawString("The Rescue Doctor",886/2-200,150);
          myFont = new Font ("Courier New", 1, 20);
         g2d.setFont(myFont);
         g2d.drawString("-- Press Enter to start the game --",886/2-200,250);
         g2d.drawString("Caution: Doctor hates WATER and FIRE",886/2-180,300);
         g2d.drawImage(ImageUtil.LoadImage("images/player/player-right5.png"),80,490,null);
         g2d.drawImage(ImageUtil.LoadImage("images/arrows/PixelArt.png"),170,520,null);
         g2d.drawImage(ImageUtil.LoadImage("images/player/player-left5.png"),230,490,null);
         g2d.drawImage(ImageUtil.LoadImage("images/arrows/PixelArt (2).png"),320,520,null);
         g2d.drawImage(ImageUtil.LoadImage("images/player/player-right5.png"),400,490,null);
         g2d.drawImage(ImageUtil.LoadImage("images/arrows/PixelArt (1).png"),480,520,null);
         g2d.drawImage(ImageUtil.LoadImage("images/player/player-right5.png"),550,430,null);
         g2d.drawImage(ImageUtil.LoadImage("images/arrows/xKey.png"),630,520,null);
         g2d.drawImage(ImageUtil.LoadImage("images/player/player-right5.png"),690,490,null);
         g2d.drawImage(ImageUtil.LoadImage("images/bullets/bullet1.png"),780,520,null);
         if(InputManager.instance.startAgain){
             SceneManager.changeScene(new GamePlayScene());
         }
     }
        this.repaint();
    }
}
