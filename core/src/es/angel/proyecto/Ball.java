package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


import java.awt.*;
import java.util.ArrayList;

public class Ball {
    boolean izquierda = true;
    boolean abajo = true;
    private SpriteBatch batch;
    private Texture ball;
    private Sprite pcBall;
    private float ballX = 270, ballY = 50;
    public Rectangle recBall;


    //Crea la pelota
    public void create() {
        batch = new SpriteBatch();
        ball = new Texture("ball.png");
        pcBall = new Sprite(ball);
        pcBall.setPosition(ballX, ballY);
        pcBall.setSize(ball.getWidth() - 32, ball.getHeight() - 32);
    }

    //Printa le pelota
    public void printarBall() {
        batch.begin();
        pcBall.draw(batch);
        batch.end();
    }

    //Mueve la pelota
    public void moveBall(Rectangle recPlayer, ArrayList recA, Rectangle recAlien){
        recBall = new Rectangle(pcBall.getX(), pcBall.getY(), pcBall.getWidth(), pcBall.getHeight());

        ShapeRenderer shapeRenderer;
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(recBall.getX(), recBall.getY(), recBall.getWidth(), recBall.getHeight());
        shapeRenderer.end();

        //Mueve la pelota hacia la izquierda y la hace rebotar arriba y abajo
        if (izquierda){
            pcBall.translateX(-5);
            if (pcBall.getX() < 0){
                izquierda = !izquierda;
                pcBall.setX(0);
            }

            if (recBall.overlaps(recPlayer) && pcBall.getY() > 0){
                abajo = !abajo;
                pcBall.translateY(5);
            }


                if (recBall.overlaps(recAlien) && pcBall.getY() > 0){
                    abajo = !abajo;
                    pcBall.translateY(-50);

            }


            if (abajo){
                pcBall.translateY(-5);
                if (pcBall.getY() < 0){
                    abajo = !abajo;
                    pcBall.setY(0);
                }
            }else{
                pcBall.translateY(5);
                if (pcBall.getY() + pcBall.getHeight() > Gdx.graphics.getHeight()){
                abajo = !abajo;
                pcBall.setY(Gdx.graphics.getHeight() - pcBall.getHeight());
                }
            }

        //Mueve la pelota hacia la derecha y la hace rebotar arriba y abajo
        }else{
            pcBall.translateX(5);
            if ((pcBall.getX() + pcBall.getWidth()) > Gdx.graphics.getWidth()) {
                izquierda = !izquierda;
                pcBall.setX(Gdx.graphics.getWidth() - pcBall.getWidth());
            }

            if (recBall.overlaps(recPlayer) && pcBall.getY() > 0){
                abajo = !abajo;
                pcBall.translateY(-5);
            }


            if (recBall.overlaps(recPlayer)){
                pcBall.translateY(10);
            }

            if (abajo) {
                pcBall.translateY(-5);
                if (pcBall.getY() < 0) {
                    abajo = !abajo;
                    pcBall.setY(0);
                }
            } else {
                pcBall.translateY(5);
                if (pcBall.getY() + pcBall.getHeight() > Gdx.graphics.getHeight()) {
                    abajo = !abajo;
                    pcBall.setY(Gdx.graphics.getHeight() - pcBall.getHeight());
                }
            }
        }
    }

    public void dispose () {
        batch.dispose();
        ball.dispose();
    }
}
