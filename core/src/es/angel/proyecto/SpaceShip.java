package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceShip {
    private SpriteBatch batch;
    private Texture ship;
    private Sprite myShip;
    private float shipX = 270, shipY = 10;


    public void create() {
        batch = new SpriteBatch();
        ship = new Texture("player.png");
        myShip = new Sprite(ship);
        myShip.setPosition(shipX, shipY);
        myShip.setSize(ship.getWidth(), ship.getHeight());
    }

    public void printarNave() {
        batch.begin();
        myShip.draw(batch);
        batch.end();
    }

    public void moveNave() {
        boolean izquierda = Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A);
        boolean derecha = Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D);
        boolean mover = (izquierda != derecha);
        if(mover && izquierda){
            myShip.translateX(-1.5f);
            if (myShip.getX() < 0){
                myShip.setX(0);
            }
        }else if (mover && derecha){
            myShip.translateX(1.5f);
            if ((myShip.getX() + myShip.getWidth()) > Gdx.graphics.getWidth()){
                myShip.setX(Gdx.graphics.getWidth() - myShip.getWidth());
            }
        }
    }

        public void dispose () {
            batch.dispose();
            ship.dispose();
        }
    }