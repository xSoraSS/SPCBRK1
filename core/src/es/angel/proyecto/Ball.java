package es.angel.proyecto;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ball {
    private SpriteBatch batch;
    private Texture ball;
    private Sprite pcBball;
    private float ballX = 270, ballY = 50;

    public void create() {
        batch = new SpriteBatch();
        ball = new Texture("ball.png");
        pcBball = new Sprite(ball);
        pcBball.setPosition(ballX, ballY);
        pcBball.setSize(ball.getWidth() - 32, ball.getHeight() - 32);
    }

    public void printarBall() {
        batch.begin();
        pcBball.draw(batch);
        batch.end();
    }

    public void dispose () {
        batch.dispose();
        ball.dispose();
    }
}
