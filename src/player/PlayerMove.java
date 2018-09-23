package player;

import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;
import game.Platform;
import inputs.InputManager;

import javax.swing.*;

public class PlayerMove {
    public Vector2D velocity;

    public PlayerMove() {
        velocity = new Vector2D();
    }

    public void run(Player player) {
        velocity.x = 0;
        velocity.y = 0;
        if (InputManager.instance.rightPressed) {
            velocity.x += 3;
        }
        if (InputManager.instance.leftPressed) {
            velocity.x -= 3;
        }
        if (InputManager.instance.upPressed) {
            BoxCollider boxColliderAtBottom = player.boxCollider.shift(0,1);
            if (GameObject.checkCollision(boxColliderAtBottom,Platform.class) != null) {
                player.velocity.y -= 12;
            }
        }
//        if (InputManager.instance.downPressed) {
//            velocity.y += 3;
//        }

        player.position.addUp(velocity);
    }
}
