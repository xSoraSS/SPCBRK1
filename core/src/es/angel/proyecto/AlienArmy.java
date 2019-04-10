package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;


public class AlienArmy {
    boolean DEBUG = true;

    boolean derecha = true;
    private SpriteBatch batch;
    private Texture alien;
    private Sprite myAlien;
    private int alienx = 150, alieny = 350;

    ArrayList<Sprite> aliens = new ArrayList<Sprite>();

    ShapeRenderer shapeRenderer;

    void create() {
        shapeRenderer = new ShapeRenderer();

        alien = new Texture("alien.png");

        for (int i = 0; i < 4; i++) {
            batch = new SpriteBatch();
            myAlien = new Sprite(alien);
            myAlien.setSize(70, 70);
            myAlien.setPosition(alienx, alieny);

            aliens.add(myAlien);
            alienx += 100;
        }
    }

    void render() {
        batch.begin();
        for (int i = 0; i < aliens.size(); i++) {
            aliens.get(i).draw(batch);
        }
        batch.end();
    }

    public void update() {
        float appGW = Gdx.app.getGraphics().getWidth();

        //Mueve todos los aliens a la derecha y baja sus Y
        for (int i = 0; i < aliens.size(); i++) {

            Rectangle rectAlien = aliens.get(i).getBoundingRectangle();

            if(DEBUG) {
               shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
               shapeRenderer.rect(rectAlien.getX(), rectAlien.getY(), rectAlien.getWidth(), rectAlien.getHeight());
               shapeRenderer.end();
            }

//            if (derecha) {
//
//                aliens.get(i).translateX(-3f);
//
//                if (aliens.get(i).getX() < 0) {
//                    derecha = !derecha;
//                    for (int j = 0; j < aliens.size(); j++) {
//                        aliens.get(j).translateY(-20);
//                    }
//                }
//
//                //Mueve todos los aliens a la izquierda y baja sus Y
//            } else {
//                aliens.get(i).translateX(3f);
//
//                if (aliens.get(i).getX() + aliens.get(i).getWidth() > appGW) {
//                    derecha = !derecha;
//                    for (int j = 0; j < aliens.size(); j++) {
//                        aliens.get(j).translateY(-20);
//                    }
//                }
//            }
        }
    }

    void dispose() {
        batch.dispose();
        alien.dispose();
    }
}
