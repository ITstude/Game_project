package com.company;

import java.awt.*;

public class Shot {
    int shotX;
    int shotY;
    int shotdirY;

    public Shot(Alien an) {
        shotX = an.alienX;
        shotY = an.alienY;
        shotdirY = 4;
    }
    public Shot(Player p) {
        shotX = p.playerX + 32;
        shotY = p.playerY;
        shotdirY = -5;
    }
    public void drawshot(Graphics2D g) {
        g.setColor(Color.white);
        g.drawRect(shotX, shotY, 5, 20);
    }

    public void shotmove() {
        shotY += shotdirY;
    }


}