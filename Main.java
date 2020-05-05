package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame map = new JFrame();
        Gameplay game = new Gameplay();

        map.setBounds(10,10,700,600);
        map.setTitle("game");
        map.setResizable(false);
        map.add(game);
        map.setVisible(true);
        map.setDefaultCloseOperation(3);


    }
}
