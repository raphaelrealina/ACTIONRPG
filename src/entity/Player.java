package entity;

import main.KeyHandler;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 500;
        y = 300;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            // add src/res
            down1 = ImageIO
                    .read(getClass().getResourceAsStream("/res/player/New Piskel-2.png.png"));
            down2 = ImageIO
                    .read(getClass().getResourceAsStream("/res/player/New Piskel-3.png.png"));
            left1 = ImageIO
                    .read(getClass().getResourceAsStream("/res/player/New Piskel-5.png.png"));
            left2 = ImageIO
                    .read(getClass().getResourceAsStream("/res/player/New Piskel-6.png.png"));
            right1 = ImageIO
                    .read(getClass().getResourceAsStream("/res/player/New Piskel-8.png.png"));
            right2 = ImageIO
                    .read(getClass().getResourceAsStream("/res/player/New Piskel-9.png.png"));
            up1 = ImageIO
                    .read(getClass().getResourceAsStream("/res/player/New Piskel-11.png.png"));
            up2 = ImageIO
                    .read(getClass().getResourceAsStream("/res/player/New Piskel-12.png.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
                || keyH.rightPressed == true) {
            if (keyH.upPressed) {
                direction = "up";
                y -= speed;
            }
            if (keyH.downPressed) {
                direction = "down";
                y += speed;
            }
            if (keyH.leftPressed) {
                direction = "left";
                x -= speed;
            }
            if (keyH.rightPressed) {
                direction = "right";
                x += speed;

            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1)
                    image = up1;
                else if (spriteNum == 2)
                    image = up2;
                break;
            case "down":
                if (spriteNum == 1)
                    image = down1;
                else if (spriteNum == 2)
                    image = down2;
                break;
            case "left":
                if (spriteNum == 1)
                    image = left1;
                else if (spriteNum == 2)
                    image = left2;
                break;
            case "right":
                if (spriteNum == 1)
                    image = right1;
                else if (spriteNum == 2)
                    image = right2;
                break;
        }

        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}