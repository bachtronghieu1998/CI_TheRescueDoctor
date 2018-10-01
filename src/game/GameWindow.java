package game;

import game.maps.Map;
import inputs.InputManager;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    
    GameCanvas gameCanvas;

    public GameWindow() {

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                InputManager.instance.keyPressed(keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                InputManager.instance.keyReleased(keyEvent);
            }
        });
        // change later
        this.setSize(886,666);
        this.setResizable(false);
        this.setTitle("The-Resue-Doctor");
        gameCanvas = new GameCanvas();
        this.setContentPane(gameCanvas);
        this.setVisible(true);
    }



    public void mainLoop() {
        long currentTime = 0;
        long lastTimeRender = 0;
        while (true) {
            currentTime = System.nanoTime();
            if (currentTime - lastTimeRender >= 17_000_000) {
                gameCanvas.run();
                gameCanvas.render();
                lastTimeRender = currentTime;
            }
        }
    }
}
