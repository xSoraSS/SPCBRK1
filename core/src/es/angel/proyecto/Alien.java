package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;


public class Alien {

     private SpriteBatch batch;
     private Texture alien;
     private Sprite myAlien;
     private int alienx = 70, alieny = 350;



    ArrayList<Sprite> aliens2= new ArrayList<Sprite>();


    void create(){

        for (int i = 0; i < 5; i++) {

            batch = new SpriteBatch();
            alien = new Texture("alien.png");
            myAlien = new Sprite(alien);
            myAlien.setSize(70,70);
            myAlien.setPosition(alienx, alieny);

            aliens2.add(myAlien);
            alienx += 100;
        }
    }

    void printarAlien() {
        for (int i = 0; i < aliens2.size(); i++) {
            batch.begin();
            aliens2.get(i).draw(batch);
            batch.end();
        }
    }

    public void moveAlien() {
        float alienXW = myAlien.getX() + myAlien.getWidth();
        float appGW = Gdx.app.getGraphics().getWidth();
        if (myAlien.getX() > 0) {
            myAlien.translateX(-1.5f);
        } else {
            while (myAlien.getX() < Gdx.graphics.getWidth()) {
                myAlien.setX(1.5f);
            }
        }
    }

//        myAlien.setX(1.5f);
//        if((myAlien.getX() + myAlien.getWidth()) > Gdx.app.getGraphics().getWidth()) {
//            myAlien.translateX(-1.5f);
//            if (myAlien.getX() < 0) {
//                myAlien.setX(0);
//            }
//        }
    //}

    void dispose () {
        batch.dispose();
        alien.dispose();
    }





}
