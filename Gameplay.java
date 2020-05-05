package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

   boolean play = false;
   int start = 0;
    Integer score = 0;
    int hjk = 0;
Integer highscore;
    High_score hg = new High_score();
   private Timer time;
   private int delay = 8;

Image background;
Shot amoal1;
Shot amoal2;
Alien an;
Alien an1;
Alien an2;
Shot amo;
Player p1;
Shot amopl;
   public Gameplay(){
       an = new Alien(120,350,-2,-2);
       try {
           background = ImageIO.read(new File("src/com/company/starfield2.png"));
       } catch (IOException e) {
           e.printStackTrace();
       }
       an1= new Alien(140,160,-3,-1);
       an2 = new Alien(120,300,-1,-3);
       amoal1 = new Shot(an1);
       amoal2 = new Shot(an2);
       amo = new Shot(an);
     p1 = new Player();
     amopl = new Shot(p1);

     addKeyListener(this);
       setFocusable(true);
       setFocusTraversalKeysEnabled(false);
       time = new Timer(delay,this);
       time.start();

       highscore = hg.readHigh();



   }

   public void paint(Graphics g){


    // background
g.drawImage(background,1,1,null);
      // g.setColor(Color.black);
       //g.fillRect(1,1,692,592);

       if (start == 0){

           g.setColor(Color.white);
           g.setFont(new Font("serif", Font.BOLD,30));
           g.drawString("Press Enter to start, the highscore is" +highscore, 120,300);}

       g.setColor(Color.white);
       g.setFont(new Font("serif", Font.BOLD,30));
       g.drawString("your score"+score + " highscore "+highscore, 50,50);
       //borders
       g.setColor(Color.black);
       g.fillRect(0,0,3,592);
       g.fillRect(0,0,692,3);
       g.fillRect(691,0,3,592);



       //the paddle
      // g.setColor(Color.green);
      // g.fillRect(p1.playerX,550,70,120);
p1.playerdraw((Graphics2D)g);
       //
       amoal1.drawshot((Graphics2D)g);
       amoal2.drawshot((Graphics2D)g);
       amo.drawshot((Graphics2D)g);
       an.draw((Graphics2D) g);
       an1.draw((Graphics2D) g);
       an2.draw((Graphics2D) g);
amopl.drawshot((Graphics2D)g);
       //ball
     //  g.setColor(Color.yellow);
       //g.fillRect(ballposX,ballposY,20,20);
       if(p1.playerlive <= 0){
           play = false;
           g.setColor(Color.white);
           g.setFont(new Font("serif", Font.BOLD,30));
           g.drawString("Game over your score is:"+score, 200,300);
           highscore= hg.readHigh();


       }
       g.dispose();
   }


   @Override
    public void actionPerformed(ActionEvent e) {

time.start();

       Rectangle shotal = new Rectangle(amo.shotX,amo.shotY,10,10);
       Rectangle shotal1 = new Rectangle(amoal1.shotX,amoal1.shotY,10,10);
       Rectangle shotal2 = new Rectangle(amoal2.shotX,amoal2.shotY,10,10);
       Rectangle rec0 = new Rectangle(an.alienX,an.alienY,30,30);
       Rectangle rec1 = new Rectangle(an1.alienX,an1.alienY,30,30);
       Rectangle rec2 = new Rectangle(an2.alienX,an2.alienY,30,30);
       Rectangle playerrec = new Rectangle(p1.playerX,p1.playerY,65,120);
       Rectangle shotrec0 = new Rectangle(amopl.shotX,amopl.shotY,10,10);

if(play){
  if(rec0.intersects(rec1) ){
    if (hjk == 0){

                    amo.shotX = an.alienX;
                    amo.shotY = an.alienY;
                    amoal1.shotX = an1.alienX;
                    amoal1.shotY = an1.alienY;
                    amoal2.shotX = an2.alienX;
                    amoal2.shotY = an2.alienY;
                    hjk = 1;

                }}
    if(rec0.intersects(rec1) ){
    if (hjk == 1){
        hjk = 0;}}

    an.alienmove();
   an1.alienmove();
   an2.alienmove();
    amoal1.shotmove();
    amoal2.shotmove();
   amo.shotmove();
amopl.shotmove();
if (shotal.intersects(playerrec)){
    p1.playerlive -= 1;
zapis();
}
    if (shotal1.intersects(playerrec)){
        p1.playerlive -= 1;
   zapis();
    }
    if (shotal2.intersects(playerrec)){
        p1.playerlive -= 1;
    zapis();
    }

if( shotrec0.intersects(rec0)){
    if(an.live == 1){
    an.live=0;
score = score + 10;}}
    if( shotrec0.intersects(rec1)){
        if(an1.live == 1){
        an1.live=0;
    score = score + 10;}}
    if( shotrec0.intersects(rec2)){
        if(an2.live == 1){
            an2.live=0;
    score = score + 10;}}
}
repaint();
    }


    @Override
    public void keyPressed(KeyEvent e) {

       if(e.getKeyCode() == KeyEvent.VK_RIGHT){
    if(p1.playerX >= 600){
        p1.playerX = 600;
    }else{
        moveRight();

    }
}
       if (e.getKeyCode() == KeyEvent.VK_ENTER){
           play = true;
           start = 1;
           score = 0;
           p1.playerlive = 1;
           p1.playerX = 310;
           amo.shotX = an.alienX;
           amo.shotY = an.alienY;
           amoal1.shotX = an1.alienX;
           amoal1.shotY = an1.alienY;
           amoal2.shotX = an2.alienX;
           amoal2.shotY = an2.alienY;
       }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(p1.playerX < 10){
                p1.playerX = 10;
            }else{
                moveLeft();

            }
        }
   if(e.getKeyCode() == KeyEvent.VK_SPACE){
amopl = new Shot(p1);

   }
   }
    public void moveRight(){

       p1.playerX += 10;
    }
    public void moveLeft(){

       p1.playerX -= 10;
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
public void zapis(){
    if (score > highscore){
        hg.saveHigh(score.toString().toCharArray());
    }




     /* if(score.toString().charAt(0)==highscore.charAt(0)){
       if(score.toString().charAt(1)>highscore.charAt(1)){
       hg.saveHigh(score.toString().toCharArray());}}
      else{
          if(score.toString().charAt(0)>highscore.charAt(0)){
          hg.saveHigh(score.toString().toCharArray());}}
    if(score.toString().charAt(0)<highscore.charAt(0)){
        if(score.toString().toCharArray().length > highscore.toCharArray().length)
            hg.saveHigh(score.toString().toCharArray());
    } */
}

}
