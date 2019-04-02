package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


import java.util.ArrayList;


public class Alien {
    boolean derecha = true;
    private SpriteBatch batch;
    private Texture alien;
    private Sprite myAlien;
    private int alienx = 0, alieny = 350;

    ArrayList<Sprite> aliens2 = new ArrayList<Sprite>();
    ArrayList<Rectangle> recA = new ArrayList<Rectangle>();
    Rectangle recAlien;

//Crea los aliens utilizando un array
    void create() {

        for (int i = 0; i < 5; i++) {

            batch = new SpriteBatch();
            alien = new Texture("alien.png");
            myAlien = new Sprite(alien);
            myAlien.setSize(70, 70);
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

    public void moveArmyAlien() {
        float appGW = Gdx.app.getGraphics().getWidth();

        //Mueve todos los aliens a la derecha y baja sus Y
        for (int i = 0; i < aliens2.size(); i++) {
            float alienXW = aliens2.get(i).getX() + aliens2.get(i).getWidth();
            float px = aliens2.get(i).getX();
            float py = aliens2.get(i).getY();
            float wi = aliens2.get(i).getWidth();
            float he = aliens2.get(i).getHeight();
            recAlien = new Rectangle(px, py, wi, he);

            ShapeRenderer shapeRenderer;
            shapeRenderer = new ShapeRenderer();
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.rect(recAlien.getX(), recAlien.getY(), recAlien.getWidth(), recAlien.getHeight());
            shapeRenderer.end();

            if (derecha) {

                aliens2.get(i).translateX(-3f);

                if (px < 0) {
                    derecha = !derecha;
                    for (int j = 0; j < aliens2.size(); j++) {
                        aliens2.get(j).translateY(-20);
                    }
                }

                //Mueve todos los aliens a la izquierda y baja sus Y
            } else {
                aliens2.get(i).translateX(3f);

                if (alienXW > appGW) {
                    derecha = !derecha;
                    for (int j = 0; j < aliens2.size(); j++) {
                        aliens2.get(j).translateY(-20);
                    }
                }
            }
        }
    }

    void dispose() {
        batch.dispose();
        alien.dispose();
    }


}
