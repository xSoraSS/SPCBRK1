package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ball {
    boolean derecha = true;
    boolean abajo = true;
    boolean shooted = false;
    private SpriteBatch batch;
    private Texture ball;
    private Sprite pcBball;
    private float ballX = 270, ballY = 50;
    Player player = new Player();

    //Crea la pelota
    public void create() {
        batch = new SpriteBatch();
        ball = new Texture("ball.png");
        pcBball = new Sprite(ball);
        pcBball.setPosition(ballX, ballY);
        pcBball.setSize(ball.getWidth() - 32, ball.getHeight() - 32);
    }

    //Printa le pelota
    public void printarBall() {
        batch.begin();
        pcBball.draw(batch);
        batch.end();
    }

    //Mueve la pelota
    public void moveBall(){
        float ball = pcBball.getX() + pcBball.getWidth();
        float playerHX = player.myShip.getHeight() + player.myShip.getX();

        //Mueve la pelota hacia la izquierda y la hace rebotar arriba y abajo
        if (derecha){
            pcBball.translateX(-5);
            if (pcBball.getX() < 0){
                derecha = !derecha;
                pcBball.setX(0);
            }
//            if ()
            if (abajo){
                pcBball.translateY(-5);
                if (pcBball.getY() < 0){
                    abajo = !abajo;
                    pcBball.setY(0);
                }
            }else{
                pcBball.translateY(5);
                if (pcBball.getY() + pcBball.getHeight() > Gdx.graphics.getHeight()){
                abajo = !abajo;
                pcBball.setY(Gdx.graphics.getHeight() - pcBball.getHeight());
                }
            }

        //Mueve la pelota hacia la derecha y la hace rebotar arriba y abajo
        }else{
            pcBball.translateX(5);
            if ((pcBball.getX() + pcBball.getWidth()) > Gdx.graphics.getWidth()) {
                derecha = !derecha;
                pcBball.setX(Gdx.graphics.getWidth() - pcBball.getWidth());
            }
            if (abajo) {
                pcBball.translateY(-5);
                if (pcBball.getY() < 0) {
                    abajo = !abajo;
                    pcBball.setY(0);
                }
            } else {
                pcBball.translateY(5);
                if (pcBball.getY() + pcBball.getHeight() > Gdx.graphics.getHeight()) {
                    abajo = !abajo;
                    pcBball.setY(Gdx.graphics.getHeight() - pcBball.getHeight());
                }
            }
        }
    }

    public void dispose () {
        batch.dispose();
        ball.dispose();
    }
}
