package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class Ball {
    boolean izquierda = true;
    boolean abajo = true;
    boolean isOverlaping;
    private SpriteBatch batch;
    private Texture ball;
    private Sprite pcBall;
    private float ballX, ballY;
    public Rectangle recBall;
    public Rectangle recPlayerB;
    public Player myPlayer = new Player();

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


    //ARREGLAR VALORES BALLX Y BALLY


    //Mueve la pelota
    public void moveBall(Rectangle recPlayer){
        recBall = new Rectangle(pcBall.getX(), pcBall.getY(), pcBall.getWidth(), pcBall.getHeight());
        //Mueve la pelota hacia la izquierda y la hace rebotar arriba y abajo
        if (izquierda){
            pcBall.translateX(-5);
            if (pcBall.getX() < 0){
                izquierda = !izquierda;
                pcBall.setX(0);
            }

            if (recBall.overlaps(recPlayer) && pcBall.getY() > 0){
                pcBall.translateY(ballY);
            }

            if (abajo){
                pcBall.translateY(-ballY);
                if (pcBall.getY() < 0){
                    abajo = !abajo;
                    pcBall.setY(0);
                }
            }else{
                pcBall.translateY(ballY);
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
