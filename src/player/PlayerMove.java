package player;

import bases.Vector2D;
import inputs.InputManager;

public class PlayerMove {
    public Vector2D velocity;

    public PlayerMove() {
        velocity = new Vector2D();
    }

    public void run(Vector2D position) {
        velocity.x = 0;
        velocity.y = 0;
        if (InputManager.instance.rightPressed) {
            velocity.x += 3;
        }
        if (InputManager.instance.leftPressed) {
            velocity.x -= 3;
        }
        if (InputManager.instance.upPressed) {
            velocity.y -=20;
        }
        if (InputManager.instance.downPressed) {
            if(position.y>=550) return;
            velocity.y += 3;
        }

        position.addUp(velocity);
    }
}
