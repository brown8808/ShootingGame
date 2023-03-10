import javax.swing.*;
import java.awt.*;

public class Game extends Thread{
    private int delay = 20;
    private long pretime;
    private int cnt;

    private Image player = new ImageIcon("src/images/player.png").getImage();
    private int playerX, playerY;
    private int playerWidth = player.getWidth(null);
    private int playerHeight = player.getHeight(null);
    private int playerSpeed = 10;
    private int playerHp = 30;

    private boolean up, down, left, right;

    @Override
    public void run() {
        cnt = 0;
        playerX = 10;
        playerY = (Main.SCREEN_HEIGHT - playerHeight) / 2;

        while (true) {
            pretime = System.currentTimeMillis();
            if (System.currentTimeMillis() - pretime < delay) {
                try {
                    Thread.sleep(delay - System.currentTimeMillis() + pretime);
                    keyProcess();
                    cnt++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void keyProcess() {
        if (up && playerY - playerSpeed > 0) playerY -= playerSpeed;
        if (down && playerY - playerHeight + playerSpeed < Main.SCREEN_HEIGHT) playerY += playerSpeed;
        if (left && playerX - playerSpeed > 0) playerX -= playerSpeed;
        if (right && playerX - playerWidth + playerSpeed < Main.SCREEN_WIDTH) playerY += playerSpeed;
    }

    public void gameDraw(Graphics g) {
        g.drawImage(player, playerX, playerY, null);
    }

    public void playerDraw(Graphics g) {
        g.drawImage(player, playerX, playerY, null);
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
