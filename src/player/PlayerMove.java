package player;

import Platform.Platform;
import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;
import inputs.InputManager;

public class PlayerMove {
    public Vector2D velocity;

    public PlayerMove() {
        velocity = new Vector2D();
    }

    public void run(Player player) {
        velocity.x = 0;
        this. velocity.y+=player.gravity;
        if (InputManager.instance.rightPressed) {
            velocity.x += 3;
        }
        if (InputManager.instance.leftPressed) {
            velocity.x -= 3;
        }
        if (InputManager.instance.upPressed) {
                BoxCollider colliderBottom=player.boxCollider.shift(0,1);
                if(GameObject.checkCollision(colliderBottom, Platform.class)!=null){
                    this.velocity.y -=15;
                }
        }
        moveHorizontal(player);
        moveVertical(player);
       //player.position.addUp(velocity);
    }

        private void moveHorizontal(Player player) {
        BoxCollider nextBoxCollider=player.boxCollider.shift(this.velocity.x,0);
        Platform platform = GameObject.checkCollision(nextBoxCollider, Platform.class);
        if(platform!=null){
            boolean moveContinue=true;
            float distance=Math.signum(velocity.x);
            while (moveContinue){
                BoxCollider temp = player.boxCollider.shift(distance,0);
                if(GameObject.checkCollision(temp,Platform.class)!=null){
                    moveContinue=false;
                }else{
                    distance+=Math.signum(velocity.x);
                    player.position.addUp(Math.signum(velocity.x),0);
                }
            }
            this.velocity.x=0;
        }else{
            player.position.addUp(velocity.x,0);

        }


    }



    public void moveVertical(Player player) {
        //Predict collider
        BoxCollider nextBoxCollider=player.boxCollider.shift(0,this.velocity.y);
        Platform platform = GameObject.checkCollision(nextBoxCollider, Platform.class);
        if(platform!=null){
            boolean moveContinue=true;
            float distance=Math.signum(velocity.y);
            while (moveContinue){
                BoxCollider temp = player.boxCollider.shift(0,distance);
                if(GameObject.checkCollision(temp,Platform.class)!=null){
                    moveContinue=false;
                }else{
                    distance+=Math.signum(velocity.y);
                    player.position.addUp(0,Math.signum(velocity.y));
                }
            }
            this.velocity.y=0;
        }else{
            player.position.addUp(0,velocity.y);
        }
    }
}
