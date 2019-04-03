package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Ball {
    boolean izquierda = true;
    boolean abajo = true;
    public SpriteBatch batch;
    public Texture ball;
    public Sprite pcBall;
    public float ballX = 270, ballY = 50;
    public Rectangle rectBall;
    ShapeRenderer shapeRenderer;


    //Crea la pelota
    public void create() {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();

        ball = new Texture("ball.png");
        pcBall = new Sprite(ball);
        pcBall.setPosition(ballX, ballY);
        pcBall.setSize(ball.getWidth() - 32, ball.getHeight() - 32);
    }

    //Printa le pelota
    public void render() {
        batch.begin();
        pcBall.draw(batch);
        batch.end();
    }


    //Mueve la pelota
    public void update(Player player, AlienArmy alienArmy){
        rectBall = new Rectangle(pcBall.getX(), pcBall.getY(), pcBall.getWidth(), pcBall.getHeight());


        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(rectBall.getX(), rectBall.getY(), rectBall.getWidth(), rectBall.getHeight());
        shapeRenderer.end();

    }

    public void dispose () {
        batch.dispose();
        ball.dispose();
    }
}
