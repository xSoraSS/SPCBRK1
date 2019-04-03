package es.angel.proyecto;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SPCBRK extends ApplicationAdapter {
    SpriteBatch batch;

    AlienArmy alienArmy;
    Player player;
    Ball ball;
    CheckCollisions checkCollisions;


    @Override
    public void create () {

        alienArmy = new AlienArmy();
        player = new Player();
        ball = new Ball();
        checkCollisions = new CheckCollisions();

        player.create();
        alienArmy.create();
        ball.create();
    }


    @Override
    public void render () {

        Gdx.gl.glClearColor(0.5f,0.5f, 0.5f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update();


        player.render();
        alienArmy.render();
        ball.render();
    }

    void update(){
        player.update();
        alienArmy.update();
        ball.update(player, alienArmy);
        checkCollisions.checkcollisionsBall(ball, player, alienArmy);

    }


    @Override
    public void dispose () {
        batch.dispose();
        player.dispose();
        alienArmy.dispose();
        ball.dispose();
    }
}