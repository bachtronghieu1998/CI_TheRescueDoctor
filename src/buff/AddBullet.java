package buff;

import bases.*;

public class AddBullet extends GameObject {
    private int count;
    private boolean check;
    public AddBullet(int x, int y) {
        super(x,y);
        this.renderer = new Animation(
                ImageUtil.LoadImage("images/bullets/bullet1.png"),
                ImageUtil.LoadImage("images/bullets/bullet2.png"),
                ImageUtil.LoadImage("images/bullets/bullet3.png")
        );
        count = 0;
        this.boxCollider = new BoxCollider(20,20);
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
