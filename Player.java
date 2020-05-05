package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player {
    int playerX = 310;
int playerlive = 1;
int playerY = 490;
Image playerImage;

    {
        try {
            playerImage = ImageIO.read(new File("src/com/company/ships_human.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playerdraw(Graphics2D g){
        g.drawImage(playerImage,playerX+3,playerY,null);
    }

}
