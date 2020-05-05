package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class Alien {
int alienX;
int alienY;
int aliendirX = -5;
int aliendirY = -5;
int live=1;
//120 350
Image alienImage;

public Alien(int x, int y, int dirx,int diry){
    alienX=x;
    alienY=y;
    aliendirX = dirx;
    aliendirY = diry;

    try {
        alienImage = ImageIO.read(new File("src/com/company/ships_saucer.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

}
    public void draw(Graphics2D g){
        if(live > 0) {
          g.drawImage(alienImage, alienX,alienY,null);
            //  g.setColor(Color.blue)
           // g.fillRect(alienX, alienY, 30, 30);


        }
    }




    public void alienmove(){
        alienX += aliendirX;
       alienY += aliendirY;
        if(alienX<0)
            aliendirX= -aliendirX;
        if(alienY <0)
            aliendirY = -aliendirY;
        if(alienY >360)
            aliendirY = -aliendirY;
        if(alienX > 670)
            aliendirX = -aliendirX;
     if (live == 0){
      if(alienY<0){
          live =1;
      }}
       /* if(live == 0){
            new java.util.Timer().schedule(
                   new java.util.TimerTask() {
        @Override
                      public void run() {
                            live = 1;
                        }
                    },
                    5000
            );
            } */
        }
    }

