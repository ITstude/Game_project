package com.company;

import java.io.*;

public class High_score {
    int highscore;
    int playerscore;

Integer tojuz;
    public Integer readHigh() {
        Integer high ;
        try {

            FileReader reader = new FileReader("src/com/company/High");
            BufferedReader bufreader = new BufferedReader(reader);
            high =Integer.parseInt(bufreader.readLine()) ;
            tojuz = high;



bufreader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tojuz;
    }
public void saveHigh(char[]x){
    try {

     //   if(playerscore > highscore) {
            FileWriter fw = new FileWriter("src/com/company/High");
            BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(x);

        bfw.close();
       // }

    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
