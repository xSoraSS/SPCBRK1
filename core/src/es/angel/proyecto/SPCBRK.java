package es.angel.proyecto;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SPCBRK extends ApplicationAdapter {
    SpriteBatch batch;

    Alien alien1 = new Alien();
    Player shipPlayer = new Player();
    Ball ballBullet = new Ball();


    @Override
    public void create () {
        shipPlayer.create();
        alien1.create();
        ballBullet.create();
    }


    @Override
    public void render () {

        Gdx.gl.glClearColor(0.5f,0.5f, 0.5f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //printa y permite mover la nave
        shipPlayer.printarNave();
        shipPlayer.moveNave();
        //printa y mueve los aliens de izquierda->derecha y de arriba->abajo
        alien1.printarAlien();
        alien1.moveArmyAlien();
        //Printa y mueve la pelota en varias direcciones
        ballBullet.printarBall();
        ballBullet.moveBall();
    }

    @Override
    public void dispose () {
        batch.dispose();
        shipPlayer.dispose();
        alien1.dispose();
        ballBullet.dispose();
    }
}