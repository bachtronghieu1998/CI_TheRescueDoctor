package buff;

import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;
import bases.ImageUtil;

public class AddBlood extends GameObject {
    private boolean check;
    private int count;

    public AddBlood(int x, int y) {
        super(x, y);
        this.renderer = new Animation(
                ImageUtil.LoadImage("images/bullets/bullet.png"),
                ImageUtil.LoadImage("images/bullets/bullet4.png"),
                ImageUtil.LoadImage("images/bullets/bullet.png")
        );
        this.boxCollider = new BoxCollider(20, 20);
        this.count = 0;
    }

    @Override
    public void run() {
        super.run();
        if (!check) {
            count++;
            position.y -= 3;
            if (count == 70) {
                check = true;
            }
        }
        if (check) {
            count--;
            position.y += 3;
            if (count == 0) {
                check = false;
            }
        }
    }
}
