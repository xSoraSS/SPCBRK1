package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private SpriteBatch batch;
    private Texture ship;
    public Sprite myShip;
    private float shipX = 270, shipY = 10;
    public Rectangle rectangle;

    public void create() {
        batch = new SpriteBatch();
        ship = new Texture("player.png");
        myShip = new Sprite(ship);
        myShip.setPosition(shipX, shipY);
        myShip.setSize(ship.getWidth(), ship.getHeight());
    }

    public void render() {
        batch.begin();
        myShip.draw(batch);
        batch.end();
    }

    public void update() {

        rectangle = new Rectangle(myShip.getX(), myShip.getY(), myShip.getWidth(), myShip.getHeight());
        if (Controls.isLeftPressed()){
            myShip.translateX(-3f);
            if (myShip.getX() < 0){
                myShip.setX(0);
            }
        }

        if (Controls.isRightPressed()){
            myShip.translateX(3f);
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