package player;

import Platform.Platform;
import bases.*;
import bases.scenes.SceneManager;
import buff.AddBlood;
import buff.AddBullet;
import plant.Plant;
import plant.PlantExplosion;
import scenes.GameOverScene;
import zombie.Zombie;
import Platform.Water;
import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    PlayerMove playerMove;
    public static PlayerShoot playerShoot;
    PlayerAnimator playerAnimator;
    public  float gravity=0.8f;
    public int countLive;
   public BloodBar bloodBar;
    FrameCounter frameCounter;
    public static int countZom;
    public static int countTree;
   public boolean isDrop;
   public boolean isWin;
   Random random;

    public Player(int x, int y) {
        super(x,y);
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        playerAnimator = new PlayerAnimator();
        renderer = this.playerAnimator;
        boxCollider = new BoxCollider(x,y,60,111);
        countLive = 3;
        bloodBar = new BloodBar();
        frameCounter=new FrameCounter(50);
        this.countZom = 0;
        this.countTree=0;
        this.isDrop=false;
        this.isWin=false;
        random = new Random();
    }

    public Vector2D getPosition(){
        return this.position;
    }

    public void updateTreeBullet(){
        Player player= getPlayer();
        if(this.position.x <874){
            Plant.counter.limit=80;
        }else if(player.position.x<182*32){
            Plant.counter.limit=80;
        }else if(player.position.x<283*32){
            Plant.counter.limit=75;
        }else if(player.position.x<343*12){
            Plant.counter.limit=70;
        }else{
            Plant.counter.limit=65;
        }
    }

    public void Win(){
        if(this.position.x >392*32){
            isWin=true;
        }
    }
    @Override
    public void run() {
        super.run();
       if(!isDrop && !isWin){
           Win();
           updateTreeBullet();
           move();
           shoot();
           animate();
           getHit();
           dropWater();
           eatBullet();
           eatBlood();
       }else if(isDrop){
           if(frameCounter.expired){
               this.Destroy();
           }else{
               GameObject.add(new PlantExplosion((int)this.position.x,(int)this.position.y));
               frameCounter.run();
           }
       }else if(isWin){
           if(frameCounter.expired){
               this.Destroy();
           }else{
               GameObject.add(new WinAnimation((int)this.position.x,(int)this.position.y-150));
               frameCounter.run();
           }
       }


        bloodBar.position.x=this.position.x;
        bloodBar.position.y=this.position.y;
    }

    public void dropWater(){
        Water water = GameObject.checkCollision(this.boxCollider, Water.class);
        if(water!=null){
          isDrop=true;

        }
    }
    private void move() {
        playerMove.run(this);
    }

    private void shoot() {
        playerShoot.run(this);
    }

    private void animate() {
        playerAnimator.selectAnimation(playerMove.velocity);
    }

    @Override
    public void render(Graphics g, ViewPort viewPort) {
        super.render(g, viewPort);
        bloodBar.render(g,viewPort.translate(this.position));
    }

    private void eatBullet() {
        AddBullet addBullet = GameObject.checkCollision(this.boxCollider, AddBullet.class);
        if (addBullet != null) {
            addBullet.isActive = false;
            playerShoot.count += random.nextInt(6);
        }
    }

    public  void backWard(){
        BoxCollider tempBox=  this.boxCollider.shift(-30,-30);
        if(GameObject.checkCollision(tempBox,Platform.class)!=null){
            int distance=-1;
            boolean moveContinue=true;
            while(moveContinue){
                BoxCollider temp=this.boxCollider.shift(distance,0);
                if(GameObject.checkCollision(temp, Platform.class)!=null){
                    moveContinue=false;
                }else{
                    distance-=1;
                    this.position.addUp(distance,0);
                    this.boxCollider.position.addUp(distance,0);
                }

            }
        }else{
            this.position.addUp(-30,-30);
            this.boxCollider.position.addUp(-30,-30);
        }
    }

    public void getHit() {
        Zombie zombie = GameObject.checkCollision(this.boxCollider, Zombie.class);
        if (zombie != null) {
            countLive--;
            backWard();
        }
        if (countLive == 3) {
            bloodBar.image = ImageUtil.LoadImage("images/player/bloodbar/bloodbar1.png");
        }
        if (countLive == 2) {
            bloodBar.image = ImageUtil.LoadImage("images/player/bloodbar/bloodbar2.png");
        }
        if (countLive == 1) {
            bloodBar.image = ImageUtil.LoadImage("images/player/bloodbar/bloodbar3.png");
        }
        if (countLive == 0) {
            this.Destroy();
        }
    }

    private void eatBlood() {
        AddBlood addBlood = GameObject.checkCollision(this.boxCollider,AddBlood.class);
        if (addBlood != null) {
            addBlood.isActive = false;
            if (this.countLive == 3) {
                this.countLive += 0;
            } else {
                this.countLive++;
            }
        }
    }

    public void Destroy(){
        SceneManager.changeScene(new GameOverScene());
    }
}
