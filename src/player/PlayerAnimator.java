package player;

import bases.*;

import java.awt.*;

public class PlayerAnimator extends Renderer {

    public static Animation rightAnimation;
    public static Animation straightAnimation;
    public static Animation currentAnimation;
    public static Animation leftAnimation;
    public static Animation straightlAnimation;

    public PlayerAnimator() {
        rightAnimation = new Animation(5,false,
                ImageUtil.LoadImage("images/player/player-right1.png"),
                ImageUtil.LoadImage("images/player/player-right2.png"),
                ImageUtil.LoadImage("images/player/player-right3.png"),
                ImageUtil.LoadImage("images/player/player-right4.png"),
                ImageUtil.LoadImage("images/player/player-right5.png"));

        leftAnimation = new Animation(5,false,
                ImageUtil.LoadImage("images/player/player-left1.png"),
                ImageUtil.LoadImage("images/player/player-left2.png"),
                ImageUtil.LoadImage("images/player/player-left3.png"),
                ImageUtil.LoadImage("images/player/player-left4.png"),
                ImageUtil.LoadImage("images/player/player-left5.png"));

        straightAnimation = new Animation(5,false,
                ImageUtil.LoadImage("images/player/player.png"),
                ImageUtil.LoadImage("images/player/player1.png"),
                ImageUtil.LoadImage("images/player/player2.png"),
                ImageUtil.LoadImage("images/player/player3.png"),
                ImageUtil.LoadImage("images/player/player4.png"));
        straightlAnimation = new Animation(5,false,
                ImageUtil.LoadImage("images/player/playerl.png"),
                ImageUtil.LoadImage("images/player/playerl1.png"),
                ImageUtil.LoadImage("images/player/playerl2.png"),
                ImageUtil.LoadImage("images/player/playerl3.png"),
                ImageUtil.LoadImage("images/player/playerl4.png"));
        currentAnimation = straightAnimation;
    }


    @Override
    public void render(Graphics g, Vector2D position) {
        currentAnimation.render(g,position);
    }

    public void selectAnimation(Vector2D playerVelocity) {
        if (playerVelocity.x > 0) {
            currentAnimation = rightAnimation;
        } else if (playerVelocity.x < 0) {
            currentAnimation = leftAnimation;
        } else if (playerVelocity.x == 0) {
            if (currentAnimation == rightAnimation) {
                currentAnimation = straightAnimation;
            } else if (currentAnimation == leftAnimation){
                currentAnimation = straightlAnimation;
            }
        }
    }
}
