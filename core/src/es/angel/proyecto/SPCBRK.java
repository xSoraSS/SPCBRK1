package es.angel.proyecto;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SPCBRK extends ApplicationAdapter {
    SpriteBatch batch;

    Alien alien1 = new Alien();
    SpaceShip shipPlayer = new SpaceShip();


    @Override
    public void create () {
        shipPlayer.create();
        alien1.create();
    }


    @Override
    public void render () {

        Gdx.gl.glClearColor(0.5f,0.5f, 0.5f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shipPlayer.printarNave();
        alien1.printarAlien();
        shipPlayer.moveNave();
        alien1.moveAlien();
    }

    @Override
    public void dispose () {
        batch.dispose();
        shipPlayer.dispose();
        alien1.dispose();
    }
}